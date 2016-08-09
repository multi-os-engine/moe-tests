package org.moe.xosrt.binding.test.foundation.Utils;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import ios.foundation.NSError;
import ios.foundation.NSFileManager;
import ios.foundation.protocol.NSFileManagerDelegate;
import ios.NSObject;
import ios.foundation.NSURL;

public class TestFileManagerDelegate extends NSObject implements NSFileManagerDelegate {

    static {
        NatJ.register();
    }

    protected TestFileManagerDelegate(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native TestFileManagerDelegate alloc();

    @Selector("init")
    public native TestFileManagerDelegate init();

    @Override
    public boolean fileManagerShouldCopyItemAtPathToPath(NSFileManager nsFileManager, String s, String s2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldCopyItemAtURLToURL(NSFileManager nsFileManager, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldLinkItemAtPathToPath(NSFileManager nsFileManager, String s, String s2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldLinkItemAtURLToURL(NSFileManager nsFileManager, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldMoveItemAtPathToPath(NSFileManager nsFileManager, String s, String s2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldMoveItemAtURLToURL(NSFileManager nsFileManager, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorCopyingItemAtPathToPath(NSFileManager nsFileManager, NSError nsError, String s, String s2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorCopyingItemAtURLToURL(NSFileManager nsFileManager, NSError nsError, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorLinkingItemAtPathToPath(NSFileManager nsFileManager, NSError nsError, String s, String s2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorLinkingItemAtURLToURL(NSFileManager nsFileManager, NSError nsError, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorMovingItemAtPathToPath(NSFileManager nsFileManager, NSError nsError, String s, String s2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorMovingItemAtURLToURL(NSFileManager nsFileManager, NSError nsError, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorRemovingItemAtPath(NSFileManager nsFileManager, NSError nsError, String s) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorRemovingItemAtURL(NSFileManager nsFileManager, NSError nsError, NSURL nsurl) {
        return false;
    }

    @Override
    public boolean fileManagerShouldRemoveItemAtPath(NSFileManager nsFileManager, String s) {
        return false;
    }

    @Override
    public boolean fileManagerShouldRemoveItemAtURL(NSFileManager nsFileManager, NSURL nsurl) {
        return false;
    }
}
