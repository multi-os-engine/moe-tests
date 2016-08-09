package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.xib.testhelpers.UserView;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIInterfaceOrientation;

public class XIBTestUserViewViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestUserViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestUserViewViewController alloc();

    @Selector("init")
    public native XIBTestUserViewViewController init();

    UserView userView;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "userView":
                userView = (UserView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "userView":
                return userView;
            default:
                return super.valueForKey(key);
        }
    }

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    public void viewDidLoad() {
        super.viewDidLoad();
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

}
