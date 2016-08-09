package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UIScreen;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;

public class UITabBarController2SecondViewController extends UIViewController {


    static {
        NatJ.register();
    }

    protected UITabBarController2SecondViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITabBarController2SecondViewController alloc();

    @Selector("init")
    public native UITabBarController2SecondViewController init();

    private boolean runTest = true;

    public static volatile boolean testTitle2 = false;
    public static volatile boolean testTabBarItem2 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.redColor());
        setTitle("SecondViewController");
        tabBarItem().setTitle("SecondT");
        navigationItem().setTitle("SecondN");

        UIButton pushButton = UIButton.buttonWithType(UIButtonType.RoundedRect);
        pushButton.setFrame(CoreGraphics.CGRectMake(30, 30, 300, 44));
        pushButton.setTitleForState("Push View Controller", UIControlState.Normal);
        pushButton.addTargetActionForControlEvents(this, new SEL("senderActionPushButton:"), UIControlEvents.TouchUpInside);
        view().addSubview(pushButton);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        if (!runTest) {
            return;
        }
        System.out.println("Title: " + tabBarController().selectedViewController().tabBarItem().title());
        testTitle2 = (title().equals("SecondViewController")
                && tabBarController().selectedViewController().title().equals("SecondViewController"));
        testTabBarItem2 = (tabBarItem().title().equals("SecondT"));
        runTest = false;
        performSelectorWithObjectAfterDelay(new SEL("changeTab"), null, 1);
    }

    @Selector("changeTab")
    public void changeTab() {
        tabBarController().setSelectedIndex(2);
    }

    @Selector("senderActionPushButton:")
    public void senderActionPushButton(Object o) {
        UITabBarController2ThirdViewController viewController = UITabBarController2ThirdViewController.alloc().init();
        navigationController().pushViewControllerAnimated(viewController, true);
    }
}
