package org.moe.xosrt.binding.test.xib.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.uikit.UIView;

public class View1 extends UIView {

    static {
        NatJ.register();
    }

    protected View1(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native View1 alloc();

    @Selector("init")
    public native View1 init();

    public volatile boolean testAwakeFromNib = false;

    @Selector("awakeFromNib")
    @Override
    public void awakeFromNib() {
        testAwakeFromNib = true;
    }
}
