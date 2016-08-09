package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;

public class XIBTestScrollViewViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected XIBTestScrollViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestScrollViewViewController alloc();

    @Selector("init")
    public native XIBTestScrollViewViewController init();

    UIScrollView scrollView;
    UIScrollView scrollView2;
    
    UILabel label;
    UITextField textfield;
    
    UIButton button;
    UIProgressView progress;
    boolean  status;
    
    UISwitch switchControl;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "scrollView":
                scrollView = (UIScrollView)value;
                break;
            case "scrollView2":
                scrollView2 = (UIScrollView)value;
                break;
            case "label":
                label = (UILabel)value;
                break;
            case "textfield":
                textfield = (UITextField)value;
                break;
            case "button":
                button = (UIButton)value;
                break;
            case "progress":
                progress = (UIProgressView)value;
                break;
            case "switchControl":
                switchControl = (UISwitch)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "scrollView":
                return scrollView;
            case "scrollView2":
                return scrollView2;
            case "label":
                return label;
            case "textfield":
                return textfield;
            case "button":
                return button;
            case "progress":
                return progress;
            case "switchControl":
                return switchControl;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFrame1 = false;
    public static volatile boolean testFrame2 = false;
    public static volatile boolean testFrame3 = false;
    public static volatile boolean testFrame4 = false;
    public static volatile boolean testFrame5 = false;
    public static volatile boolean testFrame6 = false;
    public static volatile boolean testFrame7 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testBackgroundColor2 = false;
    public static volatile boolean testAlpha1 = false;
    public static volatile boolean testAlpha2 = false;

    public void didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

    public void viewDidUnload() {
        //TODO: unknown method setTextfield(nil);
        super.viewDidUnload();
        // Release any retained subviews of the main view. // e.g. myOutlet = nil;
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        status = true;
        scrollView.setContentSize(CoreGraphics.CGSizeMake(1000, 1700));
        scrollView2.setContentSize(CoreGraphics.CGSizeMake(200, 1000));
        double a = Math.abs(scrollView.frame().origin().x() - 42);
        double b = Math.abs(scrollView.frame().origin().y() - 14);
        double c = Math.abs(scrollView.frame().size().width() - 236);
        double d = Math.abs(scrollView.frame().size().height() - 203);
        testFrame1 =  (Math.abs(scrollView.frame().origin().x() - 42) <= 2 && Math.abs(scrollView.frame().origin().y() - 14) <= 2
                && Math.abs(scrollView.frame().size().width() - 236) <= 2 && Math.abs(scrollView.frame().size().height() - 203) <= 2);

        testFrame2 =  (Math.abs(scrollView2.frame().origin().x() - 40) <= 2 && Math.abs(scrollView2.frame().origin().y() - 252) <= 2
                && Math.abs(scrollView2.frame().size().width() - 240) <= 2 && Math.abs(scrollView2.frame().size().height() - 167) <= 2);

        testFrame3 =  (Math.abs(label.frame().origin().x() - 34) <= 2 && Math.abs(label.frame().origin().y() - 59) <= 2
                && Math.abs(label.frame().size().width() - 175) <= 2 && Math.abs(label.frame().size().height() - 35) <= 2);

        testFrame4 =  (Math.abs(textfield.frame().origin().x() - 70) <= 2 && Math.abs(textfield.frame().origin().y() - 86) <= 2
                && Math.abs(textfield.frame().size().width() - 97) <= 2 && Math.abs(textfield.frame().size().height() - 31) <= 2);

        testFrame5 =  (Math.abs(button.frame().origin().x() - 229) <= 2 && Math.abs(button.frame().origin().y() - 85) <= 2
                && Math.abs(button.frame().size().width() - 172) <= 2 && Math.abs(button.frame().size().height() - 37) <= 2);

        testFrame6 =  (Math.abs(progress.frame().origin().x() - 45) <= 2 && Math.abs(progress.frame().origin().y() - 172.5) <= 2
                && Math.abs(progress.frame().size().width() - 150) <= 2 && Math.abs(progress.frame().size().height() - 9) <= 2);

        testFrame7 =  (Math.abs(switchControl.frame().origin().x() - 64) <= 2 && Math.abs(switchControl.frame().origin().y() - 147) <= 2);

        testBackgroundColor1 =  (scrollView.backgroundColor().isEqual(UIColor.cyanColor()));

        testBackgroundColor2 =  (scrollView2.backgroundColor().isEqual(UIColor.magentaColor()));

        testAlpha1 =  (scrollView.alpha() == 1 );

        testAlpha2 =  (scrollView2.alpha() == 0.5 );

        performSelectorWithObjectAfterDelay(new SEL("move"), null, 2);
    }

    @Selector("move")
    public void move() {
        scrollView.setContentOffset(CoreGraphics.CGPointMake(50, 50));
        scrollView.scrollRectToVisibleAnimated(CoreGraphics.CGRectMake(50, 10, 50, 30), true);

        button.sendActionsForControlEvents(UIControlEvents.TouchUpInside);

        switchControl.sendActionsForControlEvents(UIControlEvents.ValueChanged);
    }

    public void dealloc() {
        //textfield.release();
        super.dealloc();
    }

    @Selector("reload:")
    public void reload(Object sender) {
        if(status) {
            progress.setProgressAnimated(0.8f, true);
            label.setText("80%");
        } else {
            progress.setProgressAnimated(0.0f, true);
            label.setText("0%");
        }
        status = !status;
    }

    @Selector("changeSwitch:")
    public void changeSwitch(Object sender) {
        if(switchControl.isOn()) {
            textfield.setText("switch ON");
        } else {
            textfield.setText("switch OFF");
        }
    }

}
