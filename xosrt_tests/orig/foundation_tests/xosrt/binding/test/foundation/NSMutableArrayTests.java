package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.core.VoidPtr;
import xosrt.binding.foundation.*;
import xosrt.binding.objc.NSInteger;
import xosrt.binding.objc.NSUInteger;
import xosrt.binding.objc.NSUIntegerPtr;
import xosrt.binding.pointers.FuncPtr;
import xosrt.binding.pointers.IdPtr;
import xosrt.binding.test.foundation.Utils.TestObject;
import org.junit.Test;

public class NSMutableArrayTests {

    static {
        System.loadLibrary("Mac");
    }

    private long intSort(IdPtr num1, IdPtr num2, VoidPtr context)
    {
        int v1 = ((NSNumber) num1.getPointee()).getIntValue();
        int v2 = ((NSNumber) num2.getPointee()).getIntValue();
        if (v1 < v2)
            return NSComparisonResult.Ascending;
        else if (v1 > v2)
            return NSComparisonResult.Descending;
        else
            return NSComparisonResult.Same;
    }

    @Test
    public void testInitWithCapacity1() {
        NSString string0 = NSString.fromJavaString("string0");
        NSString string1 = NSString.fromJavaString("string1");
        NSString string2 = NSString.fromJavaString("string2");

        NSMutableArray array0 = (NSMutableArray)NSMutableArray.alloc().initWithCapacity(3);
        array0.addObject(string0);
        array0.addObject(string1);
        array0.addObject(string2);
        assertTrue(array0.getCount() == 3);
    }

    @Test
    public void testArrayWithCapacity1() {
        NSString string5 = NSString.fromJavaString("string0");
        NSString string6 = NSString.fromJavaString("string1");
        NSString string7 = NSString.fromJavaString("string2");

        NSMutableArray array1 = NSMutableArray.arrayWithCapacity(3);
        array1.addObject(string5);
        array1.addObject(string6);
        array1.addObject(string7);
        assertTrue (array1.getCount() == 3);
    }

    @Test
    public void testAddObject1() {
        NSString string8 = NSString.fromJavaString("string0");

        NSMutableArray array2 = (NSMutableArray)NSMutableArray.array();
        array2.addObject(string8);
        assertTrue (array2.objectAtIndex(0) == string8) ;
    }

    @Test
    public void testInsertObject_atIndex1() {
        NSString string9 = NSString.fromJavaString("string0");
        NSString string10 = NSString.fromJavaString("string1");
        NSString string11 = NSString.fromJavaString("string2");
        NSString string12 = NSString.fromJavaString("string3");

        NSMutableArray array3 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string9, string10, string11}), 3);
        array3.insertObject(string12, 2);
        assertTrue (array3.objectAtIndex(2) == string12);
    }

    @Test
    public void testAddObjectsFromArray1() {
        NSString string13 = NSString.fromJavaString("string0");
        NSString string14 = NSString.fromJavaString("string1");
        NSString string15 = NSString.fromJavaString("string2");

        NSMutableArray array4 = (NSMutableArray)NSMutableArray.array();
        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string15, string14}), 2);
        array4.addObject(string13);
        array4.addObjectsFromArray(array5);
        assertTrue (array4.getCount() == 3) ;
    }

    @Test
    public void testRemoveObject1() {
        NSString string16 = NSString.fromJavaString("string0");
        NSString string17 = NSString.fromJavaString("string1");
        NSString string18 = NSString.fromJavaString("string2");
        NSString string19 = NSString.fromJavaString("string3");

        NSMutableArray array6 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string16, string17, string18, string19}), 4);
        array6.removeObject(string19);
        assertTrue (array6.getCount() == 3) ;
    }

    @Test
    public void testReplaceObjectAtIndex_withObject1() {
        NSString string20 = NSString.fromJavaString("string0");
        NSString string21 = NSString.fromJavaString("string1");
        NSString string22 = NSString.fromJavaString("string2");
        NSString string23 = NSString.fromJavaString("string3");
        NSString string24 = NSString.fromJavaString("string4");

        NSMutableArray array7 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string20, string21, string22, string23}), 4);
        array7.replaceObject(2, string24);
        boolean j = array7.containsObject(string24);
        assertTrue (j && array7.objectAtIndex(2) == string24) ;
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testRemoveObjectAtIndex1() {
        NSString string25 = NSString.fromJavaString("string0");
        NSString string26 = NSString.fromJavaString("string1");
        NSString string27 = NSString.fromJavaString("string2");
        NSString string28 = NSString.fromJavaString("string3");
        NSString string29 = NSString.fromJavaString("string4");

        NSMutableArray array8 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string25, string26, string27, string28, string29}), 5);
        array8.removeObjectAtIndex(2);
        assertTrue (array8.getCount() == 4) ;
    }
    */

    @Test
    public void testRemoveAllObjects1() {
        NSString string30 = NSString.fromJavaString("string0");
        NSString string31 = NSString.fromJavaString("string1");
        NSString string32 = NSString.fromJavaString("string2");
        NSString string33 = NSString.fromJavaString("string3");
        NSString string34 = NSString.fromJavaString("string4");

        NSMutableArray array9 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string30, string31, string32, string33, string34}), 5);
        array9.removeAllObjects();
        assertTrue (array9.getCount() == 0) ;
    }

    @Test
    public void testRemoveLastObject1() {
        NSString string35 = NSString.fromJavaString("string0");
        NSString string36 = NSString.fromJavaString("string1");
        NSString string37 = NSString.fromJavaString("string2");
        NSString string38 = NSString.fromJavaString("string3");
        NSString string39 = NSString.fromJavaString("string4");

        NSMutableArray array10 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string35, string36, string37, string38, string39}), 5);
        long nroItems = array10.getCount();
        array10.removeLastObject();
        assertTrue (array10.getCount() == nroItems-1 && array10.objectAtIndex(array10.getCount()-1) == string38);
    }

    @Test
    public void testRemoveObject_inRange1() {
        NSString string40 = NSString.fromJavaString("string0");
        NSString string42 = NSString.fromJavaString("string2");
        NSString string44 = NSString.fromJavaString("string4");

        NSMutableArray array11 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string40, string42, string42, string42, string44}), 5);
        long nroItems = array11.getCount();
        NSRange range = Foundation.NSMakeRange(1, 2);
        array11.removeObjectInRange(string42, range);
        assertTrue (array11.getCount() == nroItems-2) ;
    }

    @Test
    public void testRemoveObjectsInArray1() {
        NSString string45 = NSString.fromJavaString("string0");
        NSString string46 = NSString.fromJavaString("string1");
        NSString string47 = NSString.fromJavaString("string2");
        NSString string49 = NSString.fromJavaString("string4");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string47, string46}), 2);
        NSMutableArray array12 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string45, string47, string46, string47, string49}), 5);
        long nroItems = array12.getCount();
        array12.removeObjectsInArray(array5);
        assertTrue (array12.getCount() == nroItems-3) ;
    }

    @Test
    public void testReplaceObjectsInRange_withObjectsFromArray_range1() {
        NSString string50 = NSString.fromJavaString("string0");
        NSString string51 = NSString.fromJavaString("string1");
        NSString string52 = NSString.fromJavaString("string2");
        NSString string53 = NSString.fromJavaString("string3");
        NSString string54 = NSString.fromJavaString("string4");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string51, string52}), 2);
        NSMutableArray array13 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string50, string51, string52, string53, string54}), 5);
        NSString stringOrig = (NSString)array13.objectAtIndex(3);
        long nroItems = array13.getCount();
        NSRange rangeOrig = Foundation.NSMakeRange(1, 3);
        NSRange rangeArr = Foundation.NSMakeRange(0, 2);
        array13.replaceObjectsInRangeWithObjectsFromArrayRange(rangeOrig, array5, rangeArr);
        NSString stringNew = (NSString)array13.objectAtIndex(3);
        assertTrue(array13.getCount() == nroItems - 1 && !stringOrig.isEqual(stringNew)
                        && array13.objectAtIndex(1).isEqual(array5.objectAtIndex(0))
                        && array13.objectAtIndex(2).isEqual(array5.objectAtIndex(1))
        );
    }

    @Test
    public void testReplaceObjectsInRange_withObjectsFromArray_range2() {
        NSString string55 = NSString.fromJavaString("string0");
        NSString string56 = NSString.fromJavaString("string1");
        NSString string57 = NSString.fromJavaString("string2");
        NSString string58 = NSString.fromJavaString("string3");
        NSString string59 = NSString.fromJavaString("string4");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string56, string57}), 2);
        NSMutableArray array14 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string55, string56, string57, string58, string59}), 5);
        NSString stringOrig = (NSString)array14.objectAtIndex(1);
        long nroItems = array14.getCount();
        NSRange rangeOrig = Foundation.NSMakeRange(1, 1);
        NSRange rangeArr = Foundation.NSMakeRange(0, 2);
        array14.replaceObjectsInRangeWithObjectsFromArrayRange(rangeOrig, array5, rangeArr);
        NSString stringNew = (NSString)array14.objectAtIndex(1);
        assertTrue(array14.getCount() == nroItems + 1 && !stringOrig.isEqual(stringNew)
                        && array14.objectAtIndex(2).isEqual(array5.objectAtIndex(1))
        );
    }

    @Test
    public void testReplaceObjectsInRange_withObjectsFromArray1() {
        NSString string60 = NSString.fromJavaString("string0");
        NSString string61 = NSString.fromJavaString("string1");
        NSString string62 = NSString.fromJavaString("string2");
        NSString string63 = NSString.fromJavaString("string3");
        NSString string64 = NSString.fromJavaString("string4");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string61, string62}), 2);
        NSMutableArray array15 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string60, string61, string62, string63, string64}), 5);
        NSString stringOrig = (NSString)array15.objectAtIndex(2);
        long nroItems = array15.getCount();
        NSRange rangeOrig = Foundation.NSMakeRange(1, 3);
        array15.replaceObjectsInRangeWithObjectsFromArray(rangeOrig, array5);
        NSString stringNew = (NSString)array15.objectAtIndex(2);
        assertTrue(array15.getCount() == nroItems - 1 && !stringOrig.isEqual(stringNew)
                        && array15.objectAtIndex(1).isEqual(array5.objectAtIndex(0))
                        && array15.objectAtIndex(2).isEqual(array5.objectAtIndex(1))
        ) ;
    }

    @Test
    public void testReplaceObjectsInRange_withObjectsFromArray2() {
        NSString string65 = NSString.fromJavaString("string0");
        NSString string66 = NSString.fromJavaString("string1");
        NSString string67 = NSString.fromJavaString("string2");
        NSString string68 = NSString.fromJavaString("string3");
        NSString string69 = NSString.fromJavaString("string4");

        NSMutableArray array16 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string65, string66, string67, string68, string69}), 5);
        NSMutableArray array17 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string65, string66, string67, string68}), 4);
        NSString stringOrig = (NSString)array16.objectAtIndex(2);
        long nroItems = array16.getCount();
        NSRange rangeOrig = Foundation.NSMakeRange(1, 3);
        array16.replaceObjectsInRangeWithObjectsFromArray(rangeOrig, array17);
        NSString stringNew = (NSString)array16.objectAtIndex(2);
        assertTrue(array16.getCount() == nroItems + 1 && !stringOrig.isEqual(stringNew)
                        && array16.objectAtIndex(1).isEqual(array17.objectAtIndex(0))
                        && array16.objectAtIndex(2).isEqual(array17.objectAtIndex(1))
        );
    }

    @Test
    public void testSortUsingFunction_context1() {
        NSString a = NSString.fromJavaString("1");
        NSString b = NSString.fromJavaString("2");
        NSString c = NSString.fromJavaString("3");
        NSString d = NSString.fromJavaString("4");
        NSString e = NSString.fromJavaString("5");
        NSMutableArray array18 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {a, c, d, b, e}), 5);
        NSString stringOrig = (NSString) array18.objectAtIndex(1);
        array18.sortedArrayUsingFunctionContext(new FuncPtr("intSort"), null);
        NSString stringNew = (NSString)array18.objectAtIndex(1);
        assertTrue(!stringOrig.isEqual(stringNew) && array18.objectAtIndex(2).isEqual(stringOrig));
    }

    @Test
    public void testSortUsingSelector1() throws NoSuchMethodException {
        TestObject newObjectA = TestObject.alloc().init();
        newObjectA.field = NSString.fromJavaString("A");
        TestObject newObjectB = TestObject.alloc().init();
        newObjectB.field = NSString.fromJavaString("B");
        TestObject newObjectC = TestObject.alloc().init();
        newObjectC.field = NSString.fromJavaString("C");
        TestObject newObjectD = TestObject.alloc().init();
        newObjectD.field = NSString.fromJavaString("D");

        NSMutableArray array19 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new TestObject[]{newObjectD, newObjectB, newObjectA, newObjectC}), 4);
        array19.sortedArrayUsingSelector(TestObject.class.getMethod("compareFields"));
        assertTrue (array19.getCount() == 4 && array19.objectAtIndex(0).isEqual(newObjectA)
                && array19.objectAtIndex(1).isEqual(newObjectB)
                && array19.objectAtIndex(2).isEqual(newObjectC)
                && array19.objectAtIndex(3).isEqual(newObjectD)
        );
    }

    @Test
    public void testRemoveObjectsAtIndexes1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        NSMutableArray array20 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"), NSString.fromJavaString("a"),
                        NSString.fromJavaString("two"), NSString.fromJavaString("b"),
                        NSString.fromJavaString("three"), NSString.fromJavaString("four")
                }), 6);

        NSString item2 = (NSString)array20.objectAtIndex(1);
        NSString item3 = (NSString)array20.objectAtIndex(2);
        NSString item4 = (NSString)array20.objectAtIndex(3);
        NSString item5 = (NSString)array20.objectAtIndex(4);

        array20.removeObjectsAtIndexes(set1);

        NSString newItem2 = (NSString)array20.objectAtIndex(1);
        NSString newItem3 = (NSString)array20.objectAtIndex(2);

        assertTrue(!newItem2.isEqual(item2) && newItem2.isEqual(item4) &&
                !newItem3.isEqual(item3) && newItem3.isEqual(item5)
        );
    }

    @Test
    public void testReplaceObjectsAtIndexes_withObjects1() {
        NSString string70 = NSString.fromJavaString("string0");
        NSString string71 = NSString.fromJavaString("string1");
        NSString string72 = NSString.fromJavaString("string2");
        NSString string73 = NSString.fromJavaString("string3");
        NSString string74 = NSString.fromJavaString("string4");

        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        NSMutableArray array21 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string70, string71, string72, string73, string74}), 5);
        NSMutableArray array22 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string74, string73}), 2);
        NSString item2 = (NSString)array21.objectAtIndex(1);
        NSString item3 = (NSString)array21.objectAtIndex(2);
        NSString itemReplace0 = (NSString)array22.objectAtIndex(0);
        NSString itemReplace1 = (NSString)array22.objectAtIndex(1);

        long nroItems = array21.getCount();
        array21.replaceObjectsAtIndexesWithObjects(set1, array22);
        NSString newItem2 = (NSString)array21.objectAtIndex(1);
        NSString newItem3 = (NSString)array21.objectAtIndex(2);

        assertTrue(!newItem2.isEqual(item2) && newItem2.isEqual(itemReplace0)
                && !newItem3.isEqual(item3) && newItem3.isEqual(itemReplace1));
    }

    @Test
    public void testInsertObjects_atIndexes1() {
        NSString string75 = NSString.fromJavaString("string0");
        NSString string76 = NSString.fromJavaString("string1");
        NSString string77 = NSString.fromJavaString("string2");
        NSString string78 = NSString.fromJavaString("string3");
        NSString string79 = NSString.fromJavaString("string4");

        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        NSMutableArray array23 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string75, string76, string77, string78, string79}), 5);
        NSMutableArray array24 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string79, string78}), 2);
        NSString item2 = (NSString)array23.objectAtIndex(1);
        NSString item3 = (NSString)array23.objectAtIndex(2);
        NSString itemReplace0 = (NSString)array24.objectAtIndex(0);
        NSString itemReplace1 = (NSString)array24.objectAtIndex(1);
        long nroItems = array23.getCount();

        array23.insertObjectsAtIndexes(array24, set1);

        NSString newItem2 = (NSString)array23.objectAtIndex(1);
        NSString newItem3 = (NSString)array23.objectAtIndex(2);

        long newNroItems = array23.getCount();
        assertTrue(newNroItems == nroItems + 2 && !newItem2.isEqual(item2)
                        && newItem2.isEqual(itemReplace0) && !newItem3.isEqual(item3)
                        && newItem3.isEqual(itemReplace1) && item2.isEqualToString((NSString) array23.objectAtIndex(3))
                        && item3.isEqualToString((NSString) array23.objectAtIndex(4))
        );
    }

    @Test
    public void testExchangeObjectAtIndex_withObjectAtIndex1() {
        NSString string80 = NSString.fromJavaString("string0");
        NSString string81 = NSString.fromJavaString("string1");
        NSString string82 = NSString.fromJavaString("string2");
        NSString string83 = NSString.fromJavaString("string3");
        NSString string84 = NSString.fromJavaString("string4");
        NSMutableArray array25 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string80, string81, string82, string83, string84}), 5);
        NSString item1 = (NSString)array25.objectAtIndex(1);
        NSString item4 = (NSString)array25.objectAtIndex(4);

        array25.exchangeObjectAtIndexWithObjectAtIndex(1, 4);

        NSString newItem1 = (NSString)array25.objectAtIndex(1);
        NSString newItem4 = (NSString)array25.objectAtIndex(4);

        assertTrue (!newItem1.isEqualToString(item1) && newItem1.isEqualToString(item4)
                && !newItem4.isEqualToString(item4) && newItem4.isEqualToString(item1)
        );
    }

    @Test
    public void testArray1() {
        NSMutableArray  array0 = (NSMutableArray)NSMutableArray.array();
        assertTrue(array0 != null && array0.getCount() == 0) ;
    }

    //TODO: varargs
    /*
    @Test
    public void testArrayWithObjects1() {
        NSString string3 = NSString.fromJavaString("string0");
        NSString string4 = NSString.fromJavaString("string1");
        NSString string5 = NSString.fromJavaString("string2");

        NSMutableArray  array1 = (NSMutableArray)NSMutableArray.arrayWithObjects(
                new IdArr<NSObject>(new NSString[] {string3, string4, string5}));
        NSMutableArray emptyArray = (NSMutableArray)NSMutableArray.array();
        assertTrue(array1.getCount() == 3 && emptyArray.getCount() == 0) ;
    }

    @Test
    public void testInitWithObjects1() {
        NSString string6 = NSString.fromJavaString("string0");
        NSString string7 = NSString.fromJavaString("string1");
        NSString string8 = NSString.fromJavaString("string2");
        NSMutableArray array2 = NSMutableArray.alloc().initWithObjects(string6, string7, string8);
        assertTrue(array2.getCount() == 3);
    }
    */

    @Test
    public void testArrayWithArray1() {
        NSMutableArray anArray0 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("A"), NSString.fromJavaString("B")
                }), 2);
        NSMutableArray anArray1 = (NSMutableArray)NSMutableArray.arrayWithArray(anArray0);
        assertTrue (anArray1.getCount() == 2 && anArray1.objectAtIndex(0).isEqual(anArray0.objectAtIndex(0))
                && anArray1.objectAtIndex(1).isEqual(anArray0.objectAtIndex(1))
        );
    }

    @Test
    public void testInitWithArray1() {
        NSMutableArray anArray2 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("A"), NSString.fromJavaString("B")
                }), 2);
        NSMutableArray anArray3 = (NSMutableArray)NSMutableArray.alloc().initWithArray(anArray2);
        assertTrue (anArray3.getCount() == 2 && anArray2.objectAtIndex(0).isEqual(anArray3.objectAtIndex(0))
                && anArray2.objectAtIndex(1).isEqual(anArray3.objectAtIndex(1))
        );
    }

    @Test
    public void testArrayWithObject1() {
        NSString string9 = NSString.fromJavaString("string0");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObject(string9);
        assertTrue (array5.getCount() == 1) ;
    }

    @Test
    public void testObjectEnumerator1() {
        NSString string10 = NSString.fromJavaString("string0");
        NSString string11 = NSString.fromJavaString("string1");
        NSString string12 = NSString.fromJavaString("string2");
        NSMutableArray array6 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string10, string11, string12}), 3);
        NSEnumerator enumerator0 = array6.objectEnumerator();
        NSObject anObject;
        int count0 = 0;
        anObject = enumerator0.nextObject();
        while (anObject != null)
        {
            count0++;
            anObject = enumerator0.nextObject();
        }
        assertTrue (count0 == 3) ;
    }

    @Test
    public void testContainsObject1() {
        NSString string13 = NSString.fromJavaString("string0");
        NSString string14 = NSString.fromJavaString("string1");
        NSString string15 = NSString.fromJavaString("string2");
        NSMutableArray array7 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string13, string14, string15}), 3);
        boolean flag0 = array7.containsObject(string14);
        assertTrue (flag0 && array7.containsObject(string14));
    }

    @Test
    public void testLastObject1() {
        NSString string16 = NSString.fromJavaString("string0");
        NSString string17 = NSString.fromJavaString("string1");
        NSString string18 = NSString.fromJavaString("string2");
        NSMutableArray array8 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string16, string17, string18}), 3);
        assertTrue ((array8.getLastObject()) == string18) ;
    }

    @Test
    public void testDescription1() {
        NSString objectToInitArray = NSString.fromJavaString("asdf");
        NSMutableArray array11 = (NSMutableArray)NSMutableArray.arrayWithObject(objectToInitArray);
        NSString description = array11.description();
        NSString description2 = NSString.fromJavaString("(\n    asdf\n)");
        assertTrue (description.isEqualToString(description2));
    }

    @Test
    public void testObjectAtIndex1() {
        NSString string19 = NSString.fromJavaString("string0");
        NSString string20 = NSString.fromJavaString("string1");
        NSString string21 = NSString.fromJavaString("string2");
        NSMutableArray array12 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string19, string20, string21}), 3);
        assertTrue (array12.objectAtIndex(2) == string21);
    }

    @Test
    public void testCount1() {
        NSString string22 = NSString.fromJavaString("string0");
        NSString string23 = NSString.fromJavaString("string1");
        NSString string24 = NSString.fromJavaString("string2");
        NSMutableArray array13 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string22, string23, string24}), 3);
        assertTrue (array13.getCount() == 3);
    }

    @Test
    public void testInit1() {
        NSMutableArray array14 = (NSMutableArray)NSMutableArray.alloc().init();
        assertTrue(array14 != null && array14.getCount() == 0) ;
    }

    @Test
    public void testIsEqualToArray1() {
        NSMutableArray array15 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("hello"),
                        NSString.fromJavaString("food"),
                        NSString.fromJavaString("sleep")
                }), 3);
        NSMutableArray array16 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("hello"),
                        NSString.fromJavaString("food"),
                        NSString.fromJavaString("sleep")
                }), 3);
        NSMutableArray array17 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("hello"),
                        NSString.fromJavaString("sleep"),
                        NSString.fromJavaString("food")
                }), 3);
        NSMutableArray array18 = NSMutableArray.alloc().init();
        NSMutableArray array19 = null;
        assertTrue (array15.isEqualToArray(array16) && array16.isEqualToArray(array15)
                && array15.isEqualToArray(array15) && array16.isEqualToArray(array16)
                && !array15.isEqualToArray(array17) && !array16.isEqualToArray(array18)
                && !array17.isEqualToArray(array19) && !array18.isEqualToArray(null));
    }

    @Test
    public void testIsEqual1() {
        NSMutableArray array20 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("hello"),
                        NSString.fromJavaString("food"),
                        NSString.fromJavaString("sleep")
                }), 3);
        NSMutableArray array21 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("hello"),
                        NSString.fromJavaString("food"),
                        NSString.fromJavaString("sleep")
                }), 3);
        NSMutableArray array22 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{NSString.fromJavaString("hello")}), 1);
        NSMutableArray array23 = NSMutableArray.alloc().init();
        NSMutableArray array24 = null;
        assertTrue (array20.isEqual(array21) && array21.isEqual(array20)
                && array20.isEqual(array20) && array20.isEqual(array20)
                && !array20.isEqual(array22) && !array21.isEqual(array23)
                && !array22.isEqual(array24) && !array23.isEqual(null)
        );
    }

    @Test
    public void testArrayWithObjects_count1() {
        IdArr<NSObject> strings =new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("strings0obj0"),
                NSString.fromJavaString("strings0obj1"),
                NSString.fromJavaString("strings0obj2")
        });
        NSMutableArray array25 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(strings, 2);
        assertTrue (array25.getCount() == 2
                && ((NSString)array25.objectAtIndex(0)).isEqualToString(NSString.fromJavaString("strings0obj0"))
                && ((NSString)array25.objectAtIndex(1)).isEqualToString(NSString.fromJavaString("strings0obj1")));
    }

    @Test
    public void testInitWithObjects_count1() {
        IdArr<NSObject> strings = new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("strings1obj0"),
                NSString.fromJavaString("strings1obj1"),
                NSString.fromJavaString("strings1obj2")
        });
        NSMutableArray array26 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(strings, 2);
        assertTrue (array26.getCount() == 2
                && ((NSString)array26.objectAtIndex(0)).isEqualToString(NSString.fromJavaString("strings1obj0"))
                && ((NSString)array26.objectAtIndex(1)).isEqualToString(NSString.fromJavaString("strings1obj1"))
        );
    }

    @Test
    public void testIndexOfObject1() {
        NSString string25 = NSString.fromJavaString("string3");
        NSString string26 = NSString.fromJavaString("string4");
        NSString string27 = NSString.fromJavaString("string5");
        NSString string28 = NSString.fromJavaString("string6");
        NSMutableArray array27 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{string25, string26, string27}), 3);
        assertTrue (array27.indexOfObject(string25) == 0
                && array27.indexOfObject(NSString.fromJavaString("string4")) == 1
                && array27.indexOfObject(string28) == Foundation.NotFound
        );
    }

    @Test
    public void testArrayByAddingObject1() {
        NSMutableArray array28 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("0"),
                        NSString.fromJavaString("1")
                }), 2);
        NSMutableArray array29 = (NSMutableArray)array28.arrayByAddingObject(NSString.fromJavaString("2"));
        assertTrue (array29.getCount() == 3 && array29.objectAtIndex(2).isEqual(NSString.fromJavaString("2")));
    }

    @Test
    public void testArrayByAddingObjectsFromArray1() {
        NSMutableArray array30 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("0"),
                        NSString.fromJavaString("1")
                }), 2);
        NSMutableArray array31 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("A"),
                        NSString.fromJavaString("B")
                }), 2);
        NSMutableArray array32 = (NSMutableArray)array30.arrayByAddingObjectsFromArray(array31);
        assertTrue (array32.getCount() == 4
                && array32.objectAtIndex(0).isEqual(NSString.fromJavaString("0"))
                && array32.objectAtIndex(1).isEqual(NSString.fromJavaString("1"))
                && array32.objectAtIndex(2).isEqual(NSString.fromJavaString("A"))
                && array32.objectAtIndex(3).isEqual(NSString.fromJavaString("B"))
        );
    }

}
