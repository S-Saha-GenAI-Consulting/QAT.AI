package com.selenium_automation;


import static com.selenium_automation.Asserts.assertEquals;
import static com.selenium_automation.Driver.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

    
public class CommonUtils{

    private static final Logger logger = LogManager.getLogger(CommonUtils.class);

    public static void getUrl(){
        dr.get("https://www.saucedemo.com/");
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
