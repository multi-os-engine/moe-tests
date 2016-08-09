package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;

public class UIPageControlViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIPageControlViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIPageControlViewController alloc();

    @Selector("init")
    public native UIPageControlViewController init();

    
    UIScrollView scrollView;
    UIPageControl pageControl;
    UIView  subview;
    NSArray views;
    boolean  passTest;

    public static volatile boolean testCurrentPage1 = false;
    public static volatile boolean testNumberOfPages1 = false;
    public static volatile boolean testDefersCurrentPageDisplay1 = false;
    public static volatile boolean testDefersCurrentPageDisplay2 = false;
    public static volatile boolean testSizeForNumberOfPages1 = false;
    public static volatile boolean testHidesForSinglePage1 = false;
    public static volatile boolean testHidesForSinglePage2 = false;
    public static volatile boolean testUpdateCurrentPageDisplay1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        scrollView = UIScrollView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 444));

        views = NSArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                UIColor.class, new UIColor[] {
                        UIColor.yellowColor(), UIColor.greenColor(), UIColor.blueColor(), UIColor.redColor()
                }), 4);

        for ( int i = 0; i < views.count(); i++) {
            CGRect frame = CoreGraphics.CGRectZero();
            frame.origin().setX(scrollView.frame().size().width() * i);
            frame.origin().setY(0);
            frame.setSize(scrollView.frame().size());

            subview = UIView.alloc().initWithFrame(frame);
            subview.setBackgroundColor((UIColor) views.objectAtIndex(i));

            scrollView.addSubview(subview);
        }
        scrollView.setContentSize(CoreGraphics.CGSizeMake(
                scrollView.frame().size().width() * views.count(), scrollView.frame().size().height()));

        pageControl = UIPageControl.alloc().init();
        double width = (6 * views.count()) + (10 * (views.count() - 1));
        pageControl.setFrame(CoreGraphics.CGRectMake(0, scrollView.frame().size().height() , width , 36));
        pageControl.setCurrentPage(0);
        pageControl.setNumberOfPages(views.count());
        pageControl.addTargetActionForControlEvents(this, new SEL("changePage"), UIControlEvents.ValueChanged);

        view().addSubview(pageControl);
        view().addSubview(scrollView);
    }

    @Selector("changePage")
    public void changePage() {
        CGRect frame = CoreGraphics.CGRectZero();
        frame.origin().setX(scrollView.frame().size().width() * pageControl.currentPage());
        frame.origin().setY(0);
        frame.setSize(scrollView.frame().size());
        scrollView.scrollRectToVisibleAnimated(frame, true);

        if (pageControl.defersCurrentPageDisplay()) {
            pageControl.updateCurrentPageDisplay();
            passTest = true;
        }
    }

    public void viewWillAppear(boolean animated) {
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        passTest = false;
        testMethod();
    }

    public void dealloc() {
        super.dealloc();
    }

    public void testMethod() {

        testCurrentPage1 = (pageControl.currentPage() == 0);

        testNumberOfPages1 = (pageControl.numberOfPages() == views.count());

        pageControl.setDefersCurrentPageDisplay(false);
        testDefersCurrentPageDisplay1 = (!pageControl.defersCurrentPageDisplay());

        pageControl.setDefersCurrentPageDisplay(true);
        testDefersCurrentPageDisplay2 = (pageControl.defersCurrentPageDisplay());

        CGSize size = pageControl.sizeForNumberOfPages(views.count());

        testSizeForNumberOfPages1 = (size.width() >= 36);
        pageControl.setFrame(CoreGraphics.CGRectMake(
                0, scrollView.frame().size().height(), view().frame().size().width(), 36));


        pageControl.setHidesForSinglePage(false);
        testHidesForSinglePage1 = (!pageControl.hidesForSinglePage());

        pageControl.setHidesForSinglePage(true);
        testHidesForSinglePage2 = (pageControl.hidesForSinglePage());

        pageControl.setCurrentPage(2);
        pageControl.sendActionsForControlEvents(UIControlEvents.ValueChanged);

        testUpdateCurrentPageDisplay1 = (passTest);


        pageControl.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = (!pageControl.isUserInteractionEnabled());
    }

}
