package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;

public class UISliderViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UISliderViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UISliderViewController alloc();

    @Selector("init")
    public native UISliderViewController init();

    UIView subView1;
    UISlider slider1;
    UISlider slider2;
    NSArray  values;
    UILabel label;
    UILabel label2;

    public static volatile boolean testSliderValueChanged1 = false;
    public static volatile boolean testMinimumValue1 = false;
    public static volatile boolean testMaximumValue1 = false;
    public static volatile boolean testValue1 = false;
    public static volatile boolean testSetValue1 = false;
    public static volatile boolean testSetContinuous1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIScreen screenObject = UIScreen.mainScreen();
        setView(UIView.alloc().initWithFrame(screenObject.bounds()));
        view().setBackgroundColor(UIColor.grayColor());

        testMethod();
    }

    @Selector("sliderValueChanged")
    public void sliderValueChanged() {
        int progressAsInt =(int)(slider1.value());
        int progressAsInt2 =(int)(slider2.value());
        String newText = String.format("%d", progressAsInt);
        String newText2 = String.format("%d", progressAsInt2);
        label.setText(newText);
        label2.setText(newText2);

        testSliderValueChanged1 = (slider2.value() == 25);
    }

    public void testMethod() {
        label = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(100, 100, 50, 40));
        label.setText("------");
        label.setTextColor(UIColor.greenColor());
        label.setBackgroundColor(UIColor.blackColor());
        UIFont font1 = UIFont.fontWithNameSize("Helvetica", 25.0);
        label.setFont(font1);

        label2 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(200, 100, 50, 40));
        label2.setText("------");
        label2.setTextColor(UIColor.greenColor());
        label2.setBackgroundColor(UIColor.blackColor());
        label2.setFont(font1);

        slider1 = UISlider.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 200, UIScreen.mainScreen().bounds().size().width() - 20, 50));
        slider1.setContinuous(true);
        slider1.setMinimumValue(0);
        slider1.setMaximumValue(100);
        slider1.setValue(0);
        slider1.addTargetActionForControlEvents(this, new SEL("sliderValueChanged"), UIControlEvents.ValueChanged);

        slider2 = UISlider.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 300, UIScreen.mainScreen().bounds().size().width() - 20, 50));
        slider2.setContinuous(false);
        slider2.setMinimumValue(0);
        slider2.setMaximumValue(100);
        slider2.setValue(0);
        slider2.addTargetActionForControlEvents(this, new SEL("sliderValueChanged"), UIControlEvents.ValueChanged);

        view().addSubview(label);
        view().addSubview(label2);
        view().addSubview(slider1);
        view().addSubview(slider2);

        testMinimumValue1 = (slider1.minimumValue() == 0);

        testMaximumValue1 = (slider1.maximumValue() == 100);

        testValue1 = (slider1.value() == 0);

        slider1.setValue(50);
        testSetValue1 = (slider1.value() == 50);

        slider1.setContinuous(false);
        testSetContinuous1 = (!slider1.isContinuous());
        slider1.setContinuous(true);

        slider2.setValue(25);
        slider2.sendActionsForControlEvents(UIControlEvents.ValueChanged);

        slider2.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = !slider2.isUserInteractionEnabled();
    }

}
