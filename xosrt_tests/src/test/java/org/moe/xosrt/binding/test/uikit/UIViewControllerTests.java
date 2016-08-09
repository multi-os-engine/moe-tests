package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIViewControllerViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UIViewControllerTests {

    static UIViewControllerViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIViewControllerViewController.alloc().init();
                controller.setTitle("title 1");
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testView1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testView1;
            }
        }));
    }

    @Test
    public void testSetView1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testSetView1;
            }
        }));
    }

    @Test
    public void testTitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testTitle1;
            }
        }));
    }

    @Test
    public void testTitle2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testTitle2;
            }
        }));
    }

    @Test
    public void testLoadView1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testLoadView1;
            }
        }));
    }

    @Test
    public void testViewDidLoad1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testViewDidLoad1;
            }
        }));
    }

    @Test
    public void testViewWillAppear1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testViewWillAppear1;
            }
        }));
    }

    @Test
    public void testViewDidAppear1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testViewDidAppear1;
            }
        }));
    }

    @Test
    public void testNavigationItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testNavigationItem1;
            }
        }));
    }

    @Test
    public void testNavigationController1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testNavigationController1;
            }
        }));
    }

    @Test
    public void testTabBarItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testTabBarItem1;
            }
        }));
    }

    @Test
    public void testTabBarController1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testTabBarController1;
            }
        }));
    }

    @Test
    public void testToolbarItems1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testToolbarItems1;
            }
        }));
    }

    @Test
    public void testHidesBottomBarWhenPushed1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIViewControllerViewController.testHidesBottomBarWhenPushed1;
            }
        }));
    }

}
