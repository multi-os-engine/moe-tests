package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTableViewSearchBarViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

public class XIBTestTableViewSearchBarTests {

    static XIBTestTableViewSearchBarViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestTableViewSearchBarViewController) XIBTestTableViewSearchBarViewController.alloc()
                        .initWithNibNameBundle("XIBTestTableViewSearchBarViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testSearchBarDelegateMethodCalled() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewSearchBarViewController.testSearchBarDelegateMethodCalled;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testTableNumberOfRowsInSectionCalled() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewSearchBarViewController.testTableNumberOfRowsInSectionCalled;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testTableViewCellForRowAtIndexPathCalled() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewSearchBarViewController.testTableViewCellForRowAtIndexPathCalled;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testTableViewHeightForRowAtIndexPathCalled() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewSearchBarViewController.testTableViewHeightForRowAtIndexPathCalled;
            }
        }));
    }
}
