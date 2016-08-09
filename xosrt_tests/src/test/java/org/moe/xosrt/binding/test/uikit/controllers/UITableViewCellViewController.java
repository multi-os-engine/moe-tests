package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITableViewCellAccessoryType;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.enums.UITableViewStyle;
import ios.uikit.protocol.UITableViewDataSource;
import ios.uikit.protocol.UITableViewDelegate;

public class UITableViewCellViewController extends UIViewController implements UITableViewDelegate, UITableViewDataSource {

    static {
        NatJ.register();
    }

    protected UITableViewCellViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITableViewCellViewController alloc();

    @Selector("init")
    public native UITableViewCellViewController init();

    
    NSMutableArray colorNames;
    UITableView newTableView;
    UITableView newTableView1;
    UIView newView;
    UITableViewCell cellWhite;
    UITableViewCell cellBlue;
    boolean pass;

    public static volatile boolean testInitWithFrame_reuseIdentifier1 = false;
    public static volatile boolean testInitWithStyle_reuseIdentifier1 = false;
    public static volatile boolean testTestLabel1 = false;
    public static volatile boolean testContentView1 = false;
    public static volatile boolean testImageView1 = false;
    public static volatile boolean testDetailTextLabel1 = false;
    public static volatile boolean testAccessoryType1 = false;
    public static volatile boolean testSelected1 = false;

    @Selector("numberOfSectionsInTableView")
    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        return 1;
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

    @Selector("tableView:titleForHeaderInSection:")
    @Override
    public String tableViewTitleForHeaderInSection(UITableView tableView , long section) {
        return "Colors";
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        return colorNames.count();
    }

    @Override
    public long tableViewSectionForSectionIndexTitleAtIndex(UITableView uiTableView, String s, long l) {
        return 0;
    }

    @Override
    public String tableViewTitleForFooterInSection(UITableView uiTableView, long l) {
        return null;
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {

        String cellIdentifier = "Cell";
        UITableViewCell cell;

        if (newTableView != null && !pass) {
            cell = UITableViewCell.alloc().initWithFrameReuseIdentifier(CoreGraphics.CGRectZero(), cellIdentifier);
            testInitWithFrame_reuseIdentifier1 = (cell != null);
        }
        pass = true;
        cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(UITableViewCellStyle.Default, cellIdentifier);
        String newText = (String)colorNames.objectAtIndex(indexPath.row());

        if (indexPath.row() == 0) {
            testInitWithStyle_reuseIdentifier1 = (cell != null);

            cell.textLabel().setText(newText);
            testTestLabel1 = (cell.textLabel() != null && cell.textLabel().text().equals(newText));

            testContentView1 = (cell.contentView() != null);

            UIImage cellImage = UIImage.imageNamed("images.jpeg");
            if (cell.imageView() != null) {
                cell.imageView().setImage(cellImage);
                testImageView1 = (cell.imageView().image() != null && cell.imageView().image() == cellImage);
            }
        } else {
            cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(UITableViewCellStyle.Subtitle, cellIdentifier);
            cell.textLabel().setText(newText);
            String subTitle = "Has subTitle";
            cell.detailTextLabel().setText(subTitle);
            testDetailTextLabel1 = (cell.detailTextLabel() != null && cell.detailTextLabel().text().equals(subTitle));

            cell.setAccessoryType(UITableViewCellAccessoryType.Checkmark);
            testAccessoryType1 = (cell.accessoryType() == UITableViewCellAccessoryType.Checkmark);
            cell.setSelected(true);
            testSelected1 = cell.isSelected();
        }
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

    @Override
    public double tableViewHeightForHeaderInSection(UITableView uiTableView, long l) {
        return 0;
    }

    @Selector("tableView:heightForRowAtIndexPath:")
    @Override
    public double tableViewHeightForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        return 50;
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

    @Selector("loadView")
    @Override
    public void loadView() {
        NSString  white = NSString.stringWithString("White (T1)");
        NSString  blue = NSString.stringWithString("Blue (T2)");

        colorNames = NSMutableArray.alloc().initWithCapacity(5);
        colorNames.addObject(white);
        colorNames.addObject(blue);


        newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 319, 480));
        newView.setBackgroundColor(UIColor.whiteColor());

        newTableView = UITableView.alloc().initWithFrameStyle(CoreGraphics.CGRectMake(0,20, 319, 200), UITableViewStyle.Grouped);
        newTableView.setDelegate(this);
        newTableView.setDataSource(this);

        newTableView1 = UITableView.alloc().initWithFrameStyle(CoreGraphics.CGRectMake(0,20, 319, 200), UITableViewStyle.Grouped);
        newTableView1.setDelegate(this);
        newTableView1.setDataSource(this);

        pass = false;

        newView.addSubview(newTableView);

        setView(newView);
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
