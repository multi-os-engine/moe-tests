package org.moe.xosrt.binding.test.foundation;

import java.util.Random;

import org.moe.natj.general.ptr.ConstPtr;
import ios.foundation.NSArray;
import ios.foundation.NSBundle;
import ios.foundation.NSDictionary;
import ios.foundation.NSError;
import ios.foundation.NSFileManager;
import ios.foundation.NSNumber;
import ios.foundation.NSString;
import ios.foundation.c.Foundation;
import ios.foundation.enums.NSSearchPathDirectory;
import ios.foundation.enums.NSSearchPathDomainMask;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;

public class NSBundleTests extends XOSTest{
	
	static NSFileManager fm;
	static String testDir;
	static boolean success;
	
	static {
		fm = NSFileManager.defaultManager();
		if( fm != null) success = true;
		else  			success = false;
	}
	
    @BeforeClass
    public static void setUp() {
    	String defaultPath = (String)Foundation.NSSearchPathForDirectoriesInDomains(
    			NSSearchPathDirectory.DocumentDirectory,
    			NSSearchPathDomainMask.UserDomainMask, true).firstObject();
    	
    	Random randomGenerator = new Random();
    	long random = 0;
    	String fullPath = defaultPath;
    	do {
    		random = randomGenerator.nextLong();
    		fullPath = defaultPath + random + "/testDir/"; 
    	} while ( fm.fileExistsAtPath(fullPath));
    	
    	Ptr<NSError> err = PtrFactory.newObjectPtr(NSError.class, 1, true, true);
    	
    	NSDictionary attributes = NSDictionary.alloc().initWithObjectsForKeys(
				NSArray.alloc().initWithObjectsCount(
						(ConstPtr)PtrFactory.newObjectArray(NSNumber.class, new NSNumber[] {
							NSNumber.numberWithInt(0777)
							} ),
						1),
				NSArray.alloc().initWithObjectsCount(
						(ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
    						NSString.stringWithString( Foundation.NSFilePosixPermissions() )
							} ), 
						1) 
				);
    	
    	if ( !fm.createDirectoryAtPathWithIntermediateDirectoriesAttributesError(fullPath, true, attributes, err) ) {
    		success = false;
    		System.err.println( err.get().description() );
    	}
    	
    	testDir = fullPath;
     }
    
    @AfterClass
    public static void theEnd() {
    	Ptr<NSError> err = PtrFactory.newObjectPtr(NSError.class, 1, true, true);
    	if ( !fm.removeItemAtPathError(testDir, err) ) {
    		System.err.println( err.get().description() );
    	}
    }

    @Test
    public void testMainBundle() {
        NSBundle bundle = NSBundle.mainBundle();
        assertTrue(bundle != null);
    }
    
    @Test
    public void testBundleWithPath() {
    	NSBundle bundle = NSBundle.bundleWithPath(testDir);
    	assertTrue(bundle != null && success);
    }

    @Test
    public void testPathForResourceOfType() {
    	if (success) {
    		NSBundle aBundle = NSBundle.bundleWithPath(testDir);
    		NSFileManager fm = NSFileManager.defaultManager();
    		fm.createFileAtPathContentsAttributes(testDir + "logo.jpg", null, null);
    		String path = aBundle.pathForResourceOfType("logo", "jpg");
    		assertTrue(aBundle.bundlePath(), NSString.stringWithString(path).hasSuffix("logo.jpg"));
    	}
    	else assertTrue(false);
    }

    @Test
    public void testPathForResourceOfTypeInDirectory() {
    	if (success) {
    		NSBundle aBundle = NSBundle.bundleWithPath(testDir);
    		NSFileManager fm = NSFileManager.defaultManager();
    		fm.createFileAtPathContentsAttributes(testDir + "imgLogo2.jpg", null, null);
    		String path = aBundle.pathForResourceOfTypeInDirectory("imgLogo2", "jpg", ".");
    		assertTrue(path != null);
    	}
    	else assertTrue(false);
    }

    @Test
    public void testResourcePath() {
        String str = NSBundle.mainBundle().resourcePath();
        assertTrue(str != null);
    }
}
