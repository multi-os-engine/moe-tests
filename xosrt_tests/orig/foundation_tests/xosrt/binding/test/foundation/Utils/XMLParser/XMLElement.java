package xosrt.binding.test.foundation.Utils.XMLParser;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSDictionary;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class XMLElement extends NSObject {
    public NSString name = null;
    public NSString qName = null;
    public NSString namespaceURI = null;
    public NSString characters = null;
    public NSDictionary attributes = null;

    static {
        Registrator.registerClassObject(XMLElement.class);
    }

    @NativeSelector("alloc")
    public static native XMLElement alloc();

    @NativeSelector("init")
    public native XMLElement init();
}
