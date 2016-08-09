package org.moe.xosrt.binding.test.xib.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.*;
import ios.uikit.*;

public class TableViewCellController extends UITableViewCell {

    static {
        NatJ.register();
    }

    protected TableViewCellController(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native TableViewCellController alloc();

    @Selector("init")
    public native TableViewCellController init();

    public UILabel lbl;
    public UIImageView image;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "lbl":
                lbl = (UILabel)value;
                break;
            case "image":
                image = (UIImageView)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "lbl":
                return lbl;
            case "image":
                return image;
            default:
                return super.valueForKey(key);
        }
    }

    @Selector("setLabel:")
    public void setLabel(NSIndexPath indexPath) {
        lbl.setText(String.format("Cell %d", indexPath.row()));
    }

}
