package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UITextViewViewController;

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

public class UITextViewTests {

    static UITextViewViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UITextViewViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testText1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testText1;
            }
        }));
    }

    @Test
    public void testSetText1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testSetText1;
            }
        }));
    }

    @Test
    public void testFont1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testFont1;
            }
        }));
    }

    @Test
    public void testSetFont1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testSetFont1;
            }
        }));
    }

    @Test
    public void testTextColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testTextColor1;
            }
        }));
    }

    @Test
    public void testSetTextColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testSetTextColor1;
            }
        }));
    }

    @Test
    public void testIsEditable1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testIsEditable1;
            }
        }));
    }

    @Test
    public void testSetEditable1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testSetEditable1;
            }
        }));
    }

    //Fails in xCode as well
    @Ignore
    @Test
    public void testTextAlignment1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testTextAlignment1;
            }
        }));
    }

    @Test
    public void testSetTextAlignment1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testSetTextAlignment1;
            }
        }));
    }

    //Fails in xCode as well
    @Ignore
    @Test
    public void testSetTextAlignment2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testSetTextAlignment2;
            }
        }));
    }

    @Test
    public void testHasText1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testHasText1;
            }
        }));
    }

    @Test
    public void testDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testDelegate1;
            }
        }));
    }

    @Test
    public void testSetDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testSetDelegate1;
            }
        }));
    }

    @Test
    public void testSetUserInteractionEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextViewViewController.testSetUserInteractionEnabled1;
            }
        }));
    }

}
