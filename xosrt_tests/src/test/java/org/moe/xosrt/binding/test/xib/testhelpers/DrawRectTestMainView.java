package org.moe.xosrt.binding.test.xib.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.opaque.CGContextRef;
import ios.coregraphics.struct.CGRect;
import ios.foundation.NSMutableArray;
import ios.foundation.c.Foundation;
import ios.uikit.UIColor;
import ios.uikit.UIView;
import ios.uikit.c.UIKit;

public class DrawRectTestMainView extends UIView {

    public NSMutableArray array0;

    static {
        NatJ.register();
    }

    int x = 140;
    int y = 140;
    int c = 0;
    int n = 0;

    protected DrawRectTestMainView(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native DrawRectTestMainView alloc();

    @Selector("init")
    public native DrawRectTestMainView init();

    @Selector("awakeFromNib")
    @Override
    public void awakeFromNib() {
        array0 = NSMutableArray.alloc().initWithCapacity(1);
        setBackgroundColor(UIColor.blackColor());
    }

    @Selector("drawRect:")
    @Override
    public void drawRect(CGRect rect) {
        array0.addObject("drawRect");

        while (c++ < 100000) {
            CGContextRef context = UIKit.UIGraphicsGetCurrentContext();

            // Drawing lines with a white stroke color
            CoreGraphics.CGContextSetRGBStrokeColor(context, y/140.0, (140.0 - x) / 140.0, x/140.0, 1.0);
            CoreGraphics.CGContextSetLineWidth(context, 1.0);

            // Draw a single line from left to right
            CoreGraphics.CGContextMoveToPoint(context, x + 10, 10 + 240 - y);
            CoreGraphics.CGContextAddLineToPoint(context, x + 10 + 1, 10 + 240 - y + 1);
            CoreGraphics.CGContextStrokePath(context);

            n = (int)(1000 * Math.random());
            if (n < 333) {
                x = (int)(0.5 * (x + 300));
                y = (int)(0.5 * y);
            } else if (n < 666) {
                x = (int)(0.5 * x);
                y = (int)(0.5 * y);
            } else {
                x = (int)(0.5 * (x + 140));
                y = (int)(0.5 * (y + 240));
            }
            setNeedsDisplay();
        }
    }
}
