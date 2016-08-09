package org.moe.xosrt.binding.test.xib.controllers;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.uikit.UIButton;
import ios.uikit.UILabel;
import ios.uikit.UIViewController;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;

public class XIBTestButtonLabel1ViewController extends UIViewController {

    UILabel label = null;
    UIButton button = null;

    private static final String beginAnimations = "_beginAnimations_context";
    private static final String commitAnimations = "_commitAnimations";

    public static volatile boolean testText1 = false;
    public static volatile boolean testText2 = false;
    public static volatile boolean testFrame1 = false;
    public static volatile boolean testTitleForState1 = false;
    public static volatile boolean testFrame2 = false;

    static {
        NatJ.register();
    }

    protected XIBTestButtonLabel1ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestButtonLabel1ViewController alloc();

    @Selector("init")
    public native XIBTestButtonLabel1ViewController init();

    @Selector("changeText:")
    public void changeText(Object o) {
        label.setText("Text Changed!!");
        testText2 = label.text().equals("Text Changed!!");
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean bAnimated) {
        System.out.println("viewDidAppear:");
        testText1 = label.text().equals("Init Text...");

        testFrame1 = (label.frame().origin().x() == 126
                && label.frame().origin().y() == 58
                && label.frame().size().width() == 133
                && label.frame().size().height() == 47);

        String str = button.titleForState(UIControlState.Normal);
        testTitleForState1 = str.equals("Change Text!");

        testFrame2 = (button.frame().origin().x() == 90
                && button.frame().origin().y() == 178
                && button.frame().size().width() == 141
                && button.frame().size().height() == 47);

        button.sendActionsForControlEvents(UIControlEvents.TouchUpInside);

    }


    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        if (key.equals("label")) {
            label = (UILabel)value;
        } else if (key.equals("button")) {
            button = (UIButton)value;
        } else {
            super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        if (key.equals("label")) {
            return label;
        } else if (key.equals("button")) {
            return button;
        }
        return super.valueForKey(key);
    }
}
