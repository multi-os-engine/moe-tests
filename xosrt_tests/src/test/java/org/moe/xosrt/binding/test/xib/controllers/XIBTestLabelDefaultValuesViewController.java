package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.NFloatPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;
import ios.uikit.enums.UITextAlignment;

public class XIBTestLabelDefaultValuesViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestLabelDefaultValuesViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestLabelDefaultValuesViewController alloc();

    @Selector("init")
    public native XIBTestLabelDefaultValuesViewController init();

    UILabel labelDefaultXib;
    UILabel labelDefaultProg;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "labelDefaultXib":
                labelDefaultXib = (UILabel)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "labelDefaultXib":
                return labelDefaultXib;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testXIB_backgroundColor1 = false;
    public static volatile boolean testXIB_textColor1 = false;
    public static volatile boolean testXIB_textAlignment1 = false;
    public static volatile boolean testXIB_text1 = false;
    public static volatile boolean testPROGRAMATIC_backgroundColor1 = false;
    public static volatile boolean testPROGRAMATIC_backgroundColor2 = false;
    public static volatile boolean testPROGRAMATIC_textColor1 = false;
    public static volatile boolean testPROGRAMATIC_textAlignment1 = false;
    public static volatile boolean testPROGRAMATIC_text1 = false;

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        labelDefaultProg = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 300, 200, 80));
        view().addSubview(labelDefaultProg);

        UIButton button = UIButton.buttonWithType(UIButtonType.RoundedRect);
        button.setFrame(CoreGraphics.CGRectMake(100, 400, 100, 44));
        button.setTitleForState("run test", UIControlState.Normal);
        button.addTargetActionForControlEvents(this, new SEL("runTest"), UIControlEvents.TouchUpInside);
        view().addSubview(button);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        runTest();
    }

    @Selector("runTest")
    public void runTest() {
        testXIBDefaults();
        testProgramaticDefaults();
    }

    public void testXIBDefaults() {
        testXIB_backgroundColor1 = (labelDefaultXib != null && labelDefaultXib.backgroundColor() == null);

        NFloatPtr white = PtrFactory.newNFloatReference();
        NFloatPtr alpha = PtrFactory.newNFloatReference();
        labelDefaultXib.textColor().getWhiteAlpha(white, alpha);
        testXIB_textColor1 =  (labelDefaultXib != null && labelDefaultXib.textColor() != null
                && white.getValue() == 0.0 && alpha.getValue() == 1.0) ;

        testXIB_textAlignment1 =  (labelDefaultXib.textAlignment() == UITextAlignment.Left);

        testXIB_text1 =  (labelDefaultXib.text().equals("Label"));
    }

    public void testProgramaticDefaults() {
        NFloatPtr white0 = PtrFactory.newNFloatReference();
        NFloatPtr alpha0 = PtrFactory.newNFloatReference();
        labelDefaultProg.backgroundColor().getWhiteAlpha(white0, alpha0);
        testPROGRAMATIC_backgroundColor1 = (labelDefaultProg != null && white0.getValue() == 1
                && alpha0.getValue() == 1);

        UILabel label0 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 200, 50, 50));
        label0.setBackgroundColor(UIColor.redColor());
        label0.setBackgroundColor(null);
        label0.setText("l0");
        view().addSubview(label0);
        UILabel label1 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(100, 200, 50, 50));
        label1.setBackgroundColor(null);
        label1.setText("l1");
        view().addSubview(label1);
        testPROGRAMATIC_backgroundColor2 = (label0.backgroundColor() == null && label1.backgroundColor() == null);

        NFloatPtr white1 = PtrFactory.newNFloatReference();
        NFloatPtr alpha1 = PtrFactory.newNFloatReference();
        labelDefaultProg.textColor().getWhiteAlpha(white1, alpha1);
        testPROGRAMATIC_textColor1 =  (labelDefaultProg != null && labelDefaultProg.textColor() != null
                && white1.getValue() == 0 && alpha1.getValue() == 1);

        testPROGRAMATIC_textAlignment1 = (labelDefaultProg.textAlignment() == UITextAlignment.Left);

        testPROGRAMATIC_text1 =  (labelDefaultProg.text() == null);
    }

    public void dealloc() {
        //labelDefaultProg.release();
        //labelDefaultXib.release();
        super.dealloc();
    }

}
