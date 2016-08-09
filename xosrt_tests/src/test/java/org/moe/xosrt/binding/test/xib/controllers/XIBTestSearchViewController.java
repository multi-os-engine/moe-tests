package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestSearchViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestSearchViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestSearchViewController alloc();

    @Selector("init")
    public native XIBTestSearchViewController init();

    UISearchBar searchBar;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "searchBar":
                searchBar = (UISearchBar)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "searchBar":
                return searchBar;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testText1 = false;
    public static volatile boolean testPlaceholder1 = false;
    public static volatile boolean testFrame1 = false;
    public static volatile boolean testAlpha1 = false;

    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testText1 = ("abc".equals(searchBar.text()));


        testPlaceholder1 = ("find text".equals(searchBar.placeholder()));

        testFrame1 = (searchBar.frame().origin().x() == 0 && searchBar.frame().origin().y() == 74
                && searchBar.frame().size().width() == 320 && searchBar.frame().size().height() == 44);

        testAlpha1 = (searchBar.alpha() == 0.5);
    }

}
