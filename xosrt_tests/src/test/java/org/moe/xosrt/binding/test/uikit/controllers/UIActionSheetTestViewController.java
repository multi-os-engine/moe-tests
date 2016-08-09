package org.moe.xosrt.binding.test.uikit.controllers;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.NSMutableArray;
import ios.foundation.NSString;
import ios.uikit.UIActionSheet;
import ios.uikit.UIColor;
import ios.uikit.UILabel;
import ios.uikit.UIScreen;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.protocol.UIActionSheetDelegate;

public class UIActionSheetTestViewController extends UIViewController implements UIActionSheetDelegate {

    public static boolean checkDelegateTestPassed = false;

    NSMutableArray array;
    UIActionSheet actionSheet;

    static {
        NatJ.register();
    }

    protected UIActionSheetTestViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIActionSheetTestViewController alloc();

    @Selector("init")
    public native UIActionSheetTestViewController init();

    @Selector("loadView")
    @Override
    public void loadView() {
        array = NSMutableArray.alloc().initWithCapacity(2);
        actionSheet = UIActionSheet.alloc().init();
        actionSheet.setTitle("NewTitle");
        actionSheet.setDelegate(this);
        UIScreen screenObject = UIScreen.mainScreen();
        UIView newView = UIView.alloc().initWithFrame(screenObject.applicationFrame());
        newView.setBackgroundColor(UIColor.grayColor());

        UILabel labelTitle = (UILabel)UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 40, 200, 30));
        labelTitle.setText("NewTitle");
        newView.addSubview(labelTitle);
        actionSheet.showInView(newView);
        setView(newView);

        performSelectorWithObjectAfterDelay(new SEL("checkDelegateMethod"), null, 2);
    }

    @Selector("checkDelegateMethod")
    public void checkDelegateMethod() {
    	checkDelegateTestPassed = "willPresentActionSheet".equals(array.objectAtIndex(0).toString())
                && "didPresentActionSheet".equals(array.objectAtIndex(1).toString());
    }

    @Selector("willPresentActionSheet:")
    @Override
    public void willPresentActionSheet(UIActionSheet uiActionSheet) {
        array.addObject(NSString.stringWithString("willPresentActionSheet"));
    }

    @Override
    public void actionSheetClickedButtonAtIndex(UIActionSheet uiActionSheet, long l) {

    }

    @Override
    public void actionSheetDidDismissWithButtonIndex(UIActionSheet uiActionSheet, long l) {

    }

    @Override
    public void actionSheetWillDismissWithButtonIndex(UIActionSheet uiActionSheet, long l) {

    }

    @Override
    public void actionSheetCancel(UIActionSheet uiActionSheet) {

    }

    @Selector("didPresentActionSheet:")
    @Override
    public void didPresentActionSheet(UIActionSheet uiActionSheet) {
        array.addObject(NSString.stringWithString("didPresentActionSheet"));
    }

}
