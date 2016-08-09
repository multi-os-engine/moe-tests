package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;

import ios.foundation.NSArray;
import ios.foundation.NSCountedSet;
import ios.foundation.NSEnumerator;
import ios.NSObject;
import ios.foundation.NSSet;
import ios.foundation.NSString;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSCountedSetTests extends XOSTest{

    @Test
    public void testInitWithCapacity() {
        NSCountedSet countedSet = NSCountedSet.alloc().initWithCapacity(3);
        assertTrue(countedSet != null);
    }

    @Test
    public void testInitWithArray() {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[]{
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("two")
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);

        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        assertTrue(countedSet != null && countedSet.count() == 2);
    }

    @Test
    public void testCountForObject1() {
        NSString string1 = NSString.stringWithString("two");
        NSString string2 = NSString.stringWithString("three");
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                string1, string2, string1
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);

        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        long count = countedSet.countForObject(string1);
        assertTrue(count == 2);
    }

    @Test
    public void testAddObject() {
        NSString string0 = NSString.stringWithString("one");
        NSString string1 = NSString.stringWithString("two");
        NSString string2 = NSString.stringWithString("three");
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                string1, string2, string1
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        countedSet.addObject(string0);
        assertTrue(countedSet != null && countedSet.count() == 3);
    }

    @Test
    public void testCountForObject2() {
        NSString string0 = NSString.stringWithString("one");
        NSString string1 = NSString.stringWithString("two");
        NSString string2 = NSString.stringWithString("three");
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                string1, string2, string1
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        countedSet.addObject(string0);
        assertTrue(countedSet.countForObject(string0) == 1);
    }

    @Test
    public void testCountForObject3() {
        NSString string0 = NSString.stringWithString("one");
        NSString string1 = NSString.stringWithString("two");
        NSString string2 = NSString.stringWithString("three");
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
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
        NSString string0 = NSString.stringWithString("one");
        NSString string1 = NSString.stringWithString("two");
        NSString string2 = NSString.stringWithString("three");
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
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
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("three")
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 4);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        NSEnumerator enumerator = countedSet.objectEnumerator();
        long count = enumerator.allObjects().count();
        assertTrue(count == 3);
    }

    @Test
    public void testRemoveAllObjects() {
        NSString param1 = NSString.stringWithString("one");
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                param1,
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("three")
        });
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 4);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithArray(array);
        countedSet.removeAllObjects();
        assertTrue(countedSet.count() == 0 && countedSet.countForObject(param1) == 0);
    }

    @Test
    public void testAddObjectsFromArray() {
        NSCountedSet countedSet = NSCountedSet.alloc().initWithCapacity(4);
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("three")
        });
        NSArray anArray = NSArray.arrayWithObjectsCount(arr, 4);
        countedSet.addObjectsFromArray(anArray);
        assertTrue(countedSet.count() == 3 && countedSet.countForObject(NSString.stringWithString("three")) == 2);
    }

    @Test
    public void testInitWithSet() {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        });
        NSSet setObjects = NSSet.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = NSCountedSet.alloc().initWithSet(setObjects);
        assertTrue(!countedSet.isEqualToSet(null) && !setObjects.isEqualToSet(null)
                && countedSet.count() == 3 );
    }

    @Test
    public void testSetWithObject() {
        NSString obj = NSString.stringWithString("one");
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.setWithObject(obj);
        assertTrue(!countedSet.isEqualToSet(null) && countedSet.count() == 1);
    }

    @Test
    public void testSetWithSet() {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        });
        NSSet setObjects = NSSet.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.setWithSet(setObjects) ;
        assertTrue(!setObjects.isEqualToSet(null) && !countedSet.isEqualToSet(null)
                && countedSet.count() == 3);
    }

    @Test
    public void testDescription() {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"),
                NSString.stringWithString("two")
        });
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.alloc().initWithObjectsCount(arr, 2);
        NSString strDesc1 = NSString.stringWithString("{(\n    one,\n    two\n)}");
        NSString strDesc2 = NSString.stringWithString("{(\n    two,\n    one\n)}");
        assertTrue(!countedSet.isEqualToSet(null) && (strDesc1.isEqualToString(countedSet.description())
                || strDesc2.isEqualToString(countedSet.description())));
    }

    @Test
    public void testSet() {
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.set();
        assertTrue(countedSet != null && countedSet.count() == 0);
    }

    @Test
    public void testSetByAddingObjectsFromSet() {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        });
        Ptr arr2 = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("four"),
                NSString.stringWithString("five"),
                NSString.stringWithString("three")
        });
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.alloc().initWithObjectsCount(arr, 3);
        NSCountedSet countedSet1 = (NSCountedSet)NSCountedSet.alloc().initWithObjectsCount(arr2, 3);

        NSSet set = countedSet.setByAddingObjectsFromSet(countedSet1);
        assertTrue(!set.isEqualToSet(null) && set.count() == 5);
    }

    @Test
    public void testSetByAddingObjectsFromArray() {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        });
        Ptr arr2 = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("four"),
                NSString.stringWithString("five"),
                NSString.stringWithString("six"),
                NSString.stringWithString("six")
        });
        NSCountedSet countedSet = (NSCountedSet)NSCountedSet.alloc().initWithObjectsCount(arr, 3);
        NSArray objects = NSArray.alloc().initWithObjectsCount(arr2, 4);

        NSSet set = countedSet.setByAddingObjectsFromArray(objects);
        assertTrue(!set.isEqualToSet(null) && set.count() == 6);
    }
}
