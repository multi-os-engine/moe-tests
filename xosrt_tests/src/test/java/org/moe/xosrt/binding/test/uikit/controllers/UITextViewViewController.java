package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.NFloatPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.foundation.struct.NSRange;
import ios.uikit.*;
import ios.uikit.enums.NSTextAlignment;
import ios.uikit.enums.UITextAlignment;
import ios.uikit.protocol.UITextViewDelegate;

public class UITextViewViewController extends UIViewController implements UITextViewDelegate {

    static {
        NatJ.register();
    }

    protected UITextViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITextViewViewController alloc();

    @Selector("init")
    public native UITextViewViewController init();

    UITextView textView1;
    UITextView textView2;

    public static volatile boolean testText1 = false;
    public static volatile boolean testSetText1 = false;
    public static volatile boolean testFont1 = false;
    public static volatile boolean testSetFont1 = false;
    public static volatile boolean testTextColor1 = false;
    public static volatile boolean testSetTextColor1 = false;
    public static volatile boolean testIsEditable1 = false;
    public static volatile boolean testSetEditable1 = false;
    public static volatile boolean testTextAlignment1 = false;
    public static volatile boolean testSetTextAlignment1 = false;
    public static volatile boolean testSetTextAlignment2 = false;
    public static volatile boolean testHasText1 = false;
    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testSetDelegate1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    static String textEditable = "You can edit this text";
    static String textNoEditable = "This text is read only. Cannot be edited.";

    @Selector("loadView")
    @Override
    public void loadView() {
        UIView newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 640));
        textView1 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 40, 300, 200));
        textView1.setDelegate(this);
        textView1.setText(textEditable);

        textView2 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 250, 300, 200));
        textView2.setText(textNoEditable);
        textView2.setEditable(false);
        textView2.setDelegate(this);

        UIColor color1 = UIColor.redColor();
        UIColor color2 = UIColor.blueColor();
        textView1.setTextColor(color1);
        textView2.setTextColor(color2);

        UIFont font1 = UIFont.fontWithNameSize("Verdana-BoldItalic", 11);
        UIFont font2 = UIFont.fontWithNameSize("Courier-Bold", 12);
        textView1.setFont(font1);
        textView2.setFont(font2);

        newView.addSubview(textView1);
        newView.addSubview(textView2);

        setView(newView);
        //newView.release();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testMethods();
    }

    public void dealloc() {
        super.dealloc();
    }

    public void testMethods() {
        testText1 = (textEditable.equals(textView1.text()) && textNoEditable.equals(textView2.text()));

        String textTest1 = "Now uneditable";
        String textTest2 = "Now editable";
        textView1.setText(textTest1);
        textView2.setText(textTest2);
        testSetText1 = (textTest1.equals(textView1.text()) && textTest2.equals(textView2.text()));

        testFont1 = ("Verdana-BoldItalic".equals(textView1.font().fontName())
                && "Verdana".equals(textView1.font().familyName())
                && 11 == textView1.font().pointSize()
                && "Courier-Bold".equals(textView2.font().fontName())
                && "Courier".equals(textView2.font().familyName())
                && 12 == textView2.font().pointSize());

        UIFont font1 = UIFont.fontWithNameSize("Courier-BoldOblique", 13);
        UIFont font2 = UIFont.fontWithNameSize("Helvetica-Oblique", 14);
        textView1.setFont(font1);
        textView2.setFont(font2);
        testSetFont1 = ("Courier-BoldOblique".equals(textView1.font().fontName())
                && "Courier".equals(textView1.font().familyName())
                && 13 == textView1.font().pointSize()
                && "Helvetica-Oblique".equals(textView2.font().fontName())
                && "Helvetica".equals(textView2.font().familyName())
                && 14 == textView2.font().pointSize());

        NFloatPtr red1 = PtrFactory.newNFloatReference();
        NFloatPtr green1 = PtrFactory.newNFloatReference();
        NFloatPtr blue1 = PtrFactory.newNFloatReference();
        NFloatPtr alpha1 = PtrFactory.newNFloatReference();
        NFloatPtr red2 = PtrFactory.newNFloatReference();
        NFloatPtr green2 = PtrFactory.newNFloatReference();
        NFloatPtr blue2 = PtrFactory.newNFloatReference();
        NFloatPtr alpha2 = PtrFactory.newNFloatReference();
        boolean converted1 = textView1.textColor().getRedGreenBlueAlpha(red1, green1, blue1, alpha1);
        boolean converted2 = textView2.textColor().getRedGreenBlueAlpha(red2, green2, blue2, alpha2);
        testTextColor1 = (converted1 && red1.get() == 1.0 && green1.get() == 0.0
                && blue1.get() == 0.0 && alpha1.get() == 1.0
                && converted2 && red2.get() == 0.0 && green2.get() == 0.0
                && blue2.get() == 1.0 && alpha2.get() == 1.0);

        textView1.setTextColor(UIColor.greenColor());
        textView2.setTextColor(UIColor.redColor());
        converted1 = textView1.textColor().getRedGreenBlueAlpha(red1, green1, blue1, alpha1);
        converted2 = textView2.textColor().getRedGreenBlueAlpha(red2, green2, blue2, alpha2);
        testSetTextColor1 = (converted1 && red1.get() == 0.0 && green1.get() == 1.0
                && blue1.get() == 0.0 && alpha1.get() == 1.0
                && converted2 && red2.get() == 1.0 && green2.get() == 0.0
                && blue2.get() == 0.0 && alpha2.get() == 1.0);

        testIsEditable1 = (textView1.isEditable() && !textView2.isEditable());

        textView1.setEditable(false);
        textView2.setEditable(true);
        testSetEditable1 = (!textView1.isEditable() && textView2.isEditable());

        testTextAlignment1 = (textView1.textAlignment() == UITextAlignment.Left
                && textView2.textAlignment() == UITextAlignment.Left);

        textView1.setTextAlignment(UITextAlignment.Right);
        textView2.setTextAlignment(UITextAlignment.Center);
        testSetTextAlignment1 = (textView1.textAlignment() == UITextAlignment.Right
                && textView2.textAlignment() == UITextAlignment.Center);

        UITextView textViewNSTextAlignment0 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 480, 300, 40));
        UITextView textViewNSTextAlignment1 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 530, 300, 40));
        UITextView textViewNSTextAlignment2 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 590, 300, 40));
        UITextView textViewNSTextAlignment3 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 480, 300, 40));
        UITextView textViewNSTextAlignment4 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 530, 300, 40));
        UITextView textViewNSTextAlignmentDefault = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 590, 300, 40));
        textViewNSTextAlignment0.setText("NSTextAlignmentLeft");
        textViewNSTextAlignment1.setText("NSTextAlignmentCenter");
        textViewNSTextAlignment2.setText("NSTextAlignmentRight");
        textViewNSTextAlignment3.setText("NSTextAlignmentJustified");
        textViewNSTextAlignment4.setText("NSTextAlignmentNatural");
        textViewNSTextAlignmentDefault.setText("Default");
        textViewNSTextAlignment0.setTextAlignment(NSTextAlignment.Left);
        textViewNSTextAlignment1.setTextAlignment(NSTextAlignment.Center);
        textViewNSTextAlignment2.setTextAlignment(NSTextAlignment.Right);
        textViewNSTextAlignment3.setTextAlignment(NSTextAlignment.Justified);
        textViewNSTextAlignment4.setTextAlignment(NSTextAlignment.Natural);
        view().addSubview(textViewNSTextAlignment0);
        view().addSubview(textViewNSTextAlignment1);
        view().addSubview(textViewNSTextAlignment2);
        view().addSubview(textViewNSTextAlignment3);
        view().addSubview(textViewNSTextAlignment4);
        view().addSubview(textViewNSTextAlignmentDefault);
        testSetTextAlignment2 = (NSTextAlignment.Left == textViewNSTextAlignment0.textAlignment()
                && NSTextAlignment.Center == textViewNSTextAlignment1.textAlignment()
                && NSTextAlignment.Right == textViewNSTextAlignment2.textAlignment()
                && NSTextAlignment.Justified == textViewNSTextAlignment3.textAlignment()
                && NSTextAlignment.Natural == textViewNSTextAlignment4.textAlignment()
                && NSTextAlignment.Left == textViewNSTextAlignmentDefault.textAlignment());

        UITextView textView3 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 100, 100));
        UITextView textView4 = UITextView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 200, 100, 100));
        textView3.setText("");
        textView4.setText(null);
        testHasText1 = (textView1.hasText() && textView2.hasText()
                && !textView3.hasText() && !textView4.hasText());

        testDelegate1 = (textView1.delegate() == this && textView3.delegate() == null);

        textView3.setDelegate(this);
        textView1.setDelegate(null);
        testSetDelegate1 = (textView3.delegate() == this && textView1.delegate() == null);

        textView1.setUserInteractionEnabled(false);

        testSetUserInteractionEnabled1 = !textView1.isUserInteractionEnabled();
    }

    @Override
    public boolean textViewShouldChangeTextInRangeReplacementText(UITextView uiTextView, NSRange nsRange, String s) {
        return false;
    }

    @Override
    public boolean textViewShouldInteractWithTextAttachmentInRange(UITextView uiTextView, NSTextAttachment nsTextAttachment, NSRange nsRange) {
        return false;
    }

    @Override
    public boolean textViewShouldInteractWithURLInRange(UITextView uiTextView, NSURL nsurl, NSRange nsRange) {
        return false;
    }

    @Override
    public void textViewDidBeginEditing(UITextView uiTextView) {

    }

    @Override
    public void textViewDidChange(UITextView uiTextView) {

    }

    @Override
    public void textViewDidChangeSelection(UITextView uiTextView) {

    }

    @Override
    public void textViewDidEndEditing(UITextView uiTextView) {

    }

    @Override
    public boolean textViewShouldBeginEditing(UITextView uiTextView) {
        return false;
    }

    @Override
    public boolean textViewShouldEndEditing(UITextView uiTextView) {
        return false;
    }

    @Override
    public void scrollViewDidEndDecelerating(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewDidEndDraggingWillDecelerate(UIScrollView uiScrollView, boolean b) {

    }

    @Override
    public void scrollViewDidEndScrollingAnimation(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewDidEndZoomingWithViewAtScale(UIScrollView uiScrollView, UIView uiView, double v) {

    }

    @Override
    public void scrollViewDidScroll(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewDidScrollToTop(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewDidZoom(UIScrollView uiScrollView) {

    }

    @Override
    public boolean scrollViewShouldScrollToTop(UIScrollView uiScrollView) {
        return false;
    }

    @Override
    public void scrollViewWillBeginDecelerating(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewWillBeginDragging(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewWillBeginZoomingWithView(UIScrollView uiScrollView, UIView uiView) {

    }

    @Override
    public void scrollViewWillEndDraggingWithVelocityTargetContentOffset(UIScrollView uiScrollView, CGPoint cgPoint, CGPoint cgPoint1) {

    }

    @Override
    public UIView viewForZoomingInScrollView(UIScrollView uiScrollView) {
        return null;
    }
}
