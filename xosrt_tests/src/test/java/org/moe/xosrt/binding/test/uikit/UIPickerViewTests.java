package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UIPickerViewViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;
import static org.junit.Assert.*;

public class UIPickerViewTests {

    static UIPickerViewViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UIPickerViewViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testNumberOfComponents1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPickerViewViewController.testNumberOfComponents1;
            }
        }, 5000));
    }

    @Test
    public void testNumberOfRowsInComponent1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPickerViewViewController.testNumberOfRowsInComponent1;
            }
        }, 5000));
    }

    //TODO: fails on simulator!
    @Ignore
    @Test
    public void testRowSizeForComponent1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPickerViewViewController.testRowSizeForComponent1;
            }
        }, 5000));
    }

    @Test
    public void testDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPickerViewViewController.testDelegate1;
            }
        }, 5000));
    }

    @Test
    public void testDataSource1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPickerViewViewController.testDataSource1;
            }
        }, 5000));
    }

    @Test
    public void testSetUserInteractionEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UIPickerViewViewController.testSetUserInteractionEnabled1;
            }
        }, 5000));
    }

}
