package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestActivityIndicatorViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestActivityIndicatorViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestActivityIndicatorViewController alloc();

    @Selector("init")
    public native XIBTestActivityIndicatorViewController init();

    UIActivityIndicatorView activity;
    

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "activity":
                activity = (UIActivityIndicatorView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "activity":
                return activity;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testBackgroundColor1 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrame1 = (activity.frame().origin().x() == 40 && activity.frame().origin().y() == 20);

        testBackgroundColor1 =  (activity.backgroundColor().isEqual(UIColor.blueColor()));

        activity.startAnimating();
    }

    public void dealloc() {
        super.dealloc();
    }

}
