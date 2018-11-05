/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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

import org.controlsfx.control.StatusBar;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Acerta
 */
@Component
public class FXMLDocumentController implements Initializable {
    
//    @FXML
//    private Label label;
	@Autowired private ApplicationContext applicationContext;	
	
	@FXML private HBox hbInsertarId;
	@FXML private HBox hbBuscarId;
	@FXML private HBox hbIdentificarId;
	@FXML private HBox hbValidarId;
	@FXML private HBox hbBorrarId;
//	@FXML private HBox hbFotoId;
//	@FXML private HBox hbHuellaId;
//	@FXML private HBox hbCURPId;
	
	@FXML private VBox innerContainer;
	@FXML private StatusBar statusBar;
	@Autowired private StringProperty statusProperty;
	
	
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
    	
    	loadChild("Borrar", "/fxml/pantallaBorrar.fxml");
    	
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

	private void loadChild(String nombre, String fxml) {
		try {
			
			final JavaFXBuilderFactory bf = new JavaFXBuilderFactory();
	    	final Callback<Class<?>, Object> cb = (clazz) -> applicationContext.getBean(clazz);
	    	Parent root = FXMLLoader.load(
	    			getClass().getResource(fxml)
	    			, null
	    			, bf
	    			, cb );
	    	
//			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
//			Parent root = loader.load();
//			BorrarController controller = loader.getController();
			
			innerContainer.getChildren().clear();
			innerContainer.getChildren().add(root);
			statusProperty.set(nombre);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	statusBar.textProperty().bind(statusProperty);
    	
    	
//    	hbBorrarId.hoverProperty().addListener((observable, oldValue, newValue)-> { (Objects.notNull(newValue)||newValue) ? statusProperty.set("Borrar un registro") : statusProperty.set(""); });
    	
    }

    
}
