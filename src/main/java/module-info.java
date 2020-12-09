module com.mycompany.baitaplon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires mysql.connector.java;
    requires javafx.base;
    requires javafx.graphics;

    opens com.mycompany.demo3 to javafx.fxml;
    exports com.mycompany.demo3;
}