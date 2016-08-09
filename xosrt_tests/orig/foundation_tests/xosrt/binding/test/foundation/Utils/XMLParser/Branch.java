package xosrt.binding.test.foundation.Utils.XMLParser;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSMutableArray;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class Branch extends NSObject {

    public NSString idNumber = null;
    public NSString lengthy = null;
    public NSMutableArray leaves = null;

    static {
        Registrator.registerClassObject(Branch.class);
    }

    @NativeSelector("alloc")
    public static native Branch alloc();

    @NativeSelector("init")
    public native Branch init();
}
