package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIViewViewController;

import ios.coregraphics.c.CoreGraphics;
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

public class UIView2Tests {

    public static int WAIT_TIMEOUT = 10000;

    static UIViewViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().init();//WithFrame(UIScreen.mainScreen().bounds());
                controller = UIViewViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setFrame(CoreGraphics.CGRectMake(0, 0, 320, 480));
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                controller.window = main;
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testBackgroundColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testBackgroundColor1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetBackgroundColor2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetBackgroundColor2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testAlpha1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testAlpha1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetAlpha1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetAlpha1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testIsHidden1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testIsHidden1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testIsHidden2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testIsHidden2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetHidden1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetHidden1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetHidden2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetHidden2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testFrame1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testFrame1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testFrame2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testFrame2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetFrame1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetFrame1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetFrame2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetFrame2;
            }
        }, WAIT_TIMEOUT));
    }

    //TODO: fails!
    @Ignore
    @Test
    public void testBounds1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testBounds1;
            }
        }, WAIT_TIMEOUT));
    }

    //TODO: fails!
    @Ignore
    @Test
    public void testCenter1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testCenter1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetBounds1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetBounds1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetCenter1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetCenter1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetCenter2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetCenter2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testAddSubView1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testAddSubView1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testAddSubView2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testAddSubView2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSubviews1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSubviews1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testRemoveFromSuperview1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testRemoveFromSuperview1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSuperview1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSuperview1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInsertSubview_atIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testInsertSubview_atIndex1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInsertSubview_aboveSubview() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testInsertSubview_aboveSubview;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInsertSubview_belowSubview() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testInsertSubview_belowSubview;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testBringSubviewToFront1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testBringSubviewToFront1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testBringSubviewToFront2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testBringSubviewToFront2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testBringSubviewToFront3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testBringSubviewToFront3;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSendSubviewToBack1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSendSubviewToBack1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSendSubviewToBack2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSendSubviewToBack2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testExchangeSubviewAtIndex_withSubviewAtIndex1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testExchangeSubviewAtIndex_withSubviewAtIndex1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testExchangeSubviewAtIndex_withSubviewAtIndex2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testExchangeSubviewAtIndex_withSubviewAtIndex2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testIsDescendantOfView1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testIsDescendantOfView1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testIsDescendantOfView2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testIsDescendantOfView2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testIsDescendantOfView3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testIsDescendantOfView3;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInitWithFrame1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testInitWithFrame1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testInitWithFrame2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testInitWithFrame2;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testTag1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testTag1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testSetTag1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testSetTag1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testViewWithTag1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testViewWithTag1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testIsUserInteractionEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testIsUserInteractionEnabled1;
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testWindow1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewViewController.testWindow1;
            }
        }, WAIT_TIMEOUT));
    }

}
