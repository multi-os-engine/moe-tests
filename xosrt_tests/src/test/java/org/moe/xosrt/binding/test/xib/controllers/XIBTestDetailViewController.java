package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIInterfaceOrientation;
import ios.uikit.enums.UIUserInterfaceIdiom;
import ios.uikit.protocol.UISplitViewControllerDelegate;

public class XIBTestDetailViewController extends UIViewController implements UISplitViewControllerDelegate {

    static {
        NatJ.register();
    }

    protected XIBTestDetailViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestDetailViewController alloc();

    @Selector("init")
    public native XIBTestDetailViewController init();

    NSObject detailItem = null;
    UILabel detailDescriptionLabel = null;
    UIPopoverController masterPopoverController = null;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "detailDescriptionLabel":
                detailDescriptionLabel = (UILabel)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "detailDescriptionLabel":
                return detailDescriptionLabel;
            default:
                return super.valueForKey(key);
        }
    }

    @Selector("setDetailItem:")
    public void setDetailItem(NSObject newDetailItem) {
        if (detailItem != newDetailItem) {
            detailItem = newDetailItem;
            // Update the view.
            configureView();
        }

        if (masterPopoverController != null) {
            masterPopoverController.dismissPopoverAnimated(true);
        }
    }

    public void configureView() {
        // Update the user interface for the detail item. 
        if (detailItem != null) {
            detailDescriptionLabel.setText(detailItem.description());
        }
    }

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        // Do any additional setup after loading the view, typically from a nib. self.configureView();
    }

    public void viewDidUnload() {
        super.viewDidUnload();
        // Release any retained subviews of the main view. detailDescriptionLabel = nil;
    }

    @Selector("shouldAutorotateToInterfaceOrientation:")
    @Override
    public boolean shouldAutorotateToInterfaceOrientation(long interfaceOrientation) {
        if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone){
            return (interfaceOrientation != UIInterfaceOrientation.PortraitUpsideDown);
        }
        return true;
    }

    @Selector("initWithNibName:bundle:")
    @Override
    public UIViewController initWithNibNameBundle(String nibNameOrNil, NSBundle nibBundleOrNil) {
        super.initWithNibNameBundle(nibNameOrNil, nibBundleOrNil);
        setTitle("Detail");
        return this;
    }

    @Override
    public UIViewController primaryViewControllerForCollapsingSplitViewController(UISplitViewController uiSplitViewController) {
        return null;
    }

    @Override
    public UIViewController primaryViewControllerForExpandingSplitViewController(UISplitViewController uiSplitViewController) {
        return null;
    }

    @Override
    public boolean splitViewControllerCollapseSecondaryViewControllerOntoPrimaryViewController(UISplitViewController uiSplitViewController, UIViewController uiViewController, UIViewController uiViewController1) {
        return false;
    }

    @Override
    public void splitViewControllerPopoverControllerWillPresentViewController(UISplitViewController uiSplitViewController, UIPopoverController uiPopoverController, UIViewController uiViewController) {

    }

    @Override
    public UIViewController splitViewControllerSeparateSecondaryViewControllerFromPrimaryViewController(UISplitViewController uiSplitViewController, UIViewController uiViewController) {
        return null;
    }

    @Override
    public boolean splitViewControllerShouldHideViewControllerInOrientation(UISplitViewController uiSplitViewController, UIViewController uiViewController, long l) {
        return false;
    }

    @Override
    public boolean splitViewControllerShowDetailViewControllerSender(UISplitViewController uiSplitViewController, UIViewController uiViewController, Object o) {
        return false;
    }

    @Override
    public boolean splitViewControllerShowViewControllerSender(UISplitViewController uiSplitViewController, UIViewController uiViewController, Object o) {
        return false;
    }

    @Override
    public void splitViewControllerWillChangeToDisplayMode(UISplitViewController uiSplitViewController, long l) {

    }

    @Selector("splitViewController:willHideViewController:withBarButtonItem:forPopoverController:")
    @Override
    public void splitViewControllerWillHideViewControllerWithBarButtonItemForPopoverController(
            UISplitViewController splitController, UIViewController viewController, UIBarButtonItem barButtonItem, UIPopoverController popoverController) {
        barButtonItem.setTitle("Master");
        navigationItem().setLeftBarButtonItemAnimated(barButtonItem, true);
        masterPopoverController = popoverController;
    }

    @Selector("splitViewController:willShowViewController:invalidatingBarButtonItem:")
    @Override
    public void splitViewControllerWillShowViewControllerInvalidatingBarButtonItem(
            UISplitViewController splitController, UIViewController viewController, UIBarButtonItem barButtonItem) {
        // Called when the view is shown again in the split view, invalidating the button and popover controller.
        navigationItem().setLeftBarButtonItemAnimated(null, true);
        masterPopoverController = null;
    }

    @Override
    public long splitViewControllerPreferredInterfaceOrientationForPresentation(UISplitViewController uiSplitViewController) {
        return 0;
    }

    @Override
    public long splitViewControllerSupportedInterfaceOrientations(UISplitViewController uiSplitViewController) {
        return 0;
    }

    @Override
    public long targetDisplayModeForActionInSplitViewController(UISplitViewController uiSplitViewController) {
        return 0;
    }

}
