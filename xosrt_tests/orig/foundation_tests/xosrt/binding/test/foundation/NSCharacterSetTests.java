package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.NSCharacterSet;
import xosrt.binding.foundation.NSString;
import org.junit.Test;

public class NSCharacterSetTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testWhitespaceCharacterSet() {
        NSCharacterSet aCharSet0 = NSCharacterSet.whitespaceCharacterSet();
        assertTrue(aCharSet0 != null && aCharSet0.characterIsMember((short)0x0020)
                && aCharSet0.characterIsMember((short)0x0009));
    }

    @Test
    public void testNewlineCharacterSet() {
        NSCharacterSet aCharSet1 = NSCharacterSet.newlineCharacterSet();
        assertTrue(aCharSet1 != null && aCharSet1.characterIsMember((short)0x000A)
                && aCharSet1.characterIsMember((short)0x000D));
    }

    @Test
    public void testCharacterIsMember() {
        assertTrue(NSCharacterSet.whitespaceCharacterSet().characterIsMember((short)0x0020)
                && NSCharacterSet.whitespaceCharacterSet().characterIsMember((short) 0x0009));
    }

    @Test
    public void testDecimalDigitCharacterSet() {
        NSCharacterSet aCharSet3 = NSCharacterSet.decimalDigitCharacterSet();
        assertTrue(aCharSet3 != null && aCharSet3.characterIsMember((short)0x0030)
                && aCharSet3.characterIsMember((short)0x0031)
                && aCharSet3.characterIsMember((short)0x0032)
                && aCharSet3.characterIsMember((short)0x0033)
                && aCharSet3.characterIsMember((short)0x0034)
                && aCharSet3.characterIsMember((short)0x0035)
                && aCharSet3.characterIsMember((short)0x0036)
                && aCharSet3.characterIsMember((short)0x0037)
                && aCharSet3.characterIsMember((short)0x0038)
                && aCharSet3.characterIsMember((short)0x0039)
        );
    }

    @Test
    public void testPunctuationCharacterSet() {
        NSCharacterSet aCharSet = NSCharacterSet.punctuationCharacterSet();
        assertTrue(aCharSet != null && aCharSet.characterIsMember((short)0x0021)
                && aCharSet.characterIsMember((short)0x0022)
                && aCharSet.characterIsMember((short)0x0025)
                && aCharSet.characterIsMember((short)0x0027)
                && aCharSet.characterIsMember((short)0x0028)
                && aCharSet.characterIsMember((short)0x0029)
                && aCharSet.characterIsMember((short)0x002C)
                && aCharSet.characterIsMember((short)0x002D)
                && aCharSet.characterIsMember((short)0x002E)
                && aCharSet.characterIsMember((short)0x002F)
                && aCharSet.characterIsMember((short)0x003A)
                && aCharSet.characterIsMember((short)0x003B)
                && aCharSet.characterIsMember((short)0x003F)
                && aCharSet.characterIsMember((short)0x005B)
                && aCharSet.characterIsMember((short)0x005C)
                && aCharSet.characterIsMember((short)0x005D)
                && aCharSet.characterIsMember((short)0x007B)
                && aCharSet.characterIsMember((short)0x007D)
        );
    }

    @Test
    public void testUppercaseLetterCharacterSet() {
        NSCharacterSet aCharSet = NSCharacterSet.uppercaseLetterCharacterSet();
        assertTrue(aCharSet != null && aCharSet.characterIsMember((short)0x0041)
                && aCharSet.characterIsMember((short)0x0042)
                && aCharSet.characterIsMember((short)0x0043)
                && aCharSet.characterIsMember((short)0x0044)
                && aCharSet.characterIsMember((short)0x0045)
                && aCharSet.characterIsMember((short)0x0046)
                && aCharSet.characterIsMember((short)0x0047)
                && aCharSet.characterIsMember((short)0x0048)
                && aCharSet.characterIsMember((short)0x0049)
                && aCharSet.characterIsMember((short)0x004A)
                && aCharSet.characterIsMember((short)0x004B)
                && aCharSet.characterIsMember((short)0x004C)
                && aCharSet.characterIsMember((short)0x004D)
                && aCharSet.characterIsMember((short)0x004E)
                && aCharSet.characterIsMember((short)0x004F)
                && aCharSet.characterIsMember((short)0x0050)
                && aCharSet.characterIsMember((short)0x0051)
                && aCharSet.characterIsMember((short)0x0052)
                && aCharSet.characterIsMember((short)0x0053)
                && aCharSet.characterIsMember((short)0x0054)
                && aCharSet.characterIsMember((short)0x0055)
                && aCharSet.characterIsMember((short)0x0056)
                && aCharSet.characterIsMember((short)0x0057)
                && aCharSet.characterIsMember((short)0x0058)
                && aCharSet.characterIsMember((short)0x0059)
                && aCharSet.characterIsMember((short)0x005A)
        );
    }

    @Test
    public void testLowercaseLetterCharacterSet() {
        NSCharacterSet aCharSet = NSCharacterSet.lowercaseLetterCharacterSet();
        assertTrue(aCharSet != null && aCharSet.characterIsMember((short)0x0061)
                && aCharSet.characterIsMember((short)0x0062)
                && aCharSet.characterIsMember((short)0x0063)
                && aCharSet.characterIsMember((short)0x0064)
                && aCharSet.characterIsMember((short)0x0065)
                && aCharSet.characterIsMember((short)0x0066)
                && aCharSet.characterIsMember((short)0x0067)
                && aCharSet.characterIsMember((short)0x0068)
                && aCharSet.characterIsMember((short)0x0069)
                && aCharSet.characterIsMember((short)0x006A)
                && aCharSet.characterIsMember((short)0x006B)
                && aCharSet.characterIsMember((short)0x006C)
                && aCharSet.characterIsMember((short)0x006D)
                && aCharSet.characterIsMember((short)0x006E)
                && aCharSet.characterIsMember((short)0x006F)
                && aCharSet.characterIsMember((short)0x0070)
                && aCharSet.characterIsMember((short)0x0071)
                && aCharSet.characterIsMember((short)0x0072)
                && aCharSet.characterIsMember((short)0x0073)
                && aCharSet.characterIsMember((short)0x0074)
                && aCharSet.characterIsMember((short)0x0075)
                && aCharSet.characterIsMember((short)0x0076)
                && aCharSet.characterIsMember((short)0x0077)
                && aCharSet.characterIsMember((short)0x0078)
                && aCharSet.characterIsMember((short)0x0079)
                && aCharSet.characterIsMember((short)0x007A)
        );
    }

    @Test
    public void testCharacterSetWithCharactersInString() {
        NSCharacterSet aCharSet = NSCharacterSet.characterSetWithCharactersInString(
                NSString.fromJavaString("ABC"));
        assertTrue(aCharSet != null && aCharSet.characterIsMember((short)0x0041)
                && aCharSet.characterIsMember((short)0x0042)
                && aCharSet.characterIsMember((short)0x0043)
        );
    }

    @Test
    public void testIsSupersetOfSet1() {
        NSCharacterSet aCharSet0 = NSCharacterSet.characterSetWithCharactersInString(
                NSString.fromJavaString("ABCDEF"));
        NSCharacterSet aCharSet1 = NSCharacterSet.characterSetWithCharactersInString(
                NSString.fromJavaString("ABC"));
        assertTrue(aCharSet0.isSupersetOfSet(aCharSet1));
    }

    @Test
    public void testIsSupersetOfSet2() {
        NSCharacterSet aCharSet0 = NSCharacterSet.characterSetWithCharactersInString(
                NSString.fromJavaString("ABCDEF"));
        NSCharacterSet aCharSet1 = NSCharacterSet.characterSetWithCharactersInString(
                NSString.fromJavaString("GH"));
        assertFalse(aCharSet0.isSupersetOfSet(aCharSet1));
    }
}
