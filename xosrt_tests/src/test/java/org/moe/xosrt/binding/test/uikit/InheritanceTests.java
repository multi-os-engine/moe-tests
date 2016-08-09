package org.moe.xosrt.binding.test.uikit;

import static org.junit.Assert.*;

import org.moe.xosrt.binding.test.uikit.testhelpers.Subclass;
import org.moe.xosrt.binding.test.uikit.testhelpers.SuperClass;
import org.junit.Test;

import ios.foundation.NSMutableArray;
import ios.foundation.NSString;

public class InheritanceTests {

    public static int WAIT_TIMEOUT = 0;

    public static void starter() {}

    @Test
    public void testInheritance() {
        Subclass subClassObject = Subclass.alloc().init();
        subClassObject.methodB();
        NSMutableArray array = SuperClass.methodExecutedArray();

        assertTrue("0", NSString.stringWithString("SubClass methodB").isEqualToString((array.objectAtIndex(0).toString())));
        assertTrue("1", NSString.stringWithString("SuperClass methodB").isEqualToString((array.objectAtIndex(1).toString())));
        assertTrue("2", NSString.stringWithString("SubClass methodA").isEqualToString((array.objectAtIndex(2).toString())));
        assertTrue("3", NSString.stringWithString("SuperClass methodA").isEqualToString((array.objectAtIndex(3).toString())));
    }
}
