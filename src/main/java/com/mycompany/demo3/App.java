package com.mycompany.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.mtd.pojo.*;
import com.mtd.services.*;
import java.text.ParseException;
import javafx.scene.layout.Region;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
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
        //BookServices.console_searchBook("", "", "20", "");
        //BookServices.console_timKiemID(16);
        
        System.out.println("Start!");
//        if(BookServices.console_addBook() == true) {
//            System.out.print("thanh cong");
//        }
//        else {
//            System.out.print("ko duoc");
//        }

//        Book b = BookServices.console_enterBook();
//        b.toString();
//        BookServices.addBook(b);
        
        BookServices.deleteBook(21);

        System.out.println("OK!");
         //launch();
    }
    
}