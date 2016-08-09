package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestWebViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

public class XIBTestWebViewTests {


    public static UIViewController controller = null;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                UIWindow main = (UIWindow) UIWindow.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480));
                controller = XIBTestWebViewController.alloc().initWithNibNameBundle("WebView", null);
                //UIKit.UIApplicationMain(0, null, null, AppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testOrigin1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestWebViewController.testOrigin1;
            }
        }));
    }

    @Test
    public void testSize1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestWebViewController.testSize1;
            }
        }));
    }
}
