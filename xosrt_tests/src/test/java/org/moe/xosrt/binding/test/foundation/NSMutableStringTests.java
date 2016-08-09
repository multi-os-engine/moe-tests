package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.NSArray;
import ios.foundation.NSCharacterSet;
import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSMutableString;
import ios.foundation.NSString;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

import org.moe.natj.general.ptr.CharPtr;
import org.moe.natj.general.ptr.ConstVoidPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import ios.foundation.c.Foundation;
import ios.foundation.enums.Enums;
import ios.foundation.enums.NSComparisonResult;
import ios.foundation.enums.NSStringCompareOptions;
import ios.foundation.struct.NSRange;

public class NSMutableStringTests extends XOSTest {

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
        NSMutableString aString3 = (NSMutableString)NSMutableString.stringWithString("a"));
        aString3.appendFormat(NSString.stringWithString("n int:%i %@"), 5, NSString.stringWithString("asd"));
        assertTrue (aString3.isEqualToString("an int:5 asd")));
    }
    */

    @Test
    public void testAppendString1() {
        NSMutableString aString4 = (NSMutableString)NSMutableString.stringWithString( "an int:5 asd" );
        aString4.appendString(" (five)");
        assertTrue (aString4.isEqualToString("an int:5 asd (five)"));
    }

    @Test
    public void testInit1() {
        NSMutableString init0 = NSMutableString.alloc().init();
        assertTrue(init0.isEqualToString(""));
    }

    @Test
    public void testString1() {
        NSMutableString init1 = (NSMutableString)NSMutableString.string();
        assertTrue(init1.isEqualToString(""));
    }

    @Test
    public void testInitWithBytes_length_encoding1() {
        ConstVoidPtr cBytes = PtrFactory.newCharArray("abc".toCharArray());
        NSMutableString stringInitWithBytes_length_encoding0 = (NSMutableString)NSMutableString.alloc()
                .initWithBytesLengthEncoding(cBytes, 6, Enums.NSUTF16LittleEndianStringEncoding);
        assertTrue (stringInitWithBytes_length_encoding0.isEqualToString("abc"));
    }

    @Test
    public void testInitWithData_encoding1() {
        NSData someData = NSString.stringWithString("aaa").dataUsingEncoding(Enums.NSASCIIStringEncoding);
        NSMutableString initWithData_encoding0 = (NSMutableString)NSMutableString.alloc().initWithDataEncoding(
                someData, Enums.NSASCIIStringEncoding);

        assertTrue (initWithData_encoding0.isEqualToString( "aaa" ) );
    }

    @Test
    public void testInitWithString1() {
        NSMutableString initWithString1 = (NSMutableString)NSMutableString.alloc().initWithString("string to copy");
        assertTrue (initWithString1.isEqualToString( "string to copy") );
    }

    @Test
    public void testStringWithString1() {
        NSMutableString stringWithString1 = (NSMutableString)NSString.stringWithString("string to copy");
        assertTrue (stringWithString1.isEqualToString("string to copy"));
    }

    @Test
    public void testLength1() {
        NSMutableString string0 = (NSMutableString)NSMutableString.stringWithString("");
        NSMutableString string1 = (NSMutableString)NSMutableString.stringWithString("1");
        NSMutableString string2 = (NSMutableString)NSMutableString.stringWithString("test");
        long length0 = string0.length();
        long length1 = string1.length();
        assertTrue (length0 == 0 && length1 == 1 && string2.length() == 4
                && string0.length() + 5 == 5 && string1.length() + 1 == 2);
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testInitWithFormat1() {
        NSMutableString initWithFormat0 = NSMutableString.alloc().initWithFormat(
                NSString.stringWithString("this int: %i %@ %% %d %u %x %X %o %.2f %c %.2F"),
                5, NSString.stringWithString("asd"), 1, 2, 10, 10, 8, 3.5, 's', 3.2);
        assertTrue(initWithFormat0.isEqualToString("this int: 5 asd % 1 2 a A 10 3.50 s 3.20")));
    }

    @Test
    public void testStringWithFormat1() {
        NSMutableString stringWithFormat0 = NSMutableString.stringWithFormat(
                NSString.stringWithString("this int: %i %@ %% %d %u %x %X %o %.2f %c %.2F"),
                5, NSString.stringWithString("abc"), 5, 8, 15, 15, 20, 3.2, 'b', 3.8);
        assertTrue (stringWithFormat0.isEqualToString("this int: 5 abc % 5 8 f F 24 3.20 b 3.80")));
    }
    */

    @Test
    public void testStringWithUTF8String1() {
        NSMutableString stringWithUTF8String0 = (NSMutableString)NSMutableString
        		.stringWithUTF8String("utf8 c string with characters áéíóúñäëïöüàèìòù");
        assertTrue (stringWithUTF8String0.isEqualToString(
                "utf8 c string with characters áéíóúñäëïöüàèìòù"));
    }

    @Test
    public void testInitWithUTF8String1() {
        NSMutableString stringWithUTF8String1 = (NSMutableString)NSMutableString
        		.alloc()
        		.initWithUTF8String("utf8 c string with characters áéíóúñäëïöüàèìòù");
        assertTrue (stringWithUTF8String1.isEqualToString(
                "utf8 c string with characters áéíóúñäëïöüàèìòù"));
    }

    @Test
    public void testStringByAppendingString1() {
        String stringByAppendingString0 = NSMutableString.alloc().init()
                .stringByAppendingString( "string0" );
        String stringByAppendingString1 = NSMutableString.stringWithString("string")
                .stringByAppendingString("1");
        NSMutableString stringByAppendingString2 = (NSMutableString)NSMutableString.stringWithString("st");
        NSMutableString stringByAppendingString3 = (NSMutableString)NSMutableString.stringWithString("");
        assertTrue (stringByAppendingString0.equals("string0")
                && stringByAppendingString1.equals("string1")
                && stringByAppendingString2.stringByAppendingString("ring2")
                    .equals("string2")
                && stringByAppendingString3.stringByAppendingString("string3")
                    .equals("string3")
                && NSString.stringWithString("string").stringByAppendingString("4")
                    .equals("string4")
                && NSString.stringWithString("").stringByAppendingString("string5")
                    .equals("string5")
                && NSString.stringWithString("").stringByAppendingString("")
                    .equals("")
        );
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testStringByAppendingFormat1() {
        NSMutableString stringByAppendingFormat0 = (NSMutableString)NSMutableString.stringWithString(
                NSString.stringWithString("sum("));
        NSString stringByAppendingFormat1 = stringByAppendingFormat0.stringByAppendingFormat(
                NSString.stringWithString("2+1)=%d"), 3);
        assertTrue (stringByAppendingFormat1.isEqualToString("sum(2+1)=3")));
    }
    */

    @Test
    public void testStringByReplacingOccurrencesOfString_withString1() {
        assertTrue(NSMutableString.stringWithString("afaialae.txt")
                .stringByReplacingOccurrencesOfStringWithString("a" , "")
                    .equals("file.txt")
                && NSMutableString.stringWithString(");.-o")
                    .stringByReplacingOccurrencesOfStringWithString(");.-","hell")
                    .equals("hello")
                && NSMutableString.stringWithString("U$S")
                    .stringByReplacingOccurrencesOfStringWithString("asd","$$$")
                    .equals("U$S")
        );
    }

    @Test
    public void testStringByReplacingCharactersInRange_withString1() {
        NSMutableString stringByReplacingStringx = (NSMutableString)NSMutableString.stringWithString("abxxxfgh");
        NSRange aRange = Foundation.NSMakeRange(2, 3);
        String newString = stringByReplacingStringx.stringByReplacingCharactersInRangeWithString(aRange, "cde");
        assertTrue(newString.equals("abcdefgh"));
    }

    @Test
    public void testStringByTrimmingCharactersInSet1() {
        NSCharacterSet whitespaces = NSCharacterSet.whitespaceCharacterSet();
        assertTrue(NSMutableString.stringWithString("    with spaces before and after   ")
                .stringByTrimmingCharactersInSet(whitespaces).equals(
                       "with spaces before and after")
        );
    }

    @Test
    public void testStringByAddingPercentEscapesUsingEncoding1() {
        NSMutableString tStr1 = (NSMutableString)NSMutableString.stringWithString("string append string");
        NSMutableString tStr2 = (NSMutableString)NSMutableString.stringWithString("string%20append%20string");
        String  tStr3 = tStr1.stringByAddingPercentEscapesUsingEncoding(Enums.NSASCIIStringEncoding);
        assertTrue(tStr3.equals(tStr2.description()));
    }

    @Test
    public void testComponentsSeparatedByString1() {
        NSArray arrayComponentsSeparatedByString0 = NSMutableString.stringWithString("1 2").componentsSeparatedByString(" ");
        NSMutableString stringComponentsSeparatedByString0 = (NSMutableString)NSMutableString.stringWithString(",\n 111,\n 22222");
        NSArray arrayComponentsSeparatedByString1 = stringComponentsSeparatedByString0
                .componentsSeparatedByString(",\n ");
        NSArray arrayComponentsSeparatedByString2 = NSMutableString.stringWithString("23le")
                .componentsSeparatedByString("le");
        NSArray arrayComponentsSeparatedByString3 = NSMutableString.stringWithString("12le12le")
                .componentsSeparatedByString("12le");
        assertTrue (arrayComponentsSeparatedByString0.count() == 2
                && ((String)arrayComponentsSeparatedByString0.objectAtIndex(0))
                    .equals("1")
                && ((String)arrayComponentsSeparatedByString0.objectAtIndex(1))
                    .equals("2")
                && arrayComponentsSeparatedByString1.count() == 3
                && ((String)arrayComponentsSeparatedByString1.objectAtIndex(0))
                    .equals("")
                && ((String)arrayComponentsSeparatedByString1.objectAtIndex(1))
                    .equals("111")
                && ((String)arrayComponentsSeparatedByString1.objectAtIndex(2))
                    .equals("22222")
                && arrayComponentsSeparatedByString2.count() == 2
                && ((String)arrayComponentsSeparatedByString2.objectAtIndex(0))
                    .equals("23")
                && ((String)arrayComponentsSeparatedByString2.objectAtIndex(1))
                    .equals("")
                && arrayComponentsSeparatedByString3.count() == 3
                && ((String)arrayComponentsSeparatedByString3.objectAtIndex(0))
                    .equals("")
                && ((String)arrayComponentsSeparatedByString3.objectAtIndex(1))
                    .equals("")
                && ((String)arrayComponentsSeparatedByString3.objectAtIndex(2))
                    .equals("")
        );
    }

    @Test
    public void testSubstringFromIndex1() {
        NSMutableString substringFromIndex0 = (NSMutableString)NSMutableString.stringWithString("a string0.");
        NSMutableString substringFromIndex1 = (NSMutableString)NSMutableString.stringWithString("a string1.");
        assertTrue (substringFromIndex0.substringFromIndex(1).equals(" string0.")
                && substringFromIndex1.substringFromIndex(0).equals("a string1.")
        );
    }

    @Test
    public void testSubstringWithRange1() {
        NSRange rangeSubstringWithRange = Foundation.NSMakeRange(1, 2);
        NSMutableString substringWithRange0 = (NSMutableString)NSMutableString.stringWithString("one");
        NSMutableString substringWithRange1 = (NSMutableString)NSMutableString.stringWithString("test text");
        assertTrue (substringWithRange0.substringWithRange(rangeSubstringWithRange)
                    .equals("ne")
                && substringWithRange1.substringWithRange(Foundation.NSMakeRange(0, 0)).equals("")
                && substringWithRange1.substringWithRange(Foundation.NSMakeRange(0, substringWithRange1.length()))
                    .equals("test text")
        );
    }

    @Test
    public void testSubstringToIndex1() {
        NSMutableString substringToIndex0 = (NSMutableString)NSMutableString.stringWithString("test substring0");
        String substringToIndex1 = NSMutableString.stringWithString("test substring1")
                .substringToIndex(0);
        NSMutableString substringToIndex2 = (NSMutableString)NSMutableString.stringWithString("test substring2");
        assertTrue (substringToIndex0.substringToIndex(4).equals("test")
                && substringToIndex1.equals("")
                && substringToIndex2.substringToIndex(substringToIndex2.length()) != null
        );
    }

    @Test
    public void testRangeOfString1() {
        NSMutableString rangeOfString0 = (NSMutableString)NSMutableString.stringWithString("I will try to find a word inside");
        NSRange aRange = rangeOfString0.rangeOfString("word");
        assertTrue(aRange.location() == 21 && aRange.length() == 4
                && rangeOfString0.rangeOfString("").location() == Foundation.NSNotFound
                && rangeOfString0.rangeOfString("").length() == 0
                && rangeOfString0.rangeOfString("notFoundString").location() == Foundation.NSNotFound
                && rangeOfString0.rangeOfString("notFoundString").length() == 0) ;
    }

    @Test
    public void testRangeOfString_options1() {

        NSMutableString rangeOfStringOptions0 = (NSMutableString)NSMutableString
        		.stringWithString("I will try to find a word inside");
        NSRange aRangeOfStringOptions0 = rangeOfStringOptions0.rangeOfStringOptions(
                "word", NSStringCompareOptions.CaseInsensitiveSearch);
        assertTrue (aRangeOfStringOptions0.location() == 21 && aRangeOfStringOptions0.length() == 4) ;
    }

    @Test
    public void testRangeOfString_options_range1() {
        NSRange range0 = Foundation.NSMakeRange(15, 15), range1, range2;

        NSMutableString rangeOfString01 = (NSMutableString)NSMutableString
        		.stringWithString("I will try to find a word inside");
        NSMutableString rangeOfString11 = (NSMutableString)NSMutableString
        		.stringWithString("I will try to find a word inside");

        range1 = rangeOfString01.rangeOfStringOptionsRange(
                "word", NSStringCompareOptions.CaseInsensitiveSearch, range0);
        range2 = rangeOfString11.rangeOfStringOptionsRange(
                "food", NSStringCompareOptions.CaseInsensitiveSearch, range0);
        assertTrue(range2.location() == Foundation.NSNotFound && range1.location() == 21 && range1.length() == 4);
    }

    @Test
    public void testCompare1() {
        NSMutableString compare0 = (NSMutableString)NSMutableString.stringWithString("A0");
        NSMutableString compare2 = (NSMutableString)NSMutableString.stringWithString("A2");
        assertTrue (compare0.compare("A1") == NSComparisonResult.Ascending
                && compare2.compare("A1") == NSComparisonResult.Descending
                && compare2.compare("A2") == NSComparisonResult.Same);
    }

    @Test
    public void testCompare_options1() {
        NSMutableString compare = (NSMutableString)NSMutableString.stringWithString("AEIOU");
        assertTrue (compare.compareOptions("aeiou",
                NSStringCompareOptions.CaseInsensitiveSearch) == NSComparisonResult.Same);
    }

    @Test
    public void testHasPrefix1() {
        NSMutableString stringHasPrefix = (NSMutableString)NSMutableString
        		.stringWithString("I will try to find a prefix inside");
        boolean aBool = stringHasPrefix.hasPrefix("I will");
        assertTrue(aBool);
    }

    @Test
    public void testHasSuffix1() {
        NSMutableString hasSuffix0 = (NSMutableString)NSMutableString
        		.stringWithString("I will try to find a word inside");
        assertTrue (hasSuffix0.hasSuffix("inside"));
    }

    @Test
    public void testIsEqualToString1() {
        NSMutableString  aString45a = (NSMutableString)NSMutableString
        		.stringWithString("a simple string");
        NSMutableString  aString45b = (NSMutableString)NSMutableString
        		.stringWithString("a simple string");
        NSMutableString aString45c = (NSMutableString)NSMutableString
        		.stringWithString("asd");
        assertTrue (aString45a.isEqualToString("a simple string") && aString45b.isEqualToString("a simple string")
                && !aString45a.isEqualToString("asd") && !aString45b.isEqualToString(null)
                && !aString45c.isEqualToString(null) );
    }

    @Test
    public void testIsEqual1() {
        NSMutableString  aString46a = (NSMutableString)NSMutableString
        		.stringWithString("a simple string");
        NSMutableString  aString46b = (NSMutableString)NSMutableString
        		.stringWithString("a simple string");
        NSMutableString aString46c = (NSMutableString)NSMutableString.stringWithString("asd");
        NSMutableString aString46d = null;
        assertTrue (aString46a.isEqual(aString46b) && aString46b.isEqual(aString46a)
                && !aString46a.isEqual(aString46c) && !aString46b.isEqual(aString46d)
                && !aString46c.isEqual(null) && aString46b.isEqual(aString46b));
    }

    @Test
    public void testLowercaseString1() {
        NSMutableString lowercaseString0 = (NSMutableString)NSMutableString
        		.stringWithString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertTrue(lowercaseString0.lowercaseString().equals("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void testUppercaseString1() {
        NSMutableString uppercaseString0 = (NSMutableString)NSMutableString.stringWithString("abcdefghijklmnopqrstuvwxyz");
        assertTrue(uppercaseString0.uppercaseString().equals("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void testCaseInsensitiveCompare1() {
        NSMutableString str0 = (NSMutableString)NSMutableString.stringWithString("AbC");
        NSMutableString str2 = (NSMutableString)NSMutableString.stringWithString("aaa");
        NSMutableString str4 = (NSMutableString)NSMutableString.stringWithString("baa");
        assertTrue (str0.caseInsensitiveCompare("Abc") == NSComparisonResult.Same
                && str2.caseInsensitiveCompare("Baa") == NSComparisonResult.Ascending
                && str4.caseInsensitiveCompare("AAa") == NSComparisonResult.Descending);
    }

    @Test
    public void testIntValue1() {
        NSMutableString intValue0 = (NSMutableString)NSMutableString.stringWithString(" 25");
        NSMutableString intValue1 = (NSMutableString)NSMutableString.stringWithString("-25");
        int anInt = intValue0.intValue();
        assertTrue (anInt == 25 && intValue1.intValue() == -25 && intValue1.intValue() + 10 == -15);
    }

    @Test
    public void testFloatValue1() {
        NSMutableString floatValue0 = (NSMutableString)NSMutableString.stringWithString("1.23");
        assertTrue (floatValue0.floatValue() - 1.23 < 0.0000001);
    }

    @Test
    public void testIntegerValue1() {
        NSMutableString integerValue0 = (NSMutableString)NSMutableString.stringWithString("11");
        assertTrue (integerValue0.integerValue() == 11);
    }

    @Test
    public void testDoubleValue1() {
        NSMutableString doubleValue0 = (NSMutableString)NSMutableString.stringWithString("1.23000000001");
        assertTrue (doubleValue0.doubleValue() - 1.23000000001 < 0.000001) ;
    }

    @Test
    public void testBoolValue1() {
        NSMutableString boolValue0 = (NSMutableString)NSMutableString.stringWithString("Y");
        NSMutableString boolValue1 = (NSMutableString)NSMutableString.stringWithString(" y");
        NSMutableString boolValue2 = (NSMutableString)NSMutableString.stringWithString("T");
        NSMutableString boolValue3 = (NSMutableString)NSMutableString.stringWithString("t");
        NSMutableString boolValue4 = (NSMutableString)NSMutableString.stringWithString("1");
        NSMutableString boolValue5 = (NSMutableString)NSMutableString.stringWithString(" 2");
        NSMutableString boolValue6 = (NSMutableString)NSMutableString.stringWithString("3");
        NSMutableString boolValue7 = (NSMutableString)NSMutableString.stringWithString("4");
        NSMutableString boolValue8 = (NSMutableString)NSMutableString.stringWithString("5");
        NSMutableString boolValue9 = (NSMutableString)NSMutableString.stringWithString(" 6");
        NSMutableString boolValue10 = (NSMutableString)NSMutableString.stringWithString("7");
        NSMutableString boolValue11 = (NSMutableString)NSMutableString.stringWithString("8");
        NSMutableString boolValue12 = (NSMutableString)NSMutableString.stringWithString(" 9");
        NSMutableString boolValue13 = (NSMutableString)NSMutableString.stringWithString("-0002");
        NSMutableString boolValue14 = (NSMutableString)NSMutableString.stringWithString("-000007");
        NSMutableString boolValue15 = (NSMutableString)NSMutableString.stringWithString("adsa");
        NSMutableString boolValue16 = (NSMutableString)NSMutableString.stringWithString("0");
        NSMutableString boolValue17 = (NSMutableString)NSMutableString.stringWithString("asdYasd");
        NSMutableString boolValue18 = (NSMutableString)NSMutableString.stringWithString("atasd");
        NSMutableString boolValue19 = (NSMutableString)NSMutableString.stringWithString(" -0.1");
        NSMutableString boolValue20 = (NSMutableString)NSMutableString.stringWithString(" -07.1");
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
        NSMutableString longLongString0 = (NSMutableString)NSMutableString
        		.stringWithString("123456789123456");
        long longLong0 = 123456789123456L;
        assertTrue (longLongString0.longLongValue() == longLong0);
    }

    @Test
    public void testCharacterAtIndex1() {
        NSMutableString stringCharacterAtIndex0 = (NSMutableString)NSMutableString
        		.stringWithString("I will try to find a character inside");
        assertTrue (stringCharacterAtIndex0.characterAtIndex(2) == 'w');
    }

    @Test
    public void testGetCharacters_range1() {
        NSMutableString stringA = (NSMutableString)NSMutableString
        		.stringWithString("ZABCDEFGHY123456");
        CharPtr aBuffer = PtrFactory.newCharArray(new char[5]);
        stringA.getCharactersRange(aBuffer, Foundation.NSMakeRange(1, 6));
        assertTrue (aBuffer.get(0) == 65 && aBuffer.get(1) == 66 && aBuffer.get(2) == 67
                && aBuffer.get(3) == 68 && aBuffer.get(4) == 69);
    }

    @Test
    public void testUTF8String1() {
        NSMutableString uTF8String0 = (NSMutableString)NSMutableString.stringWithString("test");
        char[] aCString = uTF8String0.UTF8String().toCharArray();

        assertTrue ((aCString[0] =='t') && (aCString[1] =='e')&&(aCString[2] =='s')
                &&(aCString[3] =='t'));
    }

    @Test
    public void testInitWithCString_encoding1() {
        NSMutableString stringWithCString0 = (NSMutableString)NSMutableString.alloc()
                .initWithCStringEncoding("This is ASCII", Enums.NSASCIIStringEncoding);
        assertTrue (stringWithCString0.isEqualToString("This is ASCII"));
    }

    @Test
    public void testStringWithCString_encoding1() {
        NSMutableString stringWithCString1 = (NSMutableString)NSMutableString.stringWithCStringEncoding(
        		"This is ASCII", Enums.NSASCIIStringEncoding);
        assertTrue (stringWithCString1.isEqualToString("This is ASCII"));
    }

    @Test
    public void testDescription1() {
        NSMutableString description0 = (NSMutableString)NSMutableString.stringWithString(" 25");
        NSMutableString description1 = (NSMutableString)NSMutableString.stringWithString("test1");
        assertTrue (description0.description().equals(" 25")
                && description1.isEqualToString(description1.description()));
    }

    @Test
    public void testDataUsingEncoding1() {
        NSMutableString stringDataUsingEncodign0 = (NSMutableString)NSMutableString.stringWithString("hola");
        NSData  dataDataUsingEncoding = stringDataUsingEncodign0.dataUsingEncoding(Enums.NSASCIIStringEncoding);
        NSRange aRange = NSString.stringWithString(dataDataUsingEncoding.description()).rangeOfString("686f6c61");
        assertTrue (aRange.location() != 0);
    }

    @Test
    public void testStringByAppendingPathComponent1() {
        assertTrue(NSString.stringWithString("/tmp").stringByAppendingPathComponent("afaialae.txt")
                .equals("/tmp/afaialae.txt"));
    }

    @Test
    public void testStringByPaddingToLength_withString_startingAtIndex1() {
        NSMutableString string0 = (NSMutableString)NSMutableString.stringWithString("1");
        String string1 = string0.stringByPaddingToLengthWithStringStartingAtIndex(10, ". ", 1);
        assertTrue (string1.equals("1 . . . . "));
    }

    @Test
    public void testPropertyListFromStringsFileFormat1() {
        NSMutableString newDesc5 = (NSMutableString)NSMutableString.stringWithString("aa = 11; bb = 22;");
        NSDictionary newDict5 = newDesc5.propertyListFromStringsFileFormat();
        assertTrue (newDict5.count() == 2) ;
    }

}
