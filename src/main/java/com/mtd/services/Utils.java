/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtd.services;

import com.mtd.pojo.Book;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class Utils {
    private static Connection conn;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/qlthuvien", "root", "123456");
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Khong the ket noi CSDL! - Utils.java");
        }
    }

    /**
     * @return the conn
     */
    public static Connection getConn() {
        return conn;
    }
    
    
}
