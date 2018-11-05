/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Acerta
 */
@ComponentScan(basePackages={"com.acerta", "fxml"})
@ImportResource("META-INF/spring/spring.xml")
public class FXMLDemo extends Application {
    
	static AnnotationConfigApplicationContext ctx;
	
    @Override
    public void start(Stage stage) throws Exception {
    	String uri = "/fxml/pantallaPrueba.fxml";
    	
        final JavaFXBuilderFactory bf = new JavaFXBuilderFactory();
    	final Callback<Class<?>, Object> cb = (clazz) -> ctx.getBean(clazz);
    	Parent root = FXMLLoader.load(
    			getClass().getResource(uri)
    			, null
    			, bf
    			, cb );
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	ctx = new AnnotationConfigApplicationContext(fxml.FXMLDemo.class);
    	ctx.registerShutdownHook();
        launch(args);
    }
    
}
