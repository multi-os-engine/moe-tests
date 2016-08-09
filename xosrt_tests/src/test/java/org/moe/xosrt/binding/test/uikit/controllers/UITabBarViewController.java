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
import ios.uikit.protocol.UITabBarDelegate;

public class UITabBarViewController extends UIViewController implements UITabBarDelegate {

    static {
        NatJ.register();
    }

    protected UITabBarViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITabBarViewController alloc();

    @Selector("init")
    public native UITabBarViewController init();


    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testItems1 = false;
    public static volatile boolean testSelectedItem1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.blueColor());
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testProperties();
    }

    public void testProperties() {
        String string1 = "item1";
        String string2 = "item2";
        String string3 = "item3";
        String string4 = "item4";
        String string5 = "item5";
        String string6 = "item6";

        UIImage image0 = UIImage.imageNamed("testImage0.png");
        UIImage image1 = UIImage.imageNamed("testImage1.png");
        UIImage image2 = UIImage.imageNamed("testImage2.png");
        UIImage image3 = UIImage.imageNamed("testImage3.png");
        UIImage image4 = UIImage.imageNamed("testImage4.png");

        UITabBar tabBar1 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 10, 300, 50));
        tabBar1.setDelegate(this);
        UITabBar tabBar2 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 10, 300, 50));
        tabBar2.setDelegate(this);
        testDelegate1 = (tabBar1.delegate() == this && tabBar2.delegate() == this);

        UITabBar tabBar3 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 10, 300, 50));
        tabBar3.setTag(3);
        UITabBar tabBar4 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 70, 300, 40));
        tabBar4.setTag(4);
        UITabBar tabBar5 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 130, 300, 50));
        tabBar5.setTag(5);
        UITabBar tabBar6 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 190, 300, 100));
        tabBar6.setTag(6);
        UITabBarItem tabBar3Item1 = UITabBarItem.alloc().initWithTitleImageTag(string1, image0, 31);
        UITabBarItem tabBar3Item2 = UITabBarItem.alloc().initWithTitleImageTag(string2, null, 32);
        UITabBarItem tabBar3Item3 = UITabBarItem.alloc().initWithTitleImageTag(string3, null, 33);
        UITabBarItem tabBar3Item4 = UITabBarItem.alloc().initWithTitleImageTag(string4, null, 34);
        UITabBarItem tabBar4Item1 = UITabBarItem.alloc().initWithTitleImageTag(string1, image1, 41);
        UITabBarItem tabBar4Item2 = UITabBarItem.alloc().initWithTitleImageTag(string2, null, 42);
        UITabBarItem tabBar4Item3 = UITabBarItem.alloc().initWithTitleImageTag(string3, null, 43);
        UITabBarItem tabBar4Item4 = UITabBarItem.alloc().initWithTitleImageTag(string4, null, 44);
        UITabBarItem tabBar4Item5 = UITabBarItem.alloc().initWithTitleImageTag(string5, null, 45);
        UITabBarItem tabBar5Item1 = UITabBarItem.alloc().initWithTitleImageTag(string1, image2, 51);
        UITabBarItem tabBar5Item2 = UITabBarItem.alloc().initWithTitleImageTag(string2, null, 52);
        UITabBarItem tabBar5Item3 = UITabBarItem.alloc().initWithTitleImageTag(string3, null, 53);
        UITabBarItem tabBar5Item4 = UITabBarItem.alloc().initWithTitleImageTag(string4, null, 54);
        UITabBarItem tabBar5Item5 = UITabBarItem.alloc().initWithTitleImageTag(string5, null, 55);
        UITabBarItem tabBar5Item6 = UITabBarItem.alloc().initWithTitleImageTag(string6, null, 56);
        UITabBarItem tabBar6Item1 = UITabBarItem.alloc().initWithTitleImageTag(string1, image3, 61);
        UITabBarItem tabBar6Item2 = UITabBarItem.alloc().initWithTitleImageTag(string2, null, 62);
        NSArray array1 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UITabBarItem.class, new UITabBarItem[]{
                        tabBar3Item1, tabBar3Item2, tabBar3Item3, tabBar3Item4
                }), 4);
        NSArray array2 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UITabBarItem.class, new UITabBarItem[]{
                        tabBar4Item1, tabBar4Item2, tabBar4Item3, tabBar4Item4, tabBar4Item5
                }), 5);
        NSArray array3 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UITabBarItem.class, new UITabBarItem[]{
                        tabBar5Item1, tabBar5Item2, tabBar5Item3, tabBar5Item4, tabBar5Item5, tabBar5Item6
                }), 6);
        NSArray array4 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UITabBarItem.class, new UITabBarItem[]{
                        tabBar6Item1, tabBar6Item2
                }), 2);
        tabBar3.setItems(array1);
        tabBar4.setItems(array2);
        tabBar5.setItems(array3);
        tabBar6.setItems(array4);
        view().addSubview(tabBar3);
        view().addSubview(tabBar4);
        view().addSubview(tabBar5);
        view().addSubview(tabBar6);
        testItems1 = (arraysHaveEqualItems(tabBar3.items(), array1)
                && arraysHaveEqualItems(tabBar4.items(), array2)
                && arraysHaveEqualItems(tabBar5.items(), array3)
                && arraysHaveEqualItems(tabBar6.items(), array4));

        UITabBar tabBar7 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 300, 300, 50));
        tabBar7.setTag(7);
        UITabBar tabBar8 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 360, 300, 50));
        tabBar8.setTag(8);
        UITabBar tabBar9 = UITabBar.alloc().initWithFrame(CoreGraphics.CGRectMake(500, 420, 300, 30));
        tabBar9.setBounds(CoreGraphics.CGRectMake(0, 0, 480, 250));
        tabBar9.setTag(9);
        UITabBarItem tabBar7Item1 = UITabBarItem.alloc().initWithTitleImageTag(string1, null, 71);
        UITabBarItem tabBar7Item2 = UITabBarItem.alloc().initWithTitleImageTag(string2, null, 72);
        UITabBarItem tabBar7Item3 = UITabBarItem.alloc().initWithTitleImageTag(string3, null, 73);
        UITabBarItem tabBar8Item1 = UITabBarItem.alloc().initWithTitleImageTag(string1, null, 71);
        UITabBarItem tabBar8Item2 = UITabBarItem.alloc().initWithTitleImageTag(string2, image4, 72);
        UITabBarItem tabBar8Item3 = UITabBarItem.alloc().initWithTitleImageTag(string3, null, 73);
        UITabBarItem tabBar9Item1 = UITabBarItem.alloc().initWithTitleImageTag(string1, null, 71);
        UITabBarItem tabBar9Item2 = UITabBarItem.alloc().initWithTitleImageTag(string2, image2, 72);
        UITabBarItem tabBar9Item3 = UITabBarItem.alloc().initWithTitleImageTag(string3, null, 73);
        NSArray array5 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UITabBarItem.class, new UITabBarItem[]{
                        tabBar7Item1, tabBar7Item2, tabBar7Item3
                }), 3);
        NSArray array6 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UITabBarItem.class, new UITabBarItem[]{
                        tabBar8Item1, tabBar8Item2, tabBar8Item3
                }), 3);
        NSArray array7 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UITabBarItem.class, new UITabBarItem[]{
                        tabBar9Item1, tabBar9Item2, tabBar9Item3
                }), 3);
        tabBar7.setItems(array5);
        tabBar8.setItems(array6);
        tabBar9.setItems(array7);
        tabBar7.setSelectedItem(tabBar7Item2);
        tabBar8.setSelectedItem(tabBar8Item3);
        tabBar8.setSelectedItem(null);
        view().addSubview(tabBar7);
        view().addSubview(tabBar8);
        view().addSubview(tabBar9);
        testSelectedItem1 = (tabBar7.selectedItem() == tabBar7Item2
                && tabBar8.selectedItem() == null
                && tabBar9.selectedItem() == null);

        tabBar7.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = !tabBar7.isUserInteractionEnabled();
    }

    public boolean arraysHaveEqualItems(NSArray array1, NSArray array2) {
        boolean result = true;
        if (array1.count() == array2.count()) {
            for (int i = 0; i < array1.count(); i++) {
                if (array1.objectAtIndex(i) != array2.objectAtIndex(i)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
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
