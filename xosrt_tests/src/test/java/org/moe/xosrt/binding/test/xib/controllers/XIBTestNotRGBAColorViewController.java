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

public class XIBTestNotRGBAColorViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestNotRGBAColorViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestNotRGBAColorViewController alloc();

    @Selector("init")
    public native XIBTestNotRGBAColorViewController init();

    UIView view1;
    UIView view2;
    UIView view3;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "view1":
                view1 = (UIView)value;
                break;
            case "view2":
                view2 = (UIView)value;
                break;
            case "view3":
                view3 = (UIView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "view1":
                return view1;
            case "view2":
                return view2;
            case "view3":
                return view3;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testUIColor_notRGB_XIB1 = false;

    static double UNCERTAINTY1 = 0.000001;
    public boolean eqcgf(double n1, double n2) {
        return Math.abs(n1 - n2) < UNCERTAINTY1;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        NFloatPtr red0 = PtrFactory.newNFloatReference();
        NFloatPtr green0 = PtrFactory.newNFloatReference();
        NFloatPtr blue0 = PtrFactory.newNFloatReference();
        NFloatPtr alpha0 = PtrFactory.newNFloatReference();
        view().backgroundColor().getRedGreenBlueAlpha(red0, green0, blue0, alpha0);

        NFloatPtr red1 = PtrFactory.newNFloatReference();
        NFloatPtr green1 = PtrFactory.newNFloatReference();
        NFloatPtr blue1 = PtrFactory.newNFloatReference();
        NFloatPtr alpha1 = PtrFactory.newNFloatReference();
        view1.backgroundColor().getRedGreenBlueAlpha(red1, green1, blue1, alpha1);

        NFloatPtr red2 = PtrFactory.newNFloatReference();
        NFloatPtr green2 = PtrFactory.newNFloatReference();
        NFloatPtr blue2 = PtrFactory.newNFloatReference();
        NFloatPtr alpha2 = PtrFactory.newNFloatReference();
        view2.backgroundColor().getRedGreenBlueAlpha(red2, green2, blue2, alpha2);

        NFloatPtr red3 = PtrFactory.newNFloatReference();
        NFloatPtr green3 = PtrFactory.newNFloatReference();
        NFloatPtr blue3 = PtrFactory.newNFloatReference();
        NFloatPtr alpha3 = PtrFactory.newNFloatReference();
        view3.backgroundColor().getRedGreenBlueAlpha(red3, green3, blue3, alpha3);

        System.out.println("red0: " + red0.getValue());
        System.out.println("green0: " + green0.getValue());
        System.out.println("blue0: " + blue0.getValue());
        System.out.println("alpha1: " + alpha0.getValue());
        System.out.println("red1: " + red1.getValue());
        System.out.println("green1: " + green1.getValue());
        System.out.println("blue1: " + blue1.getValue());
        System.out.println("alpha1: " + alpha1.getValue());
        System.out.println("red2: " + red2.getValue());
        System.out.println("green2: " + green2.getValue());
        System.out.println("blue2: " + blue2.getValue());
        System.out.println("alpha2: " + alpha2.getValue());
        System.out.println("red3: " + red3.getValue());
        System.out.println("green3: " + green3.getValue());
        System.out.println("blue3: " + blue3.getValue());
        System.out.println("alpha3: " + alpha3.getValue());
        testUIColor_notRGB_XIB1 = (eqcgf(red0.getValue(), 1.0) && eqcgf(green0.getValue(), 0.0)
                && eqcgf(blue0.getValue(), 0.0) && eqcgf(alpha0.getValue(), 1.0)
                && eqcgf(red1.getValue(), 0.5) && eqcgf(green1.getValue(), 0.5)
                && eqcgf(blue1.getValue(), 0.5) && eqcgf(alpha1.getValue(), 0.5)
                && eqcgf(red2.getValue(), 0.444868) && eqcgf(green2.getValue(), 1)
                && eqcgf(blue2.getValue(), 0.997937) && eqcgf(alpha2.getValue(), 0.5)
                && eqcgf(red3.getValue(), 0.119584) && eqcgf(green3.getValue(), 0.115913)
                && eqcgf(blue3.getValue(), 0.394453) && eqcgf(alpha3.getValue(), 1.0));
    }

}
