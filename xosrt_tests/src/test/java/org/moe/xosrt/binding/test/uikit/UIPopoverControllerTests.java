package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIPopoverControllerViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.moe.xosrt.binding.test.uikit.testhelpers.UIPopoverDetailViewController;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;
import static org.junit.Assert.*;

@Ignore //Runs on iPad only
public class UIPopoverControllerTests {

    static UIPopoverDetailViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIPopoverDetailViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    //Fails in xCode
    @Ignore
    @Test
    public void testSetPopoverContentSize_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPopoverControllerViewController.testSetPopoverContentSize_animated1;
            }
        }, 5000));
    }

    //Fails in xCode
    @Ignore
    @Test
    public void testSetContentViewController_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPopoverControllerViewController.testSetContentViewController_animated1;
            }
        }, 5000));
    }

    //Fails in xCode
    @Ignore
    @Test
    public void testDismissPopoverAnimated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPopoverControllerViewController.testDismissPopoverAnimated1;
            }
        }, 5000));
    }


    @Test
    public void testInitWithContentViewController1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPopoverDetailViewController.testInitWithContentViewController1;
            }
        }));
    }

    @Test
    public void testSetPopoverContentSize1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPopoverDetailViewController.testSetPopoverContentSize1;
            }
        }));
    }

    @Test
    public void testDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPopoverDetailViewController.testDelegate1;
            }
        }));
    }

    @Test
    public void testPopoverVisible1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPopoverDetailViewController.testPopoverVisible1;
            }
        }));
    }

}
