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
        // TODO
//        File homeFile = new File("C:/Users/tanph/Documents/netbeanproject/demo3/src/main/java/com/mycompany/demo3/Images/home.png");
//        Image homeImage = new Image(homeFile.toURI().toString());
//        homeImageView.setImage(homeImage);
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
