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

public class XIBTestLabelViewController extends UIViewController {

    static {
        NatJ.register();
    }

    private static final double NORMAL_DISTORTION = 1e-6;

    protected XIBTestLabelViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestLabelViewController alloc();

    @Selector("init")
    public native XIBTestLabelViewController init();

    UILabel label;
    UILabel label2;
    UILabel label3;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "label":
                label = (UILabel)value;
                break;
            case "label2":
                label2 = (UILabel)value;
                break;
            case "label3":
                label3 = (UILabel)value;
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
            case "label2":
                return label2;
            case "label3":
                return label3;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testText1 = false;
    public static volatile boolean testFrame1 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testTextColor1 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;
    public static volatile boolean testTextAlignment1 = false;
    public static volatile boolean testTextAlignment2 = false;
    public static volatile boolean testTextAlignment3 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    public void viewDidUnload() {
        //TODO: no such function setLabel(null);
        super.viewDidUnload();
        // Release any retained subviews of the main view. // e.g. myOutlet = nil;
    }

    private boolean isDoubleEqual(double val1, double val2) {
        return Math.abs(val1 - val2) < NORMAL_DISTORTION;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testText1 = (label.text().equals("This is a Label!!!" ));

        testFrame1 =  (label.frame().origin().x() == 107 && label.frame().origin().y() == 99
                && label.frame().size().width() == 124 && label.frame().size().height() == 37) ;

        NFloatPtr red0 = PtrFactory.newNFloatReference();
        NFloatPtr green0 = PtrFactory.newNFloatReference();
        NFloatPtr blue0 = PtrFactory.newNFloatReference();
        NFloatPtr alpha0 = PtrFactory.newNFloatReference();
        label.backgroundColor().getRedGreenBlueAlpha(red0, green0, blue0, alpha0);
        testBackgroundColor1 =  (isDoubleEqual(1, red0.getValue()) && isDoubleEqual(0.827825248, green0.getValue())
                && isDoubleEqual(0.4596515, blue0.getValue()) && isDoubleEqual(1, alpha0.getValue()));

        NFloatPtr red1 = PtrFactory.newNFloatReference();
        NFloatPtr green1 = PtrFactory.newNFloatReference();
        NFloatPtr blue1 = PtrFactory.newNFloatReference();
        NFloatPtr alpha1 = PtrFactory.newNFloatReference();
        label.textColor().getRedGreenBlueAlpha(red1, green1, blue1, alpha1);
        testTextColor1 = (isDoubleEqual(0.98010999, red1.getValue()) && isDoubleEqual(0.0821668804, green1.getValue())
                && isDoubleEqual(0.770666063, blue1.getValue()) && isDoubleEqual(1, alpha1.getValue()));

        testAlpha1 = isDoubleEqual(label.alpha(), 1);

        testAlpha2 = isDoubleEqual(label2.alpha(), 0.5);

        testTextAlignment1 =  (label.textAlignment() == 0 );

        testTextAlignment2 =  (label2.textAlignment() == 1 );

        testTextAlignment3 =  (label3.textAlignment() == 2 );
    }

    public void dealloc() {
        //label.release();
        super.dealloc();
    }

}
