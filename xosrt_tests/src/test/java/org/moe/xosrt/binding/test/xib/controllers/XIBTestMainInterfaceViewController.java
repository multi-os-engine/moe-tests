package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestMainInterfaceViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestMainInterfaceViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestMainInterfaceViewController alloc();

    @Selector("init")
    public native XIBTestMainInterfaceViewController init();

    public long viewDidAppearCount;
    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.blueColor());
        viewDidAppearCount = 0;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
viewDidAppearCount++;
    }

}
