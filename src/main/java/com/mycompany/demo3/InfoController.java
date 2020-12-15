/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;


import java.io.IOException;


import com.mtd.pojo.Reader;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
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
    @FXML private  TextField txt_MaDocGia;
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
    
    public static TextField static_MaDocGia;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        static_MaDocGia = txt_MaDocGia;
//        PreparedStatement pst = null;
//        Connection conn = Utils.getConn();
//        try{
//            Statement stm = conn.createStatement(); 
//            String sql = "SELECT * FROM qlthuvien.readers WHERE Username = '"+ static_MaDocGia +"'";
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, txt_MaDocGia.getText());
//            pst.setString(2, txt_Ten.getText());
//            pst.setString(3, txt_NgaySinh.getText());
//            pst.setString(4, txt_GioiTinh.getText());
//            pst.setString(5, txt_DoiTuong.getText());
//            pst.setString(6, txt_HanThe.getText());
//            pst.setString(7, txt_Email.getText());
//            pst.setString(8, txt_SDT.getText());
//            pst.setString(9, txt_DiaChi.getText());
//            pst.setString(10, txt_Khoa.getText());
//            pst.execute();
//            
//           
//            ResultSet rs = stm.executeQuery(sql);
//            rs.next();
//            
//
//        } catch(SQLException ex){
//            System.err.println("Loi ket noi!");
//        }

    } 
    
    
    @FXML
    private void switchToHomePageLogout() throws IOException {
        App.setRoot("homePageLogout");
    }
    
    public void homepageLogoutOnAction(ActionEvent event) throws IOException{
        switchToHomePageLogout();
    }
}
