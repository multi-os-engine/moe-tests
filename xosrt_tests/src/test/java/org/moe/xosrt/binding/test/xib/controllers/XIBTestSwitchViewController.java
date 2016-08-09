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

public class XIBTestSwitchViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestSwitchViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestSwitchViewController alloc();

    @Selector("init")
    public native XIBTestSwitchViewController init();

    UISwitch uiswitch;
    UISwitch uiswitch2;
    UILabel  uilabel;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "uiswitch":
                uiswitch = (UISwitch)value;
                break;
            case "uiswitch2":
                uiswitch2 = (UISwitch)value;
                break;
            case "uilabel":
                uilabel = (UILabel)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "uiswitch":
                return uiswitch;
            case "uiswitch2":
                return uiswitch2;
            case "uilabel":
                return uilabel;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testOn1 = false;
    public static volatile boolean testFrame2 = false;
    public static volatile boolean testOn2 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testBackgroundColor2 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;
    public static volatile boolean testUIControlEventValueChanged1 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    public void viewDidLoad() {
        super.viewDidLoad();
    }

    public void viewDidUnload() {
        //TODO: unknown method setUiswitch(nil);
        super.viewDidUnload();
        // Release any retained subviews of the main view.
        // e.g. myOutlet = nil;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrame1 = (uiswitch.frame().origin().x() == 106 && uiswitch.frame().origin().y() == 145);

        testOn1 = (uiswitch.isOn());

        testFrame2 = (uiswitch2.frame().origin().x() == 28 && uiswitch2.frame().origin().y() == 63);

        testOn2 = (!uiswitch2.isOn());

        testBackgroundColor1 = (uiswitch.backgroundColor().isEqual(UIColor.yellowColor()));

        testBackgroundColor2 = (uiswitch2.backgroundColor().isEqual(UIColor.redColor()));

        testAlpha1 = (uiswitch2.alpha() == 1 );

        testAlpha2 = (uiswitch.alpha() == 0.25 );

        uiswitch.sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }

    @IBAction
    @Selector("labelChange:")
    public void labelChange(Object sender) {

        if (uiswitch.isOn()) {
            uilabel.setText("Switch ON");
        } else {
            uilabel.setText("Switch OFF");
        }

        testUIControlEventValueChanged1 = (uilabel.text().equals("Switch ON") && uiswitch.isOn());
    }

    public void dealloc() {
        //uiswitch.release();
        //uiswitch2.release();
        //uilabel.release();
        super.dealloc();
    }

}
