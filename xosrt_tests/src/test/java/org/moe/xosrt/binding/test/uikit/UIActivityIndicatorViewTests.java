package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIActivityIndicatorViewTestViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;
import static org.junit.Assert.*;

public class UIActivityIndicatorViewTests {

    static UIActivityIndicatorViewTestViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIActivityIndicatorViewTestViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testHidesWhenStopped1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIActivityIndicatorViewTestViewController.hidesWhenStopped1Passed;
            }
        }));
    }

    @Test
    public void testStartAnimating1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIActivityIndicatorViewTestViewController.startAnimatingPassed;
            }
        }));
    }

    @Test
    public void testHidesWhenStopped2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIActivityIndicatorViewTestViewController.hidesWhenStopped2Passed;
            }
        }));
    }

    @Test
    public void testStopAnimating1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIActivityIndicatorViewTestViewController.stopAnimatingPassed;
            }
        }));
    }

    @AfterClass
    public static void ender() {
        ConditionWait.prepareConditionWait();
    }
}
