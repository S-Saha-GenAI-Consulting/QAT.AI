package com.selenium_automation;

import static com.selenium_automation.CommonUtils.*;
import static com.selenium_automation.Waits.*;

import java.io.FileInputStream;
import java.io.File;


import java.util.Properties;
import static com.selenium_automation.Asserts.*;
import static com.selenium_automation.Driver.dr;

import static com.selenium_automation.PageFactories.LoginPage.*;

import org.openqa.selenium.support.PageFactory;

import com.selenium_automation.PageFactories.LoginPage;


public class StepMethods{


    public static void loginTitle(){

        try{

            getUrl();
            PageFactory.initElements(dr, LoginPage.class);
            WaitTitleContains("Swag Labs");
            System.out.println("Page title is: " + dr.getTitle());
            assertEquals(dr.getTitle(), "Swag Labs");

        }
        catch(Exception e){
            tearDown();
            logger(e);
        }
    }

    public static void loginMethod(){

        try{

            //test random credentials can be entered and deleted
            username.sendKeys("abcd");
            password.sendKeys("1234");
            clearText(username);
            clearText(password);

            FileInputStream fis = new FileInputStream(new File("src/config.properties"));

            Properties prop = new Properties();
            prop.load(fis);
            String USERNAME = prop.getProperty("USERNAME");
            String PASSWORD = prop.getProperty("PASSWORD");
        
            username.sendKeys(USERNAME);
            password.sendKeys(PASSWORD);
            loginButton.click();
    
            assertEquals(dr.getTitle(), "Swag Labs");

        }
        catch(Exception e){
            tearDown();
            logger(e);
        }

    }

    public static void verifyProduct(){

        try{
            WaitTitleContains("Swag Labs");
            assertEquals(dr.getTitle(), "Swag Labs");
            tearDown();
        }
        catch(Exception e){
            tearDown();
            logger(e);
        }
    
    }
    
}