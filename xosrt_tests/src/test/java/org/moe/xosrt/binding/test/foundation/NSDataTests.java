package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.CharPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import ios.foundation.NSData;
import ios.foundation.NSString;
import ios.foundation.c.Foundation;
import ios.foundation.enums.Enums;
import ios.foundation.enums.NSDataSearchOptions;
import ios.foundation.struct.NSRange;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

//TODO: causes simulator crush
@Ignore
public class NSDataTests extends XOSTest{

    @Test
    public void testData() {
        NSData data = NSData.data();
        assertTrue(data != null);
    }

    @Test
    public void testDataWithBytes_length() {
        NSData aData = NSData.data();
        aData = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 3*2);
        long i = aData.length();
        NSString aDataText = NSString.alloc().initWithDataEncoding(aData, Enums.NSUTF16LittleEndianStringEncoding);
        assertTrue(i == 3*2 && aDataText.isEqual(NSString.stringWithString("012")));
    }

    @Test
    public void testInitWithBytes_length() {
        NSData aData = NSData.alloc().initWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 4);
        assertTrue(aData.length() == 4);
    }

    @Test
    public void testInitWithData() {
        NSData aDataaux = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 4);

        NSData aData = NSData.alloc().initWithData(aDataaux);

        NSString aDataText = NSString.alloc().initWithDataEncoding(aData, Enums.NSASCIIStringEncoding);
        NSString aDataTextAux = NSString.alloc().initWithDataEncoding(aDataaux, Enums.NSASCIIStringEncoding);

        assertTrue(aDataaux.length() == aData.length() && aDataText.isEqual(aDataTextAux));
    }

    @Test
    public void testDataWithData() {
        NSData aDataaux =  NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 4);

        NSData aData = NSData.dataWithData(aDataaux);
        assertTrue(aDataaux.length() == aData.length()
                && NSString.alloc().initWithDataEncoding(aDataaux, Enums.NSASCIIStringEncoding)
                .isEqual(NSString.alloc().initWithDataEncoding(aData, Enums.NSASCIIStringEncoding)));
    }

    @Test
    public void testLength() {
        NSData aData = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 1);
        long i = aData.length();
        NSString text = NSString.alloc().initWithDataEncoding(aData, Enums.NSASCIIStringEncoding);
        assertTrue(i == 1 && text.isEqualToString("0"));
    }

    @Test
    public void testIsEqualToData() {
        NSData data0 = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 3);
        NSData data1 = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 3);
        NSData data2 = NSData.dataWithBytesLength(PtrFactory.newCharArray("0".toCharArray()), 1);
        assertTrue(data0.isEqualToData(data1) && data1.isEqualToData(data0)
                && !data0.isEqualToData(data2) && !data1.isEqualToData(null)
                && data0.isEqualToData(data0));
    }

    @Test
    public void testIsEqual() {
        NSData data0 = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 3);
        NSData data1 = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 3);
        NSData data2 = NSData.dataWithBytesLength(PtrFactory.newCharArray("0".toCharArray()), 1);
        assertTrue(data0.isEqual(data1) && data1.isEqual(data0)
                && !data0.isEqual(data2) && !data1.isEqual(null)
                && data0.isEqual(data0));
    }

    @Test
    public void testGetBytes_length() {
        NSData data = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 8);
        CharPtr buffer = PtrFactory.newCharArray(4);
        data.getBytesLength(buffer, 4);

        NSData dataAux = NSData.alloc().initWithBytesLength(buffer, 4);

        assertTrue(dataAux != null && dataAux.length() == 4);
    }

    @Test
    public void testGetBytes_range() {
        NSData dataaux = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 8);
        CharPtr buffer = PtrFactory.newCharArray(4);
        dataaux.getBytesRange(buffer, Foundation.NSMakeRange(0, 4));

        NSData data = NSData.alloc().initWithBytesLength(buffer, 4);

        assertTrue(data != null && data.length() == 4);
    }

    @Test
    public void testRangeOfData_options_range1() {
        NSData data = NSData.dataWithBytesLength(PtrFactory.newCharArray("567".toCharArray()), 3*2);
        NSData dataaux = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 8*2);

        NSRange range = dataaux.rangeOfDataOptionsRange(data, NSDataSearchOptions.Anchored,
                Foundation.NSMakeRange(5*2, 3*2));

        assertTrue(range.location() == 5*2 && range.length() == 3*2);
    }

    @Test
    public void testRangeOfData_options_range2() {
        NSData data = NSData.dataWithBytesLength(PtrFactory.newCharArray("567".toCharArray()), 1*2);
        NSData dataaux = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 8*2);

        NSRange range = dataaux.rangeOfDataOptionsRange(data, NSDataSearchOptions.Anchored,
                Foundation.NSMakeRange(0, 8*2));

        assertTrue(range.length() == 0);
    }

    @Test
    public void testRangeOfData_options_range3() {
        NSData data = NSData.dataWithBytesLength(PtrFactory.newCharArray("456".toCharArray()), 3*2);
        NSData dataaux = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 8*2);

        NSRange range = dataaux.rangeOfDataOptionsRange(data, NSDataSearchOptions.Backwards,
                Foundation.NSMakeRange(0, 8*2));

        assertTrue(range.location() == 4*2 && range.length() == 3*2);
    }

    @Test
    public void testSubdataWithRange() {
        NSData data = NSData.dataWithBytesLength(PtrFactory.newCharArray("01234567".toCharArray()), 8);

        NSData d1 = data.subdataWithRange(Foundation.NSMakeRange(0, 4));
        assertTrue(d1.length() == 4);
    }

    @Test
    public void testDataWithBytesNoCopy_length() {
        CharPtr base64buffer = PtrFactory.newCharArray(10);
        NSData dataToEncode = NSData.dataWithBytesNoCopyLength(base64buffer, 10);
        assertTrue(dataToEncode != null);
    }

    @Test
    public void testInitWithBytesNoCopy_length() {
        CharPtr base64buffer = PtrFactory.newCharArray(10);
        NSData dataToEncode = NSData.alloc().initWithBytesNoCopyLength(base64buffer, 10);
        assertTrue(dataToEncode != null);
    }
}
