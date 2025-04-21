package com.selenium_automation;

import org.openqa.selenium.WebDriver;


public class Base {    

	private static WebDriver driver;
	
	protected static WebDriver dr;

	protected WebDriver getDriver(){
		dr = driver;
		return dr;
	}

	
}

