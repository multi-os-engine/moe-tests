package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestProgressViewViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestProgressViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestProgressViewViewController alloc();

    @Selector("init")
    public native XIBTestProgressViewViewController init();

    UIProgressView progressView;
    UIProgressView progressView2;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "progressView":
                progressView = (UIProgressView)value;
                break;
            case "progressView2":
                progressView2 = (UIProgressView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "progressView":
                return progressView;
            case "progressView2":
                return progressView2;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testProgress1 = false;
    public static volatile boolean testFrame2 = false;
    public static volatile boolean testProgress2 = false;
    public static volatile boolean testProgress3 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    public void viewDidUnload() {
        //TODO: not unknown method setProgressView(null);
        super.viewDidUnload();
        // Release any retained subviews of the main view.
        // e.g. myOutlet = nil;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testFrame1 =  (progressView.frame().origin().x() == 90 && progressView.frame().origin().y() == 153
                && progressView.frame().size().width() == 150 && progressView.frame().size().height() == 9);

        testProgress1 = (progressView.progress() == 0.5);

        testFrame2 =  (progressView2.frame().origin().x() == 65 && progressView2.frame().origin().y() == 253
                && progressView2.frame().size().width() == 200 && progressView2.frame().size().height() == 9);

        testProgress2 = (progressView2.progress() == 0.75);

        testProgress3 =  (progressView.progress() == 0.5) ;

        testAlpha1 =  (progressView.alpha() == 0.5) ;

        testAlpha2 =  (progressView2.alpha() == 1) ;
    }

    public void dealloc() {
        //progressView.release();
        super.dealloc();
    }

}
