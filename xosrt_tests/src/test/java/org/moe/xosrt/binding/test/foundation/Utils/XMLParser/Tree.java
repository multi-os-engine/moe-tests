package org.moe.xosrt.binding.test.foundation.Utils.XMLParser;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSMutableArray;
import ios.foundation.NSString;


public class Tree extends NSObject {

    public Root root = null;
    public Stem stem = null;
    public NSString height = null;
    public NSMutableArray branches = null;

    static {
        NatJ.register();
    }

    protected Tree(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native Tree alloc();

    @Selector("init")
    public native Tree init();
}
