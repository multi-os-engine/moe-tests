package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTableViewLabelTexFieldUIImageViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

public class XIBTestTableViewLabelTexFieldUIImageTests {

    static XIBTestTableViewLabelTexFieldUIImageViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestTableViewLabelTexFieldUIImageViewController) XIBTestTableViewLabelTexFieldUIImageViewController.alloc()
                        .initWithNibNameBundle("XIBTestTableViewLabelTexFieldUIImageViewController", null);
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
                return XIBTestTableViewLabelTexFieldUIImageViewController.testNumberOfRowsInSection;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testCellForRowAtIndex() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldUIImageViewController.testCellForRowAtIndex;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testIsImageInstantiated() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldUIImageViewController.testIsImageInstantiated;
            }
        }));
    }

    @Test
    public void testSelectionWillChange() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldUIImageViewController.testSelectionWillChange;
            }
        }));
    }

    @Test
    public void testSelectionChanged() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldUIImageViewController.testSelectionChanged;
            }
        }));
    }

    @Test
    public void testTextWillChange() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldUIImageViewController.testTextWillChange;
            }
        }));
    }

    @Test
    public void testTextDidChange() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelTexFieldUIImageViewController.testTextDidChange;
            }
        }));
    }
}
