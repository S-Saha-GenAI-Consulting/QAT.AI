package com.selenium_automation;

import java.io.IOException;
import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.support.PageFactory;

import com.selenium_automation.PageFactories.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

import static com.selenium_automation.Asserts.*;

@CucumberOptions(
    plugin = {
        "pretty", // Makes the console output more readable
        "json:target/reports/json.json", // Generates JSON report
        "html:target/reports/html.html" // Generates HTML report
    },
    monochrome = true, // Makes console output more readable by removing ANSI colors
    features = {"src/test/java/com/selenium_automation/Resources"}, // Path to feature files
    glue = {"com.selenium_automation.Steps"}, // Path to step definitions
    dryRun = false, // Set to true to check if all steps have definitions without executing them
    tags = "@Swag_Labs" // Executes scenarios with this tag
)
public class RunnerTest extends AbstractTestNGCucumberTests {

    {
        // Call startup method before tests
        CommonUtils.startUp();
        
        // Initialize PageFactory elements for all page classes
        PageFactory.initElements(CommonUtils.dr, LoginPage.class);
        PageFactory.initElements(CommonUtils.dr, Sidebar.class);
        PageFactory.initElements(CommonUtils.dr, ProductPage.class);

        // Add a shutdown hook to ensure teardown is called after tests
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            this.cleanUp();
        }));
    }

    /**
     * Clears all static instances after test execution.
     */
    private void cleanUp() {
        try { 
            // Perform WebDriver cleanup
            CommonUtils.tearDown();

            // Ensure all soft assertions are checked
            try {
                softAssert.assertAll();
            } 
            catch (AssertionError e) {
                // Log soft assertion failure in Extent Report
                ExtentReportUtil.createAndGetTest("Soft Assertion Failure").fail("Soft assertion failed: " + e.getMessage());
                throw e;
            } 
            finally {
                // Flush Extent Report
                ExtentReportUtil.flushReport();

                try {
                    Thread.sleep(3000);
                } 
                catch (InterruptedException e) {
                    System.err.println("Thread sleep was interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                }

                // Open the Extent Report in the default browser
                try {
                    File reportFile = new File("target/ExtentReport.html");
                    if (reportFile.exists()) {
                        Desktop.getDesktop().browse(reportFile.toURI());
                        System.out.println("Extent Report opened in the default browser.");
                    } 
                    else {
                        System.err.println("Extent Report file not found: " + reportFile.getAbsolutePath());
                    }
                } 
                catch (IOException e) {
                    System.err.println("Failed to open Extent Report in browser: " + e.getMessage());
                }

                // Clear static references in LoginPage
                for (java.lang.reflect.Field field : LoginPage.class.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && !java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true); // Make the field accessible
                        field.set(null, null); // Set the static field to null
                    }
                }

                for (java.lang.reflect.Field field : Waits.class.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && !java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true); // Make the field accessible
                        field.set(null, null); // Set the static field to null
                    }
                }

                for (java.lang.reflect.Field field : Asserts.class.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && !java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true); // Make the field accessible
                        field.set(null, null); // Set the static field to null
                    }
                }

                // Clear static references in DriverBase
                for (java.lang.reflect.Field field : DriverBase.class.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && !java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true); // Make the field accessible
                        field.set(null, null); // Set the static field to null
                    }
                }

                // Clear static references in Base
                for (java.lang.reflect.Field field : Base.class.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && !java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true); // Make the field accessible
                        field.set(null, null); // Set the static field to null
                    }
                }

                // Clear static references in CommonUtils
                for (java.lang.reflect.Field field : CommonUtils.class.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && !java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true); // Make the field accessible
                        field.set(null, null); // Set the static field to null
                    }
                }

                System.out.println("All static instances have been cleared.");
            }
        } 
        catch (Exception e) {
            System.err.println("Error while clearing static instances: " + e.getMessage());
        }
    }

    @BeforeClass
    public void startReport() {
        // Initialize Extent Report
        ExtentReportUtil.initializeReport();
    }

}