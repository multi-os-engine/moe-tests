package org.moe.xosrt.binding.test.foundation.Utils;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSString;

public class ErrorTestObject extends NSObject {

    long myNumberx;
    NSString myStringx;

    static {
        NatJ.register();
    }

    protected ErrorTestObject(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native ErrorTestObject alloc();

    @Selector("init")
    public native ErrorTestObject init();

    public void setMyNumber(long n) {
        myNumberx = n;
    }

    public void setMyString(NSString s) {
        myStringx = s;
    }

    public long myNumber() {
        return myNumberx;
    }

    public NSString myString() {
        return myStringx;
    }
}
