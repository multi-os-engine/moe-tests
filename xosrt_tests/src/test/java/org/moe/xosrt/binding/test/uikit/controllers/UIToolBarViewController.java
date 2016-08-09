package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIBarButtonItemStyle;
import ios.uikit.enums.UIBarStyle;

public class UIToolBarViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIToolBarViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIToolBarViewController alloc();

    @Selector("init")
    public native UIToolBarViewController init();

    UIToolbar toolbar;
    NSMutableArray items;

    public static volatile boolean testBarStyle1 = false;
    public static volatile boolean testBarStyle2 = false;
    public static volatile boolean testItems1 = false;
    public static volatile boolean testSetItems_animated1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().applicationFrame()));
        view().setBackgroundColor(UIColor.grayColor());
        toolbar = UIToolbar.alloc().init();
        toolbar.setFrame(CoreGraphics.CGRectMake(0, 0, view().frame().size().width(), 44));

        view().addSubview(toolbar);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testMethod();
    }

    public void testMethod() {
        testBarStyle1 = (toolbar.barStyle() == UIBarStyle.Default);

        toolbar.setBarStyle(UIBarStyle.Black);
        testBarStyle2 = (toolbar.barStyle() == UIBarStyle.Black);

        items = NSMutableArray.alloc().init();
        UIBarButtonItem barItem = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "title 1", UIBarButtonItemStyle.Plain, this, new SEL("info_clicked:"));
        UIBarButtonItem barItem2 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "title 2", UIBarButtonItemStyle.Done, this, new SEL("info_clicked:"));

        items.addObject(barItem);
        items.addObject(barItem2);
        toolbar.setItems(items);

        testItems1 = (toolbar.items().count() == 2);

        UIBarButtonItem barItem3 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "title 3", UIBarButtonItemStyle.Bordered, this, new SEL("info_clicked:"));
        items.addObject(barItem3);
        toolbar.setItemsAnimated(items, true);

        testSetItems_animated1 = (toolbar.items().count() == 3);

        toolbar.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = !toolbar.isUserInteractionEnabled();


    }

    @Selector("info_clicked:")
    public void info_clicked(Object o) {
    }

}
