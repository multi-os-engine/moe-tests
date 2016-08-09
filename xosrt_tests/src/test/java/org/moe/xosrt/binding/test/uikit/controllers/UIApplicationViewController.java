package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.NSURL;
import ios.uikit.UIApplication;
import ios.uikit.UIColor;
import ios.uikit.UIView;
import ios.uikit.UIViewController;

public class UIApplicationViewController extends UIViewController {

    //public static NewTestRunner appDelegate = null;

    static {
        NatJ.register();
    }

    protected UIApplicationViewController(Pointer peer) {
        super(peer);
    }

    public static boolean testSharedApplication = false;
    public static boolean testOpenURL1 = false;
    public static boolean testOpenURL2 = false;
    public static boolean testOpenURL3 = false;
    public static boolean testOpenURL4 = false;
    public static boolean testOpenURL5 = false;

    @Selector("alloc")
    public static native UIApplicationViewController alloc();

    @Selector("init")
    public native UIApplicationViewController init();

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.whiteColor());

        UIApplication app = UIApplication.sharedApplication();

        //testSharedApplication = (app.delegate() == appDelegate);

        NSURL urlLoad1 = NSURL.URLWithString("http://www.google.com.ar");
        testOpenURL1 = app.canOpenURL(urlLoad1);


        NSURL urlLoad2 = NSURL.URLWithString("fgsdgdsfghff");
        testOpenURL2 = !app.canOpenURL(urlLoad2);

        NSURL urlLoad3 = NSURL.URLWithString("mailto://info@iphonedevelopertips.com");
        testOpenURL3 = app.canOpenURL(urlLoad3);

        NSURL urlLoad4 = NSURL.URLWithString("tel:15415551234");
        testOpenURL4 = app.canOpenURL(urlLoad4);

        NSURL urlLoad5 = NSURL.URLWithString("sms:55555");
        testOpenURL5 = app.canOpenURL(urlLoad5);

        //app.openURL(urlLoad1);
    }

}
