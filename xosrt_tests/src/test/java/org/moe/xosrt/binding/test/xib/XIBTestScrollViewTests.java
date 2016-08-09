package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestScrollViewViewController;
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

public class XIBTestScrollViewTests {

    static XIBTestScrollViewViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestScrollViewViewController)XIBTestScrollViewViewController.alloc()
                        .initWithNibNameBundle("XIBTestScrollViewViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Ignore //TODO: fails in xcode as well
    @Test
    public void testFrame1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testFrame1;
            }
        }));
    }

    @Ignore //TODO: fails in xcode as well
    @Test
    public void testFrame2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testFrame2;
            }
        }));
    }

    @Test
    public void testFrame3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testFrame3;
            }
        }));
    }

    @Test
    public void testFrame4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testFrame4;
            }
        }));
    }

    @Test
    public void testFrame5() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testFrame5;
            }
        }));
    }

    @Ignore //TODO: fails in xcode as well
    @Test
    public void testFrame6() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testFrame6;
            }
        }));
    }

    @Ignore //TODO: fails in xcode as well
    @Test
    public void testFrame7() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testFrame7;
            }
        }));
    }

    @Test
    public void testBackgroundColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testBackgroundColor1;
            }
        }));
    }

    @Test
    public void testBackgroundColor2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testBackgroundColor2;
            }
        }));
    }

    @Test
    public void testAlpha1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testAlpha1;
            }
        }));
    }

    @Test
    public void testAlpha2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestScrollViewViewController.testAlpha2;
            }
        }));
    }

}
