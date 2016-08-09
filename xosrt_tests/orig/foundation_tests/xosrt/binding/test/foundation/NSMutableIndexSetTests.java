package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSMutableIndexSetTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testAddIndex1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableIndexSet  indexSet = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);
        long nroItemsOrig = indexSet.getCount();

        indexSet.addIndex(3);
        long newNroItems = indexSet.getCount();

        assertTrue(newNroItems == nroItemsOrig + 1);
    }

    @Test
    public void testAddIndexes1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableArray array = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("a"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("b"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four")
                }), 6
        );
        NSMutableIndexSet  indexSet2 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);

        NSString item4 = (NSString)array.objectAtIndex(3);
        NSString item5 = (NSString)array.objectAtIndex(4);
        NSString item6 = (NSString)array.objectAtIndex(5);

        array.removeObjectsAtIndexes(indexSet2);

        NSString newItem2 = (NSString)array.objectAtIndex(1);
        NSString newItem3 = (NSString)array.objectAtIndex(2);

        NSMutableArray array2 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("a"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("b"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four")
                }), 6
        );
        NSRange aRangeAux = Foundation.NSMakeRange(3, 2);
        NSMutableIndexSet  indexSet3 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRangeAux);
        indexSet2.addIndexes(indexSet3);

        array2.removeObjectsAtIndexes(indexSet2);

        NSString newItem1Aux = (NSString)array2.objectAtIndex(1);

        assertTrue(newItem2.isEqual(item4) && newItem3.isEqual(item5) && newItem1Aux.isEqualToString(item6));
    }

    @Test
    public void testRemoveIndex1() {
        NSRange aRange1 = Foundation.NSMakeRange(0, 2);
        NSMutableIndexSet  indexSet4 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange1);
        long nroItemsOrig = indexSet4.getCount();
        NSMutableArray array3 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("item0"),
                        NSString.fromJavaString("item1"),
                        NSString.fromJavaString("item2"),
                        NSString.fromJavaString("item3"),
                        NSString.fromJavaString("item4")
                }), 5
        );
        long nroArrayOrig = array3.getCount();
        NSString item0 = (NSString)array3.objectAtIndex(0);
        NSString item2 = (NSString)array3.objectAtIndex(2);
        NSString item4 = (NSString)array3.objectAtIndex(4);

        array3.removeObjectsAtIndexes(indexSet4);
        long nroArray = array3.getCount();

        NSMutableArray array4 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("item0"),
                        NSString.fromJavaString("item1"),
                        NSString.fromJavaString("item2"),
                        NSString.fromJavaString("item3"),
                        NSString.fromJavaString("item4")
                }), 5
        );
        indexSet4.removeIndex(0);
        array4.removeObjectsAtIndexes(indexSet4);
        long nroArrayAux = array4.getCount();

        assertTrue (((NSString)array3.objectAtIndex(0)).isEqualToString(item2) && nroArrayOrig == nroArray + 2
                && ((NSString)array4.objectAtIndex(0)).isEqualToString(item0)
                && ((NSString)array4.objectAtIndex(1)).isEqualToString(item2)
                && nroArrayOrig == nroArrayAux + 1
        );
    }

    @Test
    public void testRemoveIndex2() {
        NSRange aRange1 = Foundation.NSMakeRange(0, 2);
        NSMutableIndexSet  indexSet5 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange1);
        long nroSet1 = indexSet5.getCount();
        indexSet5.removeIndex(1);
        long newNroSet1 = indexSet5.getCount();

        NSMutableIndexSet  indexSet6 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange1);
        long nroSet2 = indexSet6.getCount();
        indexSet6.removeIndex(2);
        long newNroSet2 = indexSet6.getCount();

        assertTrue (nroSet1 == newNroSet1 + 1 && nroSet2 == newNroSet2);
    }

    @Test
    public void testRemoveIndexes1() {
        NSRange aRange2 = Foundation.NSMakeRange(0, 3);
        NSMutableIndexSet  indexSet7 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange2);
        long nroSet1 = indexSet7.getCount();

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("item0"),
                        NSString.fromJavaString("item1"),
                        NSString.fromJavaString("item2"),
                        NSString.fromJavaString("item3"),
                        NSString.fromJavaString("item4")
                }), 5
        );

        NSString item3 = (NSString)array5.objectAtIndex(3);
        array5.removeObjectsAtIndexes(indexSet7);
        NSString newItem0 = (NSString)array5.objectAtIndex(0);

        NSMutableIndexSet  indexSet8 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndex(1);
        indexSet7.removeIndexes(indexSet8);
        long newNroSet1 = indexSet7.getCount();

        NSMutableArray array6 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("item0"),
                        NSString.fromJavaString("item1"),
                        NSString.fromJavaString("item2"),
                        NSString.fromJavaString("item3"),
                        NSString.fromJavaString("item4")
                }), 5
        );
        NSString item1 = (NSString)array6.objectAtIndex(1);
        NSString itemAux3 = (NSString)array6.objectAtIndex(3);
        array6.removeObjectsAtIndexes(indexSet7);
        NSString newItemAux0 = (NSString)array6.objectAtIndex(0);
        NSString newItemAux1 = (NSString)array6.objectAtIndex(1);

        assertTrue (nroSet1 == newNroSet1 + 1 && item3.isEqualToString(newItem0)
                && itemAux3.isEqualToString(newItemAux1) && item1.isEqualToString(newItemAux0));
    }

    @Test
    public void testRemoveIndexes2() {
        NSRange aRange2 = Foundation.NSMakeRange(0, 3);
        NSMutableIndexSet  indexSet9 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange2);
        long nroIndexes = indexSet9.getCount();
        NSRange range3 = Foundation.NSMakeRange(2,3);
        NSMutableIndexSet  indexSet10 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(range3);
        indexSet9.removeIndexes(indexSet10);
        long newNroIndexes = indexSet9.getCount();

        assertTrue (nroIndexes == newNroIndexes + 1);
    }

    @Test
    public void testRemoveAllIndexes1() {
        NSRange aRange2 = Foundation.NSMakeRange(0, 3);
        NSMutableIndexSet  indexSet11 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange2);
        long nroIndexes = indexSet11.getCount();

        indexSet11.removeAllIndexes();
        long newNroIndexes = indexSet11.getCount();

        assertTrue (nroIndexes > 0 && newNroIndexes == 0);
    }

    @Test
    public void testCount1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableIndexSet  set1 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);
        assertTrue(2 == set1.getCount());
    }

    @Test
    public void testInitWithIndexesInRange1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableArray array = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("a"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("b"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four")
                }), 6
        );
        NSMutableIndexSet  set2 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);
        NSString item2 = (NSString)array.objectAtIndex(1);
        NSString item3 = (NSString)array.objectAtIndex(2);
        NSString item4 = (NSString)array.objectAtIndex(3);
        NSString item5 = (NSString)array.objectAtIndex(4);

        array.removeObjectsAtIndexes(set2);

        NSString newItem2 = (NSString)array.objectAtIndex(1);
        NSString newItem3 = (NSString)array.objectAtIndex(2);

        assertTrue(!newItem2.isEqual(item2) && newItem2.isEqual(item4)
                && !newItem3.isEqual(item3) && newItem3.isEqual(item5));
    }

    @Test
    public void testIndexSet1() {
        NSMutableIndexSet set3 = (NSMutableIndexSet)NSMutableIndexSet.indexSet();
        assertTrue (set3 != null && set3.getCount() == 0) ;
    }

    @Test
    public void testIsEqualToIndexSet1() {
        NSRange aRange1 = Foundation.NSMakeRange(0, 2);
        NSRange aRange2 = Foundation.NSMakeRange(0, 2);
        NSRange aRange3 = Foundation.NSMakeRange(1, 3);
        NSMutableIndexSet  set4 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange1);
        NSMutableIndexSet  set5 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange2);
        NSMutableIndexSet  set6 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange3);
        NSMutableIndexSet  set7 = (NSMutableIndexSet)NSMutableIndexSet.indexSet();
        assertTrue (set4.isEqualToIndexSet(set5) && !set4.isEqualToIndexSet(set6)
                && !set4.isEqualToIndexSet(set7) && !set5.isEqualToIndexSet(set6)
                && !set6.isEqualToIndexSet(set7) && !set5.isEqualToIndexSet(null)
                && !set5.isEqualToIndexSet(set7)
        );
    }

    @Test
    public void testInitWithIndex1() {
        NSMutableIndexSet indexSet1 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndex(2);
        NSMutableArray array2 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four")
                }), 4
        );
        NSString itemSub2 = (NSString)array2.objectAtIndex(2);
        NSString itemSub3 = (NSString)array2.objectAtIndex(3);
        array2.removeObjectsAtIndexes(indexSet1);
        NSString newItemSub2 = (NSString)array2.objectAtIndex(2);
        assertTrue (1 == indexSet1.getCount() && !itemSub2.isEqualToString(newItemSub2)
                && newItemSub2.isEqualToString(itemSub3));
    }

    @Test
    public void testIndexSetWithIndex1() {
        NSMutableIndexSet indexSet2 = (NSMutableIndexSet)NSMutableIndexSet.indexSetWithIndex(2);
        NSMutableArray array3 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four")
                }), 4
        );
        NSString itemSub2 = (NSString)array3.objectAtIndex(2);
        NSString itemSub3 = (NSString)array3.objectAtIndex(3);
        array3.removeObjectsAtIndexes(indexSet2);
        NSString newItemSub2 = (NSString)array3.objectAtIndex(2);
        assertTrue (1 == indexSet2.getCount() && !itemSub2.isEqualToString(newItemSub2)
                && newItemSub2.isEqualToString(itemSub3)) ;
    }

    @Test
    public void testInitWithIndexSet1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableIndexSet  set1 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);
        NSMutableIndexSet indexSet3 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexSet(set1);
        NSMutableArray array4 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four"),
                        NSString.fromJavaString("five")
                }), 5
        );
        NSString itemSub1 = (NSString)array4.objectAtIndex(1);
        NSString itemSub2 = (NSString)array4.objectAtIndex(2);
        NSString itemSub3 = (NSString)array4.objectAtIndex(3);
        NSString itemSub4 = (NSString)array4.objectAtIndex(4);
        array4.removeObjectsAtIndexes(indexSet3);
        NSString newItemSub1 = (NSString)array4.objectAtIndex(1);
        NSString newItemSub2 = (NSString)array4.objectAtIndex(2);
        assertTrue (2 == indexSet3.getCount() && !itemSub1.isEqualToString(newItemSub1)
                && !itemSub2.isEqualToString(newItemSub2) && newItemSub1.isEqualToString(itemSub3)
                && newItemSub2.isEqualToString(itemSub4));
    }

    @Test
    public void testContainsIndex1() {
        NSRange aRange4 = Foundation.NSMakeRange(1, 3);
        NSMutableIndexSet indexSet4 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange4);
        assertTrue (indexSet4.containsIndex(1) && indexSet4.containsIndex(2)
                && indexSet4.containsIndex(3) && !indexSet4.containsIndex(4));
    }

    @Test
    public void testContainsIndexes1() {
        NSRange aRange5 = Foundation.NSMakeRange(1, 3);
        NSRange aRange6 = Foundation.NSMakeRange(1, 2);
        NSMutableIndexSet  indexSet5 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange5);
        NSMutableIndexSet  indexSet6 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange6);
        NSMutableIndexSet  indexSet7 = (NSMutableIndexSet)NSMutableIndexSet.indexSetWithIndex(1);
        NSMutableIndexSet  indexSet8 = (NSMutableIndexSet)NSMutableIndexSet.indexSetWithIndex(3);
        assertTrue (indexSet5.containsIndexes(indexSet6) && indexSet5.containsIndexes(indexSet7)
                && indexSet6.containsIndexes(indexSet7) && indexSet5.containsIndexes(indexSet8)
                && !indexSet6.containsIndexes(indexSet8) && !indexSet6.containsIndexes(indexSet5));
    }

}
