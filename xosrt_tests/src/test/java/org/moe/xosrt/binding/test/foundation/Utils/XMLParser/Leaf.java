package org.moe.xosrt.binding.test.foundation.Utils.XMLParser;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSString;

public class Leaf extends NSObject {

    public NSString idNumber = null;

    static {
        NatJ.register();
    }

    protected Leaf(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native Leaf alloc();

    @Selector("init")
    public native Leaf init();
}
