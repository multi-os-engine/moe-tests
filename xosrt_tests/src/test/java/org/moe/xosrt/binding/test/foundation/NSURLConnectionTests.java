package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.objc.SEL;

import static org.junit.Assert.*;
import ios.foundation.*;

import org.moe.xosrt.binding.test.foundation.Utils.ThreadTestTarget;
import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
//TODO:org.moe.natj.objc.ObjCException: target does not implement selector "runURLConn"
//It's a pure java method
//Test should be rewritten
public class NSURLConnectionTests extends XOSTest{

    @Test
    public void testInitWithRequest_delegate1() throws NoSuchMethodException {
        ThreadTestTarget testNUC = ThreadTestTarget.alloc().init();
        NSThread t = NSThread.alloc().initWithTargetSelectorObject(testNUC, new SEL("runURLConn"), null);

        t.start();
        while (t.isExecuting()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertTrue(testNUC.passed);
    }

    @Test
    public void testInitWithRequest_delegate2() throws NoSuchMethodException {
        ThreadTestTarget testNUC = ThreadTestTarget.alloc().init();
        NSThread t = NSThread.alloc().initWithTargetSelectorObject(testNUC, new SEL("runURLConn2"), null);

        t.start();
        while (t.isExecuting()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertTrue(testNUC.passed);
    }

    @Test
    public void testInitWithRequest_delegate3() throws NoSuchMethodException {
        ThreadTestTarget testNUC = ThreadTestTarget.alloc().init();
        NSThread t = NSThread.alloc().initWithTargetSelectorObject(testNUC, new SEL("runURLConn3"), null);

        t.start();
        while (t.isExecuting()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertTrue(testNUC.passed);
    }

}
