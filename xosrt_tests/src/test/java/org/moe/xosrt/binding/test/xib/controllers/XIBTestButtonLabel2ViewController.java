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
import ios.uikit.enums.UIControlState;

public class XIBTestButtonLabel2ViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestButtonLabel2ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestButtonLabel2ViewController alloc();

    @Selector("init")
    public native XIBTestButtonLabel2ViewController init();

    UILabel label;
    UIButton button;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "label":
                label = (UILabel)value;
                break;
            case "button":
                button = (UIButton)value;
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
            case "button":
                return button;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testText2 = false;
    public static volatile boolean testText1 = false;
    public static volatile boolean testFrame1 = false;
    public static volatile boolean testTitleForState1 = false;
    public static volatile boolean testFrame2 = false;

    @Selector("changeText:")
    public void changeText(Object sender) {
        label.setText("Text Changed!");
        testText2 = (label.text().equals("Text Changed!" ));
    }

    public void didReceiveMemoryWarning() {
        // Releases the view if it doesn't have a superview. super.didReceiveMemoryWarning();

    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);


        testText1 = (label.text().equals("Init Text" ));

        testFrame1 = (label.frame().origin().x() == 105 && label.frame().origin().y() == 74
                && label.frame().size().width() == 110 && label.frame().size().height() == 36);

        String str = button.titleForState(UIControlState.Normal);
        testTitleForState1 = (str.equals("Change Text!!"));


        testFrame2 = (button.frame().origin().x() == 97 && button.frame().origin().y() == 252
                && button.frame().size().width() == 127 && button.frame().size().height() == 37);

        button.sendActionsForControlEvents(UIControlEvents.TouchUpInside);
    }

}
