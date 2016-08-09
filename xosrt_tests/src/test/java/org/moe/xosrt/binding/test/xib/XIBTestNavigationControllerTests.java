package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestNavigationControllerViewController;
import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

@Ignore //TODO: xib should be uploaded on UIApplication level
public class XIBTestNavigationControllerTests {

    static XIBTestNavigationControllerViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());

                UINavigationController navController = (UINavigationController)UINavigationController.alloc()
                        .initWithNibNameBundle("XIBTestNavigationController", null);
                //controller = navController.topViewController();
                main.setRootViewController(navController);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testTitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestNavigationControllerViewController.testTitle1;
            }
        }));
    }

    @Test
    public void testTabBarItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestNavigationControllerViewController.testTabBarItem1;
            }
        }));
    }

    @Test
    public void testPushViewController_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestNavigationControllerViewController.testPushViewController_animated1;
            }
        }));
    }

}
