package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.NSObject;
import ios.foundation.NSString;
import ios.foundation.c.Foundation;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSObjectTests extends XOSTest{

    @Test
    public void testInit1() {
        NSObject object = NSObject.alloc().init();
        assertTrue (object != null);
    }

    @Test
    public void testNSStringFromClass1() {
        String objectClassName = Foundation.NSStringFromClass(NSObject.alloc().init().classForCoder());
        String stringClassName = Foundation.NSStringFromClass(NSString.alloc().init().classForCoder());

        assertEquals( "NSObject", objectClassName);
        assertEquals( "NSString", stringClassName);
    }
}
