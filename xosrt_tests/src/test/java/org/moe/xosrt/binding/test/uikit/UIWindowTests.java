package org.moe.xosrt.binding.test.uikit;

import org.junit.BeforeClass;
import org.junit.Test;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIColor;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.*;

public class UIWindowTests {

    public static int WAIT_TIMEOUT = 7000;

    static volatile UIWindow window;
    static volatile UIWindow window2;
    static volatile UIWindow window3;
    static volatile UIWindow window4;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        window = (UIWindow) UIWindow.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 660));
        window2 = (UIWindow) UIWindow.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 660));
        window3 = (UIWindow) UIWindow.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 660));
        window4 = (UIWindow) UIWindow.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 660));
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                window.setBackgroundColor(UIColor.blueColor());
                window2.setBackgroundColor(UIColor.redColor());
                window3.setBackgroundColor(UIColor.blackColor());
                window4.setBackgroundColor(UIColor.greenColor());
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(window);
            }
        });
    }

    @Test
    public void testKeyWindow1() {
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                window.makeKeyAndVisible();
            }
        });
        assertTrue(ConditionWait.since(new ConditionWait.Condition() {
            @Override
            public boolean check () {
                return window.isKeyWindow() && !window2.isKeyWindow();
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testMakeKeyWindow1() {
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                window2.makeKeyWindow();
            }
        });
        assertTrue(ConditionWait.since(new ConditionWait.Condition() {
            @Override
            public boolean check () {
                return !window.isKeyWindow() && window2.isKeyWindow();
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testMakeKeyAndVisible1() {
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                window.makeKeyAndVisible();
            }
        });
        assertTrue(ConditionWait.since(new ConditionWait.Condition() {
            @Override
            public boolean check () {
                return window.isKeyWindow() && !window2.isKeyWindow();
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testMakeKeyWindow2() {
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                window3.makeKeyAndVisible();
            }
        });
        assertTrue(ConditionWait.since(new ConditionWait.Condition() {
            @Override
            public boolean check () {
                return !window.isKeyWindow() && !window2.isKeyWindow() && window3.isKeyWindow();
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testMakeKeyAndVisible2() {
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                window4.makeKeyAndVisible();
            }
        });
        assertTrue(ConditionWait.since(new ConditionWait.Condition() {
            @Override
            public boolean check () {
                return !window.isKeyWindow() && !window2.isKeyWindow() && !window3.isKeyWindow() && window4.isKeyWindow();
            }
        }, WAIT_TIMEOUT));
    }

    @Test
    public void testMakeKeyWindow3() {
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                window3.makeKeyAndVisible();
            }
        });
        assertTrue(ConditionWait.since(new ConditionWait.Condition() {
            @Override
            public boolean check () {
                return !window.isKeyWindow() && !window2.isKeyWindow() && window3.isKeyWindow() && !window4.isKeyWindow();
            }
        }, WAIT_TIMEOUT));
    }
}
