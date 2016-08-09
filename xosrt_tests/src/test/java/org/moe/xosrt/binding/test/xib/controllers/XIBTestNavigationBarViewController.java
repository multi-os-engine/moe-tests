package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestNavigationBarViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestNavigationBarViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestNavigationBarViewController alloc();

    @Selector("init")
    public native XIBTestNavigationBarViewController init();

    UINavigationBar navBar;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "navBar":
                navBar = (UINavigationBar)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "navBar":
                return navBar;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testPrompt1 = false;
    public static volatile boolean testTitle1 = false;
    public static volatile boolean testItems1 = false;
    public static volatile boolean testAlpha1 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        testFrame1 =  (navBar.frame().origin().x() == 0 && navBar.frame().origin().y() == 92
                && navBar.frame().size().width() == 320 && navBar.frame().size().height() == 74);

        testPrompt1 = (navBar.topItem().prompt().equals("prompt"));

        testTitle1 = (navBar.topItem().title().equals("Navigation Bar"));

        testItems1 = (navBar.items().count() == 1);

        testAlpha1 = (navBar.alpha() == 0.5);

    }

}
