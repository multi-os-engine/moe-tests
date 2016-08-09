package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSIndexSetTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testCount1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        assertTrue(2 == set1.getCount());
    }

    @Test
    public void testInitWithIndexesInRange1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"), NSString.fromJavaString("a"),
                NSString.fromJavaString("two"), NSString.fromJavaString("b"),
                NSString.fromJavaString("three"), NSString.fromJavaString("four")
        });
        NSMutableArray array = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(arr, 6);
        NSIndexSet set2 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
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
        NSIndexSet set3 = NSIndexSet.indexSet();
        assertTrue (set3 != null && set3.getCount() == 0) ;
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
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"), NSString.fromJavaString("two"),
                NSString.fromJavaString("three"), NSString.fromJavaString("four")
        });
        NSMutableArray array2 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(arr, 4);
        NSString itemSub2 = (NSString)array2.objectAtIndex(2);
        NSString itemSub3 = (NSString)array2.objectAtIndex(3);
        array2.removeObjectsAtIndexes(indexSet1);
        NSString newItemSub2 = (NSString)array2.objectAtIndex(2);
        assertTrue (1 == indexSet1.getCount() && !itemSub2.isEqualToString(newItemSub2)
                && newItemSub2.isEqualToString(itemSub3));
    }

    @Test
    public void testIndexSetWithIndex1() {
        NSIndexSet indexSet2 = NSIndexSet.indexSetWithIndex(2);
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"), NSString.fromJavaString("two"),
                NSString.fromJavaString("three"), NSString.fromJavaString("four")
        });
        NSMutableArray array3 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(arr, 4);
        NSString itemSub2 = (NSString)array3.objectAtIndex(2);
        NSString itemSub3 = (NSString)array3.objectAtIndex(3);
        array3.removeObjectsAtIndexes(indexSet2);
        NSString newItemSub2 = (NSString)array3.objectAtIndex(2);
        assertTrue (1 == indexSet2.getCount() && !itemSub2.isEqualToString(newItemSub2)
                && newItemSub2.isEqualToString(itemSub3));
    }

    @Test
    public void testInitWithIndexSet1() {
        NSRange aRange = Foundation.NSMakeRange(1, 2);
        NSIndexSet  set1 = NSIndexSet.alloc().initWithIndexesInRange(aRange);
        NSIndexSet indexSet3 = NSIndexSet.alloc().initWithIndexSet(set1);
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"), NSString.fromJavaString("two"),
                NSString.fromJavaString("three"), NSString.fromJavaString("four"),
                NSString.fromJavaString("five")
        });
        NSMutableArray array4 = (NSMutableArray)NSMutableArray.arrayWithObjectsCount(arr, 5);
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
