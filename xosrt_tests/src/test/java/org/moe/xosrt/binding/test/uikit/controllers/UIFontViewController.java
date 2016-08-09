package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.*;

public class UIFontViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UIFontViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIFontViewController alloc();

    @Selector("init")
    public native UIFontViewController init();


    public static volatile boolean testFontWithName_size1 = false;
    public static volatile boolean testFontWithSize1 = false;
    public static volatile boolean testSystemFontOfSize1 = false;
    public static volatile boolean testItalicSystemFontOfSize1 = false;
    public static volatile boolean testBoldSystemFontOfSize1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        UIView  newView = UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds());

        setView(newView);

        testMethod();
    }

    public void testMethod() {


        UITextField  labelNameSize = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 200, 250,50 ));
        labelNameSize.setTag(4);
        labelNameSize.setText("_fontWithName_size");
        labelNameSize.setFont(UIFont.fontWithNameSize("Helvetica", 16.0f));
        view().addSubview(labelNameSize);

        UIFont fontWithName = labelNameSize.font();
        testFontWithName_size1 = (fontWithName.fontName().equals("Helvetica") && fontWithName.pointSize() == 16.0f);


        UITextField labelSize = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 280, 250, 50));
        labelSize.setTag(5);
        labelSize.setText("fontWithSize");
        double floatFontSize2 = 25.0f;
        labelSize.setFont(labelNameSize.font().fontWithSize(floatFontSize2));
        view().addSubview(labelSize);

        UIFont fontWithSize = labelSize.font();
        testFontWithSize1 = (fontWithSize.fontName().equals("Helvetica") && fontWithSize.pointSize() == floatFontSize2);


        UITextField  labelSystem = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 100, 250,30 ));
        labelSystem.setTag(2);
        labelSystem.setText("_systemFontOfSize");
        double floatFontSize3 = 20.0f;
        labelSystem.setFont(UIFont.systemFontOfSize(floatFontSize3));
        view().addSubview(labelSystem);

        UIFont systemFontOfSize = labelSystem.font();
        testSystemFontOfSize1 = (systemFontOfSize.pointSize() == floatFontSize3);


        UITextField  labelSystemItalic = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 150, 250,30 ));
        labelSystemItalic.setTag(3);
        labelSystemItalic.setText("_italicSystemFontOfSize");
        labelSystemItalic.setFont(UIFont.italicSystemFontOfSize(16.0f));
        view().addSubview(labelSystemItalic);

        UIFont systemItalicFontOfSize = labelSystemItalic.font();
        System.out.println("Font: " + systemItalicFontOfSize.fontName() + " size:  " + systemItalicFontOfSize.pointSize());
        testItalicSystemFontOfSize1 = (//systemItalicFontOfSize.fontName().equals("Helvetica-Oblique") &&
                systemItalicFontOfSize.pointSize() == 16.0f);


        UITextField  labelSystemBold = UITextField.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 50, 250,20 ));
        labelSystemBold.setTag(1);
        labelSystemBold.setText("_boldSystemFontOfSize");
        double floatFontSize1 = 16.0f;
        labelSystemBold.setFont(UIFont.boldSystemFontOfSize(floatFontSize1));
        view().addSubview(labelSystemBold);

        UIFont systemBoldFontOfSize = labelSystemBold.font();
        System.out.println("Font: " + systemBoldFontOfSize.fontName() + " size:  " + systemBoldFontOfSize.pointSize());
        testBoldSystemFontOfSize1 = (//systemBoldFontOfSize.fontName().equals("Helvetica-Bold") &&
                 systemBoldFontOfSize.pointSize() == floatFontSize1);

    }

}
