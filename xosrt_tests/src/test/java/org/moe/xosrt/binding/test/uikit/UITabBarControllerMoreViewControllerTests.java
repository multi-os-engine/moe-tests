package org.moe.xosrt.binding.test.uikit;

import org.moe.natj.objc.SEL;

import org.moe.xosrt.binding.test.uikit.controllers.UISwitchViewController;
import org.moe.xosrt.binding.test.uikit.testhelpers.SimpleViewController;
import org.moe.xosrt.binding.test.uikit.testhelpers.TestAppDelegate;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;
import ios.uikit.enums.UITabBarSystemItem;
import ios.uikit.protocol.UIApplicationDelegate;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UITabBarControllerMoreViewControllerTests {

    public static int WAIT_TIMEOUT = 13;

/*    @BeforeClass
    public static void starter() {
        UIWindow main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
        NewTestRunner appDelegate = ((NewTestRunner) UIApplication.sharedApplication().delegate());
        SimpleViewController aViewController = null;
        NSMutableArray array = NSMutableArray.array();

        for (int i = 0; i < 20; i++) {
            aViewController = SimpleViewController.alloc().init();
            aViewController.setTitle(String.format("View %d", i));
            if (i % 2 == 0) {
                aViewController.tabBarItem().setImage(UIImage.imageNamed("first.png"));
            } else {
                aViewController.tabBarItem().setImage(UIImage.imageNamed("second.png"));
            }

            if (i == 3) {
                aViewController.view().setBackgroundColor(UIColor.yellowColor());
                UIButton buttonSelectMore = UIButton.buttonWithType(UIButtonType.RoundedRect);
                buttonSelectMore.setFrame(CoreGraphics.CGRectMake(5, 250, 300, 50));
                buttonSelectMore.setTitleForState("selectMoreController", UIControlState.Normal);
                buttonSelectMore.addTargetActionForControlEvents(appDelegate,
                        new SEL("actionSelectMoreController:"), UIControlEvents.TouchUpInside);
                aViewController.view().addSubview(buttonSelectMore);
            }
            array.addObject(aViewController);
        }

        appDelegate.viewController0 = SimpleViewController.alloc().init();
        appDelegate.viewController0.setTabBarItem(UITabBarItem.alloc().initWithTabBarSystemItemTag(
                UITabBarSystemItem.MostRecent, 222111
        ));
        appDelegate.viewController0.view().setBackgroundColor(UIColor.redColor());

        UIButton buttonPush = UIButton.buttonWithType(UIButtonType.RoundedRect);
        buttonPush.setFrame(CoreGraphics.CGRectMake(15, 12, 200, 50));
        buttonPush.setTitleForState("PUSH", UIControlState.Normal);
        buttonPush.addTargetActionForControlEvents(appDelegate,
                new SEL("actionPushButton:"), UIControlEvents.TouchUpInside);
        appDelegate.viewController0.view().addSubview(buttonPush);

        appDelegate.viewController1 = SimpleViewController.alloc().init();
        appDelegate.viewController1.setTitle("ViewController N2");
        appDelegate.viewController1.view().setBackgroundColor(UIColor.greenColor());

        appDelegate.navigationController = UINavigationController.alloc().init();
        appDelegate.navigationController.setTitle("navigation");
        appDelegate.navigationController.tabBarItem().setImage(UIImage.imageNamed("second.png"));
        array.addObject(appDelegate.navigationController);

        appDelegate.tabBarController = UITabBarController.alloc().init();
        appDelegate.tabBarController.setDelegate(null);
        appDelegate.tabBarController.setViewControllers(array);
        main.setRootViewController(appDelegate.tabBarController);
        ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
        main.makeKeyAndVisible();
        appDelegate.performSelectorWithObjectAfterDelay(new SEL("testMoreViewController1"), null, 2);
        appDelegate.performSelectorWithObjectAfterDelay(new SEL("testMoreViewController2"), null, 6);
        appDelegate.performSelectorWithObjectAfterDelay(new SEL("testMoreViewController3"), null, 10);
    }

    @Test
    public void testMoreViewController1() {
        assertTrue(NewTestRunner.testMoreViewController1);
    }

    @Test
    public void testMoreViewController2() {
        assertTrue(NewTestRunner.testMoreViewController2);
    }

    @Test
    public void testMoreViewController3() {
        assertTrue(NewTestRunner.testMoreViewController3);
    }*/
}