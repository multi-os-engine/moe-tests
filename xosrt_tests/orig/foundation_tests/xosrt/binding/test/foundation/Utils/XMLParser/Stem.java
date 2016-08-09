package xosrt.binding.test.foundation.Utils.XMLParser;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class Stem extends NSObject {

    public NSString lengthy = null;
    public NSString radius = null;

    static {
        Registrator.registerClassObject(Stem.class);
    }

    @NativeSelector("alloc")
    public static native Stem alloc();

    @NativeSelector("init")
    public native Stem init();
}
