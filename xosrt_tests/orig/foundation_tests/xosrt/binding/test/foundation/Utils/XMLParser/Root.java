package xosrt.binding.test.foundation.Utils.XMLParser;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class Root extends NSObject {

    public NSString size = null;

    static {
        Registrator.registerClassObject(Root.class);
    }
    @NativeSelector("alloc")
    public static native Root alloc();

    @NativeSelector("init")
    public native Root init();
}
