package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.xib.testhelpers.DrawRectTestMainView;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlState;
import ios.uikit.enums.UIInterfaceOrientation;

public class XIBTestDrawRect0ViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestDrawRect0ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestDrawRect0ViewController alloc();

    @Selector("init")
    public native XIBTestDrawRect0ViewController init();

    
    UIButton infoButton;
    XIBTestDrawRectViewController mainViewController;

    public static volatile boolean testDrawRect1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIView newView = UIButton.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 320, 460));
        infoButton = UIButton.alloc().initWithFrame(CoreGraphics.CGRectMake(228, 403, 72, 37));
        infoButton.setTitleForState("Hola", UIControlState.Normal);
        newView.addSubview(infoButton);
        setView(newView);
    }

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {

        XIBTestDrawRectViewController viewController = (XIBTestDrawRectViewController)
                XIBTestDrawRectViewController.alloc().initWithNibNameBundle("XIBTestDrawRectViewController", null);
        mainViewController = viewController;
        //viewController.release();

        view().insertSubviewBelowSubview(mainViewController.view(), infoButton);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        DrawRectTestMainView mainView = (DrawRectTestMainView) mainViewController.view();
        testDrawRect1 =  (mainView.array0.count()  == 1);
    }

    @Selector("shouldAutorotateToInterfaceOrientation:")
    @Override
    public boolean shouldAutorotateToInterfaceOrientation(long interfaceOrientation) {
        // Return YES for supported orientations
        return (interfaceOrientation == UIInterfaceOrientation.Portrait);
    }

}
