package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class UIResponderViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIResponderViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIResponderViewController alloc();

    @Selector("init")
    public native UIResponderViewController init();

    public static volatile boolean testBecomeFirstResponder1 = false;
    public static volatile boolean testResignFirstResponder1 = false;
    public static volatile boolean testResignFirstResponder2 = false;
    public static volatile boolean testBecomeFirstResponder2 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIView newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480));
        newView.setBackgroundColor(UIColor.blueColor());

        UITextField textField1 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 50, 300, 50));
        String newText = "text1";
        textField1.setText(newText);
        textField1.setTag(1454);

        UITextView textview1 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(50, 90, 300, 50));
        textview1.setText("text2");
        textview1.setTag(14543);

        setView(newView);
        view().addSubview(textField1);
        view().addSubview(textview1);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {

        UITextField textField1 = (UITextField)view().viewWithTag(1454);
        testBecomeFirstResponder1 = textField1.becomeFirstResponder();

        testResignFirstResponder1 = textField1.resignFirstResponder();

        UITextView textview1 = (UITextView)view().viewWithTag(14543);
        testResignFirstResponder2 = !textview1.resignFirstResponder();

        testBecomeFirstResponder2 = textview1.becomeFirstResponder();
    }

}
