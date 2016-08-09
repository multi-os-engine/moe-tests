package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.xib.testhelpers.View1;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestAwake1ViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestAwake1ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestAwake1ViewController alloc();

    @Selector("init")
    public native XIBTestAwake1ViewController init();

    UIButton button;
    UIScrollView scrollView;
    public static View1 newView;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "button":
                button = (UIButton)value;
                break;
            case "scrollView":
                scrollView = (UIScrollView)value;
                break;
            case "newView":
                newView = (View1)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "button":
                return button;
            case "scrollView":
                return scrollView;
            case "newView":
                return newView;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testAwakeFromNib1 = false;

    public void awakeFromNib() {
        testAwakeFromNib1 = (button != null && button.titleLabel().text().equals("OK"));
        scrollView.setBackgroundColor(UIColor.magentaColor());
    }

    public UIView view() {
        return scrollView;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {

    }

}
