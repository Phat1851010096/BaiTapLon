/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Diem
 */
public class TraCuuController  implements Initializable {

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
    private TableColumn<Books, CheckBox> select;
    @FXML
    private void switchTohomePageLogout() throws IOException {
        App.setRoot("homePageLogout");
    }
    
    @FXML private TextField txt_MaSach;
    @FXML private TextField txt_TenSach;
    @FXML private TextField txt_PhanLoai;
    @FXML private TextField txt_MoTa;
    @FXML private TextField txt_NamXuatBan;
    @FXML private TextField txt_NhaXuatBan;
    @FXML private TextField txt_NgayNhap;
    @FXML private TextField txt_ViTriSach;
    @FXML private TextField txt_HienThi;
    
    
    ObservableList<Books> listM;
    ObservableList<Books> listBook;
    
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        conn = Utils.getConn();
//        String sql = "select count(*) from books ";
//        try{
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(sql);
//            rs.next();
//            int dem = rs.getInt(1);
// 
//            UpdateTable();
            search();

//            
//        }catch(SQLException e){
//            System.err.println("Loi ket noi!");
//        }
//        
//       
    }  
    
    public void homePageLogoutOnAction(ActionEvent event) throws IOException{
        switchTohomePageLogout();
    }
    
//    public void Add (){    
//        conn = Utils.getConn();
//        String sql = "insert into Books (BookID, BookName, Category, Description, "
//                + "PublishYear, PublicCompany, EntryDate, BookPosition)values(?,?,?,?,?,?,?,?)";
//        try {
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, txt_MaSach.getText());
//            pst.setString(2, txt_TenSach.getText());
//            pst.setString(3, txt_PhanLoai.getText());
//            pst.setString(4, txt_MoTa.getText());
//            pst.setString(5, txt_NamXuatBan.getText());
//            pst.setString(6, txt_NhaXuatBan.getText());
//            pst.setString(7, txt_NgayNhap.getText());
//            pst.setString(8, txt_ViTriSach.getText());
//            
//            pst.execute();
//            
//            UpdateTable();
//            search();
//        } catch (Exception ex) {
//            System.err.println("Loi ket noi");
//        }
//    }
//    
    @FXML
    void getSelected (MouseEvent event){
    index = tableBooks.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
 
    
    txt_TenSach.setText(col_BookName.getCellData(index).toString());
    txt_PhanLoai.setText(col_Category.getCellData(index).toString());
    txt_NamXuatBan.setText(col_PublishYear.getCellData(index).toString());
    }
//    
//    public void Edit (){   
//        try {
//            conn = Utils.getConn();
//            String value1 = txt_MaSach.getText();
//            String value2 = txt_TenSach.getText();
//            String value3 = txt_PhanLoai.getText();
//            String value4 = txt_MoTa.getText();
//            String value5 = txt_NamXuatBan.getText();
//            String value6 = txt_NhaXuatBan.getText();
//            String value7 = txt_NgayNhap.getText();
//            String value8 = txt_ViTriSach.getText();
//            String sql = "update Books set BookID= '" + value1 +"',BookName= '" + value2 +"', "
//                    + "Category= '" + value3 +"',Description= '"+value4+"' "
//                    + "PublishYear='"+value5+"', PublishCompany='"+value6+"'"
//                    + "EntryDate='"+value7+"', BookPosition='"+value8+"'"
//                    + "WHERE BookID='"+value1+"' ";
//            pst= conn.prepareStatement(sql);
//            pst.execute();
//            UpdateTable();
//            search();
//        } catch (Exception e) {
//           System.err.println("Loi ket noi!");
//        }
//        
//    }
//    
//    public void Delete(){
//        conn = Utils.getConn();
//        String sql = "delete from Books where BookID = ?";
//            try {
//                pst = conn.prepareStatement(sql);
//                pst.setString(1, txt_MaSach.getText());
//                pst.setString(2, txt_TenSach.getText());
//                pst.setString(3, txt_PhanLoai.getText());
//                pst.setString(4, txt_MoTa.getText());
//                pst.setString(5, txt_NamXuatBan.getText());
//                pst.setString(6, txt_NhaXuatBan.getText());
//                pst.setString(7, txt_NgayNhap.getText());
//                pst.setString(8, txt_ViTriSach.getText());
//                pst.execute();
//                UpdateTable();
//                search();
//            } catch (Exception e) {
//                System.err.println("Loi ket noi!");
//            }
//
//    }
    
    
    public void UpdateTable(){
        col_BookID.setCellValueFactory(new PropertyValueFactory<Books, Integer>("BookID"));
        col_BookName.setCellValueFactory(new PropertyValueFactory<Books, String>("BookName"));
        col_Category.setCellValueFactory(new PropertyValueFactory<Books, String>("Category"));
        col_Description.setCellValueFactory(new PropertyValueFactory<Books, String>("Description"));
        col_PublishYear.setCellValueFactory(new PropertyValueFactory<Books, Date>("PublishYear"));
        col_PublishCompany.setCellValueFactory(new PropertyValueFactory<Books, String>("PublishCompany"));
        col_EntryDate.setCellValueFactory(new PropertyValueFactory<Books, Date>("EntryDate"));
        col_BookPosition.setCellValueFactory(new PropertyValueFactory<Books, String>("BookPosition"));
        select.setCellValueFactory(new PropertyValueFactory<Books, CheckBox>("checkbox"));
        
        listM = Utils.getDatabook();
        tableBooks.setItems(listM);
    }
    
    @FXML
    void search() {   
        col_BookID.setCellValueFactory(new PropertyValueFactory<Books, Integer>("BookID"));
        col_BookName.setCellValueFactory(new PropertyValueFactory<Books, String>("BookName"));
        col_Category.setCellValueFactory(new PropertyValueFactory<Books, String>("Category"));
        col_Description.setCellValueFactory(new PropertyValueFactory<Books, String>("Description"));
        col_PublishYear.setCellValueFactory(new PropertyValueFactory<Books, Date>("PublishYear"));
        col_PublishCompany.setCellValueFactory(new PropertyValueFactory<Books, String>("PublishCompany"));
        col_EntryDate.setCellValueFactory(new PropertyValueFactory<Books, Date>("EntryDate"));
        col_BookPosition.setCellValueFactory(new PropertyValueFactory<Books, String>("BookPosition"));
        select.setCellValueFactory(new PropertyValueFactory<Books, CheckBox>("checkbox"));
        
        listBook =  Utils.getDatabook();
        tableBooks.setItems(listBook);
        FilteredList<Books> filteredData = new FilteredList<>(listBook, b -> true);  
	txt_TenSach.textProperty().addListener((observable, oldValue, newValue) -> {
	filteredData.setPredicate(person -> {
                String lowerCaseFilter = newValue.toLowerCase();
        	if (newValue == null || newValue.isEmpty()) {
           		return true;
        	} else if (person.getBookName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                		return true; 
                }
		else
			return false;
		});
	});
	
	
	txt_NamXuatBan.textProperty().addListener((observable, oldValue, newValue) -> {
	filteredData.setPredicate(person -> {
        	String lowerCaseFilter = newValue.toLowerCase();
                if (newValue == null || newValue.isEmpty()) {
           		return true;
        	} else if (String.valueOf(person.getPublishYear()).indexOf(lowerCaseFilter)!=-1) {
                		return true; 
                }
		else
			return false;
		});
	});
        
        txt_PhanLoai.textProperty().addListener((observable, oldValue, newValue) -> {
	filteredData.setPredicate(person -> {
                String lowerCaseFilter = newValue.toLowerCase();
        	if (newValue == null || newValue.isEmpty()) {
           		return true;
        	} else if (person.getCategory().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                		return true; 
                }
		else
			return false;
		});
	});
	
	
        SortedList<Books> sortedData = new SortedList<>(filteredData);  
        sortedData.comparatorProperty().bind(tableBooks.comparatorProperty());  
        tableBooks.setItems(sortedData);      
    }
        
 }
