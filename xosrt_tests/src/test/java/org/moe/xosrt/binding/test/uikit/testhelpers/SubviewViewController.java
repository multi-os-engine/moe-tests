package org.moe.xosrt.binding.test.uikit.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.uikit.UIColor;
import ios.uikit.UIView;
import ios.uikit.UIViewController;

public class SubviewViewController extends UIViewController {

    static {
        NatJ.register();
    }

    public long loadViewCount = 0;
    public long viewDidLoadCount = 0;
    public long viewWillAppearCount = 0;
    public long viewDidAppearCount = 0;
    public long viewWillDisappearCount = 0;
    public long viewDidDisappearCount = 0;
    
    protected SubviewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native SubviewViewController alloc();

    @Selector("init")
    public native SubviewViewController init();

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(100, 100, 100, 100)));
        view().setBackgroundColor(UIColor.cyanColor());

        loadViewCount++;
    }

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        viewDidLoadCount++;
        super.viewDidLoad();
    }

    @Selector("viewWillAppear:")
    @Override
    public void viewWillAppear(boolean animated) {
        viewWillAppearCount++;
        super.viewWillAppear(animated);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        viewDidAppearCount++;
        super.viewDidAppear(animated);
    }

    @Selector("viewWillDisappear:")
    @Override
    public void viewWillDisappear(boolean animated) {
        viewWillDisappearCount++;
        super.viewWillDisappear(animated);
    }

    @Selector("viewDidDisappear:")
    @Override
    public void viewDidDisappear(boolean animated) {
        viewDidDisappearCount++;
        super.viewDidDisappear(animated);
    }
}
