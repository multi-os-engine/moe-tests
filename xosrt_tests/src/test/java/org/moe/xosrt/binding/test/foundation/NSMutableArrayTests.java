package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.ConstPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import static org.junit.Assert.*;
import ios.foundation.*;

import org.moe.xosrt.binding.test.foundation.Utils.TestObject;

import ios.foundation.c.Foundation;
import ios.foundation.enums.Enums;
import ios.foundation.enums.NSComparisonResult;
import ios.foundation.struct.NSRange;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSMutableArrayTests extends XOSTest{

    @Test
    public void testInitWithCapacity1() {
        NSString string0 = NSString.stringWithString("string0");
        NSString string1 = NSString.stringWithString("string1");
        NSString string2 = NSString.stringWithString("string2");

        NSMutableArray array0 = (NSMutableArray)NSMutableArray.alloc().initWithCapacity(3);
        array0.addObject(string0);
        array0.addObject(string1);
        array0.addObject(string2);
        assertTrue(array0.count() == 3);
    }

    @Test
    public void testArrayWithCapacity1() {
        NSString string5 = NSString.stringWithString("string0");
        NSString string6 = NSString.stringWithString("string1");
        NSString string7 = NSString.stringWithString("string2");

        NSMutableArray array1 = NSMutableArray.arrayWithCapacity(3);
        array1.addObject(string5);
        array1.addObject(string6);
        array1.addObject(string7);
        assertTrue (array1.count() == 3);
    }

    @Test
    public void testAddObject1() {
        NSString string8 = NSString.stringWithString("string0");

        NSMutableArray array2 = (NSMutableArray)NSMutableArray.array();
        array2.addObject(string8);
        assertEquals ( string8.toString() , array2.objectAtIndex(0)) ;
    }

    @Test
    public void testInsertObject_atIndex1() {
        NSString string9 = NSString.stringWithString("string0");
        NSString string10 = NSString.stringWithString("string1");
        NSString string11 = NSString.stringWithString("string2");
        NSString string12 = NSString.stringWithString("string3");

        NSMutableArray array3 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[]{string9, string10, string11}), 3);
        array3.insertObjectAtIndex(string12, 2);
        assertEquals ( string12.toString(), array3.objectAtIndex(2) );
    }

    @Test
    public void testAddObjectsFromArray1() {
        NSString string13 = NSString.stringWithString("string0");
        NSString string14 = NSString.stringWithString("string1");
        NSString string15 = NSString.stringWithString("string2");

        NSMutableArray array4 = (NSMutableArray)NSMutableArray.array();
        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string15, string14}), 2);
        array4.addObject(string13);
        array4.addObjectsFromArray(array5);
        assertTrue (array4.count() == 3) ;
    }

    @Test
    public void testRemoveObject1() {
        NSString string16 = NSString.stringWithString("string0");
        NSString string17 = NSString.stringWithString("string1");
        NSString string18 = NSString.stringWithString("string2");
        NSString string19 = NSString.stringWithString("string3");

        NSMutableArray array6 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string16, string17, string18, string19}), 4);
        array6.removeObject(string19);
        assertTrue (array6.count() == 3) ;
    }

    @Test
    public void testReplaceObjectAtIndex_withObject1() {
        NSString string20 = NSString.stringWithString("string0");
        NSString string21 = NSString.stringWithString("string1");
        NSString string22 = NSString.stringWithString("string2");
        NSString string23 = NSString.stringWithString("string3");
        NSString string24 = NSString.stringWithString("string4");

        NSMutableArray array7 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string20, string21, string22, string23}), 4);
        array7.replaceObjectAtIndexWithObject(2, string24);
        assertTrue( array7.containsObject(string24));
        assertEquals( string24.toString(), array7.objectAtIndex(2));
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testRemoveObjectAtIndex1() {
        NSString string25 = NSString.stringWithString("string0");
        NSString string26 = NSString.stringWithString("string1");
        NSString string27 = NSString.stringWithString("string2");
        NSString string28 = NSString.stringWithString("string3");
        NSString string29 = NSString.stringWithString("string4");

        NSMutableArray array8 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string25, string26, string27, string28, string29}), 5);
        array8.removeObjectAtIndex(2);
        assertTrue (array8.count() == 4) ;
    }
    */

    @Test
    public void testRemoveAllObjects1() {
        NSString string30 = NSString.stringWithString("string0");
        NSString string31 = NSString.stringWithString("string1");
        NSString string32 = NSString.stringWithString("string2");
        NSString string33 = NSString.stringWithString("string3");
        NSString string34 = NSString.stringWithString("string4");

        NSMutableArray array9 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string30, string31, string32, string33, string34}), 5);
        array9.removeAllObjects();
        assertTrue (array9.count() == 0) ;
    }

    @Test
    public void testRemoveLastObject1() {
        NSString string35 = NSString.stringWithString("string0");
        NSString string36 = NSString.stringWithString("string1");
        NSString string37 = NSString.stringWithString("string2");
        NSString string38 = NSString.stringWithString("string3");
        NSString string39 = NSString.stringWithString("string4");

        NSMutableArray array10 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string35, string36, string37, string38, string39}), 5);
        long nroItems = array10.count();
        array10.removeLastObject();
        assertEquals ( nroItems-1, array10.count()); 
        assertEquals( string38.toString(), array10.objectAtIndex(array10.count()-1) );
    }

    @Test
    public void testRemoveObject_inRange1() {
        NSString string40 = NSString.stringWithString("string0");
        NSString string42 = NSString.stringWithString("string2");
        NSString string44 = NSString.stringWithString("string4");

        NSMutableArray array11 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string40, string42, string42, string42, string44}), 5);
        long nroItems = array11.count();
        NSRange range = Foundation.NSMakeRange(1, 2);
        array11.removeObjectInRange(string42, range);
        assertTrue (array11.count() == nroItems-2) ;
    }

    @Test
    public void testRemoveObjectsInArray1() {
        NSString string45 = NSString.stringWithString("string0");
        NSString string46 = NSString.stringWithString("string1");
        NSString string47 = NSString.stringWithString("string2");
        NSString string49 = NSString.stringWithString("string4");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string47, string46}), 2);
        NSMutableArray array12 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string45, string47, string46, string47, string49}), 5);
        long nroItems = array12.count();
        array12.removeObjectsInArray(array5);
        assertTrue (array12.count() == nroItems-3) ;
    }

    @Test
    public void testReplaceObjectsInRange_withObjectsFromArray_range1() {
        NSString string50 = NSString.stringWithString("string0");
        NSString string51 = NSString.stringWithString("string1");
        NSString string52 = NSString.stringWithString("string2");
        NSString string53 = NSString.stringWithString("string3");
        NSString string54 = NSString.stringWithString("string4");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string51, string52}), 2);
        NSMutableArray array13 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string50, string51, string52, string53, string54}), 5);
        String stringOrig = (String)array13.objectAtIndex(3);
        long nroItems = array13.count();
        NSRange rangeOrig = Foundation.NSMakeRange(1, 3);
        NSRange rangeArr = Foundation.NSMakeRange(0, 2);
        array13.replaceObjectsInRangeWithObjectsFromArrayRange(rangeOrig, array5, rangeArr);
        String stringNew = (String)array13.objectAtIndex(3);
        assertTrue(array13.count() == nroItems - 1 && !stringOrig.equals(stringNew)
                        && array13.objectAtIndex(1).equals(array5.objectAtIndex(0))
                        && array13.objectAtIndex(2).equals(array5.objectAtIndex(1))
        );
    }

    @Test
    public void testReplaceObjectsInRange_withObjectsFromArray_range2() {
        NSString string55 = NSString.stringWithString("string0");
        NSString string56 = NSString.stringWithString("string1");
        NSString string57 = NSString.stringWithString("string2");
        NSString string58 = NSString.stringWithString("string3");
        NSString string59 = NSString.stringWithString("string4");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string56, string57}), 2);
        NSMutableArray array14 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string55, string56, string57, string58, string59}), 5);
        String stringOrig = (String)array14.objectAtIndex(1);
        long nroItems = array14.count();
        NSRange rangeOrig = Foundation.NSMakeRange(1, 1);
        NSRange rangeArr = Foundation.NSMakeRange(0, 2);
        array14.replaceObjectsInRangeWithObjectsFromArrayRange(rangeOrig, array5, rangeArr);
        String stringNew = (String)array14.objectAtIndex(1);
        assertEquals( nroItems + 1, array14.count());
        assertEquals( stringOrig , stringNew);
        assertEquals( array14.objectAtIndex(2) , array5.objectAtIndex(1));
    }

    @Test
    public void testReplaceObjectsInRange_withObjectsFromArray1() {
        NSString string60 = NSString.stringWithString("string0");
        NSString string61 = NSString.stringWithString("string1");
        NSString string62 = NSString.stringWithString("string2");
        NSString string63 = NSString.stringWithString("string3");
        NSString string64 = NSString.stringWithString("string4");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string61, string62}), 2);
        NSMutableArray array15 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string60, string61, string62, string63, string64}), 5);
        String stringOrig = (String)array15.objectAtIndex(2);
        long nroItems = array15.count();
        NSRange rangeOrig = Foundation.NSMakeRange(1, 3);
        array15.replaceObjectsInRangeWithObjectsFromArray(rangeOrig, array5);
        String stringNew = (String)array15.objectAtIndex(2);
        assertTrue(array15.count() == nroItems - 1 && stringOrig.equals(stringNew)
                        && array15.objectAtIndex(1).equals(array5.objectAtIndex(0))
                        && array15.objectAtIndex(2).equals(array5.objectAtIndex(1))
        ) ;
    }

    @Test
    public void testReplaceObjectsInRange_withObjectsFromArray2() {
        NSString string65 = NSString.stringWithString("string0");
        NSString string66 = NSString.stringWithString("string1");
        NSString string67 = NSString.stringWithString("string2");
        NSString string68 = NSString.stringWithString("string3");
        NSString string69 = NSString.stringWithString("string4");

        NSMutableArray array16 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string65, string66, string67, string68, string69}), 5);
        NSMutableArray array17 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string65, string66, string67, string68}), 4);
        String stringOrig = (String)array16.objectAtIndex(2);
        long nroItems = array16.count();
        NSRange rangeOrig = Foundation.NSMakeRange(1, 3);
        array16.replaceObjectsInRangeWithObjectsFromArray(rangeOrig, array17);
        String stringNew = (String)array16.objectAtIndex(2);
        assertTrue(array16.count() == nroItems + 1 && !stringOrig.equals(stringNew)
                        && array16.objectAtIndex(1).equals(array17.objectAtIndex(0))
                        && array16.objectAtIndex(2).equals(array17.objectAtIndex(1))
        );
    }

    @Test
    public void testSortUsingFunction_context1() {
        NSString a = NSString.stringWithString("1");
        NSString b = NSString.stringWithString("2");
        NSString c = NSString.stringWithString("3");
        NSString d = NSString.stringWithString("4");
        NSString e = NSString.stringWithString("5");
        NSMutableArray array18 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {a, c, d, b, e}), 5);
        String stringOrig = (String) array18.objectAtIndex(1);
        NSArray newArr = array18.sortedArrayUsingFunctionContext(new NSArray.Function_sortedArrayUsingFunctionContext() {
            @Selector("call_sortedArrayUsingFunction:Context:")
            public long call_sortedArrayUsingFunctionContext(Object a, Object b, VoidPtr ctx) {
                int v1 = NSString.stringWithString((String)a).intValue();
                int v2 = NSString.stringWithString((String)b).intValue();
                if (v1 < v2) {
                    return NSComparisonResult.Ascending;
                } else if (v1 > v2) {
                    return NSComparisonResult.Descending;
                } else {
                    return NSComparisonResult.Same;
                }
            }
        }, null);
        String stringNew = (String)newArr.objectAtIndex(1);
        assertNotEquals( stringNew, stringOrig);
        assertEquals( stringOrig, newArr.objectAtIndex(2));
    }

    @Test
    public void testSortUsingSelector1() throws NoSuchMethodException {
        TestObject newObjectA = TestObject.alloc().init();
        newObjectA.field = NSString.stringWithString("A");
        TestObject newObjectB = TestObject.alloc().init();
        newObjectB.field = NSString.stringWithString("B");
        TestObject newObjectC = TestObject.alloc().init();
        newObjectC.field = NSString.stringWithString("C");
        TestObject newObjectD = TestObject.alloc().init();
        newObjectD.field = NSString.stringWithString("D");

        NSMutableArray array19 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(TestObject.class, new TestObject[] {
                        newObjectA, newObjectB, newObjectC, newObjectD
                }), 4);
        array19.sortedArrayUsingSelector(new SEL("compareFields:"));
        assertTrue (array19.count() == 4 && newObjectA.isEqual(array19.objectAtIndex(0))
                && newObjectB.isEqual(array19.objectAtIndex(1))
                && newObjectC.isEqual(array19.objectAtIndex(2))
                && newObjectD.isEqual(array19.objectAtIndex(3))
        );
    }

    @Test
    public void testRemoveObjectsAtIndexes1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        NSMutableArray array20 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("one"), NSString.stringWithString("a"),
                        NSString.stringWithString("two"), NSString.stringWithString("b"),
                        NSString.stringWithString("three"), NSString.stringWithString("four")
                }), 6);

        String item2 = (String)array20.objectAtIndex(1);
        String item3 = (String)array20.objectAtIndex(2);
        String item4 = (String)array20.objectAtIndex(3);
        String item5 = (String)array20.objectAtIndex(4);

        array20.removeObjectsAtIndexes(set1);

        String newItem2 = (String)array20.objectAtIndex(1);
        String newItem3 = (String)array20.objectAtIndex(2);

        assertTrue(!newItem2.equals(item2) && newItem2.equals(item4) &&
                !newItem3.equals(item3) && newItem3.equals(item5)
        );
    }

    @Test
    public void testReplaceObjectsAtIndexes_withObjects1() {
        NSString string70 = NSString.stringWithString("string0");
        NSString string71 = NSString.stringWithString("string1");
        NSString string72 = NSString.stringWithString("string2");
        NSString string73 = NSString.stringWithString("string3");
        NSString string74 = NSString.stringWithString("string4");

        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        NSMutableArray array21 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string70, string71, string72, string73, string74}), 5);
        NSMutableArray array22 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string74, string73}), 2);
        String item2 = (String)array21.objectAtIndex(1);
        String item3 = (String)array21.objectAtIndex(2);
        String itemReplace0 = (String)array22.objectAtIndex(0);
        String itemReplace1 = (String)array22.objectAtIndex(1);

        array21.replaceObjectsAtIndexesWithObjects(set1, array22);
        String newItem2 = (String)array21.objectAtIndex(1);
        String newItem3 = (String)array21.objectAtIndex(2);

        assertTrue(!newItem2.equals(item2) && newItem2.equals(itemReplace0)
                && !newItem3.equals(item3) && newItem3.equals(itemReplace1));
    }

    @Test
    public void testInsertObjects_atIndexes1() {
        NSString string75 = NSString.stringWithString("string0");
        NSString string76 = NSString.stringWithString("string1");
        NSString string77 = NSString.stringWithString("string2");
        NSString string78 = NSString.stringWithString("string3");
        NSString string79 = NSString.stringWithString("string4");

        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        NSMutableArray array23 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string75, string76, string77, string78, string79}), 5);
        NSMutableArray array24 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string79, string78}), 2);
        String item2 = (String)array23.objectAtIndex(1);
        String item3 = (String)array23.objectAtIndex(2);
        String itemReplace0 = (String)array24.objectAtIndex(0);
        String itemReplace1 = (String)array24.objectAtIndex(1);
        long nroItems = array23.count();

        array23.insertObjectsAtIndexes(array24, set1);

        String newItem2 = (String)array23.objectAtIndex(1);
        String newItem3 = (String)array23.objectAtIndex(2);

        long newNroItems = array23.count();
        assertTrue(newNroItems == nroItems + 2 && !newItem2.equals(item2)
                        && newItem2.equals(itemReplace0) && !newItem3.equals(item3)
                        && newItem3.equals(itemReplace1) && item2.equals((String)array23.objectAtIndex(3))
                        && item3.equals((String) array23.objectAtIndex(4))
        );
    }

    @Test
    public void testExchangeObjectAtIndex_withObjectAtIndex1() {
        NSString string80 = NSString.stringWithString("string0");
        NSString string81 = NSString.stringWithString("string1");
        NSString string82 = NSString.stringWithString("string2");
        NSString string83 = NSString.stringWithString("string3");
        NSString string84 = NSString.stringWithString("string4");
        NSMutableArray array25 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string80, string81, string82, string83, string84}), 5);
        String item1 = (String)array25.objectAtIndex(1);
        String item4 = (String)array25.objectAtIndex(4);

        array25.exchangeObjectAtIndexWithObjectAtIndex(1, 4);

        String newItem1 = (String)array25.objectAtIndex(1);
        String newItem4 = (String)array25.objectAtIndex(4);

        assertTrue (!newItem1.equals(item1) && newItem1.equals(item4)
                && !newItem4.equals(item4) && newItem4.equals(item1)
        );
    }

    @Test
    public void testArray1() {
        NSMutableArray  array0 = (NSMutableArray)NSMutableArray.array();
        assertTrue(array0 != null && array0.count() == 0) ;
    }

    //TODO: varargs
    /*
    @Test
    public void testArrayWithObjects1() {
        NSString string3 = NSString.stringWithString("string0");
        NSString string4 = NSString.stringWithString("string1");
        NSString string5 = NSString.stringWithString("string2");

        NSMutableArray  array1 = (NSMutableArray)NSMutableArray.arrayWithObjects(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string3, string4, string5}));
        NSMutableArray emptyArray = (NSMutableArray)NSMutableArray.array();
        assertTrue(array1.count() == 3 && emptyArray.count() == 0) ;
    }

    @Test
    public void testInitWithObjects1() {
        NSString string6 = NSString.stringWithString("string0");
        NSString string7 = NSString.stringWithString("string1");
        NSString string8 = NSString.stringWithString("string2");
        NSMutableArray array2 = NSMutableArray.alloc().initWithObjects(string6, string7, string8);
        assertTrue(array2.count() == 3);
    }
    */

    @Test
    public void testArrayWithArray1() {
        NSMutableArray anArray0 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("A"), NSString.stringWithString("B")
                }), 2);
        NSMutableArray anArray1 = (NSMutableArray)NSMutableArray.arrayWithArray(anArray0);
        assertTrue (anArray1.count() == 2 && anArray1.objectAtIndex(0).equals(anArray0.objectAtIndex(0))
                && anArray1.objectAtIndex(1).equals(anArray0.objectAtIndex(1))
        );
    }

    @Test
    public void testInitWithArray1() {
        NSMutableArray anArray2 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("A"), NSString.stringWithString("B")
                }), 2);
        NSMutableArray anArray3 = (NSMutableArray)NSMutableArray.alloc().initWithArray(anArray2);
        assertTrue (anArray3.count() == 2 && anArray2.objectAtIndex(0).equals(anArray3.objectAtIndex(0))
                && anArray2.objectAtIndex(1).equals(anArray3.objectAtIndex(1))
        );
    }

    @Test
    public void testArrayWithObject1() {
        NSString string9 = NSString.stringWithString("string0");

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObject(string9);
        assertTrue (array5.count() == 1) ;
    }

    @Test
    public void testObjectEnumerator1() {
        NSString string10 = NSString.stringWithString("string0");
        NSString string11 = NSString.stringWithString("string1");
        NSString string12 = NSString.stringWithString("string2");
        NSMutableArray array6 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string10, string11, string12}), 3);
        NSEnumerator enumerator0 = array6.objectEnumerator();
        Object anObject;
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
        NSString string13 = NSString.stringWithString("string0");
        NSString string14 = NSString.stringWithString("string1");
        NSString string15 = NSString.stringWithString("string2");
        NSMutableArray array7 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string13, string14, string15}), 3);
        boolean flag0 = array7.containsObject(string14);
        assertTrue (flag0 && array7.containsObject(string14));
    }

    @Test
    public void testLastObject1() {
        NSString string16 = NSString.stringWithString("string0");
        NSString string17 = NSString.stringWithString("string1");
        NSString string18 = NSString.stringWithString("string2");
        NSMutableArray array8 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string16, string17, string18}), 3);
        assertEquals ( string18.toString(), array8.lastObject());
    }

    @Test
    public void testDescription1() {
        NSString objectToInitArray = NSString.stringWithString("asdf");
        NSMutableArray array11 = (NSMutableArray)NSMutableArray.arrayWithObject(objectToInitArray);
        NSString description = NSString.stringWithString(array11.description());
        NSString description2 = NSString.stringWithString("(\n    asdf\n)");
        assertTrue (description.isEqualToString(description2.toString()));
    }

    @Test
    public void testObjectAtIndex1() {
        NSString string19 = NSString.stringWithString("string0");
        NSString string20 = NSString.stringWithString("string1");
        NSString string21 = NSString.stringWithString("string2");
        NSMutableArray array12 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string19, string20, string21}), 3);
        assertEquals ( string21.toString(), array12.objectAtIndex(2));
    }

    @Test
    public void testCount1() {
        NSString string22 = NSString.stringWithString("string0");
        NSString string23 = NSString.stringWithString("string1");
        NSString string24 = NSString.stringWithString("string2");
        NSMutableArray array13 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string22, string23, string24}), 3);
        assertTrue (array13.count() == 3);
    }

    @Test
    public void testInit1() {
        NSMutableArray array14 = (NSMutableArray)NSMutableArray.alloc().init();
        assertTrue(array14 != null && array14.count() == 0) ;
    }

    @Test
    public void testIsEqualToArray1() {
        NSMutableArray array15 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("hello"),
                        NSString.stringWithString("food"),
                        NSString.stringWithString("sleep")
                }), 3);
        NSMutableArray array16 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("hello"),
                        NSString.stringWithString("food"),
                        NSString.stringWithString("sleep")
                }), 3);
        NSMutableArray array17 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("hello"),
                        NSString.stringWithString("sleep"),
                        NSString.stringWithString("food")
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
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("hello"),
                        NSString.stringWithString("food"),
                        NSString.stringWithString("sleep")
                }), 3);
        NSMutableArray array21 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("hello"),
                        NSString.stringWithString("food"),
                        NSString.stringWithString("sleep")
                }), 3);
        NSMutableArray array22 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {NSString.stringWithString("hello")}), 1);
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
        Ptr<NSString> strings =PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("strings0obj0"),
                NSString.stringWithString("strings0obj1"),
                NSString.stringWithString("strings0obj2")
        });
        NSMutableArray array25 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(strings, 2);
        assertTrue (array25.count() == 2
                && ((String)array25.objectAtIndex(0)).equals("strings0obj0")
                && ((String)array25.objectAtIndex(1)).equals("strings0obj1"));
    }

    @Test
    public void testInitWithObjects_count1() {
        Ptr strings = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("strings1obj0"),
                NSString.stringWithString("strings1obj1"),
                NSString.stringWithString("strings1obj2")
        });
        NSMutableArray array26 = (NSMutableArray)NSMutableArray.alloc().initWithObjectsCount((ConstPtr)strings, 2);
        assertTrue (array26.count() == 2
                && ((String)array26.objectAtIndex(0)).equals("strings1obj0")
                && ((String)array26.objectAtIndex(1)).equals("strings1obj1")
        );
    }

    @Test
    public void testIndexOfObject1() {
        NSString string25 = NSString.stringWithString("string3");
        NSString string26 = NSString.stringWithString("string4");
        NSString string27 = NSString.stringWithString("string5");
        NSString string28 = NSString.stringWithString("string6");
        NSMutableArray array27 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {string25, string26, string27}), 3);
        assertTrue (array27.indexOfObject(string25) == 0
                && array27.indexOfObject(NSString.stringWithString("string4")) == 1
                && array27.indexOfObject(string28) == Foundation.NSNotFound
        );
    }

    @Test
    public void testArrayByAddingObject1() {
        NSMutableArray array28 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("0"),
                        NSString.stringWithString("1")
                }), 2);
        NSMutableArray array29 = NSMutableArray.arrayWithArray(array28.arrayByAddingObject(NSString.stringWithString("2")));
        assertTrue (array29.count() == 3 && array29.objectAtIndex(2).equals("2"));
    }

    @Test
    public void testArrayByAddingObjectsFromArray1() {
        NSMutableArray array30 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("0"),
                        NSString.stringWithString("1")
                }), 2);
        NSMutableArray array31 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("A"),
                        NSString.stringWithString("B")
                }), 2);
        NSArray array32 = array30.arrayByAddingObjectsFromArray(array31);
        assertEquals ( 4, array32.count());
        assertEquals(array32.objectAtIndex(0), "0");
        assertEquals(array32.objectAtIndex(1), "1");
        assertEquals(array32.objectAtIndex(2), "A");
        assertEquals(array32.objectAtIndex(3), "B");
    }

}
