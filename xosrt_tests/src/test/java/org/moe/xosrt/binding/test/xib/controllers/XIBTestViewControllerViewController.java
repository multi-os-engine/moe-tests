package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestViewControllerViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestViewControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestViewControllerViewController alloc();

    @Selector("init")
    public native XIBTestViewControllerViewController init();


    public static volatile boolean testNavigationItemtitle1 = false;
    public static volatile boolean testNavigationItemleftBarButtonItemtitle1 = false;
    public static volatile boolean testNavigationItemrightBarButtonItemtitle1 = false;
    public static volatile boolean testTabBarItemtitle1 = false;

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testNavigationItemtitle1 = (navigationItem().title().equals("TitleNavItem")
                && tabBarItem().title().equals("TitleTabBarItem"));

        testNavigationItemleftBarButtonItemtitle1 = (navigationItem().leftBarButtonItem().title().equals("left"));

        testNavigationItemrightBarButtonItemtitle1 = (navigationItem().rightBarButtonItem().title().equals("right"));

        testTabBarItemtitle1 = (tabBarItem().title().equals("TitleTabBarItem"));
    }

}
