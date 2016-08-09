package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIScrollViewViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UIScrollViewTests {

    static UIScrollViewViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIScrollViewViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testContentSize1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIScrollViewViewController.testContentSize1;
            }
        }, 5000));
    }

    @Test
    public void testScrollEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIScrollViewViewController.testScrollEnabled1;
            }
        }, 5000));
    }

    @Test
    public void testContentOffset1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIScrollViewViewController.testContentOffset1;
            }
        }, 5000));
    }

    @Test
    public void testShowsVerticalScrollIndicator1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIScrollViewViewController.testShowsVerticalScrollIndicator1;
            }
        }, 5000));
    }

    @Test
    public void testShowsHorizontalScrollIndicator1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIScrollViewViewController.testShowsHorizontalScrollIndicator1;
            }
        }, 5000));
    }

    @Test
    public void testScrollRectToVisible1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIScrollViewViewController.testScrollRectToVisible1;
            }
        }, 5000));
    }

    @Test
    public void testSetUserInteractionEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIScrollViewViewController.testSetUserInteractionEnabled1;
            }
        }, 5000));
    }

    @Test
    public void testSetContentOffset_animated2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIScrollViewViewController.testSetContentOffset_animated2;
            }
        }, 5000));
    }

}
