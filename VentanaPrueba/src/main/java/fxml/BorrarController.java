package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.acerta.abis.dermalog.client.EjecutarWS_Abis_10000;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BorrarController implements Initializable {

	
	@FXML private TextField IdTextField;
	@FXML private Button submitBtn;
	
	 private EjecutarWS_Abis_10000 api;
	
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	
    
    }

    @FXML private void handleBorrarAction(){
    	try {
			String id = IdTextField.getText();
			api.eliminarRegistro(id);
			System.out.println("Borrar");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public void setApi(EjecutarWS_Abis_10000 api) {
		this.api = api;
	}
	
}
