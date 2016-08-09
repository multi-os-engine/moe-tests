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

public class UITabBarController2FourthViewController extends UIViewController {


    static {
        NatJ.register();
    }

    protected UITabBarController2FourthViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITabBarController2FourthViewController alloc();

    @Selector("init")
    public native UITabBarController2FourthViewController init();

    private boolean runTest = true;

    public static volatile boolean testTitle4 = false;
    public static volatile boolean testTabBarItem4 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.greenColor());
        tabBarItem().setTitle("FourthT");

        UIButton pushButton = UIButton.buttonWithType(UIButtonType.RoundedRect);
        pushButton.setFrame(CoreGraphics.CGRectMake(30, 30, 300, 44));
        pushButton.setTitleForState("Push View Controller", UIControlState.Normal);
        pushButton.addTargetActionForControlEvents(this, new SEL("senderActionPushButton:"), UIControlEvents.TouchUpInside);

        UIButton setViewControllersAnimatedButton = UIButton.buttonWithType(UIButtonType.RoundedRect);
        setViewControllersAnimatedButton.setFrame(CoreGraphics.CGRectMake(30, 230, 200, 44));
        setViewControllersAnimatedButton.setTitleForState("setViewControllers:Animated", UIControlState.Normal);
        setViewControllersAnimatedButton.addTargetActionForControlEvents(this,
                new SEL("actionSetViewControllersAnimated:"), UIControlEvents.TouchUpInside);
        view().addSubview(pushButton);
        view().addSubview(setViewControllersAnimatedButton);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        if (!runTest) {
            return;
        }
        testTitle4 = (title() == null
                && tabBarController().selectedViewController().title() == null);
        testTabBarItem4 = (tabBarController().selectedViewController().tabBarItem().title() == null);
        runTest = false;
        performSelectorWithObjectAfterDelay(new SEL("actionSetViewControllersAnimated:"), null, 1);
    }

    @Selector("changeTab")
    public void changeTab() {
        tabBarController().setSelectedIndex(3);
    }

    @Selector("senderActionPushButton:")
    public void senderActionPushButton(Object o) {
        UITabBarController2FirstViewController viewController = UITabBarController2FirstViewController.alloc().init();
        navigationController().pushViewControllerAnimated(viewController, true);
    }

    @Selector("actionSetViewControllersAnimated:")
    public void actionSetViewControllersAnimated(Object o) {
        tabBarController().setViewControllersAnimated(UITabBarController2Tests.viewControllersArray2(), true);
    }
}
