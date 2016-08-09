package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class UIScreenViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIScreenViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIScreenViewController alloc();

    @Selector("init")
    public native UIScreenViewController init();

    
    

    public static volatile boolean testMainScreen1 = false;
    public static volatile boolean testBounds1 = false;
    public static volatile boolean testApplicationFrame1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIScreen screenObject;
        screenObject = UIScreen.mainScreen();
        UIView newView = UIView.alloc().initWithFrame(screenObject.applicationFrame());
        newView.setBackgroundColor(UIColor.whiteColor());
        setView(newView);
        testMethod();
    }

    public void testMethod() {
        UIScreen deviceScreen2 = UIScreen.mainScreen();
        testMainScreen1 = (deviceScreen2 != null);

        double minWidth = 240.0;
        double minHeight = 320.0;
        CGRect deviceScreenBounds;
        UIScreen deviceScreen1 = UIScreen.mainScreen();
        deviceScreenBounds = deviceScreen1.bounds();
        testBounds1 = (deviceScreenBounds.size().width() >= minWidth && deviceScreenBounds.size().height() >= minHeight);

        double minWidth2 = 240.0;
        double minHeight2 = 320.0;
        boolean hasStatusBarHidden = false;
        double statusBarHeight = 20;
        CGRect deviceScreenApplicationFrame = deviceScreen1.applicationFrame();
        testApplicationFrame1 = (deviceScreenApplicationFrame.size().width() >= minWidth2
                && (hasStatusBarHidden ? deviceScreenApplicationFrame.size().height() >= minHeight2
                        : deviceScreenApplicationFrame.size().height() >= minHeight2 - statusBarHeight));
    }
}
