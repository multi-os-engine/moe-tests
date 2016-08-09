package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.testhelpers.UIPopoverDetailViewController;
import org.moe.xosrt.binding.test.uikit.testhelpers.UIPopoverNewViewController;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.enums.UITableViewScrollPosition;
import ios.uikit.enums.UITableViewStyle;

public class UIPopoverControllerViewController extends UITableViewController {

    static {
        NatJ.register();
    }

    protected UIPopoverControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UIPopoverControllerViewController alloc();

    @Selector("init")
    public native UIPopoverControllerViewController init();

    public NSMutableArray colors;
    public UIPopoverDetailViewController detailViewController;	// TODO Never initialized

    public static volatile boolean testSetPopoverContentSize_animated1 = false;
    public static volatile boolean testSetContentViewController_animated1 = false;
    public static volatile boolean testDismissPopoverAnimated1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        String  white = "Red";
        String  blue = "Blue";

        colors = NSMutableArray.alloc().initWithCapacity(5);
        colors.addObject(white);
        colors.addObject(blue);

        UIView newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 319, 200));
        newView.setBackgroundColor(UIColor.whiteColor());

        UITableView newTableView = UITableView.alloc().initWithFrameStyle(CoreGraphics.CGRectMake(0,20, 319, 200), UITableViewStyle.Grouped);
        newTableView.setDelegate(this);
        newTableView.setDataSource(this);
        newTableView.setTag(1);

        newView.addSubview(newTableView);

        setView(newView);

    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        UITableView newTableView = (UITableView) view().viewWithTag(1);
        NSIndexPath indexSelPath = NSIndexPath.indexPathForRowInSection(colors.count() - 1, 0);

        newTableView.selectRowAtIndexPathAnimatedScrollPosition(indexSelPath, true, UITableViewScrollPosition.None);

        ((UITableViewController)newTableView.delegate()).tableViewDidSelectRowAtIndexPath(newTableView, indexSelPath);
    }

    @Selector("numberOfSectionsInTableView:")
    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        // Return the number of sections.
        return 1;
    }

    @Selector("tableView:titleForHeaderInSection:")
    @Override
    public String tableViewTitleForHeaderInSection(UITableView var1, long var2) {
        return "Colors";
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView var1, long var2) {
        // Return the number of rows in the section.
        return colors.count();
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView var1, NSIndexPath indexPath) {
        String CellIdentifier = "Cell";
        UITableViewCell cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(UITableViewCellStyle.Default, CellIdentifier);

        // Configure the cell...
        String newText = (String)colors.objectAtIndex(indexPath.row());

        cell.textLabel().setText(newText);
        return cell;
    }

    @Selector("tableView:didSelectRowAtIndexPath:")
    @Override
    public void tableViewDidSelectRowAtIndexPath(UITableView var1, NSIndexPath indexPath) {
        long row = indexPath.row();
        UILabel label = (UILabel)detailViewController.view().viewWithTag(1);

        if (row == 0) {
            label.setText("Red");
        }
        if (row == 1) {
            label.setText("Blue");
        }

        detailViewController.popoverController.setPopoverContentSizeAnimated(CoreGraphics.CGSizeMake(250, 200), true);
        performSelectorWithObjectAfterDelay(new SEL("setContentViewController_animated"), null, 2);
    }

    @Selector("setContentViewController_animated")
    public void setContentViewController_animated() {
        CGSize size = detailViewController.popoverController.popoverContentSize();
        testSetPopoverContentSize_animated1 = (size.width() == 250 && size.height() == 200) ;

        UIPopoverNewViewController controller = UIPopoverNewViewController.alloc().init();
        detailViewController.popoverController.setContentViewControllerAnimated(controller, true);

        testSetContentViewController_animated1 = (detailViewController.popoverController.contentViewController() == controller) ;

        performSelectorWithObjectAfterDelay(new SEL("closePopover"), null, 2);
    }

    @Selector("closePopover")
    public void closePopover() {
        detailViewController.popoverController.dismissPopoverAnimated(true);
        testDismissPopoverAnimated1 =  (!detailViewController.popoverController.isPopoverVisible()) ;
    }
}
