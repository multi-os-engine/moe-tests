package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.foundation.struct.NSRange;
import ios.uikit.*;
import ios.uikit.enums.NSTextAlignment;
import ios.uikit.enums.UIKeyboardType;
import ios.uikit.enums.UITextAlignment;
import ios.uikit.enums.UITextBorderStyle;
import ios.uikit.protocol.UITextFieldDelegate;

public class UITextFieldViewController extends UIViewController implements UITextFieldDelegate {

	private static final String HELVETICA = ".HelveticaNeueInterface-Regular";
	
    static {
        NatJ.register();
    }

    protected UITextFieldViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITextFieldViewController alloc();

    @Selector("init")
    public native UITextFieldViewController init();

    
    UITextField textField1;
    UITextField textField2;
    UITextField textField3;
    NSString text3;
    boolean  textFieldShouldReturnOK;

    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testSetDelegate1 = false;
    public static volatile boolean testText1 = false;
    public static volatile boolean testSetText1 = false;
    public static volatile boolean testFont2 = false;
    public static volatile boolean testSetFont1 = false;
    public static volatile boolean testSetFont2 = false;
    public static volatile boolean testTextColor1 = false;
    public static volatile boolean testSetTextColor1 = false;
    public static volatile boolean testTextAlignment1 = false;
    public static volatile boolean testSetTextAlignment1 = false;
    public static volatile boolean testSetTextAlignment2 = false;
    public static volatile boolean testPlaceholder1 = false;
    public static volatile boolean testSetPlaceholder1 = false;
    public static volatile boolean testBorderStyle1 = false;
    public static volatile boolean testSetBorderStyle1 = false;
    public static volatile boolean testKeyboardType1 = false;
    public static volatile boolean testSetKeyboardType1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;
    public static volatile boolean testTextFieldShouldReturn1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        //view().release();
        view().setBackgroundColor(UIColor.magentaColor());
        textField1 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 50, 300, 50));
        textField1.setTag(1);
        textField1.setBackgroundColor(UIColor.whiteColor());

        textField2 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 120, 100, 50));
        textField2.setTag(2);
        textField2.setDelegate(this);

        textField2.setBackgroundColor(UIColor.yellowColor());

        textField3 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(30, 200, 200, 20));
        textField3.setTag(3);

        textField3.setBackgroundColor(UIColor.lightGrayColor());

        textFieldShouldReturnOK = false;

        view().addSubview(textField1);
        view().addSubview(textField2);
        view().addSubview(textField3);

        testDelegate1 = (textField1.delegate() == null && textField2.delegate() == this && textField3.delegate() == null);

        textField1.setDelegate(this);
        textField2.setDelegate(null);
        textField3.setDelegate(this);
        testSetDelegate1 = (textField1.delegate() == this && textField2.delegate() == null && textField3.delegate() == this);
        textField2.setDelegate(this);

        String newText = "text1";
        textField1.setText(newText);

        textField2.setText("text2");

        text3 = NSString.stringWithString("text3");
        textField3.setText(text3.toString());
        testText1 = (textField1.text().equals("text1") && textField2.text().equals("text2")
                && textField3.text().equals(text3.toString()));

        text3 = NSString.stringWithString("text3-2");
        textField1.setText("text1-2");
        textField2.setText("text2-2");
        textField3.setText(text3.toString());
        testSetText1 = (textField1.text().equals("text1-2") && textField2.text().equals("text2-2")
                && textField3.text().equals(text3.toString()));

        String fontname = textField1.font().fontName();
        String family = textField1.font().familyName();
        testFont2 = (textField1.font().fontName().equals(HELVETICA)
                && textField1.font().familyName().equals(".Helvetica Neue Interface")
                && textField2.font().fontName().equals(HELVETICA)
                && textField2.font().familyName().equals(".Helvetica Neue Interface")
                && textField3.font().fontName().equals(HELVETICA)
                && textField3.font().familyName().equals(".Helvetica Neue Interface"));

        double fontSize1 = 12.0;
        double fontSize2 = 13.0;
        double fontSize3 = 14.0;
        UIFont font1 = UIFont.fontWithNameSize("Helvetica-Oblique", fontSize1);
        UIFont font2 = UIFont.fontWithNameSize("Courier-BoldOblique", fontSize2);
        UIFont font3 = UIFont.fontWithNameSize("Verdana-Italic", fontSize3);
        textField1.setFont(font1);
        textField2.setFont(font2);
        textField3.setFont(font3);
        fontname = textField1.font().fontName();
        family = textField1.font().familyName();
        testSetFont1 = (textField1.font().fontName().equals("Helvetica-Oblique")
                && textField1.font().familyName().equals("Helvetica")
                && textField1.font().pointSize() == fontSize1
                && textField2.font().fontName().equals("Courier-BoldOblique")
                && textField2.font().familyName().equals("Courier")
                && textField2.font().pointSize() == fontSize2
                && textField3.font().fontName().equals("Verdana-Italic")
                && textField3.font().familyName().equals("Verdana")
                && textField3.font().pointSize() == fontSize3);

        textField1.setFont(UIFont.fontWithNameSize("Helvetica-Oblique", fontSize1));
        textField2.setFont(UIFont.fontWithNameSize("Courier-BoldOblique", fontSize2));
        textField3.setFont(UIFont.fontWithNameSize("Verdana-Italic", fontSize3));
        testSetFont2 = (textField1.font().fontName().equals("Helvetica-Oblique")
                && textField1.font().familyName().equals("Helvetica")
                && textField1.font().pointSize() == fontSize1
                && textField2.font().fontName().equals("Courier-BoldOblique")
                && textField2.font().familyName().equals("Courier")
                && textField2.font().pointSize() == fontSize2
                && textField3.font().fontName().equals("Verdana-Italic")
                && textField3.font().familyName().equals("Verdana")
                && textField3.font().pointSize() == fontSize3);

        UIColor textColor1 = UIColor.greenColor();
        UIColor textColor2 = UIColor.blueColor();
        UIColor textColor3 = UIColor.darkGrayColor();
        textField1.setTextColor(textColor1);
        textField2.setTextColor(textColor2);
        textField3.setTextColor(textColor3);
        testTextColor1 = (textField1.textColor() == textColor1 && textField2.textColor() == textColor2
                && textField3.textColor() == textColor3);

        textColor1 = UIColor.lightGrayColor();
        textColor2 = UIColor.blackColor();
        textColor3 = UIColor.whiteColor();
        textField1.setTextColor(textColor1);
        textField2.setTextColor(textColor2);
        textField3.setTextColor(textColor3);
        testSetTextColor1 = (textField1.textColor() == textColor1 && textField2.textColor() == textColor2
                && textField3.textColor() == textColor3);

        testTextAlignment1 = (textField1.textAlignment() == UITextAlignment.Left
                && textField2.textAlignment() == UITextAlignment.Left
                && textField3.textAlignment() == UITextAlignment.Left);

        textField1.setTextAlignment(UITextAlignment.Right);
        textField2.setTextAlignment(UITextAlignment.Center);
        textField3.setTextAlignment(UITextAlignment.Left);
        testSetTextAlignment1 = (textField1.textAlignment() == UITextAlignment.Right
                && textField2.textAlignment() == UITextAlignment.Center
                && textField3.textAlignment() == UITextAlignment.Left);


        UITextField textFieldNSTextAlignment0 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 480, 300, 40));
        UITextField textFieldNSTextAlignment1 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 530, 300, 40));
        UITextField textFieldNSTextAlignment2 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 590, 300, 40));
        UITextField textFieldNSTextAlignment3 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 480, 300, 40));
        UITextField textFieldNSTextAlignment4 = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 530, 300, 40));
        UITextField textFieldNSTextAlignmentDefault = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 590, 300, 40));
        textFieldNSTextAlignment0.setText("NSTextAlignmentLeft");
        textFieldNSTextAlignment1.setText("NSTextAlignmentCenter");
        textFieldNSTextAlignment2.setText("NSTextAlignmentRight");
        textFieldNSTextAlignment3.setText("NSTextAlignmentJustified");
        textFieldNSTextAlignment4.setText("NSTextAlignmentNatural");
        textFieldNSTextAlignmentDefault.setText("Default");
        textFieldNSTextAlignment0.setTextAlignment(NSTextAlignment.Left);
        textFieldNSTextAlignment1.setTextAlignment(NSTextAlignment.Center);
        textFieldNSTextAlignment2.setTextAlignment(NSTextAlignment.Right);
        textFieldNSTextAlignment3.setTextAlignment(NSTextAlignment.Justified);
        textFieldNSTextAlignment4.setTextAlignment(NSTextAlignment.Natural);
        textFieldNSTextAlignment0.setBackgroundColor(UIColor.whiteColor());
        textFieldNSTextAlignment1.setBackgroundColor(UIColor.whiteColor());
        textFieldNSTextAlignment2.setBackgroundColor(UIColor.whiteColor());
        textFieldNSTextAlignment3.setBackgroundColor(UIColor.whiteColor());
        textFieldNSTextAlignment4.setBackgroundColor(UIColor.whiteColor());
        textFieldNSTextAlignmentDefault.setBackgroundColor(UIColor.whiteColor());
        view().addSubview(textFieldNSTextAlignment0);
        view().addSubview(textFieldNSTextAlignment1);
        view().addSubview(textFieldNSTextAlignment2);
        view().addSubview(textFieldNSTextAlignment3);
        view().addSubview(textFieldNSTextAlignment4);
        view().addSubview(textFieldNSTextAlignmentDefault);
        testSetTextAlignment2 = (NSTextAlignment.Left == textFieldNSTextAlignment0.textAlignment()
                && NSTextAlignment.Center == textFieldNSTextAlignment1.textAlignment()
                && NSTextAlignment.Right == textFieldNSTextAlignment2.textAlignment()
                && NSTextAlignment.Justified == textFieldNSTextAlignment3.textAlignment()
                && NSTextAlignment.Left == textFieldNSTextAlignment4.textAlignment()
                && NSTextAlignment.Left == textFieldNSTextAlignmentDefault.textAlignment());

        testPlaceholder1 = (textField1.placeholder() == null && textField2.placeholder() == null
                && textField3.placeholder() == null);

        textField1.setPlaceholder("placeholder1");
        textField2.setPlaceholder("placeholder2");
        String placeholder3 = "placeholder3";
        textField3.setPlaceholder(placeholder3);
        testSetPlaceholder1 = (textField1.placeholder().equals("placeholder1")
                && textField2.placeholder().equals("placeholder2")
                && textField3.placeholder().equals(placeholder3));


        testBorderStyle1 = (textField1.borderStyle() == UITextBorderStyle.None
                && textField2.borderStyle() == UITextBorderStyle.None
                && textField3.borderStyle() == UITextBorderStyle.None);

        textField1.setBorderStyle(UITextBorderStyle.Line);
        textField2.setBorderStyle(UITextBorderStyle.Bezel);
        textField3.setBorderStyle(UITextBorderStyle.RoundedRect);
        testSetBorderStyle1 = (textField1.borderStyle() == UITextBorderStyle.Line
                && textField2.borderStyle() == UITextBorderStyle.Bezel
                && textField3.borderStyle() == UITextBorderStyle.RoundedRect);


        testKeyboardType1 = (textField1.keyboardType() == UIKeyboardType.Default
                && textField2.keyboardType() == UIKeyboardType.Default
                && textField3.keyboardType() == UIKeyboardType.Default);

        textField1.setKeyboardType(UIKeyboardType.EmailAddress);
        textField2.setKeyboardType(UIKeyboardType.NumberPad);
        textField3.setKeyboardType(UIKeyboardType.PhonePad);
        testSetKeyboardType1 = (textField1.keyboardType() == UIKeyboardType.EmailAddress
                && textField2.keyboardType() == UIKeyboardType.NumberPad
                && textField3.keyboardType() == UIKeyboardType.PhonePad);

        textField1.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = !textField1.isUserInteractionEnabled();



        //You must tap a Text Field to show the keyboard and push "return" key before 4 seconds to pass "textFieldShouldReturn" check .
        // this.performSelectorWithObjectAfterDelay(new SEL(checkDelegateShouldReturn), null, 3);

    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {

    }

    @Override
    public boolean textFieldShouldChangeCharactersInRangeReplacementString(UITextField uiTextField, NSRange nsRange, String s) {
        return false;
    }

    @Override
    public void textFieldDidBeginEditing(UITextField uiTextField) {

    }

    @Override
    public void textFieldDidEndEditing(UITextField uiTextField) {

    }

    @Override
    public boolean textFieldShouldBeginEditing(UITextField uiTextField) {
        return false;
    }

    @Override
    public boolean textFieldShouldClear(UITextField uiTextField) {
        return false;
    }

    @Override
    public boolean textFieldShouldEndEditing(UITextField uiTextField) {
        return false;
    }

    public boolean textFieldShouldReturn(UITextField textField) {

        textFieldShouldReturnOK = true;

        return true;
    }

    public void checkDelegateShouldReturn() {

        testTextFieldShouldReturn1 = (textFieldShouldReturnOK);

    }
}
