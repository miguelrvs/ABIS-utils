
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import VariableObjects.QueryBiometrics;

public class EjecutarWS_Abis_10000 {

//    public static void wsPostDerma_Enrroll(QueryBiometrics biometrics, String nombre) throws IOException {
    public static void abis_InsertarRegistro(String json) throws IOException {
    	try
    	{
    	String url = "http://192.168.15.184:10000/v1/identity";

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
	  }catch (MalformedURLException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}
    
    
    public static void abis_LeerRegistro(String registro) throws Exception {
    	BufferedReader rd = null;
    	try
    	{
    	String url = "http://192.168.15.184:10000/v1/identity/"+registro;

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

			IOUtils.copy(response.getEntity().getContent(), System.out);
			

    	}
    	finally {
		}
    }
    
    public static void abis_BuscarBiometicos(String json) throws Exception {
    	BufferedReader rd = null;
    	try
    	{
    	String url = "http://192.168.15.184:10000/v1/identity";

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

			IOUtils.copy(response.getEntity().getContent(), System.out);
    	}
    	finally {
		}
    }
    
    public static void abis_EliminarRegistro(String curp) throws IOException 
    {
    	try
    	{
    	String url = "http://192.168.15.184:10000/v1/identity/"+curp;

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

	  }
    	
    }
    
    
    
}