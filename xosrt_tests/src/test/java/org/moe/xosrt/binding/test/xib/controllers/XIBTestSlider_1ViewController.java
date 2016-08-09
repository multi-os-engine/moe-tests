package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestSlider_1ViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestSlider_1ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestSlider_1ViewController alloc();

    @Selector("init")
    public native XIBTestSlider_1ViewController init();

    UISlider slider;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "slider":
                slider = (UISlider)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "slider":
                return slider;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testCurrent_value1 = false;
    public static volatile boolean testMinimum_value1 = false;
    public static volatile boolean testMaximum_value1 = false;

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrame1 =  (slider.frame().origin().x() == 74 && slider.frame().origin().y() == 95
                && slider.frame().size().width() == 118 && slider.frame().size().height() == 23);

        testCurrent_value1 = (slider.value() == 2.0);

        testMinimum_value1 = (slider.minimumValue() == 1.0);

        testMaximum_value1 = (slider.maximumValue() == 8.0);
    }

}
