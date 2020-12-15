/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Phat Nguyen
 */
public class HomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }  
    
    @FXML
    private void switchToTraCuu() throws IOException {
        App.setRoot("TraCuu");
    }
    
    @FXML
    private void switchToInfo() throws IOException {
        App.setRoot("info");
    }
    
        public void traCuuPageOnAction(ActionEvent event) throws IOException{
        switchToTraCuu();
    }
    
    public void InfoPageOnAction(ActionEvent event) throws IOException{
        switchToInfo();
    }
    
    public void loginPageOnAction(ActionEvent event) throws IOException{
        switchToLoginPage();
    }
    
    @FXML
    private ImageView homeImageView;
    
    @FXML
    private void switchToLoginPage() throws IOException {
        App.setRoot("login");
    }
    
}
