package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.UIActivityIndicatorView;
import ios.uikit.UIColor;
import ios.uikit.UIScreen;
import ios.uikit.UIView;
import ios.uikit.UIViewController;


public class UIActivityIndicatorViewTestViewController extends UIViewController {

    public static boolean hidesWhenStopped1Passed = false;
    public static boolean startAnimatingPassed = false;
    public static boolean hidesWhenStopped2Passed = false;
    public static boolean stopAnimatingPassed = false;

    static {
        NatJ.register();
    }

    protected UIActivityIndicatorViewTestViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIActivityIndicatorViewTestViewController alloc();

    @Selector("init")
    public native UIActivityIndicatorViewTestViewController init();

    @Selector("loadView")
    @Override
    public void loadView() {
        UIActivityIndicatorView activity = (UIActivityIndicatorView)UIActivityIndicatorView.alloc()
                .initWithFrame(CoreGraphics.CGRectMake(0, 0, 50, 50));
        activity.setTag(1);

        UIScreen screenObject = UIScreen.mainScreen();
        UIView newView = UIView.alloc().initWithFrame(screenObject.applicationFrame());
        newView.addSubview(activity);

        setView(newView);
        view().setBackgroundColor(UIColor.blueColor());
    }

    @Selector("viewWillAppear:")
    @Override
    public void viewWillAppear(boolean animated) {
        UIActivityIndicatorView activity = (UIActivityIndicatorView) view().viewWithTag(1);

        hidesWhenStopped1Passed = activity.hidesWhenStopped();

        activity.startAnimating();
        startAnimatingPassed = activity.isAnimating();

        activity.setHidesWhenStopped(false);
        activity.stopAnimating();
        hidesWhenStopped2Passed = !activity.isHidden();

        activity.startAnimating();
        activity.setHidesWhenStopped(true);
        activity.stopAnimating();
        stopAnimatingPassed = !activity.isAnimating();

        activity.startAnimating();
    }
}
