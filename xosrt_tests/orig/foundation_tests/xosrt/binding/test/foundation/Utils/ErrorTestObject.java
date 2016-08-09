package xosrt.binding.test.foundation.Utils;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class ErrorTestObject extends NSObject {

    long myNumberx;
    NSString myStringx;

    static {
        Registrator.registerClassObject(ErrorTestObject.class);
    }

    @NativeSelector("alloc")
    public static native ErrorTestObject alloc();

    @NativeSelector("init")
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
