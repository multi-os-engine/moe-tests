package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.Enums;

public class UISegmentedControlViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UISegmentedControlViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UISegmentedControlViewController alloc();

    @Selector("init")
    public native UISegmentedControlViewController init();

    long selectedCount = 0;

    public static volatile boolean testInitWithItems1 = false;
    public static volatile boolean testImage_forSegmentAtIndex1 = false;
    public static volatile boolean testSetImage_forSegmentAtIndex1 = false;
    public static volatile boolean testTitle_forSegmentAtIndex1 = false;
    public static volatile boolean testSetTitle_forSegmentAtIndex1 = false;
    public static volatile boolean testSelectedSegmentIndex1 = false;
    public static volatile boolean testNumberOfSegments1 = false;
    public static volatile boolean testInsertSegmentWithImage_atIndex_animated1 = false;
    public static volatile boolean testInsertSegmentWithText_atIndex_animated2 = false;
    public static volatile boolean testRemoveAllSegments1 = false;
    public static volatile boolean testRemoveSegmentAtIndex_animated1 = false;
    public static volatile boolean testRemoveSegmentAtIndex_animated2 = false;
    public static volatile boolean testIsEnabled_forSegmentAtIndex1 = false;
    public static volatile boolean testSetEnabled_forSegmentAtIndex1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        view().setBackgroundColor(UIColor.redColor());
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        performSelectorWithObjectAfterDelay(new SEL("testInitializing"), null, 1);
        performSelectorWithObjectAfterDelay(new SEL("testManagingSegmentedContent"), null, 3);
        performSelectorWithObjectAfterDelay(new SEL("testProperties"), null, 5);
        performSelectorWithObjectAfterDelay(new SEL("testInsertSegments"), null, 7);
        performSelectorWithObjectAfterDelay(new SEL("testRemoveSegments"), null, 9);
        performSelectorWithObjectAfterDelay(new SEL("testEnabled"), null, 12);
    }

    public void actionValueChanged() {
        selectedCount++;
    }

    public void cleanView() {
        NSArray subviews1 = view().subviews();
        for(int i = 0; i < subviews1.count(); i++) {
            ((UIView)subviews1.objectAtIndex(i)).removeFromSuperview();
        }
    }

    @Selector("testInitializing")
    public void testInitializing() {
        NSString stringItem1 = NSString.stringWithString("Item1");
        NSString stringItem2 = NSString.stringWithString("Item2");
        NSString stringItem3 = NSString.stringWithString("Item3");
        UIImage image1 = UIImage.imageNamed("testImage0.png");
        UIImage image2 = UIImage.imageNamed("testImage1.png");
        UIImage image3 = UIImage.imageNamed("testImage2.png");
        NSArray arrayStringItems = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem1, stringItem2, stringItem3
                }), 3);
        NSArray arrayImageItems = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(UIImage.class, new UIImage[]{
                        image1, image2
                }), 2);
        NSArray arrayMixedItems = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSObject.class, new NSObject[]{
                        stringItem1, image2, image3
                }), 3);
        UISegmentedControl segmentedControl1 = UISegmentedControl.alloc().initWithItems(arrayStringItems);
        UISegmentedControl segmentedControl2 = UISegmentedControl.alloc().initWithItems(arrayImageItems);
        segmentedControl2.setFrame(CoreGraphics.CGRectMake(0, 100, 250, 100));
        UISegmentedControl segmentedControl3 = UISegmentedControl.alloc().initWithItems(arrayMixedItems);
        segmentedControl3.setFrame(CoreGraphics.CGRectMake(10, 230, 300, 80));
        view().addSubview(segmentedControl1);
        view().addSubview(segmentedControl2);
        view().addSubview(segmentedControl3);
        testInitWithItems1 =  (segmentedControl1 != null && segmentedControl2 != null && segmentedControl3 != null) ;
    }

    @Selector("testManagingSegmentedContent")
    public void testManagingSegmentedContent() {
        cleanView();
        UIImage image0 = UIImage.imageNamed("testImage0.png");
        UIImage image1 = UIImage.imageNamed("testImage1.png");
        UIImage image2 = UIImage.imageNamed("testImage2.png");
        UIImage image3 = UIImage.imageNamed("testImage3.png");
        NSString stringItem0 = NSString.stringWithString("Item0");
        NSString stringItem1 = NSString.stringWithString("Item1");
        NSString stringItem2 = NSString.stringWithString("Item2");
        NSString stringItem3 = NSString.stringWithString("Item3");

        NSArray arrayImageItems1 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSObject.class, new NSObject[]{
                        image0, image1, stringItem3, image3
                }), 4);
        UISegmentedControl segmentedControl1 = UISegmentedControl.alloc().initWithItems(arrayImageItems1);
        view().addSubview(segmentedControl1);
        testImage_forSegmentAtIndex1 = (segmentedControl1.imageForSegmentAtIndex(3) == image3);

        NSArray arrayImageItems2 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(UIImage.class, new UIImage[]{
                        image0, image1, image2
                }), 3);
        UISegmentedControl segmentedControl2 = UISegmentedControl.alloc().initWithItems(arrayImageItems2);
        segmentedControl2.setImageForSegmentAtIndex(image2, 2);
        segmentedControl2.setFrame(CoreGraphics.CGRectMake(0, 100, 200, 80));
        view().addSubview(segmentedControl2);
        testSetImage_forSegmentAtIndex1 = (segmentedControl2.imageForSegmentAtIndex(2) == image2);

        NSArray arrayStrings1 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem0, stringItem1, stringItem2, stringItem3
                }), 4);
        UISegmentedControl segmentedControl3 = UISegmentedControl.alloc().initWithItems(arrayStrings1);
        segmentedControl3.setFrame(CoreGraphics.CGRectMake(0, 200, 300, 80));
        view().addSubview(segmentedControl3);
        testTitle_forSegmentAtIndex1 = (segmentedControl3.titleForSegmentAtIndex(1).equals(stringItem1.toString()));

        NSArray arrayStrings2 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem1, stringItem2
                }), 2);
        UISegmentedControl segmentedControl4 = UISegmentedControl.alloc().initWithItems(arrayStrings2);
        segmentedControl4.setTitleForSegmentAtIndex(stringItem3.toString(), 0);
        segmentedControl4.setFrame(CoreGraphics.CGRectMake(30, 300, 180, 70));
        view().addSubview(segmentedControl4);
        testSetTitle_forSegmentAtIndex1 = (segmentedControl4.titleForSegmentAtIndex(0).equals(stringItem3.toString()));

    }

    @Selector("testProperties")
    public void testProperties() {
        cleanView();
        NSString stringItem0 = NSString.stringWithString("Item0");
        NSString stringItem1 = NSString.stringWithString("Item1");
        NSString stringItem2 = NSString.stringWithString("Item2");
        NSString stringItem3 = NSString.stringWithString("Item3");
        UIImage image0 = UIImage.imageNamed("testImage0.png");
        UIImage image1 = UIImage.imageNamed("testImage1.png");
        UIImage image2 = UIImage.imageNamed("testImage2.png");

        NSArray arrayStrings1 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem0, stringItem1, stringItem2, stringItem3
                }), 4);
        NSArray arrayStrings2 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem0, stringItem2, stringItem3
                }), 3);
        UISegmentedControl segmentedControl1 = UISegmentedControl.alloc().initWithItems(arrayStrings1);
        UISegmentedControl segmentedControl2 = UISegmentedControl.alloc().initWithItems(arrayStrings2);
        UISegmentedControl segmentedControlDefault = UISegmentedControl.alloc().initWithItems(arrayStrings2);
        UISegmentedControl segmentedControlOutOfLength = UISegmentedControl.alloc().initWithItems(arrayStrings2);
        UISegmentedControl segmentedControlDeselect = UISegmentedControl.alloc().initWithItems(arrayStrings2);
        segmentedControl1.setSelectedSegmentIndex(2);
        segmentedControl2.setSelectedSegmentIndex(1);
        segmentedControlOutOfLength.setSelectedSegmentIndex(200);
        segmentedControlDeselect.setSelectedSegmentIndex(-1);

        view().addSubview(segmentedControl1);
        segmentedControl2.setFrame(CoreGraphics.CGRectMake(30, 100, 180, 70));
        view().addSubview(segmentedControl2);

        testSelectedSegmentIndex1 = (segmentedControl1.selectedSegmentIndex() == 2
                && segmentedControl2.selectedSegmentIndex() == 1
                && segmentedControlOutOfLength.selectedSegmentIndex() == Enums.UISegmentedControlNoSegment
                && segmentedControlDefault.selectedSegmentIndex() == Enums.UISegmentedControlNoSegment
                && segmentedControlDeselect.selectedSegmentIndex() == -1) ;


        NSArray arrayStrings3 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem0, stringItem1, stringItem2, stringItem3
                }), 4);
        NSArray arrayImageItems1 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(UIImage.class, new UIImage[] {
                        image0, image1, image2
                }), 3);

        UISegmentedControl segmentedControl3 = UISegmentedControl.alloc().initWithItems(arrayStrings3);
        segmentedControl3.setFrame(CoreGraphics.CGRectMake(30, 300, 200, 100));
        view().addSubview(segmentedControl3);
        UISegmentedControl segmentedControl4 = UISegmentedControl.alloc().initWithItems(arrayImageItems1);
        segmentedControl4.setFrame(CoreGraphics.CGRectMake(30, 400, 300, 90));
        view().addSubview(segmentedControl4);

        testNumberOfSegments1 = (segmentedControl3.numberOfSegments() == 4 && segmentedControl4.numberOfSegments() == 3);
    }

    @Selector("testInsertSegments")
    public void testInsertSegments() {
        cleanView();

        UIImage image0 = UIImage.imageNamed("testImage0.png");
        UIImage image1 = UIImage.imageNamed("testImage1.png");
        UIImage image2 = UIImage.imageNamed("testImage2.png");
        UIImage image3 = UIImage.imageNamed("testImage3.png");
        UIImage image4 = UIImage.imageNamed("testImage4.png");
        NSString stringItem0 = NSString.stringWithString("Item0");
        NSString stringItem1 = NSString.stringWithString("Item1");
        NSString stringItem2 = NSString.stringWithString("Item2");
        NSString stringItem3 = NSString.stringWithString("Item3");
        NSString stringItem4 = NSString.stringWithString("Item4");

        NSArray arrayImage1 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(UIImage.class, new UIImage[]{
                        image0, image1
                }), 2);
        UISegmentedControl segmentedControl1 = UISegmentedControl.alloc().initWithItems(arrayImage1);
        UISegmentedControl segmentedControl2 = UISegmentedControl.alloc().initWithItems(arrayImage1);
        segmentedControl1.setFrame(CoreGraphics.CGRectMake(0, 0, 300, 80));
        segmentedControl2.setFrame(CoreGraphics.CGRectMake(0, 90, 300, 80));
        view().addSubview(segmentedControl1);
        view().addSubview(segmentedControl2);

        segmentedControl1.insertSegmentWithImageAtIndexAnimated(image2, 2, true);
        segmentedControl2.insertSegmentWithImageAtIndexAnimated(image3, 0, false);
        segmentedControl2.insertSegmentWithImageAtIndexAnimated(image4, 15, false);
        testInsertSegmentWithImage_atIndex_animated1 = (segmentedControl1.numberOfSegments() == 3
                && segmentedControl2.numberOfSegments() == 4
                && segmentedControl1.imageForSegmentAtIndex(2) == image2
                && segmentedControl2.imageForSegmentAtIndex(0) == image3
                && segmentedControl2.imageForSegmentAtIndex(3) == image4);

        NSArray arrayString1 = NSArray.arrayWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem0, stringItem1
                }), 2);
        UISegmentedControl segmentedControl3 = UISegmentedControl.alloc().initWithItems(arrayString1);
        UISegmentedControl segmentedControl4 = UISegmentedControl.alloc().initWithItems(arrayString1);
        segmentedControl3.setFrame(CoreGraphics.CGRectMake(0, 190, 300, 80));
        segmentedControl4.setFrame(CoreGraphics.CGRectMake(0, 310, 200, 80));
        view().addSubview(segmentedControl3);
        view().addSubview(segmentedControl4);

        segmentedControl3.insertSegmentWithTitleAtIndexAnimated(stringItem2.toString(), 2, true);
        segmentedControl4.insertSegmentWithTitleAtIndexAnimated(stringItem3.toString(), 0, false);
        segmentedControl4.insertSegmentWithTitleAtIndexAnimated(stringItem4.toString(), 15, false);

        String titleItem2 = segmentedControl3.titleForSegmentAtIndex(2);
        String titleItem3 = segmentedControl4.titleForSegmentAtIndex(0);
        String titleItem4 = segmentedControl4.titleForSegmentAtIndex(3);
        testInsertSegmentWithText_atIndex_animated2 = (segmentedControl1.numberOfSegments() == 3
                && segmentedControl2.numberOfSegments() == 4
                && titleItem2.equals(stringItem2.toString())
                && titleItem3.equals(stringItem3.toString())
                && titleItem4.equals(stringItem4.toString()));
    }

    @Selector("testRemoveSegments")
    public void testRemoveSegments() {
        cleanView();

        NSString stringItem0 = NSString.stringWithString("Item0");
        NSString stringItem1 = NSString.stringWithString("Item1");
        NSString stringItem2 = NSString.stringWithString("Item2");
        NSString stringItem3 = NSString.stringWithString("Item3");
        NSString stringItem4 = NSString.stringWithString("Item4");

        NSArray arrayString2 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem0, stringItem1, stringItem2, stringItem3, stringItem4
                }), 5);
        UISegmentedControl segmentedControl5 = UISegmentedControl.alloc().initWithItems(arrayString2);
        segmentedControl5.setFrame(CoreGraphics.CGRectMake(0, 10, 200, 50));
        view().addSubview(segmentedControl5);
        segmentedControl5.removeAllSegments();

        testRemoveAllSegments1 = (segmentedControl5.numberOfSegments() == 0);

        NSArray arrayString3 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem0, stringItem1, stringItem2, stringItem3, stringItem4
                }), 5);
        UISegmentedControl segmentedControl6 = UISegmentedControl.alloc().initWithItems(arrayString3);
        segmentedControl6.setFrame(CoreGraphics.CGRectMake(0, 100, 300, 50));
        view().addSubview(segmentedControl6);
        segmentedControl6.removeSegmentAtIndexAnimated(2, false);
        String title2Control6 = segmentedControl6.titleForSegmentAtIndex(2);
        testRemoveSegmentAtIndex_animated1 = (segmentedControl6.numberOfSegments() == 4
                && title2Control6.equals(stringItem3.toString()));

        NSArray arrayString4 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        stringItem0, stringItem1, stringItem2, stringItem3, stringItem4
                }), 5);
        UISegmentedControl segmentedControl7 = UISegmentedControl.alloc().initWithItems(arrayString4);
        segmentedControl7.setFrame(CoreGraphics.CGRectMake(0, 200, 300, 50));
        view().addSubview(segmentedControl7);
        segmentedControl7.removeSegmentAtIndexAnimated(2, true);
        testRemoveSegmentAtIndex_animated2 = (segmentedControl7.numberOfSegments() == 4);
    }

    @Selector("testEnabled")
    public void testEnabled() {
        cleanView();
        UIImage image0 = UIImage.imageNamed("testImage0.png");
        UIImage image1 = UIImage.imageNamed("testImage1.png");
        UIImage image2 = UIImage.imageNamed("testImage2.png");
        UIImage image3 = UIImage.imageNamed("testImage3.png");
        UIImage image4 = UIImage.imageNamed("testImage4.png");
        NSString stringItem0 = NSString.stringWithString("Item0");
        NSString stringItem1 = NSString.stringWithString("Item1");
        NSString stringItem2 = NSString.stringWithString("Item2");
        NSString stringItem3 = NSString.stringWithString("Item3");
        NSString stringItem4 = NSString.stringWithString("Item4");

        NSArray array1 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSObject.class, new NSObject[]{
                        stringItem0, stringItem1, stringItem2, image0
                }), 4);
        UISegmentedControl segmentedControl1 = UISegmentedControl.alloc().initWithItems(array1);
        segmentedControl1.setFrame(CoreGraphics.CGRectMake(10, 10, 300, 80));
        view().addSubview(segmentedControl1);
        testIsEnabled_forSegmentAtIndex1 = segmentedControl1.isEnabledForSegmentAtIndex(0);

        NSArray array2 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSObject.class, new NSObject[]{
                        stringItem3, stringItem4, image2, image1
                }), 4);
        UISegmentedControl segmentedControl2 = UISegmentedControl.alloc().initWithItems(array2);
        segmentedControl2.setFrame(CoreGraphics.CGRectMake(0, 100, 320, 70));
        segmentedControl2.setEnabledForSegmentAtIndex(false, 0);
        segmentedControl2.setEnabledForSegmentAtIndex(false, 1);
        segmentedControl2.setSelectedSegmentIndex(1);
        segmentedControl2.setEnabledForSegmentAtIndex(true, 1);

        NSArray array3 = NSArray.arrayWithObjectsCount(
                (Ptr)PtrFactory.newObjectArray(NSObject.class, new NSObject[]{
                        stringItem0, stringItem1, image3, image4
                }), 4);
        UISegmentedControl segmentedControl3 = UISegmentedControl.alloc().initWithItems(array3);
        segmentedControl3.setFrame(CoreGraphics.CGRectMake(0, 300, 320, 70));

        segmentedControl3.setEnabled(false);
        segmentedControl3.setSelectedSegmentIndex(3);
        segmentedControl3.setSelectedSegmentIndex(0);
        segmentedControl3.setEnabledForSegmentAtIndex(false, 0);
        segmentedControl3.setEnabledForSegmentAtIndex(true, 0);
        segmentedControl3.setEnabledForSegmentAtIndex(true, 1);
        segmentedControl3.setEnabledForSegmentAtIndex(false, 2);

        view().addSubview(segmentedControl2);
        view().addSubview(segmentedControl3);

        System.out.println(!segmentedControl2.isEnabledForSegmentAtIndex(0));
        System.out.println(segmentedControl2.isEnabledForSegmentAtIndex(1));
        System.out.println(!segmentedControl3.isEnabled());
        System.out.println(segmentedControl3.isEnabledForSegmentAtIndex(0));
        System.out.println(segmentedControl3.isEnabledForSegmentAtIndex(1));
        System.out.println(!segmentedControl3.isEnabledForSegmentAtIndex(2));
        System.out.println(segmentedControl3.isEnabledForSegmentAtIndex(3));
        System.out.println(segmentedControl2.selectedSegmentIndex());
        System.out.println(segmentedControl3.selectedSegmentIndex());
        
        testSetEnabled_forSegmentAtIndex1 = (!segmentedControl2.isEnabledForSegmentAtIndex(0)
                && segmentedControl2.isEnabledForSegmentAtIndex(1)
                && !segmentedControl3.isEnabled()
                && segmentedControl3.isEnabledForSegmentAtIndex(0)
                && segmentedControl3.isEnabledForSegmentAtIndex(1)
                && !segmentedControl3.isEnabledForSegmentAtIndex(2)
                && segmentedControl3.isEnabledForSegmentAtIndex(3)
                && segmentedControl2.selectedSegmentIndex() == 1
                && segmentedControl3.selectedSegmentIndex() == Enums.UISegmentedControlNoSegment) ;

        segmentedControl2.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = !segmentedControl2.isUserInteractionEnabled();
    }

}
