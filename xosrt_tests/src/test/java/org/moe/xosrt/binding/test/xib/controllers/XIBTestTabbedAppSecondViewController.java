package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIInterfaceOrientation;
import ios.uikit.enums.UIUserInterfaceIdiom;

public class XIBTestTabbedAppSecondViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTabbedAppSecondViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTabbedAppSecondViewController alloc();

    @Selector("init")
    public native XIBTestTabbedAppSecondViewController init();

    @Selector("initWithNibName:bundle:")
    @Override
    public UIViewController initWithNibNameBundle(String nibNameOrNil, NSBundle nibBundleOrNil) {
        super.initWithNibNameBundle(nibNameOrNil, nibBundleOrNil);
        setTitle("Second");
        tabBarItem().setImage(UIImage.imageNamed("second"));
        return this;
    }

    public void viewDidLoad() {
        super.viewDidLoad();
    }

    public void viewDidUnload() {
        super.viewDidUnload();
    }

    @Selector("shouldAutorotateToInterfaceOrientation:")
    @Override
    public boolean shouldAutorotateToInterfaceOrientation(long interfaceOrientation) {
        if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {
            return (interfaceOrientation != UIInterfaceOrientation.PortraitUpsideDown);
        } else {
            return true;
        }
    }

}
