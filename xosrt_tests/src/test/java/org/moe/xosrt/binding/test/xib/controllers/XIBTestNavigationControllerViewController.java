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
import ios.uikit.enums.UIControlEvents;

public class XIBTestNavigationControllerViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestNavigationControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestNavigationControllerViewController alloc();

    @Selector("init")
    public native XIBTestNavigationControllerViewController init();

    XIBTestNavigationControllerViewTwoController viewTwoController;
    UIButton button;
    boolean pushed = false;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "button":
                button = (UIButton)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "button":
                return button;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testTitle1 = false;
    public static volatile boolean testTabBarItem1 = false;
    public static volatile boolean testPushViewController_animated1 = false;

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        testXIBFileProperties();
        button.sendActionsForControlEvents(UIControlEvents.TouchUpInside);

    }

    @Selector("switchPage:")
    public void switchPage(Object sender) {
        if(viewTwoController == null) {
            XIBTestNavigationControllerViewTwoController viewTwo = (XIBTestNavigationControllerViewTwoController)
                    XIBTestNavigationControllerViewTwoController.alloc().initWithNibNameBundle(
                            "XIBTestNavigationControllerViewTwoController", NSBundle.mainBundle());
            viewTwo.back = this;
            viewTwoController = viewTwo;
            //viewTwo.release();
        }
        setPushed(false);
        performSelectorWithObjectAfterDelay(new SEL("testPushViewController"), null, 3);
        navigationController().pushViewControllerAnimated(viewTwoController, true);
    }

    @Selector("setPushed:")
    public void setPushed(boolean bPushed) {
        pushed = bPushed;
    }

    @Selector("testXIBFileProperties")
    public void testXIBFileProperties() {
        testTitle1 =  (navigationController().title().equals("NavigationController title")) ;

        testTabBarItem1 =  (navigationController().tabBarItem().tag() == 3);
    }

    @Selector("testPushViewController")
    public void testPushViewController() {
        testPushViewController_animated1 = pushed;
    }

}
