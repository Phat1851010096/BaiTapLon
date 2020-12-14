/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtd.pojo;

import com.mtd.pojo.Author;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dungm
 */

public class Book {
    public static enum Category {
        VANHOC("Văn học"), KINHTE("Kinh tế"), KYNANG("Kỹ năng"), THIEUNHI("Thiếu nhi"),
        NGOAINGU("Ngoại ngữ"), KYTHUAT("Kỹ thuật"), TIEUTHUYET("Tiểu thuyết");
        
        private String value;
        
        private Category(String value) {
            this.value = value;
            
        }
        public String getValue() {
            return value;
        }
    
}
    private int bookID;
    private String bookName = null;
    private String category = null;
    private String author = null;
    private String description = null;
    private Date publishYear = null;
    private String publishCompany = null;
    private Date entryDate = null;
    private String bookPosition = null;
    
    public Book (){
    }
    
    public Book(int bookID, String bookName, String category) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.category = category;  
    }
      
    public Book(String bookName, String author, String category, Date publishYear) {
        this.bookName = bookName;
        this.category = category;
         this.publishYear = publishYear;
         this.author = author;
    }
    public Book(String bookName, String category, 
            String description, Date publishYear, String publishCompany, 
            Date entryDate, String bookPosition) {
        this.bookName = bookName;
        this.category = category;
        this.description = description;
        this.publishYear = publishYear;
        this.publishCompany = publishCompany;
        this.entryDate = entryDate;
        this.bookPosition = bookPosition;
    }
    
        public Book(String bookName, String category, 
            String description, Date publishYear, String publishCompany, 
            Date entryDate, String bookPosition, String author) {
            this(bookName, category, description, publishYear, publishCompany, entryDate, bookPosition);
            this.author = author;
        }
        
    public Book(int bookID,String bookName, String category, 
            String description, Date publishYear, String publishCompany, 
            Date entryDate, String bookPosition) {
        this(bookName, category, description, publishYear, publishCompany, entryDate, bookPosition);        
        this.bookID = bookID;

    }
    
   public Book(int bookID,String bookName, String category, 
            String description, Date publishYear, String publishCompany, 
            Date entryDate, String bookPosition, String author) {
        this(bookID, bookName, category, description, publishYear, publishCompany, entryDate, bookPosition);
        this.author = author;
   }
    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder str = new StringBuilder();
        str.append(String.format(" - ID: %d", this.getBookID()));
        str.append(String.format(" - Name: %s", this.getBookName()));
        str.append(String.format(" - Category: %s", this.getCategory()));
        str.append(String.format(" - Description: %s", this.getDescription()));
        if (this.getPublishYear() != null) {
            str.append(String.format(" - Publish year: %s", dateFormat.format(this.getPublishYear())));
        }
        else {
            str.append(String.format(" - Publish year: %s", "NaN"));
        }
        str.append(String.format(" - Publish company: %s", this.getPublishCompany()));
        if(this.getEntryDate() != null) {
                str.append(String.format(" - Entry date: %s", dateFormat.format(this.getEntryDate())));
        }
        else {
             str.append(String.format(" - Entry date: %s", "NaN"));
        }
        str.append(String.format(" - Book position: %s", this.getBookPosition()));
        str.append(String.format(" - Author: %s", this.getAuthor()));
        return str.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the bookID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the publishYear
     */
    public Date getPublishYear() {
        return publishYear;
    }

    /**
     * @param publishYear the publishYear to set
     */
    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * @return the publishCompany
     */
    public String getPublishCompany() {
        return publishCompany;
    }

    /**
     * @param publishCompany the publishCompany to set
     */
    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    /**
     * @return the entryDate
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate the entryDate to set
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * @return the bookPosition
     */
    public String getBookPosition() {
        return bookPosition;
    }

    /**
     * @param bookPosition the bookPosition to set
     */
    public void setBookPosition(String bookPosition) {
        this.bookPosition = bookPosition;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    
}
