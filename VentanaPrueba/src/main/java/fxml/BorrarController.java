package fxml;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acerta.abis.dermalog.client.AbisException;
import com.acerta.abis.dermalog.client.EjecutarWS_Abis_10000;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

@Component
public class BorrarController implements Initializable {

	
	@FXML private TextField IdTextField;
	@FXML private Button submitBtn;
	
	@Autowired private EjecutarWS_Abis_10000 api;

	@Autowired private StringProperty statusProperty;
	@Autowired private DoubleProperty progressProperty;
	
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	
    
    }

    @FXML private void handleBorrarAction(){

    	Task<Void> task = new Task<Void>() {
    	    @Override public Void call() throws AbisException, IOException {
    	    updateProgress(-1, 0);
    	    updateMessage("Borrando...");
			String id = IdTextField.getText();
			api.eliminarRegistro(id);
			System.out.println("Borrar");
			
			return null;
    	    }
    	    @Override
    	    protected void succeeded() {
    	    	updateMessage("");
    			updateProgress(0,0);
    	    	Alert alert = new Alert(AlertType.INFORMATION);
    	    	alert.setTitle("Registro borrado");
    	    	alert.setHeaderText("Registro borrado");
    	    	alert.setContentText("Registro borrado");
    	    	alert.showAndWait();
    	    }
    	    @Override
    	    protected void failed() {
    	    	super.failed();
    	    	Throwable e = getException();
    			e.printStackTrace();
    			updateMessage("");
    			updateProgress(0,0);
    			ErrorMessage.exceptionDialog("Error al Borrar",e);
    	    }
    	};
    	progressProperty.bind(task.progressProperty());
    	statusProperty.bind(task.messageProperty());
		new Thread(task).start();
		
    }
    
	
}
