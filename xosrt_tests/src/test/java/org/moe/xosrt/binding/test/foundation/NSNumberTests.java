package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.NSNumber;
import ios.foundation.enums.NSComparisonResult;

import org.junit.Ignore;
import org.junit.Test;

public class NSNumberTests {

    @Test
    public void testIsEqualToNumber1() {
        NSNumber number0 = NSNumber.numberWithInteger(1233);
        NSNumber number1 = NSNumber.numberWithInteger(1233);
        NSNumber number2 = NSNumber.numberWithInt(321);
        assertTrue (number0.isEqualToNumber(number1) && number1.isEqualToNumber(number0)
                && !number0.isEqualToNumber(number2) && number2.isEqualToNumber(number2));
    }

    @Test
    public void testIsEqual1() {
        NSNumber number3 = NSNumber.numberWithInt(1233);
        NSNumber number4 = NSNumber.numberWithInt(1233);
        NSNumber number5 = NSNumber.numberWithInt(321);
        NSNumber number6 = null;
        assertTrue (number3.isEqual(number4) && number4.isEqual(number3)
                && !number3.isEqual(number5) && !number3.isEqual(number6)
                && !number4.isEqual(null) && number5.isEqual(number5));
    }

    @Test
    public void testCompare1() {
        NSNumber number7 = NSNumber.numberWithInt(1);
        NSNumber number8 = NSNumber.numberWithInt(1);
        NSNumber number9 = NSNumber.numberWithInt(2);
        assertTrue ( number7.compare(number8) == NSComparisonResult.Same
                && number7.compare(number9) == NSComparisonResult.Ascending
                && number9.compare(number7) == NSComparisonResult.Descending) ;
    }

    @Test
    public void testDescription1() {
        NSNumber number10 = NSNumber.numberWithInt(123);
        assertTrue(number10.description().equals("123"));
    }

    @Test
    public void testDescriptionWithLocale1() {
        NSNumber number11 = NSNumber.numberWithInt(123);
        assertTrue (number11.descriptionWithLocale(null).equals("123"));
    }

    @Test
    public void testNumberWithBool1() {
        NSNumber number0 = NSNumber.numberWithBool(true);
        assertTrue (number0.boolValue());
    }

    @Test
    public void testNumberWithInt1() {
        NSNumber  number1 = NSNumber.numberWithInt(4);
        assertTrue(number1.intValue() == 4);
    }


    @Test
    public void testNumberWithUnsignedLongLong1() {
        long unsignedLongLong0 = 1234567890123456789L;
        NSNumber number3 = NSNumber.numberWithUnsignedLongLong(unsignedLongLong0);
        assertTrue (number3.unsignedLongLongValue() == unsignedLongLong0) ;
    }

    @Test
    public void testNumberWithDouble1() {
        double double1 = 1230.987654321;
        NSNumber number4 = NSNumber.numberWithDouble(double1);
        assertTrue (Math.abs(number4.doubleValue() - double1) < 0.001) ;
    }

    @Test
    public void testNumberWithChar1() {
        byte char0 = 125;
        NSNumber number5 = NSNumber.numberWithChar(char0);
        assertTrue (number5.charValue() == char0);
    }

    @Test
    public void testNumberWithFloat1() {
        float float0 = 123.132f;
        NSNumber number6 = NSNumber.numberWithFloat(float0);
        assertTrue (number6.floatValue() - float0 <= 0.0001) ;
    }

    @Test
    public void testNumberWithLong1() {
        long long0 = 123123123312L;
        NSNumber number7 = NSNumber.numberWithLong(long0);
        assertTrue (number7.longValue() == long0) ;
    }

    @Test
    public void testNumberWithShort1() {
        short short0 = 1000;
        NSNumber number9 = NSNumber.numberWithShort(short0);
        assertTrue (number9.shortValue() == short0) ;
    }

    @Test
    public void testNumberWithUnsignedChar1() {
        byte unsignedChar0 = 90;
        NSNumber number10 = NSNumber.numberWithUnsignedChar(unsignedChar0);
        assertTrue (number10.unsignedCharValue() == unsignedChar0) ;
    }

    @Test
    public void testNumberWithUnsignedInteger1() {
        long unsignedInteger0 = 123321231L; //TODO: instantiate NSUInteger
        NSNumber number11 = NSNumber.numberWithUnsignedInteger(unsignedInteger0);
        assertTrue (number11.unsignedIntegerValue() == unsignedInteger0) ;
    }

    @Test
    public void testNumberWithUnsignedLong1() {
        long unsignedLong0 = 1000000000;
        NSNumber number12 = NSNumber.numberWithUnsignedLong(unsignedLong0);
        assertTrue (number12.unsignedLongValue() == unsignedLong0) ;
    }

    @Test
    public void testIntValue1() {
        int int0 = 4;
        NSNumber  number0 = NSNumber.numberWithInt(int0);
        assertTrue(number0.intValue() == int0) ;
    }

    @Test
    public void testBoolValue1() {
        NSNumber number1 = NSNumber.numberWithBool(true);
        assertTrue(number1.boolValue());
    }

    @Test
    public void testDoubleValue1() {
        double double0 = 0.12345678901;
        NSNumber number2 = NSNumber.numberWithDouble(double0);
        double double0_1 = 0;
        NSNumber number2_1 = NSNumber.numberWithDouble(double0_1);
        double double0_2 = -1;
        NSNumber number2_2 = NSNumber.numberWithDouble(double0_2);
        assertTrue (number2.doubleValue() - double0 < 0.0001 && number2_1.doubleValue() == double0_1
                && number2_2.doubleValue() == double0_2);
    }

    @Test
    public void testStringValue1() {
        NSNumber number3 = NSNumber.numberWithInt(4);
        assertTrue(number3.stringValue().equals("4")) ;
    }

    @Test
    public void testFloatValue1() {
        float float0 = 4.123f;
        NSNumber number4 = NSNumber.numberWithFloat(4);
        assertTrue(number4.floatValue() - float0 < 0.0001 ) ;
    }

    @Test
    public void testCharValue1() {
        char char1 = 56;
        NSNumber number5 = NSNumber.numberWithDouble(char1);
        byte char2 = -56;
        NSNumber number5_2 = NSNumber.numberWithDouble(char2);
        NSNumber number5_3 = NSNumber.numberWithDouble(9);

        assertTrue (number5.charValue() == char1 && number5_2.charValue() == char2
                && number5_3.charValue() == 9) ;
    }

    @Test
    public void testUnsignedLongValue1() {
        long  unsignedLong0 = 4;
        NSNumber number6 = NSNumber.numberWithUnsignedLong(unsignedLong0);
        assertTrue(number6.unsignedLongValue() == unsignedLong0);
    }

    @Test
    public void testUnsignedLongLongValue1() {
        long unsignedLongLong0 = 9876543210987654L;
        NSNumber number7 = NSNumber.numberWithUnsignedLongLong(unsignedLongLong0);
        assertTrue (number7.unsignedLongLongValue() == unsignedLongLong0) ;
    }

    @Test
    public void testIntegerValue1() {
        int integer0 = 12;
        NSNumber number8 = NSNumber.numberWithInteger(integer0);

        assertTrue (number8.integerValue() == integer0) ;
    }

    @Test
    public void testLongLongValue1() {
        long longLong0 = 9876543210321L;
        NSNumber number9 = NSNumber.numberWithLongLong(longLong0);
        assertTrue (number9.longLongValue() == longLong0) ;
    }

    @Test
    public void testLongValue1() {
        long long0 = 6543210321L;
        NSNumber number10 = NSNumber.numberWithLong(long0);
        assertTrue (number10.longValue() == long0) ;
    }

    @Test
    public void testShortValue1() {
        short short0 = 3213;
        NSNumber number11 = NSNumber.numberWithShort(short0);
        short short0_1 = -3213;
        NSNumber number11_1 = NSNumber.numberWithShort(short0_1);
        short short0_2 = 32133;
        NSNumber number11_2 = NSNumber.numberWithShort(short0_2);
        short short0_3 = 0;
        NSNumber number11_3 = NSNumber.numberWithShort(short0_3);

        assertTrue (number11.shortValue() == short0 && number11_1.shortValue() == short0_1
                && number11_2.shortValue() == short0_2 && number11_3.shortValue() == short0_3);
    }

    @Test
    public void testUnsignedCharValue1() {
        byte unsignedChar0 = 13;
        NSNumber number12 = NSNumber.numberWithUnsignedChar(unsignedChar0);
        assertTrue (number12.unsignedCharValue() == unsignedChar0) ;
    }

    @Test
    public void testUnsignedIntegerValue1() {
        int unsignedInteger0 = 231132213;
        NSNumber number13 = NSNumber.numberWithUnsignedInteger(unsignedInteger0);
        assertTrue (number13.unsignedIntegerValue() == unsignedInteger0) ;
    }

    @Test
    public void testUnsignedIntValue1() {
        int unsignedInt0 = 231132213;
        NSNumber number14 = NSNumber.numberWithUnsignedInt(unsignedInt0);
        assertTrue (number14.unsignedIntegerValue() == unsignedInt0) ;
    }

    @Test
    @Ignore
    //TODO: NSDecimal is absent for iOS
    public void testDecimalValue1() {
//        double aDoubleValue0 = 1.1515000015;
//        double aDoubleValue1 = 1000.848804080;
//        NSNumber number45 = NSNumber.numberWithDouble(aDoubleValue0);
//        NSNumber number46 = NSNumber.numberWithDouble(aDoubleValue0);
//        NSNumber number47 = NSNumber.numberWithDouble(aDoubleValue1);
//        NSDecimal decimal0 = number45.getDecimalValue();
//        NSDecimal decimal1 = number46.getDecimalValue();
//        NSDecimal decimal2 = number47.getDecimalValue();
//        assertTrue (Foundation.NSDecimalCompare(decimal0, decimal1) == NSComparisonResult.Same
//                && Foundation.NSDecimalCompare(decimal0, decimal2) == NSComparisonResult.Ascending
//                && Foundation.NSDecimalCompare(decimal2, decimal0) == NSComparisonResult.Descending
//        );
    }

    @Test
    public void testInitWithInt1() {
        NSNumber aNumber3 = NSNumber.alloc().initWithInt(4);
        char charNumber1 = 5;
        NSNumber aNumber3_1 = NSNumber.alloc().initWithInt(charNumber1);

        assertTrue(aNumber3.intValue() == 4 && aNumber3_1.intValue() == charNumber1
                && aNumber3_1.intValue() == 5);
    }

    @Test
    public void testInitWithBool1() {
        NSNumber  number30 = NSNumber.alloc().initWithBool(true);
        NSNumber  number31 = NSNumber.alloc().initWithBool(false);
        assertTrue (number30.boolValue() && !number31.boolValue()) ;
    }

    @Test
    public void testInitWithChar1() {
        char char2 = 127;
        NSNumber number32 = NSNumber.alloc().initWithChar((byte)char2);
        byte char2_1 = -127;
        NSNumber number32_1 = NSNumber.alloc().initWithChar(char2_1);
        char char2_2 = 0;
        NSNumber number32_2 = NSNumber.alloc().initWithChar((byte)char2_2);
        NSNumber number32_3 = NSNumber.alloc().initWithChar((byte)9);

        assertTrue (number32.charValue() == char2 && number32_1.charValue() == char2_1
                && number32_2.charValue() == char2_2 && number32_3.charValue() == 9) ;
    }

    @Test
    public void testInitWithDouble1() {
        double double2 = 123.132;
        NSNumber number33 = NSNumber.alloc().initWithDouble(double2);
        double double2_1 = -123.132;
        NSNumber number33_1 = NSNumber.alloc().initWithDouble(double2_1);
        double double2_2 = 0;
        NSNumber number33_2 = NSNumber.alloc().initWithDouble(double2_2);
        NSNumber number33_3 = NSNumber.alloc().initWithDouble(123.132);
        assertTrue (number33.doubleValue() - double2 <= 0.0001
                && number33_1.doubleValue() == double2_1
                && number33_2.doubleValue() == double2_2
                && number33_3.doubleValue() == double2);
    }

    @Test
    public void testInitWithFloat1() {
        float float0 = 123.132f;
        NSNumber number34 = NSNumber.alloc().initWithFloat(float0);
        float float0_1 = -123.123f;
        NSNumber number34_1 = NSNumber.alloc().initWithFloat(float0_1);
        float float0_2 = 0;
        NSNumber number34_2 = NSNumber.alloc().initWithFloat(float0_2);
        NSNumber number34_3 = NSNumber.alloc().initWithFloat(123.132f);

        assertTrue (number34.floatValue() - float0 <= 0.0001
                && number34_1.floatValue() == float0_1
                && number34_2.floatValue() == float0_2
                && number34_3.floatValue() == float0);
    }

    @Test
    public void testInitWithInteger1() {
        long integer0 = 1234;
        NSNumber number35 = NSNumber.alloc().initWithInteger(integer0);
        long integer0_1 = -1234;
        NSNumber number35_1 = NSNumber.alloc().initWithInteger(integer0_1);
        long integer0_2 = 0;
        NSNumber number35_2 = NSNumber.alloc().initWithInteger(integer0_2);
        NSNumber number35_3 = NSNumber.alloc().initWithInteger(8);

        assertTrue (number35.integerValue() == integer0
                && number35_1.integerValue() == integer0_1
                && number35_2.integerValue() == integer0_2
                && number35_3.integerValue() == 8) ;
    }

    @Test
    public void testInitWithLong1() {
        long long0 = 1234567890;
        NSNumber number36 = NSNumber.alloc().initWithLong(long0);
        long long0_1 = -1234567890;
        NSNumber number36_1 = NSNumber.alloc().initWithLong(long0_1);
        long long0_2 = 0;
        NSNumber number36_2 = NSNumber.alloc().initWithLong(long0_2);
        NSNumber number36_3 = NSNumber.alloc().initWithLong(1234567890);

        assertTrue (number36.longValue() == long0 && number36_1.longValue() == long0_1
                && number36_2.longValue() == long0_2 && number36_3.longValue() == 1234567890) ;
    }

    @Test
    public void testInitWithLongLong1() {
        long longLong0 = 1234567890123456789l;
        NSNumber number37 = NSNumber.alloc().initWithLongLong(longLong0);
        long longLong0_1 = -1234567890123456789l;
        NSNumber number37_1 = NSNumber.alloc().initWithLongLong(longLong0_1);
        long longLong0_2 = 0;
        NSNumber number37_2 = NSNumber.alloc().initWithLongLong(longLong0_2);
        NSNumber number37_3 = NSNumber.alloc().initWithLongLong(1234567890123456789l);

        assertTrue (number37.longLongValue() == longLong0
                && number37_1.longLongValue() == longLong0_1
                && number37_2.longLongValue() == longLong0_2
                && number37_3.longLongValue() == 1234567890123456789l) ;
    }

    @Test
    public void testInitWithShort1() {
        short short0 = 123;
        NSNumber number38 = NSNumber.alloc().initWithShort(short0);
        short short0_1 = -123;
        NSNumber number38_1 = NSNumber.alloc().initWithShort(short0_1);
        short short0_2 = 0;
        NSNumber number38_2 = NSNumber.alloc().initWithShort(short0_2);
        NSNumber number38_3 = NSNumber.alloc().initWithShort((short)123);

        assertTrue (number38.shortValue() == short0 && number38_1.shortValue() == short0_1
                && number38_2.shortValue() == short0_2 && number38_3.shortValue() == 123) ;
    }

    @Test
    public void testInitWithUnsignedChar1() {
        char unsignedChar0 = 255;
        NSNumber number40 = NSNumber.alloc().initWithUnsignedChar((byte)unsignedChar0);
        assertEquals (unsignedChar0, number40.unsignedCharValue() ) ;
    }

    @Test
    public void testInitWithUnsignedInt1() {
        int unsignedInt0 = 266000;
        NSNumber number41 = NSNumber.alloc().initWithUnsignedInt(unsignedInt0);
        assertTrue (number41.unsignedIntValue() == unsignedInt0) ;
    }

    @Test
    public void testInitWithUnsignedInteger1() {
        long unsignedInteger0 = 2550111;
        NSNumber number42 = NSNumber.alloc().initWithUnsignedInteger(unsignedInteger0);
        assertTrue (number42.unsignedIntegerValue() == unsignedInteger0);
    }

    @Test
    public void testInitWithUnsignedLong1() {
        long unsignedLong0 = 2550111;
        NSNumber number43 = NSNumber.alloc().initWithUnsignedLong(unsignedLong0);
        assertTrue (number43.unsignedLongValue() == unsignedLong0) ;
    }

    @Test
    public void testInitWithUnsignedLongLong1() {
        long unsignedLongLong2 = 2550111;
        NSNumber number44 = NSNumber.alloc().initWithUnsignedLongLong(unsignedLongLong2);
        assertTrue (number44.unsignedLongLongValue() == unsignedLongLong2) ;
    }

    @Test
    public void testCharValue2() {
        char char5 = 'a';
        NSNumber number5_5 = NSNumber.numberWithDouble(char5);
        NSNumber number5_6 = NSNumber.numberWithDouble('a');
        assertTrue (number5_5.charValue() == char5 && number5_6.charValue() == 97);
    }

    @Test
    public void testInitWithInt2() {
        char charNumber1_1 = 'a';
        NSNumber aNumber3_2 = NSNumber.alloc().initWithInt(charNumber1_1);
        NSNumber aNumber3_3 = NSNumber.alloc().initWithInt('a');

        assertTrue(aNumber3_2.intValue() == charNumber1_1 && aNumber3_2.intValue() == 97
                && aNumber3_3.intValue() == 97 && aNumber3_3.intValue() == charNumber1_1);
    }

    @Test
    public void testInitWithChar2() {
        char char2_3 = 'a';
        char charNumber1_1 = 'a';
        NSNumber number32_4 = NSNumber.alloc().initWithChar((byte)char2_3);
        NSNumber number32_5 = NSNumber.alloc().initWithChar((byte)'a');
        assertTrue (number32_4.charValue() == char2_3 && number32_4.charValue() == 97
                && number32_5.charValue() == 97 && number32_5.charValue() == charNumber1_1) ;
    }

    @Test
    public void testInitWithDouble2() {
        char charNumber_1 = 'a';
        NSNumber number33_01 = NSNumber.alloc().initWithDouble(charNumber_1);
        NSNumber number33_02 = NSNumber.alloc().initWithDouble('a');
        assertTrue (number33_01.doubleValue() == charNumber_1 && number33_01.doubleValue() == 97
                && number33_02.doubleValue() == 97 && number33_02.doubleValue() == charNumber_1) ;
    }

    @Test
    public void testInitWithFloat2() {
        char charNumber_2 = 'a';
        NSNumber number34_01 = NSNumber.alloc().initWithFloat(charNumber_2);
        NSNumber number34_02 = NSNumber.alloc().initWithFloat('a');
        assertTrue (number34_01.floatValue() == charNumber_2 && number34_01.floatValue() == 97
                && number34_02.floatValue() == 97 && number34_02.floatValue() == charNumber_2) ;
    }

    @Test
    public void testInitWithInteger2() {
        char charNumber_3 = 'a';
        NSNumber number35_01 = NSNumber.alloc().initWithInteger(charNumber_3);
        NSNumber number35_02 = NSNumber.alloc().initWithInteger('a');
        assertTrue (number35_01.integerValue() == charNumber_3 && number35_01.integerValue() == 97
                && number35_02.integerValue() == 97 && number35_02.integerValue() == charNumber_3);
    }

    @Test
    public void testInitWithLong2() {
        char charNumber_4 = 'a';
        NSNumber number36_01 = NSNumber.alloc().initWithLong(charNumber_4);
        NSNumber number36_02 = NSNumber.alloc().initWithLong('a');
        assertTrue (number36_01.longValue() == charNumber_4 && number36_01.longValue() == 97
                && number36_02.longValue() == 97 && number36_02.longValue() == charNumber_4);
    }

    @Test
    public void testInitWithLongLong2() {
        char charNumber_5 = 'a';
        NSNumber number37_01 = NSNumber.alloc().initWithLongLong(charNumber_5);
        NSNumber number37_02 = NSNumber.alloc().initWithLongLong('a');
        assertTrue (number37_01.longLongValue() == charNumber_5 && number37_01.longLongValue() == 97
                && number37_02.longLongValue() == 97 && number37_02.longLongValue() == charNumber_5);
    }

    @Test
    public void testInitWithShort2() {
        char charNumber_6 = 'a';
        NSNumber number38_01 = NSNumber.alloc().initWithShort((byte)charNumber_6);
        NSNumber number38_02 = NSNumber.alloc().initWithShort((byte)'a');
        assertTrue (number38_01.shortValue() == charNumber_6 && number38_01.shortValue() == 97
                && number38_02.shortValue() == 97 && number38_02.shortValue() == charNumber_6);
    }

    @Test
    public void testUnsignedShortValue1() {
        char unsignedShort0 = 2000;
        NSNumber number15 = NSNumber.numberWithUnsignedShort(unsignedShort0);
        assertTrue (number15.unsignedShortValue() == unsignedShort0);
    }

    @Test
    public void testInitWithUnsignedShort1() {
        char unsignedShort1 = 500;
        NSNumber number45 = NSNumber.alloc().initWithUnsignedShort(unsignedShort1);
        assertTrue (number45.unsignedShortValue() == unsignedShort1) ;
    }

    @Test
    public void testNumberWithUnsignedShort1() {
        char unsignedShort2 = 1000;
        NSNumber number13 = NSNumber.numberWithUnsignedShort(unsignedShort2);
        assertTrue (number13.unsignedShortValue() == unsignedShort2);
    }

}
