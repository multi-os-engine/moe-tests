package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import org.moe.natj.general.ptr.ConstPtr;
import ios.NSObject;
import ios.foundation.NSArray;
import ios.foundation.NSEnumerator;
import ios.foundation.NSSet;
import ios.foundation.NSString;

import org.moe.xosrt.binding.test.foundation.Utils.TestObject;
import org.junit.Test;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;

public class NSSetTests {

    //TODO: varargs
    /*
    @Test
    public void testInitWithObjects1() {
        NSSet  set1 = NSSet.alloc().initWithObjectsCount(new IdArr<NSObject>( new NSString[] {
                NSString.stringWithString("one"),
                NSString.stringWithString("two"));
        assertTrue(!set1.isEqualToSet(null) && 2 == set1.count());
    }
    */

    @Test
    public void testCount1() {
        NSString string0 = NSString.stringWithString("string0");
        NSString string1 = NSString.stringWithString("string1");
        NSString string2 = NSString.stringWithString("string2");
        NSSet set2 = NSSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray( NSString.class,
        				new NSString[] {string0, string1, string2, string1}), 4);
        assertTrue(!set2.isEqualToSet(null) && 3 == set2.count());
    }

    @Test
    public void testAllObjects1() {
        NSSet set3 = NSSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        NSArray arr = set3.allObjects();
        assertTrue (!set3.isEqualToSet(null) && arr != null && arr.count() == 3);
    }

    @Test
    public void testAnyObject1() {
        NSSet set4 = NSSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two")
        }), 2);
        NSSet set5 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{}), 0);
        String obj0 = (String) set4.anyObject();
        String obj1 = (String) set5.anyObject();
        assertTrue((obj0.equals("one")
                || obj0.equals("two"))
                && obj1 == null);
    }

    @Test
    public void testIsEqualToSet1() {
        NSSet set10 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two")
        }), 2);
        NSSet set11 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two")
        }), 2);
        NSSet set12 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 2);
        NSSet set13 = NSSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray( NSObject.class, new NSString[]{NSString.stringWithString("one")}), 1);
        NSSet set14 = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSObject.class, new NSString[]{}), 0);
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
        NSSet set20 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two")
        }), 2);
        NSSet set21 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two")
        }), 2);
        NSSet set22 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 2);
        NSSet set23 = NSSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray( NSObject.class, new NSString[]{NSString.stringWithString("one")}), 1);
        NSSet set24 = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSObject.class, new NSString[]{}), 0);
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
        NSArray objects = NSArray.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("three")
        }), 4);
        NSSet set26 = NSSet.alloc().initWithArray(objects);
        assertTrue (!set26.isEqualToSet(null) && set26.count() == 3) ;
    }

    @Test
    public void testMember1() {
        NSSet setObjects1 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        String obj = (String)setObjects1.member("one");
        Object objNil = (Object) setObjects1.member("four");
        assertTrue (!setObjects1.isEqualToSet(null) && obj.equals("one")
                && objNil == null) ;
    }

    @Test
    public void testSetWithArray1() {
        NSArray objects1 = NSArray.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("four"),
                NSString.stringWithString("four")
        }), 5);
        NSSet set27 = NSSet.setWithArray(objects1);
        assertTrue (!set27.isEqualToSet(null) && set27.count() == 4);
    }

    @Test
    public void testInitWithSet1() {
        NSSet setObjects = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        NSSet set28 = NSSet.alloc().initWithSet(setObjects);
        assertTrue (!set28.isEqualToSet(null) && !setObjects.isEqualToSet(null) &&set28.count() == 3 ) ;
    }

    @Test
    public void testSetWithObject1() {
        NSString obj2 = NSString.stringWithString("one");
        NSSet set29 = NSSet.setWithObject(obj2);
        assertTrue (!set29.isEqualToSet(null) && set29.count() == 1) ;
    }

    @Test
    public void testSetWithSet1() {
        NSSet setObjects2 = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        NSSet set30 = NSSet.setWithSet(setObjects2);
        assertTrue (!setObjects2.isEqualToSet(null) && !set30.isEqualToSet(null) && set30.count() == 3 ) ;
    }

    @Test
    public void testDescription1() {
        NSSet set31 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two")
        }), 2);
        assertTrue(!set31.isEqualToSet(null) && (set31.description().equals("{(\n    one,\n    two\n)}")
                || set31.description().equals("{(\n    two,\n    one\n)}")));
    }

    @Test
    public void testSet1() {
        NSSet set32 = NSSet.set();
        assertTrue (set32 != null && set32.count() == 0);
    }

    @Test
    public void testSetByAddingObject1() {
        NSSet setObjects3 = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSObject.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        NSString newObject = NSString.stringWithString("four");
        NSSet set33 = setObjects3.setByAddingObject(newObject);
        NSSet set49 = setObjects3.setByAddingObject(NSString.stringWithString("three"));

        assertTrue (!set33.isEqualToSet(null) && set33.count() == 4 && set49.count() == 3) ;
    }

    @Test
    public void testSetByAddingObjectsFromSet1() {
        NSSet setObjects4 = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSObject.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        NSSet setObjects5 = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSObject.class, new NSString[]{
                NSString.stringWithString("four"),
                NSString.stringWithString("five"),
                NSString.stringWithString("three")
        }), 3);

        NSSet set34 = setObjects4.setByAddingObjectsFromSet(setObjects5);
        assertTrue (!set34.isEqualToSet(null) && set34.count() == 5) ;
    }

    @Test
    public void testSetByAddingObjectsFromArray1() {
        NSSet setObjects6 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        NSArray objects2 = NSArray.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("four"),
                NSString.stringWithString("five"),
                NSString.stringWithString("six"),
                NSString.stringWithString("six")
        }), 4);

        NSSet set35 = setObjects6.setByAddingObjectsFromArray(objects2);
        assertTrue (!set35.isEqualToSet(null) && set35.count() == 6) ;
    }

    @Test
    public void testObjectEnumerator1() {
        NSSet set36 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        NSEnumerator enumerator0 = set36.objectEnumerator();
        Object anObject;
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
        NSSet set37 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three")
        }), 3);
        NSString obj3 = NSString.stringWithString("two");
        boolean contains = set37.containsObject(obj3);
        assertTrue (!set37.isEqualToSet(null) && contains && set37.containsObject(obj3)) ;
    }

    @Test
    public void testIsSubsetOfSet1() throws NoSuchMethodException {
        NSSet set38 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("four")
        }), 4);
        NSSet set39 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("three")
        }), 2);

        assertTrue (!set38.isEqualToSet(null) && !set39.isEqualToSet(null) && set39.isSubsetOfSet(set38));
    }

    @Test
    public void testIntersectsSet1() {
        NSSet set40 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("four")
        }), 4);
        NSSet set41 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("three"),
                NSString.stringWithString("one")
        }), 2);
        NSSet set42 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("five"),
                NSString.stringWithString("six")
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
        testObject0.field = NSString.stringWithString("testObject0");
        testObject1.field = NSString.stringWithString("testObject1");
        testObject2.field = NSString.stringWithString("testObject2");
        testObject3.field = NSString.stringWithString("testObject3");
        NSSet set43 = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSObject.class, new TestObject[] {
                testObject0, testObject1, testObject2, testObject3 }), 4);
        set43.makeObjectsPerformSelector( new SEL(TestObject.class.getMethod("changeField")));
        assertTrue (!set43.isEqualToSet(null) && testObject0.field.isEqual(NSString.stringWithString("changed"))
                && testObject1.field.isEqual(NSString.stringWithString("changed"))
                && testObject2.field.isEqual(NSString.stringWithString("changed"))
                && testObject3.field.isEqual(NSString.stringWithString("changed"))
        );
    }

    @Test
    public void testMakeObjectsPerformSelector_withObject1() throws NoSuchMethodException {
        TestObject testObject4 = TestObject.alloc().init();
        TestObject testObject5 = TestObject.alloc().init();
        TestObject testObject6 = TestObject.alloc().init();
        TestObject testObject7 = TestObject.alloc().init();
        NSString aString0 = NSString.stringWithString("changed1");
        testObject4.field = NSString.stringWithString("testObject4");
        testObject5.field = NSString.stringWithString("testObject5");
        testObject6.field = NSString.stringWithString("testObject6");
        testObject7.field = NSString.stringWithString("testObject7");
        NSSet set44 = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSObject.class,
                new TestObject[] {testObject4, testObject5, testObject6, testObject7 }), 4);
        set44.makeObjectsPerformSelectorWithObject( new SEL(TestObject.class.getMethod("changeFieldWithString", NSString.class)), aString0);
        assertTrue (!set44.isEqualToSet(null) && testObject4.field.isEqual(NSString.stringWithString("changed1"))
                && testObject5.field.isEqual(aString0)
                && testObject6.field.isEqual(NSString.stringWithString("changed1"))
                && testObject7.field.isEqual(NSString.stringWithString("changed1"))
        );
    }

    @Test
    public void testInitWithObjects_count1() {
        NSString[] strings = new NSString[3];
        strings[0] = NSString.stringWithString("strings0obj0");
        strings[1] = NSString.stringWithString("strings0obj1");
        strings[2] = NSString.stringWithString("strings0obj2");

        NSSet mySet = NSSet.alloc().initWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSString.class, strings), 2);
        assertTrue (!mySet.isEqualToSet(null) && mySet.count() == 2) ;
    }

    @Test
    public void testSetWithObjects_count1() {
        NSString[] strings = new NSString[3];
        strings[0] = NSString.stringWithString("strings0obj0");
        strings[1] = NSString.stringWithString("strings0obj1");
        strings[2] = NSString.stringWithString("strings0obj2");

        NSSet mySet = NSSet.setWithObjectsCount((ConstPtr)PtrFactory.newObjectArray( NSString.class, strings), 2);
        assertTrue (!mySet.isEqualToSet(null) && mySet.count() == 2);
    }

    //TODO: varargs
    /*
    @Test
    public void testSetWithObjects1() {
        NSString number = NSString.stringWithString("a string");
        NSString aValue = NSString.stringWithString("a string 2");
        NSString aString = NSString.stringWithString("a string 3");
        NSSet mySet = NSSet.setWithObjects(number, aValue, aString);
        assertTrue (!mySet.isEqualToSet(null) && mySet.count() == 3) ;
    }
    */

    @Test
    public void testDescriptionWithLocale1() {
        NSSet set46 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("six"),
                NSString.stringWithString("four")
        }), 2);
        NSSet set45 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("three"),
                NSString.stringWithString("two")
        }), 2);
        assertTrue (!set46.isEqualToSet(null) && !set45.isEqualToSet(null)
                && (set45.descriptionWithLocale(set46).equals("{(\n    three,\n    two\n)}")
                    || set45.descriptionWithLocale(set46).equals( "{(\n    two,\n    three\n)}"))
        );
    }

    @Test
    public void testInitWithSet_copyItems1() {
        NSSet setObjects7 = NSSet.alloc().initWithObjectsCount( (ConstPtr)PtrFactory.newObjectArray( NSString.class, new NSString[]{
                NSString.stringWithString("one"),
                NSString.stringWithString("two"),
                NSString.stringWithString("three"),
                NSString.stringWithString("four")
        }), 4);
        NSSet set48 = NSSet.alloc().initWithSetCopyItems(setObjects7, true);
        assertTrue(!set48.isEqualToSet(null) && !setObjects7.isEqualToSet(null) && set48.count() == 4);
    }

}
