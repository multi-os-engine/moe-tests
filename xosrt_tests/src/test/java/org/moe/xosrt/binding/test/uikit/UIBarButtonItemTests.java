package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIBarButtonItemViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UIBarButtonItemTests {

    static UIBarButtonItemViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIBarButtonItemViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testInitWithBarButtonSystemItem_target_action1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIBarButtonItemViewController.testInitWithBarButtonSystemItem_target_action1;
            }
        }));
    }

    @Test
    public void testSetAction1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIBarButtonItemViewController.testSetAction1;
            }
        }));
    }

    @Test
    public void testInitWithTitle_style_target_action1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIBarButtonItemViewController.testInitWithTitle_style_target_action1;
            }
        }));
    }

    @Test
    public void testSetTarget1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIBarButtonItemViewController.testSetTarget1;
            }
        }));
    }

}
