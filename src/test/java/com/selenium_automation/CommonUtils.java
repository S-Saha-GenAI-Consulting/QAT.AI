package com.selenium_automation;


import static com.selenium_automation.Driver.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;


import java.util.Properties;

    
public class CommonUtils{

    private static final Logger logger = LogManager.getLogger(CommonUtils.class);
    
    public static void getUrl(){

        try {
            FileInputStream fis = new FileInputStream(new File("src/test/java/com/selenium_automation/Resources/config.properties"));
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

   
}
