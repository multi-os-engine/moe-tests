package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSMutableArray;
import ios.foundation.NSString;
import ios.uikit.UIColor;
import ios.uikit.UIScreen;
import ios.uikit.UIView;
import ios.uikit.UIViewController;

public class XIBTestLifeCycleViewController0 extends UIViewController {

    static {
        NatJ.register();
    }

    private boolean bAnimated = false;
    private boolean withDelay = false;
    private int n = 0;
    private NSMutableArray viewLifeCycleArray = NSMutableArray.array();
    private int appearCounter = 0;
    private UIColor bkColor = UIColor.grayColor();

    public static volatile boolean testViewLifeCycle = false;

    protected XIBTestLifeCycleViewController0(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestLifeCycleViewController0 alloc();

    @Selector("init")
    public native XIBTestLifeCycleViewController0 init();

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(bkColor);
        setTitle("ViewController" + n);
        if (viewLifeCycleArray == null) {
            viewLifeCycleArray = NSMutableArray.array();
        }
        viewLifeCycleArray.addObject(NSString.stringWithString("ViewController" + n + " loadView"));
    }

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        viewLifeCycleArray.addObject(NSString.stringWithString("ViewController" + n + " viewDidLoad"));
        super.viewDidLoad();
    }

    @Selector("viewWillAppear:")
    @Override
    public void viewWillAppear(boolean animated) {
        viewLifeCycleArray.addObject(NSString.stringWithString("ViewController" + n + " viewWillAppear"));
        super.viewWillAppear(animated);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        viewLifeCycleArray.addObject(NSString.stringWithString("ViewController" + n + " viewDidAppear"));
        super.viewDidAppear(animated);

        if (n != 2 && appearCounter++ == 0) {
            if (withDelay) {
                performSelectorWithObjectAfterDelay(new SEL("push"), null, 1);
            } else {
                push();
            }
        } else {
            if (n != 0) {
                if (withDelay) {
                    performSelectorWithObjectAfterDelay(new SEL("pop"), null, 1);
                } else {
                    pop();
                }
            }
        }
    }

    @Selector("push")
    public void push() {
        XIBTestLifeCycleViewController0 controller = (XIBTestLifeCycleViewController0)
                XIBTestLifeCycleViewController0.alloc().initWithNibNameBundle("ViewController" + (n + 1), null);
        controller.setCheckAnimated(bAnimated);
        controller.setNumber(n + 1);
        controller.setArray(viewLifeCycleArray);
        controller.setWithDelay(withDelay);
        if (navigationController() != null) {
            navigationController().pushViewControllerAnimated(controller, bAnimated);
        }
    }

    @Selector("pop")
    public void pop() {
        if (navigationController() != null) {
            navigationController().popViewControllerAnimated(bAnimated);
        }
    }

    @Selector("viewWillDisappear:")
    @Override
    public void viewWillDisappear(boolean animated) {
        viewLifeCycleArray.addObject(NSString.stringWithString("ViewController" + n + " viewWillDisappear"));
            super.viewWillDisappear(animated);
    }

    @Selector("viewDidDisappear:")
    @Override
    public void viewDidDisappear(boolean animated) {
        viewLifeCycleArray.addObject(NSString.stringWithString("ViewController" + n + " viewDidDisappear"));
        super.viewDidDisappear(animated);
    }

    public void setCheckAnimated(boolean animated) {
        bAnimated = animated;
    }

    public void setNumber(int _n) {
        n = _n;
    }

    public void setWithDelay(boolean hasDelay) {
        withDelay = hasDelay;
    }

    public void setArray(NSMutableArray arr) {
        viewLifeCycleArray = arr;
    }

    public NSMutableArray getArray() {
        return viewLifeCycleArray;
    }

    public void setColor(UIColor color) {bkColor = color;}
}
