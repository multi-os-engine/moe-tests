package org.moe.xosrt.binding.test.foundation.Utils.XMLParser;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSString;


public class Stem extends NSObject {

    public NSString lengthy = null;
    public NSString radius = null;

    static {
        NatJ.register();
    }

    protected Stem(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native Stem alloc();

    @Selector("init")
    public native Stem init();
}
