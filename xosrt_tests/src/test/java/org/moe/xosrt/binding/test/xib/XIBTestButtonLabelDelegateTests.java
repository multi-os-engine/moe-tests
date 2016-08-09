package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestButtonLabelDelegateViewController;
import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class XIBTestButtonLabelDelegateTests {

    static XIBTestButtonLabelDelegateViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestButtonLabelDelegateViewController)XIBTestButtonLabelDelegateViewController.alloc()
                        .initWithNibNameBundle("XIBTestButtonLabelDelegateViewController", null);
                //main.setRootViewController(controller);
                main.addSubview(controller.view());
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testButtonType1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testButtonType1;
            }
        }));
    }

    @Test
    public void testButtonType2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testButtonType2;
            }
        }));
    }

    @Test
    public void testButtonType3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testButtonType3;
            }
        }));
    }

    @Test
    public void testSetTitle_forState1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testSetTitle_forState1;
            }
        }));
    }

    @Test
    public void testSetNumberOfLineslabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testSetNumberOfLineslabel1;
            }
        }));
    }

    @Test
    public void testSetTextlabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testSetTextlabel1;
            }
        }));
    }

    @Test
    public void testSetTextColorlabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testSetTextColorlabel1;
            }
        }));
    }

    @Test
    public void testSetTextAlignmentlabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testSetTextAlignmentlabel1;
            }
        }));
    }

    @Test
    public void testSetEnabledlabel1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestButtonLabelDelegateViewController.testSetEnabledlabel1;
            }
        }));
    }

}
