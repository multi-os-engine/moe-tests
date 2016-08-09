package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.UITabBarController2Tests;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UIScreen;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;

public class UITabBarController2FifthViewController extends UIViewController {


    static {
        NatJ.register();
    }

    protected UITabBarController2FifthViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITabBarController2FifthViewController alloc();

    @Selector("init")
    public native UITabBarController2FifthViewController init();

    private boolean runTest = true;

    public static volatile boolean testSetViewControllers_animated1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.brownColor());

        UIButton pushButton = UIButton.buttonWithType(UIButtonType.RoundedRect);
        pushButton.setFrame(CoreGraphics.CGRectMake(30, 230, 200, 44));
        pushButton.setTitleForState("setViewControllers:animated", UIControlState.Normal);
        pushButton.addTargetActionForControlEvents(this, new SEL("actionSetViewControllersAnimated:"), UIControlEvents.TouchUpInside);
        view().addSubview(pushButton);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
    	System.out.println("viewDidAppear");
        if (!runTest) {
            return;
        }
        System.out.println("tabBarController().viewControllers().count() = " + tabBarController().viewControllers().count());
        testSetViewControllers_animated1 = (tabBarController().viewControllers().count() == 2);
        runTest = false;
    }

    @Selector("actionSetViewControllersAnimated:")
    public void senderActionPushButton(Object o) {
        tabBarController().setViewControllersAnimated(UITabBarController2Tests.viewControllersArray1(), true);
    }
}
