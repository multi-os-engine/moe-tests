package org.moe.xosrt.binding.test.foundation.Utils;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import java.lang.Object;import java.lang.Override;import ios.NSObject;
import ios.foundation.*;

public class TestObject extends NSObject {
    public NSString field;

    static {
        NatJ.register();
    }

    protected TestObject(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native TestObject alloc();

    @Selector("init")
    public native TestObject init();

    @Selector("changeField")
    public void changeField() {
        field = NSString.stringWithString("changed");
    }

    @Selector("changeFieldWithString:")
    public void changeFieldWithString(NSString aString) {
        field = aString;
    }

    @Selector("compareFields:")
    public long compareFields(TestObject testObject) {
        return field.compare(testObject.field.toString());
    }

    @Override
    public boolean isEqual(Object object) {
        if (object == this) {
            return true;
        }
        return this.field.isEqual(((TestObject)object).field);
    }
}
