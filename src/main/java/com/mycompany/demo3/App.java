package com.mycompany.demo3;

import com.mtd.services.BookServices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.text.ParseException;
import java.util.Scanner;
import static javafx.application.Application.launch;
import javafx.scene.layout.Region;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("homePage"), Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    
   
    
    public static void main(String[] args) throws ParseException {
        System.out.println("OK!");
        
        BookServices.mainMenu();
        launch();
       
    }
    
   

}
 