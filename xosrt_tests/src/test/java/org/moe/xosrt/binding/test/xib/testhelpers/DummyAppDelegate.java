package org.moe.xosrt.binding.test.xib.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.uikit.UINavigationController;
import ios.uikit.UIResponder;
import ios.uikit.UIView;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;

public class DummyAppDelegate extends UIViewController implements UIApplicationDelegate {

    static {
        NatJ.register();
    }

    protected DummyAppDelegate(Pointer peer) {
        super(peer);
    }

    public UINavigationController navigationController;
    public UIWindow window;

    @Selector("alloc")
    public static native DummyAppDelegate alloc();

    @Selector("init")
    public native DummyAppDelegate init();

    @Selector("setValue:forUndefinedKey:")
    @Override
    public void setValueForUndefinedKey(Object value, String key) {
        switch(key) {
            case "window":
                window = (UIWindow)value;
                break;
            case "navigationController":
                navigationController = (UINavigationController)value;
                break;
            default:
                super.setValueForUndefinedKey(value, key);
        }
    }

    @Selector("valueForKey:")
    @Override
    public Object valueForKey(String key) {
        switch(key) {
            case "window":
                return window;
            case "navigationController":
                return navigationController;
            default:
                return super.valueForKey(key);
        }
    }

    @Override
    @Selector("setWindow:")
    public void setWindow(UIWindow value) {
        window = value;
    }

    @Override
    @Selector("window")
    public UIWindow window() {
        return window;
    }
}
