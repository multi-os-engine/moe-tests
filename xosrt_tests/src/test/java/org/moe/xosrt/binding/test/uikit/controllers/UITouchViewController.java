package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class UITouchViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UITouchViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITouchViewController alloc();

    @Selector("init")
    public native UITouchViewController init();


    public static volatile boolean testLocationInView1 = false;
    public static volatile boolean testView1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        UIView newViewConteiner = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 319, 480));
        newViewConteiner.setBackgroundColor(UIColor.blueColor());

        setView(newViewConteiner);
    }

    @Selector("touchesBegan:withEvent:")
    @Override
    public void touchesBeganWithEvent(NSSet touches, UIEvent event) {

        UITouch touch = (UITouch)touches.anyObject();
        CGPoint point = touch.locationInView(view());

        testLocationInView1 = (point.x() >= 0 && point.x() <= 480 && point.y() >= 0 && point.y() <= 319);

        testView1 = (touch.view() == view());
    }

}
