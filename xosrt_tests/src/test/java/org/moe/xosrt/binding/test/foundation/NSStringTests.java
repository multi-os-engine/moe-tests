package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.c.Foundation;
import ios.foundation.enums.Enums;
import ios.foundation.NSArray;
import ios.foundation.NSCharacterSet;
import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSString;
import ios.foundation.enums.NSComparisonResult;
import ios.foundation.enums.NSStringCompareOptions;
import ios.foundation.struct.NSRange;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Ignore;
import org.junit.Test;

import org.moe.natj.general.ptr.CharPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

public class NSStringTests extends XOSTest{

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
                testNSString.compare("Good bye, NSString!") );
    }

    @Test
    public void compareOptionsTest() {
        NSString testNSString = NSString.stringWithString("He11o NSString!");
        assertEquals( NSComparisonResult.Ascending ,
                testNSString.compareOptions("He110 NSString!",
                        NSStringCompareOptions.NumericSearch ));
    }

    @Test
    public void caseInsensetiveCompareTest() {
        NSString testNSString = NSString.stringWithString("Hello NSString!");
        assertEquals( NSComparisonResult.Same ,
                testNSString.caseInsensitiveCompare("hello nsstring!") );
    }

    @Test
    public void localizedCompareTest() {
        NSString testNSString = NSString.stringWithString("NSString!");
        assertEquals( NSComparisonResult.Descending ,
                testNSString.localizedCompare("Hello NSString!") );
    }

    @Test
    public void localizedCaseInsensitiveCompareTest() {
        NSString testNSString = NSString.stringWithString("HeLLo");
        assertEquals( NSComparisonResult.Ascending ,
                testNSString.localizedCaseInsensitiveCompare("Hello NSString!") );
    }

    @Test
    public void localizedStandardCompareTest() {
        NSString testNSString = NSString.stringWithString("Hello NSString!");
        assertEquals( NSComparisonResult.Same ,
                testNSString.localizedStandardCompare("Hello NSString!") );
    }

    @Test
    public void isEqualToStringTest() {
        NSString testNSString = NSString.stringWithString("Hello NSString!");
        assertEquals( true ,
                testNSString.isEqualToString("Hello NSString!") );
        assertEquals( false ,
                testNSString.isEqualToString("LOL") );
    }

    @Test
    public void hasPrefixTest() {
        NSString testNSString = NSString.stringWithString("Hello NSString!");
        assertEquals( true ,
                testNSString.hasPrefix("Hell") );
        assertEquals( false ,
                testNSString.hasPrefix("LOL") );
    }

    @Test
    public void hasSuffixTest() {
        NSString testNSString = NSString.stringWithString("Hello NSString!");
        assertEquals( true ,
                testNSString.hasSuffix("String!") );
        assertEquals( false ,
                testNSString.hasSuffix("LOL") );
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
                testNSString.stringByAppendingString("NSString!").toString() );
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
        String cstring = "String With CString Encoding Test";
        NSString fromCString = NSString.stringWithCStringEncoding(cstring, Enums.NSUTF8StringEncoding);
        assertEquals( cstring , fromCString.toString());
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
    public void ASCIIStringEncodingTest() {
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

    @Test
    public void testInit1() {
        NSString init0 = NSString.alloc().init();
        assertTrue(init0.equals(""));
    }

    @Test
    public void testString1() {
        NSString init1 = NSString.string();
        assertTrue(init1.equals(""));
    }

    @Test
    public void testInitWithBytes_length_encoding1() {
        CharPtr cBytes = PtrFactory.newCharArray("aaa".toCharArray());
        NSString stringInitWithBytes_length_encoding0 = NSString.alloc().initWithBytesLengthEncoding(
                cBytes, 6,  Enums.NSUTF16LittleEndianStringEncoding);
        assertTrue (stringInitWithBytes_length_encoding0.isEqualToString("aaa"));
    }

    @Test
    public void testInitWithData_encoding1() {
        NSData  someData = NSString.stringWithString("aaa").dataUsingEncoding(Enums.NSASCIIStringEncoding);
        NSString initWithData_encoding0 = NSString.alloc().initWithDataEncoding(
                someData, Enums.NSASCIIStringEncoding);

        assertTrue (initWithData_encoding0.isEqualToString("aaa")) ;
    }

    @Test
    public void testInitWithString1() {
        NSString initWithString0 = NSString.stringWithString("string to copy");
        NSString initWithString1 = NSString.alloc().initWithString("string to copy");
        assertTrue (initWithString1.equals(initWithString0));
    }

    @Test
    public void testStringWithString1() {
        NSString stringWithString1 = NSString.stringWithString("string to copy");
        assertTrue (stringWithString1.isEqualToString("string to copy"));
    }

    @Test
    public void testLength1() {
        NSString string0 = NSString.stringWithString("");
        NSString string1 = NSString.stringWithString("1");
        NSString string2 = NSString.stringWithString("test");
        long length0 = string0.length();
        long length1 = string1.length();
        assertTrue (length0 == 0 && length1 == 1 && string2.length() == 4
                && string0.length() + 5 == 5 && string1.length() + 1 == 2);
    }

    @Test
    @Ignore
    //TODO: varargs
    public void testInitWithFormat1() {
//        NSString initWithFormat0 = NSString.alloc().initWithFormat(
//                NSString.stringWithString("this int: %i %@ %% %d %u %x %X %o %.2f %c %.2F"),
//                5, NSString.stringWithString("asd"), 1, 2, 10, 10, 8, 3.5, 's', 3.2);
//        assertTrue(initWithFormat0.isEqualToString(NSString.stringWithString(
//                "this int( 5 asd % 1 2 a A 10 3.50 s 3.20")));
    }

    @Test
    @Ignore
    //TODO: varargs
    public void testStringWithFormat1() {
//        NSString stringWithFormat0 = NSString.stringWithFormat(NSString.stringWithString(
//                "this int: %i %@ %% %d %u %x %X %o %.2f %c %.2F"),
//                5, NSString.stringWithString("abc"), 5, 8, 15, 15, 20, 3.2, 'b', 3.8);
//        assertTrue (stringWithFormat0.isEqualToString(NSString.stringWithString(
//                "this int( 5 abc % 5 8 f F 24 3.20 b 3.80")));
    }

    @Test
    public void testStringWithUTF8String1() {
        NSString stringWithUTF8String0 = NSString.stringWithUTF8String("utf8 c string with characters áéíóúñäëïöüàèìòù");
        assertTrue (stringWithUTF8String0.isEqualToString(
                "utf8 c string with characters áéíóúñäëïöüàèìòù"));
    }

    @Test
    public void testInitWithUTF8String1() {
        NSString stringWithUTF8String1 = NSString.alloc().initWithUTF8String("utf8 c string with characters áéíóúñäëïöüàèìòù");
        assertTrue (stringWithUTF8String1.isEqualToString(
                "utf8 c string with characters áéíóúñäëïöüàèìòù"));
    }

    @Test
    public void testStringByAppendingString1() {
        String stringByAppendingString0 = NSString.alloc().init().stringByAppendingString("string0");
        String stringByAppendingString1 = NSString.stringWithString("string").stringByAppendingString("1");
        NSString stringByAppendingString2 = NSString.stringWithString("st");
        NSString stringByAppendingString3 = NSString.stringWithString("");
        assertTrue (stringByAppendingString0.equals("string0")
                && stringByAppendingString1.equals("string1")
                && stringByAppendingString2.stringByAppendingString(("ring2"))
                    .equals("string2")
                && stringByAppendingString3.stringByAppendingString(("string3"))
                    .equals("string3")
                && NSString.stringWithString("string").stringByAppendingString(("4"))
                    .equals("string4")
                && NSString.stringWithString("").stringByAppendingString(("string5"))
                    .equals("string5")
                && NSString.stringWithString("").stringByAppendingString((""))
                    .equals("")) ;
    }

    @Test
    @Ignore
    //TODO: varargs
    public void testStringByAppendingFormat1() {
//        NSString stringByAppendingFormat0 = NSString.stringWithString("sum(");
//        NSString stringByAppendingFormat1 = stringByAppendingFormat0.stringByAppendingFormat(
//                NSString.stringWithString("2+1)=%d"), 3);
//        assertTrue (stringByAppendingFormat1.isEqualToString(NSString.stringWithString("sum(2+1)=3")));
    }

    @Test
    public void testStringByReplacingOccurrencesOfString_withString1() {
        assertTrue(NSString.stringWithString("afaialae.txt").stringByReplacingOccurrencesOfStringWithString(
                    "a", "")
                .equals("file.txt")
                && NSString.stringWithString(");.-o").stringByReplacingOccurrencesOfStringWithString(
                    ");.-", "hell")
                .equals("hello")
                && NSString.stringWithString("U$S").stringByReplacingOccurrencesOfStringWithString(
                    "asd", "$$$")
                .equals("U$S"));
    }

    @Test
    public void testStringByReplacingCharactersInRange_withString1() {
        NSString stringByReplacingStringx = NSString.stringWithString("abxxxfgh");
        NSRange aRange = Foundation.NSMakeRange(2, 3);
        String newString = stringByReplacingStringx.stringByReplacingCharactersInRangeWithString(
                aRange, "cde");
        assertTrue(newString.equals("abcdefgh"));
    }

    @Test
    public void testStringByTrimmingCharactersInSet1() {

        NSCharacterSet whitespaces = NSCharacterSet.whitespaceCharacterSet();
        assertTrue(NSString.stringWithString("    with spaces before and after   ")
                .stringByTrimmingCharactersInSet(whitespaces)
                .equals("with spaces before and after"));
    }

    @Test
    public void testStringByAddingPercentEscapesUsingEncoding1() {
        NSString tStr1 = NSString.stringWithString("string append string");
        NSString tStr2 = NSString.stringWithString("string%20append%20string");
        assertTrue(tStr1.stringByAddingPercentEscapesUsingEncoding(Enums.NSASCIIStringEncoding)
        		.equals(tStr2.description()));
    }

    @Test
    public void testComponentsSeparatedByString1() {
        NSArray arrayComponentsSeparatedByString0 = NSString.stringWithString("1.2").componentsSeparatedByString(".");
        NSString stringComponentsSeparatedByString0 = NSString.stringWithString(",\n 111,\n 22222");
        NSArray arrayComponentsSeparatedByString1 = stringComponentsSeparatedByString0
                .componentsSeparatedByString(",\n ");
        NSArray arrayComponentsSeparatedByString2 = NSString.stringWithString("23le")
                .componentsSeparatedByString("le");
        NSArray arrayComponentsSeparatedByString3 = NSString.stringWithString("12le12le")
                .componentsSeparatedByString("12le");
        assertEquals ( 2, arrayComponentsSeparatedByString0.count()); 
        assertEquals ( "1", arrayComponentsSeparatedByString0.objectAtIndex(0));
        assertEquals ( "2", arrayComponentsSeparatedByString0.objectAtIndex(1));
        assertEquals ( 3, arrayComponentsSeparatedByString1.count()); 
        assertEquals ( "", arrayComponentsSeparatedByString1.objectAtIndex(0));
        assertEquals ( "111", arrayComponentsSeparatedByString1.objectAtIndex(1));
        assertEquals ( "22222", arrayComponentsSeparatedByString1.objectAtIndex(2));
        assertEquals ( 2, arrayComponentsSeparatedByString2.count());
        assertEquals ( "23", arrayComponentsSeparatedByString2.objectAtIndex(0));
        assertEquals ( "", arrayComponentsSeparatedByString2.objectAtIndex(1));
        assertEquals ( 3, arrayComponentsSeparatedByString3.count());
        assertEquals ( "", arrayComponentsSeparatedByString3.objectAtIndex(0));
        assertEquals ( "", arrayComponentsSeparatedByString3.objectAtIndex(1));
        assertEquals ( "", arrayComponentsSeparatedByString3.objectAtIndex(2));
    }

    @Test
    public void testSubstringFromIndex1() {
        NSString substringFromIndex0 = NSString.stringWithString("a string0.");
        NSString substringFromIndex1 = NSString.stringWithString("a string1.");
        assertTrue (substringFromIndex0.substringFromIndex(1).equals((" string0."))
                && substringFromIndex1.substringFromIndex(0).equals(("a string1.")));
    }

    @Test
    public void testSubstringWithRange1() {
        NSRange rangeSubstringWithRange = Foundation.NSMakeRange(1, 2);
        NSString substringWithRange0 = NSString.stringWithString("one");
        NSString substringWithRange1 = NSString.stringWithString("test text");
        assertTrue (substringWithRange0.substringWithRange(rangeSubstringWithRange)
                    .equals(("ne"))
                && substringWithRange1.substringWithRange(Foundation.NSMakeRange(0, 0))
                    .equals((""))
                && substringWithRange1.substringWithRange(Foundation.NSMakeRange(0, substringWithRange1.length()))
                    .equals(("test text"))
        );
    }

    @Test
    public void testSubstringToIndex1() {
        NSString substringToIndex0 = NSString.stringWithString("test.substring0");
        String substringToIndex1 = NSString.stringWithString("test.substring1").substringToIndex(0);
        NSString substringToIndex2 = NSString.stringWithString("test.substring2");
        assertTrue (substringToIndex0.substringToIndex(4).equals("test")
                && substringToIndex1.equals("")
                && substringToIndex2.substringToIndex(substringToIndex2.length()) != null
        );
    }

    @Test
    public void testRangeOfString1() {
        NSString rangeOfString0 = NSString.stringWithString("I will try to find a word inside");
        NSRange aRange = rangeOfString0.rangeOfString("word");
        assertEquals ( 21, aRange.location());
        assertEquals ( 4, aRange.length());
        assertEquals ( Foundation.NSNotFound, rangeOfString0.rangeOfString("").location());
        assertEquals ( 0, rangeOfString0.rangeOfString("").length());
        assertEquals ( Foundation.NSNotFound, rangeOfString0.rangeOfString("notFoundString").location());
        assertEquals ( 0, rangeOfString0.rangeOfString("notFoundString").length());
    }

    @Test
    public void testRangeOfString_options1() {

        NSString rangeOfStringOptions0 = NSString.stringWithString("I will try to find a word inside");
        NSRange aRangeOfStringOptions0 = rangeOfStringOptions0.rangeOfStringOptions("word", NSStringCompareOptions.CaseInsensitiveSearch);
        assertTrue (aRangeOfStringOptions0.location() == 21 && aRangeOfStringOptions0.length() == 4) ;
    }

    @Test
    public void testRangeOfString_options_range1() {
        NSRange range0 = Foundation.NSMakeRange(15, 15), range1 , range2;
        range1 = NSString.stringWithString("I.will try to find a word inside")
                .rangeOfStringOptionsRange("Word",
                            NSStringCompareOptions.CaseInsensitiveSearch, range0);
        range2 = NSString.stringWithString("I.will try to find a word inside")
                .rangeOfStringOptionsRange("food",
                        NSStringCompareOptions.CaseInsensitiveSearch, range0);
        assertEquals( Foundation.NSNotFound, range2.location());
        assertEquals( 21, range1.location());
        assertEquals( 4, range1.length());
    }

    @Test
    public void testCompare1() {
        NSString compare0 = NSString.stringWithString("A0");
        NSString compare2 = NSString.stringWithString("A2");
        assertTrue (compare0.compare("A1") == NSComparisonResult.Ascending
                && compare2.compare("A1") == NSComparisonResult.Descending
                && compare2.compare("A2") == NSComparisonResult.Same) ;
    }

    @Test
    public void testCompare_options1() {
        assertTrue (NSString.stringWithString("AEIOU").compareOptions("aeiou",
                NSStringCompareOptions.CaseInsensitiveSearch) == NSComparisonResult.Same);
    }

    @Test
    public void testHasPrefix1() {
        NSString stringHasPrefix = NSString.stringWithString("I will try to find a prefix inside");
        boolean aBool = stringHasPrefix.hasPrefix("I will");
        assertTrue (aBool) ;
    }

    @Test
    public void testHasSuffix1() {
        NSString hasSuffix0 = NSString.stringWithString("I will try to find a word inside");
        assertTrue (hasSuffix0.hasSuffix("inside"));
    }

    @Test
    public void testIsEqualToString1() {
        NSString  aString45a = NSString.stringWithString("a simple string");
        NSString  aString45b = NSString.stringWithString("a simple string");
        NSString aString45c = NSString.stringWithString("asd");
        assertTrue (aString45a.isEqualToString("a simple string") && aString45b.isEqualToString("a simple string")
                && !aString45a.isEqualToString("asd") && !aString45b.isEqualToString(null)
                && !aString45c.isEqualToString(null) && !aString45b.isEqualToString(null)
        );
    }

    @Test
    public void testIsEqual1() {
        NSString  aString46a = NSString.stringWithString("a simple string");
        NSString  aString46b = NSString.stringWithString("a simple string");
        NSString aString46c = NSString.stringWithString("asd");
        NSString aString46d = null;
        assertTrue (aString46a.isEqual(aString46b) && aString46b.isEqual(aString46a)
                && !aString46a.isEqual(aString46c) && !aString46b.isEqual(aString46d)
                && !aString46c.isEqual(null) && aString46b.isEqual(aString46b)
        );
    }

    @Test
    public void testLowercaseString1() {
        NSString lowercaseString0 = NSString.stringWithString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertTrue(lowercaseString0.lowercaseString().equals("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void testUppercaseString1() {
        NSString uppercaseString0 = NSString.stringWithString("abcdefghijklmnopqrstuvwxyz");
        assertTrue(uppercaseString0.uppercaseString().equals("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void testCaseInsensitiveCompare1() {
        NSString str0 = NSString.stringWithString("AbC");
        NSString str2 = NSString.stringWithString("aaa");
        NSString str4 = NSString.stringWithString("baa");
        assertTrue (str0.caseInsensitiveCompare("Abc") == NSComparisonResult.Same
                && str2.caseInsensitiveCompare("Baa") == NSComparisonResult.Ascending
                && str4.caseInsensitiveCompare("AAa") == NSComparisonResult.Descending);
    }

    @Test
    public void testIntValue1() {
        NSString intValue0 = NSString.stringWithString(" 25");
        NSString intValue1 = NSString.stringWithString("-25");
        int anInt = intValue0.intValue();
        assertTrue (anInt == 25 && intValue1.intValue() == -25 && intValue1.intValue() + 10 == -15);
    }

    @Test
    public void testFloatValue1() {
        NSString floatValue0 = NSString.stringWithString("1.23");
        assertTrue (floatValue0.floatValue() - 1.23 < 0.0000001) ;
    }

    @Test
    public void testIntegerValue1() {
        NSString integerValue0 = NSString.stringWithString("11");
        assertTrue (integerValue0.integerValue() == 11) ;
    }

    @Test
    public void testDoubleValue1() {
        NSString doubleValue0 = NSString.stringWithString("1.23000000001");
        assertTrue (doubleValue0.doubleValue() - 1.23000000001 < 0.000001) ;
    }

    @Test
    public void testBoolValue1() {
        NSString boolValue0 = NSString.stringWithString("Y");
        NSString boolValue1 = NSString.stringWithString(" y");
        NSString boolValue2 = NSString.stringWithString("T");
        NSString boolValue3 = NSString.stringWithString("t");
        NSString boolValue4 = NSString.stringWithString("1");
        NSString boolValue5 = NSString.stringWithString(" 2");
        NSString boolValue6 = NSString.stringWithString("3");
        NSString boolValue7 = NSString.stringWithString("4");
        NSString boolValue8 = NSString.stringWithString("5");
        NSString boolValue9 = NSString.stringWithString(" 6");
        NSString boolValue10 = NSString.stringWithString("7");
        NSString boolValue11 = NSString.stringWithString("8");
        NSString boolValue12 = NSString.stringWithString(" 9");
        NSString boolValue13 = NSString.stringWithString("-0002");
        NSString boolValue14 = NSString.stringWithString("-000007");
        NSString boolValue15 = NSString.stringWithString("adsa");
        NSString boolValue16 = NSString.stringWithString("0");
        NSString boolValue17 = NSString.stringWithString("asdYasd");
        NSString boolValue18 = NSString.stringWithString("atasd");
        NSString boolValue19 = NSString.stringWithString(" -0.1");
        NSString boolValue20 = NSString.stringWithString(" -07.1");
        assertTrue (boolValue0.boolValue() && boolValue1.boolValue() && boolValue2.boolValue()
                && boolValue3.boolValue() && boolValue4.boolValue() && boolValue5.boolValue()
                && boolValue6.boolValue() && boolValue7.boolValue() && boolValue8.boolValue()
                && boolValue9.boolValue() && boolValue10.boolValue() && boolValue11.boolValue()
                && boolValue12.boolValue() && boolValue13.boolValue() && boolValue14.boolValue()
                && !boolValue15.boolValue() && !boolValue16.boolValue() && !boolValue17.boolValue()
                && !boolValue18.boolValue() && !boolValue19.boolValue() && boolValue20.boolValue()
        );
    }

    @Test
    public void testLongLongValue1() {
        NSString longLongString0 = NSString.stringWithString("123456789123456");
        long longLong0 = 123456789123456L;
        assertTrue (longLongString0.longLongValue() == longLong0);
    }

    @Test
    public void testCharacterAtIndex1() {
        NSString stringCharacterAtIndex0 = NSString.stringWithString("I will try to find a character inside");
        assertTrue (stringCharacterAtIndex0.characterAtIndex(2) == 'w') ;
    }

    @Test
    public void testGetCharacters_range1() {
        NSString stringA = NSString.stringWithString("ZABCDEFGHY123456");
        NSRange range0 = Foundation.NSMakeRange(1, 6);
        CharPtr aBuffer = PtrFactory.newCharArray(new char[5]);
        stringA.getCharactersRange(aBuffer, range0);
        assertTrue (aBuffer.get(0) == 65 && aBuffer.get(1) == 66 && aBuffer.get(2) == 67
                && aBuffer.get(3) == 68 && aBuffer.get(4) == 69);
    }

    @Test
    public void testUTF8String1() {
        NSString uTF8String0 = NSString.stringWithString("test");
        char[] aCString = uTF8String0.UTF8String().toCharArray();

        assertTrue ((aCString[0] =='t') && (aCString[1] =='e')&&(aCString[2] =='s')
                &&(aCString[3] =='t'));
    }

    @Test
    public void testInitWithCString_encoding1() {
        NSString stringWithCString0 = NSString.alloc().initWithCStringEncoding(
        		"This is ASCII", Enums.NSASCIIStringEncoding);
        assertTrue (stringWithCString0.isEqualToString("This is ASCII"));
    }

    @Test
    public void testStringWithCString_encoding1() {
        NSString stringWithCString1 = NSString.stringWithCStringEncoding(
        		"This is ASCII", Enums.NSASCIIStringEncoding);
        assertTrue (stringWithCString1.isEqualToString("This is ASCII"));
    }

    @Test
    public void testDescription1() {
        NSString description0 = NSString.stringWithString(" 25");
        NSString description1 = NSString.stringWithString("test1");
        assertTrue (description0.description().equals(" 25")
                && description1.isEqualToString(description1.description()));
    }

    @Test
    public void testDataUsingEncoding1() {
        NSString stringDataUsingEncodign0 = NSString.stringWithString("hola");
        NSData  dataDataUsingEncoding = stringDataUsingEncodign0.dataUsingEncoding(
                Enums.NSASCIIStringEncoding);
        NSRange aRange = NSString.stringWithString(dataDataUsingEncoding.description()).rangeOfString("686f6c61");
        assertTrue (aRange.location() != 0) ;
    }

    @Test
    public void testStringByAppendingPathComponent1() {
        assertTrue(NSString.stringWithString("/tmp").stringByAppendingPathComponent("afaialae.txt")
        		.equals("/tmp/afaialae.txt"));
    }

    @Test
    public void testStringByPaddingToLength_withString_startingAtIndex1() {
        NSString string0 = NSString.stringWithString("1");
        String string1 = string0.stringByPaddingToLengthWithStringStartingAtIndex(
                10, ". ", 1);
        assertTrue (string1.equals("1 . . . . "));
    }

    @Test
    public void testPropertyListFromStringsFileFormat1() {
        NSString newDesc5 = NSString.stringWithString("aa = 11; bb = 22;");
        NSDictionary newDict5 = newDesc5.propertyListFromStringsFileFormat();
        assertTrue (newDict5.count() == 2) ;
    }
    
	@Test
	public void arrayOfNativeObjectsInitialisation() {
		

		Ptr<NSString> testObject = PtrFactory.newObjectPtr(NSString.class, 100, true, true);

		for ( int i = 0; i < 100; i++ ) {
			testObject.set(i, NSString.stringWithCString(Integer.valueOf(i).toString()));
		}

		for ( int i = 0; i < 100; i++) {
			assertEquals( Integer.valueOf(i).toString() , testObject.get(i).toString() );
		}
	}

}
