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
import ios.uikit.enums.UIViewAnimationTransition;

public class UIViewAnimationBasic2ViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIViewAnimationBasic2ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIViewAnimationBasic2ViewController alloc();

    @Selector("init")
    public native UIViewAnimationBasic2ViewController init();

    UIImageView  h1;
    UIImageView  h2;
    

    public static volatile boolean testSetAnimationTransition_forView_cache1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.blueColor());
        UIView  newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 40, 260, 400));
        newView.setBackgroundColor(UIColor.greenColor());
        newView.setTag(1);

        UIImage  hamster1 = UIImage.imageNamed("hamster1.png");
        h1 = UIImageView.alloc().initWithImage(hamster1);
        h1.setFrame(CoreGraphics.CGRectMake(0, 0, 250, 250));

        UIImage  hamster2 = UIImage.imageNamed("hamster2.png");
        h2 = UIImageView.alloc().initWithImage(hamster2);
        h2.setFrame(CoreGraphics.CGRectMake(0, 0, 250, 250));

        view().addSubview(newView);
        newView.addSubview(h1);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {

        UIView  newView = view().viewWithTag(1);
        UIView view1 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 300, 100, 100));
        view1.setBackgroundColor(UIColor.redColor());

        UIView.beginAnimationsContext(null, null);
        UIView.setAnimationDuration_static(5);
        UIView.setAnimationTransitionForViewCache(UIViewAnimationTransition.FlipFromLeft, newView, false);
        UIView.setAnimationDidStopSelector(new SEL("animationDidStop"));
        UIView.setAnimationDelegate(this);

        newView.setFrame(CoreGraphics.CGRectMake(50, 110, 180, 450));
        newView.setAlpha(0.5);
        h1.removeFromSuperview();
        newView.addSubview(h2);
        newView.addSubview(view1);

        UIView.commitAnimations();
    }

    @Selector("animationDidStop")
    public void animationDidStop() {
        UIView  newView = view().viewWithTag(1);
        testSetAnimationTransition_forView_cache1 = (newView.frame().origin().x() == 50
                && newView.frame().origin().y() == 110
                && newView.frame().size().width() == 180
                && newView.frame().size().height() == 450
                && newView.alpha() == 0.5
                && newView.subviews().count() == 2
                && newView.subviews().objectAtIndex(0) == h2);
    }

    public void dealloc() {
        super.dealloc();
    }

}
