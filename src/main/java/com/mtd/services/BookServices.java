/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtd.services;

import com.mtd.pojo.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungm
 */
public class BookServices {
    
    private static final Connection conn = Utils.getConn();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void console_dsSach() throws ParseException {
        List<Book> ds = new ArrayList<>();
        ds = BookServices.getBooks();
        
        for (Book b1 : ds) {
            System.out.println(b1.toString());

            System.out.println("");
        }
    }
    
    public static void console_timKiemID(int id) {
        Book b = getBookById(id);
        System.out.println(b.toString());
    }
    
    public static void console_searchBook(String bookName, String authorName, String publishYear, String category) {
        List<Book> ds = new ArrayList<>();
        ds = BookServices.searchBook(bookName,authorName, publishYear, category);
        
        for (Book b1 : ds) {
            System.out.println(b1.toString());

            System.out.println("");
        }
    }
    
    public static List<Book> getBooks () throws ParseException {
        List<Book> listBook = new ArrayList<>();
        
        try {   
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * From Books");


//            while (rs.next()) {
//                int bookID = rs.getInt("BookID");
//                String name = rs.getString("BookName");
//                String category = rs.getString("Category");
//                //String description = rs.getString("Description");
//                //Date publishYear = rs.getDate("PublishYear");
////                java.sql.Date mysqlDate = rs.getDate("PublishYear");
////                java.util.Date dateConverter = new java.util.Date(mysqlDate.getTime());
//                //String publishCompany = rs.getString("PublishCompany");
//                //Date entryDate = rs.getDate("EntryDate");
////                java.sql.Date mysqlDate2 = rs.getDate("entryDate");
////                java.util.Date dateConverter2 = new java.util.Date(mysqlDate2.getTime());
//                //String position = rs.getString("BookPosition");
//                
//
//            Book b = new Book(bookID, name, category);
//            
//            
//                //Book b = new Book(bookID, name, category, description, dateFormat.parse("1976-3-14"), publishCompany, dateFormat.parse("1976-3-14"), position);
//
//                listBook.add(b);
//            }
//            
            while(rs.next()) {
                int id = rs.getInt("BookID");
                String name = rs.getString("BookName");
                String category = rs.getString("Category");
                String description = rs.getString("Description");
                Date publishYear = rs.getDate("PublishYear");
                String publishCompany = rs.getString("PublishCompany");
                Date entryDate = rs.getDate("EntryDate");
                String position = rs.getString("BookPosition");
                
                Book b = new Book(id, name, category, description, publishYear, publishCompany, entryDate, position);
                listBook.add(b);


            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return listBook;
    }
    
    public static Book getBookById(int bookID) {
        Book book1 = new Book();
        
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Books WHERE BookID = ?");
            stm.setInt(1, bookID);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("BookID");
                String name = rs.getString("BookName");
                String category = rs.getString("Category");
                String description = rs.getString("Description");
                Date publishYear = rs.getDate("PublishYear");
                String publishCompany = rs.getString("PublishCompany");
                Date entryDate = rs.getDate("EntryDate");
                String position = rs.getString("BookPosition");
                Book b = new Book(id, name, category, description, publishYear, publishCompany, entryDate, position);
                return b;


            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        return book1;
    }
    
    public static boolean addBook(Book book) {
        boolean flag = false;
        try {
            
            String addQuery = "INSERT INTO Books(BookName, Category, Description,PublishYear, PublishCompany, EntryDate, BookPosition)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?);";    
            PreparedStatement stm = conn.prepareStatement(addQuery);           
            conn.setAutoCommit(flag);
            
            stm.setString(1, book.getBookName());
            stm.setString(2, book.getCategory());
            stm.setString(3, book.getDescription());
            stm.setDate(4, new java.sql.Date(book.getPublishYear().getTime()));
            stm.setString(5, book.getPublishCompany());
            stm.setDate(6, new java.sql.Date(book.getEntryDate().getTime()));
            stm.setString(7, book.getBookPosition());
            
            stm.executeUpdate();
            conn.commit();
            

            
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
            if (conn != null)
                try {
                    System.err.print("Them du lieu bi loi. Rollback!");
                    conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        
        return flag;
    }
    
    public static List<Book> searchBook(String bookName, String authorName, String publishYear, String category) {   
//Tên sách, tên tác giả, năm xuât bản, danh mục
         List<Book> listBook = new ArrayList<>();
         
         if (bookName == null) bookName ="";
         if (authorName == null) authorName = "";
         if (publishYear == null) publishYear = "";
         if (category == null) category = ""; 
        
        try {   
            Statement stm = conn.createStatement();
            String sqlQuerry = "SELECT distinct B.*, BA.AuthorName\n"
            + "FROM qlthuvien.books_authors BA, qlthuvien.books B, qlthuvien.authors A\n"
            + "WHERE B.BookID = BA.BookID AND A.AuthorID = BA.AuthorID AND\n"
            + "(B.BookName LIKE \"%" + bookName + "%\" AND A.AuthorName LIKE \"%" + authorName + "%\""
            + "AND year(B.PublishYear) LIKE \"%" + publishYear + "%\" AND B.Category LIKE \"% " + category +"%\" ) ";
            
            ResultSet rs = stm.executeQuery(sqlQuerry);
            
            while(rs.next()) {
                int id = rs.getInt("BookID");
                String name = rs.getString("BookName");
                String category2 = rs.getString("Category");
                String description = rs.getString("Description");
                Date publishYear2 = rs.getDate("PublishYear");
                String publishCompany = rs.getString("PublishCompany");
                Date entryDate = rs.getDate("EntryDate");
                String position = rs.getString("BookPosition");
                
                Book b = new Book(id, name, category2, description, publishYear2, publishCompany, entryDate, position);
                listBook.add(b);


            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return listBook;
    }
    
    public static void deleteTempInMySQL(int bookID) { 
       
        try {           
            String deleteTempTable = "DELETE FROM temp";
            PreparedStatement pstm = conn.prepareStatement(deleteTempTable);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Can't delete temp table!");
        }
    }
    
}
