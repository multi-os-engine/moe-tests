package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class UIViewViewController extends UIViewController {

    private static final double DOUBLE_DISTORTION = 0.00001;

    static {
        NatJ.register();
    }

    protected UIViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIViewViewController alloc();

    @Selector("init")
    public native UIViewViewController init();

    
    UIView subView1;
    UIView subView2;
    UIView subView3;
    UIView subView4;
    UIView subView5;
    
    public UIWindow window;

    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testSetBackgroundColor2 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testSetAlpha1 = false;
    public static volatile boolean testIsHidden1 = false;
    public static volatile boolean testIsHidden2 = false;
    public static volatile boolean testSetHidden1 = false;
    public static volatile boolean testSetHidden2 = false;
    public static volatile boolean testFrame1 = false;
    public static volatile boolean testFrame2 = false;
    public static volatile boolean testSetFrame1 = false;
    public static volatile boolean testSetFrame2 = false;
    public static volatile boolean testBounds1 = false;
    public static volatile boolean testCenter1 = false;
    public static volatile boolean testSetBounds1 = false;
    public static volatile boolean testSetCenter1 = false;
    public static volatile boolean testSetCenter2 = false;
    public static volatile boolean testAddSubView1 = false;
    public static volatile boolean testAddSubView2 = false;
    public static volatile boolean testSubviews1 = false;
    public static volatile boolean testRemoveFromSuperview1 = false;
    public static volatile boolean testSuperview1 = false;
    public static volatile boolean testInsertSubview_atIndex1 = false;
    public static volatile boolean testInsertSubview_aboveSubview = false;
    public static volatile boolean testInsertSubview_belowSubview = false;
    public static volatile boolean testBringSubviewToFront1 = false;
    public static volatile boolean testBringSubviewToFront2 = false;
    public static volatile boolean testBringSubviewToFront3 = false;
    public static volatile boolean testSendSubviewToBack1 = false;
    public static volatile boolean testSendSubviewToBack2 = false;
    public static volatile boolean testExchangeSubviewAtIndex_withSubviewAtIndex1 = false;
    public static volatile boolean testExchangeSubviewAtIndex_withSubviewAtIndex2 = false;
    public static volatile boolean testIsDescendantOfView1 = false;
    public static volatile boolean testIsDescendantOfView2 = false;
    public static volatile boolean testIsDescendantOfView3 = false;
    public static volatile boolean testInitWithFrame1 = false;
    public static volatile boolean testInitWithFrame2 = false;
    public static volatile boolean testTag1 = false;
    public static volatile boolean testSetTag1 = false;
    public static volatile boolean testViewWithTag1 = false;
    public static volatile boolean testIsUserInteractionEnabled1 = false;
    public static volatile boolean testWindow1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        //view().release();
        view().setBackgroundColor(UIColor.blueColor());

        subView1 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(12, 50, 50, 50));

        subView2 = UIView.alloc().init();
        subView2.setFrame(CoreGraphics.CGRectMake(100, 100, 30, 35));
        subView2.setBackgroundColor(UIColor.redColor());
        subView2.setTag(20);

        subView3 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(100, 200, 53, 51));
        subView3.setBackgroundColor(UIColor.greenColor());
        subView3.setHidden(true);
        subView3.setTag(30);

        subView4 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(50, 300, 53, 51));
        subView4.setBackgroundColor(UIColor.redColor());
        subView4.setHidden(true);
        subView4.setTag(40);
    }

    @Selector("viewWillAppear:")
    @Override
    public void viewWillAppear(boolean animated) {
        checkVisualProperties();
        checkGeometryProperties();
        checkVisualHierarchy1();
        checkVisualHierarchy2();
        checkOtherMethods();
        performSelectorWithObjectAfterDelay(new SEL("checkWindowProperty"), null, 1);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {

        view().setFrame(view().window().frame());
        view().setBounds(view().window().bounds());
        view().setCenter(view().window().center());

        view().setBackgroundColor(UIColor.redColor());
    }

    public void checkVisualProperties() {
        subView1.setBackgroundColor(UIColor.yellowColor());
        testBackgroundColor1 = (subView1.backgroundColor() == UIColor.yellowColor());

        subView2.setBackgroundColor(UIColor.grayColor());

        testSetBackgroundColor2 = (subView2.backgroundColor() == UIColor.grayColor());

        testAlpha1 = (view().alpha() == (double)1.0 && subView3.alpha() == (double)1.0 && subView1.alpha() == (double)1.0);

        view().setAlpha(0.7);
        subView3.setAlpha(0.3);
        testSetAlpha1 = (Math.abs(view().alpha() - 0.7) < DOUBLE_DISTORTION
                && Math.abs(subView3.alpha() - 0.3) < DOUBLE_DISTORTION
                && subView1.alpha() == (double)1.0);

        testIsHidden1 = !subView1.isHidden();

        subView2.setHidden(false);
        testIsHidden2 = !subView2.isHidden();

        subView2.setHidden(true);
        subView3.setHidden(false);
        testSetHidden1 = (subView2.isHidden() && !subView3.isHidden());

        UIView viewWithSubviews1 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 300, 320, 180));
        viewWithSubviews1.setBackgroundColor(UIColor.magentaColor());
        viewWithSubviews1.setHidden(false);
        UIView viewSubview1 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 10, 50, 50));
        viewSubview1.setBackgroundColor(UIColor.brownColor());
        viewSubview1.setHidden(false);
        viewWithSubviews1.addSubview(viewSubview1);
        view().addSubview(viewWithSubviews1);
        viewWithSubviews1.setHidden(true);

        testSetHidden2 = (viewWithSubviews1.isHidden() && !viewSubview1.isHidden());
    }

    public void checkGeometryProperties() {
        testFrame1 =  (subView1.frame().origin().x() == 12
                && subView1.frame().origin().y() == 50
                && subView1.frame().size().width() == 50
                && subView1.frame().size().height() == 50);

        testFrame2 = (subView2.frame().origin().x() == 100
                && subView2.frame().origin().y() == 100
                && subView2.frame().size().width() == 30
                && subView2.frame().size().height() == 35);

        subView1.setFrame(CoreGraphics.CGRectMake(150, 150, 32, 33));
        testSetFrame1 = (subView1.frame().origin().x() == 150
                && subView1.frame().origin().y() == 150
                && subView1.frame().size().width() == 32
                && subView1.frame().size().height() == 33);


        subView2.setFrame(CoreGraphics.CGRectMake(15, 45, 55, 56));
        testSetFrame2 = (subView2.frame().origin().x() == 15
                && subView2.frame().origin().y() == 45
                && subView2.frame().size().width() == 55
                && subView2.frame().size().height() == 56) ;

        testBounds1 = (view().bounds().origin().x() == 0
                && view().bounds().origin().y() == 0
                && view().bounds().size().width() == 320
                && view().bounds().size().height() == 480);

        System.out.println("Tests Center: " + view().center().x()
                + " " + view().center().y());
        testCenter1 = (view().center().x() == 160.0 && view().center().y() == 240.0);

        view().setBounds(CoreGraphics.CGRectMake(30, 60, 290, 450));
        testSetBounds1 = (view().bounds().origin().x() == 30
                && view().bounds().origin().y() == 60
                && view().bounds().size().width() == 290
                && view().bounds().size().height() == 450);

        view().setCenter(CoreGraphics.CGPointMake((double) 160, (double) 480));
        testSetCenter1 = (view().center().x() == 160.0 && view().center().y() == 480);

        view().setCenter(CoreGraphics.CGPointMake((double) 162.0, (double) 242.0));
        testSetCenter2 = (view().center().x() == 162.0 && view().center().y() == 242.0);
    }

    public void checkVisualHierarchy1() {


        view().addSubview(subView1);
        boolean subView1Added = checkSubViewAddedIn(subView1, view());

        testAddSubView1 = (subView1Added);

        view().addSubview(subView2);
        boolean subView2Added = checkSubViewAddedIn(subView2, view());

        testAddSubView2 = (subView2Added);

        view().addSubview(subView3);
        view().addSubview(subView4);
        testSubviews1 = (checkSubViewAddedIn(subView1, view())
                && checkSubViewAddedIn(subView2, view())
                && checkSubViewAddedIn(subView3, view()));

        subView2.removeFromSuperview();
        testRemoveFromSuperview1 = (!checkSubViewAddedIn(subView2, view()));

        testSuperview1 = (subView1.superview() == view() && subView2.superview() == null
                && subView3.superview() == view());

        view().insertSubviewAtIndex(subView2, 1);
        testInsertSubview_atIndex1 = (view().subviews().objectAtIndex(1) == subView2);

        view().setAlpha(1.0);
        subView4 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(145, 145, 20, 20));
        subView4.setBackgroundColor(UIColor.blackColor());
        view().insertSubviewAboveSubview(subView4, subView1);
        testInsertSubview_aboveSubview = (checkSubViewAddedIn(subView4, view()) && subView4.superview() == view());


        subView5 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(130, 130, 60, 60));
        subView5.setBackgroundColor(UIColor.darkGrayColor());
        view().insertSubviewBelowSubview(subView5, subView1);

        testInsertSubview_belowSubview = (checkSubViewAddedIn(subView5, view()) && subView5.superview() == view());

    }

    public void checkVisualHierarchy2() {

        view().bringSubviewToFront(subView1);
        testBringSubviewToFront1 = (view().subviews().objectAtIndex(view().subviews().count() - 1) == subView1);

        view().bringSubviewToFront(subView5);
        testBringSubviewToFront2 = (view().subviews().objectAtIndex(view().subviews().count() - 1) == subView5);

        view().bringSubviewToFront(subView4);
        testBringSubviewToFront3 = (view().subviews().objectAtIndex(view().subviews().count() - 1) == subView4);

        view().sendSubviewToBack(subView1);
        testSendSubviewToBack1 = (view().subviews().objectAtIndex(0) == subView1);

        view().sendSubviewToBack(subView5);
        testSendSubviewToBack2 = (view().subviews().objectAtIndex(0) == subView5);

        view().exchangeSubviewAtIndexWithSubviewAtIndex(0, view().subviews().count() - 1);
        testExchangeSubviewAtIndex_withSubviewAtIndex1 = (view().subviews().objectAtIndex(0) == subView4
                && view().subviews().objectAtIndex(view().subviews().count() - 1) == subView5);

        view().exchangeSubviewAtIndexWithSubviewAtIndex(0, view().subviews().count() - 1);
        testExchangeSubviewAtIndex_withSubviewAtIndex2 = (view().subviews().objectAtIndex(0) == subView5
                && view().subviews().objectAtIndex(view().subviews().count() - 1) == subView4);

        testIsDescendantOfView1 = subView1.isDescendantOfView(view());

        testIsDescendantOfView2 = subView5.isDescendantOfView(view());

        testIsDescendantOfView3 = subView1.isDescendantOfView(subView1);
    }

    public void checkOtherMethods() {
        testInitWithFrame1 = (subView1 != null);

        testInitWithFrame2 = (subView2 != null);

        testTag1 = (subView2.tag() == 20);

        subView3.setTag(40);
        testSetTag1 = (subView3.tag() == 40);

        testViewWithTag1 = (subView2.viewWithTag(100) == null
                && view().viewWithTag(20) == subView2
                && view().viewWithTag(40) == subView3);

        subView2.setUserInteractionEnabled(false);
        boolean interaction = subView2.isUserInteractionEnabled();
        testIsUserInteractionEnabled1 = (!interaction);
        subView2.setUserInteractionEnabled(true);
    }

    @Selector("checkWindowProperty")
    public void checkWindowProperty() {
        testWindow1 = (view().window() == window);
    }

    public boolean checkSubViewAddedIn(UIView child,UIView parent) {
        boolean subView1Added = false;
        for( int i = 0; i < parent.subviews().count(); i++) {
            UIView uiv = (UIView)parent.subviews().objectAtIndex(i);
            if (uiv == child) {
                subView1Added = true;
                break;
            }
        }
        return subView1Added;
    }

}
