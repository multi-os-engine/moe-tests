package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.protocol.UIPickerViewDataSource;
import ios.uikit.protocol.UIPickerViewDelegate;

public class XIBTestPickerViewViewController extends UIViewController implements UIPickerViewDataSource, UIPickerViewDelegate {

    static {
        NatJ.register();
    }

    protected XIBTestPickerViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestPickerViewViewController alloc();

    @Selector("init")
    public native XIBTestPickerViewViewController init();

    UIPickerView pickerView;
    NSMutableArray arrayColors;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "pickerView":
                pickerView = (UIPickerView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "pickerView":
                return pickerView;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testDidSelectRow1 = false;

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        arrayColors = NSMutableArray.alloc().init();
        arrayColors.addObject(NSString.stringWithString("Red"));
        arrayColors.addObject(NSString.stringWithString("Orange"));
        arrayColors.addObject(NSString.stringWithString("Yellow"));
        arrayColors.addObject(NSString.stringWithString("Green"));
        arrayColors.addObject(NSString.stringWithString("Blue"));
        arrayColors.addObject(NSString.stringWithString("Indigo"));
        arrayColors.addObject(NSString.stringWithString("Violet"));
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrame1 =  (pickerView.frame().origin().x() == 0 && pickerView.frame().origin().y() == 264
                && pickerView.frame().size().width() == 320 && pickerView.frame().size().height() == 216);

        testAlpha1 = (pickerView.alpha() == 0.5);
        pickerView.selectRowInComponentAnimated(1, 0, true);
    }

    public void dealloc() {
        //arrayColors.release();
        super.dealloc();
    }

    @Selector("numberOfComponentsInPickerView:")
    @Override
    public long numberOfComponentsInPickerView(UIPickerView thePickerView) {
        System.out.println("numberOfComponentsInPickerView");
        return 1;
    }

    @Selector("pickerView:numberOfRowsInComponent:")
    @Override
    public long pickerViewNumberOfRowsInComponent(UIPickerView var1, long var2) {
        System.out.println("pickerViewNumberOfRowsInComponent: " + arrayColors.count());
        return arrayColors.count();
    }

    @Selector("pickerView:titleForRow:forComponent:")
    @Override
    public String pickerViewTitleForRowForComponent(UIPickerView thePickerView, long row, long component) {
        System.out.println("Title for row " + row + " is " + (String)arrayColors.objectAtIndex(row));
        return (String)arrayColors.objectAtIndex(row);
    }

    @Override
    public UIView pickerViewViewForRowForComponentReusingView(UIPickerView uiPickerView, long row, long l1, UIView uiView) {
        return null;
    }

    @Selector("pickerView:widthForComponent:")
    @Override
    public double pickerViewWidthForComponent(UIPickerView uiPickerView, long l) {
        return 0;
    }

    @Selector("pickerView:attributedTitleForRow:forComponent:")
    @Override
    public NSAttributedString pickerViewAttributedTitleForRowForComponent(UIPickerView uiPickerView, long l, long l1) {
        System.out.println("pickerViewAttributedTitleForRowForComponent");
        return null;
    }

    @Selector("pickerView:didSelectRow:inComponent:")
    @Override
    public void pickerViewDidSelectRowInComponent(UIPickerView thePickerView, long row, long component) {
        testDidSelectRow1 = true;
    }

    @Selector("pickerView:rowHeightForComponent:")
    @Override
    public double pickerViewRowHeightForComponent(UIPickerView uiPickerView, long l) {
        System.out.println("pickerViewRowHeightForComponent");
        return 20;
    }

}
