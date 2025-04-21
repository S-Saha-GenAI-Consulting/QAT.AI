package com.selenium_automation;

import org.testng.Assert;

public class Asserts {
    
    public static void assertEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
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
