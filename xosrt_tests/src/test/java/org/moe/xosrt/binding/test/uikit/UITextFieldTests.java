package org.moe.xosrt.binding.test.uikit;

import org.moe.xosrt.binding.test.uikit.controllers.UITextFieldViewController;

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

public class UITextFieldTests {

    static UITextFieldViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = UITextFieldViewController.alloc().init();
                //UIKit.UIApplicationMain(0, null, null, TestAppDelegate.class.getSimpleName());
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testDelegate1;
            }
        }, 10000));
    }

    @Test
    public void testSetDelegate1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetDelegate1;
            }
        }, 10000));
    }

    @Test
    public void testText1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testText1;
            }
        }, 10000));
    }

    @Test
    public void testSetText1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetText1;
            }
        }, 10000));
    }

    @Test
    public void testFont2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testFont2;
            }
        }, 10000));
    }

    @Test
    public void testSetFont1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetFont1;
            }
        }, 10000));
    }

    @Test
    public void testSetFont2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetFont2;
            }
        }, 10000));
    }

    @Test
    public void testTextColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testTextColor1;
            }
        }, 10000));
    }

    @Test
    public void testSetTextColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetTextColor1;
            }
        }, 10000));
    }

    //Fails in xCode as well
    @Ignore
    @Test
    public void testTextAlignment1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testTextAlignment1;
            }
        }, 10000));
    }

    @Test
    public void testSetTextAlignment1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetTextAlignment1;
            }
        }, 10000));
    }

    //Fails in xCode as well
    @Ignore
    @Test
    public void testSetTextAlignment2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetTextAlignment2;
            }
        }, 10000));
    }

    @Test
    public void testPlaceholder1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testPlaceholder1;
            }
        }, 10000));
    }

    @Test
    public void testSetPlaceholder1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetPlaceholder1;
            }
        }, 10000));
    }

    @Test
    public void testBorderStyle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testBorderStyle1;
            }
        }, 10000));
    }

    @Test
    public void testSetBorderStyle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetBorderStyle1;
            }
        }, 10000));
    }

    @Test
    public void testKeyboardType1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testKeyboardType1;
            }
        }, 10000));
    }

    @Test
    public void testSetKeyboardType1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetKeyboardType1;
            }
        }, 10000));
    }

    @Test
    public void testSetUserInteractionEnabled1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testSetUserInteractionEnabled1;
            }
        }, 10000));
    }

    @Ignore
    @Test
    public void testTextFieldShouldReturn1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return UITextFieldViewController.testTextFieldShouldReturn1;
            }
        }, 10000));
    }

}
