package org.moe.xosrt.binding.test.foundation.Utils.XMLParser;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSString;

public class Mail extends NSObject {

    public NSString to = null;
    public NSString header = null;
    public NSString body = null;

    static {
        NatJ.register();
    }

    protected Mail(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native Mail alloc();

    @Selector("init")
    public native Mail init();
}
