package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UITableViewViewController;

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

public class UITableViewTests {

    static UITableViewViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UITableViewViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testInsertRowsAtIndexPaths_withRowAnimation1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testInsertRowsAtIndexPaths_withRowAnimation1;
            }
        }, 5000));
    }

    @Test
    public void testDeleteRowsAtIndexPaths_withRowAnimation1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testDeleteRowsAtIndexPaths_withRowAnimation1;
            }
        }, 5000));
    }

    @Test
    public void testSelectRowAtIndexPath_animated_scrollPosition1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testSelectRowAtIndexPath_animated_scrollPosition1;
            }
        }, 5000));
    }

    @Test
    public void testDeselectRowAtIndexPath_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testDeselectRowAtIndexPath_animated1;
            }
        }, 5000));
    }

    @Test
    public void testIndexPathForSelectedRow1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testIndexPathForSelectedRow1;
            }
        }, 5000));
    }

    @Test
    public void testAllowsSelection1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testAllowsSelection1;
            }
        }, 5000));
    }

    @Test
    public void testInitWithFrame_style1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testInitWithFrame_style1;
            }
        }, 5000));
    }

    @Test
    public void testDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testDelegate1;
            }
        }, 5000));
    }

    @Test
    public void testDataSource1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testDataSource1;
            }
        }, 5000));
    }

    //TODO: fails on simulator!
    @Ignore
    @Test
    public void testReloadData1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testReloadData1;
            }
        }, 5000));
    }

    @Test
    public void testRowHeight1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testRowHeight1;
            }
        }, 5000));
    }

    @Test
    public void testSectionHeaderHeight1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITableViewViewController.testSectionHeaderHeight1;
            }
        }, 5000));
    }

}
