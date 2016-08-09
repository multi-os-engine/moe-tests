package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSRangeTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testNSMakeRange1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        assertTrue(range != null );
    }

    @Test
    public void testLocation1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        assertTrue(range.getLocation() == 3);
    }

    @Test
    public void testSetLocation1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        range.setLocation(4);
        assertTrue(range.getLocation() == 4);
    }

    @Test
    public void testLength1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        assertTrue( range.getLength() == 2);
    }

    @Test
    public void testSetLength1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        range.setLength(5);
        assertTrue( range.getLength() == 5);
    }

}
