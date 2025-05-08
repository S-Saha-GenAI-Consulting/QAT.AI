package com.selenium_automation;

import org.openqa.selenium.WebDriver;


public class Base {    

	public static WebDriver dr;
	private static WebDriver driver;

	public WebDriver getDriver() {
		dr = driver;
		return dr;
	}
	
}

