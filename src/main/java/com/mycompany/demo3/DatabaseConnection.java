/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
}
