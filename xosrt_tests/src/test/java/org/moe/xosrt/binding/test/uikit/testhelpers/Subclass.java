package org.moe.xosrt.binding.test.uikit.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSString;

public class Subclass extends SuperClass {
    static {
        NatJ.register();
    }

    protected Subclass(Pointer peer) {
        super(peer);
    }
    @Selector("alloc")
    public static native Subclass alloc();

    @Selector("init")
    public native Subclass init();

    @Override
    public void methodA() {
        SuperClass.addMethodNameToExecutedArray(NSString.stringWithString("SubClass methodA"));
        super.methodA();
    }

    @Override
    public void methodB() {
        SuperClass.addMethodNameToExecutedArray(NSString.stringWithString("SubClass methodB"));
        super.methodB();
    }

}
