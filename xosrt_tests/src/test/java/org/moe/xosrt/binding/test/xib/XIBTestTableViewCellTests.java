package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTableViewCellViewController;
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

@Ignore //TODO: crushes the simulator, cannot load TableViewCellController class from xib
public class XIBTestTableViewCellTests {

    static XIBTestTableViewCellViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestTableViewCellViewController) XIBTestTableViewCellViewController.alloc()
                        .initWithNibNameBundle("XIBTestTableViewCellViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testFramelabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewCellViewController.testFramelabel1;
            }
        }));
    }

    @Test
    public void testTextlabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewCellViewController.testTextlabel1;
            }
        }));
    }

    @Test
    public void testFrameimage1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewCellViewController.testFrameimage1;
            }
        }));
    }

    @Test
    public void testBackgroundColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewCellViewController.testBackgroundColor1;
            }
        }));
    }

    @Test
    public void testBackgroundColorlabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewCellViewController.testBackgroundColorlabel1;
            }
        }));
    }

    @Test
    public void testTextColorlabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTableViewCellViewController.testTextColorlabel1;
            }
        }));
    }

}
