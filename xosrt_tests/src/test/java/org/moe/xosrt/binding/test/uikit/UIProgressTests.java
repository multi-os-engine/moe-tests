package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIProgressViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;
import ios.foundation.NSOperationQueue;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import static org.junit.Assert.assertTrue;

public class UIProgressTests {

    public static int WAIT_TIMEOUT = 2;

    static UIProgressViewController controller;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
		        UIWindow main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
		        controller = UIProgressViewController.alloc().init();
		        //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
		        main.setRootViewController(controller);
		        ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
		        main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testBecomeFirstResponder1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIProgressViewController.testInitWithProgressViewStyle1;
            }
        }));
    }

    @Test
    public void testBecomeFirstResponder2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIProgressViewController.testInitWithProgressViewStyle2;
            }
        }));
    }

    @Test
    public void testBecomeFirstResponder3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIProgressViewController.testInitWithProgressViewStyle3;
            }
        }));
    }

    @Test
    public void testBecomeFirstResponder4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIProgressViewController.testInitWithProgressViewStyle4;
            }
        }));
    }

    @Test
    public void testSetUserInteractionEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIProgressViewController.testSetUserInteractionEnabled1;
            }
        }));
    }

}
