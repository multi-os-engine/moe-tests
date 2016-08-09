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
import ios.foundation.c.Foundation;
import ios.foundation.enums.Enums;
import ios.uikit.*;
import ios.uikit.protocol.UITabBarControllerDelegate;

public class UITabBarControllerViewController extends UIViewController implements UITabBarControllerDelegate {

    static {
        NatJ.register();
    }

    protected UITabBarControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITabBarControllerViewController alloc();

    @Selector("init")
    public native UITabBarControllerViewController init();


    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testTabBar1 = false;
    public static volatile boolean testViewControllers1 = false;
    public static volatile boolean testSelectedViewController1 = false;
    public static volatile boolean testSelectedIndex1 = false;

    @Selector("loadView")
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.blueColor());
    }

    @Selector("viewDidAppear:")
    public void viewDidAppear(boolean animated) {
        testAccessingTabBarControllerProperties();
        testManagingViewControllersProperties();
        testManagingSelectedTab();
    }

    public void testAccessingTabBarControllerProperties() {
        UITabBarController tabBarController1 = UITabBarController.alloc().init();
        UITabBarController tabBarController2 = UITabBarController.alloc().init();
        UITabBarController tabBarController3 = UITabBarController.alloc().init();
        tabBarController1.setDelegate(this);
        tabBarController2.setDelegate(this);

        testDelegate1 = (tabBarController1.delegate() == this
                && tabBarController2.delegate() == this && tabBarController3.delegate() == null);

        UITabBarController tabBarController4 = UITabBarController.alloc().init();
        testTabBar1 = (tabBarController4.tabBar() != null);
    }

    public void testManagingViewControllersProperties() {
        UITabBarController tabBarController5 = UITabBarController.alloc().init();
        UITabBarController tabBarController6 = UITabBarController.alloc().init();
        UITabBarController tabBarController7 = UITabBarController.alloc().init();
        UITabBarControllerViewController viewController1 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController viewController2 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController viewController3 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController viewController4 = UITabBarControllerViewController.alloc().init();
        UINavigationController navigationController1 = UINavigationController.alloc().initWithRootViewController(viewController2);
        UINavigationController navigationController2 = UINavigationController.alloc().initWithRootViewController(viewController4);
        NSArray array1 = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[] {
                        viewController1, navigationController1
                }), 2);
        NSMutableArray array2 = NSMutableArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        viewController3, navigationController2
                }), 2);
        tabBarController6.setViewControllers(array1);
        tabBarController7.setViewControllers(array2);
        testViewControllers1 = (tabBarController5.viewControllers() == null
                && tabBarController6.viewControllers().count() == 2
                && tabBarController6.viewControllers().objectAtIndex(0) == viewController1
                && tabBarController6.viewControllers().objectAtIndex(1) == navigationController1
                && tabBarController7.viewControllers().count() == 2
                && tabBarController7.viewControllers().objectAtIndex(0) == viewController3
                && tabBarController7.viewControllers().objectAtIndex(1) == navigationController2);
    }

    public void testManagingSelectedTab() {
        UITabBarController tabBarController0 = UITabBarController.alloc().init();
        UITabBarController tabBarController1 = UITabBarController.alloc().init();
        UITabBarControllerViewController viewController1 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController viewController2 = UITabBarControllerViewController.alloc().init();
        UINavigationController navigationController1 = UINavigationController.alloc().initWithRootViewController(viewController2);
        NSArray array1 = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        viewController1, navigationController1
                }), 2);
        tabBarController1.setViewControllers(array1);
        tabBarController1.setSelectedViewController(viewController1);
        UITabBarController tabBarController2 = UITabBarController.alloc().init();
        UITabBarControllerViewController viewController3 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController viewController4 = UITabBarControllerViewController.alloc().init();
        UINavigationController navigationController2 = UINavigationController.alloc().initWithRootViewController(viewController4);
        NSArray array2 = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        navigationController2, viewController3
                }), 2);
        tabBarController2.setViewControllers(array2);
        tabBarController2.setSelectedViewController(navigationController2);
        UITabBarController tabBarController3 = UITabBarController.alloc().init();
        UITabBarControllerViewController viewController5 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController viewController6 = UITabBarControllerViewController.alloc().init();
        NSArray array3 = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        viewController5, viewController6
                }), 2);
        tabBarController3.setViewControllers(array3);
        tabBarController3.setSelectedViewController(viewController6);
        //This causes an exception here and in xCode, so, considering it works correctly
        //tabBarController3.setSelectedViewController(null);
        UITabBarController tabBarController4 = UITabBarController.alloc().init();
        UITabBarControllerViewController viewController7 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController viewController8 = UITabBarControllerViewController.alloc().init();
        NSArray array4 = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        viewController7, viewController8
                }), 2);
        tabBarController4.setViewControllers(array4);
        testSelectedViewController1 = (tabBarController0.selectedViewController() == null
                && tabBarController1.selectedViewController() == viewController1
                && tabBarController2.selectedViewController() == navigationController2
                && tabBarController3.selectedViewController() == viewController6 //null
                && tabBarController3.selectedIndex() == 1 //Foundation.NSNotFound
                && tabBarController4.selectedViewController() == viewController7);

        UITabBarController aTabBarController0 = UITabBarController.alloc().init();
        UITabBarController aTabBarController1 = UITabBarController.alloc().init();
        UITabBarControllerViewController aViewController0 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController aViewController1 = UITabBarControllerViewController.alloc().init();
        NSArray anArray1 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        aViewController0, aViewController1
                }), 2);
        aTabBarController1.setViewControllers(anArray1);
        UITabBarController aTabBarController2 = UITabBarController.alloc().init();
        UITabBarControllerViewController aViewController2 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController aViewController3 = UITabBarControllerViewController.alloc().init();
        NSArray anArray2 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        aViewController2, aViewController3
                }), 2);
        aTabBarController2.setViewControllers(anArray2);
        aTabBarController2.setSelectedIndex(0);
        UITabBarController aTabBarController3 = UITabBarController.alloc().init();
        UITabBarControllerViewController aViewController4 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController aViewController5 = UITabBarControllerViewController.alloc().init();
        NSArray anArray3 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        aViewController4, aViewController5
                }), 2);
        aTabBarController3.setViewControllers(anArray3);
        aTabBarController3.setSelectedIndex(1);
        UITabBarController aTabBarController4 = UITabBarController.alloc().init();
        UITabBarControllerViewController aViewController6 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController aViewController7 = UITabBarControllerViewController.alloc().init();
        NSArray anArray4 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        aViewController6, aViewController7
                }), 2);
        aTabBarController4.setViewControllers(anArray4);
        aTabBarController4.setSelectedIndex(-1);
        UITabBarController aTabBarController5 = UITabBarController.alloc().init();
        UITabBarControllerViewController aViewController8 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController aViewController9 = UITabBarControllerViewController.alloc().init();
        NSArray anArray5 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        aViewController8, aViewController9
                }), 2);
        aTabBarController5.setViewControllers(anArray5);
        aTabBarController5.setSelectedIndex(8);
        UITabBarController aTabBarController6 = UITabBarController.alloc().init();
        UITabBarControllerViewController aViewController10 = UITabBarControllerViewController.alloc().init();
        UITabBarControllerViewController aViewController11 = UITabBarControllerViewController.alloc().init();
        NSArray anArray6 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        aViewController10, aViewController11
                }), 2);
        aTabBarController6.setViewControllers(anArray6);
        aTabBarController6.setSelectedIndex(Foundation.NSNotFound);
        testSelectedIndex1 = (aTabBarController0.selectedIndex() == Foundation.NSNotFound
                && aTabBarController1.selectedIndex() == 0
                && aTabBarController2.selectedIndex() == 0
                && aTabBarController3.selectedIndex() == 1
                && aTabBarController4.selectedIndex() == 0
                && aTabBarController5.selectedIndex() == 0
                && aTabBarController6.selectedIndex() == 0
                && aTabBarController6.selectedViewController() == aViewController10) ;

    }

    @Override
    public Object tabBarControllerAnimationControllerForTransitionFromViewControllerToViewController(UITabBarController uiTabBarController, UIViewController uiViewController, UIViewController uiViewController1) {
        return null;
    }

    @Override
    public void tabBarControllerDidEndCustomizingViewControllersChanged(UITabBarController uiTabBarController, NSArray nsArray, boolean b) {

    }

    @Override
    public void tabBarControllerDidSelectViewController(UITabBarController uiTabBarController, UIViewController uiViewController) {

    }

    @Override
    public Object tabBarControllerInteractionControllerForAnimationController(UITabBarController uiTabBarController, Object o) {
        return null;
    }

    @Override
    public boolean tabBarControllerShouldSelectViewController(UITabBarController uiTabBarController, UIViewController uiViewController) {
        return false;
    }

    @Override
    public void tabBarControllerWillBeginCustomizingViewControllers(UITabBarController uiTabBarController, NSArray nsArray) {

    }

    @Override
    public void tabBarControllerWillEndCustomizingViewControllersChanged(UITabBarController uiTabBarController, NSArray nsArray, boolean b) {

    }

    @Override
    public long tabBarControllerPreferredInterfaceOrientationForPresentation(UITabBarController uiTabBarController) {
        return 0;
    }

    @Override
    public long tabBarControllerSupportedInterfaceOrientations(UITabBarController uiTabBarController) {
        return 0;
    }
}
