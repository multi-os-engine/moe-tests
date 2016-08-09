package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;

public class UIControlViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIControlViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIControlViewController alloc();

    @Selector("init")
    public native UIControlViewController init();

    boolean  touchDownFlag = false;
    boolean  touchDragInsideFlag = false;
    boolean  touchUpInsideFlag = false;
    boolean  touchCancelFlag = false;
    boolean  editingDidBeginFlag = false;
    boolean  editingDidEndFlag = false;
    boolean  editingDidEndOnExitFlag = false;
    
    boolean  touchDownRemoveFlag = true;
    boolean  touchDragInsideRemoveFlag = true;
    boolean  touchUpInsideRemoveFlag = true;
    boolean  touchCancelRemoveFlag = true;
    boolean  editingDidBeginRemoveFlag = true;
    boolean  editingDidEndRemoveFlag = true;
    boolean  editingDidEndOnExitRemoveFlag = true;
    
    UIControl control1;
    UIControl control2;

    public static volatile boolean testAddTarget_action_forControlEvents1 = false;
    public static volatile boolean testSendActionsForControlEvents1 = false;
    public static volatile boolean testRemoveTarget_action_forControlEvents1 = false;
    public static volatile boolean testEnabled1 = false;

    @Selector("touchDown")
    public void touchDown() {
        touchDownFlag = true;
    }

    @Selector("touchDragInside")
    public void touchDragInside() {
        touchDragInsideFlag = true;
    }

    @Selector("touchUpInside")
    public void touchUpInside() {
        touchUpInsideFlag = true;
    }

    @Selector("touchCancel")
    public void touchCancel() {
        touchCancelFlag = true;
    }

    @Selector("editingDidBegin")
    public void editingDidBegin() {
        editingDidBeginFlag = true;
    }

    @Selector("editingDidEnd")
    public void editingDidEnd() {
        editingDidEndFlag = true;
    }

    @Selector("editingDidEndOnExit")
    public void editingDidEndOnExit() {
        editingDidEndOnExitFlag = true;
    }

    @Selector("touchDownRemove")
    public void touchDownRemove() {
        touchDownRemoveFlag = false;
    }

    @Selector("touchDragInsideRemove")
    public void touchDragInsideRemove() {
        touchDragInsideRemoveFlag = false;
    }

    @Selector("touchUpInsideRemove")
    public void touchUpInsideRemove() {
        touchUpInsideRemoveFlag = false;
    }

    @Selector("touchCancelRemove")
    public void touchCancelRemove() {
        touchCancelRemoveFlag = false;
    }

    @Selector("editingDidBeginRemove")
    public void editingDidBeginRemove() {
        editingDidBeginRemoveFlag = false;
    }

    @Selector("editingDidEndRemove")
    public void editingDidEndRemove() {
        editingDidEndRemoveFlag = false;
    }

    @Selector("editingDidEndOnExitRemove")
    public void editingDidEndOnExitRemove() {
        editingDidEndOnExitRemoveFlag = false;
    }

    public void testProperties() {
        UIControl aControl1 = UIControl.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 10, 120, 30));
        UIControl aControl2 = UIControl.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 10, 120, 30));
        UIControl aControl3 = UIControl.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 10, 120, 30));
        UIControl aControl4 = UIControl.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 10, 120, 30));
        aControl1.setEnabled(true);
        aControl2.setEnabled(true);
        aControl3.setEnabled(false);
        aControl4.setEnabled(false);
        testEnabled1 = (aControl1.isEnabled() && aControl2.isEnabled()
                && !aControl3.isEnabled() && !aControl4.isEnabled()) ;

    }

    @Selector("loadView")
    @Override
    public void loadView() {
        control1 = (UIControl)UIControl.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 250, 40));
        control1.setTag(1);
        control1.setBackgroundColor(UIColor.redColor());

        control2 = (UIControl)UIControl.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 80, 250, 40));
        control2.setTag(2);
        control2.setBackgroundColor(UIColor.redColor());

        try {
            control1.addTargetActionForControlEvents(this, new SEL("touchDown"),
                    UIControlEvents.TouchDown);
            control1.addTargetActionForControlEvents(this, new SEL("touchDragInside"),
                    UIControlEvents.TouchDragInside);
            control1.addTargetActionForControlEvents(this, new SEL("touchUpInside"),
                    UIControlEvents.TouchUpInside);
            control1.addTargetActionForControlEvents(this, new SEL("touchCancel"),
                    UIControlEvents.TouchCancel);
            control1.addTargetActionForControlEvents(this, new SEL("editingDidBegin"),
                    UIControlEvents.EditingDidBegin);
            control1.addTargetActionForControlEvents(this, new SEL("editingDidEnd"),
                    UIControlEvents.EditingDidEnd);
            control1.addTargetActionForControlEvents(this, new SEL("editingDidEndOnExit"),
                    UIControlEvents.EditingDidEndOnExit);

            control2.addTargetActionForControlEvents(this, new SEL("touchDownRemove"),
                    UIControlEvents.TouchDown);
            control2.addTargetActionForControlEvents(this, new SEL("touchDragInsideRemove"),
                    UIControlEvents.TouchDragInside);
            control2.addTargetActionForControlEvents(this, new SEL("touchUpInsideRemove"),
                    UIControlEvents.TouchUpInside);
            control2.addTargetActionForControlEvents(this, new SEL("touchCancelRemove"),
                    UIControlEvents.TouchCancel);
            control2.addTargetActionForControlEvents(this, new SEL("editingDidBeginRemove"),
                    UIControlEvents.EditingDidBegin);
            control2.addTargetActionForControlEvents(this, new SEL("editingDidEndRemove"),
                    UIControlEvents.EditingDidEnd);
            control2.addTargetActionForControlEvents(this, new SEL("editingDidEndOnExitRemove"),
                    UIControlEvents.EditingDidEndOnExit);
        } catch(Exception e) {
            e.printStackTrace();
        }

        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().addSubview(control1);
        view().addSubview(control2);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        control1.sendActionsForControlEvents(UIControlEvents.TouchDown);
        control1.sendActionsForControlEvents(UIControlEvents.TouchDragInside);
        control1.sendActionsForControlEvents(UIControlEvents.TouchUpInside);
        control1.sendActionsForControlEvents(UIControlEvents.TouchCancel);
        control1.sendActionsForControlEvents(UIControlEvents.EditingDidBegin);
        control1.sendActionsForControlEvents(UIControlEvents.EditingDidEnd);
        control1.sendActionsForControlEvents(UIControlEvents.EditingDidEndOnExit);

        try {
            control2.removeTargetActionForControlEvents(this, new SEL("touchDownRemove"),
                    UIControlEvents.TouchDown);
            control2.removeTargetActionForControlEvents(this, new SEL("touchDragInsideRemove"),
                    UIControlEvents.TouchDragInside);
            control2.removeTargetActionForControlEvents(this, new SEL("touchUpInsideRemove"),
                    UIControlEvents.TouchUpInside);
            control2.removeTargetActionForControlEvents(this, new SEL("touchCancelRemove"),
                    UIControlEvents.TouchCancel);
            control2.removeTargetActionForControlEvents(this, new SEL("editingDidBeginRemove"),
                    UIControlEvents.EditingDidBegin);
            control2.removeTargetActionForControlEvents(this, new SEL("editingDidEndRemove"),
                    UIControlEvents.EditingDidEnd);
            control2.removeTargetActionForControlEvents(this, new SEL("editingDidEndOnExitRemove"),
                    UIControlEvents.EditingDidEndOnExit);
        } catch (Exception e) {
            e.printStackTrace();
        }

        control2.sendActionsForControlEvents(UIControlEvents.TouchDown);
        control2.sendActionsForControlEvents(UIControlEvents.TouchDragInside);
        control2.sendActionsForControlEvents(UIControlEvents.TouchUpInside);
        control2.sendActionsForControlEvents(UIControlEvents.TouchCancel);
        control2.sendActionsForControlEvents(UIControlEvents.EditingDidBegin);
        control2.sendActionsForControlEvents(UIControlEvents.EditingDidEnd);
        control2.sendActionsForControlEvents(UIControlEvents.EditingDidEndOnExit);

        testMethod();
        testProperties();
    }

    public void testMethod() {
        testAddTarget_action_forControlEvents1 = touchDownFlag && touchDragInsideFlag && touchUpInsideFlag && touchCancelFlag
                && editingDidBeginFlag && editingDidEndFlag && editingDidEndOnExitFlag;
        testSendActionsForControlEvents1 = touchDownFlag && touchDragInsideFlag && touchUpInsideFlag && touchCancelFlag
                && editingDidBeginFlag && editingDidEndFlag && editingDidEndOnExitFlag;
        testRemoveTarget_action_forControlEvents1 = touchDownRemoveFlag && touchDragInsideRemoveFlag && touchUpInsideRemoveFlag
                && touchCancelRemoveFlag && editingDidBeginRemoveFlag && editingDidEndRemoveFlag
                && editingDidEndOnExitRemoveFlag;
    }
}
