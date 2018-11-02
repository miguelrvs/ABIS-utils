import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;

public class EjecutarWS_Abis_8080
{
  static String url_String = "http://192.168.15.184:8080/v1/encode/face";
  
  public static void wsPostDerma_Enrroll(String fotoBase64, String nombre)
    throws IOException
  {
    try
    {
      URL url = new URL(url_String);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Content-Type", "application/json");
      
      String input = "{\"image\": {\"data\" : \"" + 
        fotoBase64 + "\"," + 
        "\"type\" : \"JPG\"}" + 
        "}";
      
      OutputStream os = conn.getOutputStream();
      os.write(input.getBytes());
      os.flush();
      
      System.out.println(conn.getResponseCode());
      
      BufferedReader br = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
      
      System.out.println("Output from Server .... \n");
      String output;
      while ((output = br.readLine()) != null)
      {
        String output;
        System.out.println(output);
      }
      conn.disconnect();
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public static String codificar_Rostro(String fotoBase64)
    throws IOException
  {
    String respuesta = "";
    
    URL url = new URL(url_String);
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/json");
    
    String input = "{\"image\": {\"data\" : \"" + 
      fotoBase64 + "\"," + 
      "\"type\" : \"JPG\"}" + 
      "}";
    
    OutputStream os = conn.getOutputStream();
    os.write(input.getBytes());
    os.flush();
    
    System.out.println(conn.getResponseCode());
    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    
    System.out.println("Output from Server .... \n");
    String output;
    while ((output = br.readLine()) != null)
    {
      String output;
      System.out.println(output);
    }
    conn.disconnect();
    
    return respuesta;
  }
  
  private static String encodeFileToBase64Binary(File file)
  {
    String encodedfile = null;
    try
    {
      FileInputStream fileInputStreamReader = new FileInputStream(file);
      byte[] bytes = new byte[(int)file.length()];
      fileInputStreamReader.read(bytes);
      encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return encodedfile;
  }
}
