package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import xosrt.binding.test.foundation.Utils.TestObject;
import xosrt.binding.test.foundation.Utils.ThreadTestTarget;
import org.junit.Test;

public class NSURLConnectionTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInitWithRequest_delegate1() throws NoSuchMethodException {
        ThreadTestTarget testNUC = ThreadTestTarget.alloc().init();
        NSThread t = NSThread.alloc().init(testNUC, ThreadTestTarget.class.getMethod("runURLConn"), null);

        t.start();
        while (t.isExecuting()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t.autorelease();
        assertTrue(testNUC.passed);
    }

    @Test
    public void testInitWithRequest_delegate2() throws NoSuchMethodException {
        ThreadTestTarget testNUC = ThreadTestTarget.alloc().init();
        NSThread t = NSThread.alloc().init(testNUC, ThreadTestTarget.class.getMethod("runURLConn"), null);

        t.start();
        while (t.isExecuting()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t.autorelease();
        assertTrue(testNUC.passed);
    }

    @Test
    public void testInitWithRequest_delegate3() throws NoSuchMethodException {
        ThreadTestTarget testNUC = ThreadTestTarget.alloc().init();
        NSThread t = NSThread.alloc().init(testNUC, ThreadTestTarget.class.getMethod("runURLConn"), null);

        t.start();
        while (t.isExecuting()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t.autorelease();
        assertTrue(testNUC.passed);
    }

}
