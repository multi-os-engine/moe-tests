package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.CharArr;
import xosrt.binding.arrays.ShortArr;
import xosrt.binding.foundation.*;
import xosrt.binding.pointers.CharPtr;
import xosrt.binding.pointers.ShortPtr;
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
        assertEquals( NSComparisonResult.Descending ,
                testNSString.compare( NSString.fromJavaString("Good bye, NSString!") ));
    }

    @Test
    public void compareOptionsTest() {
        NSString testNSString = NSString.fromJavaString("He11o NSString!");
        assertEquals( NSComparisonResult.Ascending ,
                testNSString.compareOptions( NSString.fromJavaString("He110 NSString!"),
                        NSStringCompareOptions.NumericSearch ));
    }

    @Test
    public void caseInsensetiveCompareTest() {
        NSString testNSString = NSString.fromJavaString("Hello NSString!");
        assertEquals( NSComparisonResult.Same ,
                testNSString.caseInsensitiveCompare( NSString.fromJavaString("hello nsstring!") ) );
    }

    @Test
    public void localizedCompareTest() {
        NSString testNSString = NSString.fromJavaString("NSString!");
        assertEquals( NSComparisonResult.Descending ,
                testNSString.localizedCompare( NSString.fromJavaString("Hello NSString!") ) );
    }

    @Test
    public void localizedCaseInsensitiveCompareTest() {
        NSString testNSString = NSString.fromJavaString("HeLLo");
        assertEquals( NSComparisonResult.Ascending ,
                testNSString.localizedCaseInsensitiveCompare( NSString.fromJavaString("Hello NSString!") ) );
    }

    @Test
    public void localizedStandardCompareTest() {
        NSString testNSString = NSString.fromJavaString("Hello NSString!");
        assertEquals( NSComparisonResult.Same ,
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

        assertEquals( 5 , chunks.getCount() );
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
        CharPtr cstring = testNSString.getUTF8String();
        NSString fromCString = NSString.stringWithUTF8String(cstring);
        assertEquals( "Hello UTF8String!" , fromCString.toString());
    }

    @Test
    public void stringWithCStringEncodingTest() {
        CharArr cstring = new CharArr( "String With CString Encoding Test\0".toCharArray() );
        NSString fromCString = NSString.stringWithCStringEncoding(cstring, NSStringEncoding.UTF8StringEncoding);
        assertEquals( "String With CString Encoding Test" , fromCString.toString());
    }

    @Test
    public void cStringUsingEncodingTest() {
        NSString testObject = NSString.fromJavaString("String With CString Encoding Test");
        CharPtr cstring = testObject.cStringUsingEncoding(NSStringEncoding.UTF8StringEncoding);
        NSString fromCString = NSString.stringWithCStringEncoding(cstring, NSStringEncoding.UTF8StringEncoding);
        assertEquals( "String With CString Encoding Test" , fromCString.toString());
    }

    //Encoding tests
    public void encodingTest(String str, long enc) {
        NSString testObject = NSString.fromJavaString(str);
        CharPtr cstring = testObject.cStringUsingEncoding(enc);
        NSString fromCString = NSString.stringWithCStringEncoding(cstring, enc);
        assertEquals( str , fromCString.toString());
    }

    @Test
    public void ASCIIStringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.ASCIIStringEncoding);
    }

    @Test
    public void NSISO2022JPStringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.ISO2022JPStringEncoding);
    }

    @Test
    public void NSISOLatin1StringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.ISOLatin1StringEncoding);
    }

    @Test
    public void NSJapaneseEUCStringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.JapaneseEUCStringEncoding);
    }

    @Test
    public void NSMacOSRomanStringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.MacOSRomanStringEncoding);
    }

    @Test
    public void NSNEXTSTEPStringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.NEXTSTEPStringEncoding);
    }

    @Test
    public void NSNonLossyASCIIStringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.NonLossyASCIIStringEncoding);
    }

    @Test
    public void NSShiftJISStringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.ShiftJISStringEncoding);
    }

    @Test
    public void NSSymbolStringEncodingTest() {
        encodingTest("Στρινγ Ωιτη ΧΣτρινγ Ενχοδινγ Τεστ", NSStringEncoding.SymbolStringEncoding);
    }

    @Test
    public void NSUTF8StringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.UTF8StringEncoding);
    }

    @Test
    public void NSWindowsCP1250StringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.WindowsCP1250StringEncoding);
    }

    @Test
    public void NSWindowsCP1251StringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.WindowsCP1251StringEncoding);
    }

    @Test
    public void NSWindowsCP1252StringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.WindowsCP1252StringEncoding);
    }

    @Test
    public void NSWindowsCP1253StringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.WindowsCP1253StringEncoding);
    }

    @Test
    public void NSWindowsCP1254StringEncodingTest() {
        encodingTest("String With CString Encoding Test", NSStringEncoding.WindowsCP1254StringEncoding);
    }

    @Test
    public void testInit1() {
        NSString init0 = NSString.alloc().init();
        assertTrue(init0.isEqualToString(NSString.fromJavaString("")));
    }

    @Test
    public void testString1() {
        NSString init1 = NSString.string();
        assertTrue(init1.isEqualToString(NSString.fromJavaString("")));
    }

    @Test
    public void testInitWithBytes_length_encoding1() {
        CharArr cBytes = new CharArr("aaa".toCharArray());
        NSString stringInitWithBytes_length_encoding0 = NSString.alloc().initWithBytesLengthEncoding(
                cBytes, 3,  NSStringEncoding.ASCIIStringEncoding);
        assertTrue (stringInitWithBytes_length_encoding0.isEqualToString(NSString.fromJavaString("aaa")));
    }

    @Test
    public void testInitWithData_encoding1() {
        NSData  someData = NSString.fromJavaString("aaa").dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding);
        NSString initWithData_encoding0 = NSString.alloc().initWithDataEncoding(
                someData, NSStringEncoding.ASCIIStringEncoding);
        NSString initWithData_encoding1 = NSString.fromJavaString("aaa");

        assertTrue (initWithData_encoding0.isEqualToString(initWithData_encoding1)) ;
    }

    @Test
    public void testInitWithString1() {
        NSString initWithString0 = NSString.fromJavaString("string to copy");
        NSString initWithString1 = NSString.alloc().initWithString(initWithString0);
        assertTrue (initWithString1.isEqualToString(NSString.fromJavaString("string to copy")));
    }

    @Test
    public void testStringWithString1() {
        NSString stringWithString0 = NSString.fromJavaString("string to copy");
        NSString stringWithString1 = NSString.stringWithString(stringWithString0);
        assertTrue (stringWithString1.isEqualToString(NSString.fromJavaString("string to copy")));
    }

    @Test
    public void testLength1() {
        NSString string0 = NSString.fromJavaString("");
        NSString string1 = NSString.fromJavaString("1");
        NSString string2 = NSString.fromJavaString("test");
        long length0 = string0.getLength();
        long length1 = string1.getLength();
        assertTrue (length0 == 0 && length1 == 1 && string2.getLength() == 4
                && string0.getLength() + 5 == 5 && string1.getLength() + 1 == 2);
    }

    //TODO: unimplemented methods
    /*
    @Test
    public void testInitWithFormat1() {
        NSString initWithFormat0 = NSString.alloc().initWithFormat(
                NSString.fromJavaString("this int: %i %@ %% %d %u %x %X %o %.2f %c %.2F"),
                5, NSString.fromJavaString("asd"), 1, 2, 10, 10, 8, 3.5, 's', 3.2);
        assertTrue(initWithFormat0.isEqualToString(NSString.fromJavaString(
                "this int( 5 asd % 1 2 a A 10 3.50 s 3.20")));
    }

    @Test
    public void testStringWithFormat1() {
        NSString stringWithFormat0 = NSString.stringWithFormat(NSString.fromJavaString(
                "this int: %i %@ %% %d %u %x %X %o %.2f %c %.2F"),
                5, NSString.fromJavaString("abc"), 5, 8, 15, 15, 20, 3.2, 'b', 3.8);
        assertTrue (stringWithFormat0.isEqualToString(NSString.fromJavaString(
                "this int( 5 abc % 5 8 f F 24 3.20 b 3.80")));
    }
*/
    @Test
    public void testStringWithUTF8String1() {
        CharArr chars = new CharArr("utf8 c string with characters áéíóúñäëïöüàèìòù".toCharArray());
        NSString stringWithUTF8String0 = NSString.stringWithUTF8String(chars);
        assertTrue (stringWithUTF8String0.isEqualToString(NSString.fromJavaString(
                "utf8 c string with characters áéíóúñäëïöüàèìòù")));
    }

    @Test
    public void testInitWithUTF8String1() {
        CharArr chars = new CharArr("utf8 c string with characters áéíóúñäëïöüàèìòù".toCharArray());
        NSString stringWithUTF8String1 = NSString.alloc().initWithUTF8String(chars);
        assertTrue (stringWithUTF8String1.isEqualToString(NSString.fromJavaString(
                "utf8 c string with characters áéíóúñäëïöüàèìòù")));
    }

    @Test
    public void testStringByAppendingString1() {
        NSString stringByAppendingString0 = NSString.alloc().init().stringByAppendingString(
                NSString.fromJavaString("string0"));
        NSString stringByAppendingString1 = NSString.fromJavaString("string").stringByAppendingString(
                NSString.fromJavaString("1"));
        NSString stringByAppendingString2 = NSString.fromJavaString("st");
        NSString stringByAppendingString3 = NSString.fromJavaString("");
        assertTrue (stringByAppendingString0.isEqualToString(NSString.fromJavaString("string0"))
                && stringByAppendingString1.isEqualToString(NSString.fromJavaString("string1"))
                && stringByAppendingString2.stringByAppendingString(NSString.fromJavaString("ring2"))
                    .isEqualToString(NSString.fromJavaString("string2"))
                && stringByAppendingString3.stringByAppendingString(NSString.fromJavaString("string3"))
                    .isEqualToString(NSString.fromJavaString("string3"))
                && NSString.fromJavaString("string").stringByAppendingString(NSString.fromJavaString("4"))
                    .isEqualToString(NSString.fromJavaString("string4"))
                && NSString.fromJavaString("").stringByAppendingString(NSString.fromJavaString("string5"))
                    .isEqualToString(NSString.fromJavaString("string5"))
                && NSString.fromJavaString("").stringByAppendingString(NSString.fromJavaString(""))
                    .isEqualToString(NSString.fromJavaString(""))) ;
    }

    //TODO: unimplemented methods
    /*
    @Test
    public void testStringByAppendingFormat1() {
        NSString stringByAppendingFormat0 = NSString.fromJavaString("sum(");
        NSString stringByAppendingFormat1 = stringByAppendingFormat0.stringByAppendingFormat(
                NSString.fromJavaString("2+1)=%d"), 3);
        assertTrue (stringByAppendingFormat1.isEqualToString(NSString.fromJavaString("sum(2+1)=3")));
    }
    */

    @Test
    public void testStringByReplacingOccurrencesOfString_withString1() {
        assertTrue(NSString.fromJavaString("afaialae.txt").stringByReplacingOccurrencesOfStringWithString(
                    NSString.fromJavaString("a"), NSString.fromJavaString(""))
                .isEqualToString(NSString.fromJavaString("file.txt"))
                && NSString.fromJavaString(");.-o").stringByReplacingOccurrencesOfStringWithString(
                    NSString.fromJavaString(");.-"), NSString.fromJavaString("hell"))
                .isEqualToString(NSString.fromJavaString("hello"))
                && NSString.fromJavaString("U$S").stringByReplacingOccurrencesOfStringWithString(
                    NSString.fromJavaString("asd"), NSString.fromJavaString("$$$"))
                .isEqualToString(NSString.fromJavaString("U$S")));
    }

    @Test
    public void testStringByReplacingCharactersInRange_withString1() {
        NSString stringByReplacingStringx = NSString.fromJavaString("abxxxfgh");
        NSString stringx = NSString.fromJavaString("cde");
        NSRange aRange = Foundation.NSMakeRange(2, 3);
        NSString newString = stringByReplacingStringx.stringByReplacingCharactersInRangeWithString(
                aRange, stringx);
        assertTrue(newString.isEqualToString(NSString.fromJavaString("abcdefgh")));
    }

    @Test
    public void testStringByTrimmingCharactersInSet1() {

        NSCharacterSet whitespaces = NSCharacterSet.whitespaceCharacterSet();
        assertTrue(NSString.fromJavaString("    with spaces before and after   ")
                .stringByTrimmingCharactersInSet(whitespaces)
                .isEqualToString(NSString.fromJavaString("with spaces before and after")));
    }

    @Test
    public void testStringByAddingPercentEscapesUsingEncoding1() {
        NSString tStr1 = NSString.fromJavaString("string append string");
        NSString tStr2 = NSString.fromJavaString("string%20append%20string");
        tStr1 = tStr1.stringByAddingPercentEscapesUsingEncoding(NSStringEncoding.ASCIIStringEncoding);
        assertTrue(tStr1.isEqualToString(tStr2));
    }

    @Test
    public void testComponentsSeparatedByString1() {
        NSArray arrayComponentsSeparatedByString0 = NSString.fromJavaString("1.2").componentsSeparatedByString(
                NSString.fromJavaString(" "));
        NSString stringComponentsSeparatedByString0 = NSString.fromJavaString(",\n 111,\n 22222");
        NSArray arrayComponentsSeparatedByString1 = stringComponentsSeparatedByString0
                .componentsSeparatedByString(NSString.fromJavaString(",\n "));
        NSArray arrayComponentsSeparatedByString2 = NSString.fromJavaString("23le")
                .componentsSeparatedByString(NSString.fromJavaString("le"));
        NSArray arrayComponentsSeparatedByString3 = NSString.fromJavaString("12le12le")
                .componentsSeparatedByString(NSString.fromJavaString("12le"));
        assertTrue (arrayComponentsSeparatedByString0.getCount() == 2 
                && ((NSString)arrayComponentsSeparatedByString0.objectAtIndex(0))
                    .isEqualToString(NSString.fromJavaString("1"))
                && ((NSString)arrayComponentsSeparatedByString0.objectAtIndex(1))
                    .isEqualToString(NSString.fromJavaString("2"))
                && arrayComponentsSeparatedByString1.getCount() == 3
                && ((NSString)arrayComponentsSeparatedByString1.objectAtIndex(0))
                    .isEqualToString(NSString.fromJavaString(""))
                && ((NSString)arrayComponentsSeparatedByString1.objectAtIndex(1))
                    .isEqualToString(NSString.fromJavaString("111"))
                && ((NSString)arrayComponentsSeparatedByString1.objectAtIndex(2))
                    .isEqualToString(NSString.fromJavaString("22222"))
                && arrayComponentsSeparatedByString2.getCount() == 2
                && ((NSString)arrayComponentsSeparatedByString2.objectAtIndex(0))
                    .isEqualToString(NSString.fromJavaString("23"))
                && ((NSString)arrayComponentsSeparatedByString2.objectAtIndex(1))
                    .isEqualToString(NSString.fromJavaString(""))
                && arrayComponentsSeparatedByString3.getCount() == 3
                && ((NSString)arrayComponentsSeparatedByString3.objectAtIndex(0))
                    .isEqualToString(NSString.fromJavaString(""))
                && ((NSString)arrayComponentsSeparatedByString3.objectAtIndex(1))
                    .isEqualToString(NSString.fromJavaString(""))
                && ((NSString)arrayComponentsSeparatedByString3.objectAtIndex(2))
                    .isEqualToString(NSString.fromJavaString(""))
        );
    }

    @Test
    public void testSubstringFromIndex1() {
        NSString substringFromIndex0 = NSString.fromJavaString("a string0.");
        NSString substringFromIndex1 = NSString.fromJavaString("a string1.");
        assertTrue (substringFromIndex0.substringFromIndex(1).isEqualToString(NSString.fromJavaString(" string0."))
                && substringFromIndex1.substringFromIndex(0).isEqualToString(NSString.fromJavaString("a string1.")));
    }

    @Test
    public void testSubstringWithRange1() {
        NSRange rangeSubstringWithRange = Foundation.NSMakeRange(1, 2);
        NSString substringWithRange0 = NSString.fromJavaString("one");
        NSString substringWithRange1 = NSString.fromJavaString("test text");
        assertTrue (substringWithRange0.substringWithRange(rangeSubstringWithRange)
                    .isEqualToString(NSString.fromJavaString("ne"))
                && substringWithRange1.substringWithRange(Foundation.NSMakeRange(0, 0))
                    .isEqualToString(NSString.fromJavaString(""))
                && substringWithRange1.substringWithRange(Foundation.NSMakeRange(0, substringWithRange1.getLength()))
                    .isEqualToString(NSString.fromJavaString("test text"))
        );
    }

    @Test
    public void testSubstringToIndex1() {
        NSString substringToIndex0 = NSString.fromJavaString("test.substring0");
        NSString substringToIndex1 = NSString.fromJavaString("test.substring1").substringToIndex(0);
        NSString substringToIndex2 = NSString.fromJavaString("test.substring2");
        assertTrue (substringToIndex0.substringToIndex(4).isEqualToString(NSString.fromJavaString("test"))
                && substringToIndex1.isEqualToString(NSString.fromJavaString(""))
                && substringToIndex2.substringToIndex(substringToIndex2.getLength()) != null
        );
    }

    @Test
    public void testRangeOfString1() {
        NSString rangeOfString0 = NSString.fromJavaString("I will try to find a word inside");
        NSString rangeOfString1 = NSString.fromJavaString("word");
        NSRange aRange = rangeOfString0.rangeOfString(rangeOfString1);
        assertTrue (aRange.getLocation() == 21 && aRange.getLength() == 4
                && rangeOfString0.rangeOfString(NSString.fromJavaString("")).getLocation() == Foundation.NotFound
                && rangeOfString0.rangeOfString(NSString.fromJavaString("")).getLength() == 0
                && rangeOfString0.rangeOfString(NSString.fromJavaString("notFoundString")).getLocation()
                    == Foundation.NotFound
                && rangeOfString0.rangeOfString(NSString.fromJavaString("notFoundString")).getLength() == 0
        );
    }

    @Test
    public void testRangeOfString_options1() {

        NSString rangeOfStringOptions0 = NSString.fromJavaString("I will try to find a word inside");
        NSRange aRangeOfStringOptions0 = rangeOfStringOptions0.rangeOfStringOptions(
                NSString.fromJavaString("word"), NSStringCompareOptions.CaseInsensitiveSearch);
        assertTrue (aRangeOfStringOptions0.getLocation() == 21 && aRangeOfStringOptions0.getLength() == 4) ;
    }

    @Test
    public void testRangeOfString_options_range1() {
        NSRange range0 = Foundation.NSMakeRange(15, 15), range1 , range2;
        range1 = NSString.fromJavaString("I.will try to find a word inside")
                .rangeOfStringOptionsRange(NSString.fromJavaString("word"),
                            NSStringCompareOptions.CaseInsensitiveSearch, range0);
        range2 = NSString.fromJavaString("I.will try to find a word inside")
                .rangeOfStringOptionsRange(NSString.fromJavaString("food"),
                        NSStringCompareOptions.CaseInsensitiveSearch, range0);
        assertTrue(range2.getLocation() == Foundation.NotFound && range1.getLocation() == 21 && range1.getLength() == 4);
    }

    @Test
    public void testCompare1() {
        NSString compare0 = NSString.fromJavaString("A0");
        NSString compare1 = NSString.fromJavaString("A1");
        NSString compare2 = NSString.fromJavaString("A2");
        NSString compare3 = NSString.fromJavaString("A2");
        assertTrue (compare0.compare(compare1) == NSComparisonResult.Ascending
                && compare2.compare(compare1) == NSComparisonResult.Descending
                && compare2.compare(compare3) == NSComparisonResult.Same) ;
    }

    @Test
    public void testCompare_options1() {
        assertTrue (NSString.fromJavaString("AEIOU").compareOptions(NSString.fromJavaString("aeiou"),
                NSStringCompareOptions.CaseInsensitiveSearch) == NSComparisonResult.Same);
    }

    @Test
    public void testHasPrefix1() {
        NSString stringHasPrefix = NSString.fromJavaString("I will try to find a prefix inside");
        boolean aBool = stringHasPrefix.hasPrefix(NSString.fromJavaString("I will"));
        assertTrue (aBool) ;
    }

    @Test
    public void testHasSuffix1() {
        NSString hasSuffix0 = NSString.fromJavaString("I will try to find a word inside");
        assertTrue (hasSuffix0.hasSuffix(NSString.fromJavaString("inside")));
    }

    @Test
    public void testIsEqualToString1() {
        NSString  aString45a = NSString.fromJavaString("a simple string");
        NSString  aString45b = NSString.fromJavaString("a simple string");
        NSString aString45c = NSString.fromJavaString("asd");
        NSString aString45d = null;
        assertTrue (aString45a.isEqualToString(aString45b) && aString45b.isEqualToString(aString45a)
                && !aString45a.isEqualToString(aString45c) && !aString45b.isEqualToString(aString45d)
                && !aString45c.isEqualToString(null) && aString45b.isEqualToString(aString45b)
        );
    }

    @Test
    public void testIsEqual1() {
        NSString  aString46a = NSString.fromJavaString("a simple string");
        NSString  aString46b = NSString.fromJavaString("a simple string");
        NSString aString46c = NSString.fromJavaString("asd");
        NSString aString46d = null;
        assertTrue (aString46a.isEqual(aString46b) && aString46b.isEqual(aString46a)
                && !aString46a.isEqual(aString46c) && !aString46b.isEqual(aString46d)
                && !aString46c.isEqual(null) && aString46b.isEqual(aString46b)
        );
    }

    @Test
    public void testLowercaseString1() {
        NSString lowercaseString0 = NSString.fromJavaString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertTrue(lowercaseString0.getLowercaseString().isEqualToString(
                NSString.fromJavaString("abcdefghijklmnopqrstuvwxyz")));
    }

    @Test
    public void testUppercaseString1() {
        NSString uppercaseString0 = NSString.fromJavaString("abcdefghijklmnopqrstuvwxyz");
        assertTrue(uppercaseString0.getUppercaseString().isEqualToString(
                NSString.fromJavaString("ABCDEFGHIJKLMNOPQRSTUVWXYZ")));
    }

    @Test
    public void testCaseInsensitiveCompare1() {
        NSString str0 = NSString.fromJavaString("AbC");
        NSString str1 = NSString.fromJavaString("Abc");
        NSString str2 = NSString.fromJavaString("aaa");
        NSString str3 = NSString.fromJavaString("Baa");
        NSString str4 = NSString.fromJavaString("baa");
        NSString str5 = NSString.fromJavaString("AAa");
        assertTrue (str0.caseInsensitiveCompare(str1) == NSComparisonResult.Same
                && str2.caseInsensitiveCompare(str3) == NSComparisonResult.Ascending
                && str4.caseInsensitiveCompare(str5) == NSComparisonResult.Descending);
    }

    @Test
    public void testIntValue1() {
        NSString intValue0 = NSString.fromJavaString(" 25");
        NSString intValue1 = NSString.fromJavaString("-25");
        int anInt = intValue0.getIntValue();
        assertTrue (anInt == 25 && intValue1.getIntValue() == -25 && intValue1.getIntValue() + 10 == -15);
    }

    @Test
    public void testFloatValue1() {
        NSString floatValue0 = NSString.fromJavaString("1.23");
        assertTrue (floatValue0.getFloatValue() - 1.23 < 0.0000001) ;
    }

    @Test
    public void testIntegerValue1() {
        NSString integerValue0 = NSString.fromJavaString("11");
        assertTrue (integerValue0.getIntegerValue() == 11) ;
    }

    @Test
    public void testDoubleValue1() {
        NSString doubleValue0 = NSString.fromJavaString("1.23000000001");
        assertTrue (doubleValue0.getDoubleValue() - 1.23000000001 < 0.000001) ;
    }

    @Test
    public void testBoolValue1() {
        NSString boolValue0 = NSString.fromJavaString("Y");
        NSString boolValue1 = NSString.fromJavaString(" y");
        NSString boolValue2 = NSString.fromJavaString("T");
        NSString boolValue3 = NSString.fromJavaString("t");
        NSString boolValue4 = NSString.fromJavaString("1");
        NSString boolValue5 = NSString.fromJavaString(" 2");
        NSString boolValue6 = NSString.fromJavaString("3");
        NSString boolValue7 = NSString.fromJavaString("4");
        NSString boolValue8 = NSString.fromJavaString("5");
        NSString boolValue9 = NSString.fromJavaString(" 6");
        NSString boolValue10 = NSString.fromJavaString("7");
        NSString boolValue11 = NSString.fromJavaString("8");
        NSString boolValue12 = NSString.fromJavaString(" 9");
        NSString boolValue13 = NSString.fromJavaString("-0002");
        NSString boolValue14 = NSString.fromJavaString("-000007");
        NSString boolValue15 = NSString.fromJavaString("adsa");
        NSString boolValue16 = NSString.fromJavaString("0");
        NSString boolValue17 = NSString.fromJavaString("asdYasd");
        NSString boolValue18 = NSString.fromJavaString("atasd");
        NSString boolValue19 = NSString.fromJavaString(" -0.1");
        NSString boolValue20 = NSString.fromJavaString(" -07.1");
        assertTrue (boolValue0.isBoolValue() && boolValue1.isBoolValue() && boolValue2.isBoolValue()
                && boolValue3.isBoolValue() && boolValue4.isBoolValue() && boolValue5.isBoolValue()
                && boolValue6.isBoolValue() && boolValue7.isBoolValue() && boolValue8.isBoolValue()
                && boolValue9.isBoolValue() && boolValue10.isBoolValue() && boolValue11.isBoolValue()
                && boolValue12.isBoolValue() && boolValue13.isBoolValue() && boolValue14.isBoolValue()
                && !boolValue15.isBoolValue() && !boolValue16.isBoolValue() && !boolValue17.isBoolValue()
                && !boolValue18.isBoolValue() && !boolValue19.isBoolValue() && boolValue20.isBoolValue()
        );
    }

    @Test
    public void testLongLongValue1() {
        NSString longLongString0 = NSString.fromJavaString("123456789123456");
        long longLong0 = 123456789123456L;
        assertTrue (longLongString0.getLongLongValue() == longLong0);
    }

    @Test
    public void testCharacterAtIndex1() {
        NSString stringCharacterAtIndex0 = NSString.fromJavaString("I will try to find a character inside");
        assertTrue (stringCharacterAtIndex0.characterAtIndex(2) == 'w') ;
    }

    @Test
    public void testGetCharacters_range1() {
        NSString stringA = NSString.fromJavaString("ZABCDEFGHY123456");
        NSRange range0 = Foundation.NSMakeRange(1, 6);
        ShortArr aBuffer = new ShortArr(new short[5]);
        stringA.getCharactersRange(aBuffer, range0);
        assertTrue (aBuffer.get(0) == 65 && aBuffer.get(1) == 66 && aBuffer.get(2) == 67
                && aBuffer.get(3) == 68 && aBuffer.get(4) == 69);
    }

    @Test
    public void testUTF8String1() {
        NSString uTF8String0 = NSString.fromJavaString("test");
        CharArr aCString = (CharArr)uTF8String0.getUTF8String();

        assertTrue ((aCString.get(0) =='t') && (aCString.get(1) =='e')&&(aCString.get(2) =='s')
                &&(aCString.get(3) =='t'));
    }

    @Test
    public void testInitWithCString_encoding1() {
        CharArr str = new CharArr("This is ASCII".toCharArray());
        NSString stringWithCString0 = NSString.alloc().initWithCStringEncoding(
                str, NSStringEncoding.ASCIIStringEncoding).autorelease();
        assertTrue (stringWithCString0.isEqualToString(NSString.fromJavaString("This is ASCII")));
    }

    @Test
    public void testStringWithCString_encoding1() {
        CharArr str = new CharArr("This is ASCII".toCharArray());
        NSString stringWithCString1 = NSString.stringWithCStringEncoding(
                str, NSStringEncoding.ASCIIStringEncoding);
        assertTrue (stringWithCString1.isEqualToString(NSString.fromJavaString("This is ASCII")));
    }

    @Test
    public void testDescription1() {
        NSString description0 = NSString.fromJavaString(" 25");
        NSString description1 = NSString.fromJavaString("test1");
        assertTrue (description0.getDescription().isEqualToString(description0)
                && description1.isEqualToString(description1.getDescription()));
    }

    @Test
    public void testDataUsingEncoding1() {
        NSString stringDataUsingEncodign0 = NSString.fromJavaString("hola");
        NSString stringDataUsingEncoding1 = NSString.fromJavaString("686f6c61");
        NSData  dataDataUsingEncoding = stringDataUsingEncodign0.dataUsingEncoding(
                NSStringEncoding.ASCIIStringEncoding);
        NSRange aRange = dataDataUsingEncoding.getDescription().rangeOfString(stringDataUsingEncoding1);
        assertTrue (aRange.getLocation() != Foundation.NotFound) ;
    }

    @Test
    public void testStringByAppendingPathComponent1() {
        assertTrue(NSString.fromJavaString("/tmp").stringByAppendingPathComponent(
                NSString.fromJavaString("afaialae.txt")).isEqualToString(
                    NSString.fromJavaString("/tmp/afaialae.txt")));
    }

    @Test
    public void testStringByPaddingToLength_withString_startingAtIndex1() {
        NSString string0 = NSString.fromJavaString("1");
        NSString string1 = string0.stringByPaddingToLengthWithStringStartingAtIndex(
                10, NSString.fromJavaString(". "), 1);
        assertTrue (string1.isEqualToString(NSString.fromJavaString("1 . . . . ")));
    }

    @Test
    public void testPropertyListFromStringsFileFormat1() {
        NSString newDesc5 = NSString.fromJavaString("aa = 11; bb = 22;");
        NSDictionary newDict5 = newDesc5.propertyListFromStringsFileFormat();
        assertTrue (newDict5.getCount() == 2) ;
    }

}
