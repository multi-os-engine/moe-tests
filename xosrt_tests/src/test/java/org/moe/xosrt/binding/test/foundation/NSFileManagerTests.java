package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.BoolPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;
import ios.foundation.*;

import org.moe.xosrt.binding.test.foundation.Utils.TestFileManagerDelegate;

import ios.foundation.protocol.NSFileManagerDelegate;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class NSFileManagerTests extends XOSTest{

    private static final String FILE_NAME = NSBundle.mainBundle().bundlePath() + "/afile.txt";

    @Before
    public void initTests() {
        NSFileManager.defaultManager().createFileAtPathContentsAttributes(
                FILE_NAME, NSData.data(), null);
    }

    @Test
    public void testFileExistsAtPath1() {
        NSFileManager  aManager = NSFileManager.defaultManager();

        boolean i = aManager.fileExistsAtPath(FILE_NAME);
        assertTrue(i) ;
    }

    @Test
    public void testFileExistsAtPath_isDirectory1() {
        NSFileManager  aManager = NSFileManager.defaultManager();
        BoolPtr aBool = PtrFactory.newBoolReference(false);
        boolean aExist = aManager.fileExistsAtPathIsDirectory(FILE_NAME, aBool);

        assertTrue(aExist);
    }

    @Test
    public void testSetDelegate1() {
        NSFileManager  aManager = NSFileManager.defaultManager();
        aManager.setDelegate(TestFileManagerDelegate.alloc().init());
        NSFileManagerDelegate anId = (NSFileManagerDelegate)aManager.delegate();
        assertTrue(anId != null);
    }

    @After
    public void wrapUp() {
        NSFileManager.defaultManager().removeItemAtPathError(FILE_NAME, null);
    }
}
