package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestImageViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestImageViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestImageViewController alloc();

    @Selector("init")
    public native XIBTestImageViewController init();

    UIImageView imageView1;
    UIImageView imageView2;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "imageView1":
                imageView1 = (UIImageView)value;
                break;
            case "imageView2":
                imageView2 = (UIImageView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "imageView1":
                return imageView1;
            case "imageView2":
                return imageView2;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testFrame2 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testFrame1 =  (imageView1.frame().origin().x() == 24 && imageView1.frame().origin().y() == 27
                && imageView1.frame().size().width() == 274 && imageView1.frame().size().height() == 194);

        testFrame2 =  (imageView2.frame().origin().x() == 28 && imageView2.frame().origin().y() == 250
                && imageView2.frame().size().width() == 262 && imageView2.frame().size().height() == 185);

        testBackgroundColor1 =  (imageView1.backgroundColor().isEqual(UIColor.blueColor())) ;

        testAlpha1 =  (imageView1.alpha() == 1 );

        testAlpha2 =  (imageView2.alpha() == 0.5 );

        super.viewDidAppear(animated);
    }

}
