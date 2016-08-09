package org.moe.xosrt.binding.test.uikit.controllers;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.NSNumber;
import ios.quartzcore.CALayer;
import ios.uikit.UIColor;
import ios.uikit.UIView;
import ios.uikit.UIViewController;

public class CALayerTestViewController extends UIViewController {

    UIView subView1;
    UIView subView2;

    private static final String beginAnimations = "_beginAnimations_context";
    private static final String commitAnimations = "_commitAnimations";

    public static volatile boolean testPresentationLayer1 = false;
    public static volatile boolean testPresentationLayer2 = false;
    public static volatile boolean testPresentationLayer3 = false;
    public static volatile boolean testPresentationLayer4 = false;

    static {
        NatJ.register();
    }

    protected CALayerTestViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native CALayerTestViewController alloc();

    @Selector("init")
    public native CALayerTestViewController init();

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.grayColor());
        subView1 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(30, 90, 20, 200));
        
        subView1.setBackgroundColor(UIColor.grayColor());
        view().addSubview(subView1);
        subView2 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(100, 10, 100, 200));
        subView2.setBackgroundColor(UIColor.purpleColor());
        view().addSubview(subView2);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean bAnimated) {
        CALayer layer = subView1.layer();
        CGRect frame = ((CALayer)layer.presentationLayer()).frame();
        testPresentationLayer1 = (frame.origin().x() == 30 && frame.origin().y() == 90);

        CALayer layer2 = subView2.layer();
        CGRect frame2 = ((CALayer)layer2.presentationLayer()).frame();
        testPresentationLayer2 = (frame2.origin().x() == 100 && frame2.origin().y() == 10);

        super.viewDidAppear(bAnimated);
        beginTestAnimations();

    }

    public void beginTestAnimations() {
        UIView.beginAnimationsContext(beginAnimations, null);
        UIView.setAnimationWillStartSelector(new SEL("animationDelegateWillStart:context"));
        UIView.setAnimationDidStopSelector(new SEL("animationDelegateDidStop:finished:context"));
        UIView.setAnimationDelegate(this);
        UIView.setAnimationDuration_static(0.5);
        subView1.setFrame(CoreGraphics.CGRectMake(250, 10, 40, 40));
        UIView.commitAnimations();
    }

    @Selector("animationDelegateDidStop:finished:context")
    public void animationDelegateDidStopFinishedContext(String animationId, NSNumber finished, VoidPtr ctx) {
        if (beginAnimations.equals(animationId)) {
            UIView.beginAnimationsContext(commitAnimations, null);
            UIView.setAnimationWillStartSelector(new SEL("animationDelegateWillStart:context"));
            UIView.setAnimationDidStopSelector(new SEL("animationDelegateDidStop:finished:context"));
            UIView.setAnimationDelegate(this);
            UIView.setAnimationDuration_static(0.2);
            subView2.setFrame(CoreGraphics.CGRectMake(200, 200, 60, 40));
            UIView.commitAnimations();
        } else if (commitAnimations.equals(animationId)) {
            checkAnimations();
        }
    }

    @Selector("animationDelegateWillStart:context")
    public void animationDelegateWillStartContext(String animationId, VoidPtr ctx) {

    }

    public void checkAnimations() {
        CALayer layer3 = subView1.layer();
        CGRect frame3 = ((CALayer)layer3.presentationLayer()).frame();
        testPresentationLayer3 = (frame3.origin().x() == 250 && frame3.origin().y() == 10
                && frame3.size().width() == 40 && frame3.size().height() == 40);

        CALayer layer4 = subView2.layer();
        CGRect frame4 = ((CALayer)layer4.presentationLayer()).frame();
        testPresentationLayer4 = (frame4.origin().x() == 200 && frame4.origin().y() == 200
                && frame4.size().width() == 60 && frame4.size().height() == 40);
    }
}
