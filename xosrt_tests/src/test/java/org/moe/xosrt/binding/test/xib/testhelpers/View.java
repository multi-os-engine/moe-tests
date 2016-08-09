package org.moe.xosrt.binding.test.xib.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UIView;

public class View extends UIView {

    static {
        NatJ.register();
    }

    protected View(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native View alloc();

    @Selector("init")
    public native View init();

    View1 view1;

    public static volatile boolean testAwakeFromNib = false;


    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "view1":
                view1 = (View1)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "view1":
                return view1;
            default:
                return super.valueForKey(key);
        }
    }

    @Selector("awakeFromNib")
    @Override
    public void awakeFromNib() {
        testAwakeFromNib = (view1 != null);
        setBackgroundColor(UIColor.greenColor());
    }
}
