/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import com.mtd.pojo.*;
import static com.mtd.services.Utils.getConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author PHAT NGUYEN
 */
public class DatabaseConnection {
    public Connection databaseLink;
    
    public Connection getConnection() throws SQLException {
         String databaseName = "qlthuvien";
         String url ="jdbc:mysql://127.0.0.1:3306/?user=root/qlthuvien" + databaseName ;
         String databaseUser = "root";
         String databasePassword = "123456";
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return databaseLink;
    }
    
    public static ObservableList<Books> getDatabook(){
        Connection conn =  getConn();
        ObservableList<Books> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from books");
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()){
                list.add(new Books(Integer.parseInt(rs.getString("BookID")), 
                        rs.getString("BookName"), rs.getString("Category"),
                        rs.getString("AuthorName"),
                        rs.getString("Description"), rs.getDate("PublishYear"), 
                        rs.getString("PublishCompany"), rs.getDate("EntryDate"), 
                        rs.getString("BookPosition")));
            }
        } catch (Exception e) {
        } 
        return list;
    }
}
