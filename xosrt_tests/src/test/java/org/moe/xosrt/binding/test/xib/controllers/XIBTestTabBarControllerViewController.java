package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestTabBarControllerViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTabBarControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTabBarControllerViewController alloc();

    @Selector("init")
    public native XIBTestTabBarControllerViewController init();


    public static volatile boolean testTitle1 = false;
    public static volatile boolean testViewControllers1 = false;
    public static volatile boolean testTabBar1 = false;
    public static volatile boolean testTabBarItemtag1 = false;

    public void viewDidLoad() {
        super.viewDidLoad();
        testXIBFilesProperties();
    }

    public void testXIBFilesProperties() {
        testTitle1 = (tabBarController().title().equals("TabBarController"));

        testViewControllers1 = (tabBarController().viewControllers().count() == 2);

        testTabBar1 =  (tabBarController().tabBar().items().count() == 2
                && ((UITabBarItem)tabBarController().tabBar().items().objectAtIndex(0)).title().equals("FirstViewController")
                && ((UITabBarItem)tabBarController().tabBar().items().objectAtIndex(1)).title().equals("SecondViewController")
        );

        testTabBarItemtag1 = (tabBarItem().tag() == 1);
    }

}
