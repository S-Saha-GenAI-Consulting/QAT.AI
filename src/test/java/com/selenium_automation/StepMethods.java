package com.selenium_automation;

import static com.selenium_automation.CommonUtils.*;
import static com.selenium_automation.Waits.*;

import java.io.FileInputStream;
import java.io.File;


import java.util.Properties;
import org.openqa.selenium.support.ui.Select;

import static com.selenium_automation.Asserts.*;

import static com.selenium_automation.PageFactories.LoginPage.*;
import static com.selenium_automation.PageFactories.ProductPage.*;

import static com.selenium_automation.ExtentReportUtil.*;


public class StepMethods{


    public static void launchPageTitle(){

        try{

            createAndGetTest("Login Page Test");
            
            WaitTitleContains("Swag Labs");
            System.out.println("Page title is: " + dr.getTitle());
            softAssertEquals(dr.getTitle(), "Swag Labs");
        }
        catch(Exception e){
            logger(e);
        }
    }

    public static void loginMethod(){

        try{

            createAndGetTest("Login Page Test");
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
    
            softAssertEquals(dr.getTitle(), "Swag Labs");

            Thread.sleep(3000);


        }
        catch(Exception e){
            logger(e);
        }

    }

    public static void verifyProduct(){

        try{

            createAndGetTest("Login Page Test");

            WaitTitleContains("Swag Labs");
            softAssertEquals(dr.getTitle(), "Swag Labs");
            Thread.sleep(3000);
            
            new Select(sortBy).selectByVisibleText("Price (high to low)");
            Thread.sleep(3000);

            scrollAction(SauceLabsOnesie);
            softAssertEquals(SauceLabsOnesie.getText(), "Sauce Labs Onesie");
            Thread.sleep(3000);
            SauceLabsOnesie.click();
            Thread.sleep(3000);
            

        }
        catch(Exception e){
            logger(e);
        }
    
    }
    
}