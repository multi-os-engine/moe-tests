package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ios.foundation.NSArray;
import ios.foundation.NSString;
import ios.foundation.enums.Enums;
import ios.foundation.enums.NSComparisonResult;
import ios.foundation.enums.NSStringCompareOptions;

import org.junit.Ignore;
import org.junit.Test;

public class NSStringTests2 {
	
	@Test
	public void simpleStaticCreationTest() {
		NSString testNSString = NSString.string();
		assertNotNull(testNSString);
	 }
	
	@Test
	public void toStringTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( "Hello NSString!" , testNSString.toString());
	 }
	
	
	@Test
	public void substringFromIndexTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( "NSString!" , testNSString.substringFromIndex(6L).toString());
	 }
	
	@Test
	public void substringToIndexTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( "Hello " , testNSString.substringToIndex(6L).toString());
	 }
	
	@Test
	public void compareTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( NSComparisonResult.Descending ,
				testNSString.compare( "Good bye, NSString!") );
	 }

	@Test
	public void compareOptionsTest() {
		NSString testNSString = NSString.stringWithString("He11o NSString!");
		assertEquals( NSComparisonResult.Ascending ,
				testNSString.compareOptions( "He110 NSString!", NSStringCompareOptions.NumericSearch ));
	 }
	
	@Test
	public void caseInsensetiveCompareTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( NSComparisonResult.Same ,
				testNSString.caseInsensitiveCompare( "hello nsstring!") );
	 }
	
	@Test
	public void localizedCompareTest() {
		NSString testNSString = NSString.stringWithString("NSString!");
		assertEquals( NSComparisonResult.Descending ,
				testNSString.localizedCompare( "Hello NSString!") );
	 }
	
	@Test
	public void localizedCaseInsensitiveCompareTest() {
		NSString testNSString = NSString.stringWithString("HeLLo");
		assertEquals( NSComparisonResult.Ascending ,
				testNSString.localizedCaseInsensitiveCompare( "Hello NSString!") );
	 }
	
	@Test
	public void localizedStandardCompareTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( NSComparisonResult.Same ,
				testNSString.localizedStandardCompare( "Hello NSString!") );
	 }
	
	@Test
	public void isEqualToStringTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( true , 
				testNSString.isEqualToString( "Hello NSString!") );
		assertEquals( false , 
				testNSString.isEqualToString( "LOL") );
	 }
	
	@Test
	public void hasPrefixTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( true , 
				testNSString.hasPrefix( "Hell") );
		assertEquals( false , 
				testNSString.hasPrefix( "LOL") );
	 }
	
	@Test
	public void hasSuffixTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( true , 
				testNSString.hasSuffix( "String!") );
		assertEquals( false , 
				testNSString.hasSuffix( "LOL") );
	 }
	
	@Test
	public void containsStringTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( true , 
				testNSString.containsString("llo N") );
		assertEquals( false , 
				testNSString.containsString("LOL") );
	 }
	 
	@Test
	public void localizedCaseInsensitiveContainsStringTest() {
		NSString testNSString = NSString.stringWithString("Hello NSString!");
		assertEquals( true , 
				testNSString.localizedCaseInsensitiveContainsString("lLO n") );
		assertEquals( false , 
				testNSString.localizedCaseInsensitiveContainsString("LoL") );
	 }
	
	@Test
	public void stringByAppendingStringTest() {
		NSString testNSString = NSString.stringWithString("Hello ");
		assertEquals( "Hello NSString!" , 
				testNSString.stringByAppendingString("NSString!") );
	 }
	
	@Test
	public void componentsSeparatedByStringTest() throws Exception {
		NSString testNSString = NSString.stringWithString("A B C D E");
		NSArray chunks = testNSString.componentsSeparatedByString(" ");
		
		assertEquals( 5 , chunks.count() );
		assertEquals( "A" , chunks.objectAtIndex(0).toString() );
		assertEquals( "B" , chunks.objectAtIndex(1).toString() );
		assertEquals( "C" , chunks.objectAtIndex(2).toString() );
		assertEquals( "D" , chunks.objectAtIndex(3).toString() );
		assertEquals( "E" , chunks.objectAtIndex(4).toString() );

	 }
	
	@Test
	public void stringWithUTF8StringTest() {
		NSString testNSString = NSString.stringWithUTF8String("!");
		assertEquals( "!" , testNSString.toString());
	 }
	
	@Test
	public void UTF8StringTest() {
		NSString testNSString = NSString.stringWithString("Hello UTF8String!");
		String cstring = testNSString.UTF8String();
		NSString fromCString = NSString.stringWithUTF8String(cstring);
		assertEquals( "Hello UTF8String!" , fromCString.toString());
	 }
	
	@Test
	public void stringWithCStringEncodingTest() {
		NSString fromCString = NSString.stringWithCStringEncoding("String With CString Encoding Test", Enums.NSUTF8StringEncoding);
		assertEquals( "String With CString Encoding Test" , fromCString.toString());
	 }
		
	@Test
	public void cStringUsingEncodingTest() {
		NSString testObject = NSString.stringWithString("String With CString Encoding Test");
		String cstring = testObject.cStringUsingEncoding(Enums.NSUTF8StringEncoding);
		NSString fromCString = NSString.stringWithCStringEncoding(cstring, Enums.NSUTF8StringEncoding);
		assertEquals( "String With CString Encoding Test" , fromCString.toString());
	 }
	
	//Encoding tests
	public void encodingTest(String str, long enc) {
		NSString testObject = NSString.stringWithString(str);
		String cstring = testObject.cStringUsingEncoding(enc);
		NSString fromCString = NSString.stringWithCStringEncoding(cstring, enc);
		assertEquals( str , fromCString.toString());
	}
	
	@Test
	public void NSASCIIStringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSASCIIStringEncoding);
	 }
	
	@Test
	public void NSISO2022JPStringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSISO2022JPStringEncoding);
	 }
	
	@Test
	public void NSISOLatin1StringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSISOLatin1StringEncoding);
	 }
	
	@Test
	public void NSJapaneseEUCStringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSJapaneseEUCStringEncoding);
	 }
	
	@Test
	public void NSMacOSRomanStringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSMacOSRomanStringEncoding);
	 }
	
	@Test
	public void NSNEXTSTEPStringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSNEXTSTEPStringEncoding);
	 }
	
	@Test
	public void NSNonLossyASCIIStringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSNonLossyASCIIStringEncoding);
	 }
	
	@Test
	public void NSShiftJISStringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSShiftJISStringEncoding);
	 }

    //TODO: crushes simulator!
    @Ignore
	@Test
	public void NSSymbolStringEncodingTest() {
		encodingTest("Στρινγ Ωιτη ΧΣτρινγ Ενχοδινγ Τεστ", Enums.NSSymbolStringEncoding);
	}
	
	@Test
	public void NSUTF8StringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSUTF8StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1250StringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSWindowsCP1250StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1251StringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSWindowsCP1251StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1252StringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSWindowsCP1252StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1253StringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSWindowsCP1253StringEncoding);
	 }
	
	@Test
	public void NSWindowsCP1254StringEncodingTest() {
		encodingTest("String With CString Encoding Test", Enums.NSWindowsCP1254StringEncoding);
	 }
}
