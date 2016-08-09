package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UINavigationItemViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UINavigationItemTests {

    static UINavigationItemViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UINavigationItemViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testInitWithTitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testInitWithTitle1;
            }
        }));
    }

    @Test
    public void testTitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testTitle1;
            }
        }));
    }

    @Test
    public void testPrompt1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testPrompt1;
            }
        }));
    }

    @Test
    public void testHidesBackButton1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testHidesBackButton1;
            }
        }));
    }

    @Test
    public void testLeftItemsSupplementBackButton1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testLeftItemsSupplementBackButton1;
            }
        }));
    }

    @Test
    public void testBackBarButtonItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testBackBarButtonItem1;
            }
        }));
    }

    @Test
    public void testLeftBarButtonItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testLeftBarButtonItem1;
            }
        }));
    }

    @Test
    public void testRightBarButtonItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testRightBarButtonItem1;
            }
        }));
    }

    @Test
    public void testLeftBarButtonItems1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testLeftBarButtonItems1;
            }
        }));
    }

    @Test
    public void testRightBarButtonItems1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationItemViewController.testRightBarButtonItems1;
            }
        }));
    }

}
