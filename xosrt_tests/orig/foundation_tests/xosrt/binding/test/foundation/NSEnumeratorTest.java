package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.NSArray;
import xosrt.binding.foundation.NSEnumerator;
import xosrt.binding.foundation.NSObject;

import xosrt.binding.foundation.NSString;
import org.junit.Test;

public class NSEnumeratorTest {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testNextObject1() throws Exception {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("1"),
                NSString.fromJavaString("2"),
                NSString.fromJavaString("3")
        });

        NSArray anArray = NSArray.arrayWithObjectsCount(arr, 3);
        /*NSEnumerator aEnumerator = anArray.objectEnumerator();
        NSObject value1 = aEnumerator.nextObject();
        NSObject value2 = aEnumerator.nextObject();
        NSObject value3 = aEnumerator.nextObject();

        assertTrue(value1.isEqual(NSString.fromJavaString("1"))
                && value2.isEqual(NSString.fromJavaString("2"))
                && value3.isEqual(NSString.fromJavaString("3")));*/
    }

    @Test
    public void testAllObjects1() throws Exception {
        /*IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("1"),
                NSString.fromJavaString("2"),
                NSString.fromJavaString("3")
        });
        NSArray anArray3 = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSEnumerator aEnumerator2 = anArray3.objectEnumerator();
        NSArray anArray2 = aEnumerator2.getAllObjects();

        assertTrue(anArray2.objectAtIndex(0).equals(NSString.fromJavaString("1"))
                && anArray2.objectAtIndex(1).equals(NSString.fromJavaString("2"))
                && anArray2.objectAtIndex(2).equals(NSString.fromJavaString("3")));*/
    }
}
