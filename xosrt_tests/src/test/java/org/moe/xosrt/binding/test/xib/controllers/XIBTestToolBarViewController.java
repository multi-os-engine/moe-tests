package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.IBAction;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestToolBarViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestToolBarViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestToolBarViewController alloc();

    @Selector("init")
    public native XIBTestToolBarViewController init();

    UIToolbar toolBar;
    
    UIBarButtonItem item1;
    UIBarButtonItem item2;
    UIBarButtonItem item3;
    
    UILabel label;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "toolBar":
                toolBar = (UIToolbar)value;
                break;
            case "item1":
                item1 = (UIBarButtonItem)value;
                break;
            case "item2":
                item2 = (UIBarButtonItem)value;
                break;
            case "item3":
                item3 = (UIBarButtonItem)value;
                break;
            case "label":
                label = (UILabel)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "toolBar":
                return toolBar;
            case "item1":
                return item1;
            case "item2":
                return item2;
            case "item3":
                return item3;
            case "label":
                return label;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testAlpha1 = false;

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        testMethod();
    }

    @IBAction
    @Selector("clickItem1:")
    public void clickItem1(Object sender) {
        label.setText("Button 1 clicked");
    }

    @IBAction
    @Selector("clickItem2:")
    public void clickItem2(Object sender) {
        label.setText("Button 2 clicked");
    }

    @IBAction
    @Selector("clickItem3:")
    public void clickItem3(Object sender) {
        label.setText("Button 3 clicked");
    }

    public void testMethod() {
        testFrame1 = (toolBar.frame().origin().x() == 0 && toolBar.frame().origin().y() == 90
                && toolBar.frame().size().width() == 320 && toolBar.frame().size().height() == 44);

        testAlpha1 = (toolBar.alpha() == 0.5);

    }

}
