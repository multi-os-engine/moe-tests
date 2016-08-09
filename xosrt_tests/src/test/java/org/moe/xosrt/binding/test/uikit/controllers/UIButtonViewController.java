package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.*;
import ios.uikit.enums.UIButtonType;
import ios.uikit.enums.UIControlState;

public class UIButtonViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIButtonViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIButtonViewController alloc();

    @Selector("init")
    public native UIButtonViewController init();


    public static volatile boolean testButtonWithType1 = false;
    public static volatile boolean testSetTitle_forState1 = false;
    public static volatile boolean testTitleLabel1 = false;
    public static volatile boolean testSetTitleColor_forState1 = false;
    public static volatile boolean testFont1 = false;
    public static volatile boolean testSetImage_forState1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        UIView newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480));

        setView(newView);

        testMethod();
    }

    public void testMethod() {
        UIButton btn1 = UIButton.buttonWithType(UIButtonType.RoundedRect);
        btn1.setFrame(CoreGraphics.CGRectMake(0, 20, 250, 40));
        btn1.setTitleForState("Button 1", UIControlState.Normal & UIControlState.Disabled & UIControlState.Selected);
        view().addSubview(btn1);
        testButtonWithType1 = (btn1.buttonType() == UIButtonType.RoundedRect);

        UIButton btn2 = UIButton.buttonWithType(UIButtonType.Custom);
        btn2.setFrame(CoreGraphics.CGRectMake(0, 70, 250, 40));
        btn2.setTitleForState("Button 2", UIControlState.Normal & UIControlState.Disabled & UIControlState.Selected);
        view().addSubview(btn2);
        String clickedTitle = "Clicked title!";
        btn2.setTitleForState(clickedTitle, UIControlState.Normal);
        String str = btn2.titleForState(UIControlState.Normal);
        testSetTitle_forState1 = (str.equals(clickedTitle));

        UIButton  btn6 = UIButton.buttonWithType(UIButtonType.RoundedRect);
        String strLabel = "TITLE LABEL";
        btn6.setTitleForState(strLabel, UIControlState.Normal);
        testTitleLabel1 = (btn6.titleLabel().text().equals(strLabel));

        UIButton btn3 = UIButton.buttonWithType(UIButtonType.InfoLight);
        btn3.setFrame(CoreGraphics.CGRectMake(0, 130, 250, 40));
        view().addSubview(btn3);
        String clickedTitle2 = "Clicked title2!";
        btn3.setTitleForState(clickedTitle2, UIControlState.Normal);
        btn3.setTitleColorForState(UIColor.blueColor(), UIControlState.Normal);
        testSetTitleColor_forState1 = (btn3.titleColorForState(UIControlState.Normal) == UIColor.blueColor());

        String  fontName = "Helvetica";
        double fontSize = 12.0f;
        UIFont font = UIFont.fontWithNameSize(fontName, fontSize);
        UIButton btn8 = UIButton.buttonWithType(UIButtonType.ContactAdd);
        btn8.setFont(font);
        btn8.setTitleForState(clickedTitle, UIControlState.Normal);
        btn8.setFrame(CoreGraphics.CGRectMake(0, 190, 250, 40));
        view().addSubview(btn8);
        testFont1 = (btn8.font() == font);

        UIButton btn9 = UIButton.buttonWithType( UIButtonType.Custom);
        UIImage img9 = UIImage.imageNamed("logo_boton.png");
        btn9.setFrame(CoreGraphics.CGRectMake(0, 250, 250, 200));
        btn9.setBackgroundColor(UIColor.darkGrayColor());
        btn9.setTitleForState("Button IMG", UIControlState.Normal);
        btn9.setImageForState(img9, UIControlState.Normal);
        view().addSubview(btn9);
        testSetImage_forState1 = (btn9.imageForState(UIControlState.Normal) == img9 && btn9.imageView().image() == img9);
    }

}
