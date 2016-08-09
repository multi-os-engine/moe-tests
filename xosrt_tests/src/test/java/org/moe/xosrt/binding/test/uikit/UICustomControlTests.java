package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UICustomControlsViewController;
import org.junit.BeforeClass;
import org.junit.Ignore;
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


@Ignore // May cause crush
public class UICustomControlTests {

    public static int WAIT_TIMEOUT = 3;

    static UICustomControlsViewController controller;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
    	
		        UIWindow main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
		        controller = UICustomControlsViewController.alloc().init();
		        //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
		        main.setRootViewController(controller);
		        ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
		        main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testAddSubview1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UICustomControlsViewController.testAddSubview1;
            }
        }, 5000));
    }

    @Test
    public void testAddSubview2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UICustomControlsViewController.testAddSubview2;
            }
        }, 5000));
    }

    @Test
    public void testAddTargetAction1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UICustomControlsViewController.testAddTargetAction1;
            }
        }, 10000));
    }

    @Test
    public void testAddTargetAction2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UICustomControlsViewController.testAddTargetAction2;
            }
        }, 5000));
    }
}
