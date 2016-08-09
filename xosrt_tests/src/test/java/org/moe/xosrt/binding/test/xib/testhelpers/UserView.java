package org.moe.xosrt.binding.test.xib.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.opaque.CGContextRef;
import ios.coregraphics.struct.CGRect;
import ios.uikit.UIColor;
import ios.uikit.UILabel;
import ios.uikit.UIView;
import ios.uikit.c.UIKit;

public class UserView extends UIView {

    static {
        NatJ.register();
    }

    protected UserView(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UserView alloc();

    @Selector("init")
    public native UserView init();

    UILabel lbl;

    public static volatile boolean testUserView = false;


    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "lbl":
                lbl = (UILabel)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "lbl":
                return lbl;
            default:
                return super.valueForKey(key);
        }
    }

    @Selector("drawRect")
    @Override
    public void drawRect(CGRect rect) {
        CGContextRef context = UIKit.UIGraphicsGetCurrentContext();
        CGRect rectangle = CoreGraphics.CGRectMake(20, 20, 50, 50);
        CoreGraphics.CGContextAddEllipseInRect(context, rectangle);
        CoreGraphics.CGContextFillPath(context);

        testMethod();
    }

    public void testMethod() {
        lbl.setTextColor(UIColor.blueColor());
        testUserView = true;
    }
}
