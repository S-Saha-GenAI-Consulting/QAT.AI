package com.selenium_automation;

import static com.selenium_automation.CommonUtils.*;
import static com.selenium_automation.Waits.*;
import static com.selenium_automation.Asserts.*;
import static com.selenium_automation.Driver.dr;

import static com.selenium_automation.PageFactories.LoginPage.*;


import org.openqa.selenium.Keys;
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

            username.sendKeys("abcd");
            username.clear();
        
            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
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
