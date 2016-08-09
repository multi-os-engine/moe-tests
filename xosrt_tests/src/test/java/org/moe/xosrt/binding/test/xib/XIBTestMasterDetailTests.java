package org.moe.xosrt.binding.test.xib;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestDetailViewController;
import org.moe.xosrt.binding.test.xib.controllers.XIBTestMasterViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import ios.foundation.NSArray;
import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIDevice;
import ios.uikit.UINavigationController;
import ios.uikit.UIScreen;
import ios.uikit.UISplitViewController;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.enums.UIUserInterfaceIdiom;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

public class XIBTestMasterDetailTests {
    static XIBTestMasterViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {
                    main = (UIWindow) UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                    controller = (XIBTestMasterViewController) XIBTestMasterViewController.alloc()
                            .initWithNibNameBundle("MasterViewController_iPhone", null);
                    UINavigationController navigationController = UINavigationController.alloc()
                            .initWithRootViewController(controller);
                    main.setRootViewController(navigationController);
                } else {
                    controller = (XIBTestMasterViewController) XIBTestMasterViewController.alloc()
                            .initWithNibNameBundle("MasterViewController_iPad", null);
                    UINavigationController masterNavigationController = UINavigationController.alloc()
                            .initWithRootViewController(controller);

                    XIBTestDetailViewController detailController = (XIBTestDetailViewController) XIBTestDetailViewController.alloc()
                            .initWithNibNameBundle("DetailViewController_iPad", null);
                    UINavigationController detailNavigationController = UINavigationController.alloc()
                            .initWithRootViewController(detailController);
                    controller.detailViewController = detailController;

                    UISplitViewController splitController = UISplitViewController.alloc().init();
                    splitController.setDelegate(detailController);
                    splitController.setViewControllers(NSArray.arrayWithObjectsCount(
                            (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                                    controller, detailController
                            }), 2));
                    main.setRootViewController(splitController);
                }
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testViewDidAppear1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestMasterViewController.testMasterDetailApplication441Test1;
            }
        }));
    }
}
