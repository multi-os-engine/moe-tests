package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import xosrt.binding.test.foundation.Utils.ErrorTestObject;
import xosrt.binding.test.foundation.Utils.ThreadTestTarget;
import org.junit.Before;
import org.junit.Test;

public class NSThreadTests {

    static {
        System.loadLibrary("Mac");
    }

    static int i = 0;

    @Before
    public void initTests() {

    }

    @Test
    public void testMain1() {
        NSThread aThread = NSThread.alloc().init();
        assertTrue(aThread != null);
    }

    @Test
    public void testSetName1() {
        NSThread aThread = NSThread.alloc().init();
        aThread.setName(NSString.fromJavaString("my Thread"));
        assertTrue(aThread.getName().isEqualToString(NSString.fromJavaString("my Thread")));
    }

    @Test
    public void testStart1() throws NoSuchMethodException {
        ErrorTestObject arg1, arg2;

        arg1 = ErrorTestObject.alloc().init();
        arg1.setMyString(NSString.fromJavaString("firstString"));
        arg2 = ErrorTestObject.alloc().init();
        arg2.setMyString(NSString.fromJavaString("secondString"));

        NSObject args = NSObject.alloc().init();
        ThreadTestTarget target = ThreadTestTarget.alloc().init();

        NSThread uploadThread = NSThread.alloc().init(target, ThreadTestTarget.class.getMethod("doHttp"), args);

        uploadThread.start();

        while (uploadThread.isExecuting()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        uploadThread.cancel();
        assertTrue(target.passed);
    }
}
