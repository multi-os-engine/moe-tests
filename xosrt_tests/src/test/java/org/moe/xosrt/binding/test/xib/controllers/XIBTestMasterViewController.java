package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UIBarButtonSystemItem;
import ios.uikit.enums.UIInterfaceOrientation;
import ios.uikit.enums.UITableViewCellAccessoryType;
import ios.uikit.enums.UITableViewCellEditingStyle;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.enums.UITableViewRowAnimation;
import ios.uikit.enums.UIUserInterfaceIdiom;

public class XIBTestMasterViewController extends UITableViewController {

    static {
        NatJ.register();
    }

    protected XIBTestMasterViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestMasterViewController alloc();

    @Selector("init")
    public native XIBTestMasterViewController init();


    public static volatile boolean testMasterDetailApplication441Test1 = false;

    NSMutableArray _objects = null;
    public XIBTestDetailViewController detailViewController = null;

    @Selector("initWithNibName:bundle:")
    @Override
    public UITableViewController initWithNibNameBundle(String nibNameOrNil, NSBundle nibBundleOrNil) {
        super.initWithNibNameBundle(nibNameOrNil, nibBundleOrNil);
        setTitle("Master");
        return this;
    }

    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        // Do any additional setup after loading the view, typically from a nib.
        navigationItem().setLeftBarButtonItem(editButtonItem());
        _objects = NSMutableArray.alloc().init();
        UIBarButtonItem addButton = UIBarButtonItem.alloc().initWithBarButtonSystemItemTargetAction(
                UIBarButtonSystemItem.Add, this, new SEL("insertNewObject:"));
        navigationItem().setRightBarButtonItem(addButton);
        testMasterDetailApplication441Test1 = true;
    }

    public void viewDidUnload() {
        super.viewDidUnload();
    }

    @Selector("shouldAutorotateToInterfaceOrientation:")
    @Override
    public boolean shouldAutorotateToInterfaceOrientation(long interfaceOrientation) {
        if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {
            return (interfaceOrientation != UIInterfaceOrientation.PortraitUpsideDown);
        }
        return true;
    }

    @Selector("insertNewObject:")
    public void insertNewObject(Object sender) {
        if (_objects == null) {
            _objects = NSMutableArray.alloc().init();
        }
        _objects.insertObjectAtIndex(NSDate.date(), 0);
        NSIndexPath indexPath = NSIndexPath.indexPathForRowInSection(0, 0);
        //TODO: indexPath should be converted to NSArray properly
        this.tableView().insertRowsAtIndexPathsWithRowAnimation(
                (NSArray<NSIndexPath>)NSArray.<NSIndexPath>arrayWithObject(indexPath),
                UITableViewRowAnimation.Automatic);
    }

    @Selector("numberOfSectionsInTableView:")
    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        return 1;
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        return _objects.count();
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        String CellIdentifier = "Cell";

        UITableViewCell cell = (UITableViewCell)tableView.dequeueReusableCellWithIdentifier(CellIdentifier);
        if (cell == null) {
            cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(
                    UITableViewCellStyle.Default, CellIdentifier);
            if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {
                cell.setAccessoryType(UITableViewCellAccessoryType.DisclosureIndicator);
            }
        }

        NSDate object = (NSDate)_objects.objectAtIndex(indexPath.row());
        cell.textLabel().setText(object.description());
        return cell;
    }

    @Selector("tableView:canEditRowAtIndexPath:")
    @Override
    public boolean tableViewCanEditRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        // Return NO if you do not want the specified item to be editable.
        return true;
    }

    @Selector("tableView:commitEditingStyle:forRowAtIndexPath:")
    @Override
    public void tableViewCommitEditingStyleForRowAtIndexPath(UITableView tableView, long editingStyle, NSIndexPath indexPath) {
        if (editingStyle == UITableViewCellEditingStyle.Delete) {
            _objects.removeObjectAtIndex(indexPath.row());
            //TODO: indexPath should be converted to NSArray
            tableView.deleteRowsAtIndexPathsWithRowAnimation(
                    (NSArray<NSIndexPath>)NSArray.<NSIndexPath>arrayWithObject(indexPath),
                    UITableViewRowAnimation.Fade);
        } else if (editingStyle == UITableViewCellEditingStyle.Insert) {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view.
        }
    }

    @Selector("tableView:didSelectRowAtIndexPath:")
    @Override
    public void tableViewDidSelectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        NSDate object = (NSDate)_objects.objectAtIndex(indexPath.row());
        if (UIDevice.currentDevice().userInterfaceIdiom() == UIUserInterfaceIdiom.Phone) {
            if (detailViewController == null) {
                detailViewController = (XIBTestDetailViewController)XIBTestDetailViewController.alloc()
                        .initWithNibNameBundle("DetailViewController_iPhone", null);
            }
            detailViewController.setDetailItem(object);
            navigationController().pushViewControllerAnimated(detailViewController, true);
        } else {
            detailViewController.setDetailItem(object);
        }
    }

}
