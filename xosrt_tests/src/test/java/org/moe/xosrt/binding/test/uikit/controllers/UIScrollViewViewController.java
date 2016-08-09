package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;
import ios.uikit.protocol.UIScrollViewDelegate;

public class UIScrollViewViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIScrollViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIScrollViewViewController alloc();

    @Selector("init")
    public native UIScrollViewViewController init();

    
    UIScrollView scrollView;

    public static volatile boolean testContentSize1 = false;
    public static volatile boolean testScrollEnabled1 = false;
    public static volatile boolean testContentOffset1 = false;
    public static volatile boolean testShowsVerticalScrollIndicator1 = false;
    public static volatile boolean testShowsHorizontalScrollIndicator1 = false;
    public static volatile boolean testScrollRectToVisible1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;
    public static volatile boolean testSetContentOffset_animated2 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        scrollView = UIScrollView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 10, 300, 400));
        scrollView.setBackgroundColor(UIColor.redColor());
        scrollView.setContentSize(CoreGraphics.CGSizeMake(1000, 1580));
        scrollView.setScrollEnabled(true);
        scrollView.setDelegate(this);


        UIView newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480));
        newView.setBackgroundColor(UIColor.whiteColor());
        newView.addSubview(scrollView);
        setView(newView);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        UIView viewScroll = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 300, 600));
        viewScroll.setBackgroundColor(UIColor.blueColor());
        scrollView.addSubview(viewScroll);

        UIView viewScroll2 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 650, 300, 600));
        viewScroll2.setBackgroundColor(UIColor.magentaColor());
        scrollView.addSubview(viewScroll2);

        testContentSize1 = (scrollView.contentSize().width() == 1000 && scrollView.contentSize().height() == 1580);

        testScrollEnabled1 = (scrollView.isScrollEnabled());

        scrollView.setContentOffset(CoreGraphics.CGPointMake(500, 150));
        testContentOffset1 = (scrollView.contentOffset().x() == 500 && scrollView.contentOffset().y() == 150);

        scrollView.setShowsVerticalScrollIndicator(true);
        testShowsVerticalScrollIndicator1 = (scrollView.showsVerticalScrollIndicator()) ;

        scrollView.setShowsHorizontalScrollIndicator(true);
        testShowsHorizontalScrollIndicator1 = (scrollView.showsHorizontalScrollIndicator()) ;

        scrollView.setContentOffsetAnimated(CoreGraphics.CGPointMake(300, 100), true);
        performSelectorWithObjectAfterDelay(new SEL("testSetContentOffset"), null, 1);
    }

    @Selector("testScrollRectToVisible")
    public void testScrollRectToVisible() {
        UIButton  button = (UIButton)scrollView.viewWithTag(2);
        button.sendActionsForControlEvents(UIControlEvents.TouchDown);
    }

    @Selector("click")
    public void click() {
        scrollView.scrollRectToVisibleAnimated(CoreGraphics.CGRectMake(200, 10, 200, 30), true);

        CGPoint point = scrollView.contentOffset();
        testScrollRectToVisible1 = (scrollView.contentOffset().x() == 400 && scrollView.contentOffset().y() == 230) ;

        scrollView.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = (!scrollView.isUserInteractionEnabled());

    }

    @Selector("testSetContentOffset")
    public void testSetContentOffset() {
        testSetContentOffset_animated2 = (scrollView.contentOffset().x() == 300 && scrollView.contentOffset().y() == 100) ;

        UILabel label = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(200, 10, 200, 30));
        label.setText("Labellllllllllllllllllllll");
        label.setBackgroundColor(UIColor.greenColor());
        label.setTag(1);
        scrollView.addSubview(label);

        UIButton button = UIButton.alloc().initWithFrame(CoreGraphics.CGRectMake(500, 600, 200, 30));
        button.setBackgroundColor(UIColor.greenColor());

        button.setTitleForState("Click Me!!!", UIControlState.Normal);
        button.addTargetActionForControlEvents(this, new SEL("click"), UIControlEvents.TouchDown);
        button.setTag(2);
        scrollView.addSubview(button);

        scrollView.scrollRectToVisibleAnimated(CoreGraphics.CGRectMake(500, 600, 200, 30), true);

        performSelectorWithObjectAfterDelay(new SEL("testScrollRectToVisible"), null, 2);
    }

}
