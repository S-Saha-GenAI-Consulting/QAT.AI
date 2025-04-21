package com.selenium_automation;
//
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.selenium_automation.Driver.*;

public class Waits {

    protected static void WaitTitleContains(String title) {

		try {
			WebDriverWait wait = new WebDriverWait(dr, java.time.Duration.ofSeconds(10));
			wait.until(ExpectedConditions.titleContains(title));
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
	}
	

    protected static void WaitVisibility(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(dr, java.time.Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	//Wait for elements to be clickable
	protected static void WaitClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(dr, java.time.Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
    
}
