package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestSearchViewController;
import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class XIBTestSearchTests {

    static XIBTestSearchViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestSearchViewController)XIBTestSearchViewController.alloc()
                        .initWithNibNameBundle("XIBTestSearchViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testText1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestSearchViewController.testText1;
            }
        }));
    }

    @Test
    public void testPlaceholder1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestSearchViewController.testPlaceholder1;
            }
        }));
    }

    @Test
    public void testFrame1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestSearchViewController.testFrame1;
            }
        }));
    }

    @Test
    public void testAlpha1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestSearchViewController.testAlpha1;
            }
        }));
    }

}
