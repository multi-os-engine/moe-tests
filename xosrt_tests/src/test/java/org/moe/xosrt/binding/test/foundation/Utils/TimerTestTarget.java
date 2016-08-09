package org.moe.xosrt.binding.test.foundation.Utils;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;

public class TimerTestTarget extends NSObject {
    public volatile boolean passed = false;

    static {
        NatJ.register();
    }

    protected TimerTestTarget(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native TimerTestTarget alloc();

    @Selector("init")
    public native TimerTestTarget init();

    @Selector("targetMethod")
    public void targetMethod(){
        passed = true;
    }
}
