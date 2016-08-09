package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.testhelpers.UISplitDetailViewController;
import org.moe.xosrt.binding.test.uikit.testhelpers.UISplitRightViewController;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.enums.UITableViewStyle;
import ios.uikit.protocol.UISplitViewControllerDelegate;

public class UISplitViewControllerViewController extends UITableViewController implements UISplitViewControllerDelegate {

    static {
        NatJ.register();
    }

    protected UISplitViewControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UISplitViewControllerViewController alloc();

    @Selector("init")
    public native UISplitViewControllerViewController init();

    NSMutableArray colors;
    public UISplitViewController splitViewController;

    public static volatile boolean testViewControllers1 = false;
    public static volatile boolean testDelegate1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        NSString  white = NSString.stringWithString("Red");
        NSString  blue = NSString.stringWithString("Blue");

        colors = NSMutableArray.alloc().initWithCapacity(5);
        colors.addObject(white);
        colors.addObject(blue);

        UIView newView = UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0, 20, 319, 480));
        newView.setBackgroundColor(UIColor.whiteColor());

        UITableView newTableView = UITableView.alloc().initWithFrameStyle(CoreGraphics.CGRectMake(0,20, 319, 200), UITableViewStyle.Grouped);
        newTableView.setDelegate(this);
        newTableView.setDataSource(this);

        newView.addSubview(newTableView);

        setView(newView);

    }

    @Selector("numberOfSectionsInTableView:")
    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        return 1;
    }

    @Selector("tableView:titleForHeaderInSection:")
    @Override
    public String tableViewTitleForHeaderInSection(UITableView tableView, long section) {
        return "Colors";
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        return colors.count();
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        NSString CellIdentifier = NSString.stringWithString("Cell");
        UITableViewCell cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(UITableViewCellStyle.Default,
                CellIdentifier.toString());
        // Configure the cell...
        String newText = (String)colors.objectAtIndex(indexPath.row());
        cell.textLabel().setText(newText);

        return cell;
    }

    @Selector("tableView:didSelectRowAtIndexPath:")
    @Override
    public void tableViewDidSelectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
    System.out.println("tableViewDidSelectRowAtIndexPath");
        long row = indexPath.row();
        UIViewController detailViewController = null;

        if (row == 0) {
            UISplitRightViewController newDetailViewController = UISplitRightViewController.alloc().init();
            detailViewController = newDetailViewController;
        }

        if (row == 1) {
            UISplitDetailViewController newDetailViewController = UISplitDetailViewController.alloc().init();
            detailViewController = newDetailViewController;
        }

        NSArray viewControllers = NSArray.alloc().initWithObjectsCount(
                (Ptr) PtrFactory.newObjectArray(UIViewController.class, new UIViewController[]{
                        this, detailViewController
                }), 2);
        splitViewController.setViewControllers(viewControllers);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testViewControllers1 = (splitViewController.viewControllers() != null
                && splitViewController.viewControllers().count() == 2);

        splitViewController.setDelegate(this);

        testDelegate1 = (splitViewController.delegate() != null);
    }

    @Override
    public UIViewController primaryViewControllerForCollapsingSplitViewController(UISplitViewController uiSplitViewController) {
        return null;
    }

    @Override
    public UIViewController primaryViewControllerForExpandingSplitViewController(UISplitViewController uiSplitViewController) {
        return null;
    }

    @Override
    public boolean splitViewControllerCollapseSecondaryViewControllerOntoPrimaryViewController(UISplitViewController uiSplitViewController, UIViewController uiViewController, UIViewController uiViewController1) {
        return false;
    }

    @Override
    public void splitViewControllerPopoverControllerWillPresentViewController(UISplitViewController uiSplitViewController, UIPopoverController uiPopoverController, UIViewController uiViewController) {

    }

    @Override
    public UIViewController splitViewControllerSeparateSecondaryViewControllerFromPrimaryViewController(UISplitViewController uiSplitViewController, UIViewController uiViewController) {
        return null;
    }

    @Override
    public boolean splitViewControllerShouldHideViewControllerInOrientation(UISplitViewController uiSplitViewController, UIViewController uiViewController, long l) {
        return false;
    }

    @Override
    public boolean splitViewControllerShowDetailViewControllerSender(UISplitViewController uiSplitViewController, UIViewController uiViewController, Object o) {
        return false;
    }

    @Override
    public boolean splitViewControllerShowViewControllerSender(UISplitViewController uiSplitViewController, UIViewController uiViewController, Object o) {
        return false;
    }

    @Override
    public void splitViewControllerWillChangeToDisplayMode(UISplitViewController uiSplitViewController, long l) {

    }

    @Override
    public void splitViewControllerWillHideViewControllerWithBarButtonItemForPopoverController(UISplitViewController uiSplitViewController, UIViewController uiViewController, UIBarButtonItem uiBarButtonItem, UIPopoverController uiPopoverController) {

    }

    @Override
    public void splitViewControllerWillShowViewControllerInvalidatingBarButtonItem(UISplitViewController uiSplitViewController, UIViewController uiViewController, UIBarButtonItem uiBarButtonItem) {

    }

    @Override
    public long splitViewControllerPreferredInterfaceOrientationForPresentation(UISplitViewController uiSplitViewController) {
        return 0;
    }

    @Override
    public long splitViewControllerSupportedInterfaceOrientations(UISplitViewController uiSplitViewController) {
        return 0;
    }

    @Override
    public long targetDisplayModeForActionInSplitViewController(UISplitViewController uiSplitViewController) {
        return 0;
    }
}
