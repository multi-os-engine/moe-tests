package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;

public class XIBTestButtonViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestButtonViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestButtonViewController alloc();

    @Selector("init")
    public native XIBTestButtonViewController init();

    UIButton buttonPressed;
    boolean  _actionWorked;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "buttonPressed":
                buttonPressed = (UIButton)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "buttonPressed":
                return buttonPressed;
            default:
                return super.valueForKey(key);
        }
    }

    public static volatile boolean testIsHidden1 = false;
    public static volatile boolean testIsHidden2 = false;
    public static volatile boolean testFrame1 = false;
    public static volatile boolean testTitleForState1 = false;
    public static volatile boolean testButtonAction1 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    public void viewDidUnload() {
        //setButtonPressed(null);
        super.viewDidUnload();
        // Release any retained subviews of the main view.
        // e.g. myOutlet = nil;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {

        testIsHidden1 = !buttonPressed.isHidden();


        testFrame1 = (buttonPressed.frame().origin().x() == 63 && buttonPressed.frame().origin().y() == 151
                && buttonPressed.frame().size().width() == 195 && buttonPressed.frame().size().height() == 65);

        String str = buttonPressed.titleForState(UIControlState.Normal);
        testTitleForState1 = str.equals("Press me!!!");

        buttonPressed.sendActionsForControlEvents(UIControlEvents.TouchUpInside);
        testButtonAction1 = _actionWorked;

        checkButton();
    }

    @Selector("checkButton")
    public void checkButton() {
        testIsHidden2 = buttonPressed.isHidden();
    }

    public void dealloc() {
        //buttonPressed.release();
        super.dealloc();
    }

    @Selector("buttonDisapear:")
    public void buttonDisapear(Object sender) {
        UIButton button = (UIButton)sender;

        if (button.isEqual(buttonPressed) ) {
            buttonPressed.setHidden(true);
            _actionWorked = true;
        }
    }

}
