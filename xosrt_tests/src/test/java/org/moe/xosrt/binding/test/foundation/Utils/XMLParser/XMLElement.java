package org.moe.xosrt.binding.test.foundation.Utils.XMLParser;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSDictionary;
import ios.foundation.NSString;


public class XMLElement extends NSObject {
    public NSString name = null;
    public NSString qName = null;
    public NSString namespaceURI = null;
    public NSString characters = null;
    public NSDictionary attributes = null;

    static {
        NatJ.register();
    }

    protected XMLElement(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native XMLElement alloc();

    @Selector("init")
    public native XMLElement init();
}
