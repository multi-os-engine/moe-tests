package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.IBAction;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;

public class XIBTestSliderViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestSliderViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestSliderViewController alloc();

    @Selector("init")
    public native XIBTestSliderViewController init();

    UISlider slider;
    UILabel label;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "slider":
                slider = (UISlider)value;
                break;
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
            case "slider":
                return slider;
            case "label":
                return label;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testSlider_value_changed1 = false;

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrame1 =  (slider.frame().origin().x() == 74 && slider.frame().origin().y() == 95
                && slider.frame().size().width() == 118 && slider.frame().size().height() == 23);

        testBackgroundColor1 =  (slider.backgroundColor().isEqual(UIColor.redColor()));

        testAlpha1 = (slider.alpha() == 0.25);

        slider.setValue(2.0f);
        slider.sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }

    @IBAction
    @Selector("changeValue:")
    public void changeValue(Object sender) {
        label.setText(String.format("%.02f", slider.value()));
        testSlider_value_changed1 = true;
    }

}
