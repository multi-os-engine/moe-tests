package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestAwake1ViewController;
import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.moe.xosrt.binding.test.xib.testhelpers.View;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

//TODO: xib should be used in AppDelegate
@Ignore
public class XIBTestAwake1Tests {

    static XIBTestAwake1ViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestAwake1ViewController)XIBTestAwake1ViewController.alloc()
                        .initWithNibNameBundle("XIBTestAwake1ViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testAwakeFromNib1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestAwake1ViewController.testAwakeFromNib1;
            }
        }));
    }

    @Test
    public void testAwakeFromNib2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestAwake1ViewController.newView.testAwakeFromNib;
            }
        }));
    }

    @Test
    public void testAwakeFromNib3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return View.testAwakeFromNib;
            }
        }));
    }

}
