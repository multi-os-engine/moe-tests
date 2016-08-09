package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIViewAnimationTransition;

public class UIViewAnimationBasicViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIViewAnimationBasicViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIViewAnimationBasicViewController alloc();

    @Selector("init")
    public native UIViewAnimationBasicViewController init();

    NSMutableDictionary testResults;
    boolean  animationWillStartSelectorPass;
    boolean  animationDidStopSelectorPass;
    
    UIView subView1;
    UIView subView2;
    UIView subView3;
    UIView subView4;
    UIView subView5;
    UIView subView6;

    public static volatile boolean testSetAnimationDelegate1 = false;
    public static volatile boolean testSetAnimationWillStartSelector1 = false;
    public static volatile boolean testSetAnimationDidStopSelector1 = false;
    public static volatile boolean testBeginAnimations_context1 = false;
    public static volatile boolean testCommitAnimations1 = false;
    public static volatile boolean testSetAnimationDuration1 = false;
    public static volatile boolean testSetAnimationDuration2 = false;
    public static volatile boolean testSetAnimationDelay1 = false;

    static String animationDelegateTest = "animationDelegateTest";
    static String beginAnimations = "_beginAnimations_context";
    static String commitAnimations = "_commitAnimations";
    static String setAnimationDuration = "_setAnimationDuration";
    static String setAnimationDelay = "_setAnimationDelay";
    static String setAnimationStartDate = "_setAnimationStartDate";
    static String setAnimationCurve = "_setAnimationCurve";
    static String setAnimationRepeatCount = "_setAnimationRepeatCount";
    static String setAnimationRepeatAutoreverses = "_setAnimationRepeatAutoreverses";
    static String setAnimationBeginsFromCurrentState = "_setAnimationBeginsFromCurrentState";
    static String setAnimationTransition_forView_cache = "_setAnimationTransition_forView_cache";
    static String areAnimationsEnabled = "_areAnimationsEnabled";
    static String setAnimationsEnabled1 = "_setAnimationsEnabled1";
    static String setAnimationsEnabled2 = "_setAnimationsEnabled2";

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.greenColor());
        testResults = NSMutableDictionary.alloc().init();

    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        subView6 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(50, 80, 50, 80));
        UIView.beginAnimationsContext(animationDelegateTest, null);
        UIView.setAnimationWillStartSelector(new SEL("animationWillStart"));
        UIView.setAnimationDidStopSelector(new SEL("animationDidStop"));
        UIView.setAnimationDelegate(this);

        UIView.setAnimationDelay(0.1);
        UIView.setAnimationDuration_static(0.9);
        subView6.setFrame(CoreGraphics.CGRectMake(200, 210, 80, 100));
        view().setBackgroundColor(UIColor.redColor());
        UIView.commitAnimations();

        super.viewDidAppear(animated);
    }

    @Selector("animationWillStart")
    public void animationWillStart() {
        animationWillStartSelectorPass = true;
    }

    @Selector("animationDidStop")
    public void animationDidStop() {
        animationDidStopSelectorPass = true;
        beginTestAnimations();
    }

    @Selector("animationDelegateWillStart:context:")
    public void animationDelegateWillStartContext(String animationID, VoidPtr context) {
        NSNumber boolNumber = NSNumber.numberWithBool(false);
        testResults.setValueForKey(boolNumber, animationID);
    }

    @Selector("animationDelegateDidStop:finished:context:")
    public void animationDelegateDidStop(String animationID, NSNumber finished, VoidPtr context) {
        testResults.setValueForKey(finished, animationID);
        if (beginAnimations.equals(animationID)) {
            UIView.beginAnimationsContext(commitAnimations, null);
            UIView.setAnimationDelegate(this);
            UIView.setAnimationWillStartSelector(new SEL("animationDelegateWillStart:context:"));
            UIView.setAnimationDidStopSelector(new SEL("animationDelegateDidStop:finished:context:"));
            UIView.setAnimationDuration_static(0.2);
            subView2.setFrame(CoreGraphics.CGRectMake(250, 60, 60, 40));
            UIView.commitAnimations();
        } else if(commitAnimations.equals(animationID)) {
            UIView.beginAnimationsContext(setAnimationDuration, null);
            UIView.setAnimationDelegate(this);
            UIView.setAnimationWillStartSelector(new SEL("animationDelegateWillStart:context:"));
            UIView.setAnimationDidStopSelector(new SEL("animationDelegateDidStop:finished:context:"));
            UIView.setAnimationDuration_static(0.2);
            subView3.setFrame(CoreGraphics.CGRectMake(230, 110, 70, 20));
            UIView.commitAnimations();
        } else if(setAnimationDuration.equals(animationID)) {
            UIView.beginAnimationsContext(setAnimationTransition_forView_cache, null);
            UIView.setAnimationDelegate(this);
            UIView.setAnimationTransitionForViewCache(UIViewAnimationTransition.FlipFromRight, subView4, true);
            UIView.setAnimationWillStartSelector(new SEL("animationDelegateWillStart:context:"));
            UIView.setAnimationDidStopSelector(new SEL("animationDelegateDidStop:finished:context:"));
            UIView.setAnimationDuration_static(2);
            subView4.setFrame(CoreGraphics.CGRectMake(30, 140, 270, 230));
            subView4.setAlpha(0.5);
            UIView.commitAnimations();
        } else if(setAnimationTransition_forView_cache.equals(animationID)) {
            UIView.beginAnimationsContext(setAnimationDelay, null);
            UIView.setAnimationDelegate(this);
            UIView.setAnimationTransitionForViewCache(UIViewAnimationTransition.FlipFromRight, subView5, true);
            UIView.setAnimationWillStartSelector(new SEL("animationDelegateWillStart:context:"));
            UIView.setAnimationDidStopSelector(new SEL("animationDelegateDidStop:finished:context:"));
            UIView.setAnimationDuration_static(0.2);
            UIView.setAnimationDelay(0.5);
            subView5.setFrame(CoreGraphics.CGRectMake(10, 10, 20, 20));
            subView5.setBackgroundColor(UIColor.brownColor());
            UIView.commitAnimations();
        } else if(setAnimationDelay.equals(animationID)) {
            checkAnimations();
        }
    }

    public void beginTestAnimations() {

        subView1 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 10, 20, 20));
        subView1.setBackgroundColor(UIColor.blueColor());

        subView2 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 40, 20, 20));
        subView2.setBackgroundColor(UIColor.greenColor());

        subView3 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 70, 40, 10));
        subView3.setBackgroundColor(UIColor.magentaColor());

        subView4 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(30, 90, 20, 200));
        subView4.setBackgroundColor(UIColor.grayColor());

        subView5 = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(100, 10, 100, 200));
        subView5.setBackgroundColor(UIColor.purpleColor());

        view().addSubview(subView1);
        view().addSubview(subView2);
        view().addSubview(subView3);
        view().addSubview(subView4);
        view().addSubview(subView5);

        UIView.beginAnimationsContext(beginAnimations, null);
        UIView.setAnimationDelegate(this);
        UIView.setAnimationWillStartSelector(new SEL("animationDelegateWillStart:context:"));
        UIView.setAnimationDidStopSelector(new SEL("animationDelegateDidStop:finished:context:"));
        UIView.setAnimationDuration_static(0.5);
        subView1.setFrame(CoreGraphics.CGRectMake(250, 10, 40, 40));
        UIView.commitAnimations();

    }

    public void checkAnimations() {

        testSetAnimationDelegate1 = (animationWillStartSelectorPass && animationDidStopSelectorPass);

        testSetAnimationWillStartSelector1 = (animationWillStartSelectorPass);

        testSetAnimationDidStopSelector1 = (animationDidStopSelectorPass);

        NSNumber number = ((NSNumber)testResults.objectForKey(beginAnimations));

        boolean aTestResult = number.boolValue();
        testBeginAnimations_context1 = (aTestResult && subView1.frame().origin().x() == 250
                && subView1.frame().origin().y() == 10 && subView1.frame().size().width() == 40
                && subView1.frame().size().height() == 40);

        number = ((NSNumber) testResults.objectForKey(commitAnimations));

        aTestResult = number.boolValue();
        testCommitAnimations1 = (aTestResult && subView2.frame().origin().x() == 250
                && subView2.frame().origin().y() == 60 && subView2.frame().size().width() == 60
                && subView2.frame().size().height() == 40);

        number = ((NSNumber) testResults.objectForKey(setAnimationDuration));

        aTestResult = number.boolValue();
        testSetAnimationDuration1 = (aTestResult && subView3.frame().origin().x() == 230
                && subView3.frame().origin().y() == 110 && subView3.frame().size().width() == 70
                && subView3.frame().size().height() == 20);

        number = ((NSNumber) testResults.objectForKey(setAnimationTransition_forView_cache));
        aTestResult = number.boolValue();
        testSetAnimationDuration2 = (aTestResult && subView4.frame().origin().x() == 30
                && subView4.frame().origin().y() == 140 && subView4.frame().size().width() == 270
                && subView4.frame().size().height() == 230 && subView4.alpha() == 0.5);

        number = ((NSNumber) testResults.objectForKey(setAnimationDuration));

        aTestResult = number.boolValue();
        testSetAnimationDelay1 = (aTestResult && subView5.frame().origin().x() == 10
                && subView5.frame().origin().y() == 10 && subView5.frame().size().width() == 20
                && subView5.frame().size().height() == 20
                && subView5.backgroundColor().isEqual(UIColor.brownColor()));

    }

}
