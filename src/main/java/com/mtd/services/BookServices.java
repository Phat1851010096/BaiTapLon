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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungm
 */
public class BookServices {
    
    private static final Connection conn = Utils.getConn();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static Scanner scanner = new Scanner(System.in);
    
    
     public static void mainMenu() throws ParseException {
        Scanner scanner = new Scanner(System.in);
            boolean loop = true;
            while (loop == true) {
                System.out.println("\n======== MENU ========");
                System.out.print("# 1. Xem danh sach sach          #"
                             + "\n# 2. Tim kiem theo ID sach       #"
                             + "\n# 3. Tim kiem nang cao           #"
                             + "\n# 4. Them sach                   #"
                             + "\n# 5. Xoa sach                    #"
                             + "\n# X. Thoat                        #"
                             + "\n===================================="
                        + "\n --> ");
                String chucNangMenuChinh = scanner.nextLine();
                switch(chucNangMenuChinh) {
                    case "1" : {
                            BookServices.console_dsSach();
                        break;
                    }
                    case "2" : {
                        System.out.println("Nhap ID sach: ");
                        String id = scanner.nextLine();                       
                        BookServices.console_timKiemID(id);
                        break;
                    }
                    case "3" : {
                        System.out.println("Nhap ten sach: ");
                        String bookName1 = scanner.nextLine();
                        
                        System.out.println("Nhap ten tac gia: ");
                        String authorName1 = scanner.nextLine();
                        
                        System.out.println("Nhap nam xuat ban: ");
                        String publishYear1 = scanner.nextLine();
                        
                        System.out.println("Nhap the loai: ");
                        String category1 = scanner.nextLine();
                        
                        BookServices.console_searchBook(bookName1, authorName1, publishYear1, category1);
                        
                        break;
                    }
                    case "4" : {                       
                        if (BookServices.console_addBook() == true) {
                            System.out.println("Them sach thanh cong");
                        }
                        else {
                            System.out.println("Them sach khong thanh cong ");
                        }
                        break;
                    }
                    case "5" : {                        
                        System.out.println("Nhap ID sach can xoa: ");
                        String id = scanner.nextLine();
                        BookServices.deleteBook(id);
                        break;
                    }
                    default : {
                        System.out.println("Thoat chuong trinh");
                        loop = false;
                        scanner.close();
                        break;
                    }
                }
                
            }
            
        }
    
    
    public static void console_dsSach() throws ParseException {
        List<Book> ds = new ArrayList<>();
        ds = BookServices.getBooks();
        
        for (Book b1 : ds) {
            System.out.println(b1.toString());

            System.out.println("");
        }
    }
    
    public static void console_timKiemID(String id) {
        Book b = getBookById(id);
        if (b != null){
            System.out.println(b.toString()); 
        }
        else {
            System.out.println("Khong tim thay");
        }
    }
    
    public static void console_searchBook(String bookName, String authorName, String publishYear, String category) {
        List<Book> ds = new ArrayList<>();
        ds = BookServices.searchBook(bookName,authorName, publishYear, category);
        
        if(ds.size() == 0) {
            System.out.println("Khong tim thay");
        }
        else {
            System.out.println("Danh sach sach: ");
            for (Book b1 : ds) {
            System.out.println(b1.toString());

            System.out.println("");
        }
        }
        
    }
    
    public static boolean console_addBook() {

            try {
                Book b = new Book();
                System.out.println("Enter a new book (BookName, Category, Author, "
                        + "Description, Publish Date, Publish Company, Entry date, Book position\n");
                System.out.println("Enter BookName: ");
                b.setBookName(scanner.nextLine().trim());

                System.out.println("Enter Category:");
                System.out.println("1. Văn học \t 2. Kinh tế \t 3. Kỹ năng \t 4. Thiếu nhi \t"
                        + "5. Ngoại ngữ \t 6. Kỹ thuật \t 7. Tiểu thuyết");
                b.setCategory(scanner.nextLine().trim());

                System.out.println("Enter author name: ");
                b.setAuthor(scanner.nextLine().trim());

                System.out.println("Enter description: ");
                b.setDescription(scanner.nextLine().trim());

                System.out.println("Enter Publishing date (yyyy-MM-dd): ");
            try {
                b.setPublishYear(dateFormat.parse(scanner.nextLine().trim()));
            } catch (ParseException ex) {
                System.err.println("Nhap sai thoi gian!");
                return false;
            }

                 System.out.println("Enter publish company: ");
                b.setPublishCompany(scanner.nextLine().trim());

                System.out.println("Enter Entry date (yyyy-MM-dd): ");
            try {
                b.setEntryDate(dateFormat.parse(scanner.nextLine().trim()));
            } catch (ParseException ex) {
                System.err.println("Nhap sai thoi gian!");
                return false;
            }

                System.out.println("Enter Book position: ");
                b.setBookPosition(scanner.nextLine().trim());


                return BookServices.addBook(b);

                
            } catch (Exception ex) {
                System.err.println("Loi them sach!");
                return false;
            }
            
//            try {
//                Book abc = new Book("Tony Buổi Sáng - Trên Đường Băng", Book.Category.KINHTE.getValue(),
//                        "Khi còn trẻ, hãy ra ngoài nhiều hơn ở nhà.", dateFormat.parse("2017-10-5"),
//                        "NXB Trẻ", dateFormat.parse("2018-6-5"), "123", "Tony buổi sáng");
//                System.out.println(abc.getCategory());
//                return BookServices.addBook(abc);
//            } catch (ParseException ex) {
//                System.err.println("Loi console_addBook");
//                return false;
//            }
    }
    
    public static List<Book> getBooks () throws ParseException {
        List<Book> listBook = new ArrayList<>();
        
        try {   
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM qlthuvien.books order by BookID asc");
         
           while(rs.next()) {
                int id = rs.getInt("BookID");
                String name = rs.getString("BookName");
                String category = rs.getString("Category");
                String description = rs.getString("Description");
                Date publishYear = rs.getDate("PublishYear");
                String publishCompany = rs.getString("PublishCompany");
                Date entryDate = rs.getDate("EntryDate");
                String position = rs.getString("BookPosition");
                String author = rs.getString("AuthorName");
                Book b = new Book(id, name, category, description, publishYear, publishCompany, entryDate, position, author);
                listBook.add(b);


            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return listBook;
    }
    
    public static Book getBookById(String BookID) {
        Book b1 = new Book();
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Books WHERE BookID = ?");
            stm.setString(1,BookID);
            
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
                String author = rs.getString("AuthorName");
                Book b = new Book(id, name, category, description, publishYear, publishCompany, entryDate, position, author);
                return b;


            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Loi - BookServices - getbookbyid");
        }
                        
        return null;
    }
    
    public static boolean addBook(Book book) {
        boolean flag = false;
        try {
            
            String addQuery = "INSERT INTO Books(BookName, Category, AuthorName, Description,PublishYear, PublishCompany, EntryDate, BookPosition)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?);";    
            PreparedStatement stm = conn.prepareStatement(addQuery);           
            conn.setAutoCommit(flag);
            
            stm.setString(1, book.getBookName());
            stm.setString(2, book.getCategory());
            stm.setString(3, book.getAuthor());
            stm.setString(4, book.getDescription());
            stm.setDate(5, new java.sql.Date(book.getPublishYear().getTime()));
            stm.setString(6, book.getPublishCompany());
            stm.setDate(7, new java.sql.Date(book.getEntryDate().getTime()));
            stm.setString(8, book.getBookPosition());
            
            stm.executeUpdate();
            conn.commit();
            

            
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
            if (conn != null)
                try {
                    System.err.print("Them du lieu bi loi. Rollback!");
                    conn.rollback();
                    return flag;
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
//            String sqlQuerry = "SELECT distinct B.*, BA.AuthorName\n"
//            + "FROM qlthuvien.books_authors BA, qlthuvien.books B, qlthuvien.authors A\n"
//            + "WHERE B.BookID = BA.BookID AND A.AuthorID = BA.AuthorID AND\n"
//            + "(B.BookName LIKE \"%" + bookName + "%\" AND A.AuthorName LIKE \"%" + authorName + "%\""
//            + "AND year(B.PublishYear) LIKE \"%" + publishYear + "%\" AND B.Category LIKE \"% " + category +"%\" ) ";
            
            String sqlQuerry = "SELECT * FROM books "
                    + "WHERE (BookName LIKE \"%" + bookName + "%\" "
                    + "AND AuthorName LIKE \"%" + authorName + "%\" "
                    + "AND year(PublishYear) LIKE \"%" + publishYear + "%\" "
                    + "AND Category LIKE \"%" + category + "%\" )";
            
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
    
    public static
         void deleteBook(String BookID) {
        try {
            
            String deleteQuery = "DELETE FROM qlthuvien.Books WHERE BookID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setString(1, BookID);
            
            preparedStatement.executeUpdate();
            
            System.out.println("\nDelete book success!");
        } catch (SQLException ex) {
            System.err.println("Nhap sai ID");
        }
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
