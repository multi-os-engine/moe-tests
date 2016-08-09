package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UISplitViewControllerViewController;
import org.moe.xosrt.binding.test.uikit.testhelpers.UISplitRightViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import tools.ConditionWait;
import tools.ConditionWait.Condition;
import static org.junit.Assert.*;

public class UISplitViewControllerTests {

    static UISplitViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                UIWindow main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                UISplitViewControllerViewController leftViewController = UISplitViewControllerViewController.alloc().init();
                UISplitRightViewController rightViewController = UISplitRightViewController.alloc().init();
                controller = UISplitViewController.alloc().init();
                controller.setViewControllers(NSArray.alloc().initWithObjectsCount(
                        (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[] {
                                leftViewController, rightViewController
                        }), 2)
                );
                leftViewController.splitViewController = controller;
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Ignore
    @Test
    public void testViewControllers1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISplitViewControllerViewController.testViewControllers1;
            }
        }));
    }

    //TODO: fails!
    @Ignore
    @Test
    public void testDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISplitViewControllerViewController.testDelegate1;
            }
        }));
    }

}
