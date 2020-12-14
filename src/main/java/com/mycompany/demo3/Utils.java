/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import com.mtd.pojo.Book;
import static com.mtd.services.Utils.getConn;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.Driver;
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
    
    public static ObservableList<Books> getDatabook(){
        Connection conn =  getConn();
        ObservableList<Books> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from books");
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()){
                list.add(new Books(Integer.parseInt(rs.getString("BookID")), 
                        rs.getString("BookName"),rs.getString("AuthorName")
                        ,rs.getString("Category"),
                        rs.getString("Description"), rs.getDate("PublishYear"), 
                        rs.getString("PublishCompany"), rs.getDate("EntryDate"), 
                        rs.getString("BookPosition")));
            }
        } catch (Exception e) {
        } 
        return list;
    }
    
}
