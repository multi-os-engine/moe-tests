package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.NFloatPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestTextViewViewController extends UIViewController {

    static {
        NatJ.register();
    }

    private static final double NORMAL_DISTORTION = 1e-6;

    protected XIBTestTextViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTextViewViewController alloc();

    @Selector("init")
    public native XIBTestTextViewViewController init();

    UITextView textView;
    UITextView textView2;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "textView":
                textView = (UITextView)value;
                break;
            case "textView2":
                textView2 = (UITextView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "textView":
                return textView;
            case "textView2":
                return textView2;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testText1 = false;
    public static volatile boolean testSetText1 = false;
    public static volatile boolean testHasText1 = false;
    public static volatile boolean testFrame1 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testTextColor1 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;
    public static volatile boolean testTextAlignment1 = false;
    public static volatile boolean testTextAlignment2 = false;

    private boolean isDoubleEqual(double val1, double val2) {
        return Math.abs(val1 - val2) < NORMAL_DISTORTION;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testText1 = ("Hello world =D".equals(textView.text()));

        String textTest1 = "Hello world !!";
        textView.setText(textTest1);
        testSetText1 = (textTest1.equals(textView.text()));

        testHasText1 = (textView.hasText());

        testFrame1 = (textView.frame().origin().x() == 0 && textView.frame().origin().y() == 0
                && textView.frame().size().width() <= 320 && textView.frame().size().width() >= 300
                && textView.frame().size().height() <= 317 && textView.frame().size().height() >= 300);

        NFloatPtr red0 = PtrFactory.newNFloatReference();
        NFloatPtr green0 = PtrFactory.newNFloatReference();
        NFloatPtr blue0 = PtrFactory.newNFloatReference();
        NFloatPtr alpha0 = PtrFactory.newNFloatReference();
        textView.backgroundColor().getRedGreenBlueAlpha(red0, green0, blue0, alpha0);
        testBackgroundColor1 =  (isDoubleEqual(1, red0.getValue()) && isDoubleEqual(0.403117865, green0.getValue())
                && isDoubleEqual(0.0692477152, blue0.getValue()) && isDoubleEqual(1, alpha0.getValue()));

        NFloatPtr red1 = PtrFactory.newNFloatReference();
        NFloatPtr green1 = PtrFactory.newNFloatReference();
        NFloatPtr blue1 = PtrFactory.newNFloatReference();
        NFloatPtr alpha1 = PtrFactory.newNFloatReference();
        textView.textColor().getRedGreenBlueAlpha(red1, green1, blue1, alpha1);
        testTextColor1 = (isDoubleEqual(0.760494351, red1.getValue()) && isDoubleEqual(1, green1.getValue())
                && isDoubleEqual(0.392626613, blue1.getValue()) && isDoubleEqual(1, alpha1.getValue()));

        testAlpha1 = (textView.alpha() == 1 );

        testAlpha2 = (textView2.alpha() == 0.5 );

        testTextAlignment1 = (textView.textAlignment() == 2 );

        testTextAlignment2 = (textView2.textAlignment() == 1 );
    }

}
