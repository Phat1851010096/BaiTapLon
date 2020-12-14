/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Phat Nguyen
 */
public class HomePageLogoutController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToTraCuu() throws IOException {
        App.setRoot("TraCuu");
    }
    
    @FXML
    private void switchToInfo() throws IOException {
        App.setRoot("info");
    }
    
    @FXML
    private void switchToHomePage() throws IOException {
        App.setRoot("homePage");
    }
    
    public void traCuuPageOnAction(ActionEvent event) throws IOException{
        switchToTraCuu();
    }
    
    public void InfoPageOnAction(ActionEvent event) throws IOException{
        switchToInfo();
    }
    
    public void homePageOnAction(ActionEvent event) throws IOException{
        switchToHomePage();
    }

}
