package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;

public class XIBTestPageViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestPageViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestPageViewController alloc();

    @Selector("init")
    public native XIBTestPageViewController init();

    UIPageControl pageControl;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "pageControl":
                pageControl = (UIPageControl)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "pageControl":
                return pageControl;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testNumberOfPages1 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testValueChanged1 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    public void viewDidLoad() {
        super.viewDidLoad();
    }

    public void viewDidUnload() {
        super.viewDidUnload();
        // Release any retained subviews of the main view.
        // e.g. myOutlet = nil;
    }

    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrame1 = (pageControl.frame().origin().x() == 53 && pageControl.frame().origin().y() == 366
                && pageControl.frame().size().width() == 214 && pageControl.frame().size().height() == 36);

        testNumberOfPages1 = (pageControl.numberOfPages() == 5);

        testBackgroundColor1 = (pageControl.backgroundColor().isEqual(UIColor.blueColor()));

        testAlpha1 = (pageControl.alpha() == 0.5);

        pageControl.setCurrentPage(1);
        pageControl.sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }

    @Selector("changePage:")
    public void changePage(Object sender) {
        testValueChanged1 = true;
    }

}
