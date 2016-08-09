package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSObjectTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInit1() {
        NSObject object = NSObject.alloc().init();
        assertTrue (object != null);
    }

    @Test
    public void testNSStringFromClass1() {
        NSString objectClassName = Foundation.NSStringFromClass(NSObject.class);
        NSString stringClassName = Foundation.NSStringFromClass(NSString.class);

        assertTrue(objectClassName.isEqualToString(NSString.fromJavaString("NSObject"))
                && stringClassName.isEqualToString(NSString.fromJavaString("NSString")));
    }
}
