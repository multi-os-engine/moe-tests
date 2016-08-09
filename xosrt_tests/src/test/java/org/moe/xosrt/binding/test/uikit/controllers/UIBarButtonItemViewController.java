package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.*;
import ios.uikit.enums.UIBarButtonItemStyle;
import ios.uikit.enums.UIBarButtonSystemItem;

public class UIBarButtonItemViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIBarButtonItemViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIBarButtonItemViewController alloc();

    @Selector("init")
    public native UIBarButtonItemViewController init();

    
    UIBarButtonItem  aButton;
    UIBarButtonItem  bButton;
    UIBarButtonItem  cButton;
    UIBarButtonItem  dButton;
    UIBarButtonItem  eButton;

    public static volatile boolean testInitWithBarButtonSystemItem_target_action1 = false;
    public static volatile boolean testSetAction1 = false;
    public static volatile boolean testInitWithTitle_style_target_action1 = false;
    public static volatile boolean testSetTarget1 = false;

    private boolean pressButton1 = false;
    private boolean pressButton2 = false;
    private boolean pressButton3 = false;
    private boolean pressButton4 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 319, 480)));
        view().setBackgroundColor(UIColor.redColor());

    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testMethod();
    }

    @Selector("pressButton_1")
    public Object pressButton_1() {
        pressButton1 = true;
        return null;
    }

    @Selector("pressButton_2")
    public Object pressButton_2() {
        pressButton2 = true;
        return null;
    }

    @Selector("pressButton_3")
    public Object pressButton_3() {
        pressButton3 = true;
        return null;
    }

    @Selector("pressButton_4")
    public Object pressButton_4() {
        pressButton4 = true;
        return null;
    }

    public void testMethod() {

        UINavigationBar newNavigationBar = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 40, 319, 50));
        view().addSubview(newNavigationBar);

        newNavigationBar.setTag(1);
        UINavigationItem  newItem0 = UINavigationItem.alloc().initWithTitle("0");
        newNavigationBar.pushNavigationItemAnimated(newItem0, false);
        UINavigationItem  newItem1 = UINavigationItem.alloc().initWithTitle("1");
        newNavigationBar.pushNavigationItemAnimated(newItem1, false);
        UINavigationItem  newItem2 = UINavigationItem.alloc().initWithTitle("2");
        newNavigationBar.pushNavigationItemAnimated(newItem2, false);
        UINavigationItem  newItem3 = UINavigationItem.alloc().initWithTitle("3");
        newNavigationBar.pushNavigationItemAnimated(newItem3, false);
        UINavigationItem  newItem4 = UINavigationItem.alloc().initWithTitle("4");
        newNavigationBar.pushNavigationItemAnimated(newItem4, false);

        aButton = UIBarButtonItem.alloc().initWithBarButtonSystemItemTargetAction(
                UIBarButtonSystemItem.Add, this, new SEL("pressButton_1"));
        newItem0.setRightBarButtonItem(aButton);
        ((UIViewController)aButton.target()).performSelector(aButton.action());
        testInitWithBarButtonSystemItem_target_action1 =  (aButton != null && aButton.target() == this
                && pressButton1);

        bButton = UIBarButtonItem.alloc().initWithTitleStyleTargetAction("ButtonItem1", UIBarButtonItemStyle.Done, this, null);
        newItem1.setRightBarButtonItem(bButton);
        bButton.setAction(new SEL("pressButton_2"));
        cButton = UIBarButtonItem.alloc().initWithTitleStyleTargetAction("ButtonItem2", UIBarButtonItemStyle.Plain, this, null);
        newItem2.setRightBarButtonItem(cButton);
        cButton.setAction(new SEL("pressButton_3"));
        ((UIViewController)bButton.target()).performSelector(bButton.action());
        ((UIViewController)cButton.target()).performSelector(cButton.action());
        testSetAction1 = (pressButton2 && pressButton3);

        dButton = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "dbutton", UIBarButtonItemStyle.Bordered, this, new SEL("pressButton_4"));
        newItem3.setRightBarButtonItem (dButton);
        ((UIViewController)dButton.target()).performSelector(dButton.action());
        testInitWithTitle_style_target_action1 = (dButton != null && dButton.title().equals("dbutton")
                && dButton.target() == this && pressButton4) ;

        eButton = UIBarButtonItem.alloc().initWithTitleStyleTargetAction("ButtonItem5", UIBarButtonItemStyle.Done, null, null);
        newItem4.setRightBarButtonItem(eButton);
        eButton.setTarget(this);
        testSetTarget1 = (eButton.target() == this);
    }

}
