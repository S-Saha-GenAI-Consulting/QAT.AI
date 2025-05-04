package com.selenium_automation;

import org.openqa.selenium.WebDriver;


public class Base {    

	private static WebDriver driver;
	
	public static  WebDriver dr;

	public WebDriver getDriver(){
		dr = driver;
		return dr;
	}

	
}

