package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UILabelViewController;

import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class UILabelTests {

    static UILabelViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UILabelViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testSetNumberOfLines2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetNumberOfLines2;
            }
        }, 5000));
    }

    @Test
    public void testSetNumberOfLines3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetNumberOfLines3;
            }
        }, 5000));
    }

    @Test
    public void testSetText1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetText1;
            }
        }));
    }

    @Test
    public void testSetTextColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetTextColor1;
            }
        }));
    }

    @Test
    public void testSetTextAlignment1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetTextAlignment1;
            }
        }));
    }

    @Test
    public void testSetTextAlignment2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetTextAlignment2;
            }
        }));
    }

    @Test
    public void testSetTextAlignment3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetTextAlignment3;
            }
        }));
    }

    @Test
    public void testSetTextAlignment4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetTextAlignment4;
            }
        }));
    }

    @Test
    public void testSetEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetEnabled1;
            }
        }));
    }

    @Test
    public void testSetNumberOfLines1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetNumberOfLines1;
            }
        }, 5000));
    }

    @Test
    public void testSetFont1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetFont1;
            }
        }));
    }

    @Test
    public void testSetLineBreakMode1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UILabelViewController.testSetLineBreakMode1;
            }
        }));
    }

}
