
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

public class EjecutarWS_Abis_8080 {
	static String url_String = "http://192.168.15.184:8080/v1/encode/face";

    public static void wsPostDerma_Enrroll(String fotoBase64, String nombre) throws IOException {

    	  try {

    			URL url = new URL(url_String);
    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    			conn.setDoOutput(true);
    			conn.setRequestMethod("POST");
    			conn.setRequestProperty("Content-Type", "application/json");
            
    			
    			
//	    		String input = "{\"sImage\": \""+fotoBase64+"\"," + 
//	    							"\"sUserData\": \"dato\"," + 
//	    							"\"sUserName\": \""+nombre+"\"," +  
//	    							"\"bEnrichExistingUserTemplates\": false," + 
//	    							"\"bForceEnrolNewUser\": true," + 
//	    							"\"bIgnoreZipDB\": false}";
    			
    			String input = "{\"image\": {" +
    				    			"\"data\" : \""+fotoBase64+"\"," +
    				    			"\"type\" : \"JPG\"}" +
    				 			"}";
    		
    		OutputStream os = conn.getOutputStream();
    		os.write(input.getBytes());
    		os.flush();
    		
    		System.out.println(conn.getResponseCode());
//    		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//    			throw new RuntimeException("Failed : HTTP error code : "
//    				+ conn.getResponseCode());
//    		}

    		BufferedReader br = new BufferedReader(new InputStreamReader(
    				(conn.getInputStream())));

    		String output;
    		System.out.println("Output from Server .... \n");
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    		}

    		conn.disconnect();

    	  } catch (MalformedURLException e) {

    		e.printStackTrace();

    	  } catch (IOException e) {

    		e.printStackTrace();

    	 }

            
//            request.setEntity(new StringEntity("My test data"));
//
//            HttpResponse response = client.execute(request);
//
//            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
//                    response.getEntity().getContent()));
//
//            StringBuilder builder = new StringBuilder();
//
//            String line;
//
//            while ((line = bufReader.readLine()) != null) {
//                builder.append(line);
//                builder.append(System.lineSeparator());
//            }
//
//            System.out.println(builder);
//        }
    }
    
    
    public static String codificar_Rostro(String fotoBase64) throws IOException
    {
    	String respuesta ="";
    	
		URL url = new URL(url_String);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
    	
		String input = "{\"image\": {" +
    			"\"data\" : \""+fotoBase64+"\"," +
    			"\"type\" : \"JPG\"}" +
    			"}";
		
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		System.out.println(conn.getResponseCode());
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) 
		{
			System.out.println(output);
		}
		
		conn.disconnect();
    	
    	
		return respuesta;
    	
    }
    
    
    private static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println(encodedfile.substring(1000, 1050));
        return encodedfile;
    }
    
    
}