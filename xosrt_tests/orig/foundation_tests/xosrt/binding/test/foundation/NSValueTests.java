package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.CharArr;
import xosrt.binding.foundation.*;
import xosrt.binding.pointers.IntPtr;
import org.junit.Test;

public class NSValueTests {

    static {
        System.loadLibrary("Mac");
    }

    //TODO: need some kind of @encode directive
    /*
    @Test
    public void testValue_withObjCType1() {
        int n = 1;
        NSValue theValue = NSValue.valueWithObjCType(new IntPtr(n),
                encode(int));
        assertTrue(theValue != null);
    }

    @Test
    public void testInitWithBytes1() {
        NSValue  anotherValue = NSValue.alloc().initWithBytesObjCType(new CharArr("h".toCharArray()),
                encode(char));
        assertTrue(anotherValue != null) ;
    }
    */

}
