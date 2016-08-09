package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class UISwitchViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UISwitchViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UISwitchViewController alloc();

    @Selector("init")
    public native UISwitchViewController init();

    
    UISwitch switchControl;

    public static volatile boolean testInitWithFrame1 = false;
    public static volatile boolean testSetOn1 = false;
    public static volatile boolean testSetOn2 = false;
    public static volatile boolean testSetOn_animated1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        switchControl = UISwitch.alloc().initWithFrame(CoreGraphics.CGRectMake(30, 300, 300, 400));
        switchControl.setBackgroundColor(UIColor.redColor());

        UIView newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480));
        newView.setBackgroundColor(UIColor.whiteColor());
        newView.addSubview(switchControl);
        setView(newView);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testInitWithFrame1 = (switchControl.frame().origin().x() == 30 && switchControl.frame().origin().y() == 300) ;

        UISwitch switchControl2 = UISwitch.alloc().initWithFrame(CoreGraphics.CGRectMake(40, 40, 300, 400));
        view().addSubview(switchControl2);
        switchControl2.setOn(true);

        testSetOn1 = (switchControl2.isOn());

        switchControl2.setOn(false);

        testSetOn2 = (!switchControl2.isOn());

        switchControl.setOnAnimated(true, true);
        performSelectorWithObjectAfterDelay(new SEL("testSetOn"), null, 1);
    }

    @Selector("testSetOn")
    public void testSetOn() {
        testSetOn_animated1 = switchControl.isOn();

        switchControl.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = !switchControl.isUserInteractionEnabled();
    }

}
