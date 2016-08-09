package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestViewControllerViewController;
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

@Ignore //TODO: fails on simulator, cannot load XIBTestViewControllerViewController class with xib
public class XIBTestViewControllerTests {

    static XIBTestViewControllerViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                NSBundle.mainBundle().loadNibNamedOwnerOptions("XIBTestViewControllerWindow", main, null);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testNavigationItemtitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewControllerViewController.testNavigationItemtitle1;
            }
        }));
    }

    @Test
    public void testNavigationItemleftBarButtonItemtitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewControllerViewController.testNavigationItemleftBarButtonItemtitle1;
            }
        }));
    }

    @Test
    public void testNavigationItemrightBarButtonItemtitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewControllerViewController.testNavigationItemrightBarButtonItemtitle1;
            }
        }));
    }

    @Test
    public void testTabBarItemtitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestViewControllerViewController.testTabBarItemtitle1;
            }
        }));
    }

}
