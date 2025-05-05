package com.selenium_automation.PageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {

    @FindBy(xpath = "//*[text()='Sauce Labs Onesie']")
    public static WebElement SauceLabsOnesie;
    
}
