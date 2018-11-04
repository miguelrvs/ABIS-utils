/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.acerta.abis.dermalog.client.EjecutarWS_Abis_10000;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author Acerta
 */
public class FXMLDocumentController implements Initializable {
    
//    @FXML
//    private Label label;
	
	private EjecutarWS_Abis_10000 api;
	
	@FXML private HBox hbInsertarId;
	@FXML private HBox hbBuscarId;
	@FXML private HBox hbIdentificarId;
	@FXML private HBox hbValidarId;
	@FXML private HBox hbBorrarId;
//	@FXML private HBox hbFotoId;
//	@FXML private HBox hbHuellaId;
//	@FXML private HBox hbCURPId;
	
	@FXML private VBox innerContainer;
	
	
	public FXMLDocumentController(){
/*		
		final JavaFXBuilderFactory bf = new JavaFXBuilderFactory();
    	final Callback<Class<?>, Object> cb = (clazz) -> IndividualAuthClientFx.getBean(clazz);
    	
 	stepsUri.stream().forEach(uri->{
    		try {
				Parent root = FXMLLoader.load(getClass().getResource(uri), null, bf, cb ); 
				steps.add(root);
			} catch (Exception e) {
				log.error("Error al generar step: "+e,e);
			}
    	});*/
		
	}
	
    
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
	    	
/*	    	hbFotoId.setVisible(true);
	    	hbHuellaId.setVisible(true);
	    	hbCURPId.setVisible(true);*/
	    	
	    	
			
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
    	
/*    	hbFotoId.setVisible(false);
    	hbHuellaId.setVisible(false);
    	hbCURPId.setVisible(true);*/
    }
    
    @FXML
    private void handleIdentificarAction(ActionEvent event) 
    {
		hbInsertarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBuscarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbIdentificarId.setStyle("-fx-background-color: teal");
    	hbValidarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBorrarId.setStyle("-fx-background-color: LIGHTGREY");
    	
/*    	hbFotoId.setVisible(true);
    	hbHuellaId.setVisible(true);
    	hbCURPId.setVisible(false);*/
    }
    
    @FXML
    private void handleValidarAction(ActionEvent event) 
    {
		hbInsertarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBuscarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbIdentificarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbValidarId.setStyle("-fx-background-color: teal");
    	hbBorrarId.setStyle("-fx-background-color: LIGHTGREY");
/*    	hbFotoId.setVisible(true);
    	hbHuellaId.setVisible(true);
    	hbCURPId.setVisible(true);*/
    }
    
    @FXML
    private void handleBorrarAction(ActionEvent event) 
    {
		hbInsertarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBuscarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbIdentificarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbValidarId.setStyle("-fx-background-color: LIGHTGREY");
    	hbBorrarId.setStyle("-fx-background-color: teal");
/*    	hbFotoId.setVisible(false);
    	hbHuellaId.setVisible(false);
    	hbCURPId.setVisible(true);*/
    	
    	loadChild("/fxml/pantallaBorrar.fxml");
    	
    }


	private void loadChild(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
			Parent root = loader.load();
			BorrarController controller = loader.getController();
			
			innerContainer.getChildren().clear();
			innerContainer.getChildren().add(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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


	public EjecutarWS_Abis_10000 getApi() {
		return api;
	}


	public void setApi(EjecutarWS_Abis_10000 api) {
		this.api = api;
	}    
    
}
