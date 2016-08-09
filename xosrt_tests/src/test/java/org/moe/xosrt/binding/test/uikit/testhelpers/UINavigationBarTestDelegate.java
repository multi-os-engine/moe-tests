package org.moe.xosrt.binding.test.uikit.testhelpers;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.uikit.UINavigationBar;
import ios.uikit.UINavigationItem;
import ios.uikit.protocol.UINavigationBarDelegate;

public class UINavigationBarTestDelegate extends NSObject implements UINavigationBarDelegate {
    static {
        NatJ.register();
    }

    protected UINavigationBarTestDelegate(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native UINavigationBarTestDelegate alloc();

    @Selector("init")
    public native UINavigationBarTestDelegate init();

    public int shouldPopCount;
    public int shouldPushCount;
    public int didPopCount;
    public int didPushCount;
    public UINavigationItem navigationItem;

    @Selector("navigationBar:didPopItem:")
    @Override
    public void navigationBarDidPopItem(UINavigationBar uiNavigationBar, UINavigationItem uiNavigationItem) {
        didPopCount++;
    }

    @Selector("navigationBar:didPushItem:")
    @Override
    public void navigationBarDidPushItem(UINavigationBar uiNavigationBar, UINavigationItem uiNavigationItem) {
        didPushCount++;
    }

    @Selector("navigationBar:shouldPopItem:")
    @Override
    public boolean navigationBarShouldPopItem(UINavigationBar uiNavigationBar, UINavigationItem uiNavigationItem) {
        shouldPopCount++;
        return navigationItem != uiNavigationItem;
    }

    @Selector("navigationBar:shouldPushItem:")
    @Override
    public boolean navigationBarShouldPushItem(UINavigationBar uiNavigationBar, UINavigationItem uiNavigationItem) {
        shouldPushCount++;
        return navigationItem != uiNavigationItem;
    }

    @Override
    public long positionForBar(Object o) {
        return 0;
    }
}
