package org.moe.xosrt.binding.test.foundation.Utils.XMLParser;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSString;

public class Person extends NSObject {

    public NSString gender = null;
    public NSString witnessProtection = null;
    public NSString firstname = null;
    public NSString firstnameIsReal = null;
    public NSString lastname = null;
    public NSString lastnameIsReal = null;

    static {
        NatJ.register();
    }

    protected Person(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native Person alloc();

    @Selector("init")
    public native Person init();
}

