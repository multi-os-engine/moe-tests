package org.moe.xosrt.binding.test.uikit;

import static org.junit.Assert.assertTrue;
import ios.foundation.NSOperationQueue;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;

import org.moe.xosrt.binding.test.uikit.controllers.CALayerTestViewController;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

public class CALayerTest {

    public static UIViewController controller = null;

    private static volatile UIWindow main;
    
    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
			@Override
			public void call_addOperationWithBlock() {
		        main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
		        controller = CALayerTestViewController.alloc().init();
		        //UIKit.UIApplicationMain(0, null, null, AppDelegate.class.getSimpleName());
		        main.setRootViewController(controller);
		        ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
		        main.makeKeyAndVisible();
			}
    	});
    }

    @Test
    public void testPresentationLayer1() {
		assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return CALayerTestViewController.testPresentationLayer1;
            }
        }));
    }

    @Test
    public void testPresentationLayer2() {
		assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return CALayerTestViewController.testPresentationLayer2;
            }
        }) );
    }

    @Test
    public void testPresentationLayer3() {
		assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return CALayerTestViewController.testPresentationLayer3;
            }
        }, 5000));
    }

    @Test
    public void testPresentationLayer4() {
		assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return CALayerTestViewController.testPresentationLayer4;
            }
        }) );
    }

    @AfterClass
    public static void ender() {
        ConditionWait.prepareConditionWait();
    }

}
