package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.testhelpers.UINavCViewController1;
import org.moe.xosrt.binding.test.uikit.testhelpers.UINavCViewController2;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.protocol.UINavigationControllerDelegate;

public class UINavigationCViewController extends UIViewController implements UINavigationControllerDelegate {

    static {
        NatJ.register();
    }

    protected UINavigationCViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UINavigationCViewController alloc();

    @Selector("init")
    public native UINavigationCViewController init();

    boolean  willShowViewControllerFlag;
    boolean  didShowViewControllerFlag;
    UINavCViewController1 viewController1;
    int countShows;
    UIButton buttonNext1;

    public static volatile boolean testInitWithRootViewController1 = false;
    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testPopViewControllerAnimated1 = false;
    public static volatile boolean testPopViewControllerAnimated2 = false;
    public static volatile boolean testViewControllers1 = false;
    public static volatile boolean testTopViewController1 = false;
    public static volatile boolean testToolbar1 = false;
    public static volatile boolean testToolbarHidden1 = false;
    public static volatile boolean testSetToolbarHidden_animated1 = false;
    public static volatile boolean testNavigationBar1 = false;
    public static volatile boolean testNavigationBarHidden1 = false;
    public static volatile boolean testSetNavigationBarHidden_animated1 = false;

    @Selector("navigationController:willShowViewController:animated:")
    @Override
    public void navigationControllerWillShowViewControllerAnimated(
            UINavigationController navigationController, UIViewController viewController, boolean animated) {
        willShowViewControllerFlag = true;
    }

    @Override
    public long navigationControllerPreferredInterfaceOrientationForPresentation(UINavigationController uiNavigationController) {
        return 0;
    }

    @Override
    public long navigationControllerSupportedInterfaceOrientations(UINavigationController uiNavigationController) {
        return 0;
    }

    @Override
    public Object navigationControllerAnimationControllerForOperationFromViewControllerToViewController(UINavigationController uiNavigationController, long l, UIViewController uiViewController, UIViewController uiViewController1) {
        return null;
    }

    @Selector("navigationController:didShowViewController:animated:")
    @Override
    public void navigationControllerDidShowViewControllerAnimated(
            UINavigationController navigationController, UIViewController viewController, boolean animated) {
        didShowViewControllerFlag = true;
    }

    @Override
    public Object navigationControllerInteractionControllerForAnimationController(UINavigationController uiNavigationController, Object o) {
        return null;
    }

    public void testConstructor() {
        UINavigationCViewController myViewController1 = UINavigationCViewController.alloc().init();
        UINavigationController navConTest1 = UINavigationController.alloc().initWithRootViewController(myViewController1);
        testInitWithRootViewController1 = (navConTest1 != null);
    }

    public void testDelegateAndPopControllers() {
        UINavigationCViewController myViewController2 = UINavigationCViewController.alloc().init();
        UINavigationController navConTest2 = UINavigationController.alloc().initWithRootViewController(myViewController2);
        navConTest2.setDelegate(myViewController2);
        testDelegate1 = (navConTest2.delegate() == myViewController2 && willShowViewControllerFlag && didShowViewControllerFlag);

        String string0 = (String)viewController1.viewLifeCycleMethodsArray.objectAtIndex(0);
        String string1 = (String)viewController1.viewLifeCycleMethodsArray.objectAtIndex(1);
        String string2 = (String)viewController1.viewLifeCycleMethodsArray.objectAtIndex(2);
        String string3 = (String)viewController1.viewLifeCycleMethodsArray.objectAtIndex(3);
        testPopViewControllerAnimated1 = ("viewWillAppear".equals(string0) && "viewDidAppear".equals(string1)
                && "viewWillDisappear".equals(string2) && "viewDidDisappear".equals(string3));

        string0 = (String)viewController1.viewLifeCycleMethodsArrayAnimated.objectAtIndex(0);
        string1 = (String)viewController1.viewLifeCycleMethodsArrayAnimated.objectAtIndex(1);
        string2 = (String)viewController1.viewLifeCycleMethodsArrayAnimated.objectAtIndex(2);
        string3 = (String)viewController1.viewLifeCycleMethodsArrayAnimated.objectAtIndex(3);
        testPopViewControllerAnimated2 = ("viewWillAppear".equals(string0) && "viewDidAppear".equals(string1)
                && "viewWillDisappear".equals(string2) && "viewDidDisappear".equals(string3)) ;
    }

    public void testAccesingItemsOnNavigationStack() {
        UINavCViewController2 testViewController1 = UINavCViewController2.alloc().init();
        UINavCViewController2 testViewController2 = UINavCViewController2.alloc().init();
        UINavigationController navigationController1 = UINavigationController.alloc().initWithRootViewController(testViewController1);
        //The same behaviour as in objective c: if animated is "true" view controller is not added to the list of view controllers at once
        //So, making it "false"
        navigationController1.pushViewControllerAnimated(testViewController2, false);
        UINavigationController navigationController2 = UINavigationController.alloc().init();
        UINavCViewController2 testViewController3 = UINavCViewController2.alloc().init();
        UINavCViewController2 testViewController4 = UINavCViewController2.alloc().init();
        NSArray array1 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavCViewController2.class, new UINavCViewController2[]{
                        testViewController3, testViewController4
                }), 2);
        navigationController2.setViewControllers(array1);
        UINavigationController navigationController3 = UINavigationController.alloc().init();
        UINavCViewController2 testViewController5 = UINavCViewController2.alloc().init();
        UINavCViewController2 testViewController6 = UINavCViewController2.alloc().init();
        NSArray array2 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavCViewController2.class, new UINavCViewController2[]{
                        testViewController5, testViewController6
                }), 2);
        navigationController3.setViewControllers(array2);

        testViewControllers1 =  (navigationController1.viewControllers().objectAtIndex(0) == testViewController1
                && navigationController1.viewControllers().objectAtIndex(1) == testViewController2
                && navigationController2.viewControllers().objectAtIndex(0) == testViewController3
                && navigationController2.viewControllers().objectAtIndex(1) == testViewController4
                && navigationController3.viewControllers().objectAtIndex(0) == testViewController5
                && navigationController3.viewControllers().objectAtIndex(1) == testViewController6);

        UINavCViewController2 testViewController7 = UINavCViewController2.alloc().init();
        UINavCViewController2 testViewController8 = UINavCViewController2.alloc().init();
        UINavigationController navigationController4 = UINavigationController.alloc().initWithRootViewController(testViewController7);
        navigationController4.pushViewControllerAnimated(testViewController8, false);

        UINavigationController navigationController5 = UINavigationController.alloc().init();
        UINavCViewController2 testViewController9 = UINavCViewController2.alloc().init();
        UINavCViewController2 testViewController10 = UINavCViewController2.alloc().init();
        NSArray array3 = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UINavCViewController2.class, new UINavCViewController2[]{
                        testViewController9, testViewController10
                }), 2);
        navigationController5.setViewControllers(array3);
        testTopViewController1 =  (navigationController4.topViewController() == testViewController8
                && navigationController5.topViewController() == testViewController10);
    }

    public void testToolbarPropertiesAndMethods() {
        UINavigationController navigationController0 = UINavigationController.alloc().init();
        testToolbar1 =  (navigationController0.toolbar() != null);
        //navigationController0.release();

        UINavigationController navigationController1 = UINavigationController.alloc().init();
        UINavigationController navigationController2 = UINavigationController.alloc().init();
        UINavigationController navigationController3 = UINavigationController.alloc().init();
        navigationController1.setToolbarHidden(true);
        navigationController2.setToolbarHidden(false);
        testToolbarHidden1 = (navigationController1.isToolbarHidden() && !navigationController2.isToolbarHidden()
                && navigationController3.isToolbarHidden());
        //navigationController1.release();
        //navigationController2.release();
        //navigationController3.release();

        UINavigationController navigationController4 = UINavigationController.alloc().init();
        UINavigationController navigationController5 = UINavigationController.alloc().init();
        navigationController4.setToolbarHidden(false);
        navigationController4.setToolbarHiddenAnimated(true, false);
        navigationController5.setToolbarHiddenAnimated(false, true);
        performSelectorWithObjectAfterDelay(
                new SEL("assertSetToolbarHidden_animatedTest1:")
                , NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                    UINavigationController.class, new UINavigationController[]{
                            navigationController4, navigationController5
                    }), 2)
                ,1);
    }

    @Selector("assertSetToolbarHidden_animatedTest1:")
    public void assertSetToolbarHidden_animatedTest1(NSArray arrayOfNavigationControllers) {
        //arrayOfNavigationControllers.retain();
        UINavigationController navigationController4 = (UINavigationController)arrayOfNavigationControllers.objectAtIndex(0);
        UINavigationController navigationController5 = (UINavigationController)arrayOfNavigationControllers.objectAtIndex(1);
        testSetToolbarHidden_animated1 = (navigationController4.isToolbarHidden()
                && !navigationController5.isToolbarHidden());
    }

    @Selector("testNavigationBarPropertiesAndMethods")
    public void testNavigationBarPropertiesAndMethods() {
        UINavigationController navigationController0 = UINavigationController.alloc().init();
        testNavigationBar1 =  (navigationController0.navigationBar() != null);
        //navigationController0.release();

        UINavigationController navigationController1 = UINavigationController.alloc().init();
        UINavigationController navigationController2 = UINavigationController.alloc().init();
        UINavigationController navigationController3 = UINavigationController.alloc().init();
        navigationController1.setNavigationBarHidden(true);
        navigationController2.setNavigationBarHidden(false);
        testNavigationBarHidden1 =  (navigationController1.isNavigationBarHidden()
                && !navigationController2.isNavigationBarHidden()
                && !navigationController3.isNavigationBarHidden()) ;

        //navigationController1.release();
        //navigationController2.release();
        //navigationController3.release();

        UINavigationController navigationController4 = UINavigationController.alloc().init();
        UINavigationController navigationController5 = UINavigationController.alloc().init();
        navigationController4.setToolbarHidden(false);
        navigationController4.setNavigationBarHiddenAnimated(true, false);
        navigationController5.setNavigationBarHiddenAnimated(false, true);

        performSelectorWithObjectAfterDelay(
                new SEL("assertSetNavigationBarHidden_animatedTest1:")
                , NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                        UINavigationController.class, new UINavigationController[]{
                                navigationController4, navigationController5
                        }), 2)
                ,1);
    }

    @Selector("assertSetNavigationBarHidden_animatedTest1:")
    public void assertSetNavigationBarHidden_animatedTest1(NSArray arrayOfNavigationControllers) {
        //arrayOfNavigationControllers.retain();
        UINavigationController navigationController4 = (UINavigationController)arrayOfNavigationControllers.objectAtIndex(0);
        UINavigationController navigationController5 = (UINavigationController)arrayOfNavigationControllers.objectAtIndex(1);
        testSetNavigationBarHidden_animated1 = (navigationController4.isNavigationBarHidden()
                && !navigationController5.isNavigationBarHidden());
    }

    @Selector("loadView")
    public void loadView() {

        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.redColor());
        setTitle("MyViewController");

        countShows = 0;
    }

    @Selector("viewDidAppear:")
    public void viewDidAppear(boolean animated) {
        if (countShows == 0) {
            countShows++;
            testConstructor();
            viewController1 = UINavCViewController1.alloc().init();
            navigationController().pushViewControllerAnimated(viewController1, false);
        } else if(countShows == 1) {
            countShows++;
            viewController1.bAnimated = true;
            navigationController().pushViewControllerAnimated(viewController1, true);
        } else if(countShows == 2) {
            countShows++;
            testDelegateAndPopControllers();
            testAccesingItemsOnNavigationStack();
            testToolbarPropertiesAndMethods();
            performSelectorWithObjectAfterDelay(new SEL("testNavigationBarPropertiesAndMethods"), null, 3);
        }
    }

}
