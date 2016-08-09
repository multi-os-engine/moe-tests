package org.moe.xosrt.binding.test.uikit;

import static org.junit.Assert.assertTrue;
import ios.foundation.NSOperationQueue;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;

import org.moe.xosrt.binding.test.uikit.controllers.UIAlertViewTestViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

public class UIAlertViewTests {

    static UIAlertViewTestViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIAlertViewTestViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testShow1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIAlertViewTestViewController.testShow1Passed;
            }
        }));
    }
    
    @Test
    public void testShow2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIAlertViewTestViewController.testShow2Passed;
            }
        }));
    }

    @Test
    public void testShow3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIAlertViewTestViewController.testShow3Passed;
            }
        }));
    }

    @Test
    public void testCheckDelegate() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIAlertViewTestViewController.checkDelegateMethodPassed;
            }
        }, 5000));
    }

    @Test
    public void testStaticCall() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIAlertViewTestViewController.testStaticCallPassed;
            }
        }, 5000));
    }


}
