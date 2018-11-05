package com.acerta.abis.dermalog.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.ServiceMode;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.spec.ClientBuilderImpl;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.acerta.abis.dermalog.client.rest.QueryBiometrics;
import com.acerta.abis.dermalog.client.rest.request.AbisVoBuscarBiometricosRequest;
import com.acerta.abis.dermalog.client.rest.request.AbisVoInsertarNuevoRequest;
import com.acerta.abis.dermalog.client.rest.response.AbisVoBuscarBiometricosResponse;
import com.acerta.abis.dermalog.client.rest.response.AbisVoInsertarNuevoResponse;

import org.apache.cxf.jaxrs.client.WebClient;

@Service
public class EjecutarWS_Abis_10000 {
	
	@Value("${abis.baseUrl}") private String baseUrl = "http://192.168.15.184:10000/v1/";
	

	 private JAXRSClientFactoryBean jax;
	
	public EjecutarWS_Abis_10000( ) {
		super();
//		this.baseUrl = baseUrl;
		
		jax = new JAXRSClientFactoryBean();
		jax.setAddress(baseUrl);
		
	}

	//    public static void wsPostDerma_Enrroll(QueryBiometrics biometrics, String nombre) throws IOException {
    public com.acerta.abis.dermalog.client.rest.response.AbisVoInsertarNuevoResponse insertarRegistro(AbisVoInsertarNuevoRequest request) throws IOException {
    	String path = "identity";

//    	InsertarNuevoAbisRequestVo request = new InsertarNuevoAbisRequestVo()
//			.setIdentityId(identityId)
//			.setBiometrics(biometrics);
    	
//    	WebClient client = jax.createWebClient().path(path);
//    	Response r = client.accept(MediaType.APPLICATION_JSON)
//    			.post(request); //TODO especificar tipo de retorno
//    	
//		switch (r.getStatus()) {
//		case 200:
//			System.out.println("Registro insertado Exitosamente");
//			AbisVoInsertarNuevoResponse e = r.readEntity(com.acerta.abis.dermalog.client.rest.response.AbisVoInsertarNuevoResponse.class);
//			return e;
//		case 400:
//			System.out.println("datos de peticion invalidos");
//			throw new RuntimeException("datos de peticion invalidos");
//		case 409:
//			System.out.println("Identidad ya existente");
//			throw new RuntimeException("datos de peticion invalidos");
//		case 500:
//			System.out.println("Error inesperado");
//			throw new RuntimeException("Error inesperado");
//
//		default:
//			throw new RuntimeException("Error desconocido "+r.getStatus()+" "+r.getStatusInfo().getReasonPhrase());
//		}
    	
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(request);
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
    	
    	@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpClient client = HttpClientBuilder.create().build();
    	HttpPost   post   = new HttpPost(path);

    	StringEntity input = new StringEntity(jsonInString);
		input.setContentType("application/json");
		post.setEntity(input);

		HttpResponse response = httpClient.execute(post);

		System.out.println(response.getStatusLine().getStatusCode() + " -> ");
		
		switch (response.getStatusLine().getStatusCode()) {
		case 200:
			System.out.println("Registro insertado Exitosamente");
			break;
		case 400:
			System.out.println("datos de peticion invalidos");
			break;
		case 409:
			System.out.println("Identidad ya existente");
			break;
		case 500:
			System.out.println("Error inesperado");
			break;

		default:
			break;
		}

		BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		httpClient.getConnectionManager().shutdown();
		AbisVoInsertarNuevoResponse insertarResponse = new AbisVoInsertarNuevoResponse();
				insertarResponse.setIdentityId("aqui va a ir el id");
		return insertarResponse;

    }
    
    
    public Response leerRegistro(String identityId) throws Exception {
    	String path = "identity/{identityId}";
    	WebClient client = jax.createWebClient().path(path, identityId);
    	Response r = client.accept(MediaType.APPLICATION_JSON)
    			.get();


    	switch (r.getStatus()) {
    	case 200:
    		System.out.println("Registro encontrado");
    		break;
    	case 400:
    		System.out.println("datos de peticion invalidos");
    		break;
    	case 404:
    		System.out.println("Identidad no encontrada");
    		break;
    	case 500:
    		System.out.println("Error inesperado");
    		break;

    	default:
    		break;
    	}
    	return r;
    }
    
    public com.acerta.abis.dermalog.client.rest.response.AbisVoBuscarBiometricosResponse buscarBiometicos(AbisVoBuscarBiometricosRequest request) throws Exception {
    	String path = "/biometric/search";
    	WebClient client = jax.createWebClient().path(path);
    	AbisVoBuscarBiometricosResponse r = client
    			.accept(MediaType.APPLICATION_JSON)
    			.post(request, com.acerta.abis.dermalog.client.rest.response.AbisVoBuscarBiometricosResponse.class); //TODO falta tipo de retorno

    	return r;
/*    	
    	@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpClient client = HttpClientBuilder.create().build();
    	HttpGet get = new HttpGet(url);

		HttpResponse response = httpClient.execute(get);
			
			System.out.println(response.getStatusLine().getStatusCode() + " -> ");
			
			switch (response.getStatusLine().getStatusCode()) {
			case 200:
				System.out.println("Registro encontrado");
				break;
			case 400:
				System.out.println("datos de peticion invalidos");
				break;
			case 404:
				System.out.println("Identidad no encontrada");
				break;
			case 500:
				System.out.println("Error inesperado");
				break;

			default:
				break;
			}

			IOUtils.copy(response.getEntity().getContent(), System.out);*/
    }
    
    public void eliminarRegistro(String id) throws IOException, AbisException {

    	String path = "identity/{id}";
    	
    	WebClient client = jax.createWebClient().path(path, id);
    	Response response = client
    			.accept(MediaType.APPLICATION_JSON)
    			.delete();
    	int status = response.getStatus();
//    	return ;
  	
/*    	
    	@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpClient client = HttpClientBuilder.create().build();
    	
    	HttpDelete delete = new HttpDelete(path);

		HttpResponse response = httpClient.execute(delete);
		System.out.println(response.getStatusLine().getStatusCode() + " -> ");
*/		
		switch (response.getStatus()) { //FIXME retornar estos codigos de alguna forma
		case 204:
			System.out.println("Registro eliminado Exitosamente");
			break;
		case 400:
			throw new InvalidDataAbisException("datos de peticion invalidos");
		case 404:
			throw new IdentityNotFoundAbisException("Identidad no encontrada");
		case 500:
			throw new UnexpectedErrorAbisException("Error inesperado");

		}

//		if (response.getStatusLine().getStatusCode() != 201) {
//			throw new RuntimeException("Failed : HTTP error code : "
//				+ response.getStatusLine().getStatusCode());
//		}

//		BufferedReader br = new BufferedReader(
//                        new InputStreamReader((response.getEntity().getContent())));
//
//		String output;
//		System.out.println("Output from Server .... \n");
//		while ((output = br.readLine()) != null) {
			
//		}

//		httpClient.getConnectionManager().shutdown();
    }
    
    
}
