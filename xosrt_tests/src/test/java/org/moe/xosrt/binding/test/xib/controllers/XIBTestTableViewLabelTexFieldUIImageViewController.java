package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ObjCObject;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.protocol.UITableViewDataSource;
import ios.uikit.protocol.UITableViewDelegate;
import ios.uikit.protocol.UITextInputDelegate;

public class XIBTestTableViewLabelTexFieldUIImageViewController extends UIViewController implements
        UITableViewDelegate, UITableViewDataSource, UITextInputDelegate {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewLabelTexFieldUIImageViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewLabelTexFieldUIImageViewController alloc();

    @Selector("init")
    public native XIBTestTableViewLabelTexFieldUIImageViewController init();

    boolean  _wasCellSelected;
    boolean  _wasNumberOfRowsInSectionCalled;
    boolean  _wasCellForRowAtIndexPath;
    NSArray _data;
    


    UILabel label;
    UILabel writtenTextLabel;
    UITextField textField;
    UITableView tableView;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "label":
                label = (UILabel)value;
                break;
            case "writtenTextLabel":
                writtenTextLabel = (UILabel)value;
                break;
            case "textField":
                textField = (UITextField)value;
                break;
            case "tableView":
                tableView = (UITableView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "label":
                return label;
            case "writtenTextLabel":
                return writtenTextLabel;
            case "textField":
                return textField;
            case "tableView":
                return tableView;
            default:
                return super.valueForKey(key);
        }
    }

    public static volatile boolean testCellForRowAtIndex = false;
    public static volatile boolean testNumberOfRowsInSection = false;
    public static volatile boolean testIsImageInstantiated = false;
    public static volatile boolean testSelectionWillChange = false;
    public static volatile boolean testSelectionChanged = false;
    public static volatile boolean testTextWillChange = false;
    public static volatile boolean testTextDidChange = false;

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        // Do any additional setup after loading the view, typically from a nib. 
        _data = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        NSString.stringWithString("One"),
                        NSString.stringWithString("Two"),
                        NSString.stringWithString("Three")
        }), 3);

        /*
         * These lines were replaced because of invalid use of API.
         * From Apple documentation: https://developer.apple.com/library/ios/documentation/Cocoa/Reference/Foundation/Protocols/NSObject_Protocol/index.html#//apple_ref/occ/intfm/NSObject/performSelector:
         * Quote: For methods that return anything other than an object, use NSInvocation.
         */

        //performSelectorWithObject(new SEL("selectionWillChange:"), null);
        //performSelectorWithObject(new SEL("selectionDidChange:"), null);
        //performSelectorWithObject(new SEL("textWillChange:"), null);
        //performSelectorWithObject(new SEL("textDidChange:"), null);

        NSInvocation invocation = NSInvocation.invocationWithMethodSignature(NSMethodSignature.signatureWithObjCTypes("v@:@"));
        Ptr<ObjCObject> arg = PtrFactory.newObjectReference(ObjCObject.class);
        arg.set(null);
        invocation.setArgumentAtIndex(arg, 2);
        invocation.setSelector(new SEL("selectionWillChange:"));
        invocation.invokeWithTarget(this);
        invocation.setSelector(new SEL("selectionDidChange:"));
        invocation.invokeWithTarget(this);
        invocation.setSelector(new SEL("textWillChange:"));
        invocation.invokeWithTarget(this);
        invocation.setSelector(new SEL("textDidChange:"));
        invocation.invokeWithTarget(this);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testCellForRowAtIndex = _wasCellForRowAtIndexPath;

        testNumberOfRowsInSection = _wasNumberOfRowsInSectionCalled;
    }

    @Selector("selectionWillChange:")
    public void selectionWillChange(Object textInput) {
        testSelectionWillChange = true;
    }

    @Selector("selectionDidChange:")
    public void selectionDidChange(Object textInput) {
        testSelectionChanged = true;
    }

    @Selector("textWillChange:")
    public void textWillChange(Object textInput) {
        testTextWillChange = true;
    }

    @Selector("textDidChange:")
    public void textDidChange(Object textInput) {
        testTextDidChange = true;
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        _wasNumberOfRowsInSectionCalled = true;
        return _data.count();
    }

    @Override
    public long tableViewSectionForSectionIndexTitleAtIndex(UITableView uiTableView, String s, long l) {
        return 0;
    }

    @Override
    public String tableViewTitleForFooterInSection(UITableView uiTableView, long l) {
        return null;
    }

    @Override
    public String tableViewTitleForHeaderInSection(UITableView uiTableView, long l) {
        return null;
    }

    @Override
    public long numberOfSectionsInTableView(UITableView uiTableView) {
        return 0;
    }

    @Override
    public NSArray sectionIndexTitlesForTableView(UITableView uiTableView) {
        return null;
    }

    @Override
    public boolean tableViewCanEditRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return false;
    }

    @Override
    public boolean tableViewCanMoveRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return false;
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        UITableViewCell cell = (UITableViewCell)tableView.dequeueReusableCellWithIdentifier("CellIdentifier");

        if (cell == null) {
            cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(
                    UITableViewCellStyle.Default, "CellIdentifier");
        }
        cell.textLabel().setText((String)_data.objectAtIndex(indexPath.row()));

        UIImage image = UIImage.imageNamed("download.jpeg");
        cell.imageView().setImage(image);
        testIsImageInstantiated = (cell.imageView().image() != null);

        _wasCellForRowAtIndexPath = true;
        return cell;
    }

    @Override
    public void tableViewCommitEditingStyleForRowAtIndexPath(UITableView uiTableView, long l, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewMoveRowAtIndexPathToIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath, NSIndexPath nsIndexPath1) {

    }

    @Override
    public void tableViewAccessoryButtonTappedForRowWithIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {

    }

    @Override
    public long tableViewAccessoryTypeForRowWithIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return 0;
    }

    @Override
    public boolean tableViewCanPerformActionForRowAtIndexPathWithSender(UITableView uiTableView, SEL sel, NSIndexPath nsIndexPath, Object o) {
        return false;
    }

    @Override
    public void tableViewDidDeselectRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewDidEndDisplayingCellForRowAtIndexPath(UITableView uiTableView, UITableViewCell uiTableViewCell, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewDidEndDisplayingFooterViewForSection(UITableView uiTableView, UIView uiView, long l) {

    }

    @Override
    public void tableViewDidEndDisplayingHeaderViewForSection(UITableView uiTableView, UIView uiView, long l) {

    }

    @Override
    public void tableViewDidEndEditingRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewDidHighlightRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewDidSelectRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewDidUnhighlightRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {

    }

    @Override
    public NSArray tableViewEditActionsForRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return null;
    }

    @Override
    public long tableViewEditingStyleForRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return 0;
    }

    @Override
    public double tableViewEstimatedHeightForFooterInSection(UITableView uiTableView, long l) {
        return 0;
    }

    @Override
    public double tableViewEstimatedHeightForHeaderInSection(UITableView uiTableView, long l) {
        return 0;
    }

    @Override
    public double tableViewEstimatedHeightForRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return 0;
    }

    @Override
    public double tableViewHeightForFooterInSection(UITableView uiTableView, long l) {
        return 0;
    }

    @Override
    public double tableViewHeightForHeaderInSection(UITableView uiTableView, long l) {
        return 0;
    }

    @Override
    public double tableViewHeightForRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return 0;
    }

    @Override
    public long tableViewIndentationLevelForRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return 0;
    }

    @Override
    public void tableViewPerformActionForRowAtIndexPathWithSender(UITableView uiTableView, SEL sel, NSIndexPath nsIndexPath, Object o) {

    }

    @Override
    public boolean tableViewShouldHighlightRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return false;
    }

    @Override
    public boolean tableViewShouldIndentWhileEditingRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return false;
    }

    @Override
    public boolean tableViewShouldShowMenuForRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return false;
    }

    @Override
    public NSIndexPath tableViewTargetIndexPathForMoveFromRowAtIndexPathToProposedIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath, NSIndexPath nsIndexPath1) {
        return null;
    }

    @Override
    public String tableViewTitleForDeleteConfirmationButtonForRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return null;
    }

    @Override
    public UIView tableViewViewForFooterInSection(UITableView uiTableView, long l) {
        return null;
    }

    @Override
    public UIView tableViewViewForHeaderInSection(UITableView uiTableView, long l) {
        return null;
    }

    @Override
    public void tableViewWillBeginEditingRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {

    }

    @Override
    public NSIndexPath tableViewWillDeselectRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return null;
    }

    @Override
    public void tableViewWillDisplayCellForRowAtIndexPath(UITableView uiTableView, UITableViewCell uiTableViewCell, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewWillDisplayFooterViewForSection(UITableView uiTableView, UIView uiView, long l) {

    }

    @Override
    public void tableViewWillDisplayHeaderViewForSection(UITableView uiTableView, UIView uiView, long l) {

    }

    @Override
    public NSIndexPath tableViewWillSelectRowAtIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath) {
        return null;
    }

    @Override
    public void scrollViewDidEndDecelerating(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewDidEndDraggingWillDecelerate(UIScrollView uiScrollView, boolean b) {

    }

    @Override
    public void scrollViewDidEndScrollingAnimation(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewDidEndZoomingWithViewAtScale(UIScrollView uiScrollView, UIView uiView, double v) {

    }

    @Override
    public void scrollViewDidScroll(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewDidScrollToTop(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewDidZoom(UIScrollView uiScrollView) {

    }

    @Override
    public boolean scrollViewShouldScrollToTop(UIScrollView uiScrollView) {
        return false;
    }

    @Override
    public void scrollViewWillBeginDecelerating(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewWillBeginDragging(UIScrollView uiScrollView) {

    }

    @Override
    public void scrollViewWillBeginZoomingWithView(UIScrollView uiScrollView, UIView uiView) {

    }

    @Override
    public void scrollViewWillEndDraggingWithVelocityTargetContentOffset(UIScrollView uiScrollView, CGPoint cgPoint, CGPoint cgPoint1) {

    }

    @Override
    public UIView viewForZoomingInScrollView(UIScrollView uiScrollView) {
        return null;
    }
}
