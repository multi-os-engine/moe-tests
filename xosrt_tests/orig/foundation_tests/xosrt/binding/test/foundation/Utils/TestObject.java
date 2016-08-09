package xosrt.binding.test.foundation.Utils;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSComparisonResult;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class TestObject extends NSObject {
    public NSString field;

    static {
        Registrator.registerClassObject(TestObject.class);
    }

    @NativeSelector("alloc")
    public static native TestObject alloc();

    @NativeSelector("init")
    public native TestObject init();

    public void changeField() {
        field = NSString.fromJavaString("changed");
    }

    public void changeFieldWithString(NSString aString) {
        field = aString;
    }

    public long compareFields(TestObject testObject) {
        return field.compare(testObject.field);
    }

    @Override
    public boolean isEqual(NSObject object) {
        if (object == this) {
            return true;
        }
        return this.field.isEqual(((TestObject)object).field);
    }
}
