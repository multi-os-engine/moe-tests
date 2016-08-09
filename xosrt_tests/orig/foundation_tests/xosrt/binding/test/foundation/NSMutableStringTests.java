package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.CharArr;
import xosrt.binding.arrays.ShortArr;
import xosrt.binding.foundation.*;
import xosrt.binding.pointers.CharPtr;
import xosrt.binding.pointers.ShortPtr;
import org.junit.Test;

public class NSMutableStringTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInitWithCapacity1() {
        NSMutableString  aString = NSMutableString.alloc().initWithCapacity(5);
        // There is not form to check that the 'capacity' reservation was made 
        //Here we only check if var isn't null
        assertTrue(aString != null);
    }

    @Test
    public void testStringWithCapacity1() {
        NSMutableString aString2 = NSMutableString.stringWithCapacity(2);
        // There is not form to check that the 'capacity' reservation was made 
        //Here we only check if var isn't null
        assertTrue(aString2 != null);
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testAppendFormat1() {
        NSMutableString aString3 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("a"));
        aString3.appendFormat(NSString.fromJavaString("n int:%i %@"), 5, NSString.fromJavaString("asd"));
        assertTrue (aString3.isEqualToString(NSString.fromJavaString("an int:5 asd")));
    }
    */

    @Test
    public void testAppendString1() {
        NSMutableString aString4 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("an int:5 asd"));
        aString4.appendString(NSString.fromJavaString(" (five)"));
        assertTrue (aString4.isEqualToString(NSString.fromJavaString("an int:5 asd (five)")));
    }

    @Test
    public void testInit1() {
        NSMutableString init0 = NSMutableString.alloc().init();
        assertTrue(init0.isEqualToString(NSString.fromJavaString("")));
    }

    @Test
    public void testString1() {
        NSMutableString init1 = (NSMutableString)NSMutableString.string();
        assertTrue(init1.isEqualToString(NSString.fromJavaString("")));
    }

    @Test
    public void testInitWithBytes_length_encoding1() {
        CharArr cBytes = new CharArr("aaa".toCharArray());
        NSMutableString stringInitWithBytes_length_encoding0 = (NSMutableString)NSMutableString.alloc()
                .initWithBytesLengthEncoding(cBytes, 3, NSStringEncoding.ASCIIStringEncoding);
        assertTrue (stringInitWithBytes_length_encoding0.isEqualToString(NSString.fromJavaString("aaa")));
    }

    @Test
    public void testInitWithData_encoding1() {
        NSData someData = NSString.fromJavaString("aaa").dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding);
        NSMutableString initWithData_encoding0 = (NSMutableString)NSMutableString.alloc().initWithDataEncoding(
                someData, NSStringEncoding.ASCIIStringEncoding);
        NSMutableString initWithData_encoding1 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("aaa"));

        assertTrue (initWithData_encoding0.isEqualToString(initWithData_encoding1)) ;
    }

    @Test
    public void testInitWithString1() {
        NSMutableString initWithString0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("string to copy"));
        NSMutableString initWithString1 = (NSMutableString)NSMutableString.alloc().initWithString(initWithString0);
        assertTrue (initWithString1.isEqualToString(NSString.fromJavaString("string to copy")));
    }

    @Test
    public void testStringWithString1() {
        NSMutableString stringWithString0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("string to copy"));
        NSMutableString stringWithString1 = (NSMutableString)NSString.stringWithString(stringWithString0);
        assertTrue (stringWithString1.isEqualToString(NSString.fromJavaString("string to copy")));
    }

    @Test
    public void testLength1() {
        NSMutableString string0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(""));
        NSMutableString string1 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("1"));
        NSMutableString string2 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("test"));
        long length0 = string0.getLength();
        long length1 = string1.getLength();
        assertTrue (length0 == 0 && length1 == 1 && string2.getLength() == 4
                && string0.getLength() + 5 == 5 && string1.getLength() + 1 == 2);
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testInitWithFormat1() {
        NSMutableString initWithFormat0 = NSMutableString.alloc().initWithFormat(
                NSString.fromJavaString("this int: %i %@ %% %d %u %x %X %o %.2f %c %.2F"),
                5, NSString.fromJavaString("asd"), 1, 2, 10, 10, 8, 3.5, 's', 3.2);
        assertTrue(initWithFormat0.isEqualToString(NSString.fromJavaString("this int: 5 asd % 1 2 a A 10 3.50 s 3.20")));
    }

    @Test
    public void testStringWithFormat1() {
        NSMutableString stringWithFormat0 = NSMutableString.stringWithFormat(
                NSString.fromJavaString("this int: %i %@ %% %d %u %x %X %o %.2f %c %.2F"),
                5, NSString.fromJavaString("abc"), 5, 8, 15, 15, 20, 3.2, 'b', 3.8);
        assertTrue (stringWithFormat0.isEqualToString(NSString.fromJavaString("this int: 5 abc % 5 8 f F 24 3.20 b 3.80")));
    }
    */

    @Test
    public void testStringWithUTF8String1() {
        CharArr chars = new CharArr("utf8 c string with characters áéíóúñäëïöüàèìòù".toCharArray());
        NSMutableString stringWithUTF8String0 = (NSMutableString)NSMutableString.stringWithUTF8String(chars);
        assertTrue (stringWithUTF8String0.isEqualToString(NSString.fromJavaString(
                "utf8 c string with characters áéíóúñäëïöüàèìòù")));
    }

    @Test
    public void testInitWithUTF8String1() {
        CharArr chars = new CharArr("utf8 c string with characters áéíóúñäëïöüàèìòù".toCharArray());
        NSMutableString stringWithUTF8String1 = (NSMutableString)NSMutableString.alloc().initWithUTF8String(chars);
        assertTrue (stringWithUTF8String1.isEqualToString(NSString.fromJavaString(
                "utf8 c string with characters áéíóúñäëïöüàèìòù")));
    }

    @Test
    public void testStringByAppendingString1() {
        NSString stringByAppendingString0 = NSMutableString.alloc().init()
                .stringByAppendingString(NSString.fromJavaString("string0"));
        NSString stringByAppendingString1 = NSMutableString.stringWithString(NSString.fromJavaString("string"))
                .stringByAppendingString(NSString.fromJavaString("1"));
        NSMutableString stringByAppendingString2 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("st"));
        NSMutableString stringByAppendingString3 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString(""));
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
                    .isEqualToString(NSString.fromJavaString(""))
        );
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testStringByAppendingFormat1() {
        NSMutableString stringByAppendingFormat0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("sum("));
        NSString stringByAppendingFormat1 = stringByAppendingFormat0.stringByAppendingFormat(
                NSString.fromJavaString("2+1)=%d"), 3);
        assertTrue (stringByAppendingFormat1.isEqualToString(NSString.fromJavaString("sum(2+1)=3")));
    }
    */

    @Test
    public void testStringByReplacingOccurrencesOfString_withString1() {
        assertTrue(NSMutableString.stringWithString(NSString.fromJavaString("afaialae.txt"))
                .stringByReplacingOccurrencesOfStringWithString(NSString.fromJavaString("a"), NSString.fromJavaString(""))
                    .isEqualToString(NSString.fromJavaString("file.txt"))
                && NSMutableString.stringWithString(NSString.fromJavaString(");.-o"))
                    .stringByReplacingOccurrencesOfStringWithString(NSString.fromJavaString(");.-"),
                            NSString.fromJavaString("hell")).isEqualToString(NSString.fromJavaString("hello"))
                && NSMutableString.stringWithString(NSString.fromJavaString("U$S"))
                    .stringByReplacingOccurrencesOfStringWithString(NSString.fromJavaString("asd"),
                            NSString.fromJavaString("$$$")).isEqualToString(NSString.fromJavaString("U$S"))
        );
    }

    @Test
    public void testStringByReplacingCharactersInRange_withString1() {
        NSMutableString stringByReplacingStringx = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("abxxxfgh"));
        NSMutableString stringx = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("cde"));
        NSRange aRange = Foundation.NSMakeRange(2, 3);
        NSString newString = stringByReplacingStringx.stringByReplacingCharactersInRangeWithString(aRange, stringx);
        assertTrue(newString.isEqualToString(NSString.fromJavaString("abcdefgh")));
    }

    @Test
    public void testStringByTrimmingCharactersInSet1() {
        NSCharacterSet whitespaces = NSCharacterSet.whitespaceCharacterSet();
        assertTrue(NSMutableString.stringWithString(NSString.fromJavaString("    with spaces before and after   "))
                .stringByTrimmingCharactersInSet(whitespaces).isEqualToString(
                        NSString.fromJavaString("with spaces before and after"))
        );
    }

    @Test
    public void testStringByAddingPercentEscapesUsingEncoding1() {
        NSMutableString tStr1 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("string append string"));
        NSMutableString tStr2 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("string%20append%20string"));
        NSString  tStr3 = tStr1.stringByAddingPercentEscapesUsingEncoding(NSStringEncoding.ASCIIStringEncoding);
        assertTrue(tStr3.isEqualToString(tStr2));
    }

    @Test
    public void testComponentsSeparatedByString1() {
        NSArray arrayComponentsSeparatedByString0 = NSMutableString.stringWithString(
                NSString.fromJavaString("1 2")).componentsSeparatedByString(NSString.fromJavaString(" "));
        NSMutableString stringComponentsSeparatedByString0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString(",\n 111,\n 22222"));
        NSArray arrayComponentsSeparatedByString1 = stringComponentsSeparatedByString0
                .componentsSeparatedByString(NSString.fromJavaString(",\n "));
        NSArray arrayComponentsSeparatedByString2 = NSMutableString.stringWithString(NSString.fromJavaString("23le"))
                .componentsSeparatedByString(NSString.fromJavaString("le"));
        NSArray arrayComponentsSeparatedByString3 = NSMutableString.stringWithString(NSString.fromJavaString("12le12le"))
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
        NSMutableString substringFromIndex0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("a string0."));
        NSMutableString substringFromIndex1 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("a string1."));
        assertTrue (substringFromIndex0.substringFromIndex(1).isEqualToString(NSString.fromJavaString(" string0."))
                && substringFromIndex1.substringFromIndex(0).isEqualToString(NSString.fromJavaString("a string1."))
        );
    }

    @Test
    public void testSubstringWithRange1() {
        NSRange rangeSubstringWithRange = Foundation.NSMakeRange(1, 2);
        NSMutableString substringWithRange0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("one"));
        NSMutableString substringWithRange1 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("test text"));
        assertTrue (substringWithRange0.substringWithRange(rangeSubstringWithRange)
                    .isEqualToString(NSString.fromJavaString("ne"))
                && substringWithRange1.substringWithRange(Foundation.NSMakeRange(0, 0)).isEqualToString(
                        NSString.fromJavaString(""))
                && substringWithRange1.substringWithRange(Foundation.NSMakeRange(0, substringWithRange1.getLength()))
                    .isEqualToString(NSString.fromJavaString("test text"))
        );
    }

    @Test
    public void testSubstringToIndex1() {
        NSMutableString substringToIndex0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("test substring0"));
        NSString substringToIndex1 = NSMutableString.stringWithString(NSString.fromJavaString("test substring1"))
                .substringToIndex(0);
        NSMutableString substringToIndex2 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("test substring2"));
        assertTrue (substringToIndex0.substringToIndex(4).isEqualToString(NSString.fromJavaString("test"))
                && substringToIndex1.isEqualToString(NSString.fromJavaString(""))
                && substringToIndex2.substringToIndex(substringToIndex2.getLength()) != null
        );
    }

    @Test
    public void testRangeOfString1() {
        NSMutableString rangeOfString0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("I will try to find a word inside"));
        NSMutableString rangeOfString1 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("word"));
        NSRange aRange = rangeOfString0.rangeOfString(rangeOfString1);
        assertTrue(aRange.getLocation() == 21 && aRange.getLength() == 4
                && rangeOfString0.rangeOfString(NSString.fromJavaString("")).getLocation() == Foundation.NotFound
                && rangeOfString0.rangeOfString(NSString.fromJavaString("")).getLength() == 0
                && rangeOfString0.rangeOfString(NSString.fromJavaString("notFoundString")).getLocation() == Foundation.NotFound
                && rangeOfString0.rangeOfString(NSString.fromJavaString("notFoundString")).getLength() == 0) ;
    }

    @Test
    public void testRangeOfString_options1() {

        NSMutableString rangeOfStringOptions0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("I will try to find a word inside"));
        NSRange aRangeOfStringOptions0 = rangeOfStringOptions0.rangeOfStringOptions(
                NSString.fromJavaString("word"), NSStringCompareOptions.CaseInsensitiveSearch);
        assertTrue (aRangeOfStringOptions0.getLocation() == 21 && aRangeOfStringOptions0.getLength() == 4) ;
    }

    @Test
    public void testRangeOfString_options_range1() {
        NSRange range0 = Foundation.NSMakeRange(15, 15), range1 , range2;

        NSMutableString rangeOfString01 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("I will try to find a word inside"));
        NSMutableString rangeOfString11 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("I will try to find a word inside"));

        range1 = rangeOfString01.rangeOfStringOptionsRange(
                NSString.fromJavaString("word"), NSStringCompareOptions.CaseInsensitiveSearch, range0);
        range2 = rangeOfString11.rangeOfStringOptionsRange(
                NSString.fromJavaString("food"), NSStringCompareOptions.CaseInsensitiveSearch, range0);
        assertTrue(range2.getLocation() == Foundation.NotFound && range1.getLocation() == 21 && range1.getLength() == 4);
    }

    @Test
    public void testCompare1() {
        NSMutableString compare0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("A0"));
        NSMutableString compare1 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("A1"));
        NSMutableString compare2 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("A2"));
        NSMutableString compare3 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("A2"));
        assertTrue (compare0.compare(compare1) == NSComparisonResult.Ascending
                && compare2.compare(compare1) == NSComparisonResult.Descending
                && compare2.compare(compare3) == NSComparisonResult.Same);
    }

    @Test
    public void testCompare_options1() {
        NSMutableString compare = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("AEIOU"));
        assertTrue (compare.compareOptions(NSString.fromJavaString("aeiou"),
                NSStringCompareOptions.CaseInsensitiveSearch) == NSComparisonResult.Same);
    }

    @Test
    public void testHasPrefix1() {
        NSMutableString stringHasPrefix = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("I will try to find a prefix inside"));
        boolean aBool = stringHasPrefix.hasPrefix(NSString.fromJavaString("I will"));
        assertTrue(aBool);
    }

    @Test
    public void testHasSuffix1() {
        NSMutableString hasSuffix0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("I will try to find a word inside"));
        assertTrue (hasSuffix0.hasSuffix(NSString.fromJavaString("inside")));
    }

    @Test
    public void testIsEqualToString1() {
        NSMutableString  aString45a = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("a simple string"));
        NSMutableString  aString45b = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("a simple string"));
        NSMutableString aString45c = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("asd"));
        NSMutableString aString45d = null;
        assertTrue (aString45a.isEqualToString(aString45b) && aString45b.isEqualToString(aString45a)
                && !aString45a.isEqualToString(aString45c) && !aString45b.isEqualToString(aString45d)
                && !aString45c.isEqualToString(null) && aString45b.isEqualToString(aString45b));
    }

    @Test
    public void testIsEqual1() {
        NSMutableString  aString46a = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("a simple string"));
        NSMutableString  aString46b = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("a simple string"));
        NSMutableString aString46c = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("asd"));
        NSMutableString aString46d = null;
        assertTrue (aString46a.isEqual(aString46b) && aString46b.isEqual(aString46a)
                && !aString46a.isEqual(aString46c) && !aString46b.isEqual(aString46d)
                && !aString46c.isEqual(null) && aString46b.isEqual(aString46b));
    }

    @Test
    public void testLowercaseString1() {
        NSMutableString lowercaseString0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertTrue(lowercaseString0.getLowercaseString().isEqualToString(
                NSString.fromJavaString("abcdefghijklmnopqrstuvwxyz")));
    }

    @Test
    public void testUppercaseString1() {
        NSMutableString uppercaseString0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("abcdefghijklmnopqrstuvwxyz"));
        assertTrue(uppercaseString0.getUppercaseString().isEqualToString(
                NSString.fromJavaString("ABCDEFGHIJKLMNOPQRSTUVWXYZ")));
    }

    @Test
    public void testCaseInsensitiveCompare1() {
        NSMutableString str0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("AbC"));
        NSMutableString str1 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("Abc"));
        NSMutableString str2 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("aaa"));
        NSMutableString str3 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("Baa"));
        NSMutableString str4 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("baa"));
        NSMutableString str5 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("AAa"));
        assertTrue (str0.caseInsensitiveCompare(str1) == NSComparisonResult.Same
                && str2.caseInsensitiveCompare(str3) == NSComparisonResult.Ascending
                && str4.caseInsensitiveCompare(str5) == NSComparisonResult.Descending);
    }

    @Test
    public void testIntValue1() {
        NSMutableString intValue0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(" 25"));
        NSMutableString intValue1 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("-25"));
        int anInt = intValue0.getIntValue();
        assertTrue (anInt == 25 && intValue1.getIntValue() == -25 && intValue1.getIntValue() + 10 == -15);
    }

    @Test
    public void testFloatValue1() {
        NSMutableString floatValue0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("1.23"));
        assertTrue (floatValue0.getFloatValue() - 1.23 < 0.0000001);
    }

    @Test
    public void testIntegerValue1() {
        NSMutableString integerValue0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("11"));
        assertTrue (integerValue0.getIntegerValue() == 11);
    }

    @Test
    public void testDoubleValue1() {
        NSMutableString doubleValue0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("1.23000000001"));
        assertTrue (doubleValue0.getDoubleValue() - 1.23000000001 < 0.000001) ;
    }

    @Test
    public void testBoolValue1() {
        NSMutableString boolValue0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("Y"));
        NSMutableString boolValue1 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(" y"));
        NSMutableString boolValue2 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("T"));
        NSMutableString boolValue3 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("t"));
        NSMutableString boolValue4 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("1"));
        NSMutableString boolValue5 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(" 2"));
        NSMutableString boolValue6 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("3"));
        NSMutableString boolValue7 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("4"));
        NSMutableString boolValue8 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("5"));
        NSMutableString boolValue9 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(" 6"));
        NSMutableString boolValue10 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("7"));
        NSMutableString boolValue11 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("8"));
        NSMutableString boolValue12 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(" 9"));
        NSMutableString boolValue13 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("-0002"));
        NSMutableString boolValue14 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("-000007"));
        NSMutableString boolValue15 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("adsa"));
        NSMutableString boolValue16 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("0"));
        NSMutableString boolValue17 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("asdYasd"));
        NSMutableString boolValue18 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("atasd"));
        NSMutableString boolValue19 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(" -0.1"));
        NSMutableString boolValue20 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(" -07.1"));
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
        NSMutableString longLongString0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("123456789123456"));
        long longLong0 = 123456789123456L;
        assertTrue (longLongString0.getLongLongValue() == longLong0);
    }

    @Test
    public void testCharacterAtIndex1() {
        NSMutableString stringCharacterAtIndex0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("I will try to find a character inside"));
        assertTrue (stringCharacterAtIndex0.characterAtIndex(2) == 'w');
    }

    @Test
    public void testGetCharacters_range1() {
        NSMutableString stringA = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("ZABCDEFGHY123456"));
        ShortArr aBuffer = new ShortArr(new short[5]);
        stringA.getCharactersRange(aBuffer, Foundation.NSMakeRange(1, 6));
        assertTrue (aBuffer.get(0) == 65 && aBuffer.get(1) == 66 && aBuffer.get(2) == 67
                && aBuffer.get(3) == 68 && aBuffer.get(4) == 69);
    }

    @Test
    public void testUTF8String1() {
        NSMutableString uTF8String0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("test"));
        CharArr aCString = (CharArr)uTF8String0.getUTF8String();

        assertTrue ((aCString.get(0) =='t') && (aCString.get(1) =='e')&&(aCString.get(2) =='s')
                &&(aCString.get(3) =='t'));
    }

    @Test
    public void testInitWithCString_encoding1() {
        CharArr str = new CharArr("This is ASCII".toCharArray());
        NSMutableString stringWithCString0 = (NSMutableString)NSMutableString.alloc()
                .initWithCStringEncoding(str, NSStringEncoding.ASCIIStringEncoding).autorelease();
        assertTrue (stringWithCString0.isEqualToString(NSString.fromJavaString("This is ASCII")));
    }

    @Test
    public void testStringWithCString_encoding1() {
        CharArr str = new CharArr("This is ASCII".toCharArray());
        NSMutableString stringWithCString1 = (NSMutableString)NSMutableString.stringWithCStringEncoding(
                str, NSStringEncoding.ASCIIStringEncoding);
        assertTrue (stringWithCString1.isEqualToString(NSString.fromJavaString("This is ASCII")));
    }

    @Test
    public void testDescription1() {
        NSMutableString description0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString(" 25"));
        NSMutableString description1 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("test1"));
        assertTrue (description0.getDescription().isEqualToString(description0)
                && description1.isEqualToString(description1.getDescription()));
    }

    @Test
    public void testDataUsingEncoding1() {
        NSMutableString stringDataUsingEncodign0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("hola"));
        NSMutableString stringDataUsingEncoding1 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("686f6c61"));
        NSData  dataDataUsingEncoding = stringDataUsingEncodign0.dataUsingEncoding(NSStringEncoding.ASCIIStringEncoding);
        NSRange aRange = dataDataUsingEncoding.description().rangeOfString(stringDataUsingEncoding1);
        assertTrue (aRange.getLocation() != Foundation.NotFound);
    }

    @Test
    public void testStringByAppendingPathComponent1() {
        assertTrue(NSString.fromJavaString("/tmp").stringByAppendingPathComponent(NSString.fromJavaString("afaialae.txt"))
                .isEqualToString(NSString.fromJavaString("/tmp/afaialae.txt")));
    }

    @Test
    public void testStringByPaddingToLength_withString_startingAtIndex1() {
        NSMutableString string0 = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("1"));
        NSString string1 = string0.stringByPaddingToLengthWithStringStartingAtIndex(10, NSString.fromJavaString(". "), 1);
        assertTrue (string1.isEqualToString(NSString.fromJavaString("1 . . . . ")));
    }

    @Test
    public void testPropertyListFromStringsFileFormat1() {
        NSMutableString newDesc5 = (NSMutableString)NSMutableString.stringWithString(
                NSString.fromJavaString("aa = 11; bb = 22;"));
        NSDictionary newDict5 = newDesc5.propertyListFromStringsFileFormat();
        assertTrue (newDict5.getCount() == 2) ;
    }

}
