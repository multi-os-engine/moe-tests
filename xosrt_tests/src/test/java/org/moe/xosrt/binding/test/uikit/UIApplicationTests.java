package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIApplicationViewController;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;


public class UIApplicationTests {

    static UIApplicationViewController controller;

    public static int WAIT_TIMEOUT = 3000;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                UIWindow main = (UIWindow) UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIApplicationViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Ignore
    @Test
    public void testSharedApplication() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return UIApplicationViewController.testSharedApplication;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testOpenURL1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return UIApplicationViewController.testOpenURL1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testOpenURL2() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return UIApplicationViewController.testOpenURL2;
            }
        }, WAIT_TIMEOUT));
    }

    //TODO: fails on simulator!
    @Ignore
    @Test
    public void testOpenURL3() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return UIApplicationViewController.testOpenURL3;
            }
        }, WAIT_TIMEOUT));
    }

    //TODO: fails on simulator!
    @Ignore
    @Test
    public void testOpenURL4() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return UIApplicationViewController.testOpenURL4;
            }
        }, WAIT_TIMEOUT));
    }

    //TODO: fails on simulator!
    @Ignore
    @Test
    public void testOpenURL5() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return UIApplicationViewController.testOpenURL5;
            }
        }, WAIT_TIMEOUT));
    }

    /*@Ignore
    @Test
    public void testDelegate() {
        assertTrue(NewTestRunner.testWillResignActive);
        assertTrue(NewTestRunner.testDidBecomeActive);
        assertTrue(NewTestRunner.testDidEnterBackground);
        //assertTrue(NewTestRunner.testWillEnterForeground);
            //&& NewTestRunner.testWillTerminate //Not sure it should be called
    }*/
}
