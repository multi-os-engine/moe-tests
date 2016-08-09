package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.ConstPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;

import ios.foundation.NSArray;
import ios.foundation.NSEnumerator;

import ios.foundation.NSString;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSEnumeratorTest extends XOSTest {

    @Test
    public void testNextObject1() throws Exception {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[]{
                NSString.stringWithString("1"),
                NSString.stringWithString("2"),
                NSString.stringWithString("3")
        });

        NSArray anArray = NSArray.arrayWithObjectsCount(arr, 3);
        NSEnumerator aEnumerator = anArray.objectEnumerator();
        String value1 = (String)aEnumerator.nextObject();
        String value2 = (String)aEnumerator.nextObject();
        String value3 = (String)aEnumerator.nextObject();

        assertTrue(value1.equals("1")
                && value2.equals("2")
                && value3.equals("3"));
    }

    @Test
    public void testAllObjects1() throws Exception {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("1"),
                NSString.stringWithString("2"),
                NSString.stringWithString("3")
        });
        NSArray anArray3 = NSArray.alloc().initWithObjectsCount((ConstPtr)arr, 3);
        NSEnumerator aEnumerator2 = anArray3.objectEnumerator();
        NSArray anArray2 = aEnumerator2.allObjects();

        assertTrue(anArray2.objectAtIndex(0).equals("1")
                && anArray2.objectAtIndex(1).equals("2")
                && anArray2.objectAtIndex(2).equals("3"));
    }
}
