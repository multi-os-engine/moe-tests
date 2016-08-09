package xosrt.binding.test.foundation.Utils;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSObject;

public class TimerTestTarget extends NSObject {
    public volatile boolean passed = false;

    static {
        Registrator.registerClassObject(TimerTestTarget.class);
    }

    @NativeSelector("alloc")
    public static native TimerTestTarget alloc();

    @NativeSelector("init")
    public native TimerTestTarget init();

    public void targetMethod(){
        passed = true;
    }
}
