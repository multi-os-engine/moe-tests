package org.moe.xosrt.binding.test.foundation.Utils.XMLParser;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSString;

public class Root extends NSObject {

    public NSString size = null;

    static {
        NatJ.register();
    }

    protected Root(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native Root alloc();

    @Selector("init")
    public native Root init();
}
