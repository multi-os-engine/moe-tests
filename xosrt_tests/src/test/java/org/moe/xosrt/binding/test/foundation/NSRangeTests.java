package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.c.Foundation;
import ios.foundation.struct.NSRange;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSRangeTests extends XOSTest{

    @Test
    public void testNSMakeRange1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        assertTrue(range != null );
    }

    @Test
    public void testLocation1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        assertTrue(range.location() == 3);
    }

    @Test
    public void testSetLocation1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        range.setLocation(4);
        assertTrue(range.location() == 4);
    }

    @Test
    public void testLength1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        assertTrue( range.length() == 2);
    }

    @Test
    public void testSetLength1() {
        NSRange range = Foundation.NSMakeRange(3, 2);
        range.setLength(5);
        assertTrue( range.length() == 5);
    }

}
