package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIDatePickerMode;

public class XIBTestDatePickerViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestDatePickerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestDatePickerViewController alloc();

    @Selector("init")
    public native XIBTestDatePickerViewController init();

    UIDatePicker pickerDate;
    UIDatePicker pickerTime;
    
    UILabel label;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "pickerDate":
                pickerDate = (UIDatePicker)value;
                break;
            case "pickerTime":
                pickerTime = (UIDatePicker)value;
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
            case "pickerDate":
                return pickerDate;
            case "pickerTime":
                return pickerTime;
            case "label":
                return label;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testDatePickerMode1 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;
    public static volatile boolean testDatePickerMode2 = false;
    public static volatile boolean testChangeValue1 = false;
    public static volatile boolean testChangeValue2 = false;

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        testMethod();
    }

    public void dealloc() {
        super.dealloc();
    }

    public void testMethod() {
        testDatePickerMode1 = (pickerDate.datePickerMode() == UIDatePickerMode.Date) ;

        testAlpha1 = (pickerDate.alpha() == 0.5);

        testAlpha2 = (pickerTime.alpha() == 1);
        testDatePickerMode2 = (pickerTime.datePickerMode() == UIDatePickerMode.Time) ;

        pickerDate.sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }

    @Selector("touchPickerDate:")
    public void touchPickerDate(Object sender) {
        label.setText("change date");
        pickerTime.sendActionsForControlEvents(UIControlEvents.ValueChanged);
        testChangeValue1 = true;
    }

    @Selector("touchPickerTime:")
    public void touchPickerTime(Object sender) {
        label.setText("change time");
        testChangeValue2 = true;
    }

}
