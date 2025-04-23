package com.selenium_automation;

import static com.selenium_automation.CommonUtils.*;
import static com.selenium_automation.Waits.*;
import static com.selenium_automation.Asserts.*;
import static com.selenium_automation.Driver.dr;

import static com.selenium_automation.PageFactories.LoginPage.*;

//import selenium keys
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium_automation.PageFactories.LoginPage;




public class StepMethods{

    /*public void LoginPage() {
        
    }*/



    public static void loginTitle(){
        getUrl();
        PageFactory.initElements(dr, LoginPage.class);
        WaitTitleContains("Swag Labs");
        System.out.println("Page title is: " + dr.getTitle());
        assertEquals(dr.getTitle(), "Swag Labs");

    }

    public static void loginMethod(){
        
        username.sendKeys("abcd");
        username.clear();
    
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        assertEquals(dr.getTitle(), "Swag Labs");
    }

    public static void verifyProduct(){
        WaitTitleContains("Swag Labs");
        assertEquals(dr.getTitle(), "Swag Labs");
        tearDown();
    }
    
}
