package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;

import ios.foundation.*;
import org.junit.Test;

public class NSValueTests {

    //TODO: need some kind of @encode directive

    @Test
    public void testValue_withObjCType1() {
        int n = 1;
        NSValue theValue = NSValue.valueWithObjCType(PtrFactory.newIntReference(n), "int");
        assertTrue(theValue != null);
    }

    @Test
    public void testInitWithBytes1() {
        NSValue  anotherValue = NSValue.alloc().initWithBytesObjCType(PtrFactory.newCharReference('h'), "char");
        assertTrue(anotherValue != null) ;
    }


}
