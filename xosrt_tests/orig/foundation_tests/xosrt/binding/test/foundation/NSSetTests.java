package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.*;
import xosrt.binding.test.foundation.Utils.TestObject;
import org.junit.Test;

public class NSSetTests {

    static {
        System.loadLibrary("Mac");
    }

    //TODO: varargs
    /*
    @Test
    public void testInitWithObjects1() {
        NSSet  set1 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[] {
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"));
        assertTrue(!set1.isEqualToSet(null) && 2 == set1.getCount());
    }
    */

    @Test
    public void testCount1() {
        NSString string0 = NSString.fromJavaString("string0");
        NSString string1 = NSString.fromJavaString("string1");
        NSString string2 = NSString.fromJavaString("string2");
        NSSet set2 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(
                new NSString[] {string0, string1, string2, string1}), 4);
        assertTrue(!set2.isEqualToSet(null) && 3 == set2.getCount());
    }

    @Test
    public void testAllObjects1() {
        NSSet set3 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 3);
        NSArray arr = set3.getAllObjects();
        assertTrue (!set3.isEqualToSet(null) && arr != null && arr.getCount() == 3);
    }

    @Test
    public void testAnyObject1() {
        NSSet set4 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two")
        }), 2);
        NSSet set5 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{}), 0);
        NSString obj0 = (NSString) set4.anyObject();
        NSString obj1 = (NSString) set5.anyObject();
        assertTrue((obj0.isEqual(NSString.fromJavaString("one"))
                || obj0.isEqual(NSString.fromJavaString("two")))
                && obj1 == null);
    }

    @Test
    public void testIsEqualToSet1() {
        NSSet set10 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two")
        }), 2);
        NSSet set11 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two")
        }), 2);
        NSSet set12 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 2);
        NSSet set13 = NSSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{NSString.fromJavaString("one")}), 1);
        NSSet set14 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[] {}), 0);
        NSSet set15 = null;
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
        NSSet set20 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two")
        }), 2);
        NSSet set21 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two")
        }), 2);
        NSSet set22 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 2);
        NSSet set23 = NSSet.alloc().initWithObjectsCount(
                new IdArr<NSObject>( new NSString[] {NSString.fromJavaString("one")}), 1);
        NSSet set24 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{}), 0);
        NSSet set25 = null;
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
        NSArray objects = NSArray.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("three")
        }), 4);
        NSSet set26 = NSSet.alloc().initWithArray(objects);
        assertTrue (!set26.isEqualToSet(null) && set26.getCount() == 3) ;
    }

    @Test
    public void testMember1() {
        NSSet setObjects1 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
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
        NSArray objects1 = NSArray.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("four"),
                NSString.fromJavaString("four")
        }), 5);
        NSSet set27 = NSSet.setWithArray(objects1);
        assertTrue (!set27.isEqualToSet(null) && set27.getCount() == 4);
    }

    @Test
    public void testInitWithSet1() {
        NSSet setObjects = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 3);
        NSSet set28 = NSSet.alloc().initWithSet(setObjects);
        assertTrue (!set28.isEqualToSet(null) && !setObjects.isEqualToSet(null) &&set28.getCount() == 3 ) ;
    }

    @Test
    public void testSetWithObject1() {
        NSString obj2 = NSString.fromJavaString("one");
        NSSet set29 = NSSet.setWithObject(obj2);
        assertTrue (!set29.isEqualToSet(null) && set29.getCount() == 1) ;
    }

    @Test
    public void testSetWithSet1() {
        NSSet setObjects2 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 3);
        NSSet set30 = NSSet.setWithSet(setObjects2);
        assertTrue (!setObjects2.isEqualToSet(null) && !set30.isEqualToSet(null) && set30.getCount() == 3 ) ;
    }

    @Test
    public void testDescription1() {
        NSSet set31 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two")
        }), 2);
        NSString strDesc1 = NSString.fromJavaString("{(\n    one,\n    two\n)}");
        NSString strDesc2 = NSString.fromJavaString("{(\n    two,\n    one\n)}");
        assertTrue(!set31.isEqualToSet(null) && (set31.getDescription().isEqualToString(strDesc1)
                || set31.getDescription().isEqualToString(strDesc2)));
    }

    @Test
    public void testSet1() {
        NSSet set32 = NSSet.set();
        assertTrue (set32 != null && set32.getCount() == 0);
    }

    @Test
    public void testSetByAddingObject1() {
        NSSet setObjects3 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
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
        NSSet setObjects4 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 3);
        NSSet setObjects5 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("four"),
                NSString.fromJavaString("five"),
                NSString.fromJavaString("three")
        }), 3);

        NSSet set34 = setObjects4.setByAddingObjectsFromSet(setObjects5);
        assertTrue (!set34.isEqualToSet(null) && set34.getCount() == 5) ;
    }

    @Test
    public void testSetByAddingObjectsFromArray1() {
        NSSet setObjects6 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 3);
        NSArray objects2 = NSArray.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
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
        NSSet set36 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
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
        assertTrue (i == 3) ;
    }

    @Test
    public void testContainsObject1() {
        NSSet set37 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three")
        }), 3);
        NSString obj3 = NSString.fromJavaString("two");
        boolean contains = set37.containsObject(obj3);
        assertTrue (!set37.isEqualToSet(null) && contains && set37.containsObject(obj3)) ;
    }

    @Test
    public void testIsSubsetOfSet1() throws NoSuchMethodException {
        NSSet set38 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("four")
        }), 4);
        NSSet set39 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("three")
        }), 2);

        assertTrue (!set38.isEqualToSet(null) && !set39.isEqualToSet(null) && set39.isSubsetOfSet(set38));
    }

    @Test
    public void testIntersectsSet1() {
        NSSet set40 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("four")
        }), 4);
        NSSet set41 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("three"),
                NSString.fromJavaString("one")
        }), 2);
        NSSet set42 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("five"),
                NSString.fromJavaString("six")
        }), 2);
        assertTrue (!set40.isEqualToSet(null) && !set41.isEqualToSet(null)
                && !set42.isEqualToSet(null) && set40.intersectsSet(set41)
                && !set40.intersectsSet(set42));
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
        NSSet set43 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new TestObject[] {
                testObject0, testObject1, testObject2, testObject3 }), 4);
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
        NSSet set44 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(
                new TestObject[] {testObject4, testObject5, testObject6, testObject7 }), 4);
        set44.makeObjectsPerformSelectorWithObject(TestObject.class.getMethod("changeField"), aString0);
        assertTrue (!set44.isEqualToSet(null) && testObject4.field.isEqual(NSString.fromJavaString("changed1"))
                && testObject5.field.isEqual(aString0)
                && testObject6.field.isEqual(NSString.fromJavaString("changed1"))
                && testObject7.field.isEqual(NSString.fromJavaString("changed1"))
        );
    }

    @Test
    public void testInitWithObjects_count1() {
        NSString[] strings = new NSString[3];
        strings[0] = NSString.fromJavaString("strings0obj0");
        strings[1] = NSString.fromJavaString("strings0obj1");
        strings[2] = NSString.fromJavaString("strings0obj2");

        NSSet mySet = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>(strings), 2);
        assertTrue (!mySet.isEqualToSet(null) && mySet.getCount() == 2) ;
    }

    @Test
    public void testSetWithObjects_count1() {
        NSString[] strings = new NSString[3];
        strings[0] = NSString.fromJavaString("strings0obj0");
        strings[1] = NSString.fromJavaString("strings0obj1");
        strings[2] = NSString.fromJavaString("strings0obj2");

        NSSet mySet = NSSet.setWithObjectsCount(new IdArr<NSObject>(strings), 2);
        assertTrue (!mySet.isEqualToSet(null) && mySet.getCount() == 2);
    }

    //TODO: varargs
    /*
    @Test
    public void testSetWithObjects1() {
        NSString number = NSString.fromJavaString("a string");
        NSString aValue = NSString.fromJavaString("a string 2");
        NSString aString = NSString.fromJavaString("a string 3");
        NSSet mySet = NSSet.setWithObjects(number, aValue, aString);
        assertTrue (!mySet.isEqualToSet(null) && mySet.getCount() == 3) ;
    }
    */

    @Test
    public void testDescriptionWithLocale1() {
        NSSet set46 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("six"),
                NSString.fromJavaString("four")
        }), 2);
        NSSet set45 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("three"),
                NSString.fromJavaString("two")
        }), 2);
        NSString strDesc3 = NSString.fromJavaString("{(\n    three,\n    two\n)}");
        NSString strDesc4 = NSString.fromJavaString("{(\n    two,\n    three\n)}");
        assertTrue (!set46.isEqualToSet(null) && !set45.isEqualToSet(null)
                && (set45.descriptionWithLocale(set46).isEqualToString(strDesc3)
                    || set45.descriptionWithLocale(set46).isEqualToString( strDesc4))
        );
    }

    @Test
    public void testInitWithSet_copyItems1() {
        NSSet setObjects7 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[]{
                NSString.fromJavaString("one"),
                NSString.fromJavaString("two"),
                NSString.fromJavaString("three"),
                NSString.fromJavaString("four")
        }), 4);
        NSSet set48 = NSSet.alloc().initWithSetCopyItems(setObjects7, true);
        assertTrue(!set48.isEqualToSet(null) && !setObjects7.isEqualToSet(null) && set48.getCount() == 4);
    }

}
