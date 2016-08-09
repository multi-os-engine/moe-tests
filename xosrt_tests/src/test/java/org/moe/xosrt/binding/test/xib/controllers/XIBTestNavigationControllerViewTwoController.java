package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.uikit.UILabel;
import ios.uikit.UIViewController;

public class XIBTestNavigationControllerViewTwoController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestNavigationControllerViewTwoController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestNavigationControllerViewTwoController alloc();

    @Selector("init")
    public native XIBTestNavigationControllerViewTwoController init();

    public UIViewController back;
    public UILabel label;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "label":
                label = (UILabel)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "label":
                return label;
            default:
                return super.valueForKey(key);
        }
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        label.setText("secondView!!");
        ((XIBTestNavigationControllerViewController)back).setPushed(true);
    }

}
