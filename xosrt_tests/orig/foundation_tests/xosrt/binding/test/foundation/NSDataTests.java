package xosrt.binding.test.foundation;

import xosrt.binding.arrays.CharArr;
import xosrt.binding.foundation.Foundation;
import xosrt.binding.foundation.NSData;
import xosrt.binding.foundation.NSDataSearchOptions;
import xosrt.binding.foundation.NSRange;
import xosrt.binding.foundation.NSString;
import xosrt.binding.foundation.NSStringEncoding;
import org.junit.Test;

import static org.junit.Assert.*;

public class NSDataTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testData() {
        NSData data = NSData.data();
        assertTrue(data != null);
    }

    @Test
    public void testDataWithBytes_length() {
        NSData aData = NSData.data();
        aData = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 3);
        long i = aData.getLength();
        NSString aDataText = NSString.alloc().initWithDataEncoding(aData, NSStringEncoding.ASCIIStringEncoding);
        assertTrue(i == 3 && aDataText.isEqual(NSString.fromJavaString("012")));
    }

    @Test
    public void testInitWithBytes_length() {
        NSData aData = NSData.alloc().initWithBytesLength(new CharArr("01234567".toCharArray()), 4);
        assertTrue(aData.getLength() == 4);
    }

    @Test
    public void testInitWithData() {
        NSData aDataaux = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 4);

        NSData aData = NSData.alloc().initWithData(aDataaux);

        NSString aDataText = NSString.alloc().initWithDataEncoding(aData, NSStringEncoding.ASCIIStringEncoding);
        NSString aDataTextAux = NSString.alloc().initWithDataEncoding(aDataaux, NSStringEncoding.ASCIIStringEncoding);

        assertTrue(aDataaux.getLength() == aData.getLength() && aDataText.isEqual(aDataTextAux));
    }

    @Test
    public void testDataWithData() {
        NSData aDataaux =  NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 4);

        NSData aData = NSData.dataWithData(aDataaux);
        assertTrue(aDataaux.getLength() == aData.getLength()
                && NSString.alloc().initWithDataEncoding(aDataaux, NSStringEncoding.ASCIIStringEncoding)
                .isEqual(NSString.alloc().initWithDataEncoding(aData, NSStringEncoding.ASCIIStringEncoding)));
    }

    @Test
    public void testLength() {
        NSData aData = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 1);
        long i = aData.getLength();
        NSString text = NSString.alloc().initWithDataEncoding(aData, NSStringEncoding.ASCIIStringEncoding);
        assertTrue(i == 1 && text.isEqualToString(NSString.fromJavaString("0")));
    }

    @Test
    public void testIsEqualToData() {
        NSData data0 = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 3);
        NSData data1 = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 3);
        NSData data2 = NSData.dataWithBytesLength(new CharArr("0".toCharArray()), 1);
        assertTrue(data0.isEqualToData(data1) && data1.isEqualToData(data0)
                && !data0.isEqualToData(data2) && !data1.isEqualToData(null)
                && data0.isEqualToData(data0));
    }

    @Test
    public void testIsEqual() {
        NSData data0 = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 3);
        NSData data1 = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 3);
        NSData data2 = NSData.dataWithBytesLength(new CharArr("0".toCharArray()), 1);
        assertTrue(data0.isEqual(data1) && data1.isEqual(data0)
                && !data0.isEqual(data2) && !data1.isEqual(null)
                && data0.isEqual(data0));
    }

    @Test
    public void testGetBytes_length() {
        NSData data = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 8);
        CharArr buffer = new CharArr(4);
        data.getBytesLength(buffer, 4);

        NSData dataAux = NSData.alloc().initWithBytesLength(buffer, 4);

        assertTrue(dataAux != null && dataAux.getLength() == 4);
    }

    @Test
    public void testGetBytes_range() {
        NSData dataaux = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 8);
        CharArr buffer = new CharArr(4);
        dataaux.getBytesRange(buffer, Foundation.NSMakeRange(0, 4));

        NSData data = NSData.alloc().initWithBytesLength(buffer, 4);

        assertTrue(data != null && data.getLength() == 4);
    }

    @Test
    public void testRangeOfData_options_range1() {
        NSData data = NSData.dataWithBytesLength(new CharArr("567".toCharArray()), 3);
        NSData dataaux = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 8);

        NSRange range = dataaux.rangeOfDataOptionsRange(data, NSDataSearchOptions.Anchored,
                Foundation.NSMakeRange(5, 3));

        assertTrue(range.getLocation() == 5 && range.getLength() == 3);
    }

    @Test
    public void testRangeOfData_options_range2() {
        NSData data = NSData.dataWithBytesLength(new CharArr("567".toCharArray()), 1);
        NSData dataaux = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 8);

        NSRange range = dataaux.rangeOfDataOptionsRange(data, NSDataSearchOptions.Anchored,
                Foundation.NSMakeRange(0, 8));

        assertTrue(range.getLength() == 0);
    }

    @Test
    public void testRangeOfData_options_range3() {
        NSData data = NSData.dataWithBytesLength(new CharArr("456".toCharArray()), 3);
        NSData dataaux = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 8);

        NSRange range = dataaux.rangeOfDataOptionsRange(data, NSDataSearchOptions.Backwards,
                Foundation.NSMakeRange(0, 8));

        assertTrue(range.getLocation() == 4 && range.getLength() == 3);
    }

    @Test
    public void testSubdataWithRange() {
        NSData data = NSData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 8);

        NSData d1 = data.subdataWithRange(Foundation.NSMakeRange(0, 4));
        assertTrue(d1.getLength() == 4);
    }

    @Test
    public void testDataWithBytesNoCopy_length() {
        CharArr base64buffer = new CharArr(10);
        NSData dataToEncode = NSData.dataWithBytesNoCopyLength(base64buffer, 10);
        assertTrue(dataToEncode != null);
    }

    @Test
    public void testInitWithBytesNoCopy_length() {
        CharArr base64buffer = new CharArr(10);
        NSData dataToEncode = NSData.alloc().initWithBytesNoCopyLength(base64buffer, 10);
        assertTrue(dataToEncode != null);
    }
}
