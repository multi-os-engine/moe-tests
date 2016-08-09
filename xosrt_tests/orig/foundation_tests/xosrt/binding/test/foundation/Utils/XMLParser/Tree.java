package xosrt.binding.test.foundation.Utils.XMLParser;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSMutableArray;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;

public class Tree extends NSObject {

    public Root root = null;
    public Stem stem = null;
    public NSString height = null;
    public NSMutableArray branches = null;

    static {
        Registrator.registerClassObject(Tree.class);
    }

    @NativeSelector("alloc")
    public static native Tree alloc();

    @NativeSelector("init")
    public native Tree init();
}
