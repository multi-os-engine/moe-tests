package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;


import ios.foundation.*;
import ios.foundation.c.Foundation;
import ios.foundation.struct.NSRange;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSIndexSetTests extends XOSTest{

    @Test
    public void testCount1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        assertTrue(2 == set1.count());
    }

    @Test
    public void testInitWithIndexesInRange1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[]{
                NSString.stringWithString("one"), NSString.stringWithString("a"),
                NSString.stringWithString("two"), NSString.stringWithString("b"),
                NSString.stringWithString("three"), NSString.stringWithString("four")
        });
        NSMutableArray array = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(arr, 6);
        NSIndexSet set2 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
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
        NSIndexSet set3 = NSIndexSet.indexSet();
        assertTrue (set3 != null && set3.count() == 0) ;
    }

    @Test
    public void testIsEqualToIndexSet1() {
        NSRange aRange1 = Foundation.NSMakeRange(0, 2);
        NSRange aRange2 = Foundation.NSMakeRange(0, 2);
        NSRange aRange3 = Foundation.NSMakeRange(1, 3);
        NSIndexSet  set4 = NSIndexSet.alloc().initWithIndexesInRange(aRange1);
        NSIndexSet  set5 = NSIndexSet.alloc().initWithIndexesInRange(aRange2);
        NSIndexSet  set6 = NSIndexSet.alloc().initWithIndexesInRange(aRange3);
        NSIndexSet  set7 = NSIndexSet.indexSet();
        assertTrue (set4.isEqualToIndexSet(set5) && !set4.isEqualToIndexSet(set6)
                && !set4.isEqualToIndexSet(set7) && !set5.isEqualToIndexSet(set6)
                && !set6.isEqualToIndexSet(set7) && !set5.isEqualToIndexSet(null)
                && !set5.isEqualToIndexSet(set7)
        );
    }

    @Test
    public void testInitWithIndex1() {
        NSIndexSet indexSet1 = NSIndexSet.alloc().initWithIndex(2);
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"), NSString.stringWithString("two"),
                NSString.stringWithString("three"), NSString.stringWithString("four")
        });
        NSMutableArray array2 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(arr, 4);
        String itemSub2 = (String)array2.objectAtIndex(2);
        String itemSub3 = (String)array2.objectAtIndex(3);
        array2.removeObjectsAtIndexes(indexSet1);
        String newItemSub2 = (String)array2.objectAtIndex(2);
        assertTrue (1 == indexSet1.count() && !itemSub2.equals(newItemSub2)
                && newItemSub2.equals(itemSub3));
    }

    @Test
    public void testIndexSetWithIndex1() {
        NSIndexSet indexSet2 = NSIndexSet.indexSetWithIndex(2);
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"), NSString.stringWithString("two"),
                NSString.stringWithString("three"), NSString.stringWithString("four")
        });
        NSMutableArray array3 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(arr, 4);
        String itemSub2 = (String)array3.objectAtIndex(2);
        String itemSub3 = (String)array3.objectAtIndex(3);
        array3.removeObjectsAtIndexes(indexSet2);
        String newItemSub2 = (String)array3.objectAtIndex(2);
        assertTrue (1 == indexSet2.count() && !itemSub2.equals(newItemSub2.toString())
                && newItemSub2.equals(itemSub3.toString()));
    }

    @Test
    public void testInitWithIndexSet1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        NSIndexSet indexSet3 = NSIndexSet.alloc().initWithIndexSet(set1);
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"), NSString.stringWithString("two"),
                NSString.stringWithString("three"), NSString.stringWithString("four"),
                NSString.stringWithString("five")
        });
        NSMutableArray array4 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(arr, 5);
        String itemSub1 = (String)array4.objectAtIndex(1);
        String itemSub2 = (String)array4.objectAtIndex(2);
        String itemSub3 = (String)array4.objectAtIndex(3);
        String itemSub4 = (String)array4.objectAtIndex(4);
        array4.removeObjectsAtIndexes(indexSet3);
        String newItemSub1 = (String)array4.objectAtIndex(1);
        String newItemSub2 = (String)array4.objectAtIndex(2);
        assertTrue (2 == indexSet3.count() && !itemSub1.equals(newItemSub1)
                && !itemSub2.equals(newItemSub2.toString()) && newItemSub1.equals(itemSub3)
                && newItemSub2.equals(itemSub4));
    }

    @Test
    public void testContainsIndex1() {
        NSRange aRange4 = Foundation.NSMakeRange(1, 3);
        NSIndexSet  indexSet4 = NSIndexSet.alloc().initWithIndexesInRange(aRange4);
        assertTrue (indexSet4.containsIndex(1) && indexSet4.containsIndex(2)
                && indexSet4.containsIndex(3) && !indexSet4.containsIndex(4));
    }

    @Test
    public void testContainsIndexes1() {
        NSRange aRange5 = Foundation.NSMakeRange(1, 3);
        NSRange aRange6 = Foundation.NSMakeRange(1, 2);
        NSIndexSet  indexSet5 = NSIndexSet.alloc().initWithIndexesInRange(aRange5);
        NSIndexSet  indexSet6 = NSIndexSet.alloc().initWithIndexesInRange(aRange6);
        NSIndexSet  indexSet7 = NSIndexSet.indexSetWithIndex(1);
        NSIndexSet  indexSet8 = NSIndexSet.indexSetWithIndex(3);
        assertTrue (indexSet5.containsIndexes(indexSet6) && indexSet5.containsIndexes(indexSet7)
                && indexSet6.containsIndexes(indexSet7) && indexSet5.containsIndexes(indexSet8)
                && !indexSet6.containsIndexes(indexSet8) && !indexSet6.containsIndexes(indexSet5));
    }

}
