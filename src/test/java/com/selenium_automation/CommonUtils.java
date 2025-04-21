package com.selenium_automation;


import static com.selenium_automation.Driver.*;

public class CommonUtils{

    public static void getUrl(){
        dr.get("https://www.saucedemo.com/");
    }
    
    public static void tearDown() {
        dr.quit();

    }
}
