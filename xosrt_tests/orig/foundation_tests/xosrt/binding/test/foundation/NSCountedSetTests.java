package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.NSArray;
import xosrt.binding.foundation.NSCountedSet;
import xosrt.binding.foundation.NSEnumerator;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSSet;
import xosrt.binding.foundation.NSString;
import org.junit.Test;

public class NSCountedSetTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInitWithCapacity() {
        NSCountedSet countedSet = NSCountedSet.alloc().initWithCapacity(3);
        assertTrue(countedSet != null);
    }

    @Test
    public void testInitWithArray() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("two")
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);

        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        assertTrue(countedSet != null && countedSet.getCount() == 2);
    }

    @Test
    public void testCountForObject1() {
        NSString string1 = NSString.fromJavaString("two");
        NSString string2 = NSString.fromJavaString("three");
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                string1, string2, string1
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);

        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        long count = countedSet.countForObject(string1);
        assertTrue(count == 2);
    }

    @Test
    public void testAddObject() {
        NSString string0 = NSString.fromJavaString("one");
        NSString string1 = NSString.fromJavaString("two");
        NSString string2 = NSString.fromJavaString("three");
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                string1, string2, string1
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        countedSet.addObject(string0);
        assertTrue(countedSet != null && countedSet.getCount() == 3);
    }

    @Test
    public void testCountForObject2() {
        NSString string0 = NSString.fromJavaString("one");
        NSString string1 = NSString.fromJavaString("two");
        NSString string2 = NSString.fromJavaString("three");
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                string1, string2, string1
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        countedSet.addObject(string0);
        assertTrue(countedSet.countForObject(string0) == 1);
    }

    @Test
    public void testCountForObject3() {
        NSString string0 = NSString.fromJavaString("one");
        NSString string1 = NSString.fromJavaString("two");
        NSString string2 = NSString.fromJavaString("three");
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                string1, string2, string1
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        countedSet.addObject(string0);
        countedSet.addObject(string0);
        assertTrue(countedSet.countForObject(string0) == 2);
    }

    @Test
    public void testRemoveObject() {
        NSString string0 = NSString.fromJavaString("one");
        NSString string1 = NSString.fromJavaString("two");
        NSString string2 = NSString.fromJavaString("three");
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                string1, string2, string1
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        countedSet.addObject(string0);
        countedSet.addObject(string0);
        countedSet.removeObject(string1);
        countedSet.removeObject(string2);
        assertTrue(countedSet.countForObject(string1) == 1 && countedSet.countForObject(string2) == 0);
    }

    @Test
    public void testObjectEnumerator() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("three")
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 4);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        NSEnumerator enumerator = countedSet.objectEnumerator();
        long count = enumerator.getAllObjects().getCount();
        assertTrue(count == 3);
    }

    @Test
    public void testRemoveAllObjects() {
        NSString param1 = NSString.fromJavaString("one");
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                param1,
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("three")
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 4);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        countedSet.removeAllObjects();
        assertTrue(countedSet.getCount() == 0 && countedSet.countForObject(param1) == 0);
    }

    @Test
    public void testAddObjectsFromArray() {
        NSCountedSet countedSet = NSCountedSet.alloc().initWithCapacity(4);
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("three")
        });
        NSArray anArray = NSArray.arrayWithObjectsCount(arr, 4);
        countedSet.addObjectsFromArray(anArray);
        assertTrue(countedSet.getCount() == 3 && countedSet.countForObject(NSString.fromJavaString("three")) == 2);
    }

    @Test
    public void testInitWithSet() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        });
        NSSet setObjects = NSSet.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithSet(setObjects);
        assertTrue(!countedSet.isEqualToSet(null) && !setObjects.isEqualToSet(null)
                && countedSet.getCount() == 3 );
    }

    @Test
    public void testSetWithObject() {
        NSString obj = NSString.fromJavaString("one");
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.setWithObject(obj);
        assertTrue(!countedSet.isEqualToSet(null) && countedSet.getCount() == 1);
    }

    @Test
    public void testSetWithSet() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        });
        NSSet setObjects = NSSet.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.setWithSet(setObjects) ;
        assertTrue(!setObjects.isEqualToSet(null) && !countedSet.isEqualToSet(null)
                && countedSet.getCount() == 3);
    }

    @Test
    public void testDescription() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two")
        });
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.alloc().initWithObjectsCount(arr, 2);
        NSString strDesc1 = NSString.fromJavaString("{(\n    one,\n    two\n)}");
        NSString strDesc2 = NSString.fromJavaString("{(\n    two,\n    one\n)}");
        assertTrue(!countedSet.isEqualToSet(null) && (countedSet.getDescription().isEqualToString(strDesc1)
                || countedSet.getDescription().isEqualToString(strDesc2)));
    }

    @Test
    public void testSet() {
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.set();
        assertTrue(countedSet != null && countedSet.getCount() == 0);
    }

    @Test
    public void testSetByAddingObjectsFromSet() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        });
        IdArr<NSObject> arr2 = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("four"),
                NSString.fromJavaString("five"),
                NSString.fromJavaString("three")
        });
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet1 = (NSCountedSet)NSCountedSet.alloc().initWithObjectsCount(arr2, 3);

        NSSet set = countedSet.setByAddingObjectsFromSet(countedSet1);
        assertTrue(!set.isEqualToSet(null) && set.getCount() == 5);
    }

    @Test
    public void testSetByAddingObjectsFromArray() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        });
        IdArr<NSObject> arr2 = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("four"),
                NSString.fromJavaString("five"),
                NSString.fromJavaString("six"),
                NSString.fromJavaString("six")
        });
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.alloc().initWithObjectsCount(arr, 3);
        NSArray objects = NSArray.alloc().initWithObjectsCount(arr2, 4);

        NSSet set = countedSet.setByAddingObjectsFromArray(objects);
        assertTrue(!set.isEqualToSet(null) && set.getCount() == 6);
    }
}
