package xosrt.binding.test.foundation.Utils;

import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.Registrator;
import xosrt.binding.foundation.NSError;
import xosrt.binding.foundation.NSFileManager;
import xosrt.binding.foundation.NSFileManagerDelegate;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSString;
import xosrt.binding.foundation.NSURL;

public class TestFileManagerDelegate extends NSObject implements NSFileManagerDelegate {

    static {
        Registrator.registerClassObject(TestFileManagerDelegate.class);
    }

    @NativeSelector("alloc")
    public static native TestFileManagerDelegate alloc();

    @NativeSelector("init")
    public native TestFileManagerDelegate init();

    @Override
    public boolean fileManagerShouldCopyItemAtPathToPath(NSFileManager nsFileManager, NSString nsString, NSString nsString2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldCopyItemAtURLToURL(NSFileManager nsFileManager, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorCopyingItemAtPathToPath(NSFileManager nsFileManager, NSError nsError, NSString nsString, NSString nsString2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorCopyingItemAtURLToURL(NSFileManager nsFileManager, NSError nsError, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldMoveItemAtPathToPath(NSFileManager nsFileManager, NSString nsString, NSString nsString2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldMoveItemAtURLToURL(NSFileManager nsFileManager, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorMovingItemAtPathToPath(NSFileManager nsFileManager, NSError nsError, NSString nsString, NSString nsString2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorMovingItemAtURLToURL(NSFileManager nsFileManager, NSError nsError, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldLinkItemAtPathToPath(NSFileManager nsFileManager, NSString nsString, NSString nsString2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldLinkItemAtURLToURL(NSFileManager nsFileManager, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorLinkingItemAtPathToPath(NSFileManager nsFileManager, NSError nsError, NSString nsString, NSString nsString2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorLinkingItemAtURLToURL(NSFileManager nsFileManager, NSError nsError, NSURL nsurl, NSURL nsurl2) {
        return false;
    }

    @Override
    public boolean fileManagerShouldRemoveItemAtPath(NSFileManager nsFileManager, NSString nsString) {
        return false;
    }

    @Override
    public boolean fileManagerShouldRemoveItemAtURL(NSFileManager nsFileManager, NSURL nsurl) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorRemovingItemAtPath(NSFileManager nsFileManager, NSError nsError, NSString nsString) {
        return false;
    }

    @Override
    public boolean fileManagerShouldProceedAfterErrorRemovingItemAtURL(NSFileManager nsFileManager, NSError nsError, NSURL nsurl) {
        return false;
    }
}
