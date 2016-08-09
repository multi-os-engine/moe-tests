package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITableViewCellStyle;

public class XIBTestTableViewViewController extends UITableViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewViewController alloc();

    @Selector("init")
    public native XIBTestTableViewViewController init();

    
    NSMutableArray primaryColors;
    NSMutableArray secondaryColors;
    NSMutableArray sections;

    public static volatile boolean testFrame1 = false;
    public static volatile boolean testAlpha1 = false;

    @Selector("viewWillAppear:")
    @Override
    public void viewWillAppear(boolean animated) {
        primaryColors = NSMutableArray.alloc().initWithCapacity(5);
        primaryColors.addObject(NSString.stringWithString("Blue"));
        primaryColors.addObject(NSString.stringWithString("Red"));
        primaryColors.addObject(NSString.stringWithString("Yelow"));

        secondaryColors = NSMutableArray.alloc().initWithCapacity(5);
        secondaryColors.addObject(NSString.stringWithString("Green"));
        secondaryColors.addObject(NSString.stringWithString("Orange"));

        sections = NSMutableArray.alloc().initWithCapacity(5);
        sections.addObject(NSString.stringWithString("Primary Colors"));
        sections.addObject(NSString.stringWithString("Secondary Colors"));

        super.viewWillAppear(animated);
    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        testMethod();
    }

    @Selector("numberOfSectionsInTableView:")
    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        return sections.count();
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        if (section == 0) {
            return primaryColors.count();
        }
        if (section == 1) {
            return secondaryColors.count();
        }
        return 0;
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
        UITableViewCell cell = (UITableViewCell)tableView.dequeueReusableCellWithIdentifier(cellIdentifier);
        if (cell == null) {
            cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(
                    UITableViewCellStyle.Default, cellIdentifier);
        }

        if (indexPath.section() == 0) {
            cell.textLabel().setText((String)primaryColors.objectAtIndex(indexPath.row()));
        } else {
            cell.textLabel().setText((String)secondaryColors.objectAtIndex(indexPath.row()));
        }
        return cell;
    }

    public void testMethod() {

        testFrame1 = (tableView().frame().origin().x() == 0 && tableView().frame().origin().y() == 20
                && tableView().frame().size().width() == 320 && tableView().frame().size().height() == 460) ;

        testAlpha1 = (tableView().alpha() == 0.5);
    }

}
