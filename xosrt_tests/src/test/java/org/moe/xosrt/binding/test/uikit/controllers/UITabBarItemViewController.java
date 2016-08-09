package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITabBarSystemItem;

public class UITabBarItemViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UITabBarItemViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITabBarItemViewController alloc();

    @Selector("init")
    public native UITabBarItemViewController init();


    public static volatile boolean testInitWithTitle_image_tag1 = false;
    public static volatile boolean testInitWithTabBarSystemItem_tag1 = false;

    @Selector("loadView")
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.redColor());
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testInitWithTitle_image_tag();
        testInitWithTabBArSystemItem_tag();
    }

    public void testInitWithTitle_image_tag() {
        String title0 = "title0";
        String title1 = "title1";
        UIImage image0 = UIImage.imageNamed("testImage0.png");//.retain();
        UIImage image2 = UIImage.imageNamed("testImage2.png");//.retain();
        UITabBarItem tabBarItem0 = UITabBarItem.alloc().initWithTitleImageTag(title0, image0, 0);
        UITabBarItem tabBarItem1 = UITabBarItem.alloc().initWithTitleImageTag(title1, null, 1);
        UITabBarItem tabBarItem2 = UITabBarItem.alloc().initWithTitleImageTag(null, image2, 2);
        UITabBarItem tabBarItem3 = UITabBarItem.alloc().initWithTitleImageTag(null, null, 3);
        testInitWithTitle_image_tag1 =  (tabBarItem0 != null && tabBarItem0.image() == image0
                && tabBarItem0.title().equals(title0) && tabBarItem0.tag() == 0
                && tabBarItem1 != null && tabBarItem1.title().equals(title1)
                && tabBarItem1.image() == null && tabBarItem1.tag() == 1
                && tabBarItem2 != null && tabBarItem2.title() == null
                && tabBarItem2.image() == image2 && tabBarItem2.tag() == 2
                && tabBarItem3 != null && tabBarItem3.title() == null
                && tabBarItem3.image() == null && tabBarItem3.tag() == 3);
    }

    public void testInitWithTabBArSystemItem_tag() {
        UITabBarItem tabBarItem0 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.More, 0);
        UITabBarItem tabBarItem1 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.Favorites, 1);
        UITabBarItem tabBarItem2 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.Featured, 2);
        UITabBarItem tabBarItem3 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 3);
        UITabBarItem tabBarItem4 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 4);
        UITabBarItem tabBarItem5 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 5);
        UITabBarItem tabBarItem6 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 6);
        UITabBarItem tabBarItem7 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 7);
        UITabBarItem tabBarItem8 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 8);
        UITabBarItem tabBarItem9 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 9);
        UITabBarItem tabBarItem10 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 10);
        UITabBarItem tabBarItem11 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 11);
        UITabBarItem tabBarItem12 = UITabBarItem.alloc().initWithTabBarSystemItemTag(UITabBarSystemItem.TopRated, 12);
        testInitWithTabBarSystemItem_tag1 = (tabBarItem0 != null && tabBarItem0.tag() == 0
                && tabBarItem1 != null && tabBarItem1.tag() == 1
                && tabBarItem2 != null && tabBarItem2.tag() == 2
                && tabBarItem3 != null && tabBarItem3.tag() == 3
                && tabBarItem4 != null && tabBarItem4.tag() == 4
                && tabBarItem5 != null && tabBarItem5.tag() == 5
                && tabBarItem6 != null && tabBarItem6.tag() == 6
                && tabBarItem7 != null && tabBarItem7.tag() == 7
                && tabBarItem8 != null && tabBarItem8.tag() == 8
                && tabBarItem9 != null && tabBarItem9.tag() == 9
                && tabBarItem10 != null && tabBarItem10.tag() == 10
                && tabBarItem11 != null && tabBarItem11.tag() == 11
                && tabBarItem12 != null && tabBarItem12.tag() == 12);

    }

}
