package com.selenium_automation;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.selenium_automation.CommonUtils.*;

public class Waits {

    //Fluent wait for page title
	protected static void waitTitle(String title) {
		try {
			new org.openqa.selenium.support.ui.FluentWait<>(dr)
				.withTimeout(java.time.Duration.ofSeconds(10))
				.pollingEvery(java.time.Duration.ofMillis(500))
				.ignoring(Exception.class)
				.until(ExpectedConditions.titleIs(title));
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	//Fluent wait for page title contains
	
	protected static void waitTitleContains(String title) {
		try {
			new org.openqa.selenium.support.ui.FluentWait<>(dr)
				.withTimeout(java.time.Duration.ofSeconds(10))
				.pollingEvery(java.time.Duration.ofMillis(500))
				.ignoring(Exception.class)
				.until(ExpectedConditions.titleContains(title));
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	protected static void waitVisibility(WebElement element) {
		try {
			new org.openqa.selenium.support.ui.FluentWait<>(dr)
				.withTimeout(java.time.Duration.ofSeconds(30))
				.pollingEvery(java.time.Duration.ofMillis(500))
				.ignoring(Exception.class)
				.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	// Wait for elements to be clickable
	protected static void waitClickable(WebElement element) {
		try {
			new org.openqa.selenium.support.ui.FluentWait<>(dr)
				.withTimeout(java.time.Duration.ofSeconds(30))
				.pollingEvery(java.time.Duration.ofMillis(500))
				.ignoring(Exception.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			System.out.println("TimeoutException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
    
}
