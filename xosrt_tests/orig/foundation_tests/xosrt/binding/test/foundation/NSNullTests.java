package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSNullTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testNull1() {
        NSNull null0 = NSNull.getNull();
        NSNull null1 = NSNull.getNull();
        assertTrue (null0 == null1) ;
    }

    @Test
    public void testDescription1() {
        NSNull null2 = NSNull.getNull();
        assertTrue (NSString.fromJavaString("<null>").isEqualToString(null2.description()));
    }

}
