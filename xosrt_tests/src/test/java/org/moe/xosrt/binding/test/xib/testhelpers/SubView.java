package org.moe.xosrt.binding.test.xib.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.uikit.UIButton;
import ios.uikit.UIColor;
import ios.uikit.UIScrollView;
import ios.uikit.UIView;

public class SubView extends UIView {

    static {
        NatJ.register();
    }

    protected SubView(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native SubView alloc();

    @Selector("init")
    public native SubView init();

    public static volatile boolean testAwakeFromNib = false;

    UIButton button;

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "button":
                button = (UIButton)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "button":
                return button;
            default:
                return super.valueForKey(key);
        }
    }

    @Selector("awakeFromNib")
    @Override
    public void awakeFromNib() {
        setBackgroundColor(UIColor.blueColor());
        testAwakeFromNib = (button != null && button.titleLabel().text().equals("OK")
                && backgroundColor() == UIColor.blueColor());
    }
}
