package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTabbedAppFirstViewController;
import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.enums.UIUserInterfaceIdiom;
import ios.uikit.protocol.UIApplicationDelegate;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTabbedAppSecondViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class XIBTestTabbedAppFirstTests {

    static XIBTestTabbedAppFirstViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow) UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                UIViewController viewController2;
                if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {
                    controller = (XIBTestTabbedAppFirstViewController) XIBTestTabbedAppFirstViewController.alloc()
                            .initWithNibNameBundle("XIBTestTabbedAppFirstViewController_iPhone", null);
                    viewController2 = XIBTestTabbedAppSecondViewController.alloc()
                            .initWithNibNameBundle("XIBTestTabbedAppSecondViewController_iPhone", null);
                } else {
                    controller = (XIBTestTabbedAppFirstViewController) XIBTestTabbedAppFirstViewController.alloc()
                            .initWithNibNameBundle("XIBTestTabbedAppFirstViewController_iPad", null);
                    viewController2 = XIBTestTabbedAppSecondViewController.alloc()
                            .initWithNibNameBundle("XIBTestTabbedAppSecondViewController_iPad", null);
                }
                UITabBarController tabController = UITabBarController.alloc().init();
                NSArray controllers = NSArray.arrayWithObject(controller);
                tabController.setViewControllers(controllers.arrayByAddingObject(viewController2));
                main.setRootViewController(tabController);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testTabbedApplication441Test1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTabbedAppFirstViewController.testTabbedApplication441Test1;
            }
        }));
    }

}
