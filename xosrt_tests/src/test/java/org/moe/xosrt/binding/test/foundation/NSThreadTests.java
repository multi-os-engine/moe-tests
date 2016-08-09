package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.objc.SEL;

import static org.junit.Assert.*;

import ios.NSObject;
import ios.foundation.*;
import org.moe.xosrt.binding.test.foundation.Utils.ErrorTestObject;
import org.moe.xosrt.binding.test.foundation.Utils.ThreadTestTarget;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Before;
import org.junit.Test;

public class NSThreadTests extends XOSTest{

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
        aThread.setName("my Thread");
        assertTrue(aThread.name().equals("my Thread"));
    }

    @Test
    public void testStart1() throws NoSuchMethodException {
        ErrorTestObject arg1, arg2;

        arg1 = ErrorTestObject.alloc().init();
        arg1.setMyString(NSString.stringWithString("firstString"));
        arg2 = ErrorTestObject.alloc().init();
        arg2.setMyString(NSString.stringWithString("secondString"));

        NSObject args = NSObject.alloc().init();
        ThreadTestTarget target = ThreadTestTarget.alloc().init();

        NSThread uploadThread = NSThread.alloc().initWithTargetSelectorObject(target, new SEL("doHttp"), args);

        uploadThread.start();

        while (uploadThread.isExecuting()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        uploadThread.cancel();
        assertTrue(target.passed);
    }
}
