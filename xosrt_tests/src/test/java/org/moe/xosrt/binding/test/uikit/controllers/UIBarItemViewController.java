package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.*;

public class UIBarItemViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIBarItemViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIBarItemViewController alloc();

    @Selector("init")
    public native UIBarItemViewController init();


    public static volatile boolean testEnabled1 = false;
    public static volatile boolean testTag1 = false;
    public static volatile boolean testTitle1 = false;

    public void testProperties() {
        UIBarItem barItem1 = UIBarButtonItem.alloc().init();
        UIBarItem barItem2 = UIBarButtonItem.alloc().init();
        UIBarItem barItem3 = UIBarButtonItem.alloc().init();
        barItem1.setEnabled(true);
        barItem2.setEnabled(false);
        testEnabled1 =  (barItem1.isEnabled() && !barItem2.isEnabled() && barItem3.isEnabled()) ;

        UIBarItem barItem7 = UIBarButtonItem.alloc().init();
        UIBarItem barItem8 = UIBarButtonItem.alloc().init();
        UIBarItem barItem9 = UIBarButtonItem.alloc().init();
        barItem7.setTag(10);
        barItem8.setTag(2);
        testTag1 =  (barItem7.tag() == 10 && barItem8.tag() == 2 && barItem9.tag() == 0) ;

        UIBarItem barItem10 = UIBarButtonItem.alloc().init();
        UIBarItem barItem11 = UIBarButtonItem.alloc().init();
        UIBarItem barItem12 = UIBarButtonItem.alloc().init();
        barItem10.setTitle("title1");
        barItem11.setTitle("title2");
        testTitle1 =  (barItem10.title().equals("title1") && barItem11.title().equals("title2") && barItem12.title() == null) ;

    }

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.blueColor());
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testProperties();
    }

}
