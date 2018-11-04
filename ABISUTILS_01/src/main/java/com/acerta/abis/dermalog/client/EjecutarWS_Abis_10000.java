package com.acerta.abis.dermalog.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.spec.ClientBuilderImpl;

import com.acerta.abis.dermalog.client.rest.BuscarBiometricosAbisRequestVo;
import com.acerta.abis.dermalog.client.rest.BuscarBiometricosAbisResponse;
import com.acerta.abis.dermalog.client.rest.InsertarNuevoAbisRequestVo;
import com.acerta.abis.dermalog.client.rest.InsertarNuevoAbisResponse;
import com.acerta.abis.dermalog.client.rest.QueryBiometrics;

import org.apache.cxf.jaxrs.client.WebClient;


public class EjecutarWS_Abis_10000 {
	
	private String baseUrl = "http://192.168.15.184:10000/v1/";
	

	private JAXRSClientFactoryBean jax;
	
	public EjecutarWS_Abis_10000( String baseUrl ) {
		super();
		this.baseUrl = baseUrl;
		 jax = new JAXRSClientFactoryBean();
		 jax.setAddress(baseUrl);
		
		
	}


	//    public static void wsPostDerma_Enrroll(QueryBiometrics biometrics, String nombre) throws IOException {
    public com.acerta.abis.dermalog.client.rest.InsertarNuevoAbisResponse insertarRegistro(InsertarNuevoAbisRequestVo request) throws IOException {
    	String path = "identity";

/*    	InsertarNuevoAbisRequestVo request = new InsertarNuevoAbisRequestVo()
			.setIdentityId(identityId)
			.setBiometrics(biometrics);*/
    	
    	WebClient client = jax.createWebClient().path(path);
    	Response r = client.accept(MediaType.APPLICATION_JSON)
    			.post(request); //TODO especificar tipo de retorno
    	
		switch (r.getStatus()) {
		case 200:
			System.out.println("Registro insertado Exitosamente");
			InsertarNuevoAbisResponse e = r.readEntity(com.acerta.abis.dermalog.client.rest.InsertarNuevoAbisResponse.class);
			return e;
		case 400:
			System.out.println("datos de peticion invalidos");
			throw new RuntimeException("datos de peticion invalidos");
		case 409:
			System.out.println("Identidad ya existente");
			throw new RuntimeException("datos de peticion invalidos");
		case 500:
			System.out.println("Error inesperado");
			throw new RuntimeException("Error inesperado");

		default:
			throw new RuntimeException("Error desconocido "+r.getStatus()+" "+r.getStatusInfo().getReasonPhrase());
		}
    	
    	/*
    	@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpClient client = HttpClientBuilder.create().build();
    	HttpPost post = new HttpPost(url);

    	StringEntity input = new StringEntity(json);
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
*/
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
    
    public com.acerta.abis.dermalog.client.rest.BuscarBiometricosAbisResponse buscarBiometicos(BuscarBiometricosAbisRequestVo request) throws Exception {
    	String path = "/biometric/search";
    	WebClient client = jax.createWebClient().path(path);
    	BuscarBiometricosAbisResponse r = client
    			.accept(MediaType.APPLICATION_JSON)
    			.post(request, com.acerta.abis.dermalog.client.rest.BuscarBiometricosAbisResponse.class); //TODO falta tipo de retorno

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
    
    public void eliminarRegistro(String curp) throws IOException {

    	String path = "identity/{curp}";
    	WebClient client = jax.createWebClient().path(path, curp);

/*    	AsyncInvoker asyncClient = client.accept(MediaType.APPLICATION_JSON).async();
    	asyncClient.
    	asyncClient.get();*/
    	
    	Response r = client.accept(MediaType.APPLICATION_JSON).get();
    	return ;
    	
 /*   	
    	
    	@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpClient client = HttpClientBuilder.create().build();
    	
    	HttpDelete delete = new HttpDelete(url);

		HttpResponse response = httpClient.execute(delete);
		System.out.println(response.getStatusLine().getStatusCode() + " -> ");
		
		switch (response.getStatusLine().getStatusCode()) {
		case 204:
			System.out.println("Registro eliminado Exitosamente");
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

		httpClient.getConnectionManager().shutdown();

	  }catch (MalformedURLException e) {

		e.printStackTrace();
	
	  } catch (IOException e) {

		e.printStackTrace();

	  }*/
    	
    }


    
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
    
}
