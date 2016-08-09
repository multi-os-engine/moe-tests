package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSUserDefaultsTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testStandardUserDefaults1() {
        NSUserDefaults userD = NSUserDefaults.standardUserDefaults();
        assertTrue (userD == null);
    }

    @Test
    public void testSetBool_forKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        boolean aBool = true;
        userPreferences.setBoolForKey(aBool, NSString.fromJavaString("one"));
        boolean anotherBool = userPreferences.boolForKey(NSString.fromJavaString("one"));
        assertTrue (anotherBool);
    }

    @Test
    public void testBoolForKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        boolean aBool = false;
        userPreferences.setBoolForKey(aBool, NSString.fromJavaString("three"));
        boolean anotherBool = userPreferences.boolForKey(NSString.fromJavaString("three"));
        assertFalse(anotherBool);
    }

    @Test
    public void testSetObject_forKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        NSString  object1 = NSString.fromJavaString("object1");
        userPreferences.setObjectForKey(object1, NSString.fromJavaString("key"));

        assertTrue (userPreferences.objectForKey(NSString.fromJavaString("key")) == object1);
    }

    @Test
    public void testObjectForKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        NSString  object2 = NSString.fromJavaString("object2");
        userPreferences.setObjectForKey(object2, NSString.fromJavaString("key2"));

        assertTrue (userPreferences.objectForKey(NSString.fromJavaString("key2")) == object2);
    }

    @Test
    public void testStringForKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        NSString  object2 = NSString.fromJavaString("object2");
        userPreferences.setObjectForKey(object2, NSString.fromJavaString("key2"));
        assertTrue(userPreferences.stringForKey(NSString.fromJavaString("key2"))
                .isEqualToString(NSString.fromJavaString("object2")));
    }

    @Test
    public void testRemoveObjectForKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        NSString  object2 = NSString.fromJavaString("object2");
        userPreferences.setObjectForKey(object2, NSString.fromJavaString("key2"));
        userPreferences.removeObjectForKey(NSString.fromJavaString("key2"));

        assertTrue (userPreferences.stringForKey(NSString.fromJavaString("key2")) == null);
    }

    @Test
    public void testSynchronize1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        boolean anotherBool = userPreferences.synchronize();
        assertTrue(anotherBool) ;
    }

}
