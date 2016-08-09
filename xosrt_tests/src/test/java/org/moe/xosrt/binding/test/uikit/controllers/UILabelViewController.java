package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.*;
import ios.uikit.enums.NSTextAlignment;
import ios.uikit.enums.UILineBreakMode;
import ios.uikit.enums.UITextAlignment;

public class UILabelViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UILabelViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UILabelViewController alloc();

    @Selector("init")
    public native UILabelViewController init();


    static final String TEXT1 = "this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 this is a text1 endtext1";
    static final String TEXT2 = "this is a wieiisiddjasddjkjasdasdsadfdsfsdfsfsdfsdsdfsdfkaldkadadsadadadadsaddasdasdasdasdsadsadsadsadsadsa text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label this is a text2 Label endtext2";
    static final String TEXT3 = "this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 this is a text3 endtext3";
    static final String TEXT4 = "text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 this is a text4 text4 this is a text4 this is a text4 text4 this is a text4 this is a text4 text4 this is a text4 this is a text4 text4 this is a text4 this is a text4 text4 this is a text4 this is a text4 text4 this is a text4 this is a text4 text4 this is a text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 text4 this is a text4 endtext4";
    static final String TEXT5 = "text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 text5 this is a text5 endtext5";


    public static volatile boolean testSetNumberOfLines2 = false;
    public static volatile boolean testSetNumberOfLines3 = false;
    public static volatile boolean testSetText1 = false;
    public static volatile boolean testSetTextColor1 = false;
    public static volatile boolean testSetTextAlignment1 = false;
    public static volatile boolean testSetTextAlignment2 = false;
    public static volatile boolean testSetTextAlignment3 = false;
    public static volatile boolean testSetTextAlignment4 = false;
    public static volatile boolean testSetEnabled1 = false;
    public static volatile boolean testSetNumberOfLines1 = false;
    public static volatile boolean testSetFont1 = false;
    public static volatile boolean testSetLineBreakMode1 = false;
    public static volatile boolean testDefaultTextProgrammatically = false;

    @Selector("testNumberOfLines2")
    public void testNumberOfLines2() {
        UILabel newLabel5 = (UILabel)view().viewWithTag(5);
        newLabel5.setNumberOfLines(4);
        testSetNumberOfLines2 = (newLabel5.numberOfLines() == 4);
    }

    @Selector("testNumberOfLines3")
    public void testNumberOfLines3() {
        UILabel newLabel5 = (UILabel)view().viewWithTag(5);
        newLabel5.setNumberOfLines(0);
        testSetNumberOfLines3 = (newLabel5.numberOfLines() == 0);
    }

    public void testMethods() {
        UILabel newLabel1 = (UILabel)view().viewWithTag(1);
        UILabel newLabel2 = (UILabel)view().viewWithTag(2);
        UILabel newLabel3 = (UILabel)view().viewWithTag(3);
        UILabel newLabel4 = (UILabel)view().viewWithTag(4);
        UILabel newLabel5 = (UILabel)view().viewWithTag(5);

        newLabel1.setText(TEXT1);
        newLabel2.setText(TEXT2);
        newLabel3.setText(TEXT3);
        newLabel4.setText(TEXT4);
        newLabel5.setText(TEXT5);
        testSetText1 = (TEXT1.equals(newLabel1.text()) && TEXT2.equals(newLabel2.text())
                && TEXT3.equals(newLabel3.text()) && TEXT4.equals(newLabel4.text())
                && TEXT5.equals(newLabel5.text()) && !TEXT1.equals(newLabel4.text())
                && !TEXT2.equals(newLabel3.text())) ;

        newLabel1.setTextColor(UIColor.redColor());
        newLabel2.setTextColor(UIColor.greenColor());
        testSetTextColor1 =  (UIColor.redColor() == newLabel1.textColor() && UIColor.greenColor() == newLabel2.textColor());

        newLabel1.setTextAlignment(UITextAlignment.Left);
        newLabel2.setTextAlignment(UITextAlignment.Center);
        newLabel3.setTextAlignment(UITextAlignment.Right);
        testSetTextAlignment1 =  (UITextAlignment.Left == newLabel1.textAlignment()
                && UITextAlignment.Center == newLabel2.textAlignment()
                && UITextAlignment.Right == newLabel3.textAlignment()
                && UITextAlignment.Left == newLabel4.textAlignment());

        newLabel1.setTextAlignment(0);
        testSetTextAlignment2 = (UITextAlignment.Left == newLabel1.textAlignment()) ;

        long value = newLabel1.textAlignment();
        newLabel2.setTextAlignment(newLabel1.textAlignment());
        testSetTextAlignment3 = (value == UITextAlignment.Left);


        UILabel labelNSTextAlignment0 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 480, 300, 40));
        UILabel labelNSTextAlignment1 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 530, 300, 40));
        UILabel labelNSTextAlignment2 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 590, 300, 40));
        UILabel labelNSTextAlignment3 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 480, 300, 40));
        UILabel labelNSTextAlignment4 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 530, 300, 40));
        UILabel labelNSTextAlignmentDefault = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(320, 590, 300, 40));
        labelNSTextAlignment0.setText("NSTextAlignmentLeft");
        labelNSTextAlignment1.setText("NSTextAlignmentCenter");
        labelNSTextAlignment2.setText("NSTextAlignmentRight");
        labelNSTextAlignment3.setText("NSTextAlignmentJustified");
        labelNSTextAlignment4.setText("NSTextAlignmentNatural");
        labelNSTextAlignmentDefault.setText("Default");
        labelNSTextAlignment0.setTextAlignment(NSTextAlignment.Left);
        labelNSTextAlignment1.setTextAlignment(NSTextAlignment.Center);
        labelNSTextAlignment2.setTextAlignment(NSTextAlignment.Right);
        labelNSTextAlignment3.setTextAlignment(NSTextAlignment.Justified);
        labelNSTextAlignment4.setTextAlignment(NSTextAlignment.Natural);
        view().addSubview(labelNSTextAlignment0);
        view().addSubview(labelNSTextAlignment1);
        view().addSubview(labelNSTextAlignment2);
        view().addSubview(labelNSTextAlignment3);
        view().addSubview(labelNSTextAlignment4);
        view().addSubview(labelNSTextAlignmentDefault);

        testSetTextAlignment4 = (NSTextAlignment.Left == labelNSTextAlignment0.textAlignment()
                && NSTextAlignment.Center == labelNSTextAlignment1.textAlignment()
                && NSTextAlignment.Right == labelNSTextAlignment2.textAlignment()
                && NSTextAlignment.Left == labelNSTextAlignment3.textAlignment() //should it be justified?
                && NSTextAlignment.Left == labelNSTextAlignment4.textAlignment()
                && NSTextAlignment.Left == labelNSTextAlignmentDefault.textAlignment());

        newLabel1.setEnabled(false);
        newLabel2.setEnabled(true);
        testSetEnabled1 =  (!newLabel1.isEnabled() && newLabel2.isEnabled() && newLabel3.isEnabled());

        newLabel1.setNumberOfLines(1);
        newLabel2.setNumberOfLines(3);
        newLabel4.setNumberOfLines(2);
        newLabel5.setNumberOfLines(0);
        testSetNumberOfLines1 =  (newLabel1.numberOfLines() == 1 && newLabel2.numberOfLines() == 3
                && newLabel3.numberOfLines() == 1 && newLabel4.numberOfLines() == 2
                && newLabel5.numberOfLines() == 0);

        UIFont font1 = UIFont.fontWithNameSize("Helvetica", 22.0);
        UIFont font2 = UIFont.fontWithNameSize("Helvetica", 6.0);
        UIFont font3 = UIFont.fontWithNameSize("Helvetica", 9.0);
        newLabel1.setFont(font1);
        newLabel2.setFont(font2);
        newLabel5.setFont(font3);
        testSetFont1 =  (newLabel1.font() == font1 && newLabel2.font() == font2 && newLabel5.font() == font3) ;

        UILabel testLabel1 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 0, 100, 50));
        UILabel testLabel2 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 60, 100, 50));
        UILabel testLabel3 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(30, 120, 100, 50));
        UILabel testLabel4 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(40, 180, 100, 50));
        UILabel testLabel5 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(50, 240, 100, 50));
        UILabel testLabel6 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(60, 300, 100, 50));
        UILabel testLabel7 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(60, 300, 100, 50));
        testLabel1.setLineBreakMode(UILineBreakMode.WordWrap);
        testLabel2.setLineBreakMode(UILineBreakMode.CharacterWrap);
        testLabel3.setLineBreakMode(UILineBreakMode.Clip);
        testLabel4.setLineBreakMode(UILineBreakMode.HeadTruncation);
        testLabel5.setLineBreakMode(UILineBreakMode.TailTruncation);
        testLabel6.setLineBreakMode(UILineBreakMode.MiddleTruncation);
        testSetLineBreakMode1 = (testLabel1.lineBreakMode() == UILineBreakMode.WordWrap
                && testLabel2.lineBreakMode() == UILineBreakMode.CharacterWrap
                && testLabel3.lineBreakMode() == UILineBreakMode.Clip
                && testLabel4.lineBreakMode() == UILineBreakMode.HeadTruncation
                && testLabel5.lineBreakMode() == UILineBreakMode.TailTruncation
                && testLabel6.lineBreakMode() == UILineBreakMode.MiddleTruncation
                && testLabel7.lineBreakMode() == UILineBreakMode.TailTruncation);

        UILabel label0 = UILabel.alloc().init();
        testDefaultTextProgrammatically = (label0.text() == null);
    }

    @Selector("loadView")
    @Override
    public void loadView() {

        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));

        UILabel newLabel1 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(3, 20, 300, 50));
        newLabel1.setBackgroundColor(UIColor.whiteColor());
        newLabel1.setTag(1);

        UILabel newLabel2 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 90, 300, 50));
        newLabel2.setTag(2);

        UILabel newLabel3 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(5, 160, 300, 50));
        newLabel3.setBackgroundColor(UIColor.cyanColor());
        newLabel3.setTag(3);

        UILabel newLabel4 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 230, 300, 60));
        newLabel4.setBackgroundColor(UIColor.blueColor());
        newLabel4.setTag(4);

        UILabel newLabel5 = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(11, 300, 300, 150));
        newLabel5.setBackgroundColor(UIColor.greenColor());
        newLabel5.setTag(5);

        view().addSubview(newLabel1);
        view().addSubview(newLabel2);
        view().addSubview(newLabel3);
        view().addSubview(newLabel4);
        view().addSubview(newLabel5);

        testMethods();

        performSelectorWithObjectAfterDelay(new SEL("testNumberOfLines2"), null, 2);
        performSelectorWithObjectAfterDelay(new SEL("testNumberOfLines3"), null, 4);
    }

    public void dealloc() {
        super.dealloc();
    }

}
