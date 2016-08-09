package xosrt.binding.test.foundation.Utils.XMLParser;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class Mail extends NSObject {

    public NSString to = null;
    public NSString header = null;
    public NSString body = null;

    static {
        Registrator.registerClassObject(Mail.class);
    }

    @NativeSelector("alloc")
    public static native Mail alloc();

    @NativeSelector("init")
    public native Mail init();
}
