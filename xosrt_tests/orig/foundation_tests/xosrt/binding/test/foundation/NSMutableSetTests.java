package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.*;
import xosrt.binding.test.foundation.Utils.TestObject;
import org.junit.Test;

public class NSMutableSetTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInitWithCapacity1() {
        NSMutableSet  mySet = NSMutableSet.alloc().initWithCapacity(3);
        assertTrue (mySet != null) ;
    }

    @Test
    public void testAddObject1() {
        NSMutableSet  mySet2 = NSMutableSet.alloc().initWithCapacity(3);
        mySet2.addObject(NSString.fromJavaString("one"));
        mySet2.addObject(NSString.fromJavaString("two"));
        mySet2.addObject(NSString.fromJavaString("three"));

        assertTrue (mySet2.getCount()== 3) ;
    }

    @Test
    public void testCount1() {
        NSMutableSet  mySet3 = NSMutableSet.alloc().initWithCapacity(3);
        mySet3.addObject(NSString.fromJavaString("one"));
        mySet3.addObject(NSString.fromJavaString("two"));
        mySet3.addObject(NSString.fromJavaString("three"));
        assertTrue(3 == mySet3.getCount());
    }

    @Test
    public void testRemoveObject1() {
        NSMutableSet  mySet4 = NSMutableSet.alloc().initWithCapacity(3);
        mySet4.addObject(NSString.fromJavaString("one"));
        mySet4.addObject(NSString.fromJavaString("two"));
        mySet4.addObject(NSString.fromJavaString("three"));
        mySet4.removeObject(NSString.fromJavaString("three"));
        assertTrue (mySet4.getCount()== 2) ;
    }

    @Test
    public void testRemoveAllObjects1() {
        NSMutableSet  mySet5 = NSMutableSet.alloc().initWithCapacity(3);
        mySet5.addObject(NSString.fromJavaString("one"));
        mySet5.addObject(NSString.fromJavaString("two"));
        mySet5.addObject(NSString.fromJavaString("three"));
        mySet5.removeAllObjects();
        assertTrue (mySet5.getCount()== 0) ;
    }

    @Test
    public void testAddObjectsFromArray1() {
        NSMutableSet  mySet6 = NSMutableSet.alloc().initWithCapacity(4);
        NSArray  anArray = NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("three")
            }), 4
        );
        mySet6.addObjectsFromArray(anArray);
        assertTrue (mySet6.getCount()== 3) ;
    }

    @Test
    public void testSetWithCapacity1() {
        NSMutableSet set1 = NSMutableSet.setWithCapacity(3);
        set1.addObject(NSString.fromJavaString("one"));
        set1.addObject(NSString.fromJavaString("two"));
        set1.addObject(NSString.fromJavaString("three"));
        assertTrue (set1.getCount() == 3) ;
    }

    @Test
    public void testInitWithObjects1() {
        NSMutableSet set1 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two")
                }), 2);
        assertTrue(!set1.isEqualToSet(null) && 2 == set1.getCount());
    }

    @Test
    public void testInitWithObjects2() {
        NSString string0 = NSString.fromJavaString("string0");
        NSString string1 = NSString.fromJavaString("string1");
        NSString string2 = NSString.fromJavaString("string2");
        NSMutableSet set2 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {string0, string1, string2, string1}), 4);
        assertTrue(!set2.isEqualToSet(null) && 3 == set2.getCount());
    }

    @Test
    public void testAllObjects1() {
        NSMutableSet set3 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 3);
        NSArray arr = set3.getAllObjects();
        assertTrue (!set3.isEqualToSet(null) && arr != null && arr.getCount() == 3) ;
    }

    @Test
    public void testAnyObject1() {
        NSMutableSet set4 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two")
                }), 2);
        NSMutableSet set5 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{}), 0);
        NSString obj0 = (NSString) set4.anyObject();
        NSString obj1 = (NSString) set5.anyObject();
        assertTrue((obj0.isEqual(NSString.fromJavaString("one"))
                || obj0.isEqual( NSString.fromJavaString("two"))) && obj1 == null);
    }

    @Test
    public void testIsEqualToSet1() {
        NSMutableSet set10 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two")
                }), 2);
        NSMutableSet set11 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two")
                }), 2);
        NSMutableSet set12 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 2);
        NSMutableSet set13 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {NSString.fromJavaString("one")}), 1);
        NSMutableSet set14 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{}), 0);
        NSMutableSet set15 = null;
        assertTrue (!set10.isEqualToSet(null) && !set11.isEqualToSet(null)
                && !set12.isEqualToSet(null) && !set14.isEqualToSet(null)
                && set10.isEqualToSet(set11) && set11.isEqualToSet(set10)
                && set10.isEqualToSet(set10) && set11.isEqualToSet(set11)
                && !set10.isEqualToSet(set12) && !set11.isEqualToSet(set12)
                && !set10.isEqualToSet(set13) && !set11.isEqualToSet(set14)
                && !set12.isEqualToSet(set15) && !set13.isEqualToSet(null)
        );
    }

    @Test
    public void testIsEqual1() {
        NSMutableSet set20 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two")
                }), 2);
        NSMutableSet set21 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two")
                }), 2);
        NSMutableSet set22 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 2);
        NSMutableSet set23 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{NSString.fromJavaString("one")}), 1);
        NSMutableSet set24 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{}), 0);
        NSMutableSet set25 = null;
        assertTrue(!set20.isEqualToSet(null) && !set21.isEqualToSet(null)
                && !set22.isEqualToSet(null) && !set24.isEqualToSet(null)
                && set20.isEqual(set21) && set21.isEqual(set20)
                && set20.isEqual(set20) && set21.isEqual(set21)
                && !set20.isEqual(set22) && !set21.isEqual(set22)
                && !set20.isEqual(set23) && !set21.isEqual(set24)
                && !set22.isEqual(set25) && !set23.isEqual(null)
        );
    }

    @Test
    public void testInitWithArray1() {
        NSArray objects = NSArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("three")
                }), 4
        );
        NSMutableSet set26 = (NSMutableSet)NSMutableSet.alloc().initWithArray(objects);
        assertTrue (!set26.isEqualToSet(null) && set26.getCount() == 3) ;
    }

    @Test
    public void testMember1() {
        NSMutableSet setObjects1 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 3);
        NSString obj = (NSString)setObjects1.member(NSString.fromJavaString("one"));
        NSObject objNil = setObjects1.member(NSString.fromJavaString("four"));
        assertTrue (!setObjects1.isEqualToSet(null) && obj.isEqualToString(NSString.fromJavaString("one"))
                && objNil == null) ;
    }

    @Test
    public void testSetWithArray1() {
        NSArray objects1 = NSArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four"),
                        NSString.fromJavaString("four")
                }), 5
        );
        NSMutableSet set27 = (NSMutableSet)NSMutableSet.setWithArray(objects1);
        assertTrue (!set27.isEqualToSet(null) && set27.getCount() == 4) ;
    }

    @Test
    public void testInitWithSet1() {
        NSMutableSet setObjects = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 3);
        NSMutableSet set28 = (NSMutableSet)NSMutableSet.alloc().initWithSet(setObjects);
        assertTrue (!set28.isEqualToSet(null) && !setObjects.isEqualToSet(null) &&set28.getCount() == 3 ) ;
    }

    @Test
    public void testSetWithObject1() {
        NSString obj2 = NSString.fromJavaString("one");
        NSMutableSet set29 = (NSMutableSet)NSMutableSet.setWithObject(obj2);
        assertTrue (!set29.isEqualToSet(null) && set29.getCount() == 1) ;
    }

    @Test
    public void testSetWithSet1() {
        NSMutableSet setObjects2 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 3);
        NSMutableSet set30 = (NSMutableSet)NSMutableSet.setWithSet(setObjects2);
        assertTrue (!setObjects2.isEqualToSet(null) && !set30.isEqualToSet(null) && set30.getCount() == 3 ) ;
    }

    @Test
    public void testDescription1() {
        NSMutableSet set31 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two")
                }), 2);
        NSString strDesc1 = NSString.fromJavaString("{(\n    one,\n    two\n)}");
        NSString strDesc2 = NSString.fromJavaString("{(\n    two,\n    one\n)}");
        assertTrue(!set31.isEqualToSet(null) && (set31.getDescription().isEqualToString(strDesc1)
                        || set31.getDescription().isEqualToString(strDesc2))
        );
    }

    @Test
    public void testSet1() {
        NSMutableSet set32 = (NSMutableSet)NSMutableSet.set();
        assertTrue (set32 != null && set32.getCount() == 0) ;
    }

    @Test
    public void testSetByAddingObject1() {
        NSMutableSet setObjects3 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 3);
        NSString newObject = NSString.fromJavaString("four");
        NSSet set33 = setObjects3.setByAddingObject(newObject);
        NSSet set49 = setObjects3.setByAddingObject(NSString.fromJavaString("three"));

        assertTrue (!set33.isEqualToSet(null) && set33.getCount() == 4 && set49.getCount() == 3) ;
    }

    @Test
    public void testSetByAddingObjectsFromSet1() {
        NSMutableSet setObjects4 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 3);
        NSMutableSet setObjects5 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("four"),
                        NSString.fromJavaString("five"),
                        NSString.fromJavaString("three")
                }), 3);

        NSSet set34 = setObjects4.setByAddingObjectsFromSet(setObjects5);
        assertTrue (!set34.isEqualToSet(null) && set34.getCount() == 5) ;
    }

    @Test
    public void testSetByAddingObjectsFromArray1() {
        NSMutableSet setObjects6 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 3);
        NSArray objects2 = NSArray.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("four"),
                        NSString.fromJavaString("five"),
                        NSString.fromJavaString("six"),
                        NSString.fromJavaString("six")
                }), 4);

        NSSet set35 = setObjects6.setByAddingObjectsFromArray(objects2);
        assertTrue (!set35.isEqualToSet(null) && set35.getCount() == 6) ;
    }

    @Test
    public void testObjectEnumerator1() {
        NSMutableSet set36 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 3);
        NSEnumerator enumerator0 = set36.objectEnumerator();
        NSObject anObject;
        int i = 0;
        anObject = enumerator0.nextObject();
        while (anObject != null) {
            i++;
            anObject = enumerator0.nextObject();
        }
        assertTrue (i == 3);
    }

    @Test
    public void testContainsObject1() {
        NSMutableSet set37 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three")
                }), 3);
        NSString obj3 = NSString.fromJavaString("two");
        boolean contains = set37.containsObject(obj3);
        assertTrue (!set37.isEqualToSet(null) && contains && set37.containsObject(obj3)) ;
    }

    @Test
    public void testIsSubsetOfSet1() {
        NSMutableSet set38 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four")
                }), 4);
        NSMutableSet set39 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("three")
                }), 2);

        assertTrue (!set38.isEqualToSet(null) && !set39.isEqualToSet(null) && set39.isSubsetOfSet(set38)) ;
    }

    @Test
    public void testIntersectsSet1() {
        NSMutableSet set40 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four")
                }), 4);
        NSMutableSet set41 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("one")
                }), 2);
        NSMutableSet set42 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("five"),
                        NSString.fromJavaString("six")
                }), 2);
        assertTrue (!set40.isEqualToSet(null) && !set41.isEqualToSet(null)
                && !set42.isEqualToSet(null) && set40.intersectsSet(set41)
                && !set40.intersectsSet(set42)
        );
    }

    @Test
    public void testMakeObjectsPerformSelector1() throws NoSuchMethodException {
        TestObject testObject0 = TestObject.alloc().init();
        TestObject testObject1 = TestObject.alloc().init();
        TestObject testObject2 = TestObject.alloc().init();
        TestObject testObject3 = TestObject.alloc().init();
        testObject0.field = NSString.fromJavaString("testObject0");
        testObject1.field = NSString.fromJavaString("testObject1");
        testObject2.field = NSString.fromJavaString("testObject2");
        testObject3.field = NSString.fromJavaString("testObject3");
        NSMutableSet set43 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new TestObject[] {testObject0, testObject1, testObject2, testObject3}), 4);
        set43.makeObjectsPerformSelector(TestObject.class.getMethod("changeField"));
        assertTrue (!set43.isEqualToSet(null) && testObject0.field.isEqual(NSString.fromJavaString("changed"))
                && testObject1.field.isEqual(NSString.fromJavaString("changed"))
                && testObject2.field.isEqual(NSString.fromJavaString("changed"))
                && testObject3.field.isEqual(NSString.fromJavaString("changed"))
        );
    }

    @Test
    public void testMakeObjectsPerformSelector_withObject1() throws NoSuchMethodException {
        TestObject testObject4 = TestObject.alloc().init();
        TestObject testObject5 = TestObject.alloc().init();
        TestObject testObject6 = TestObject.alloc().init();
        TestObject testObject7 = TestObject.alloc().init();
        NSString aString0 = NSString.fromJavaString("changed1");
        testObject4.field = NSString.fromJavaString("testObject4");
        testObject5.field = NSString.fromJavaString("testObject5");
        testObject6.field = NSString.fromJavaString("testObject6");
        testObject7.field = NSString.fromJavaString("testObject7");
        NSMutableSet set44 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new TestObject[] {testObject4, testObject5, testObject6, testObject7}), 4);
        set44.makeObjectsPerformSelectorWithObject(TestObject.class.getMethod("changeField"), aString0);
        assertTrue (!set44.isEqualToSet(null) && testObject4.field.isEqual(NSString.fromJavaString("changed1"))
                && testObject5.field.isEqual(aString0)
                && testObject6.field.isEqual(NSString.fromJavaString("changed1"))
                && testObject7.field.isEqual(NSString.fromJavaString("changed1"))
        );
    }

    @Test
    public void testInitWithObjects_count1() {
        IdArr<NSObject> strings0 = new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("strings0obj0"),
                NSString.fromJavaString("strings0obj1"),
                NSString.fromJavaString("strings0obj2")
        });

        NSMutableSet mySet = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(strings0, 2);
        assertTrue (!mySet.isEqualToSet(null) && mySet.getCount() == 2) ;
    }

    @Test
    public void testSetWithObjects_count1() {
        IdArr<NSObject> strings0 = new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("strings0obj0"),
                NSString.fromJavaString("strings0obj1"),
                NSString.fromJavaString("strings0obj2")
        });
        NSMutableSet mySet = (NSMutableSet)NSMutableSet.setWithObjectsCount(strings0, 2);
        assertTrue (!mySet.isEqualToSet(null) && mySet.getCount() == 2) ;
    }

    @Test
    public void testSetWithObjects1() {
        NSString number = NSString.fromJavaString("a string");
        NSString aValue = NSString.fromJavaString("a string 2");
        NSString aString = NSString.fromJavaString("a string 3");
        NSMutableSet mySet = (NSMutableSet)NSMutableSet.setWithObjectsCount(
                new IdArr<NSObject>(new NSString[] {number, aValue, aString}), 3);
        assertTrue (!mySet.isEqualToSet(null) && mySet.getCount() == 3);
    }

    @Test
    public void testDescriptionWithLocale1() {
        NSMutableSet set46 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("six"),
                        NSString.fromJavaString("four")
                }), 2);
        NSMutableSet set45 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("two")
                }), 2);
        NSString strDesc3 = NSString.fromJavaString("{(\n    three,\n    two\n)}");
        NSString strDesc4 = NSString.fromJavaString("{(\n    two,\n    three\n)}");
        assertTrue (!set46.isEqualToSet(null) && !set45.isEqualToSet(null)
                && (set45.descriptionWithLocale(set46).isEqualToString(strDesc3)
                    || set45.descriptionWithLocale(set46).isEqualToString(strDesc4))
        );
    }

    @Test
    public void testInitWithSet_copyItems1() {
        NSMutableSet setObjects7 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("one"),
                        NSString.fromJavaString("two"),
                        NSString.fromJavaString("three"),
                        NSString.fromJavaString("four")
                }), 4);
        NSMutableSet set48 = (NSMutableSet)NSMutableSet.alloc().initWithSetCopyItems(setObjects7, true);
        assertTrue (!set48.isEqualToSet(null) && !setObjects7.isEqualToSet(null) && set48.getCount() == 4);
    }

}
