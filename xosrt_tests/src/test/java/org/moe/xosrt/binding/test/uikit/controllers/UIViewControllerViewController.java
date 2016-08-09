package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.testhelpers.SimpleViewController;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIBarButtonItemStyle;

public class UIViewControllerViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIViewControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIViewControllerViewController alloc();

    @Selector("init")
    public native UIViewControllerViewController init();

    
    UIView view1;
    UIView controllerView;
    NSMutableArray testResults;

    public static volatile boolean testView1 = false;
    public static volatile boolean testSetView1 = false;
    public static volatile boolean testTitle1 = false;
    public static volatile boolean testTitle2 = false;
    public static volatile boolean testLoadView1 = false;
    public static volatile boolean testViewDidLoad1 = false;
    public static volatile boolean testViewWillAppear1 = false;
    public static volatile boolean testViewDidAppear1 = false;
    public static volatile boolean testNavigationItem1 = false;
    public static volatile boolean testNavigationController1 = false;
    public static volatile boolean testTabBarItem1 = false;
    public static volatile boolean testTabBarController1 = false;
    public static volatile boolean testToolbarItems1 = false;
    public static volatile boolean testHidesBottomBarWhenPushed1 = false;

    public void testProperties() {
        testView1 = (view() == controllerView && view().tag() == 24948);

        controllerView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480));
        controllerView.setBackgroundColor(UIColor.blueColor());
        controllerView.setTag(610841);
        setView(controllerView);

        testSetView1 = (view() == controllerView);

        UIViewController viewController1 = SimpleViewController.alloc().init();
        UIViewController viewController2 = SimpleViewController.alloc().init();
        UIViewController viewController3 = SimpleViewController.alloc().init();
        UIViewController viewController4 = SimpleViewController.alloc().init();
        UIViewController viewController5 = SimpleViewController.alloc().init();
        String title1 = "title 1";
        String navigationTitle1 = "navigationTitle 1";
        String tabBarTitle1 = "tabBarTitle 1";
        String title2 = "title 2";
        String navigationTitle2 = "navigationTitle 2";
        String title3 = "title 3";
        String tabBarTitle3 = "tabBarTitle 3";
        String title4 = "title 4";
        String navigationTitle4 = "navigationTitle 4";
        String tabBarTitle4 = "tabBarTitle 4";
        String navigationTitle5 = "navigationTitle 5";
        String tabBarTitle5 = "tabBarTitle 5";
        boolean testSelfTitle = (title().equals(title1) && navigationItem().title().equals(title1)
                && tabBarItem().title().equals(title1));
        viewController1.navigationItem().setTitle(tabBarTitle1);
        viewController1.tabBarItem().setTitle(navigationTitle1);
        viewController1.setTitle(title1);
        boolean testViewController1Title = viewController1.title().equals(title1)
                && viewController1.navigationItem().title().equals(title1)
                && viewController1.tabBarItem().title().equals(title1);
        viewController2.setTitle(title2);
        viewController2.navigationItem().setTitle(navigationTitle2);
        boolean testViewController2Title = viewController2.title().equals(title2)
                && viewController2.navigationItem().title().equals(navigationTitle2)
                && viewController2.tabBarItem().title().equals(title2);
        viewController3.setTitle(title3);
        viewController3.tabBarItem().setTitle(tabBarTitle3);
        boolean testViewController3Title = viewController3.title().equals(title3)
                && viewController3.navigationItem().title().equals(title3)
                && viewController3.tabBarItem().title().equals(tabBarTitle3);
        viewController4.setTitle(title4);
        viewController4.navigationItem().setTitle(navigationTitle4);
        viewController4.tabBarItem().setTitle(tabBarTitle4);
        boolean testViewController4Title = viewController4.title().equals(title4)
                && viewController4.navigationItem().title().equals(navigationTitle4)
                && viewController4.tabBarItem().title().equals(tabBarTitle4);
        viewController5.navigationItem().setTitle(navigationTitle5);
        viewController5.tabBarItem().setTitle(tabBarTitle5);
        boolean testViewController5Title = viewController5.title() == null
                && viewController5.navigationItem().title().equals(navigationTitle5)
                && viewController5.tabBarItem().title().equals(tabBarTitle5);
        testTitle1 = (testSelfTitle && testViewController1Title && testViewController2Title
                && testViewController3Title && testViewController4Title && testViewController5Title);

        SimpleViewController viewController6 = SimpleViewController.alloc().init();
        SimpleViewController viewController7 = SimpleViewController.alloc().init();
        SimpleViewController viewController8 = SimpleViewController.alloc().init();
        SimpleViewController viewController9 = SimpleViewController.alloc().init();
        UINavigationController navigationController1 = UINavigationController.alloc().initWithRootViewController(viewController6);
        navigationController1.setTitle(title1);
        viewController6.setTitle(title2);
        navigationController1.pushViewControllerAnimated(viewController7, false);
        viewController7.setTitle(title3);
        UINavigationController navigationController2 = UINavigationController.alloc().init();
        navigationController2.setTitle(title1);
        navigationController2.setViewControllers(NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        viewController8, viewController9
                }), 2));
        viewController8.setTitle(title2);
        viewController9.setTitle(title3);
        viewController8.setTitle(title4);
        testTitle2 =  (navigationController1.title().equals(title2) && viewController6.title().equals(title2)
                && viewController7.title().equals(title3) && navigationController2.title().equals(title4)
                && viewController8.title().equals(title4) && viewController9.title().equals(title3));

    }

    public void testViewLifeCycleMethods() {
        String auxStr = (String)testResults.objectAtIndex(0);
        testLoadView1 = ("loadView".equals(auxStr));

        auxStr = (String)testResults.objectAtIndex(1);
        testViewDidLoad1 = "viewDidLoad".equals(auxStr);

        auxStr = (String)testResults.objectAtIndex(2);
        testViewWillAppear1 = "viewWillAppear".equals(auxStr);

        auxStr = (String)testResults.objectAtIndex(3);
        testViewDidAppear1 = "viewDidAppear".equals(auxStr);

    }

    public void testNavigationProperties() {
        UIViewController viewController1 = UIViewController.alloc().init();
        String testTitle1 = "testTitle1";
        viewController1.setTitle(testTitle1);
        testNavigationItem1 = (viewController1.navigationItem() != null
                && viewController1.navigationItem().title().equals(testTitle1));

        UIViewController viewController2 = UIViewController.alloc().init();
        UINavigationController navigationController1 = UINavigationController.alloc().initWithRootViewController(viewController2);
        testNavigationController1 = (viewController2.navigationController() == navigationController1);
    }

    public void testTabBarProperties() {
        UIViewController viewController1 = UIViewController.alloc().init();
        String testTitle1 = "testTitle1";
        viewController1.setTitle(testTitle1);
        testTabBarItem1 = (viewController1.tabBarItem() != null
                && viewController1.tabBarItem().title().equals(testTitle1));

        UIViewController viewController2 = SimpleViewController.alloc().init();
        UIViewController viewController3 = SimpleViewController.alloc().init();
        UIViewController viewController4 = SimpleViewController.alloc().init();
        UIViewController viewController5 = SimpleViewController.alloc().init();
        UIViewController viewController6 = SimpleViewController.alloc().init();
        UINavigationController navigationController1 = UINavigationController.alloc().initWithRootViewController(viewController4);
        navigationController1.pushViewControllerAnimated(viewController5, false);
        navigationController1.pushViewControllerAnimated(viewController6, false);
        navigationController1.popViewControllerAnimated(false);
        UITabBarController tabBarController1 = UITabBarController.alloc().init();
        tabBarController1.setViewControllers(NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        viewController2, viewController3, navigationController1
                }), 3));
        testTabBarController1 = (viewController2.tabBarController() == tabBarController1
                && viewController3.tabBarController() == tabBarController1
                && viewController4.tabBarController() == tabBarController1
                && viewController5.tabBarController() == tabBarController1
                && viewController6.tabBarController() == null
                && navigationController1.tabBarController() == tabBarController1);
    }

    public void testToolbarProperties() {
        UIViewController viewController2 = UIViewController.alloc().init();
        UIViewController viewController3 = UIViewController.alloc().init();
        UIViewController viewController4 = UIViewController.alloc().init();
        UIBarButtonItem barButtonItem0 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "item0", UIBarButtonItemStyle.Bordered, this, null);
        UIBarButtonItem barButtonItem1 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "item1", UIBarButtonItemStyle.Bordered, this, null);
        UIBarButtonItem barButtonItem2 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "item2", UIBarButtonItemStyle.Bordered, this, null);
        UIBarButtonItem barButtonItem3 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "item2", UIBarButtonItemStyle.Bordered, this, null);
        UIBarButtonItem barButtonItem4 = UIBarButtonItem.alloc().initWithTitleStyleTargetAction(
                "item2", UIBarButtonItemStyle.Bordered, this, null);
        viewController2.setToolbarItems(NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIBarButtonItem.class, new UIBarButtonItem[]{
                        barButtonItem0, barButtonItem1
                }), 2));
        viewController3.setToolbarItems(NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIBarButtonItem.class, new UIBarButtonItem[]{
                        barButtonItem2, barButtonItem3, barButtonItem4
                }), 3));
        testToolbarItems1 = (viewController2.toolbarItems().count() == 2
                && viewController2.toolbarItems().objectAtIndex(0) == barButtonItem0
                && viewController2.toolbarItems().objectAtIndex(1) == barButtonItem1
                && viewController3.toolbarItems().count() == 3
                && viewController3.toolbarItems().objectAtIndex(0) == barButtonItem2
                && viewController3.toolbarItems().objectAtIndex(1) == barButtonItem3
                && viewController3.toolbarItems().objectAtIndex(2) == barButtonItem4
                && viewController4.toolbarItems() == null);

        UIViewController viewController0 = UIViewController.alloc().init();
        UIViewController viewController1 = UIViewController.alloc().init();
        viewController0.setHidesBottomBarWhenPushed(true);
        viewController1.setHidesBottomBarWhenPushed(false);

        SimpleViewController simpleViewController0 = SimpleViewController.alloc().init();
        simpleViewController0.setHidesBottomBarWhenPushed(false);
        SimpleViewController simpleSimpleViewController = SimpleViewController.alloc().init();
        simpleSimpleViewController.setHidesBottomBarWhenPushed(true);
        UINavigationController navigationController0 = UINavigationController.alloc().initWithRootViewController(simpleViewController0);
        navigationController0.setToolbarHidden(false);
        navigationController0.pushViewControllerAnimated(simpleSimpleViewController, false);

        SimpleViewController simpleViewController2 = SimpleViewController.alloc().init();
        simpleViewController2.setHidesBottomBarWhenPushed(false);
        SimpleViewController simpleViewController3 = SimpleViewController.alloc().init();
        simpleViewController3.setHidesBottomBarWhenPushed(true);
        UINavigationController navigationController1 = UINavigationController.alloc().initWithRootViewController(simpleViewController2);
        navigationController1.setToolbarHidden(false);
        navigationController1.pushViewControllerAnimated(simpleViewController3, false);

        performSelectorWithObjectAfterDelay(
                new SEL("assertHidesBottomBarWhenPushed1:"),
                NSArray.arrayWithObjectsCount(
                    (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                            viewController0, viewController1, navigationController0, navigationController1
                    }), 4)
                , 1);
    }

    @Selector("assertHidesBottomBarWhenPushed1:")
    public void assertHidesBottomBarWhenPushed1(NSArray arrayOfViewControllers) {
        //arrayOfViewControllers.retain();
        UIViewController viewController0 = (UIViewController)arrayOfViewControllers.objectAtIndex(0);
        UIViewController viewController1 = (UIViewController)arrayOfViewControllers.objectAtIndex(1);
        UINavigationController navigationController0 = (UINavigationController)arrayOfViewControllers.objectAtIndex(2);
        UINavigationController navigationController1 = (UINavigationController)arrayOfViewControllers.objectAtIndex(3);
        navigationController1.setToolbarHidden(false);
        testHidesBottomBarWhenPushed1 = (viewController0.hidesBottomBarWhenPushed()
                && !viewController1.hidesBottomBarWhenPushed()
                && navigationController0.isToolbarHidden()
                && navigationController1.topViewController().hidesBottomBarWhenPushed());
        //arrayOfViewControllers.release();
    }

    @Selector("loadView")
    @Override
    public void loadView() {
        controllerView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0,0,320, 480));
        controllerView.setTag(24948);
        setView(controllerView);
        view().setBackgroundColor(UIColor.greenColor());

        view1 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(100, 200, 50, 80));
        view1.setBackgroundColor(UIColor.yellowColor());
        view().addSubview(view1);
        testResults = NSMutableArray.alloc().init();
        testResults.addObject(NSString.stringWithString("loadView"));
    }

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        testResults.addObject(NSString.stringWithString("viewDidLoad"));
        super.viewDidLoad();
    }

    @Selector("viewWillAppear:")
    @Override
    public void viewWillAppear(boolean animated) {
        testResults.addObject(NSString.stringWithString("viewWillAppear"));
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testResults.addObject(NSString.stringWithString("viewDidAppear"));

        testProperties();
        testViewLifeCycleMethods();
        testNavigationProperties();
        testTabBarProperties();
        testToolbarProperties();
    }

    public void dealloc() {
        super.dealloc();
    }

}
