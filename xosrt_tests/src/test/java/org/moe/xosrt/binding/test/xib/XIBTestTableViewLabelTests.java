package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTableViewLabelViewController;
import org.junit.BeforeClass;
import org.junit.Test;

import ios.foundation.NSOperationQueue;
import ios.uikit.UIApplication;
import ios.uikit.UIScreen;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;
import tools.ConditionWait;

import static org.junit.Assert.assertTrue;

public class XIBTestTableViewLabelTests {

    static XIBTestTableViewLabelViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new NSOperationQueue.Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestTableViewLabelViewController) XIBTestTableViewLabelViewController.alloc()
                        .initWithNibNameBundle("XIBTestTableViewLabelViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testLabelTableViewCreationInstanced() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelTableViewCreationInstanced;
            }
        }));
    }

    @Test
    public void testLabelTableViewCreationCorrectSize() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelTableViewCreationCorrectSize;
            }
        }));
    }

    @Test
    public void testLabelTableViewCreationParentView() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelTableViewCreationParentView;
            }
        }));
    }

    @Test
    public void testLabelCreationInstanced() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelCreationInstanced;
            }
        }));
    }

    @Test
    public void testLabelCreationCorectSize() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelCreationCorectSize;
            }
        }));
    }

    @Test
    public void testLabelCreationParentView() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelCreationParentView;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testLabelTableViewNumberOfRowsInSection() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelTableViewNumberOfRowsInSection;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testLabelTableViewCellForRow() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelTableViewCellForRow;
            }
        }));
    }

    //TODO: fails on simulator, seems delegate functions are not called
    @Test
    public void testLabelTableViewDelegateDidSelectCell() {
        assertTrue(ConditionWait.tillGlobalTime(new ConditionWait.Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewLabelViewController.testLabelTableViewDelegateDidSelectCell;
            }
        }));
    }
}
