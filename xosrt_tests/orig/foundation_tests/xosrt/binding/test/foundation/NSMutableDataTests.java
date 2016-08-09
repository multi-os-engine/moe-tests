package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.CharArr;
import xosrt.binding.foundation.*;

import org.junit.Test;

public class NSMutableDataTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInitWithCapacity1() {
        NSMutableData  myMutData = NSMutableData.alloc().initWithCapacity(3);
        assertTrue(myMutData != null && myMutData.getBytes() != null);
    }

    @Test
    public void testDataWithCapacity1() {
        NSMutableData  myMutData2 = NSMutableData.dataWithCapacity(4);
        assertTrue(myMutData2 != null && myMutData2.getBytes() != null);
    }

    @Test
    public void testAppendData1() {
        NSData  aData = NSData.data();
        CharArr aByte = new CharArr("023".toCharArray());
        aData = NSData.alloc().initWithBytesLength(aByte, 2);
        NSMutableData  myMutData3 = NSMutableData.alloc().initWithCapacity(3);
        myMutData3.appendData(aData);

        assertTrue (myMutData3.getLength() == 2);
    }

    @Test
    public void testData1() {
        NSMutableData data2 = (NSMutableData)NSMutableData.data();
        assertTrue (data2 == null);
    }

    @Test
    public void testDataWithBytes_length1() {
        NSMutableData  aData = (NSMutableData)NSMutableData.dataWithBytesLength(new CharArr("01234567".toCharArray()), 3);
        long i = aData.getLength();
        NSString  aDataText = NSString.alloc().initWithDataEncoding(
                aData, NSStringEncoding.ASCIIStringEncoding);
        assertTrue (i == 3 && aDataText.isEqual(NSString.fromJavaString("012")));
    }

    @Test
    public void testInitWithBytes_length1() {
        NSMutableData  aData2 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 4);
        assertTrue (aData2.getLength() == 4);
    }

    @Test
    public void testInitWithData1() {

        NSMutableData  aData3aux = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 4);

        NSMutableData aData3 = (NSMutableData)NSMutableData.alloc().initWithData(aData3aux);

        NSString  aData3Text = NSString.alloc().initWithDataEncoding(aData3, NSStringEncoding.ASCIIStringEncoding);
        NSString  aData3TextAux = NSString.alloc().initWithDataEncoding(aData3aux, NSStringEncoding.ASCIIStringEncoding);

        assertTrue (aData3aux.getLength() == aData3.getLength() && aData3Text.isEqual(aData3TextAux));
    }

    @Test
    public void testDataWithData1() {
        NSMutableData  aData4aux = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 4);

        NSMutableData  aData4 = (NSMutableData)NSMutableData.dataWithData(aData4aux);
        assertTrue(aData4aux.getLength() == aData4.getLength() &&
                NSString.alloc().initWithDataEncoding(aData4aux, NSStringEncoding.ASCIIStringEncoding).isEqual(
                        NSString.alloc().initWithDataEncoding(aData4, NSStringEncoding.ASCIIStringEncoding))
        );
    }

    @Test
    public void testLength1() {
        NSMutableData aData55 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 1);
        long i = aData55.getLength();
        NSString  text = NSString.alloc().initWithDataEncoding(aData55, NSStringEncoding.ASCIIStringEncoding);
        assertTrue (i == 1 && text.isEqualToString(NSString.fromJavaString("0")));
    }

    @Test
    public void testIsEqualToData1() {
        NSMutableData data0 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 3);
        NSMutableData data1 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 3);
        NSMutableData data21 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("0".toCharArray()), 1);
        assertTrue (data0.isEqualToData(data1) && data1.isEqualToData(data0)
                && !data0.isEqualToData(data21) && !data1.isEqualToData(null)
                && data0.isEqualToData(data0)
        );
    }

    @Test
    public void testIsEqual1() {
        NSMutableData data3 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 3);
        NSMutableData data4 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 3);
        NSMutableData data5 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("0".toCharArray()), 1);
        assertTrue (data3.isEqual(data4) && data4.isEqual(data3)
                && !data3.isEqual(data5) && !data4.isEqual(null)
                && data3.isEqual(data3)
        );
    }

    @Test
    public void testGetBytes_length1() {
        NSMutableData data6 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 8);
        CharArr buffer = new CharArr(4);
        data6.getBytesLength(buffer, 4);

        NSMutableData data6Aux = (NSMutableData)NSMutableData.alloc().initWithBytesLength(buffer, 4);

        assertTrue (data6Aux != null && data6Aux.getLength() == 4);
    }

    @Test
    public void testGetBytes_range1() {

        NSMutableData data7aux = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 8);
        CharArr buffer = new CharArr(4);
        data7aux.getBytesRange(buffer, Foundation.NSMakeRange(0, 4));

        NSMutableData  data7 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(buffer, 4);

        assertTrue (data7 != null && data7.getLength() == 4) ;
    }

    @Test
    public void testRangeOfData_options_range1() {
        NSMutableData data8 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("567".toCharArray()), 3);
        NSMutableData data8aux = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 8);

        NSRange range2 = data8aux.rangeOfDataOptionsRange(data8, NSDataSearchOptions.Anchored,
                Foundation.NSMakeRange(5, 3));

        assertTrue(range2.getLocation() == 5 && range2.getLength() == 3) ;
    }

    @Test
    public void testRangeOfData_options_range2() {

        NSMutableData data9 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 8);
        NSMutableData data10 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("567".toCharArray()), 1);

        NSRange range4 = data9.rangeOfDataOptionsRange(data10, NSDataSearchOptions.Anchored,
                Foundation.NSMakeRange(0, 8));

        assertTrue(range4.getLength() == 0) ;
    }

    @Test
    public void testRangeOfData_options_range3() {

        NSMutableData data11 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("456".toCharArray()), 3);
        NSMutableData data12 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 8);

        NSRange range5 = data12.rangeOfDataOptionsRange(data11, NSDataSearchOptions.Backwards,
                Foundation.NSMakeRange(0, 8));

        assertTrue(range5.getLocation() == 4 && range5.getLength() == 3);
    }

    @Test
    public void testSubdataWithRange1() {
        NSMutableData data13 = (NSMutableData)NSMutableData.alloc().initWithBytesLength(
                new CharArr("01234567".toCharArray()), 8);

        NSData d1 = data13.subdataWithRange(Foundation.NSMakeRange(0, 4));
        assertTrue (d1.getLength() == 4) ;
    }

    @Test
    public void testDataWithBytesNoCopy_length1() {
        CharArr base64buffer = new CharArr(10);
        NSMutableData dataToEncode = (NSMutableData)NSMutableData.dataWithBytesNoCopyLength(base64buffer, 10);
        assertTrue (dataToEncode != null) ;
    }

    @Test
    public void testInitWithBytesNoCopy_length1() {
        CharArr base64buffer2 = new CharArr(10);
        NSMutableData  dataToEncode2 = (NSMutableData)NSMutableData.alloc().initWithBytesNoCopyLength(
                base64buffer2, 10);
        assertTrue (dataToEncode2 != null) ;
    }

}
