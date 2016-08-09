package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.*;
import ios.uikit.enums.UIDeviceOrientation;

public class UIDeviceOrientationTestViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIDeviceOrientationTestViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIDeviceOrientationTestViewController alloc();

    @Selector("init")
    public native UIDeviceOrientationTestViewController init();

    UIView subView1;
    UIDevice device;
    UITextField textField;

    public static volatile boolean testOrientation_landscape_left1 = false;
    public static volatile boolean testOrientation_without_notification1 = false;
    public static volatile boolean testOrientation_with_begin_notification1 = false;
    public static volatile boolean testGeneratesDeviceOrientationNotifications1 = false;
    public static volatile boolean testOrientation_with_end_notification1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIScreen screenObject = UIScreen.mainScreen();
        setView(UIView.alloc().initWithFrame(screenObject.bounds()));
        view().setBackgroundColor(UIColor.grayColor());

        textField = (UITextField)UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 120, 100, 50));
        textField.setTag(2);
        textField.setBackgroundColor(UIColor.yellowColor());

        device = UIDevice.currentDevice();
        view().addSubview(textField);

        testMethod();
    }

    @Selector("viewWillAppear:")
    @Override
    public void viewWillAppear(boolean animated) {
        device.beginGeneratingDeviceOrientationNotifications();
        //TODO: unimplemented method
        //device.setOrientation(UIDeviceOrientation.LandscapeLeft);
        testOrientation_landscape_left1 = device.orientation() == UIDeviceOrientation.LandscapeLeft;
    }

    public void testMethod() {
        System.out.println("testOrientation_without_notification1. Device orientation: " + device.orientation()
                + " should be: " + UIDeviceOrientation.Unknown);
        testOrientation_without_notification1 = device.orientation() == UIDeviceOrientation.Unknown;

        device.beginGeneratingDeviceOrientationNotifications();
        //TODO: unimplemented method
        //device.setOrientation(UIDeviceOrientation.LandscapeLeft);
        testOrientation_with_begin_notification1 = device.orientation() == UIDeviceOrientation.LandscapeLeft;

        testGeneratesDeviceOrientationNotifications1 = device.isGeneratingDeviceOrientationNotifications();

        device.endGeneratingDeviceOrientationNotifications();
        //TODO: unimplemented method
        //device.setOrientation(UIDeviceOrientation.Portrait);

        testOrientation_with_end_notification1 = device.orientation() == UIDeviceOrientation.LandscapeLeft;
    }
}
