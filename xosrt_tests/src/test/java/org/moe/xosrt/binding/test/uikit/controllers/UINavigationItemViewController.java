package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIBarButtonItemStyle;

public class UINavigationItemViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UINavigationItemViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UINavigationItemViewController alloc();

    @Selector("init")
    public native UINavigationItemViewController init();

    NSString  strTitle;
    NSString  strBackButtonText;
    NSString  strTitleViewText;

    public static volatile boolean testInitWithTitle1 = false;
    public static volatile boolean testTitle1 = false;
    public static volatile boolean testPrompt1 = false;
    public static volatile boolean testHidesBackButton1 = false;
    public static volatile boolean testLeftItemsSupplementBackButton1 = false;
    public static volatile boolean testBackBarButtonItem1 = false;
    public static volatile boolean testLeftBarButtonItem1 = false;
    public static volatile boolean testRightBarButtonItem1 = false;
    public static volatile boolean testLeftBarButtonItems1 = false;
    public static volatile boolean testRightBarButtonItems1 = false;

    public void testConstructorMethod() {
        String testTitle1 = "testTitle1";
        UINavigationItem navigationItem1 = UINavigationItem.alloc().initWithTitle(testTitle1);
        testInitWithTitle1 =  (navigationItem1 != null && navigationItem1.title().equals(testTitle1));
    }

    public void testProperties() {
        String test_Title1 = "testTitle1";
        String test_Title2 = "testTitle2";
        UINavigationItem navigationItem1 = UINavigationItem.alloc().initWithTitle(test_Title1);
        UINavigationItem navigationItem2 = UINavigationItem.alloc().initWithTitle(test_Title2);
        navigationItem1.setTitle(test_Title1);
        navigationItem2.setTitle(test_Title2);
        testTitle1 = (navigationItem1.title().equals(test_Title1) && navigationItem2.title().equals(test_Title2));

        String test_Prompt1 = "testPrompt1";
        String test_Prompt2 = "testPrompt2";
        UINavigationItem navigationItem3 = UINavigationItem.alloc().initWithTitle("title3");
        UINavigationItem navigationItem4 = UINavigationItem.alloc().initWithTitle("title4");
        navigationItem3.setPrompt(test_Prompt1);
        navigationItem4.setPrompt(test_Prompt2);
        testPrompt1 =  (navigationItem3.prompt().equals(test_Prompt1) && navigationItem4.prompt().equals(test_Prompt2));

        UINavigationItem navigationItem5 = UINavigationItem.alloc().initWithTitle("title5");
        UINavigationItem navigationItem6 = UINavigationItem.alloc().initWithTitle("title6");
        navigationItem5.setHidesBackButton(true);
        navigationItem6.setHidesBackButton(false);
        testHidesBackButton1 = (navigationItem5.hidesBackButton() && !navigationItem6.hidesBackButton());

        UINavigationItem navigationItem7 = UINavigationItem.alloc().initWithTitle("title7");
        UINavigationItem navigationItem8 = UINavigationItem.alloc().initWithTitle("title8");
        navigationItem7.setLeftItemsSupplementBackButton(true);
        navigationItem8.setLeftItemsSupplementBackButton(false);
        testLeftItemsSupplementBackButton1 =  (navigationItem7.leftItemsSupplementBackButton()
                && !navigationItem8.leftItemsSupplementBackButton());

    }

    public void testViewProperties1() {
        UINavigationItem navigationItem1 = UINavigationItem.alloc().initWithTitle("title5");
        UINavigationItem navigationItem2 = UINavigationItem.alloc().initWithTitle("title6");

        UIBarButtonItem backBarButtonItem1 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "backTitle1", UIBarButtonItemStyle.Bordered, null, null);
        UIBarButtonItem backBarButtonItem2 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "backTitle2", UIBarButtonItemStyle.Bordered, null, null);

        navigationItem1.setBackBarButtonItem(backBarButtonItem1);
        navigationItem2.setBackBarButtonItem(backBarButtonItem2);
        testBackBarButtonItem1 =  (navigationItem1.backBarButtonItem() == backBarButtonItem1
                && navigationItem2.backBarButtonItem() == backBarButtonItem2);

        UINavigationItem navigationItem5 = UINavigationItem.alloc().initWithTitle("title9");
        UINavigationItem navigationItem6 = UINavigationItem.alloc().initWithTitle("title10");
        UIBarButtonItem leftBarButtonItem1 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "leftBarButtonItem1", UIBarButtonItemStyle.Bordered, null, null);
        UIBarButtonItem leftBarButtonItem2 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "leftBarButtonItem2", UIBarButtonItemStyle.Bordered, null, null);
        navigationItem5.setLeftBarButtonItem(leftBarButtonItem1);
        navigationItem6.setLeftBarButtonItem(leftBarButtonItem2);
        testLeftBarButtonItem1 =  (navigationItem5.leftBarButtonItem() == leftBarButtonItem1
                && navigationItem6.leftBarButtonItem() == leftBarButtonItem2);

        UINavigationItem navigationItem7 = UINavigationItem.alloc().initWithTitle("title11");
        UINavigationItem navigationItem8 = UINavigationItem.alloc().initWithTitle("title12");
        UIBarButtonItem rightBarButtonItem1 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "rightBarButtonItem1", UIBarButtonItemStyle.Bordered, null, null);
        UIBarButtonItem rightBarButtonItem2 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "rightBarButtonItem2", UIBarButtonItemStyle.Bordered, null, null);
        navigationItem7.setRightBarButtonItem(rightBarButtonItem1);
        navigationItem8.setRightBarButtonItem(rightBarButtonItem2);
        testRightBarButtonItem1 =  (navigationItem7.rightBarButtonItem() == rightBarButtonItem1
                && navigationItem8.rightBarButtonItem() == rightBarButtonItem2);

    }

    public void testViewProperties2() {
        UINavigationItem navigationItem1 = UINavigationItem.alloc().initWithTitle("title1");
        UIBarButtonItem leftBarButtonItem1 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "leftBarButtonItem1", UIBarButtonItemStyle.Bordered, null, null);
        UIBarButtonItem leftBarButtonItem2 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "leftBarButtonItem2", UIBarButtonItemStyle.Bordered, null, null);
        UIBarButtonItem leftBarButtonItem3 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "leftBarButtonItem3", UIBarButtonItemStyle.Bordered, null, null);
        NSArray leftBarButtomItemsArray = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIBarButtonItem.class, new UIBarButtonItem[]{
                        leftBarButtonItem1, leftBarButtonItem2, leftBarButtonItem3
                }), 3);
        navigationItem1.setLeftBarButtonItems(leftBarButtomItemsArray);
        testLeftBarButtonItems1 = (navigationItem1.leftBarButtonItem() == leftBarButtonItem1
                && navigationItem1.leftBarButtonItems().objectAtIndex(0) == leftBarButtonItem1
                && navigationItem1.leftBarButtonItems().objectAtIndex(1) == leftBarButtonItem2
                && navigationItem1.leftBarButtonItems().objectAtIndex(2) == leftBarButtonItem3);

        UINavigationItem navigationItem2 = UINavigationItem.alloc().initWithTitle("title2");
        UIBarButtonItem rightBarButtonItem1 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "rightBarButtonItem4", UIBarButtonItemStyle.Bordered, null, null);
        UIBarButtonItem rightBarButtonItem2 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "rightBarButtonItem5", UIBarButtonItemStyle.Bordered, null, null);
        UIBarButtonItem rightBarButtonItem3 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "rightBarButtonItem6", UIBarButtonItemStyle.Bordered, null, null);
        NSArray rightBarButtomItemsArray = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIBarButtonItem.class, new UIBarButtonItem[]{
                        rightBarButtonItem1, rightBarButtonItem2, rightBarButtonItem3
                }), 3);
        navigationItem2.setRightBarButtonItems(rightBarButtomItemsArray);
        testRightBarButtonItems1 = (navigationItem2.rightBarButtonItem() == rightBarButtonItem1
                && navigationItem2.rightBarButtonItems().objectAtIndex(0) == rightBarButtonItem1
                && navigationItem2.rightBarButtonItems().objectAtIndex(1) == rightBarButtonItem2
                && navigationItem2.rightBarButtonItems().objectAtIndex(2) == rightBarButtonItem3);

    }

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.redColor());
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testConstructorMethod();
        testProperties();
        testViewProperties1();
        testViewProperties2();
    }

}
