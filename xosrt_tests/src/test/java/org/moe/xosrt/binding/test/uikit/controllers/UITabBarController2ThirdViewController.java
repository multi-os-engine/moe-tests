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

public class UITabBarController2ThirdViewController extends UIViewController {


    static {
        NatJ.register();
    }

    protected UITabBarController2ThirdViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITabBarController2ThirdViewController alloc();

    @Selector("init")
    public native UITabBarController2ThirdViewController init();

    private boolean runTest = true;

    public static volatile boolean testTitle3 = false;
    public static volatile boolean testTabBarItem3 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.yellowColor());
        tabBarItem().setTitle("ThirdT");
        tabBarItem().setImage(null);

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
        testTitle3 = (title() == null
                && tabBarController().selectedViewController().title().equals("navigation3"));
        testTabBarItem3 = (tabBarController().selectedViewController().tabBarItem().title().equals("navigation3"));
        runTest = false;
        performSelectorWithObjectAfterDelay(new SEL("changeTab"), null, 1);
    }

    @Selector("changeTab")
    public void changeTab() {
        tabBarController().setSelectedIndex(3);
    }

    @Selector("senderActionPushButton:")
    public void senderActionPushButton(Object o) {
        UITabBarController2FourthViewController viewController = UITabBarController2FourthViewController.alloc().init();
        navigationController().pushViewControllerAnimated(viewController, true);
    }
}
