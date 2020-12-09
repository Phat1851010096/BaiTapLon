/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Phat Nguyen
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class LoginController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        LoginController instance = new LoginController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginButtonOnAction method, of class LoginController.
     */
    @Test
    public void testLoginButtonOnAction() throws Exception {
        System.out.println("loginButtonOnAction");
        ActionEvent event = null;
        LoginController instance = new LoginController();
        instance.loginButtonOnAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelButtonOnAction method, of class LoginController.
     */
    @Test
    public void testCancelButtonOnAction() {
        System.out.println("cancelButtonOnAction");
        ActionEvent event = null;
        LoginController instance = new LoginController();
        instance.cancelButtonOnAction(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateLogin method, of class LoginController.
     */
    @Test
    public void testValidateLogin() throws Exception {
        System.out.println("validateLogin");
        LoginController instance = new LoginController();
        instance.validateLogin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
