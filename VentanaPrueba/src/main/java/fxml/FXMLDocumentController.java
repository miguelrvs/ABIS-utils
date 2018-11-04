/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;

/**
 *
 * @author Acerta
 */
public class FXMLDocumentController implements Initializable {
    
//    @FXML
//    private Label label;
	
	@FXML private HBox hbInsertarId;
	@FXML private HBox hbBuscarId;
	@FXML private HBox hbIdentificarId;
	@FXML private HBox hbValidarId;
	@FXML private HBox hbBorrarId;
	@FXML private HBox hbFotoId;
	@FXML private HBox hbHuellaId;
	@FXML private HBox hbCURPId;
	
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
//        label.setText("Hello World!");
    }
    
    @FXML
    private void handleInsertarAction(ActionEvent event) 
    {
    	try {
    		hbInsertarId.setStyle("-fx-background-color: teal");
	    	hbBuscarId.setStyle("-fx-background-color: LIGHTGREY");
	    	hbIdentificarId.setStyle("-fx-background-color: LIGHTGREY");
	    	hbValidarId.setStyle("-fx-background-color: LIGHTGREY");
	    	hbBorrarId.setStyle("-fx-background-color: LIGHTGREY");
	    	
	    	hbFotoId.setVisible(true);
	    	hbHuellaId.setVisible(true);
	    	hbCURPId.setVisible(true);
	    	
			
		} catch (Exception e) {
			e.getMessage();// TODO: handle exception
		}
    }
    
    @FXML
    private void handleBuscararAction(ActionEvent event) 
    {
		hbInsertarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBuscarId.setStyle("-fx-background-color: teal");
    	hbIdentificarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbValidarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBorrarId.setStyle("-fx-background-color: LIGHTGREY");
    	
    	hbFotoId.setVisible(false);
    	hbHuellaId.setVisible(false);
    	hbCURPId.setVisible(true);
    }
    
    @FXML
    private void handleIdentificarAction(ActionEvent event) 
    {
		hbInsertarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBuscarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbIdentificarId.setStyle("-fx-background-color: teal");
    	hbValidarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBorrarId.setStyle("-fx-background-color: LIGHTGREY");
    	
    	hbFotoId.setVisible(true);
    	hbHuellaId.setVisible(true);
    	hbCURPId.setVisible(false);
    }
    
    @FXML
    private void handleValidarAction(ActionEvent event) 
    {
		hbInsertarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBuscarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbIdentificarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbValidarId.setStyle("-fx-background-color: teal");
    	hbBorrarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbFotoId.setVisible(true);
    	hbHuellaId.setVisible(true);
    	hbCURPId.setVisible(true);
    }
    
    @FXML
    private void handleBorrarAction(ActionEvent event) 
    {
		hbInsertarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBuscarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbIdentificarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbValidarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBorrarId.setStyle("-fx-background-color: teal");
    	hbFotoId.setVisible(false);
    	hbHuellaId.setVisible(false);
    	hbCURPId.setVisible(true);
    }
    
    @FXML
    private void handlefotoEventAction(ActionEvent event)
    {
    	System.out.println("Foto");
    }
    
    @FXML
    private void handleHuellaEventAction(ActionEvent event)
    {
    	System.out.println("Huella");
    }
    
    @FXML
    private void handleCURPEventAction(ActionEvent event)
    {
    	System.out.println("CURP");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
