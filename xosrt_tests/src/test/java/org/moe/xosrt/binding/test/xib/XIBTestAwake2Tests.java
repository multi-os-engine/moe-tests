package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestAwake2ViewControllerViewController;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

//TODO: xib should be used in AppDelegate
@Ignore
public class XIBTestAwake2Tests {

    static XIBTestAwake2ViewControllerViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestAwake2ViewControllerViewController)XIBTestAwake2ViewControllerViewController.alloc()
                        .initWithNibNameBundle("XIBTestAwake2ViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testAwakeFromNib1() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestAwake2ViewControllerViewController.testAwakeFromNib1;
            }
        }));
    }

    @Test
    public void testAwakeFromNib2() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestAwake2ViewControllerViewController.view1.testAwakeFromNib;
            }
        }));
    }
}
