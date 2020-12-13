/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import com.mtd.pojo.Book;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Diem
 */
public class TraCuuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Books> tableBooks;
    @FXML
    private TableColumn<Books, Integer> col_BookID;
    @FXML
    private TableColumn<Books, String> col_BookName;
    @FXML
    private TableColumn<Books, String> col_Category;
    @FXML
    private TableColumn<Books, String> col_PublishCompany;
    @FXML
    private TableColumn<Books, String> col_Description;
    @FXML
    private TableColumn<Books, Date> col_PublishYear;
    @FXML
    private TableColumn<Books, Date> col_EntryDate;
    @FXML
    private TableColumn<Books, String> col_BookPosition; 
    @FXML
    private void switchTohomePageLogout() throws IOException {
        App.setRoot("homePageLogout");
    }
    @FXML
    private TextField filterTenSach;
    
    
    
    ObservableList<Books> listBook;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //thao tac xu ly tableview va ket noi csdl
        col_BookID.setCellValueFactory(new PropertyValueFactory<Books, Integer>("BookID"));
        col_BookName.setCellValueFactory(new PropertyValueFactory<Books, String>("BookName"));
        col_Category.setCellValueFactory(new PropertyValueFactory<Books, String>("Category"));
        col_Description.setCellValueFactory(new PropertyValueFactory<Books, String>("Description"));
        col_PublishYear.setCellValueFactory(new PropertyValueFactory<Books, Date>("PublishYear"));
        col_PublishCompany.setCellValueFactory(new PropertyValueFactory<Books, String>("PublishCompany"));
        col_EntryDate.setCellValueFactory(new PropertyValueFactory<Books, Date>("EntryDate"));
        col_BookPosition.setCellValueFactory(new PropertyValueFactory<Books, String>("BookPosition"));
          
        listBook =  DatabaseConnection.getDatabook();
        tableBooks.setItems(listBook);
        
        //Truyen items vao combobox Thể Loại

    }  
    
    public void homePageLogoutOnAction(ActionEvent event) throws IOException{
        switchTohomePageLogout();
    }
    
    
    
    
    public void searchOnAction(ActionEvent event){
        //Tìm kiếm và lọc 
//        ObservableList<Books> dataList = FXCollections.observableArrayList();
        FilteredList<Books> filteredData = new FilteredList<>(listBook, b -> true);
        
        //Lọc khi fill có thay đổi
        filterTenSach.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(Books ->{
                //fill rỗng thì hiện tất cả
                if(newValue == null || newValue.isEmpty()){
                    return true;
                } 

                //Lọc phân biệt hoa thường
                String lowerCaseFilter = newValue.toLowerCase();
                if(Books.getBookName().toLowerCase().indexOf(lowerCaseFilter) != 1){
                    return true;
                } else if(Books.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(String.valueOf(Books.getBookPosition()).indexOf(lowerCaseFilter) != -1)
                    return true;
                    else
                        return false;             
                });
                
                
        });
        
        SortedList<Books> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableBooks.comparatorProperty());
        tableBooks.setItems(sortedData);
   
    }
 }
