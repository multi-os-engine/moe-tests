package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIInterfaceOrientation;
import ios.uikit.enums.UIUserInterfaceIdiom;

public class XIBTestTabbedAppFirstViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTabbedAppFirstViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTabbedAppFirstViewController alloc();

    @Selector("init")
    public native XIBTestTabbedAppFirstViewController init();


    public static volatile boolean testTabbedApplication441Test1 = false;

    @Selector("initWithNibName:bundle:")
    @Override
    public UIViewController initWithNibNameBundle(String nibNameOrNil, NSBundle nibBundleOrNil) {
        super.initWithNibNameBundle(nibNameOrNil, nibBundleOrNil);
        setTitle("First");
        tabBarItem().setImage(UIImage.imageNamed("first"));
        return this;
    }

    public void viewDidLoad() {
        super.viewDidLoad();
        // Do any additional setup after loading the view, typically from a nib.
        testTabbedApplication441Test1 = true;
    }

    public void viewDidUnload() {
        super.viewDidUnload();
    }

    @Selector("shouldAutorotateToInterfaceOrientation:")
    @Override
    public boolean shouldAutorotateToInterfaceOrientation(long interfaceOrientation) {
        if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {
            return (interfaceOrientation != UIInterfaceOrientation.PortraitUpsideDown);
        } else {
            return true;
        }
    }

}
