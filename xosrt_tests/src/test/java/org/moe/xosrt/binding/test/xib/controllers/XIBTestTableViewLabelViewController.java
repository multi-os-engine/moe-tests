package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.coregraphics.struct.CGPoint;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.protocol.UITableViewDataSource;
import ios.uikit.protocol.UITableViewDelegate;

public class XIBTestTableViewLabelViewController extends UIViewController implements UITableViewDelegate, UITableViewDataSource {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewLabelViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewLabelViewController alloc();

    @Selector("init")
    public native XIBTestTableViewLabelViewController init();

    boolean  _wasCellSelected;
    boolean  _wasnumberOfRowsInSectionCalled;
    boolean  _wasCellForRowAtIndexPath;
    NSArray _data;
    UITableView _tableView;
    UILabel _label;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "tableView":
                _tableView = (UITableView)value;
                break;
            case "label":
                _label = (UILabel)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "tableView":
                return _tableView;
            case "label":
                return _label;
            default:
                return super.valueForKey(key);
        }
    }

    static final String kCellIdentifier = "CellIdentifier";

    public static volatile boolean testLabelTableViewCreationInstanced = false;
    public static volatile boolean testLabelTableViewCreationCorrectSize = false;
    public static volatile boolean testLabelTableViewCreationParentView = false;
    public static volatile boolean testLabelCreationInstanced = false;
    public static volatile boolean testLabelCreationCorectSize = false;
    public static volatile boolean testLabelCreationParentView = false;
    public static volatile boolean testLabelTableViewNumberOfRowsInSection = false;
    public static volatile boolean testLabelTableViewCellForRow = false;
    public static volatile boolean testLabelTableViewDelegateDidSelectCell = false;

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        _data = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        NSString.stringWithString("Uno"),
                        NSString.stringWithString("Dos"),
                        NSString.stringWithString("Tres"),
                        NSString.stringWithString("Cuatro"),
                        NSString.stringWithString("Cinco"),
                        NSString.stringWithString("Seis"),
                        NSString.stringWithString("Siete"),
                        NSString.stringWithString("Ocho"),
                        NSString.stringWithString("Nueve"),
                        NSString.stringWithString("Diez")
                }), 10);

        testLabelTableViewCreationInstanced = (_tableView != null);

        testLabelTableViewCreationCorrectSize = (_tableView.frame().origin().x() == 0 && _tableView.frame().origin().y() == 34
                && _tableView.frame().size().width() == 320 && _tableView.frame().size().height() == 426);

        testLabelTableViewCreationParentView = (_tableView.superview() == view());

        testLabelCreationInstanced = (_label != null);
        testLabelCreationCorectSize = (_label.frame().origin().x() == 38 && _label.frame().origin().y() == 5
                && _label.frame().size().width() == 234 && _label.frame().size().height() == 21);

        testLabelCreationParentView = (_label.superview() == view());
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        testLabelTableViewNumberOfRowsInSection = _wasnumberOfRowsInSectionCalled;

        testLabelTableViewCellForRow = _wasCellForRowAtIndexPath;

        ((UITableViewDelegate)_tableView.delegate()).tableViewDidSelectRowAtIndexPath(
                _tableView, NSIndexPath.indexPathForRowInSection(1, 0));

        testLabelTableViewDelegateDidSelectCell = _wasCellSelected;
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        _wasnumberOfRowsInSectionCalled = true;
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
        UITableViewCell cell = (UITableViewCell)_tableView.dequeueReusableCellWithIdentifier(kCellIdentifier);

        if (cell == null) {
            cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(
                    UITableViewCellStyle.Default, kCellIdentifier);
        }
        cell.textLabel().setText((String)_data.objectAtIndex(indexPath.row()));
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

    @Selector("tableView:didDeselectRowAtIndexPath:")
    @Override
    public void tableViewDidDeselectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        _label.setText((String) _data.objectAtIndex(indexPath.row()));
        _wasCellSelected = true;
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
