package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIControlEvents;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.protocol.UITableViewDataSource;
import ios.uikit.protocol.UITableViewDelegate;

public class XIBTestTableViewLabelTexFieldViewController extends UIViewController implements UITableViewDelegate, UITableViewDataSource {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewLabelTexFieldViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewLabelTexFieldViewController alloc();

    @Selector("init")
    public native XIBTestTableViewLabelTexFieldViewController init();

    boolean  _wasCellSelected;
    boolean  _wasNumberOfRowsInSectionCalled;
    boolean  _wasCellForRowAtIndexPath;
    NSArray _data;
    
    //     boolean  _selectionWillChange;
    //     boolean  _selectionChanged;
    //     boolean  _textWillChange;
    //     boolean  _textDidChange;


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
    public static volatile boolean testEditingDidBegin = false;
    public static volatile boolean testEditingChanged = false;
    public static volatile boolean testEditingDidEnd = false;
    public static volatile boolean testEditingDidEndOnExit = false;

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

        textField.addTargetActionForControlEvents(this, new SEL("editingDidBegin"), UIControlEvents.EditingDidBegin);
        textField.addTargetActionForControlEvents(this, new SEL("editingChanged"), UIControlEvents.EditingChanged);
        textField.addTargetActionForControlEvents(this, new SEL("editingDidEnd"), UIControlEvents.EditingDidEnd);
        textField.addTargetActionForControlEvents(this, new SEL("editingDidEndOnExit"), UIControlEvents.EditingDidEndOnExit);

    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        textField.sendActionsForControlEvents(UIControlEvents.EditingDidBegin);
        textField.sendActionsForControlEvents(UIControlEvents.EditingChanged);
        textField.sendActionsForControlEvents(UIControlEvents.EditingDidEnd);
        textField.sendActionsForControlEvents(UIControlEvents.EditingDidEndOnExit);

        testCellForRowAtIndex = _wasCellForRowAtIndexPath;

        testNumberOfRowsInSection = _wasNumberOfRowsInSectionCalled;
    }

    @Selector("editingDidBegin")
    public void editingDidBegin() {
        testEditingDidBegin = true;
    }

    @Selector("editingChanged")
    public void editingChanged() {
        testEditingChanged = true;
    }

    @Selector("editingDidEnd")
    public void editingDidEnd() {
        testEditingDidEnd = true;
    }

    @Selector("editingDidEndOnExit")
    public void editingDidEndOnExit() {
        testEditingDidEndOnExit = true;
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
        cell.textLabel().setText((String) _data.objectAtIndex(indexPath.row()));
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
