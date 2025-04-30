package com.selenium_automation;


import static com.selenium_automation.Driver.*;

import org.apache.logging.log4j.*;
import java.io.File;
import java.io.FileInputStream;


import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

    
public class CommonUtils{

    private static final Logger logger = LogManager.getLogger(CommonUtils.class);
    
    public static void getUrl(){

        try {
            FileInputStream fis = new FileInputStream(new File("/Users/sayantansaha/Downloads/QAT.AI/src/config.properties"));
            Properties prop = new Properties();
            prop.load(fis);

            String url = prop.getProperty("URL");
            dr.get(url);

        } catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage(), e);
        }

        
    }
    
    public static void tearDown() {
        dr.quit();

    }

    public static void logger(Exception e){
        
        logger.error("Exception occurred: {}", e.getMessage(), e);
        tearDown();
        logger.info("Driver closed");
    }

    public static void clearText(WebElement element){
        try{

            new Actions(dr)
            .keyDown(element, Keys.COMMAND)
            .sendKeys("a").keyUp(element, Keys.COMMAND)
            .pause(100)
            .sendKeys(Keys.DELETE)
            .build()
            .perform();
        }
        catch(Exception e){
            logger(e);
        }
    }
   
}
