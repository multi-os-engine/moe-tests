package org.moe.xosrt.binding.test.uikit.testhelpers;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSMutableArray;
import ios.foundation.NSString;

public class SuperClass extends NSObject {

    static NSMutableArray methodExecutedArray = NSMutableArray.alloc().init();

    protected SuperClass(Pointer peer) {
        super(peer);
    }

    static {
        NatJ.register();
    }

    @Selector("alloc")
    public static native SuperClass alloc();

    @Selector("init")
    public native SuperClass init();

    public void methodA() {
        SuperClass.addMethodNameToExecutedArray(NSString.stringWithString("SuperClass methodA"));
    }

    public void methodB() {
        SuperClass.addMethodNameToExecutedArray(NSString.stringWithString("SuperClass methodB"));
        methodA();
    }

    static public void addMethodNameToExecutedArray(NSString str) {
        methodExecutedArray.addObject(str);
    }

    static public NSMutableArray methodExecutedArray() {
        if (methodExecutedArray == null) {
            methodExecutedArray = NSMutableArray.alloc().init();
        }
        return methodExecutedArray;
    }
}
