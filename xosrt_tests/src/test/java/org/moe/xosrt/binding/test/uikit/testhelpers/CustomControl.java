package org.moe.xosrt.binding.test.uikit.testhelpers;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.struct.CGRect;
import ios.uikit.UIColor;
import ios.uikit.UIControl;
import ios.uikit.UILabel;

public class CustomControl extends UIControl {

    static {
        NatJ.register();
    }

    @Selector("alloc")
    public static native CustomControl alloc();

    @Selector("init")
    public native CustomControl init();

    public UILabel label;

    protected CustomControl(Pointer peer) {
        super(peer);
    }

    @Selector("initWithFrame:")
    public native UIControl initWithFrame(CGRect frame);

    @Selector("setFrame:")
    @Override
    public void setFrame(CGRect frame) {
        super.setFrame(frame);
        if (label == null) {
            label = (UILabel)UILabel.alloc().initWithFrame(frame);
            label.setText("Default text");
            label.setBackgroundColor(UIColor.whiteColor());
            label.setTextColor(UIColor.blackColor());
        }
        label.setFrame(frame);
    }

    @Selector("setBackgroundColor:")
    @Override
    public void setBackgroundColor(UIColor bkColor) {
        super.setBackgroundColor(bkColor);
        label.setBackgroundColor(bkColor);
    }
}
