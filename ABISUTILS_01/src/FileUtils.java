

import java.io.BufferedReader;

/*Clase que permite escribir en un archivo de texto*/

//Importamos clases que se usaran
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	
//	static String ruta_Registro_Actual = "C:\\dev\\ARH\\Registro_Actual.txt";
//	static String ruta_ID_Actual = "C:\\dev\\ARH\\ID_Actual.txt";
	static BufferedReader 	  br = null;
	static FileReader fr = null;
	static FileWriter fw = null;
	


	
	public String ObtenerNombre(String ruta_Actual)
	{
		String nombre = "";
	    try 
	    {
	    	fr = new FileReader(ruta_Actual);
	        br = new BufferedReader(fr);
	        nombre = br.readLine();
	    }
	    catch (Exception e) 
	    {
	    	System.out.println(e.getMessage());
			// TODO: handle exception
		}
	    finally 
	    {
	    	try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nombre;
	}
}