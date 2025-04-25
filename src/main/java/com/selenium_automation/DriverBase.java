package com.selenium_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.*;



public class DriverBase extends Base {

    private static final Logger logger = LogManager.getLogger(DriverBase.class);

    public static WebDriver setUp() {

        try{
            FileInputStream fis = new FileInputStream(new File("src/config.properties"));
            Properties prop = new Properties();
            prop.load(fis);
            prop.getProperty("driverpath");
        }
        catch (Exception e){
            logger.error("Exception occurred: {}", e.getMessage(), e);
        }

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
