package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UIProgressView;
import ios.uikit.UIScreen;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;
import ios.uikit.enums.UIProgressViewStyle;

public class UIProgressViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIProgressViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIProgressViewController alloc();

    @Selector("init")
    public native UIProgressViewController init();

    UIView subView1;
    UIProgressView progressView;
    UIProgressView progressView2;

    public static volatile boolean testInitWithProgressViewStyle1 = false;
    public static volatile boolean testInitWithProgressViewStyle2 = false;
    public static volatile boolean testInitWithProgressViewStyle3 = false;
    public static volatile boolean testInitWithProgressViewStyle4 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIScreen screen = UIScreen.mainScreen();
        setView(UIView.alloc().initWithFrame(screen.bounds()));
        view().setBackgroundColor(UIColor.grayColor());
        testMethod();
    }

    @Selector("startButtonClick")
    public void startButtonClick() {
        progressView.setProgressAnimated(0, true);
        progressView2.setProgressAnimated(0, false);
    }

    @Selector("mediumButtonClick")
    public void mediumButtonClick() {
        progressView.setProgressAnimated(0.5f, true);
        progressView2.setProgressAnimated(0.5f, false);
    }

    @Selector("endButtonClick")
    public void endButtonClick() {
        progressView.setProgressAnimated(1, true);
        progressView2.setProgressAnimated(1, false);
    }

    public void testMethod() {
        UIButton btn1 = UIButton.buttonWithType(UIButtonType.RoundedRect);
        btn1.setFrame(CoreGraphics.CGRectMake(0, 110, 90, 40));
        btn1.setTitleForState("start", UIControlState.Normal);
        view().addSubview(btn1);
        btn1.addTargetActionForControlEvents(this, new SEL("startButtonClick"), UIControlEvents.TouchDown);

        UIButton btn2 = UIButton.buttonWithType(UIButtonType.RoundedRect);
        btn2.setFrame(CoreGraphics.CGRectMake(95, 110, 90, 40));
        btn2.setTitleForState("medium", UIControlState.Normal);
        view().addSubview(btn2);
        btn2.addTargetActionForControlEvents(this, new SEL("mediumButtonClick"), UIControlEvents.TouchDown);

        UIButton btn3 = UIButton.buttonWithType(UIButtonType.RoundedRect);
        btn3.setFrame(CoreGraphics.CGRectMake(190, 110, 90, 40));
        btn3.setTitleForState("end", UIControlState.Normal);
        view().addSubview(btn3);
        btn3.addTargetActionForControlEvents(this, new SEL("endButtonClick"), UIControlEvents.TouchDown);

        progressView = UIProgressView.alloc().init();
        progressView.setFrame(CoreGraphics.CGRectMake(0, 90, UIScreen.mainScreen().bounds().size().width() - 20, 9));
        progressView.setProgress(0);
        view().addSubview(progressView);
        testInitWithProgressViewStyle1 = (progressView.progress() == 0);

        progressView2 = UIProgressView.alloc().initWithProgressViewStyle(UIProgressViewStyle.Bar);
        progressView2.setFrame(CoreGraphics.CGRectMake(0, 175, UIScreen.mainScreen().bounds().size().width() - 20, 9));
        progressView2.setProgress(0.5f);
        view().addSubview(progressView2);
        testInitWithProgressViewStyle2 = (progressView2.progress() == 0.5f);

        testInitWithProgressViewStyle3 = (progressView2.progressViewStyle() == UIProgressViewStyle.Bar);

        testInitWithProgressViewStyle4 = (progressView.progressViewStyle() == UIProgressViewStyle.Default);

        progressView.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = (!progressView.isUserInteractionEnabled());
    }
}
