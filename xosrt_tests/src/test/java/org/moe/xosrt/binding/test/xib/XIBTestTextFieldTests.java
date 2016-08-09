package org.moe.xosrt.binding.test.xib;

import org.moe.xosrt.binding.test.xib.controllers.XIBTestTextFieldViewController;
import ios.foundation.*;
import ios.foundation.NSOperationQueue.Block_addOperationWithBlock;
import ios.uikit.*;
import ios.uikit.protocol.UIApplicationDelegate;

import org.junit.BeforeClass;
import org.junit.Test;

import tools.ConditionWait;
import tools.ConditionWait.Condition;

import static org.junit.Assert.*;

public class XIBTestTextFieldTests {

    static XIBTestTextFieldViewController controller = null;
    private static volatile UIWindow main;

    @BeforeClass
    public static void starter() {
        ConditionWait.prepareConditionWait();
        NSOperationQueue.mainQueue().addOperationWithBlock(new Block_addOperationWithBlock() {
            @Override
            public void call_addOperationWithBlock() {
                main = (UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
                controller = (XIBTestTextFieldViewController) XIBTestTextFieldViewController.alloc()
                        .initWithNibNameBundle("XIBTestTextFieldViewController", null);
                main.setRootViewController(controller);
                ((UIApplicationDelegate) UIApplication.sharedApplication().delegate()).setWindow(main);
                main.makeKeyAndVisible();
            }
        });
    }

    @Test
    public void testFrame1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testFrame1;
            }
        }));
    }

    @Test
    public void testTitleForState1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTitleForState1;
            }
        }));
    }

    @Test
    public void testBorderStyle1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testBorderStyle1;
            }
        }));
    }

    @Test
    public void testBorderStyle2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testBorderStyle2;
            }
        }));
    }

    @Test
    public void testBorderStyle3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testBorderStyle3;
            }
        }));
    }

    @Test
    public void testBorderStyle4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testBorderStyle4;
            }
        }));
    }

    @Test
    public void testBackgroundColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testBackgroundColor1;
            }
        }));
    }

    @Test
    public void testBackgroundColor2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testBackgroundColor2;
            }
        }));
    }

    @Test
    public void testBackgroundColor3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testBackgroundColor3;
            }
        }));
    }

    @Test
    public void testBackgroundColor4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testBackgroundColor4;
            }
        }));
    }

    @Test
    public void testTextColor1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTextColor1;
            }
        }));
    }

    @Test
    public void testTextColor2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTextColor2;
            }
        }));
    }

    @Test
    public void testTextColor3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTextColor3;
            }
        }));
    }

    @Test
    public void testTextColor4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTextColor4;
            }
        }));
    }

    @Test
    public void testAlpha1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testAlpha1;
            }
        }));
    }

    @Test
    public void testAlpha2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testAlpha2;
            }
        }));
    }

    @Test
    public void testAlpha3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testAlpha3;
            }
        }));
    }

    @Test
    public void testAlpha4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testAlpha4;
            }
        }));
    }

    @Test
    public void testTextAlignment1() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTextAlignment1;
            }
        }));
    }

    @Test
    public void testTextAlignment2() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTextAlignment2;
            }
        }));
    }

    @Test
    public void testTextAlignment3() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTextAlignment3;
            }
        }));
    }

    @Test
    public void testTextAlignment4() {
        assertTrue(ConditionWait.tillGlobalTime(new Condition() {
            @Override
            public boolean check() {
                return XIBTestTextFieldViewController.testTextAlignment4;
            }
        }));
    }

}
