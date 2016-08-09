package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestViewColorBlueViewController;
import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class XIBTestViewColorBlueTests {

    static XIBTestViewColorBlueViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestViewColorBlueViewController) XIBTestViewColorBlueViewController.alloc()
                        .initWithNibNameBundle("XIBTestViewColorBlueViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testBackgroundColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewColorBlueViewController.testBackgroundColor1;
            }
        }));
    }

    @Test
    public void testBackgroundColor2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewColorBlueViewController.testBackgroundColor2;
            }
        }));
    }

    @Test
    public void testAlpha1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewColorBlueViewController.testAlpha1;
            }
        }));
    }

    @Test
    public void testAlpha2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewColorBlueViewController.testAlpha2;
            }
        }));
    }

    @Test
    public void testAlpha3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewColorBlueViewController.testAlpha3;
            }
        }));
    }

}
