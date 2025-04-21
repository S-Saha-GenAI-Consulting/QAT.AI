package com.selenium_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverBase extends Base {

    public static WebDriver setUp() {
        
        System.setProperty("webdriver.gecko.driver", "src/main/java/com/selenium_automation/resources/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-extensions");


        dr = new FirefoxDriver(options);

        dr.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        dr.manage().deleteAllCookies();

        dr.manage().window().maximize();
        return dr;
    }
}
