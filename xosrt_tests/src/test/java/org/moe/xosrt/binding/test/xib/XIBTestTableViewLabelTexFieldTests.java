package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTableViewLabelTexFieldViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

public class XIBTestTableViewLabelTexFieldTests {

    static XIBTestTableViewLabelTexFieldViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestTableViewLabelTexFieldViewController) XIBTestTableViewLabelTexFieldViewController.alloc()
                        .initWithNibNameBundle("XIBTestTableViewLabelTexFieldViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testNumberOfRowsInSection() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldViewController.testNumberOfRowsInSection;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testCellForRowAtIndex() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldViewController.testCellForRowAtIndex;
            }
        }));
    }

    @Test
    public void testEditingDidBegin() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldViewController.testEditingDidBegin;
            }
        }));
    }

    @Test
    public void testEditingChanged() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldViewController.testEditingChanged;
            }
        }));
    }

    @Test
    public void testEditingDidEnd() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldViewController.testEditingDidEnd;
            }
        }));
    }

    @Test
    public void testEditingDidEndOnExit() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldViewController.testEditingDidEndOnExit;
            }
        }));
    }
}
