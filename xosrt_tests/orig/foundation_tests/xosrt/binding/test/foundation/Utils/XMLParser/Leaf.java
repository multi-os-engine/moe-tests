package xosrt.binding.test.foundation.Utils.XMLParser;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class Leaf extends NSObject {

    public NSString idNumber = null;

    static {
        Registrator.registerClassObject(Leaf.class);
    }

    @NativeSelector("alloc")
    public static native Leaf alloc();

    @NativeSelector("init")
    public native Leaf init();
}
