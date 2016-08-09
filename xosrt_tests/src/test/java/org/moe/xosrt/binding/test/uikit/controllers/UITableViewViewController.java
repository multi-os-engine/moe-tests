package org.moe.xosrt.binding.test.uikit.controllers;

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
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.enums.UITableViewRowAnimation;
import ios.uikit.enums.UITableViewScrollPosition;
import ios.uikit.enums.UITableViewStyle;
import ios.uikit.protocol.UITableViewDataSource;
import ios.uikit.protocol.UITableViewDelegate;

public class UITableViewViewController extends UIViewController implements UITableViewDelegate, UITableViewDataSource {

    static {
        NatJ.register();
    }

    protected UITableViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITableViewViewController alloc();

    @Selector("init")
    public native UITableViewViewController init();

    NSMutableArray primaryColors;
    NSMutableArray secondaryColors;
    NSMutableArray sections;
    UITableView  myTableView;
    UIView  newView;

    public static volatile boolean testInsertRowsAtIndexPaths_withRowAnimation1 = false;
    public static volatile boolean testDeleteRowsAtIndexPaths_withRowAnimation1 = false;
    public static volatile boolean testSelectRowAtIndexPath_animated_scrollPosition1 = false;
    public static volatile boolean testDeselectRowAtIndexPath_animated1 = false;
    public static volatile boolean testIndexPathForSelectedRow1 = false;
    public static volatile boolean testAllowsSelection1 = false;
    public static volatile boolean testInitWithFrame_style1 = false;
    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testDataSource1 = false;
    public static volatile boolean testReloadData1 = false;
    public static volatile boolean testRowHeight1 = false;
    public static volatile boolean testSectionHeaderHeight1 = false;


    @Selector("numberOfSectionsInTableView")
    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        return sections.count();
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

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, @org.moe.natj.general.ann.NInt long section) {
        if (section == 0) {
            return primaryColors.count();
        }
        if (section == 1) {
            return secondaryColors.count();
        }
        return 0;
    }

    @Override
    public long tableViewSectionForSectionIndexTitleAtIndex(UITableView uiTableView, String s, long l) {
        return 0;
    }

    @Override
    public String tableViewTitleForFooterInSection(UITableView uiTableView, long l) {
        return null;
    }

    @Selector("tableView:titleForHeaderInSection:")
    @Override
    public String tableViewTitleForHeaderInSection(UITableView tableView, long section) {
        String sectionHeader = "";
        if (section == 0) {
            sectionHeader = "Primary Colors";
        }
        if (section == 1) {
            sectionHeader = "Secondary Colors";
        }
        return sectionHeader;
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        String cellIdentifier = "Cell";

        UITableViewCell cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(UITableViewCellStyle.Default, cellIdentifier);

        if (indexPath.section() == 0) {
            cell.textLabel().setText((String)primaryColors.objectAtIndex(indexPath.row()));
        } else {
            cell.textLabel().setText((String)secondaryColors.objectAtIndex(indexPath.row()));
        }
        return cell;
    }

    @Override
    public void tableViewCommitEditingStyleForRowAtIndexPath(UITableView uiTableView, long l, NSIndexPath nsIndexPath) {

    }

    @Override
    public void tableViewMoveRowAtIndexPathToIndexPath(UITableView uiTableView, NSIndexPath nsIndexPath, NSIndexPath nsIndexPath1) {

    }

    public void testDataModifications() {
        NSIndexPath indexP = NSIndexPath.indexPathForRowInSection(primaryColors.count(), 0);
        primaryColors.addObject(NSString.stringWithString("another color"));
        NSArray indexes = NSArray.arrayWithObject(indexP);
        myTableView.insertRowsAtIndexPathsWithRowAnimation(indexes, UITableViewRowAnimation.None);
        testInsertRowsAtIndexPaths_withRowAnimation1 = (myTableView.numberOfRowsInSection(0) == 4);

        NSIndexPath indexDelPath = NSIndexPath.indexPathForRowInSection(primaryColors.count() - 1, 0);
        NSArray indexesDel = NSArray.arrayWithObject(indexDelPath);
        primaryColors.removeObjectAtIndex(3);
        myTableView.deleteRowsAtIndexPathsWithRowAnimation(indexesDel, UITableViewRowAnimation.None);
        testDeleteRowsAtIndexPaths_withRowAnimation1 = (myTableView.numberOfRowsInSection(0) == 3);

        NSIndexPath indexSelPath = NSIndexPath.indexPathForRowInSection(primaryColors.count() - 1, 1);
        myTableView.selectRowAtIndexPathAnimatedScrollPosition(indexSelPath, false, UITableViewScrollPosition.None);
        NSIndexPath temp = myTableView.indexPathForSelectedRow();
        testSelectRowAtIndexPath_animated_scrollPosition1 = (temp.section() == indexSelPath.section() && temp.row() == indexSelPath.row());

        if (temp.section() == indexSelPath.section() && temp.row() == indexSelPath.row()) {
            myTableView.deselectRowAtIndexPathAnimated(indexSelPath, false);
            NSIndexPath temp2 = myTableView.indexPathForSelectedRow();
            testDeselectRowAtIndexPath_animated1 = (temp2 == null);
        }

        NSIndexPath indexSelPath2 = NSIndexPath.indexPathForRowInSection(primaryColors.count() - 1, 0);
        myTableView.selectRowAtIndexPathAnimatedScrollPosition(indexSelPath2, false, UITableViewScrollPosition.None);
        NSIndexPath temp3 = myTableView.indexPathForSelectedRow();
        testIndexPathForSelectedRow1 = (temp3 != null && temp3.section() == indexSelPath2.section()
                && temp3.row() == indexSelPath2.row());

        myTableView.setAllowsSelection(false);
        testAllowsSelection1 = (!myTableView.allowsSelection());
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

    @Selector("tableView:didSelectRowAtIndexPath:")
    @Override
    public void tableViewDidSelectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {

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

    @Selector("tableView:heightForHeaderInSection:")
    @Override
    public double tableViewHeightForHeaderInSection(UITableView tableView,  long section) {
        return 40;
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

    public void testMethod() {
        CGRect newFrame = CoreGraphics.CGRectMake(0, 0, 310, 460);
        myTableView = UITableView.alloc().initWithFrameStyle(newFrame, UITableViewStyle.Grouped);
        testInitWithFrame_style1 =  (myTableView != null) ;

        myTableView.setDelegate(this);
        testDelegate1 = (myTableView.delegate() == this);

        myTableView.setDataSource(this);
        testDataSource1 =  (myTableView.dataSource() == this);

        secondaryColors.addObject(NSString.stringWithString("OtherColor"));
        myTableView.reloadData();
        testReloadData1 =  (myTableView.numberOfRowsInSection(1) == 3);

        myTableView.setRowHeight(50.0);
        testRowHeight1 = (myTableView.rowHeight() == 50.0);

        myTableView.setSectionHeaderHeight(40.0);
        testSectionHeaderHeight1 = (myTableView.sectionHeaderHeight() == 40.0);

        newView.addSubview(myTableView);
    }


    @Selector("loadView")
    @Override
    public void loadView() {
        newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 320, 480));
        newView.setBackgroundColor(UIColor.grayColor());

        primaryColors = NSMutableArray.alloc().initWithCapacity(5);
        primaryColors.addObject(NSString.stringWithString("Blue"));
        primaryColors.addObject(NSString.stringWithString("Red"));
        primaryColors.addObject(NSString.stringWithString("Yellow"));

        secondaryColors = NSMutableArray.alloc().initWithCapacity(5);
        secondaryColors.addObject(NSString.stringWithString("Green"));
        secondaryColors.addObject(NSString.stringWithString("Orange"));

        sections = NSMutableArray.alloc().initWithCapacity(5);
        sections.addObject(NSString.stringWithString("Primary Colors"));
        sections.addObject(NSString.stringWithString("Secondary Colors"));

        setView(newView);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testMethod();
        testDataModifications();
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
