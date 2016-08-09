package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;
import org.moe.xosrt.binding.test.uikit.testhelpers.CustomControl;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UILabel;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UIControlState;

public class UICustomControlsViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UICustomControlsViewController(Pointer peer) {
        super(peer);
    }

    UIButton addRemoveButton;
    CustomControl customControlChangeColor;
    UILabel label;

    public static boolean testAddSubview1 = false;
    public static boolean testAddSubview2 = false;
    public static boolean testAddTargetAction1 = false;
    public static boolean testAddTargetAction2 = false;

    @Selector("alloc")
    public static native UICustomControlsViewController alloc();

    @Selector("init")
    public native UICustomControlsViewController init();

    @Selector("actionButtonTouchUp")
    public void actionButtonTouchUp() {
        if (label.superview() == view()) {
            label.removeFromSuperview();
            addRemoveButton.setTitleForState("Add Label", UIControlState.Normal);
        } else {
            view().addSubview(label);
            addRemoveButton.setTitleForState("Remove Label", UIControlState.Normal);
        }
    }

    @Selector("actionCustomControlChangeColor")
    public void actionCustomControlChangeColor() {
        if (label.backgroundColor() == UIColor.redColor()) {
            label.setBackgroundColor(UIColor.blueColor());
            customControlChangeColor.label.setText("Change Color to red");
        } else {
            label.setBackgroundColor(UIColor.redColor());
            customControlChangeColor.label.setText("Change Color to blue");
        }
    }

    @Selector("loadView")
    @Override
    public void loadView() {
        this.setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.whiteColor());

        label = (UILabel)UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 250, 170, 100));
        label.setBackgroundColor(UIColor.yellowColor());
        label.setText("This is a label");
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testAddSubview();

        performSelectorWithObjectAfterDelay(new SEL("testActionButtonAddRemove"), null, 1);
        performSelectorWithObjectAfterDelay(new SEL("testActionChangeColor"), null, 2);
    }

    public void testAddSubview() {
        addRemoveButton = (UIButton)UIButton.buttonWithType(UIButtonType.Custom);
        addRemoveButton.setFrame(CoreGraphics.CGRectMake(10, 50, 300, 50));
        addRemoveButton.setBackgroundColor(UIColor.lightGrayColor());
        addRemoveButton.setTitleForState("Add Label", UIControlState.Normal);

        view().addSubview(addRemoveButton);
        testAddSubview1 = addRemoveButton.superview() == view();

        customControlChangeColor = (CustomControl)CustomControl.alloc().initWithFrame(
                CoreGraphics.CGRectMake(0, 150, 200, 60));
        customControlChangeColor .setBackgroundColor(UIColor.darkGrayColor());
        view().addSubview(customControlChangeColor);
        testAddSubview2 = customControlChangeColor.superview() == view();
    }

    @Selector("testActionButtonAddRemove")
    public void testActionButtonAddRemove() throws NoSuchMethodException {
        System.out.println("!!! HEY !!!");

        addRemoveButton.addTargetActionForControlEvents(this, new SEL("actionButtonTouchUp"),
                UIControlEvents.TouchUpInside);
        addRemoveButton.sendActionsForControlEvents(UIControlEvents.TouchUpInside);
        
        System.out.println("label.superview() = " + label.superview());
        System.out.println("view() = " + view());
        testAddTargetAction1 = label.superview() == view();
    }

    @Selector("testActionChangeColor")
    public void testActionChangeColor() throws NoSuchMethodException {
        customControlChangeColor.addTargetActionForControlEvents(this, new SEL("actionCustomControlChangeColor"),
                UIControlEvents.TouchDown);
        customControlChangeColor.sendActionsForControlEvents(UIControlEvents.TouchDown);
        testAddTargetAction2 = label.backgroundColor() == UIColor.redColor();
    }
}
