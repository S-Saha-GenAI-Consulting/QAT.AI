package commonutils;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Asserts {

    public static SoftAssert softAssert = new SoftAssert();
    
    public static void assertEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void softAssertEquals(String actual, String expected) { 
        softAssert.assertEquals(actual, expected);
    }

    public static void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    public static void softAssertTrue(boolean condition) {
        softAssert.assertTrue(condition);
    }

    public static void assertFalse(boolean condition) {
        Assert.assertFalse(condition);
    }

    public static void softAssertFalse(boolean condition) {
        softAssert.assertFalse(condition);
    }
    
    public static void assertAll() {
        softAssert.assertAll();
    }

    public static void assertNotEquals(String actual, String expected) {
        Assert.assertNotEquals(actual, expected);
    }

    public static void assertNotNull(Object object) {
        Assert.assertNotNull(object);
    }

    public static void assertNull(Object object) {
        Assert.assertNull(object);
    }
    
}
