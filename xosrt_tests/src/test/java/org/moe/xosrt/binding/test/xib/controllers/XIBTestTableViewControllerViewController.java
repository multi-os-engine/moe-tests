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

public class XIBTestTableViewControllerViewController extends UITableViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewControllerViewController alloc();

    @Selector("init")
    public native XIBTestTableViewControllerViewController init();

    NSMutableArray data;

    public static volatile boolean testTitle1 = false;

    static long numberOfSections = 15;
    static long numberOfRows = 30;

    public void viewDidLoad() {
        super.viewDidLoad();
        data = createData();

        testXibFileProperties();

    }

    public NSMutableArray createData() {
        NSMutableArray sectionsArray = NSMutableArray.array();
        NSMutableArray rowsArray = null;
        for (long i = 0;  i < numberOfSections;  i++) {
            rowsArray = NSMutableArray.array();
            for (long j = 0; j < numberOfRows; j++) {
                rowsArray.addObject(NSString.stringWithString(String.format("Cell %d of section %d", j, i)));
            }
            sectionsArray.addObject(rowsArray);
        }
        return sectionsArray;
    }

    @Selector("numberOfSectionsInTableView:")
    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        return numberOfSections;
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        return numberOfRows;
    }

    @Selector("tableView:titleForHeaderInSection:")
    @Override
    public String tableViewTitleForHeaderInSection(UITableView tableView, long section) {
        return String.format("Title Header %d", section);
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        String cellIdentifier = "cell";
        UITableViewCell cell = (UITableViewCell)tableView.dequeueReusableCellWithIdentifier(cellIdentifier);
        if (cell == null) {
            cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(
                    UITableViewCellStyle.Default, cellIdentifier);
        }
        NSMutableArray sectionArray = (NSMutableArray)data.objectAtIndex(indexPath.section());
        cell.textLabel().setText((String)sectionArray.objectAtIndex(indexPath.row()));

        return cell;
    }

    public void testXibFileProperties() {
        testTitle1 = (title().equals("TableViewController1"));
    }

}
