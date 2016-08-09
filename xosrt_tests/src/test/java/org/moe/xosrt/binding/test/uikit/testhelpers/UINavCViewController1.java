package org.moe.xosrt.binding.test.uikit.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.NSMutableArray;
import ios.foundation.NSString;
import ios.uikit.UIColor;
import ios.uikit.UIView;
import ios.uikit.UIViewController;

public class UINavCViewController1 extends UIViewController {

    static {
        NatJ.register();
    }

    protected UINavCViewController1(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UINavCViewController1 alloc();

    @Selector("init")
    public native UINavCViewController1 init();

    public static volatile boolean testPushViewController_animated1 = false;
    public static volatile boolean testPushViewController_animated2 = false;

    public NSMutableArray viewLifeCycleMethodsArray;
    public NSMutableArray viewLifeCycleMethodsArrayAnimated;
    public boolean bAnimated = false;

    @Selector("popWithAnimation")
    public void popWithAnimation() {
        navigationController().popViewControllerAnimated(true);
    }

    @Selector("popWithoutAnimation")
    public void popWithoutAnimation() {
        navigationController().popViewControllerAnimated(false);
    }

    public void testPushViewController() {
        testPushViewController_animated1 = (viewLifeCycleMethodsArray.objectAtIndex(0).equals("viewWillAppear")
                && viewLifeCycleMethodsArray.objectAtIndex(1).equals("viewDidAppear"));
    }

    public void testPushViewControllerAnimated() {
        testPushViewController_animated2 = (viewLifeCycleMethodsArrayAnimated.objectAtIndex(0).equals("viewWillAppear")
                && viewLifeCycleMethodsArrayAnimated.objectAtIndex(1).equals("viewDidAppear"));
    }

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 320, 480)));
        view().setBackgroundColor(UIColor.blueColor());
        setTitle("ViewController1");
        viewLifeCycleMethodsArray = NSMutableArray.alloc().init();
        viewLifeCycleMethodsArrayAnimated = NSMutableArray.alloc().init();
    }

    @Selector("viewWillAppear:")
    @Override
    public void viewWillAppear(boolean animated) {
        //Somewhy animated param  is false even if nav controller pushes this view controller with animated = true
        //Same behaviour in objective c
        if (bAnimated) {
            viewLifeCycleMethodsArrayAnimated.addObject(NSString.stringWithString("viewWillAppear"));
        } else {
            viewLifeCycleMethodsArray.addObject(NSString.stringWithString("viewWillAppear"));
        }
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        if (bAnimated) {
            viewLifeCycleMethodsArrayAnimated.addObject(NSString.stringWithString("viewDidAppear"));
            testPushViewControllerAnimated();
            performSelectorWithObjectAfterDelay(new SEL("popWithAnimation"), null, 1);
        } else {
            viewLifeCycleMethodsArray.addObject(NSString.stringWithString("viewDidAppear"));
            testPushViewController();
            performSelectorWithObjectAfterDelay(new SEL("popWithoutAnimation"), null, 1);
        }
    }

    @Selector("viewWillDisappear:")
    @Override
    public void viewWillDisappear(boolean animated) {
        if (bAnimated) {
            viewLifeCycleMethodsArrayAnimated.addObject(NSString.stringWithString("viewWillDisappear"));
        } else {
            viewLifeCycleMethodsArray.addObject(NSString.stringWithString("viewWillDisappear"));
        }
    }

    @Selector("viewDidDisappear:")
    @Override
    public void viewDidDisappear(boolean animated) {
        if (bAnimated) {
            viewLifeCycleMethodsArrayAnimated.addObject(NSString.stringWithString("viewDidDisappear"));
        } else {
            viewLifeCycleMethodsArray.addObject(NSString.stringWithString("viewDidDisappear"));
        }
    }
}
