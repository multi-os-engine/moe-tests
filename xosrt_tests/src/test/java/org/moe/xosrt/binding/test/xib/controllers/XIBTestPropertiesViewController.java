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
import ios.uikit.enums.UIInterfaceOrientation;

public class XIBTestPropertiesViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestPropertiesViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestPropertiesViewController alloc();

    @Selector("init")
    public native XIBTestPropertiesViewController init();

    UILabel lbl;
    UIButton btn;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "lbl":
                lbl = (UILabel)value;
                break;
            case "btn":
                btn = (UIButton)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "lbl":
                return lbl;
            case "btn":
                return btn;
            default:
                return super.valueForKey(key);
        }
    }

    public static volatile boolean testProperty1 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        // Do any additional setup after loading the view, typically from a nib.
        performSelectorWithObjectAfterDelay(new SEL("clickButton:"), btn, 2);
    }

    public void viewDidUnload() {
        super.viewDidUnload();
        // Release any retained subviews of the main view. // e.g. myOutlet = nil;
    }

    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
    }

    public void viewWillDisappear(boolean animated) {
        super.viewWillDisappear(animated);
    }

    public void viewDidDisappear(boolean animated) {
        super.viewDidDisappear(animated);
    }

    public boolean shouldAutorotateToInterfaceOrientation(long interfaceOrientation) {
        // Return YES for supported orientations
        return (interfaceOrientation != UIInterfaceOrientation.PortraitUpsideDown);
    }

    @Selector("clickButton:")
    public void clickButton(Object sender) {
        lbl.setText("Clicked!!");
        testProperty1 = (lbl.text().equals("Clicked!!"));
    }

}
