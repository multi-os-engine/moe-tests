package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITextAlignment;
import ios.uikit.protocol.UIPickerViewDataSource;
import ios.uikit.protocol.UIPickerViewDelegate;

public class UIPickerViewViewController extends UIViewController implements UIPickerViewDelegate, UIPickerViewDataSource {

    static {
        NatJ.register();
    }

    protected UIPickerViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIPickerViewViewController alloc();

    @Selector("init")
    public native UIPickerViewViewController init();

    UILabel label;
    UILabel label2;
    NSMutableArray source;
    NSMutableArray source2;
    UIPickerView pickerView;

    public static volatile boolean testNumberOfComponents1 = false;
    public static volatile boolean testNumberOfRowsInComponent1 = false;
    public static volatile boolean testRowSizeForComponent1 = false;
    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testDataSource1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        UIScreen screenObject = UIScreen.mainScreen();
        setView(UIView.alloc().initWithFrame(screenObject.bounds()));
        view().setBackgroundColor(UIColor.grayColor());

        label = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 10, 100, 50));
        label.setTextAlignment(UITextAlignment.Center);
        label2 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(120, 10, 100, 50));
        label2.setTextAlignment(UITextAlignment.Center);

        source = NSMutableArray.alloc().init();
        source.addObject(NSString.stringWithString("Rojo"));
        source.addObject(NSString.stringWithString("Verde"));
        source.addObject(NSString.stringWithString("Azul"));
        source.addObject(NSString.stringWithString("Amarillo"));
        source.addObject(NSString.stringWithString("Rosado"));
        source.addObject(NSString.stringWithString("Blanco"));

        source2 = NSMutableArray.alloc().init();
        source2.addObject(NSString.stringWithString("primero"));
        source2.addObject(NSString.stringWithString("segundo"));
        source2.addObject(NSString.stringWithString("tercero"));
        source2.addObject(NSString.stringWithString("cuarto"));
        source2.addObject(NSString.stringWithString("quinto"));
        source2.addObject(NSString.stringWithString("sexto"));


        CGRect newFrame = CoreGraphics.CGRectMake(10, 100, 300, 300);
        pickerView = UIPickerView.alloc().initWithFrame(newFrame);
        pickerView.setDelegate(this);
        pickerView.setDataSource(this);

        view().addSubview(pickerView);
        view().addSubview(label);
        view().addSubview(label2);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testMethod();
    }

    @Selector("numberOfComponentsInPickerView:")
    @Override
    public long numberOfComponentsInPickerView(UIPickerView var1) {
        return 2;
    }

    @Selector("pickerView:numberOfRowsInComponent:")
    @Override
    public long pickerViewNumberOfRowsInComponent(UIPickerView var1, long var2) {
        return source.count();
    }

    @Selector("pickerView:titleForRow:forComponent:")
    @Override
    public String pickerViewTitleForRowForComponent(UIPickerView pickerView, long row, long component) {
        if (component == 0) {
            return source.objectAtIndex(row).toString();
        }
        else {
            return source2.objectAtIndex(row).toString();
        }
    }

    @Override
    public UIView pickerViewViewForRowForComponentReusingView(UIPickerView uiPickerView, @NInt long l, @NInt long l1, UIView uiView) {
        return null;
    }

    @Override
    public double pickerViewWidthForComponent(UIPickerView uiPickerView, @NInt long l) {
        return 0;
    }

    @Override
    public NSAttributedString pickerViewAttributedTitleForRowForComponent(UIPickerView uiPickerView, @NInt long l, @NInt long l1) {
        return null;
    }

    @Selector("pickerView:didSelectRow:inComponent:")
    @Override
    public void pickerViewDidSelectRowInComponent(UIPickerView pickerView, long row, long component) {
        if (component == 0) {
            label.setText((String) source.objectAtIndex(row));
        }
        else {
            label2.setText((String) source2.objectAtIndex(row));
        }
    }

    @Override
    public double pickerViewRowHeightForComponent(UIPickerView uiPickerView, @NInt long l) {
        return 0;
    }

    public void testMethod() {

        testNumberOfComponents1 = (pickerView.numberOfComponents() == 2);

        testNumberOfRowsInComponent1 = (pickerView.numberOfRowsInComponent(0) == source.count());

        CGSize size = pickerView.rowSizeForComponent(0);
        System.out.println("testRowSizeForComponent1. size.width() = " + size.width() + ", size.height() = " + size.height());
        testRowSizeForComponent1 = (size.width() > 0 && size.height() > 0);

        testDelegate1 = (pickerView.delegate() == this);

        testDataSource1 = (pickerView.dataSource() == this);

        pickerView.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = (!pickerView.isUserInteractionEnabled());
    }

}
