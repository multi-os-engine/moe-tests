package org.moe.xosrt.binding.test.uikit.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.controllers.UIPopoverControllerViewController;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UILabel;
import ios.uikit.UIPopoverController;
import ios.uikit.UIScreen;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;
import ios.uikit.enums.UIPopoverArrowDirection;

public class UIPopoverDetailViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIPopoverDetailViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIPopoverDetailViewController alloc();

    @Selector("init")
    public native UIPopoverDetailViewController init();

    public UIPopoverController popoverController = null;
    UIButton button;

    public static volatile boolean testInitWithContentViewController1 = false;
    public static volatile boolean testSetPopoverContentSize1 = false;
    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testPopoverVisible1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIView newView = UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds());
        newView.setBackgroundColor(UIColor.redColor());

        button = UIButton.alloc().initWithFrame(CoreGraphics.CGRectMake(50, 100, 200, 44));
        button.setTitleForState("Open Popover", UIControlState.Normal);

        button.addTargetActionForControlEvents(this, new SEL("openPopover"), UIControlEvents.TouchDown);

        UILabel label = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(300, 200, 200, 30));
        label.setText("Color");
        label.setTag(1);

        newView.addSubview(button);
        newView.addSubview(label);

        setView(newView);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        button.sendActionsForControlEvents(UIControlEvents.TouchDown);
    }

    @Selector("openPopover")
    public void openPopover() {
        if (popoverController == null) {
            UIPopoverControllerViewController colors = UIPopoverControllerViewController.alloc().init();
            colors.detailViewController = this;
            popoverController = UIPopoverController.alloc().initWithContentViewController(colors);
            testInitWithContentViewController1 = (popoverController.contentViewController() == colors);

            popoverController.setPopoverContentSize(CoreGraphics.CGSizeMake(300, 300));
            testSetPopoverContentSize1 = (popoverController.popoverContentSize().width() == 300
                    && popoverController.popoverContentSize().height() == 300);

            popoverController.setDelegate(this);
            testDelegate1 = (popoverController.delegate() != null);

            testPopoverVisible1 = (!popoverController.isPopoverVisible());

            //colors.release();
        }
        popoverController.presentPopoverFromRectInViewPermittedArrowDirectionsAnimated(
                button.frame(), view(), UIPopoverArrowDirection.Up, true);
    }
}
