package org.moe.xosrt.binding.test.uikit.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.uikit.UIImage;
import ios.uikit.UIView;


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

    @Override
    public void drawRect(CGRect rect) {
        callStaticMethod(rect);
    }

    public static void callStaticMethod(CGRect rect) {
        UIImage myImage1 = UIImage.imageNamed("images.jpeg");
        myImage1.drawInRect(rect);

        UIImage myImage = UIImage.imageNamed("balloons.png");
        CGPoint imagePoint = CoreGraphics.CGPointZero();
        myImage.drawAtPoint(imagePoint);
    }
}
