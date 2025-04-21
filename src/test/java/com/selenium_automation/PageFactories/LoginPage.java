package com.selenium_automation.PageFactories;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.selenium_automation.Driver.dr;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(dr, this);
    }

    @FindBy(id = "user-name")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "login-button")
    public WebElement loginButton;

 
    
}
