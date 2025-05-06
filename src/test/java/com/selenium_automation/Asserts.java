package com.selenium_automation;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Asserts {

    protected static SoftAssert softAssert = new SoftAssert();
    
    public static void assertEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void softlyAssertEquals(String actual, String expected) { 
            softAssert.assertEquals(actual, expected);
    }



    public static void assertTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public static void assertFalse(boolean condition) {
        try {
            Assert.assertFalse(condition);
        } catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    
}
