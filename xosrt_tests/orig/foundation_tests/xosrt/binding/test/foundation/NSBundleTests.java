package xosrt.binding.test.foundation;

import xosrt.binding.foundation.NSBundle;
import xosrt.binding.foundation.NSString;
import org.junit.Test;

import static org.junit.Assert.*;

public class NSBundleTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testMainBundle() {
        NSBundle bundle = NSBundle.alloc().init();
        bundle = NSBundle.mainBundle();
        assertTrue(bundle != null);
    }

    @Test
    public void testPathForResourceOfType() {
        //TODO: implement

    }

    @Test
    public void testPathForResourceOfTypeInDirectory() {
        //TODO: implement
    }

    @Test
    public void testresourcePath() {
        NSString str = NSBundle.mainBundle().getResourcePath();
        assertTrue(str != null);
    }
}
