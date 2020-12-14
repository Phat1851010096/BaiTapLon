/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import com.mtd.pojo.Reader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diem
 */
public class InfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private TextField txt_MaDocGia;
    @FXML private TextField txt_Ten;
    @FXML private TextField txt_NgaySinh;
    @FXML private TextField txt_GioiTinh;
    @FXML private TextField txt_DoiTuong;
    @FXML private TextField txt_HanThe;
    @FXML private TextField txt_Email;
    @FXML private TextField txt_SDT;
    @FXML private TextField txt_DiaChi;
    @FXML private TextField txt_Khoa;
    @FXML
    private void switchTohomePageLogout() throws IOException {
        App.setRoot("homePageLogout");
    }
    
        
    public void homePageLogoutOnAction(ActionEvent event) throws IOException{
        switchTohomePageLogout();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PreparedStatement pst = null;
        Connection conn = Utils.getConn();
//        String userName = LoginController.
        try{
            Statement stm = conn.createStatement();           
            String sql = "SELECT * FROM qlthuvien.readers WHERE Username = '"+ txt_MaDocGia.getText()+"'";
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            
        } catch(SQLException ex){
            System.err.println("Loi ket noi!");
        }
        
    
        
    } 
    
    
}
