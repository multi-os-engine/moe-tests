package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UINavigationCViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;
import static org.junit.Assert.*;

public class UINavigationCTests {

    static UINavigationCViewController controller = null;
    static UINavigationController navController;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                UIWindow main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UINavigationCViewController.alloc().init();
                navController = UINavigationController.alloc().initWithRootViewController(controller);
                navController.setDelegate(controller);
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(navController);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testInitWithRootViewController1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testInitWithRootViewController1;
            }
        }));
    }

    @Test
    public void testDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testDelegate1;
            }
        }));
    }

    @Test
    public void testPopViewControllerAnimated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testPopViewControllerAnimated1;
            }
        }));
    }

    @Test
    public void testPopViewControllerAnimated2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testPopViewControllerAnimated2;
            }
        }));
    }

    @Test
    public void testViewControllers1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testViewControllers1;
            }
        }));
    }

    @Test
    public void testTopViewController1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testTopViewController1;
            }
        }));
    }

    @Test
    public void testToolbar1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testToolbar1;
            }
        }));
    }

    @Test
    public void testToolbarHidden1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testToolbarHidden1;
            }
        }));
    }

    @Test
    public void testSetToolbarHidden_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testSetToolbarHidden_animated1;
            }
        }));
    }

    @Test
    public void testNavigationBar1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testNavigationBar1;
            }
        }));
    }

    @Test
    public void testNavigationBarHidden1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testNavigationBarHidden1;
            }
        }));
    }

    @Test
    public void testSetNavigationBarHidden_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UINavigationCViewController.testSetNavigationBarHidden_animated1;
            }
        }));
    }

}
