package org.moe.xosrt.binding.test.uikit.viewTest;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.c.CoreGraphics;
import ios.foundation.NSMutableArray;
import ios.foundation.NSString;
import ios.uikit.UIColor;
import ios.uikit.UIScreen;
import ios.uikit.UIViewController;

public class ViewController0 extends UIViewController {

    NSMutableArray arrayOfMethodNames = null;

    public volatile static boolean test1Passed = false;
    public volatile static boolean test2Passed = false;
    public volatile static boolean test3Passed = false;
    public volatile static boolean testAddSubviewPassed = false;
    public volatile static boolean testInsertSubViewAtIndexPassed = false;
    public volatile static boolean testInsertSubviewAboveSubViewPassed = false;
    public volatile static boolean testInsertSubViewBelowSubViewPassed = false;
    public volatile static boolean testRemoveSubViewPassed = false;


    static {
        NatJ.register();
    }

    protected ViewController0(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native ViewController0 alloc();

    @Selector("init")
    public native ViewController0 init();

    @Override
    @Selector("loadView")
    public void loadView() {
        arrayOfMethodNames = NSMutableArray.alloc().init();
        this.setView(ViewTest2.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        this.view().setBackgroundColor(UIColor.redColor());
        this.view().setTag(100);
        view().setBackgroundColor(UIColor.brownColor());
    }

    @Override
    @Selector("viewDidAppear:")
    public void viewDidAppear(boolean animated) {
        testViewDidLayoutSubView();
        testAddSubView();
        testInsertSubViewAtIndex();
        testInsertSubviewAboveSubView();
        testInsertSubViewBelowSubView();
        testRemoveSubView();
        this.performSelectorWithObjectAfterDelay(new SEL("testDrawRect"), null, 3);
    }

    public void testViewDidLayoutSubView() {
        view().setFrame(CoreGraphics.CGRectMake(0, 0, 300, 400));
        performSelectorWithObjectAfterDelay(new SEL("test1"), null, 1);

        ViewController1 cont1 = ViewController1.alloc().init();
        view().addSubview(cont1.view());

        ViewTest1 view1 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(240, 50, 50, 50));
        view1.setBackgroundColor(UIColor.brownColor());
        view1.setTag(200);
        cont1.view().addSubview(view1);
        performSelectorWithObjectAfterDelay(new SEL("test2"), cont1, 1);
    }

    public void testAddSubView() {
        ViewTest view0 = (ViewTest)ViewTest.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 0, 200, 100));
        view0.setBackgroundColor(UIColor.yellowColor());
        view0.setTag(150);
        view().addSubview(view0);

        ViewTest1 view1 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 50, 50, 50));
        view1.setBackgroundColor(UIColor.blueColor());
        view1.setTag(200);
        view0.addSubview(view1);

        //Testing
        NSString string0 = NSString.stringWithString((String)view0.arrayOfMethodNames.objectAtIndex(0));
        NSString string1 = NSString.stringWithString((String)view0.arrayOfMethodNames.objectAtIndex(1));
        NSString string2 = NSString.stringWithString((String)view0.arrayOfMethodNames.objectAtIndex(2));
        NSString string3 = NSString.stringWithString((String)view0.arrayOfMethodNames.objectAtIndex(3));
        NSString string4 = NSString.stringWithString((String)view0.arrayOfMethodNames.objectAtIndex(4));

        NSString string0view1 = NSString.stringWithString((String)view1.arrayOfMethodNames.objectAtIndex(0));
        NSString string1view1 = NSString.stringWithString((String)view1.arrayOfMethodNames.objectAtIndex(1));
        NSString string2view1 = NSString.stringWithString((String)view1.arrayOfMethodNames.objectAtIndex(2));
        NSString string3view1 = NSString.stringWithString((String)view1.arrayOfMethodNames.objectAtIndex(3));

        testAddSubviewPassed = string0.isEqualToString("willMoveToWindow")
                && string1.isEqualToString("willMoveToSuperview")
                && string2.isEqualToString("didMoveToWindow")
                && string3.isEqualToString("didMoveToSuperview")
                && string4.isEqualToString("didAddSubview")
                && string0view1.isEqualToString("willMoveToWindow")
                && string1view1.isEqualToString("willMoveToSuperview")
                && string2view1.isEqualToString("didMoveToWindow")
                && string3view1.isEqualToString("didMoveToSuperview");
    }

    public void testInsertSubViewAtIndex() {
        ViewTest view0 = (ViewTest)ViewTest.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 100, 100, 250));
        view0.setBackgroundColor(UIColor.magentaColor());
        view0.setTag(150);
        view().addSubview(view0);

        ViewTest1 view1 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 50, 80, 80));
        view1.setBackgroundColor(UIColor.whiteColor());
        view1.setTag(200);
        view0.addSubview(view1);

        view0.arrayOfMethodNames = (NSMutableArray)NSMutableArray.array();

        ViewTest1 view2 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 50, 50, 50));
        view1.setBackgroundColor(UIColor.redColor());
        view1.setTag(200);
        view0.insertSubviewAtIndex(view2, 1);

        //Testing
        NSString string0 = NSString.stringWithString((String)view0.arrayOfMethodNames.objectAtIndex(0));
        NSString string0view2 = NSString.stringWithString((String)view2.arrayOfMethodNames.objectAtIndex(0));
        NSString string1view2 = NSString.stringWithString((String)view2.arrayOfMethodNames.objectAtIndex(1));
        NSString string2view2 = NSString.stringWithString((String)view2.arrayOfMethodNames.objectAtIndex(2));
        NSString string3view2 = NSString.stringWithString((String)view2.arrayOfMethodNames.objectAtIndex(3));

        testInsertSubViewAtIndexPassed = string0.isEqualToString("didAddSubview")
                && string0view2.isEqualToString("willMoveToWindow")
                && string1view2.isEqualToString("willMoveToSuperview")
                && string2view2.isEqualToString("didMoveToWindow")
                && string3view2.isEqualToString("didMoveToSuperview");
    }

    public void testInsertSubviewAboveSubView() {
        ViewTest view0 = (ViewTest)ViewTest.alloc().initWithFrame(CoreGraphics.CGRectMake(110, 110, 150, 100));
        view0.setBackgroundColor(UIColor.grayColor());
        view0.setTag(150);
        view().addSubview(view0);

        ViewTest1 view1 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 20, 50, 50));
        view1.setBackgroundColor(UIColor.cyanColor());
        view1.setTag(200);
        view0.addSubview(view1);

        view0.arrayOfMethodNames = (NSMutableArray)NSMutableArray.array();

        ViewTest1 view2 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(80, 20, 50, 50));
        view1.setBackgroundColor(UIColor.purpleColor());
        view1.setTag(200);
        view0.insertSubviewAboveSubview(view2, view1);

        //Testing
        String string0 = (String)view0.arrayOfMethodNames.objectAtIndex(0);

        String string0view2 = (String)view2.arrayOfMethodNames.objectAtIndex(0);
        String string1view2 = (String)view2.arrayOfMethodNames.objectAtIndex(1);
        String string2view2 = (String)view2.arrayOfMethodNames.objectAtIndex(2);
        String string3view2 = (String)view2.arrayOfMethodNames.objectAtIndex(3);

        testInsertSubviewAboveSubViewPassed = string0.equals("didAddSubview")
                && string0view2.equals("willMoveToWindow")
                && string1view2.equals("willMoveToSuperview")
                && string2view2.equals("didMoveToWindow")
                && string3view2.equals("didMoveToSuperview");
    }

    public void testInsertSubViewBelowSubView() {
        ViewTest view0 = (ViewTest)ViewTest.alloc().initWithFrame(CoreGraphics.CGRectMake(110, 220, 100, 130));
        view0.setBackgroundColor(UIColor.yellowColor());
        view0.setTag(150);
        view().addSubview(view0);

        ViewTest1 view1 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 50, 70, 70));
        view1.setBackgroundColor(UIColor.darkGrayColor());
        view1.setTag(200);
        view0.addSubview(view1);

        view0.arrayOfMethodNames = (NSMutableArray)NSMutableArray.array();

        ViewTest1 view2 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(20, 20, 50, 50));
        view1.setBackgroundColor(UIColor.redColor());
        view1.setTag(200);
        view0.insertSubviewBelowSubview(view2, view1); //above???

        //Testing
        String string0 = (String)view0.arrayOfMethodNames.objectAtIndex(0);

        String string0view2 = (String)view2.arrayOfMethodNames.objectAtIndex(0);
        String string1view2 = (String)view2.arrayOfMethodNames.objectAtIndex(1);
        String string2view2 = (String)view2.arrayOfMethodNames.objectAtIndex(2);
        String string3view2 = (String)view2.arrayOfMethodNames.objectAtIndex(3);

        testInsertSubViewBelowSubViewPassed = string0.equals("didAddSubview")
                && string0view2.equals("willMoveToWindow")
                && string1view2.equals("willMoveToSuperview")
                && string2view2.equals("didMoveToWindow")
                && string3view2.equals("didMoveToSuperview");
    }

    public void testRemoveSubView() {
        ViewTest view0 = (ViewTest)ViewTest.alloc().initWithFrame(CoreGraphics.CGRectMake(220, 210, 80, 70));
        view0.setBackgroundColor(UIColor.greenColor());
        view0.setTag(150);
        view().addSubview(view0);

        ViewTest1 view1 = (ViewTest1)ViewTest1.alloc().initWithFrame(CoreGraphics.CGRectMake(50, 50, 50, 50));
        view1.setBackgroundColor(UIColor.redColor());
        view1.setTag(200);
        view0.addSubview(view1);

        view1.removeFromSuperview();

        //Testing
        String string0 = (String)view0.arrayOfMethodNames.objectAtIndex(0);
        String string1 = (String)view0.arrayOfMethodNames.objectAtIndex(1);
        String string2 = (String)view0.arrayOfMethodNames.objectAtIndex(2);
        String string3 = (String)view0.arrayOfMethodNames.objectAtIndex(3);
        String string4 = (String)view0.arrayOfMethodNames.objectAtIndex(4);
        String string5 = (String)view0.arrayOfMethodNames.objectAtIndex(5);

        testRemoveSubViewPassed = string0.equals("willMoveToWindow")
                && string1.equals("willMoveToSuperview")
                && string2.equals("didMoveToWindow")
                && string3.equals("didMoveToSuperview")
                && string4.equals("didAddSubview")
                && string5.equals("willRemoveSubview");
    }

    @Selector("testDrawRect")
    public void testDrawRect() throws NoSuchMethodException {
        view().setNeedsDisplay();
        performSelectorWithObjectAfterDelay(new SEL("test3"), null, 1);
    }

    @Selector("test1")
    public void test1() {
        String string0 = (String)arrayOfMethodNames.objectAtIndex(0);
        String string1 = (String)arrayOfMethodNames.objectAtIndex(1);
        String string2 = (String)arrayOfMethodNames.objectAtIndex(2);
        String string3 = (String)arrayOfMethodNames.objectAtIndex(3);
        test1Passed = string0.equals("viewWillLayoutSubviews")
                && string1.equals("viewDidLayoutSubviews")
                && string2.equals("viewWillLayoutSubviews")
                && string3.equals("viewDidLayoutSubviews");
    }

    @Selector("test2")
    public void test2(ViewController1 controller) {
        String string0 = (String)controller.arrayOfMethodNames.objectAtIndex(0);
        String string1 = (String)controller.arrayOfMethodNames.objectAtIndex(1);
        test2Passed = string0.equals("viewWillLayoutSubviews")
                && string1.equals("viewDidLayoutSubviews");
    }

    @Selector("test3")
    public void test3() {
        String string0 = (String)((ViewTest2)view()).arrayOfMethodNames.objectAtIndex(0);
        String string1 = (String)((ViewTest2)view()).arrayOfMethodNames.objectAtIndex(1);
        test3Passed = string0.equals("drawRect")
                && string1.equals("drawRect");
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
