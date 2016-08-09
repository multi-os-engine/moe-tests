package org.moe.xosrt.binding.test.xib.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.xib.testhelpers.TableViewCellController;
import org.junit.Ignore;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;

public class XIBTestTableViewCellViewController extends UITableViewController {

    static {
        NatJ.register();
    }

    protected XIBTestTableViewCellViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XIBTestTableViewCellViewController alloc();

    @Selector("init")
    public native XIBTestTableViewCellViewController init();

    
    TableViewCellController tableCell;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "tableCell":
                tableCell = (TableViewCellController)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "tableCell":
                return tableCell;
            default:
                return super.valueForKey(key);
        }
    }


    public static volatile boolean testFramelabel1 = false;
    public static volatile boolean testTextlabel1 = false;
    public static volatile boolean testFrameimage1 = false;
    public static volatile boolean testBackgroundColor1 = false;
    public static volatile boolean testBackgroundColorlabel1 = false;
    public static volatile boolean testTextColorlabel1 = false;

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        testMethod();
    }

    @Selector("numberOfSectionsInTableView:")
    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        return 2;
    }

    @Selector("tableView:numberOfRowsInSection:")
    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        if (section == 0) {
            return 3;
        }
        if (section == 1) {
            return 2;
        }
        return 0;
    }

    @Selector("tableView:titleForHeaderInSection:")
    @Override
    public String tableViewTitleForHeaderInSection(UITableView tableView, long section) {
        String sectionHeader = "";
        if (section == 0) {
            sectionHeader = "First Section";
        }
        if (section == 1) {
            sectionHeader = "Second Section";
        }
        return sectionHeader;
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        String CellIdentifier = "CustomCell";
        TableViewCellController cell = (TableViewCellController)
                tableView.dequeueReusableCellWithIdentifier(CellIdentifier);


        if(cell == null) {
            NSBundle.mainBundle().loadNibNamedOwnerOptions("TableViewCellController", this, null);
            cell = tableCell;
        }

        cell.setLabel(indexPath);

        return (UITableViewCell)(Object)cell;
    }

    public void testMethod() {
        NSIndexPath indexPath = NSIndexPath.indexPathForRowInSection(0, 0);
        TableViewCellController cell = (TableViewCellController)(Object)tableView().cellForRowAtIndexPath(indexPath);

        testFramelabel1 =  (cell.lbl.frame().origin().x() == 23 && cell.lbl.frame().origin().y() == 11
                && cell.lbl.frame().size().width() == 115 && cell.lbl.frame().size().height() == 21);

        testTextlabel1 = (cell.lbl.text().equals("Cell 0"));

        testFrameimage1 =  (cell.image.frame().origin().x() == 246 && cell.image.frame().origin().y() == 6
                && cell.image.frame().size().width() == 31 && cell.image.frame().size().height() == 31);

        testBackgroundColor1 = (cell.backgroundColor().isEqual(UIColor.purpleColor())) ;

        testBackgroundColorlabel1 = (cell.lbl.backgroundColor().isEqual(UIColor.blueColor()));

        testTextColorlabel1 = (cell.lbl.textColor().isEqual(UIColor.yellowColor()));
    }

}
