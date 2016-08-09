package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.testhelpers.SubviewViewController;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class UIViewControllerViewLifeCycleAddSubviewViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIViewControllerViewLifeCycleAddSubviewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIViewControllerViewLifeCycleAddSubviewViewController alloc();

    @Selector("init")
    public native UIViewControllerViewLifeCycleAddSubviewViewController init();

    SubviewViewController subviewController;

    public static volatile boolean testViewLifeCycle_addSubview1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.whiteColor());
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        test();
    }

    public void test() {
        subviewController = SubviewViewController.alloc().init();
        view().addSubview(subviewController.view());
        performSelectorWithObjectAfterDelay(new SEL("removeSubviewController"), null, 2);
    }

    @Selector("removeSubviewController")
    public void removeSubviewController() {
        subviewController.view().removeFromSuperview();
        performSelectorWithObjectAfterDelay(new SEL("checkCounts"), null, 1);
    }

    @Selector("checkCounts")
    public void checkCounts() {
        System.out.println("CheckCounts: " + subviewController.loadViewCount
                + " " + subviewController.viewDidLoadCount
                + " " + subviewController.viewWillAppearCount
                + " " + subviewController.viewDidAppearCount
                + " " + subviewController.viewWillDisappearCount
                + " " + subviewController.viewDidDisappearCount);
        testViewLifeCycle_addSubview1 = (subviewController.loadViewCount == 1
                && subviewController.viewDidLoadCount == 1
                && subviewController.viewWillAppearCount == 1
                && subviewController.viewDidAppearCount == 1
                && subviewController.viewWillDisappearCount == 1
                && subviewController.viewDidDisappearCount == 1
        );
    }

}
