import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.standard.Finishings;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.acerta.abis.dermalog.client.EjecutarWS_Abis_10000;
import com.acerta.abis.dermalog.client.rest.Faces;
import com.acerta.abis.dermalog.client.rest.Fingerprint;
import com.acerta.abis.dermalog.client.rest.Image;
import com.acerta.abis.dermalog.client.rest.QueryBiometrics;
import com.acerta.abis.dermalog.client.rest.request.AbisVoBorrarCURPRequest;
import com.acerta.abis.dermalog.client.rest.request.AbisVoBuscarBiometricosRequest;
import com.acerta.abis.dermalog.client.rest.request.AbisVoInsertarNuevoRequest;
import com.acerta.abis.dermalog.client.rest.response.AbisVoBuscarBiometricosResponse;


public class RecorrerArbol {
	
	static String nombre ="";
    
	private static AbisVoInsertarNuevoRequest insertarNuevoAbisRequestVo = new AbisVoInsertarNuevoRequest();
	private static QueryBiometrics biometrics = new QueryBiometrics(); 
	private static Faces rostro = null;
	private static String id ="";
    public static void main(String[] args) {
    	
    	String opcion = "borrar";
    	String curp = "RegistroPruebaInsertMASV821015";
    	
    	switch (opcion) {
		case "insertar":
			walkin(new File("C:\\dev\\ABIS\\Busqueda")); 
			
	        insertarNuevoAbisRequestVo.setBiometrics(biometrics);
	        insertarNuevoAbisRequestVo.setIdentityId(id);
	        ObjectMapper mapper = new ObjectMapper();

			try {
				//Convert object to JSON string and save into file directly 
//				mapper.writeValue(new File("C:\\dev\\ABIS\\MASV821010HMCLLN00\\biometrics.json"), insertarNuevoAbisRequestVo);
				
				//Convert object to JSON string
//				String jsonInString = mapper.writeValueAsString(insertarNuevoAbisRequestVo);
//				System.out.println(jsonInString);
				
				//Convert object to JSON string and pretty print
//				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(insertarNuevoAbisRequestVo);
				try {
				new EjecutarWS_Abis_10000().insertarRegistro(insertarNuevoAbisRequestVo);
				} catch (Exception e) {
					e.printStackTrace();
				}
//				System.out.println(jsonInString);
				
				
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			break;

		case "borrar":
			try {
				AbisVoBorrarCURPRequest borrarRequest = new AbisVoBorrarCURPRequest();
				borrarRequest.setIdentityId(curp);
				new EjecutarWS_Abis_10000()
					.eliminarRegistro(curp);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			break;
			
		case "leer_ID":
			try {
				new EjecutarWS_Abis_10000().leerRegistro(curp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			break;
			
		case "Buscar_BioMetricos":
			try {	
				AbisVoBuscarBiometricosRequest buscarRequest   = new AbisVoBuscarBiometricosRequest();
				AbisVoBuscarBiometricosResponse buscarResponse = new AbisVoBuscarBiometricosResponse();
//				walkin(new File("C:\\dev\\ABIS\\Busqueda")); 
				buscarResponse = new EjecutarWS_Abis_10000().buscarBiometicos(buscarRequest);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
    	
    	
    }
 
    public static void walkin(File dir) {
 
    	FileUtils leer = new FileUtils();
        File listFile[] = dir.listFiles();
        if (listFile != null) 
        {
            for (int i = 0; i < listFile.length; i++) 
            {
                if (listFile[i].isDirectory()) 
                {
                    walkin(listFile[i]);
                } 
                else 
                {
                	if(listFile[i].getName().equals("DATOS.txt")) 
                		id= leer.ObtenerNombre(listFile[i].getParentFile().toString()+"\\DATOS.txt");
                	
                	if(listFile[i].getName().equals("foto.jpg"))
                	{
                		try {
							if(rostro == null) 
								rostro = new Faces();
							Image image = new Image();
							image.setType("JPG");
//                		image.setData(encodeFileToBase64Binary(listFile[i]));
							image.setData(IOUtils.toByteArray(new FileInputStream(listFile[i])));
							rostro.setImage(image);
							biometrics.getFaces().add(rostro);
//                		System.out.println(listFile[i].getPath());
							;
						} catch (IOException e) {
							e.printStackTrace();
						}
                		
                	}
                	if(listFile[i].getName().contains(".wsq"))
                	{
                		
                		try {
							Fingerprint huella = new Fingerprint();
							Image imagen = new Image();
							imagen.setType("WSQ");
//                		imagen.setData(encodeFileToBase64Binary(listFile[i]));
							imagen.setData(IOUtils.toByteArray(new FileInputStream(listFile[i])));
							huella.setImage(imagen);
							huella.setFingerPosition(Integer.valueOf(listFile[i].getName().substring(1, 3)));
							biometrics.getFingerprints().add(huella);
						} catch (NumberFormatException | IOException e) {
							e.printStackTrace();
						}
                	}
                		
                }
            }
        }

    }
/*    
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
*/
    
}
