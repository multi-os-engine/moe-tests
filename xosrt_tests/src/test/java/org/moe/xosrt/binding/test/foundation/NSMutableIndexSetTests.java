package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;


import ios.foundation.*;
import ios.foundation.c.Foundation;
import ios.foundation.struct.NSRange;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Ignore;
import org.junit.Test;

//TODO: causes simulator crush
@Ignore
public class NSMutableIndexSetTests extends XOSTest {

    @Test
    public void testAddIndex1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableIndexSet  indexSet = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);
        long nroItemsOrig = indexSet.count();

        indexSet.addIndex(3);
        long newNroItems = indexSet.count();

        assertTrue(newNroItems == nroItemsOrig + 1);
    }

    @Test
    public void testAddIndexes1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableArray array = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        NSString.stringWithString("one"),
                        NSString.stringWithString("a"),
                        NSString.stringWithString("two"),
                        NSString.stringWithString("b"),
                        NSString.stringWithString("three"),
                        NSString.stringWithString("four")
                }), 6
        );
        NSMutableIndexSet  indexSet2 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);

        String item4 = (String)array.objectAtIndex(3);
        String item5 = (String)array.objectAtIndex(4);
        String item6 = (String)array.objectAtIndex(5);

        array.removeObjectsAtIndexes(indexSet2);

        String newItem2 = (String)array.objectAtIndex(1);
        String newItem3 = (String)array.objectAtIndex(2);

        NSMutableArray array2 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("one"),
                        NSString.stringWithString("a"),
                        NSString.stringWithString("two"),
                        NSString.stringWithString("b"),
                        NSString.stringWithString("three"),
                        NSString.stringWithString("four")
                }), 6
        );
        NSRange aRangeAux = Foundation.NSMakeRange(3, 2);
        NSMutableIndexSet  indexSet3 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRangeAux);
        indexSet2.addIndexes(indexSet3);

        array2.removeObjectsAtIndexes(indexSet2);

        String newItem1Aux = (String)array2.objectAtIndex(1);

        assertTrue(newItem2.equals(item4) && newItem3.equals(item5) && newItem1Aux.equals(item6));
    }

    @Test
    public void testRemoveIndex1() {
        NSRange aRange1 = Foundation.NSMakeRange(0, 2);
        NSMutableIndexSet  indexSet4 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange1);
        NSMutableArray array3 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                		PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("item0"),
                        NSString.stringWithString("item1"),
                        NSString.stringWithString("item2"),
                        NSString.stringWithString("item3"),
                        NSString.stringWithString("item4")
                }), 5 );
        long nroArrayOrig = array3.count();
        String item0 = (String)array3.objectAtIndex(0);
        String item2 = (String)array3.objectAtIndex(2);

        array3.removeObjectsAtIndexes(indexSet4);
        long nroArray = array3.count();

        NSMutableArray array4 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("item0"),
                        NSString.stringWithString("item1"),
                        NSString.stringWithString("item2"),
                        NSString.stringWithString("item3"),
                        NSString.stringWithString("item4")
                }), 5
        );
        indexSet4.removeIndex(0);
        array4.removeObjectsAtIndexes(indexSet4);
        long nroArrayAux = array4.count();

        assertTrue (((String)array3.objectAtIndex(0)).equals(item2.toString()) && nroArrayOrig == nroArray + 2
                && ((String)array4.objectAtIndex(0)).equals(item0.toString())
                && ((String)array4.objectAtIndex(1)).equals(item2.toString())
                && nroArrayOrig == nroArrayAux + 1
        );
    }

    @Test
    public void testRemoveIndex2() {
        NSRange aRange1 = Foundation.NSMakeRange(0, 2);
        NSMutableIndexSet  indexSet5 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange1);
        long nroSet1 = indexSet5.count();
        indexSet5.removeIndex(1);
        long newNroSet1 = indexSet5.count();

        NSMutableIndexSet  indexSet6 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange1);
        long nroSet2 = indexSet6.count();
        indexSet6.removeIndex(2);
        long newNroSet2 = indexSet6.count();

        assertTrue (nroSet1 == newNroSet1 + 1 && nroSet2 == newNroSet2);
    }

    @Test
    public void testRemoveIndexes1() {
        NSRange aRange2 = Foundation.NSMakeRange(0, 3);
        NSMutableIndexSet  indexSet7 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange2);
        long nroSet1 = indexSet7.count();

        NSMutableArray array5 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("item0"),
                        NSString.stringWithString("item1"),
                        NSString.stringWithString("item2"),
                        NSString.stringWithString("item3"),
                        NSString.stringWithString("item4")
                }), 5
        );

        String item3 = (String)array5.objectAtIndex(3);
        array5.removeObjectsAtIndexes(indexSet7);
        String newItem0 = (String)array5.objectAtIndex(0);

        NSMutableIndexSet  indexSet8 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndex(1);
        indexSet7.removeIndexes(indexSet8);
        long newNroSet1 = indexSet7.count();

        NSMutableArray array6 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("item0"),
                        NSString.stringWithString("item1"),
                        NSString.stringWithString("item2"),
                        NSString.stringWithString("item3"),
                        NSString.stringWithString("item4")
                }), 5
        );
        String item1 = (String)array6.objectAtIndex(1);
        String itemAux3 = (String)array6.objectAtIndex(3);
        array6.removeObjectsAtIndexes(indexSet7);
        String newItemAux0 = (String)array6.objectAtIndex(0);
        String newItemAux1 = (String)array6.objectAtIndex(1);

        assertTrue (nroSet1 == newNroSet1 + 1 && item3.equals(newItem0)
                && itemAux3.equals(newItemAux1) && item1.equals(newItemAux0));
    }

    @Test
    public void testRemoveIndexes2() {
        NSRange aRange2 = Foundation.NSMakeRange(0, 3);
        NSMutableIndexSet  indexSet9 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange2);
        long nroIndexes = indexSet9.count();
        NSRange range3 = Foundation.NSMakeRange(2,3);
        NSMutableIndexSet  indexSet10 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(range3);
        indexSet9.removeIndexes(indexSet10);
        long newNroIndexes = indexSet9.count();

        assertTrue (nroIndexes == newNroIndexes + 1);
    }

    @Test
    public void testRemoveAllIndexes1() {
        NSRange aRange2 = Foundation.NSMakeRange(0, 3);
        NSMutableIndexSet  indexSet11 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange2);
        long nroIndexes = indexSet11.count();

        indexSet11.removeAllIndexes();
        long newNroIndexes = indexSet11.count();

        assertTrue (nroIndexes > 0 && newNroIndexes == 0);
    }

    @Test
    public void testCount1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableIndexSet  set1 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);
        assertTrue(2 == set1.count());
    }

    @Test
    public void testInitWithIndexesInRange1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableArray array = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("one"),
                        NSString.stringWithString("a"),
                        NSString.stringWithString("two"),
                        NSString.stringWithString("b"),
                        NSString.stringWithString("three"),
                        NSString.stringWithString("four")
                }), 6
        );
        NSMutableIndexSet  set2 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);
        String item2 = (String)array.objectAtIndex(1);
        String item3 = (String)array.objectAtIndex(2);
        String item4 = (String)array.objectAtIndex(3);
        String item5 = (String)array.objectAtIndex(4);

        array.removeObjectsAtIndexes(set2);

        String newItem2 = (String)array.objectAtIndex(1);
        String newItem3 = (String)array.objectAtIndex(2);

        assertTrue(!newItem2.equals(item2) && newItem2.equals(item4)
                && !newItem3.equals(item3) && newItem3.equals(item5));
    }

    @Test
    public void testIndexSet1() {
        NSMutableIndexSet set3 = (NSMutableIndexSet)NSMutableIndexSet.indexSet();
        assertTrue (set3 != null && set3.count() == 0) ;
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
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("one"),
                        NSString.stringWithString("two"),
                        NSString.stringWithString("three"),
                        NSString.stringWithString("four")
                }), 4
        );
        String itemSub2 = (String)array2.objectAtIndex(2);
        String itemSub3 = (String)array2.objectAtIndex(3);
        array2.removeObjectsAtIndexes(indexSet1);
        String newItemSub2 = (String)array2.objectAtIndex(2);
        assertTrue (1 == indexSet1.count() && !itemSub2.equals(newItemSub2.toString())
                && newItemSub2.equals(itemSub3.toString()));
    }

    @Test
    public void testIndexSetWithIndex1() {
        NSMutableIndexSet indexSet2 = (NSMutableIndexSet)NSMutableIndexSet.indexSetWithIndex(2);
        NSMutableArray array3 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("one"),
                        NSString.stringWithString("two"),
                        NSString.stringWithString("three"),
                        NSString.stringWithString("four")
                }), 4
        );
        String itemSub2 = (String)array3.objectAtIndex(2);
        String itemSub3 = (String)array3.objectAtIndex(3);
        array3.removeObjectsAtIndexes(indexSet2);
        String newItemSub2 = (String)array3.objectAtIndex(2);
        assertTrue (1 == indexSet2.count() && !itemSub2.equals(newItemSub2.toString())
                && newItemSub2.equals(itemSub3.toString())) ;
    }

    @Test
    public void testInitWithIndexSet1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSMutableIndexSet  set1 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexesInRange(aRange);
        NSMutableIndexSet indexSet3 = (NSMutableIndexSet)NSMutableIndexSet.alloc().initWithIndexSet(set1);
        NSMutableArray array4 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("one"),
                        NSString.stringWithString("two"),
                        NSString.stringWithString("three"),
                        NSString.stringWithString("four"),
                        NSString.stringWithString("five")
                }), 5
        );
        String itemSub1 = (String)array4.objectAtIndex(1);
        String itemSub2 = (String)array4.objectAtIndex(2);
        String itemSub3 = (String)array4.objectAtIndex(3);
        String itemSub4 = (String)array4.objectAtIndex(4);
        array4.removeObjectsAtIndexes(indexSet3);
        String newItemSub1 = (String)array4.objectAtIndex(1);
        String newItemSub2 = (String)array4.objectAtIndex(2);
        assertTrue (2 == indexSet3.count() && !itemSub1.equals(newItemSub1.toString())
                && !itemSub2.equals(newItemSub2.toString()) && newItemSub1.equals(itemSub3.toString())
                && newItemSub2.equals(itemSub4.toString()));
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
