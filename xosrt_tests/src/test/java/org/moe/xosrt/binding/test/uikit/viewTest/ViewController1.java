package org.moe.xosrt.binding.test.uikit.viewTest;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSMutableArray;
import ios.foundation.NSString;
import ios.uikit.UIColor;
import ios.uikit.UIScreen;
import ios.uikit.UIView;
import ios.uikit.UIViewController;


public class ViewController1 extends UIViewController {
    NSMutableArray arrayOfMethodNames = null;

    static {
        NatJ.register();
    }

    protected ViewController1(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native ViewController1 alloc();

    @Selector("init")
    public native ViewController1 init();

    @Override
    @Selector("loadView")
    public void loadView() {
        arrayOfMethodNames = NSMutableArray.alloc().init();
        this.setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        this.view().setBackgroundColor(UIColor.redColor());
        this.view().setTag(100);
    }

    @Override
    @Selector("viewWillLayoutSubviews")
    public void viewWillLayoutSubviews() {
        arrayOfMethodNames.addObject(NSString.stringWithString("viewWillLayoutSubviews"));
    }

    @Override
    @Selector("viewDidLayoutSubviews")
    public void viewDidLayoutSubviews() {
        arrayOfMethodNames.addObject(NSString.stringWithString("viewDidLayoutSubviews"));
    }
}
