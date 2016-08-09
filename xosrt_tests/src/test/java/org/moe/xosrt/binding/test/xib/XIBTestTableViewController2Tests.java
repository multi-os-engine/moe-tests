package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTableViewController2ViewController;
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

@Ignore //TODO: fails on simulator, cannot load XIBTestTableViewController2ViewController with xib
public class XIBTestTableViewController2Tests {

    static XIBTestTableViewController2ViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                NSBundle.mainBundle().loadNibNamedOwnerOptions("XIBTestTableViewController2Window", main, null);
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
                return XIBTestTableViewController2ViewController.testNavigationItemtitle1;
            }
        }));
    }

    @Test
    public void testNavigationItemprompt1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewController2ViewController.testNavigationItemprompt1;
            }
        }));
    }

    @Test
    public void testNavigationItemleftBarButtonItemtitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewController2ViewController.testNavigationItemleftBarButtonItemtitle1;
            }
        }));
    }

    @Test
    public void testNavigationItemleftBarButtonItemtag1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewController2ViewController.testNavigationItemleftBarButtonItemtag1;
            }
        }));
    }

    @Test
    public void testNavigationItemrightBarButtonItemtitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewController2ViewController.testNavigationItemrightBarButtonItemtitle1;
            }
        }));
    }

    @Test
    public void testNavigationItemrightBarButtonItemtag1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewController2ViewController.testNavigationItemrightBarButtonItemtag1;
            }
        }));
    }

    @Test
    public void testTabBarItemtitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewController2ViewController.testTabBarItemtitle1;
            }
        }));
    }

    @Test
    public void testTabBarItemtag1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewController2ViewController.testTabBarItemtag1;
            }
        }));
    }

}
