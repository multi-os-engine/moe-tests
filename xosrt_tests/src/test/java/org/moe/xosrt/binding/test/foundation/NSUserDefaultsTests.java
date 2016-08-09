package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.*;

import org.junit.Test;

public class NSUserDefaultsTests {

    @Test
    public void testStandardUserDefaults1() {
        NSUserDefaults userD = NSUserDefaults.standardUserDefaults();
        assertTrue (userD != null); // == in objective C tests
    }

    @Test
    public void testSetBool_forKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        boolean aBool = true;
        userPreferences.setBoolForKey(aBool, "one");
        boolean anotherBool = userPreferences.boolForKey("one");
        assertTrue (anotherBool);
    }

    @Test
    public void testBoolForKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        boolean aBool = false;
        userPreferences.setBoolForKey(aBool, "three");
        boolean anotherBool = userPreferences.boolForKey("three");
        assertFalse(anotherBool);
    }

    @Test
    public void testSetObject_forKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        NSString object1 = NSString.stringWithString("object1");
        userPreferences.setObjectForKey(object1, "key");

        assertTrue (userPreferences.objectForKey("key").equals(object1.toString()));
    }

    @Test
    public void testObjectForKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        NSMutableString object2 = NSMutableString.stringWithString("object2");
        userPreferences.setObjectForKey(object2, "key2");
        boolean wasEqual = (userPreferences.objectForKey("key2").equals(object2.toString()));
        object2.appendString("_!");
        assertTrue (wasEqual && !userPreferences.objectForKey("key2").equals(object2.toString()));
    }

    @Test
    public void testStringForKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        NSString  object2 = NSString.stringWithString("object2");
        userPreferences.setObjectForKey(object2, "key2");
        assertTrue(userPreferences.stringForKey("key2").equals("object2"));
    }

    @Test
    public void testRemoveObjectForKey1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        NSString  object2 = NSString.stringWithString("object2");
        userPreferences.setObjectForKey(object2, "key2");
        userPreferences.removeObjectForKey("key2");

        assertTrue (userPreferences.stringForKey("key2") == null);
    }

    @Test
    public void testSynchronize1() {
        NSUserDefaults userPreferences = NSUserDefaults.standardUserDefaults();
        boolean anotherBool = userPreferences.synchronize();
        assertTrue(anotherBool);
    }

}
