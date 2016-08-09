package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import org.moe.xosrt.binding.test.uikit.testhelpers.MyTableViewController;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.uikit.*;
import ios.uikit.enums.UITableViewStyle;

public class UITableViewControllerViewController extends UIViewController {

    static {
        NatJ.register();
    }

    protected UITableViewControllerViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UITableViewControllerViewController alloc();

    @Selector("init")
    public native UITableViewControllerViewController init();

    
    UIView view1;
    UITableView tableControllerView;
    MyTableViewController tViewController;

    public static volatile boolean testInitWithStyle1 = false;
    public static volatile boolean testTableView1 = false;

    public void testMethods() {
        tViewController = (MyTableViewController)MyTableViewController.alloc().initWithStyle(UITableViewStyle.Grouped);
        testInitWithStyle1 = (tViewController != null);
        tableControllerView = UITableView.alloc().initWithFrame(CoreGraphics.CGRectMake(10, 20, 300, 300));
        tableControllerView.setDataSource(tViewController);
        tViewController.setTableView(tableControllerView);
        testTableView1 = (tViewController.tableView() == tableControllerView);
    }

    @Selector("loadView")
    @Override
    public void loadView() {
        setView(UIView.alloc().initWithFrame(CoreGraphics.CGRectMake(0,0,320, 480)));
        view().setBackgroundColor(UIColor.lightGrayColor());
        testMethods();

        view().addSubview(tableControllerView);
    }

    public void dealloc() {
        super.dealloc();
    }

}
