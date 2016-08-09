package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UISegmentedControlViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UISegmentedControlTests {

    public static int WAIT_TIMEOUT = 10000;

    static UISegmentedControlViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UISegmentedControlViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testInitWithItems1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testInitWithItems1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testImage_forSegmentAtIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testImage_forSegmentAtIndex1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetImage_forSegmentAtIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testSetImage_forSegmentAtIndex1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testTitle_forSegmentAtIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testTitle_forSegmentAtIndex1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetTitle_forSegmentAtIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testSetTitle_forSegmentAtIndex1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSelectedSegmentIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testSelectedSegmentIndex1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testNumberOfSegments1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testNumberOfSegments1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInsertSegmentWithImage_atIndex_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testInsertSegmentWithImage_atIndex_animated1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInsertSegmentWithText_atIndex_animated2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testInsertSegmentWithText_atIndex_animated2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testRemoveAllSegments1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testRemoveAllSegments1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testRemoveSegmentAtIndex_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testRemoveSegmentAtIndex_animated1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testRemoveSegmentAtIndex_animated2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testRemoveSegmentAtIndex_animated2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testIsEnabled_forSegmentAtIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testIsEnabled_forSegmentAtIndex1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetEnabled_forSegmentAtIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testSetEnabled_forSegmentAtIndex1;
            }
        }, 2 * WAIT_TIMEOUT));
    }

    @Test
    public void testSetUserInteractionEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UISegmentedControlViewController.testSetUserInteractionEnabled1;
            }
        }, WAIT_TIMEOUT));
    }

}
