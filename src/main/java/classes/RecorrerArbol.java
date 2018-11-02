import VariableObjects.Faces;
import VariableObjects.Fingerprint;
import VariableObjects.Image;
import VariableObjects.InsertarNuevoAbisRequestVo;
import VariableObjects.QueryBiometrics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class RecorrerArbol
{
  static String nombre = "";
  private static InsertarNuevoAbisRequestVo insertarNuevoAbisRequestVo = new InsertarNuevoAbisRequestVo();
  private static QueryBiometrics biometrics = new QueryBiometrics();
  private static Faces rostro = null;
  private static String id = "";
  
  public static void main(String[] args)
  {
    String opcion = "leer";
    String curp = "RegistroPruebaInsertMASV821012";
    String str1;
    switch ((str1 = opcion).hashCode())
    {
    case -1383290818: 
      if (str1.equals("borrar")) {
        break;
      }
      break;
    case 54459412: 
      if (str1.equals("leer_ID")) {}
      break;
    case 245990993: 
      if (str1.equals("Buscar_BioMetricos")) {}
    case 541787306: 
      if ((goto 335) && (str1.equals("insertar")))
      {
        walkin(new File("C:\\dev\\ABIS\\Busqueda"));
        
        insertarNuevoAbisRequestVo.setBiometrics(biometrics);
        insertarNuevoAbisRequestVo.setIdentityId(id);
        ObjectMapper mapper = new ObjectMapper();
        try
        {
          mapper.writeValue(new File("C:\\dev\\ABIS\\MASV821010HMCLLN00\\biometrics.json"), insertarNuevoAbisRequestVo);
          
          String jsonInString = mapper.writeValueAsString(insertarNuevoAbisRequestVo);
          
          jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(insertarNuevoAbisRequestVo);
          try
          {
            EjecutarWS_Abis_10000.abis_InsertarRegistro(jsonInString);
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          System.out.println(jsonInString);
        }
        catch (JsonGenerationException e)
        {
          e.printStackTrace();
        }
        catch (JsonMappingException e)
        {
          e.printStackTrace();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        try
        {
          EjecutarWS_Abis_10000.abis_EliminarRegistro(curp);
        }
        catch (IOException e)
        {
          System.err.println(e.getMessage());
          e.printStackTrace();
        }
        try
        {
          EjecutarWS_Abis_10000.abis_LeerRegistro(curp);
        }
        catch (Exception e)
        {
          System.err.println(e.getMessage());
          e.printStackTrace();
        }
        try
        {
          walkin(new File("C:\\dev\\ABIS\\Busqueda"));
          EjecutarWS_Abis_10000.abis_BuscarBiometicos(curp);
        }
        catch (Exception e)
        {
          System.err.println(e.getMessage());
          e.printStackTrace();
        }
      }
      break;
    }
  }
  
  public static void walkin(File dir)
  {
    FileUtils leer = new FileUtils();
    File[] listFile = dir.listFiles();
    if (listFile != null) {
      for (int i = 0; i < listFile.length; i++) {
        if (listFile[i].isDirectory())
        {
          walkin(listFile[i]);
        }
        else
        {
          if (listFile[i].getName().equals("DATOS.txt")) {
            id = leer.ObtenerNombre(listFile[i].getParentFile().toString() + "\\DATOS.txt");
          }
          if (listFile[i].getName().equals("foto.jpg"))
          {
            if (rostro == null) {
              rostro = new Faces();
            }
            Image image = new Image();
            image.setType("JPG");
            image.setData(encodeFileToBase64Binary(listFile[i]));
            
            rostro.setImage(image);
            biometrics.getFaces().add(rostro);
          }
          if (listFile[i].getName().contains(".wsq"))
          {
            Fingerprint huella = new Fingerprint();
            Image imagen = new Image();
            imagen.setType("WSQ");
            imagen.setData(encodeFileToBase64Binary(listFile[i]));
            huella.setImage(imagen);
            huella.setFingerPosition(Integer.valueOf(listFile[i].getName().substring(1, 3)).intValue());
            biometrics.getFingerprints().add(huella);
          }
        }
      }
    }
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
