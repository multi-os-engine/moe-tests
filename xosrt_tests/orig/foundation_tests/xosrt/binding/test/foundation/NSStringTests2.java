package xosrt.binding.test.foundation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import xosrt.binding.foundation.NSArray;
import xosrt.binding.foundation.NSComparisonResult;
import xosrt.binding.foundation.NSString;
import xosrt.binding.foundation.NSStringCompareOptions;
import xosrt.binding.foundation.NSStringEncoding;
import xosrt.binding.arrays.CharArr;
import org.junit.Ignore;
import org.junit.Test;

public class NSStringTests {

	static {
		System.loadLibrary("Mac");
	}
	
	@Test
	public void simpleStaticCreationTest() {
		NSString testNSString = NSString.string();
		assertNotNull(testNSString);
	 }
	
	@Test
	public void toStringTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( "Hello NSString!" , testNSString.toString());
	 }
	
	
	@Test
	public void substringFromIndexTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( "NSString!" , testNSString.substringFromIndex(6L).toString());
	 }
	
	@Test
	public void substringToIndexTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( "Hello " , testNSString.substringToIndex(6L).toString());
	 }
	
	@Test
	public void compareTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( NSComparisonResult.NSOrderedDescending ,
				testNSString.compare( NSString.fromJavaString("Good bye, NSString!") ));
	 }

	@Test
	public void compareOptionsTest() {
		NSString testNSString = NSString.fromJavaString("He11o NSString!");
		assertEquals( NSComparisonResult.NSOrderedAscending , 
				testNSString.compareOptions( NSString.fromJavaString("He110 NSString!"), NSStringCompareOptions.NSNumericSearch ));
	 }
	
	@Test
	public void caseInsensetiveCompareTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( NSComparisonResult.NSOrderedSame , 
				testNSString.caseInsensitiveCompare( NSString.fromJavaString("hello nsstring!") ) );
	 }
	
	@Test
	public void localizedCompareTest() {
		NSString testNSString = NSString.fromJavaString("NSString!");
		assertEquals( NSComparisonResult.NSOrderedDescending , 
				testNSString.localizedCompare( NSString.fromJavaString("Hello NSString!") ) );
	 }
	
	@Test
	public void localizedCaseInsensitiveCompareTest() {
		NSString testNSString = NSString.fromJavaString("HeLLo");
		assertEquals( NSComparisonResult.NSOrderedAscending , 
				testNSString.localizedCaseInsensitiveCompare( NSString.fromJavaString("Hello NSString!") ) );
	 }
	
	@Test
	public void localizedStandardCompareTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( NSComparisonResult.NSOrderedSame , 
				testNSString.localizedStandardCompare( NSString.fromJavaString("Hello NSString!") ) );
	 }
	
	@Test
	public void isEqualToStringTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( true , 
				testNSString.isEqualToString( NSString.fromJavaString("Hello NSString!") ) );
		assertEquals( false , 
				testNSString.isEqualToString( NSString.fromJavaString("LOL") ) );
	 }
	
	@Test
	public void hasPrefixTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( true , 
				testNSString.hasPrefix( NSString.fromJavaString("Hell") ) );
		assertEquals( false , 
				testNSString.hasPrefix( NSString.fromJavaString("LOL") ) );
	 }
	
	@Test
	public void hasSuffixTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( true , 
				testNSString.hasSuffix( NSString.fromJavaString("String!") ) );
		assertEquals( false , 
				testNSString.hasSuffix( NSString.fromJavaString("LOL") ) );
	 }
	
	@Test
	public void containsStringTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( true , 
				testNSString.containsString( NSString.fromJavaString("llo N") ) );
		assertEquals( false , 
				testNSString.containsString( NSString.fromJavaString("LOL") ) );
	 }
	 
	@Test
	public void localizedCaseInsensitiveContainsStringTest() {
		NSString testNSString = NSString.fromJavaString("Hello NSString!");
		assertEquals( true , 
				testNSString.localizedCaseInsensitiveContainsString( NSString.fromJavaString("lLO n") ) );
		assertEquals( false , 
				testNSString.localizedCaseInsensitiveContainsString( NSString.fromJavaString("LoL") ) );
	 }
	
	@Test
	public void stringByAppendingStringTest() {
		NSString testNSString = NSString.fromJavaString("Hello ");
		assertEquals( "Hello NSString!" , 
				testNSString.stringByAppendingString( NSString.fromJavaString("NSString!") ).toString() );
	 }
	
	@Ignore
	@Test
	public void componentsSeparatedByStringTest() throws Exception {
		NSString testNSString = NSString.fromJavaString("A B C D E");
		NSArray chunks = testNSString.componentsSeparatedByString( NSString.fromJavaString(" ") );
		
		assertEquals( 5 , chunks.count() );
		assertEquals( "A" , chunks.objectAtIndex(0).toString() );
		assertEquals( "B" , chunks.objectAtIndex(1).toString() );
		assertEquals( "C" , chunks.objectAtIndex(2).toString() );
		assertEquals( "D" , chunks.objectAtIndex(3).toString() );
		assertEquals( "E" , chunks.objectAtIndex(4).toString() );

	 }
	
	@Test
	public void stringWithUTF8StringTest() {
		CharArr cstring = new CharArr( "!\0".toCharArray() );
		NSString testNSString = NSString.stringWithUTF8String(cstring);
		assertEquals( "!" , testNSString.toString());
	 }
	
	@Test
	public void UTF8StringTest() {
		NSString testNSString = NSString.fromJavaString("Hello UTF8String!");
		CharArr cstring = testNSString.UTF8String();
		NSString fromCString = NSString.stringWithUTF8String(cstring);
		assertEquals( "Hello UTF8String!" , fromCString.toString());
	 }
	
	@Test
	public void stringWithCStringEncodingTest() {
		CharArr cstring = new CharArr( "String With CString Encoding Test\0".toCharArray() );
		NSString fromCString = NSString.stringWithCStringEncoding(cstring, NSStringEncoding.NSUTF8StringEncoding);
		assertEquals( "String With CString Encoding Test" , fromCString.toString());
	 }
		
	@Test
	public void cStringUsingEncodingTest() {
		NSString testObject = NSString.fromJavaString("String With CString Encoding Test");
		CharArr cstring = testObject.cStringUsingEncoding(NSStringEncoding.NSUTF8StringEncoding);
		NSString fromCString = NSString.stringWithCStringEncoding(cstring, NSStringEncoding.NSUTF8StringEncoding);
		assertEquals( "String With CString Encoding Test" , fromCString.toString());
	 }
	
	//Encoding tests
	public void encodingTest(String str, NSStringEncoding enc) {
		NSString testObject = NSString.fromJavaString(str);
		CharArr cstring = testObject.cStringUsingEncoding(enc);
		NSString fromCString = NSString.stringWithCStringEncoding(cstring, enc);
		assertEquals( str , fromCString.toString());
	}
	
	@Test
	public void NSASCIIStringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSASCIIStringEncoding);
	 }
	
	@Test
	public void NSISO2022JPStringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSISO2022JPStringEncoding);
	 }
	
	@Test
	public void NSISOLatin1StringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSISOLatin1StringEncoding);
	 }
	
	@Test
	public void NSJapaneseEUCStringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSJapaneseEUCStringEncoding);
	 }
	
	@Test
	public void NSMacOSRomanStringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSMacOSRomanStringEncoding);
	 }
	
	@Test
	public void NSNEXTSTEPStringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSNEXTSTEPStringEncoding);
	 }
	
	@Test
	public void NSNonLossyASCIIStringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSNonLossyASCIIStringEncoding);
	 }
	
	@Test
	public void NSShiftJISStringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSShiftJISStringEncoding);
	 }
	
	@Test
	public void NSSymbolStringEncodingTest() {
		encodingTest("Στρινγ Ωιτη ΧΣτρινγ Ενχοδινγ Τεστ", NSStringEncoding.NSSymbolStringEncoding);
	}
	
	@Test
	public void NSUTF8StringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSUTF8StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1250StringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSWindowsCP1250StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1251StringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSWindowsCP1251StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1252StringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSWindowsCP1252StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1253StringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSWindowsCP1253StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1254StringEncodingTest() {
		encodingTest("String With CString Encoding Test", NSStringEncoding.NSWindowsCP1254StringEncoding);
	 }
}
