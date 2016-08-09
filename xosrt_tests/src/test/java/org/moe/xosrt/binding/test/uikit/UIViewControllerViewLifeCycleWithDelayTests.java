package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UILifeCycleViewController0;
import org.junit.BeforeClass;
import org.junit.Test;

import ios.foundation.NSMutableArray;
import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIColor;
import ios.uikit.UINavigationController;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

public class UIViewControllerViewLifeCycleWithDelayTests {


    public static int WAIT_TIMEOUT = 20000;

    static UILifeCycleViewController0 controller;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                UIWindow main = (UIWindow) UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UILifeCycleViewController0.alloc().init();
                controller.setNumber(0);
                controller.setWithDelay(true);
                controller.setCheckAnimated(false);
                controller.setColor(UIColor.whiteColor());
                UINavigationController nav = UINavigationController.alloc().initWithRootViewController(controller);
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(nav);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testViewLifeCycle1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                if (controller == null) return false;
                NSMutableArray arr = controller.getArray();
                return (arr.count() >= 24 && arr.objectAtIndex(0).equals("ViewController0 loadView")
                        && arr.objectAtIndex(1).equals("ViewController0 viewDidLoad")
                        && arr.objectAtIndex(2).equals("ViewController0 viewWillAppear")
                        && arr.objectAtIndex(3).equals("ViewController0 viewDidAppear")
                        && arr.objectAtIndex(4).equals("ViewController1 loadView")
                        && arr.objectAtIndex(5).equals("ViewController1 viewDidLoad")
                        && arr.objectAtIndex(6).equals("ViewController0 viewWillDisappear")
                        && arr.objectAtIndex(7).equals("ViewController1 viewWillAppear")
                        && arr.objectAtIndex(8).equals("ViewController0 viewDidDisappear")
                        && arr.objectAtIndex(9).equals("ViewController1 viewDidAppear")
                        && arr.objectAtIndex(10).equals("ViewController2 loadView")
                        && arr.objectAtIndex(11).equals("ViewController2 viewDidLoad")
                        && arr.objectAtIndex(12).equals("ViewController1 viewWillDisappear")
                        && arr.objectAtIndex(13).equals("ViewController2 viewWillAppear")
                        && arr.objectAtIndex(14).equals("ViewController1 viewDidDisappear")
                        && arr.objectAtIndex(15).equals("ViewController2 viewDidAppear")
                        && arr.objectAtIndex(16).equals("ViewController2 viewWillDisappear")
                        && arr.objectAtIndex(17).equals("ViewController1 viewWillAppear")
                        && arr.objectAtIndex(18).equals("ViewController2 viewDidDisappear")
                        && arr.objectAtIndex(19).equals("ViewController1 viewDidAppear")
                        && arr.objectAtIndex(20).equals("ViewController1 viewWillDisappear")
                        && arr.objectAtIndex(21).equals("ViewController0 viewWillAppear")
                        && arr.objectAtIndex(22).equals("ViewController1 viewDidDisappear")
                        && arr.objectAtIndex(23).equals("ViewController0 viewDidAppear")
                );
            }
        }, WAIT_TIMEOUT));
    }
}
