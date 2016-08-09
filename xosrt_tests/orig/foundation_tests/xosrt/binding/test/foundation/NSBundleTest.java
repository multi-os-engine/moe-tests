package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import xosrt.binding.foundation.NSBundle;
import xosrt.binding.foundation.NSString;
import xosrt.binding.foundation.NSStringEncoding;
import org.junit.Test;


public class NSBundleTest {

	static {
		System.loadLibrary("Mac");
	}
	
	@Test
	public void nsBundleLoadingXMLTest() {
		 	NSBundle mainBundle = NSBundle.mainBundle();

	        NSString pathToTestTXT = mainBundle.pathForResource(NSString.fromJavaString("/Users/user/Downloads/MessageWithProject"), NSString.fromJavaString("txt"));
	        System.out.print("--- pathToTestTXT =" + pathToTestTXT +" \n");
	        if (pathToTestTXT != null) {
	            NSString testTXT = NSString.stringWithContentsOfFileEncodingError(
	                    pathToTestTXT,
	                    NSStringEncoding.NSUTF8StringEncoding,
	                    null
	            );
	            System.out.print("--- testTXT: " + testTXT.toString());
	        }


	        NSString pathToElements = mainBundle.pathForResource(NSString.fromJavaString("Elements"), NSString.fromJavaString("xml"));
	        System.out.print("--- pathToElements =" + pathToElements +" \n");

	        if (pathToElements != null) {
	            NSString plist = NSString.stringWithContentsOfFileEncodingError(
	                    pathToElements,
	                    NSStringEncoding.NSUTF8StringEncoding,
	                    null
	            );
	            System.out.print("--- stringWithContentsOfFileEncodingError ---");
	        }
	}
	
	
}
