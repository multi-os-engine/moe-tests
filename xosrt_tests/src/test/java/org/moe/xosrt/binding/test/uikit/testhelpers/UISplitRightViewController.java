package org.moe.xosrt.binding.test.uikit.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.UIColor;
import ios.uikit.UILabel;
import ios.uikit.UIView;
import ios.uikit.UIViewController;

public class UISplitRightViewController extends UIViewController{


    static {
        NatJ.register();
    }

    protected UISplitRightViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UISplitRightViewController alloc();

    @Selector("init")
    public native UISplitRightViewController init();

    @Selector("loadView")
    @Override
    public void loadView() {
        UIView newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 319, 480));
        newView.setBackgroundColor(UIColor.redColor());

        UILabel label = UILabel.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 40, 200, 40));
        label.setText("Hello");
        newView.addSubview(label);
        setView(newView);
    }
}
