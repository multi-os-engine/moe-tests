package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIPageControlViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UIPageControlTests {

    static UIPageControlViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIPageControlViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testCurrentPage1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testCurrentPage1;
            }
        }));
    }

    @Test
    public void testNumberOfPages1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testNumberOfPages1;
            }
        }));
    }

    @Test
    public void testDefersCurrentPageDisplay1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testDefersCurrentPageDisplay1;
            }
        }));
    }

    @Test
    public void testDefersCurrentPageDisplay2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testDefersCurrentPageDisplay2;
            }
        }));
    }

    @Test
    public void testSizeForNumberOfPages1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testSizeForNumberOfPages1;
            }
        }));
    }

    @Test
    public void testHidesForSinglePage1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testHidesForSinglePage1;
            }
        }));
    }

    @Test
    public void testHidesForSinglePage2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testHidesForSinglePage2;
            }
        }));
    }

    @Test
    public void testUpdateCurrentPageDisplay1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testUpdateCurrentPageDisplay1;
            }
        }));
    }

    @Test
    public void testSetUserInteractionEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPageControlViewController.testSetUserInteractionEnabled1;
            }
        }));
    }

}
