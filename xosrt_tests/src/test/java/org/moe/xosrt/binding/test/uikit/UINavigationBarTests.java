package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UINavigationBarViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UINavigationBarTests {

    static UINavigationBarViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UINavigationBarViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testItems1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testItems1;
            }
        }, 10000));
    }

    @Test
    public void testTopItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testTopItem1;
            }
        }, 10000));
    }

    @Test
    public void testBackItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testBackItem1;
            }
        }, 10000));
    }

    @Test
    public void testBarStyle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testBarStyle1;
            }
        }, 10000));
    }

    @Test
    public void testPushNavigationItem_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testPushNavigationItem_animated1;
            }
        }, 10000));
    }

    @Test
    public void testPopNavigationItemAnimated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testPopNavigationItemAnimated1;
            }
        }, 10000));
    }

    @Test
    public void testSetItems_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testSetItems_animated1;
            }
        }, 10000));
    }

    @Test
    public void testDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testDelegate1;
            }
        }, 10000));
    }

    @Test
    public void testDelegate2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationBarViewController.testDelegate2;
            }
        }, 10000));
    }

}
