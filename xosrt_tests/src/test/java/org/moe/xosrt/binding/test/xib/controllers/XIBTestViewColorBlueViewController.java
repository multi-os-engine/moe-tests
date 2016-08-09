package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIInterfaceOrientation;

public class XIBTestViewColorBlueViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestViewColorBlueViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestViewColorBlueViewController alloc();

    @Selector("init")
    public native XIBTestViewColorBlueViewController init();

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


    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testBackgroundColor2 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;
    public static volatile boolean testAlpha3 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    public void viewDidLoad() {
        super.viewDidLoad();
    }

    public void viewDidUnload() {
        super.viewDidUnload();
        // Release any retained subviews of the main view.
        // e.g. myOutlet = nil;
    }

    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testBackgroundColor1 = (view().backgroundColor().isEqual(UIColor.blueColor()));

        testBackgroundColor2 = (view1.backgroundColor().isEqual(UIColor.redColor()));

        testAlpha1 = (view2.alpha() == 0.75 );

        testAlpha2 = (view3.alpha() == 0.5 );

        testAlpha3 = (view1.alpha() == 1 );

    }

    public void viewWillDisappear(boolean animated) {
        super.viewWillDisappear(animated);
    }

    public void viewDidDisappear(boolean animated) {
        super.viewDidDisappear(animated);
    }

    @Selector("shouldAutorotateToInterfaceOrientation:")
    @Override
    public boolean shouldAutorotateToInterfaceOrientation(long interfaceOrientation) {
        // Return YES for supported orientations
        return (interfaceOrientation != UIInterfaceOrientation.PortraitUpsideDown);
    }

}
