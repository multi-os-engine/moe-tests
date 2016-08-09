package org.moe.xosrt.binding.test.uikit;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import org.moe.xosrt.binding.test.uikit.controllers.UITabBarController2FifthViewController;
import org.moe.xosrt.binding.test.uikit.controllers.UITabBarController2FirstViewController;
import org.moe.xosrt.binding.test.uikit.controllers.UITabBarController2FourthViewController;
import org.moe.xosrt.binding.test.uikit.controllers.UITabBarController2SecondViewController;
import org.moe.xosrt.binding.test.uikit.controllers.UITabBarController2SixthViewController;
import org.moe.xosrt.binding.test.uikit.controllers.UITabBarController2ThirdViewController;
import org.moe.xosrt.binding.test.uikit.controllers.UITabBarControllerViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;
import ios.foundation.NSArray;
import ios.foundation.NSOperationQueue;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.UIApplication;
import ios.uikit.UIImage;
import ios.uikit.UINavigationController;
import ios.uikit.UIScreen;
import ios.uikit.UITabBarController;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import static org.junit.Assert.assertTrue;

public class UITabBarController2Tests {

    public static int WAIT_TIMEOUT = 5;

    static UITabBarControllerViewController controller;

    private static NSArray viewControllersArray1 = null;
    private static NSArray viewControllersArray2 = null;

    private static UIViewController viewcontroller1 = null;
    private static UIViewController viewcontroller2 = null;
    private static UIViewController viewcontroller3 = null;
    private static UIViewController viewcontroller4 = null;
    private static UIViewController viewcontroller5 = null;
    private static UIViewController viewcontroller6 = null;

    private static UINavigationController navigationController1 = null;
    private static UINavigationController navigationController2 = null;
    private static UINavigationController navigationController3 = null;
    private static UINavigationController navigationController4 = null;

    static UITabBarController tabBarController = null;

    private static volatile boolean testTitle0 = false;
    private static volatile boolean testTabBarItem0 = false;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                UIWindow main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                UIApplicationDelegate appDelegate = ((UIApplicationDelegate) UIApplication.sharedApplication().delegate());
                tabBarController = UITabBarController.alloc().init();
                tabBarController.setViewControllers(viewControllersArray1());
                main.setRootViewController(tabBarController);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testTitle0() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return testTitle0;
            }
        }, 5000));

    }

    @Test
    public void testTabBarItem0() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return testTabBarItem0;
            }
        }, 5000));

    }

    @Test
    public void testTitle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2FirstViewController.testTitle1;
            }
        }, 5000));

    }

    @Test
    public void testTabBarItem1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2FirstViewController.testTabBarItem1;
            }
        }, 5000));

    }

    @Test
    public void testTitle2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2SecondViewController.testTitle2;
            }
        }, 5000));

    }

    @Test
    public void testTabBarItem2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2SecondViewController.testTabBarItem2;
            }
        }, 5000));

    }

    @Test
    public void testTitle3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2ThirdViewController.testTitle3;
            }
        }, 5000));

    }

    @Test
    public void testTabBarItem3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2ThirdViewController.testTabBarItem3;
            }
        }, 5000));

    }

    @Test
    public void testTitle4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2FourthViewController.testTitle4;
            }
        }, 5000));

    }

    @Test
    public void testTabBarItem4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2FourthViewController.testTabBarItem4;
            }
        }, 5000));
    }


    @Test
    public void testSetViewControllers_animated1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITabBarController2FifthViewController.testSetViewControllers_animated1;
            }
        }, 5000));

    }

    public static NSArray viewControllersArray1() {
        if (viewControllersArray1 != null) {
            return viewControllersArray1;
        }

        viewcontroller1 = UITabBarController2FirstViewController.alloc().init();
        viewcontroller2 = UITabBarController2SecondViewController.alloc().init();
        viewcontroller3 = UITabBarController2ThirdViewController.alloc().init();
        viewcontroller4 = UITabBarController2FourthViewController.alloc().init();

        navigationController1 = UINavigationController.alloc().initWithRootViewController(viewcontroller1);
        navigationController1.setTitle("navigation1");
        navigationController1.tabBarItem().setTitle("navigationTabItem1");
        navigationController1.tabBarItem().setImage(UIImage.imageNamed("first.png"));

        navigationController2 = UINavigationController.alloc().initWithRootViewController(viewcontroller2);
        navigationController2.setTitle("navigation2");
        navigationController2.tabBarItem().setTitle("navigationTabItem2");
        navigationController2.tabBarItem().setImage(UIImage.imageNamed("second.png"));

        navigationController3 = UINavigationController.alloc().initWithRootViewController(viewcontroller3);
        navigationController3.setTitle("navigation3");
        navigationController4 = UINavigationController.alloc().initWithRootViewController(viewcontroller4);

        viewControllersArray1 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[] {
                        navigationController1, navigationController2, navigationController3, navigationController4
                }), 4);

        testTitle0 = (navigationController1.title().equals("navigation1") && viewcontroller1.title() == null
                && navigationController2.title().equals("navigation2") && viewcontroller2.title() == null
                && navigationController3.title().equals("navigation3") && viewcontroller3.title() == null
                && navigationController4.title() == null && viewcontroller4.title() == null);

        testTabBarItem0 = (viewcontroller1.tabBarItem() != navigationController1.tabBarItem()
                && navigationController1.tabBarItem().title().equals("navigationTabItem1")
                && viewcontroller2.tabBarItem() != navigationController2.tabBarItem()
                && navigationController2.tabBarItem().title().equals("navigationTabItem2")
                && viewcontroller3.tabBarItem() != navigationController3.tabBarItem()
                && navigationController3.tabBarItem().title().equals("navigation3")
                && viewcontroller4.tabBarItem() != navigationController4.tabBarItem()
                && navigationController4.tabBarItem().title() == null);
        return viewControllersArray1;
    }

    public static NSArray viewControllersArray2() {
        if (viewControllersArray2 != null) {
            return viewControllersArray2;
        }

        viewcontroller5 = UITabBarController2FifthViewController.alloc().init();
        viewcontroller6 = UITabBarController2SixthViewController.alloc().init();
        viewcontroller5.setTitle("view5");
        viewcontroller6.setTitle("view6");
        viewControllersArray2 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[] {
                        viewcontroller5, viewcontroller6
                }), 2);
        return viewControllersArray2;
    }
}
