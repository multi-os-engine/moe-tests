package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlState;
import ios.uikit.enums.UITextAlignment;

public class XIBTestButtonLabelDelegateViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestButtonLabelDelegateViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestButtonLabelDelegateViewController alloc();

    @Selector("init")
    public native XIBTestButtonLabelDelegateViewController init();

    UIButton button;
    
    UIButton button_model1;
    UIButton button_model2;
    
    UIButton button_info;
    UIButton button_detail;
    
    UILabel label1;
    UILabel label2;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "button":
                button = (UIButton)value;
                break;
            case "button_model1":
                button_model1 = (UIButton)value;
                break;
            case "button_model2":
                button_model2 = (UIButton)value;
                break;
            case "button_info":
                button_info = (UIButton)value;
                break;
            case "button_detail":
                button_detail = (UIButton)value;
                break;
            case "label1":
                label1 = (UILabel)value;
                break;
            case "label2":
                label2 = (UILabel)value;
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
            case "button_model1":
                return button_model1;
            case "button_model2":
                return button_model2;
            case "button_info":
                return button_info;
            case "button_detail":
                return button_detail;
            case "label1":
                return label1;
            case "label2":
                return label2;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testButtonType1 = false;
    public static volatile boolean testButtonType2 = false;
    public static volatile boolean testButtonType3 = false;
    public static volatile boolean testSetTitle_forState1 = false;
    public static volatile boolean testSetNumberOfLineslabel1 = false;
    public static volatile boolean testSetTextlabel1 = false;
    public static volatile boolean testSetTextColorlabel1 = false;
    public static volatile boolean testSetTextAlignmentlabel1 = false;
    public static volatile boolean testSetEnabledlabel1 = false;

    @Selector("buttonModel1:")
    public void buttonModel1(Object sender) {
        test();
    }

    @Selector("buttonModel2:")
    public void buttonModel2(Object sender) {
        reset();
    }

    @Selector("test")
    public void test() {
        button_info = UIButton.buttonWithType(UIButtonType.InfoDark);
        testButtonType1 = (button_info.buttonType() == UIButtonType.InfoDark);

        button_detail = UIButton.buttonWithType(UIButtonType.DetailDisclosure);
        testButtonType2 = (button_detail.buttonType() == UIButtonType.DetailDisclosure);

        button_model2 = UIButton.buttonWithType(UIButtonType.RoundedRect);
        testButtonType3 = (button_model2.buttonType() == UIButtonType.RoundedRect);

        button.setTitleForState("Test !!", UIControlState.Normal);
        testSetTitle_forState1 = (button.titleForState(UIControlState.Normal).equals("Test !!"));

        label1.setNumberOfLines(2);
        label2.setNumberOfLines(1);
        testSetNumberOfLineslabel1 = (label1.numberOfLines() == 2 && label2.numberOfLines() == 1);

        label1.setText("model1 - model1 - model1");
        label2.setText("-------");
        testSetTextlabel1 = (label1.text().equals("model1 - model1 - model1"));

        label1.setTextColor(UIColor.redColor());
        label2.setTextColor(UIColor.greenColor());
        testSetTextColorlabel1 = (UIColor.redColor() == label1.textColor()
                && UIColor.greenColor() == label2.textColor());

        label1.setTextAlignment(UITextAlignment.Left);
        label2.setTextAlignment(UITextAlignment.Center);
        testSetTextAlignmentlabel1 =  (UITextAlignment.Left == label1.textAlignment()
                && UITextAlignment.Center == label2.textAlignment());

        label1.setEnabled(false);
        label2.setEnabled(true);
        testSetEnabledlabel1 =  (!label1.isEnabled() && label2.isEnabled()) ;

        performSelectorWithObjectAfterDelay(new SEL("reset"), null, 2);
    }

    @Selector("reset")
    public void reset() {
        button_model2 = UIButton.buttonWithType(UIButtonType.RoundedRect);
        button.setTitleForState("Reset", UIControlState.Normal);
        label1.setText("--------");
        label2.setText("model2 - model2 - model2");
        label1.setTextColor(UIColor.blueColor());
        label2.setTextColor(UIColor.blackColor());
        label1.setTextAlignment(UITextAlignment.Center);
        label2.setTextAlignment(UITextAlignment.Right);
        label1.setEnabled(true);
        label2.setEnabled(true);
        label1.setFont(UIFont.fontWithNameSize("Helvetica", 22.0));
        label2.setFont(UIFont.fontWithNameSize("Helvetica", 12.0));
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        System.out.println("viewDidAppear");
        reset();
        performSelectorWithObjectAfterDelay(new SEL("test"), null, 2);

    }

}
