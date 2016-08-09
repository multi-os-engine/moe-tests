package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestAwake0ViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestAwake0ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestAwake0ViewController alloc();

    @Selector("init")
    public native XIBTestAwake0ViewController init();

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

}
