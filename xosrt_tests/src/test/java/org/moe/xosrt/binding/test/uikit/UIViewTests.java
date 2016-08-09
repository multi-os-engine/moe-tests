package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.viewTest.ViewController0;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

//@Ignore // May cause crush
public class UIViewTests {

    public static int WAIT_TIMEOUT = 12000;

    static ViewController0 controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
        controller = ViewController0.alloc().init();
        main.setRootViewController(controller);
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void test1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return ViewController0.test1Passed;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void test2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return ViewController0.test2Passed;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void test3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return ViewController0.test3Passed;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testAddSubview() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return ViewController0.testAddSubviewPassed;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInsertSubViewAtIndex() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return ViewController0.testInsertSubViewAtIndexPassed;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInsertSubviewAboveSubView() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return ViewController0.testInsertSubviewAboveSubViewPassed;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInsertSubViewBelowSubView() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return ViewController0.testInsertSubViewBelowSubViewPassed;
            }
        }, 2 * WAIT_TIMEOUT));
    }

    @Test
    public void testRemoveSubView() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return ViewController0.testRemoveSubViewPassed;
            }
        }, WAIT_TIMEOUT));
    }

}
