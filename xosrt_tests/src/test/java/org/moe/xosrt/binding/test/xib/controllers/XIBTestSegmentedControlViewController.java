package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.IBAction;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestSegmentedControlViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestSegmentedControlViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestSegmentedControlViewController alloc();

    @Selector("init")
    public native XIBTestSegmentedControlViewController init();

    UISegmentedControl segmentedControl;
    UILabel selectedSegmentText;
    int selectedUnit;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "segmentedControl":
                segmentedControl = (UISegmentedControl)value;
                break;
            case "selectedSegmentText":
                selectedSegmentText = (UILabel)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "segmentedControl":
                return segmentedControl;
            case "selectedSegmentText":
                return selectedSegmentText;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testTitleForState1 = false;

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        testMethod();
        segmentedControl.setSelectedSegmentIndex(2);
        selectedUnit = (int)segmentedControl.selectedSegmentIndex();
        updateLabel();

    }

    @IBAction
    @Selector("segmentedControlValueChanged")
    public void segmentedControlValueChanged() {
        selectedUnit = (int)segmentedControl.selectedSegmentIndex();
        updateLabel();
    }

    public void updateLabel() {
        switch (selectedUnit) {
            case 0:
                selectedSegmentText.setText("You have selected the first segment");
                break;
            case 1:
                selectedSegmentText.setText("You have selected the second segment");
                break;
            case 2:
                selectedSegmentText.setText("You have selected the third segment");
                break;
            case 3:
                selectedSegmentText.setText("You have selected the forth segment");
                break;
            default:
                break;
        }
    }

    public void didReceiveMemoryWarning() {
        // Releases the view if it doesn't have a superview.
        super.didReceiveMemoryWarning();
    }

    public void dealloc() {
        super.dealloc();
        //segmentedControl.release();
        //selectedSegmentText.release();
    }

    public void testMethod() {
        testFrame1 =  (segmentedControl.frame().origin().x() == 0 && segmentedControl.frame().origin().y() == 145
                && segmentedControl.frame().size().width() == 320 && segmentedControl.frame().size().height() == 30);

        testTitleForState1 = (segmentedControl.titleForSegmentAtIndex(1).equals("Second"));
    }

}
