package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import xosrt.binding.pointers.BoolPtr;
import xosrt.binding.test.foundation.Utils.TestFileManagerDelegate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NSFileManagerTests {

    private static final String FILE_NAME = "afile.txt";
    static {
        System.loadLibrary("Mac");
    }

    @Before
    public void initTests() {
        NSFileManager.defaultManager().createFileAtPathContentsAttributes(
                NSString.fromJavaString(FILE_NAME), NSData.data(), null);
    }

    @Test
    public void testFileExistsAtPath1() {
        NSFileManager  aManager = NSFileManager.defaultManager();

        boolean i = aManager.fileExistsAtPath(NSString.fromJavaString(FILE_NAME));
        assertTrue(i) ;
    }

    @Test
    public void testFileExistsAtPath_isDirectory1() {
        NSFileManager  aManager = NSFileManager.defaultManager();
        BoolPtr aBool = new BoolPtr(false);
        boolean aExist = aManager.fileExistsAtPathIsDirectory(NSString.fromJavaString(FILE_NAME), aBool);

        assertTrue(aExist) ;
    }

    @Test
    public void testSetDelegate1() {
        NSFileManager  aManager = NSFileManager.defaultManager();
        aManager.setDelegate(TestFileManagerDelegate.alloc().init());
        NSFileManagerDelegate anId = aManager.getDelegate();
        assertTrue(anId != null) ;
    }

    @After
    public void wrapUp() {
        NSFileManager.defaultManager().removeItemAtPathError(NSString.fromJavaString(FILE_NAME), null);
    }
}
