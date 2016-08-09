package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.NSMutableArray;
import ios.foundation.NSString;
import ios.uikit.UIAlertView;
import ios.uikit.UIColor;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.protocol.UIAlertViewDelegate;

public class UIAlertViewTestViewController extends UIViewController implements UIAlertViewDelegate {

    NSMutableArray array;
    NSString title;
    NSString message;
    NSString titleCancel;

    UIView newView;
    UIAlertView alert1;

    public static boolean testShow1Passed = false;
    public static boolean testShow2Passed = false;
    public static boolean testShow3Passed = false;
    public static boolean checkDelegateMethodPassed = false;
    public static boolean testStaticCallPassed = false;

    static {
        NatJ.register();
    }

    protected UIAlertViewTestViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIAlertViewTestViewController alloc();

    @Selector("init")
    public native UIAlertViewTestViewController init();

    @Selector("loadView")
    @Override
    public void loadView() {
        array = NSMutableArray.alloc().initWithCapacity(2);
        title = NSString.stringWithString("Title");
        message = NSString.stringWithString("Message");
        titleCancel = NSString.stringWithString("Cancel");

        newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 320, 460));
        newView.setBackgroundColor(UIColor.whiteColor());

        setView(newView);
        try {
            testMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void staticCall() {
        UIAlertView alert = UIAlertView.alloc().init();
        String cancelTitle = "Title cancel";
        alert.setTitle("HOLA");
        alert.setMessage("message");
        alert.setDelegate(null);
        alert.setCancelButtonIndex(alert.addButtonWithTitle(cancelTitle));
        alert.show();
        testStaticCallPassed = alert.isVisible();
    }

    public void testMethod() throws NoSuchMethodException {
        alert1 = UIAlertView.alloc().init();
        UIAlertView alert2 = UIAlertView.alloc().init();
        UIAlertView alert3 = UIAlertView.alloc().init();
        alert1.setDelegate(this);
        alert1.show();
        testShow1Passed = alert1.isVisible();

        performSelectorWithObjectAfterDelay(new SEL("checkDelegateMethod"), null, 2);
        alert2.show();
        alert3.show();

        testShow2Passed = !alert1.isVisible();
        testShow3Passed = !alert2.isVisible() && alert3.isVisible();
    }

    @Selector("checkDelegateMethod")
    public void checkDelegateMethod() {
        checkDelegateMethodPassed = array.objectAtIndex(0).equals("willPresentAlertView")
                && array.objectAtIndex(1).equals("didPresentAlertView");
        UIAlertViewTestViewController.staticCall();
        alert1.dismissWithClickedButtonIndexAnimated(0, false); //do we need it?
    }

    @Selector("willPresentAlertView:")
    @Override
    public void willPresentAlertView(UIAlertView uiAlertView) {
        array.addObject(NSString.stringWithString("willPresentAlertView"));
    }

    @Selector("didPresentAlertView:")
    @Override
    public void didPresentAlertView(UIAlertView uiAlertView) {
        array.addObject(NSString.stringWithString("didPresentAlertView"));
    }

    @Override
    public void alertViewClickedButtonAtIndex(UIAlertView uiAlertView, long l) {

    }

    @Override
    public void alertViewDidDismissWithButtonIndex(UIAlertView uiAlertView, long l) {

    }

    @Override
    public void alertViewWillDismissWithButtonIndex(UIAlertView uiAlertView, long l) {

    }

    @Override
    public void alertViewCancel(UIAlertView uiAlertView) {

    }

    @Override
    public boolean alertViewShouldEnableFirstOtherButton(UIAlertView uiAlertView) {
        return false;
    }

}
