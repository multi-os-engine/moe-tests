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
import ios.uikit.enums.UITextBorderStyle;

public class XIBTestTextFieldViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTextFieldViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTextFieldViewController alloc();

    @Selector("init")
    public native XIBTestTextFieldViewController init();

    UITextField textfield;
    UITextField textfield2;
    UITextField textfield3;
    UITextField textfield4;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "textfield":
                textfield = (UITextField)value;
                break;
            case "textfield2":
                textfield2 = (UITextField)value;
                break;
            case "textfield3":
                textfield3 = (UITextField)value;
                break;
            case "textfield4":
                textfield4 = (UITextField)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "textfield":
                return textfield;
            case "textfield2":
                return textfield2;
            case "textfield3":
                return textfield3;
            case "textfield4":
                return textfield4;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testTitleForState1 = false;
    public static volatile boolean testBorderStyle1 = false;
    public static volatile boolean testBorderStyle2 = false;
    public static volatile boolean testBorderStyle3 = false;
    public static volatile boolean testBorderStyle4 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testBackgroundColor2 = false;
    public static volatile boolean testBackgroundColor3 = false;
    public static volatile boolean testBackgroundColor4 = false;
    public static volatile boolean testTextColor1 = false;
    public static volatile boolean testTextColor2 = false;
    public static volatile boolean testTextColor3 = false;
    public static volatile boolean testTextColor4 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;
    public static volatile boolean testAlpha3 = false;
    public static volatile boolean testAlpha4 = false;
    public static volatile boolean testTextAlignment1 = false;
    public static volatile boolean testTextAlignment2 = false;
    public static volatile boolean testTextAlignment3 = false;
    public static volatile boolean testTextAlignment4 = false;

    public void viewDidUnload() {
        //Unknown method setTextfield(null);
        super.viewDidUnload();
        // Release any retained subviews of the main view. // e.g. myOutlet = nil;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrame1 = (textfield.frame().origin().x() == 52 && textfield.frame().origin().y() == 125
                && textfield.frame().size().width() <= 216 && textfield.frame().size().width() >= 206
                && textfield.frame().size().height() <= 31 && textfield.frame().size().height() >= 21);

        String str = textfield.text();
        testTitleForState1 = (str.equals("Hello"));

        testBorderStyle1 = (textfield.borderStyle() == UITextBorderStyle.RoundedRect);

        testBorderStyle2 = (textfield2.borderStyle() == UITextBorderStyle.None);

        testBorderStyle3 = (textfield3.borderStyle() == UITextBorderStyle.Line);

        testBorderStyle4 = (textfield4.borderStyle() == UITextBorderStyle.Bezel);

        testBackgroundColor1 = (textfield.backgroundColor().isEqual(UIColor.greenColor()));

        testBackgroundColor2 = (textfield2.backgroundColor().isEqual(UIColor.blueColor()));

        testBackgroundColor3 = (textfield3.backgroundColor().isEqual(UIColor.yellowColor()));

        UIColor  color = textfield4.backgroundColor();
        testBackgroundColor4 = (textfield4.backgroundColor() == null);

        testTextColor1 = (textfield.textColor().isEqual(UIColor.blueColor()));

        testTextColor2 = (textfield2.textColor().isEqual(UIColor.redColor()));

        testTextColor3 = (textfield3.textColor().isEqual(UIColor.redColor()));

        testTextColor4 = (textfield4.textColor().isEqual(UIColor.purpleColor()));

        testAlpha1 = (textfield.alpha() == 0.5 );

        testAlpha2 = (textfield3.alpha() == 0.25 );

        testAlpha3 = (textfield2.alpha() == 1 );

        testAlpha4 = (textfield4.alpha() == 1 );

        testTextAlignment1 = (textfield.textAlignment() == 0 );

        testTextAlignment2 = (textfield2.textAlignment() == 1 );

        testTextAlignment3 = (textfield3.textAlignment() == 2 );

        testTextAlignment4 = (textfield4.textAlignment() == 0 );
    }

    @IBAction
    @Selector("changeText:")
    public void changeText(Object sender) {
        textfield.setText("This is show if click!!!");
    }

}
