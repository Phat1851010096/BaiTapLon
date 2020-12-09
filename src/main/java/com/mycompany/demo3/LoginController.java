/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PHAT NGUYEN
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File brandingFile = new File("C:/Users/tanph/Documents/netbeanproject/demo3/src/Images/Logo.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
        
        File lockFile = new File("C:/Users/tanph/Documents/netbeanproject/demo3/src/Images/o_khoa.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
        
        File bookFile = new File("C:/Users/tanph/Documents/netbeanproject/demo3/src/Images/123.png");
        Image bookImage = new Image(bookFile.toURI().toString());
        bookImageView.setImage(bookImage);
        // TODO
    }    
    
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView bookImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    
    //
    public void loginButtonOnAction(ActionEvent event) throws SQLException, IOException, InterruptedException{
        if(usernameTextField.getText().isBlank() == false //Kiem tra username va password co rong hay khong
                && passwordTextField.getText().isBlank() == false){
             validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }
    
    //
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    
    @FXML
    private void switchToHomePage() throws IOException {
        App.setRoot("homePage");
    }
    //
    public void validateLogin() throws SQLException, IOException, InterruptedException{
        DatabaseConnection conn = new DatabaseConnection();//
        Connection connectDB = conn.getConnection();
        String veryfyLogin = "SELECT Count(1) FROM qlthuvien.user_accout WHERE username = '" + 
                usernameTextField.getText() + "'AND password ='" + passwordTextField.getText() + "'";
        //?????
        Statement statement = connectDB.createStatement();//
        ResultSet queryResult = statement.executeQuery(veryfyLogin);
        
        //nếu có trong database thì trả về 1 ngược lại là 0
        while(queryResult.next()){
            if(queryResult.getInt(1) == 1){
                loginMessageLabel.setText("Chúc mừng, Bạn đăng nhập thành công!");
                
                switchToHomePage();
            } else{
                loginMessageLabel.setText("Invalid login, Please try again!");
            }
        }
    }
    
    
}

