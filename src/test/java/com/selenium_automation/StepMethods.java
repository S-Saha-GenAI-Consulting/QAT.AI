package com.selenium_automation;

import static com.selenium_automation.CommonUtils.*;
import static com.selenium_automation.Waits.*;
import static com.selenium_automation.Asserts.*;
import static com.selenium_automation.Driver.dr;

import com.selenium_automation.PageFactories.LoginPage;

//import selenium keys
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;




public class StepMethods{

    static LoginPage login = new LoginPage();


    public static void loginTitle(){
        getUrl();
        WaitTitleContains("Swag Labs");
        String title = dr.getTitle();
        System.out.println("Page title is: " + title);
        assertEquals(title, "Swag Labs");

    }

    public static void loginMethod(){
        
        login.username.sendKeys("abcd");
        login.username.clear();
    
        login.username.sendKeys("standard_user");
        login.password.sendKeys("secret_sauce");
        login.loginButton.click();

        assertEquals(dr.getTitle(), "Swag Labs");
    }

    public static void verifyProduct(){
        WaitTitleContains("Swag Labs");
        assertEquals(dr.getTitle(), "Swag Labs");
        tearDown();
    }
    
}
