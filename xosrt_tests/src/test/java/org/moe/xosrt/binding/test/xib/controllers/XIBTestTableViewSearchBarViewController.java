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
import ios.foundation.struct.NSRange;
import ios.uikit.*;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.protocol.UISearchBarDelegate;
import ios.uikit.protocol.UITableViewDataSource;
import ios.uikit.protocol.UITableViewDelegate;

public class XIBTestTableViewSearchBarViewController extends UIViewController implements
        UITableViewDelegate, UITableViewDataSource, UISearchBarDelegate {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewSearchBarViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewSearchBarViewController alloc();

    @Selector("init")
    public native XIBTestTableViewSearchBarViewController init();

    
    public static volatile boolean testSearchBarDelegateMethodCalled = false;
    public static volatile boolean testTableViewCellForRowAtIndexPathCalled = false;
    public static volatile boolean testTableViewHeightForRowAtIndexPathCalled = false;
    public static volatile boolean testTableNumberOfRowsInSectionCalled = false;

    NSArray _tableData;
    NSArray filteredData;
    UISearchBar searchBar;
    UITableView tableView;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "searchBar":
                searchBar = (UISearchBar)value;
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
            case "searchBar":
                return searchBar;
            case "tableView":
                return tableView;
            default:
                return super.valueForKey(key);
        }
    }

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        _tableData = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        NSString.stringWithString("One"),
                        NSString.stringWithString("Two"),
                        NSString.stringWithString("Three"),
                        NSString.stringWithString("Four"),
                        NSString.stringWithString("Five"),
                        NSString.stringWithString("Six"),
                        NSString.stringWithString("Seven"),
                        NSString.stringWithString("Eight"),
                        NSString.stringWithString("Nine"),
                        NSString.stringWithString("Ten"),
                        NSString.stringWithString("Eleven"),
                        NSString.stringWithString("Twelve")
                }), 12);
        filteredData = _tableData;

        searchBarTextDidChange(searchBar, "S");
    }

    public void viewDidUnload() {
        super.viewDidUnload();
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
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

    @Selector("tableView:heightForRowAtIndexPath:")
    @Override
    public double tableViewHeightForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        testTableViewHeightForRowAtIndexPathCalled = true;
        return 20;
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

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        testTableNumberOfRowsInSectionCalled = true;
        return  filteredData.count();
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

        UITableViewCell cell = (UITableViewCell)tableView.dequeueReusableCellWithIdentifier("cellIdentifier");
        if (cell == null) {
            cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(
                    UITableViewCellStyle.Default, "cellIdentifier");
        }
        cell.textLabel().setText((String) filteredData.objectAtIndex(indexPath.row()));
        testTableViewCellForRowAtIndexPathCalled = true;
        return cell;
    }

    @Override
    public void tableViewCommitEditingStyleForRowAtIndexPath(UITableView uiTableView, long l, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewMoveRowAtIndexPathToIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath, NSIndexPath nsIndexPath1) {

    }

    @Override
    public void searchBarSelectedScopeButtonIndexDidChange(UISearchBar uiSearchBar, long l) {

    }

    @Override
    public boolean searchBarShouldChangeTextInRangeReplacementText(UISearchBar uiSearchBar, NSRange nsRange, String s) {
        return false;
    }

    @Selector("searchBar:textDidChange:")
    @Override
    public void searchBarTextDidChange(UISearchBar searchBar, String searchText) {

        if (searchText.length() > 0) {
            NSPredicate predicate = NSPredicate.predicateWithFormatArgumentArray(
                    "SELF CONTAINS %s", NSArray.arrayWithObject(NSString.stringWithString(searchText)));
            NSArray filtered = _tableData.filteredArrayUsingPredicate(predicate);

            filteredData = filtered;

            testSearchBarDelegateMethodCalled = true;
        } else {
            filteredData = _tableData;
        }
        tableView.reloadData();
    }

    @Override
    public void searchBarBookmarkButtonClicked(UISearchBar uiSearchBar) {

    }

    @Override
    public void searchBarCancelButtonClicked(UISearchBar uiSearchBar) {

    }

    @Override
    public void searchBarResultsListButtonClicked(UISearchBar uiSearchBar) {

    }

    @Override
    public void searchBarSearchButtonClicked(UISearchBar uiSearchBar) {

    }

    @Override
    public boolean searchBarShouldBeginEditing(UISearchBar uiSearchBar) {
        return false;
    }

    @Override
    public boolean searchBarShouldEndEditing(UISearchBar uiSearchBar) {
        return false;
    }

    @Override
    public void searchBarTextDidBeginEditing(UISearchBar uiSearchBar) {

    }

    @Override
    public void searchBarTextDidEndEditing(UISearchBar uiSearchBar) {

    }

    @Override
    public long positionForBar(Object o) {
        return 0;
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
