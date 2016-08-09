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

public class XIBTestPageControlViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestPageControlViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestPageControlViewController alloc();

    @Selector("init")
    public native XIBTestPageControlViewController init();

    UIScrollView scrollView;
    UIPageControl pageControl;
    
    boolean  pageControlIsChangingPage;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "scrollView":
                scrollView = (UIScrollView)value;
                break;
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
            case "scrollView":
                return scrollView;
            case "pageControl":
                return pageControl;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testValueChanged1 = false;

    public void viewDidLoad() {
        super.viewDidLoad();
    }

    public void viewDidUnload() {
        //scrollView.release();
        //pageControl.release();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        setupPage();
        testFrame1 = (pageControl.frame().origin().x() == 0 && pageControl.frame().origin().y() == 424
                && pageControl.frame().size().width() == 320 && pageControl.frame().size().height() == 36);

        pageControl.setCurrentPage(1);

        pageControl.sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }

    public void setupPage() {
        scrollView.setDelegate(this);

        long nimages;
        double cx = 0;
        for (nimages = 0; nimages < 5 ; nimages++) {
            String imageName = String.format("image%d.jpg", (nimages + 1));
            UIImage image = UIImage.imageNamed(imageName);
            if (image == null) {
                break;
            }
            UIImageView imageView = UIImageView.alloc().initWithImage(image);

            CGRect rect = imageView.frame();
            rect.size().setHeight(130);
            rect.size().setWidth(130);
            rect.origin().setX(((scrollView.frame().size().width() - 130) / 2) + cx);
            rect.origin().setY((scrollView.frame().size().height() - 130) / 2);

            imageView.setFrame(rect);

            scrollView.addSubview(imageView);
            //imageView.release();

            cx += scrollView.frame().size().width();
        }
        pageControl.setNumberOfPages(nimages);
        scrollView.setContentSize(CoreGraphics.CGSizeMake(cx, scrollView.bounds().size().height()));
    }

    @Selector("changePage:")
    public void changePage(Object sender) {
        CGRect frame = scrollView.frame();
        frame.origin().setX(frame.size().width() * pageControl.currentPage());
        frame.origin().setY(0);

        scrollView.scrollRectToVisibleAnimated(frame, true);
        testValueChanged1 = true;
    }

}
