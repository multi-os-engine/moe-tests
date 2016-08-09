package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.testhelpers.UINavigationBarTestDelegate;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIBarButtonItemStyle;
import ios.uikit.enums.UIBarStyle;

public class UINavigationBarViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UINavigationBarViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UINavigationBarViewController alloc();

    @Selector("init")
    public native UINavigationBarViewController init();

    UINavigationBarTestDelegate aDelegate;
    UINavigationItem  item1;
    UINavigationItem  item2;
    UINavigationItem  item3;
    UINavigationItem  item4;
    UINavigationItem  item5;
    UINavigationItem  item6;

    public static volatile boolean testItems1 = false;
    public static volatile boolean testTopItem1 = false;
    public static volatile boolean testBackItem1 = false;
    public static volatile boolean testBarStyle1 = false;
    public static volatile boolean testPushNavigationItem_animated1 = false;
    public static volatile boolean testPopNavigationItemAnimated1 = false;
    public static volatile boolean testSetItems_animated1 = false;
    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testDelegate2 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.whiteColor());

    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testProperties();
        performSelectorWithObjectAfterDelay(new SEL("testInstanceMethods"), null, 3);
        performSelectorWithObjectAfterDelay(new SEL("testDelegate"), null, 6);

    }

    @Selector("removeViewsFromSuperview")
    public void removeViewsFromSuperview(NSArray array) {
        //array.retain();
        for(int i = 0; i < array.count(); i++) {
            ((UIView)array.objectAtIndex(i)).removeFromSuperview();
        }
        //array.release();
    }

    public void testProperties() {

        item1 = UINavigationItem.alloc();
        item1.setTitle("First Item");

        item2 = UINavigationItem.alloc();
        item2.setTitle("Second Item");

        item3 = UINavigationItem.alloc();
        item3.setTitle("Third Item");

        item4 = UINavigationItem.alloc();
        item4.setTitle("Fourth Item");

        item5 = UINavigationItem.alloc();
        item5.setTitle("Fifth Item");

        item6 = UINavigationItem.alloc();
        item6.setTitle("Sixth Item");

        UINavigationBar bar1 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 111, 310, 50));
        view().addSubview(bar1);
        NSArray arrayItems1 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item1, item2
                }), 2);
        bar1.setItems(arrayItems1);
        UINavigationBar bar2 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 162, 320, 50));
        view().addSubview(bar2);
        NSArray arrayItems2 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item1, item2, item3
                }), 3);
        bar2.setItems(arrayItems2);
        testItems1 = (bar1.items().count() == 2 && bar2.items().count() == 3);

        UINavigationBar bar3 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 213, 320, 50));
        UINavigationBar bar4 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 264, 320, 50));
        UINavigationBar navigationBar1 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 664, 320, 50));
        view().addSubview(bar3);
        view().addSubview(bar4);
        NSArray arrayItems3 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item1, item2, item3, item4
                }), 4);
        NSArray arrayItems4 = NSArray.arrayWithObject(item1);
        bar3.setItems(arrayItems3);
        bar4.setItems(arrayItems4);
        testTopItem1 = (bar3.topItem() == item4 && bar4.topItem() == item1 && navigationBar1.topItem() == null);

        UINavigationBar bar5 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 315, 320, 50));
        UINavigationBar bar6 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 366, 320, 50));
        UINavigationBar navigationBar2 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 564, 320, 50));
        UINavigationBar navigationBar3 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 764, 320, 50));
        UINavigationItem navigationItem1 = UINavigationItem.alloc().initWithTitle("navigationItem1");
        navigationBar2.pushNavigationItemAnimated(navigationItem1, false);
        view().addSubview(bar5);
        view().addSubview(bar6);
        NSArray arrayItems5 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item3, item2, item4, item5, item6
                }), 5);
        NSArray arrayItems6 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{item1, item2}), 2);
        bar5.setItems(arrayItems5);
        bar6.setItemsAnimated(arrayItems6, false);
        testBackItem1 = (bar5.backItem() == item5 && bar6.backItem() == item1
                && navigationBar2.backItem() == null && navigationBar3.backItem() == null);

        UINavigationBar navigationBar4 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(350, 100, 320, 50));
        UINavigationBar navigationBar5 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(350, 200, 320, 50));
        UINavigationBar navigationBar6 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(350, 300, 320, 50));
        UINavigationBar navigationBar7 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(350, 400, 320, 50));
        UINavigationBar navigationBar8 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(350, 500, 320, 50));
        UINavigationItem navigationItem2 = UINavigationItem.alloc().initWithTitle("navigationBar4");
        UINavigationItem navigationItem3 = UINavigationItem.alloc().initWithTitle("navigationBar5");
        UINavigationItem navigationItem4 = UINavigationItem.alloc().initWithTitle("navigationBar6");
        UINavigationItem navigationItem5 = UINavigationItem.alloc().initWithTitle("navigationBar7");
        UINavigationItem navigationItem6 = UINavigationItem.alloc().initWithTitle("navigationBar8");
        navigationItem2.setLeftBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "left", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem3.setLeftBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "left", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem4.setLeftBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "left", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem5.setLeftBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "left", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem6.setLeftBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "left", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem2.setRightBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "right", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem3.setRightBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "right", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem4.setRightBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "right", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem5.setRightBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "right", UIBarButtonItemStyle.Bordered, null, null));
        navigationItem6.setRightBarButtonItem(UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "right", UIBarButtonItemStyle.Bordered, null, null));
        navigationBar4.pushNavigationItemAnimated(navigationItem2, false);
        navigationBar5.pushNavigationItemAnimated(navigationItem3, false);
        navigationBar6.pushNavigationItemAnimated(navigationItem4, false);
        navigationBar7.pushNavigationItemAnimated(navigationItem5, false);
        navigationBar8.pushNavigationItemAnimated(navigationItem6, false);
        navigationBar5.setBarStyle(UIBarStyle.Default);
        navigationBar6.setBarStyle(UIBarStyle.Black);
        navigationBar7.setBarStyle(UIBarStyle.BlackOpaque);
        navigationBar8.setBarStyle(UIBarStyle.BlackTranslucent);
        view().addSubview(navigationBar4);
        view().addSubview(navigationBar5);
        view().addSubview(navigationBar6);
        view().addSubview(navigationBar7);
        view().addSubview(navigationBar8);

        testBarStyle1 = (navigationBar4.barStyle() == UIBarStyle.Default
                && navigationBar5.barStyle() == UIBarStyle.Default
                && navigationBar6.barStyle() == UIBarStyle.Black
                && navigationBar7.barStyle() == UIBarStyle.BlackOpaque
                && navigationBar8.barStyle() == UIBarStyle.BlackTranslucent);

        performSelectorWithObjectAfterDelay(
                new SEL("removeViewsFromSuperview"), NSArray.arrayWithObjectsCount(
                    (Ptr) PtrFactory.newObjectArray(UINavigationBar.class, new UINavigationBar[]{
                            bar1, bar2, bar3, bar4, bar5, bar6
                    }), 6)
                , 2);
    }

    @Selector("testInstanceMethods")
    public void testInstanceMethods() {
        item1 = UINavigationItem.alloc();
        item1.setTitle("First Item");

        item2 = UINavigationItem.alloc();
        item2.setTitle("Second Item");

        item3 = UINavigationItem.alloc();
        item3.setTitle("Third Item");

        item4 = UINavigationItem.alloc();
        item4.setTitle("Fourth Item");

        UINavigationBar bar1 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 100, 250, 50));
        view().addSubview(bar1);
        bar1.setItems((NSArray)NSArray.array());
        bar1.pushNavigationItemAnimated(item1, false);
        bar1.pushNavigationItemAnimated(item2, false);
        bar1.pushNavigationItemAnimated(item3, true);
        testPushNavigationItem_animated1 = (bar1.topItem() == item3);

        UINavigationBar bar2 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 151, 300, 50));
        view().addSubview(bar2);
        NSArray arrayItems1 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item1, item2, item3
                }), 3);
        bar2.setItems(arrayItems1);
        bar2.popNavigationItemAnimated(false);
        bar2.popNavigationItemAnimated(true);
        testPopNavigationItemAnimated1 = (bar2.topItem() == item1);

        UINavigationBar bar3 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 202, 320, 50));
        view().addSubview(bar3);
        NSArray arrayItems2 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item3, item2, item4
                }), 3);
        UINavigationBar bar4 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 253, 290, 50));
        view().addSubview(bar4);
        NSArray arrayItems3 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item1, item3
                }), 2);
        bar3.setItemsAnimated(arrayItems2, true);
        bar4.setItems(arrayItems3);
        testSetItems_animated1 = (bar3.items().count() == 3 && bar4.items().count() == 2);

        performSelectorWithObjectAfterDelay(
                new SEL("removeViewsFromSuperview"), NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                    UINavigationBar.class, new UINavigationBar[]{
                            bar1, bar2, bar3, bar4
                    }), 4)
                , 2);

    }

    @Selector("testDelegate")
    public void testDelegate() {

        item1 = UINavigationItem.alloc();
        item1.setTitle("First Item");

        item2 = UINavigationItem.alloc();
        item2.setTitle("Second Item");

        item3 = UINavigationItem.alloc();
        item3.setTitle("Third Item");

        item4 = UINavigationItem.alloc();
        item4.setTitle("Fourth Item");

        item5 = UINavigationItem.alloc();
        item5.setTitle("Fifth Item");

        item6 = UINavigationItem.alloc();
        item6.setTitle("Sixth Item");

        aDelegate = UINavigationBarTestDelegate.alloc().init();
        UINavigationBar bar1 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 0, 300, 50));
        view().addSubview(bar1);
        bar1.setDelegate(aDelegate);
        UINavigationBar bar2 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(30, 60, 200, 50));
        view().addSubview(bar2);
        bar2.setDelegate(aDelegate);
        testDelegate1 = (bar1.delegate() == aDelegate && bar2.delegate() == aDelegate);

        UINavigationBarTestDelegate delegate1 = UINavigationBarTestDelegate.alloc().init();
        UINavigationBarTestDelegate delegate2 = UINavigationBarTestDelegate.alloc().init();
        delegate1.shouldPushCount = 0;
        delegate1.didPushCount = 0;
        delegate2.shouldPopCount = 0;
        delegate2.didPopCount = 0;
        delegate1.navigationItem = item6;
        delegate2.navigationItem = item4;
        UINavigationBar bar3 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 111 , 320, 60));
        UINavigationBar bar4 = UINavigationBar.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 172, 320, 50));
        view().addSubview(bar3);
        view().addSubview(bar4);
        bar3.setItems(NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item1, item2, item3, item4
                }), 4));
        bar4.setItems(NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavigationItem.class, new UINavigationItem[]{
                        item1, item2, item3, item4, item5
                }), 5));
        bar3.setDelegate(delegate1);
        bar4.setDelegate(delegate2);
        bar3.pushNavigationItemAnimated(item5, false);
        bar3.pushNavigationItemAnimated(item6, true);
        bar4.popNavigationItemAnimated(false);
        bar4.popNavigationItemAnimated(true);
        testDelegate2 =  (bar3.topItem() == item5 && bar4.topItem() == item4
                && delegate1.didPushCount == 1 && delegate1.shouldPushCount == 2
                && delegate2.didPopCount == 1 && delegate2.shouldPopCount == 2) ;
    }

}
