package org.moe.xosrt.binding.test.uikit.controllers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.struct.CGRect;
import ios.foundation.*;
import ios.foundation.struct.NSRange;
import ios.uikit.*;
import ios.uikit.enums.UITableViewCellStyle;
import ios.uikit.enums.UITableViewStyle;
import ios.uikit.protocol.UISearchBarDelegate;

public class UISearchBarViewController extends UITableViewController implements UISearchBarDelegate {

    static {
        NatJ.register();
    }

    protected UISearchBarViewController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UISearchBarViewController alloc();

    @Selector("init")
    public native UISearchBarViewController init();

    NSMutableArray countries;
    NSMutableArray filtredCountries;
    UISearchBar searchBar;
    

    public static volatile boolean testText1 = false;
    public static volatile boolean testDelegate1 = false;
    public static volatile boolean testShowsCancelButton1 = false;
    public static volatile boolean testPlaceholder1 = false;
    public static volatile boolean testSetUserInteractionEnabled1 = false;

    @Selector("loadView")
    @Override
    public void loadView() {

        countries = NSMutableArray.arrayWithObjectsCount((Ptr) PtrFactory.newObjectArray(
                NSString.class, new NSString[]{
                        NSString.stringWithString("Argentina"),
                        NSString.stringWithString("Chile"),
                        NSString.stringWithString("Uruguay"),
                        NSString.stringWithString("Brazil"),
                        NSString.stringWithString("Colombia"),
                        NSString.stringWithString("Peru"),
                        NSString.stringWithString("Paraguay"),
                        NSString.stringWithString("Bolivia"),
                        NSString.stringWithString("Ecuador"),
                        NSString.stringWithString("Venezuela")
                }), 10);
        filtredCountries = NSMutableArray.arrayWithCapacity(10);
        filtredCountries.addObjectsFromArray(countries);

        setTableView(UITableView.alloc().initWithFrameStyle(UIScreen.mainScreen().bounds(), UITableViewStyle.Grouped));
        tableView().setDataSource(this);
        tableView().setDelegate(this);

        searchBar = UISearchBar.alloc().init();
        searchBar.sizeToFit();
        searchBar.setDelegate(this);
        tableView().setTableHeaderView(searchBar);

    }

    @Selector("viewDidAppear:")
    @Override
    public void viewDidAppear(boolean animated) {
        testMethod();
    }

    public void testMethod() {
        String aText = "textTest";
        searchBar.setText(aText);
        testText1 = (searchBar.text().equals(aText));
        searchBar.setText("");

        searchBar.setDelegate(this);
        testDelegate1 = (searchBar.delegate() == this);

        if (!searchBar.showsCancelButton()) {
            searchBar.setShowsCancelButtonAnimated(true, false);
            testShowsCancelButton1 = (searchBar.showsCancelButton());
        }

        String atextholder = "search holder text";
        searchBar.setPlaceholder(atextholder);
        testPlaceholder1 = (searchBar.placeholder().equals(atextholder));

        searchBar.setUserInteractionEnabled(false);
        testSetUserInteractionEnabled1 = (!searchBar.isUserInteractionEnabled());
    }

    @Selector("numberOfSectionsInTableView:")
    public long numberOfSectionsInTableView(UITableView tableView) {
        return 1;
    }

    @Selector("tableView:numberOfRowsInSection:")
    public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
        return filtredCountries.count();
    }

    @Selector("tableView:titleForHeaderInSection:")
    public String tableViewTitleForHeaderInSection(UITableView tableView, long section) {
        return "Countries";
    }

    @Selector("tableView:cellForRowAtIndexPath:")
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        String cellIdentifier = "Cell";
        UITableViewCell cell = UITableViewCell.alloc().initWithStyleReuseIdentifier(UITableViewCellStyle.Default, cellIdentifier);
        cell.textLabel().setText((String)filtredCountries.objectAtIndex(indexPath.row()));
        return cell;
    }

    @Selector("searchBarCancelButtonClicked:")
    public void searchBarCancelButtonClicked(UISearchBar searchBar) {
        searchBar.setText("");
        searchBar.resignFirstResponder();
        filtredCountries.removeAllObjects();
        filtredCountries.addObjectsFromArray(countries);
        tableView().reloadData();
    }

    @Override
    public void searchBarResultsListButtonClicked(UISearchBar uiSearchBar) {

    }

    @Override
    public void searchBarSearchButtonClicked(UISearchBar uiSearchBar) {

    }

    @Override
    public boolean searchBarShouldBeginEditing(UISearchBar uiSearchBar) {
        return false;
    }

    @Override
    public boolean searchBarShouldEndEditing(UISearchBar uiSearchBar) {
        return false;
    }

    @Override
    public void searchBarTextDidBeginEditing(UISearchBar uiSearchBar) {

    }

    @Override
    public void searchBarTextDidEndEditing(UISearchBar uiSearchBar) {

    }

    @Override
    public void searchBarSelectedScopeButtonIndexDidChange(UISearchBar uiSearchBar, long l) {

    }

    @Override
    public boolean searchBarShouldChangeTextInRangeReplacementText(UISearchBar uiSearchBar, NSRange nsRange, String s) {
        return false;
    }

    @Selector("searchBar:textDidChange:")
    public void searchBarTextDidChange(UISearchBar searchBar, String searchText) {
        String firstLetter = "";
        int strlen = searchText.length();
        filtredCountries.removeAllObjects();
        if(strlen > 0) {
            for (int i = 0; i < countries.count(); i++) {
                NSString strTemp = NSString.stringWithString((String) countries.objectAtIndex(i));
                if (strTemp.length() >= strlen) {
                    firstLetter = strTemp.substringToIndex(strlen);
                }
                NSString toSearch = NSString.stringWithString(searchText);
                if (toSearch.uppercaseString().equals(firstLetter.toUpperCase())) {
                    filtredCountries.addObject(strTemp);
                }
            }
        } else {
            filtredCountries.addObjectsFromArray(countries);
            searchBar.resignFirstResponder();
        }
        tableView().reloadData();
    }

    @Override
    public void searchBarBookmarkButtonClicked(UISearchBar uiSearchBar) {

    }

    @Override
    public long positionForBar(Object o) {
        return 0;
    }
}
