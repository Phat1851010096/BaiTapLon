/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtd.services;

import com.mtd.pojo.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungm
 */
public class ReaderServices {
    public static Connection conn = Utils.getConn();
    public static Reader getReaderById(int ReaderID) {
        Reader reader = new Reader();
        
        String querry = "SELECT * FROM qlthuvien.readers WHERE Username = ?;";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(querry);
            pstm.setInt(1, ReaderID);
            
            ResultSet rs = pstm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReaderServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return reader;
    }
}
