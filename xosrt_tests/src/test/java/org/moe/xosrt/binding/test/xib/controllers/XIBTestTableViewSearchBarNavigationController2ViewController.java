package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestTableViewSearchBarNavigationController2ViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewSearchBarNavigationController2ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewSearchBarNavigationController2ViewController alloc();

    @Selector("init")
    public native XIBTestTableViewSearchBarNavigationController2ViewController init();

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        setTitle("Secondary");
    }

}
