package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIViewAnimationBasicViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UIViewAnimationBasicTests {

    public static int WAIT_TIMEOUT = 10000;

    static UIViewAnimationBasicViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIViewAnimationBasicViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testSetAnimationDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewAnimationBasicViewController.testSetAnimationDelegate1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetAnimationWillStartSelector1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewAnimationBasicViewController.testSetAnimationWillStartSelector1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetAnimationDidStopSelector1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewAnimationBasicViewController.testSetAnimationDidStopSelector1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testBeginAnimations_context1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewAnimationBasicViewController.testBeginAnimations_context1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testCommitAnimations1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewAnimationBasicViewController.testCommitAnimations1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetAnimationDuration1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewAnimationBasicViewController.testSetAnimationDuration1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetAnimationDuration2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewAnimationBasicViewController.testSetAnimationDuration2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetAnimationDelay1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewAnimationBasicViewController.testSetAnimationDelay1;
            }
        }, WAIT_TIMEOUT));
    }

}
