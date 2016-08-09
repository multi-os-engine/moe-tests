package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.protocol.UITabBarDelegate;

public class XIBTestTabBarViewController extends UIViewController implements UITabBarDelegate {

    static {
        NatJ.register();
    }

    protected XIBTestTabBarViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTabBarViewController alloc();

    @Selector("init")
    public native XIBTestTabBarViewController init();

    UITabBar tabBar;
    
    UITabBarItem item1;
    UITabBarItem item2;
    UITabBarItem item3;
    

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "tabBar":
                tabBar = (UITabBar)value;
                break;
            case "item1":
                item1 = (UITabBarItem)value;
                break;
            case "item2":
                item2 = (UITabBarItem)value;
                break;
            case "item3":
                item3 = (UITabBarItem)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "tabBar":
                return tabBar;
            case "item1":
                return item1;
            case "item2":
                return item2;
            case "item3":
                return item3;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrameBar1 = false;
    public static volatile boolean testCountItems1 = false;
    public static volatile boolean testTitleItem11 = false;
    public static volatile boolean testTitleItem21 = false;
    public static volatile boolean testTitleItem31 = false;
    public static volatile boolean testImgItem11 = false;
    public static volatile boolean testImgItem21 = false;
    public static volatile boolean testImgItem31 = false;
    public static volatile boolean testAlpha1 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrameBar1 =  (tabBar.frame().origin().x() == 0 && tabBar.frame().origin().y() == 411 && tabBar.frame().size().width() == 320 && tabBar.frame().size().height() == 49) ;

        long items = tabBar.items().count();
        testCountItems1 = (items == 3) ;

        String title1 = item1.title();
        testTitleItem11 =  (title1.equals("Item1"));

        String title2 = item2.title();
        testTitleItem21 =  (title2.equals("Item2"));

        String title3 = item3.title();
        testTitleItem31 = (title3.equals(""));

        UIImage img = item1.image();
        testImgItem11 = (img != null);

        UIImage img2 = item2.image();
        testImgItem21 = ( img2 == null);

        UIImage img3 = item3.image();
        testImgItem31 = (img3 != null);

        testAlpha1 = (tabBar.alpha() == 0.5);

    }


    @Override
    public void tabBarDidBeginCustomizingItems(UITabBar uiTabBar, NSArray nsArray) {

    }

    @Override
    public void tabBarDidEndCustomizingItemsChanged(UITabBar uiTabBar, NSArray nsArray, boolean b) {

    }

    @Override
    public void tabBarDidSelectItem(UITabBar uiTabBar, UITabBarItem uiTabBarItem) {

    }

    @Override
    public void tabBarWillBeginCustomizingItems(UITabBar uiTabBar, NSArray nsArray) {

    }

    @Override
    public void tabBarWillEndCustomizingItemsChanged(UITabBar uiTabBar, NSArray nsArray, boolean b) {

    }
}
