package xosrt.binding.test.foundation.Utils.XMLParser;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class Person extends NSObject {

    public NSString gender = null;
    public NSString witnessProtection = null;
    public NSString firstname = null;
    public NSString firstnameIsReal = null;
    public NSString lastname = null;
    public NSString lastnameIsReal = null;

    static {
        Registrator.registerClassObject(Person.class);
    }

    @NativeSelector("alloc")
    public static native Person alloc();

    @NativeSelector("init")
    public native Person init();
}

