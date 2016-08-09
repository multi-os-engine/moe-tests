package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.*;
import ios.foundation.enums.NSDateFormatterStyle;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIDatePickerMode;
import ios.uikit.enums.UITextAlignment;

public class UIDatePickerViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIDatePickerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIDatePickerViewController alloc();

    @Selector("init")
    public native UIDatePickerViewController init();


    public static volatile boolean testAddTarget_action_forControlEvents1 = false;
    public static volatile boolean testDate1 = false;
    public static volatile boolean testMinimumDate1 = false;
    public static volatile boolean testMaximumDate1 = false;
    public static volatile boolean testMinimumDate2 = false;
    public static volatile boolean testMaximumDate2 = false;
    public static volatile boolean testSetDate1 = false;
    public static volatile boolean testDatePickerMode1 = false;
    public static volatile boolean testSetDatePickerMode1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIView newView = UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds());
        UILabel datelabel = UILabel.alloc().init();
        datelabel.setFrame(CoreGraphics.CGRectMake(10, 10, 300, 40));
        datelabel.setBackgroundColor(UIColor.blueColor());
        datelabel.setTextColor(UIColor.whiteColor());
        datelabel.setFont(UIFont.fontWithNameSize("Verdana-Bold", 8.0));
        datelabel.setTextAlignment(UITextAlignment.Center);
        datelabel.setTag(2);

        UIDatePicker datePicker = UIDatePicker.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 250, 250, 20));
        datePicker.setDatePickerMode(UIDatePickerMode.DateAndTime);
        datePicker.setTag(1);

        datePicker.addTargetActionForControlEvents(this, new SEL("labelChange"), UIControlEvents.ValueChanged);
        newView.addSubview(datelabel);
        newView.addSubview(datePicker);

        setView(newView);
    }

    @Selector("labelChange")
    public void labelChange() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateStyle(NSDateFormatterStyle.MediumStyle);
        UILabel label = (UILabel)view().viewWithTag(2);
        UIDatePicker picker = (UIDatePicker)view().viewWithTag(1);
        label.setText(df.stringFromDate(picker.date()));

        testAddTarget_action_forControlEvents1 = label.text().equals(df.stringFromDate(picker.date()));
    }

    @Selector("viewWillAppear:")
    public void viewWillAppear(boolean animated) {
        testMethod();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        UIDatePicker picker = (UIDatePicker)view().viewWithTag(1);
        picker.sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }


    public void testMethod() {

        UIDatePicker datePicker = (UIDatePicker)view().viewWithTag(1);

        NSDate date = NSDate.alloc().init();
        NSDateFormatter df = NSDateFormatter.alloc().init();
        String dateText1 = df.stringFromDate(datePicker.date());
        String dateText2 = df.stringFromDate(date);

        testDate1 = (dateText1.equals(dateText2));

        testMinimumDate1 = (datePicker.minimumDate() == null);

        testMaximumDate1 = (datePicker.maximumDate() == null);

        datePicker.setMinimumDate(date);

        testMinimumDate2 = (datePicker.minimumDate() != null);

        df.setDateFormat("yyyy-MM-dd HH:mm:ss Z");
        NSDate dateMax = df.dateFromString("2018-02-01 00:00:00 -0600");
        datePicker.setMaximumDate(dateMax);
        testMaximumDate2 = datePicker.maximumDate() != null;

        NSDate date0 = df.dateFromString("2017-02-01 00:00:00 -0600");
        datePicker.setDate(date0);
        testSetDate1 = datePicker.date().description().equals(date0.description());

        testDatePickerMode1 = datePicker.datePickerMode() == UIDatePickerMode.DateAndTime;

        UIDatePicker datePicker2 = (UIDatePicker)UIDatePicker.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 40, 250, 20));
        datePicker2.setDatePickerMode(UIDatePickerMode.Date);
        testSetDatePickerMode1 = datePicker2.datePickerMode() == UIDatePickerMode.Date;

        view().addSubview(datePicker2);

        datePicker2.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = !datePicker2.isUserInteractionEnabled();
    }
}
