package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestButtonLabel1ViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

public class XIBTestButtonLabel1Tests {

    public static UIViewController controller = null;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                UIWindow main = (UIWindow) UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = XIBTestButtonLabel1ViewController.alloc().initWithNibNameBundle("XIBTestButtonLabel1ViewController", null);
                //UIKit.UIApplicationMain(0, null, null, AppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testFrame1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabel1ViewController.testFrame1;
            }
        }));
    }

    @Test
    public void testFrame2() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabel1ViewController.testFrame2;
            }
        }));
    }

    @Test
    public void testText1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabel1ViewController.testText1;
            }
        }));
    }

    @Test
    public void testText2() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabel1ViewController.testText2;
            }
        }));
    }

    @Test
    public void testTitleForState1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabel1ViewController.testTitleForState1;
            }
        }));
    }

}
