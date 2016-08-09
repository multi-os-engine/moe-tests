package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UITableViewCellViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UITableViewCellTests {

    static UITableViewCellViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UITableViewCellViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testInitWithFrame_reuseIdentifier1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewCellViewController.testInitWithFrame_reuseIdentifier1;
            }
        }));
    }

    @Test
    public void testInitWithStyle_reuseIdentifier1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewCellViewController.testInitWithStyle_reuseIdentifier1;
            }
        }));
    }

    @Test
    public void testTestLabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewCellViewController.testTestLabel1;
            }
        }));
    }

    @Test
    public void testContentView1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewCellViewController.testContentView1;
            }
        }));
    }

    @Test
    public void testImageView1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewCellViewController.testImageView1;
            }
        }));
    }

    @Test
    public void testDetailTextLabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewCellViewController.testDetailTextLabel1;
            }
        }));
    }

    @Test
    public void testAccessoryType1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewCellViewController.testAccessoryType1;
            }
        }));
    }

    @Test
    public void testSelected1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewCellViewController.testSelected1;
            }
        }));
    }

}
