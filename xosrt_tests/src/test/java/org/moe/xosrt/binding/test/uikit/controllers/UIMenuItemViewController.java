package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.*;
import ios.uikit.*;

public class UIMenuItemViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIMenuItemViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIMenuItemViewController alloc();

    @Selector("init")
    public native UIMenuItemViewController init();

    NSString  strTitle;
    UIMenuController menuController;
    UITextView textView1;
    UIMenuItem menuItem1;
    UIMenuItem menuItem2;

    public static volatile boolean testInitWithTitle_action1 = false;
    public static volatile boolean testTitle1 = false;
    public static volatile boolean testAction1 = false;

    public void testConstructorMethod() {
        String testTitle1 = "testMenuItemTitle1";
        menuItem1 = UIMenuItem.alloc().initWithTitleAction(testTitle1, new SEL("actionItem:"));
        testInitWithTitle_action1 =  (menuItem1 != null && menuItem1.title().equals(testTitle1)) ;
    }

    private boolean actionItem = false;
    private boolean actionItem2 = false;

    @Selector("actionItem:")
    public Object actionItem(Object o) {
        actionItem = true;
        textView1.setText("You selected testTitle2");
        return null;
    }

    @Selector("actionItem2:")
    public Object actionItem2(Object o) {
        actionItem2 = true;
        textView1.setText("You selected testTitle3");
        menuItem2.setAction(new SEL("newAction:"));
        return null;
    }

    @Selector("newAction:")
    public void newAction(Object o) {
        textView1.setText("Now execute new action in testTitle3");
    }

    public void testProperties() {
        String testTitle2 = "testTitle2";
        String testTitle3 = "testTitle3";
        menuItem1 = UIMenuItem.alloc().initWithTitleAction(testTitle3, new SEL("actionItem:"));
        menuItem2 = UIMenuItem.alloc().initWithTitleAction(testTitle2, new SEL("actionItem2:"));
        menuItem1.setTitle(testTitle2);
        menuItem2.setTitle(testTitle3);
        testTitle1 = (menuItem1.title().equals(testTitle2) && menuItem2.title().equals(testTitle3));

        menuController.setMenuItems(NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIMenuItem.class, new UIMenuItem[]{
                        menuItem1, menuItem2
                }), 2));
        this.performSelectorWithObject(menuItem1.action(), null);
        this.performSelectorWithObject(menuItem2.action(), null);
        testAction1 = (actionItem && actionItem2);
    }

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.redColor());
        String text = "Select here";
        textView1 = (UITextView)UITextView.alloc().initWithFrame(
                CoreGraphics.CGRectMake(10, 40, 300, 200));
        textView1.setText(text);
        view().addSubview(textView1);
        menuController = UIMenuController.sharedMenuController();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testConstructorMethod();
        testProperties();
    }
}
