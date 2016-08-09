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

public class XIBTestTableViewController2ViewController extends UITableViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewController2ViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewController2ViewController alloc();

    @Selector("init")
    public native XIBTestTableViewController2ViewController init();

    NSMutableArray data;

    public static volatile boolean testNavigationItemtitle1 = false;
    public static volatile boolean testNavigationItemprompt1 = false;
    public static volatile boolean testNavigationItemleftBarButtonItemtitle1 = false;
    public static volatile boolean testNavigationItemleftBarButtonItemtag1 = false;
    public static volatile boolean testNavigationItemrightBarButtonItemtitle1 = false;
    public static volatile boolean testNavigationItemrightBarButtonItemtag1 = false;
    public static volatile boolean testTabBarItemtitle1 = false;
    public static volatile boolean testTabBarItemtag1 = false;

    static long numberOfSections = 15;
    static long numberOfRows = 30;

    public void viewDidLoad() {
        super.viewDidLoad();
        data = createData();

        testXibFileProperties();

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
        cell.textLabel().setText((String) sectionArray.objectAtIndex(indexPath.row()));

        return cell;
    }

    public void testXibFileProperties() {
        testNavigationItemtitle1 = (navigationItem().title().equals("NavigationItem title"));

        testNavigationItemprompt1 =  (navigationItem().prompt().equals("NavigationItem prompt"));

        testNavigationItemleftBarButtonItemtitle1 = (navigationItem().leftBarButtonItem().title().equals("left BarButtonItem"));

        testNavigationItemleftBarButtonItemtag1 = (navigationItem().leftBarButtonItem().tag() == 1);

        testNavigationItemrightBarButtonItemtitle1 = (navigationItem().rightBarButtonItem().title().equals("right BarButtonItem"));

        testNavigationItemrightBarButtonItemtag1 = (navigationItem().rightBarButtonItem().tag() == 2);

        testTabBarItemtitle1 = (tabBarItem().title().equals("TabBarItem title"));

        testTabBarItemtag1 = (tabBarItem().tag() == 3);

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

}
