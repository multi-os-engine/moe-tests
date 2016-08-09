package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.*;
import ios.uikit.*;

public class UIImageViewAnimationViewController extends UIViewController {
    static {
        NatJ.register();
    }

    protected UIImageViewAnimationViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIImageViewAnimationViewController alloc();

    @Selector("init")
    public native UIImageViewAnimationViewController init();

    UIImageView flameAnimation;

    public static volatile boolean testAnimationImages1 = false;
    public static volatile boolean testIsAnimating1 = false;
    public static volatile boolean testAnimationDuration1 = false;
    public static volatile boolean testAnimationRepeatCount1 = false;
    public static volatile boolean testStartAnimating1 = false;
    public static volatile boolean testStopAnimating1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        flameAnimation = (UIImageView)UIImageView.alloc().initWithFrame(
                CoreGraphics.CGRectMake(0, 0, 320, 480));
        UIView view = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480));
        view.addSubview(flameAnimation);
        setView(view);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        NSArray array = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(UIImage.class, new UIImage[]{
                        UIImage.imageNamed("animImg/iFlame 001.jpg"),
                        UIImage.imageNamed("animImg/iFlame 002.jpg"),
                        UIImage.imageNamed("animImg/iFlame 003.jpg"),
                        UIImage.imageNamed("animImg/iFlame 004.jpg"),
                        UIImage.imageNamed("animImg/iFlame 005.jpg"),
                        UIImage.imageNamed("animImg/iFlame 006.jpg"),
                        UIImage.imageNamed("animImg/iFlame 007.jpg"),
                        UIImage.imageNamed("animImg/iFlame 008.jpg"),
                        UIImage.imageNamed("animImg/iFlame 009.jpg"),
                        UIImage.imageNamed("animImg/iFlame 010.jpg"),
                        UIImage.imageNamed("animImg/iFlame 009.jpg"),
                        UIImage.imageNamed("animImg/iFlame 008.jpg"),
                        UIImage.imageNamed("animImg/iFlame 007.jpg"),
                        UIImage.imageNamed("animImg/iFlame 006.jpg"),
                        UIImage.imageNamed("animImg/iFlame 005.jpg"),
                        UIImage.imageNamed("animImg/iFlame 004.jpg"),
                        UIImage.imageNamed("animImg/iFlame 003.jpg"),
                        UIImage.imageNamed("animImg/iFlame 002.jpg")
                }), 18);
        flameAnimation.setAnimationImages(array);
        testAnimationImages1 = (flameAnimation.animationImages().isEqualToArray(array));

        testIsAnimating1 = (!flameAnimation.isAnimating());
        flameAnimation.setAnimationDuration(1.0);
        testAnimationDuration1 = (flameAnimation.animationDuration() == 1.0);
        flameAnimation.setAnimationRepeatCount(7);
        testAnimationRepeatCount1 = (flameAnimation.animationRepeatCount() == 7);
        flameAnimation.startAnimating();
        testStartAnimating1 = flameAnimation.isAnimating();

        performSelectorWithObjectAfterDelay(new SEL("stopAnimation"), null, 5);
    }

    @Selector("stopAnimation")
    public void stopAnimation() {
        flameAnimation.stopAnimating();
        testStopAnimating1 = !flameAnimation.isAnimating();
    }
}
