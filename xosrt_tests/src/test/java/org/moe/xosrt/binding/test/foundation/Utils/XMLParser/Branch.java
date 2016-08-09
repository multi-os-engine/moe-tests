package org.moe.xosrt.binding.test.foundation.Utils.XMLParser;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSMutableArray;
import ios.foundation.NSString;

public class Branch extends NSObject {

    public NSString idNumber = null;
    public NSString lengthy = null;
    public NSMutableArray leaves = null;

    static {
        NatJ.register();
    }

    protected Branch(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native Branch alloc();

    @Selector("init")
    public native Branch init();
}
