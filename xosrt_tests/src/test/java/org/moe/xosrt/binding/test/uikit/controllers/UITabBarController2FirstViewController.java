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

public class UITabBarController2FirstViewController extends UIViewController {


    static {
        NatJ.register();
    }

    protected UITabBarController2FirstViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITabBarController2FirstViewController alloc();

    @Selector("init")
    public native UITabBarController2FirstViewController init();

    private boolean runTest = true;

    public static volatile boolean testTitle1 = false;
    public static volatile boolean testTabBarItem1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.blueColor());
        setTitle("FirstViewController");
        tabBarItem().setTitle("FirstT");
        navigationItem().setTitle("FirstN");

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
        testTitle1 = (title().equals("FirstViewController")
                && tabBarController().selectedViewController().title().equals("FirstViewController"));
        testTabBarItem1 = (tabBarController().selectedViewController().tabBarItem().title().equals("FirstViewController"));
        runTest = false;
        performSelectorWithObjectAfterDelay(new SEL("changeTab"), null, 1);
    }

    @Selector("changeTab")
    public void changeTab() {
        tabBarController().setSelectedIndex(1);
    }

    @Selector("senderActionPushButton:")
    public void senderActionPushButton(Object o) {
        UITabBarController2SecondViewController viewController = UITabBarController2SecondViewController.alloc().init();
        navigationController().pushViewControllerAnimated(viewController, true);
    }
}
