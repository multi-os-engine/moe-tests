package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.NSNull;

import org.junit.Test;

public class NSNullTests {

    @Test
    public void testNull1() {
        NSNull null0 = NSNull.null_objc();
        NSNull null1 = NSNull.null_objc();
        assertTrue (null0 == null1) ;
    }

    @Test
    public void testDescription1() {
        NSNull null2 = NSNull.null_objc();
        assertTrue ("<null>".equals(null2.description()));
    }

}
