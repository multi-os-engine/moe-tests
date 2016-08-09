package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class UIMenuControllerViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIMenuControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIMenuControllerViewController alloc();

    @Selector("init")
    public native UIMenuControllerViewController init();

    NSString  strTitle;
    UIMenuController menuController;
    UITextView textView1;
    UITextView textView2;
    UITextField textField1;
    UIMenuItem menuItem1;
    UIMenuItem menuItem2;

    public static volatile boolean testSharedMenuController1 = false;
    public static volatile boolean testSetTargetRect_inView1 = false;
    public static volatile boolean testMenuVisible1 = false;
    public static volatile boolean testMenuItems1 = false;
	
    public void actionItem(NSObject o) {
        textView1.setText("You selected testTitle2");
    }

    public void actionItem2(NSObject o) {
        textView1.setText("You selected testTitle3");
        menuItem2.setAction(new SEL("newAction:"));
    }

    public void newAction(NSObject o) {
        textView1.setText("Now execute new action in testTitle3");
    }

    public void testMethod() {
        menuController = UIMenuController.sharedMenuController();
        testSharedMenuController1 = menuController != null;

        textView1.becomeFirstResponder();
        CGRect selectionRect = CoreGraphics.CGRectMake(0, 0, 0, 0);
        menuController.setTargetRectInView(selectionRect, view());
        testSetTargetRect_inView1 = (CoreGraphics.CGRectEqualToRect(menuController.menuFrame(), selectionRect)) ;

        menuController.setMenuVisibleAnimated(false, true);
        testMenuVisible1 = !menuController.isMenuVisible();

        menuController.setMenuVisibleAnimated(true, true);


        String testTitle2 = "testTitle2";
        String testTitle3 = "testTitle3";
        UIMenuItem item1 = UIMenuItem.alloc().initWithTitleAction(testTitle3, new SEL("action1:"));
        UIMenuItem item2 = UIMenuItem.alloc().initWithTitleAction(testTitle2, new SEL("action2:"));
        item1.setTitle(testTitle2);
        item2.setTitle(testTitle3);
        menuController.setMenuItems(NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIMenuItem.class, new UIMenuItem[]{
                        item1, item2
                }), 2));
        System.out.println("menuController.menuItems().count() = " + menuController.menuItems().count());
        testMenuItems1 = menuController.menuItems().count() == 2;
    }

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.redColor());
        String text3 = "This is a TextField";
        textField1 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 20, 300, 30));
        textField1.setText(text3);
        String text = "Select here";
        textView1 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 50, 300, 100));
        textView1.setText(text);
        String text2 = "OR select here";
        textView2 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 160, 300, 100));
        textView2.setText(text2);
        view().addSubview(textField1);
        view().addSubview(textView1);
        view().addSubview(textView2);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testMethod();
    }
}
