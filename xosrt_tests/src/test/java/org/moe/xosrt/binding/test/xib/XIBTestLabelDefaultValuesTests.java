package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestLabelDefaultValuesViewController;
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

public class XIBTestLabelDefaultValuesTests {

    static XIBTestLabelDefaultValuesViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestLabelDefaultValuesViewController)XIBTestLabelDefaultValuesViewController.alloc()
                        .initWithNibNameBundle("XIBTestLabelDefaultValuesViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testXIB_backgroundColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testXIB_backgroundColor1;
            }
        }));
    }

    @Test
    public void testXIB_textColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testXIB_textColor1;
            }
        }));
    }

    @Test
    public void testXIB_textAlignment1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testXIB_textAlignment1;
            }
        }));
    }

    @Test
    public void testXIB_text1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testXIB_text1;
            }
        }));
    }

    //TODO: fails in xCode as well
    @Ignore
    @Test
    public void testPROGRAMATIC_backgroundColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testPROGRAMATIC_backgroundColor1;
            }
        }));
    }

    @Test
    public void testPROGRAMATIC_backgroundColor2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testPROGRAMATIC_backgroundColor2;
            }
        }));
    }

    @Test
    public void testPROGRAMATIC_textColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testPROGRAMATIC_textColor1;
            }
        }));
    }

    @Test
    public void testPROGRAMATIC_textAlignment1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testPROGRAMATIC_textAlignment1;
            }
        }));
    }

    @Test
    public void testPROGRAMATIC_text1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestLabelDefaultValuesViewController.testPROGRAMATIC_text1;
            }
        }));
    }

}
