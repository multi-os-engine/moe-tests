package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.NSObject;
import ios.foundation.NSArray;
import ios.foundation.NSEnumerator;
import ios.foundation.NSMutableSet;
import ios.foundation.NSSet;
import ios.foundation.NSString;

import org.moe.xosrt.binding.test.foundation.Utils.TestObject;
import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

import org.moe.natj.general.ptr.ConstPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.SEL;



public class NSMutableSetTests extends XOSTest {

    @Test
    public void testInitWithCapacity1() {
        NSMutableSet mySet = NSMutableSet.alloc().initWithCapacity(3);
        assertTrue (mySet != null) ;
    }

    @Test
    public void testAddObject1() {
        NSMutableSet  mySet2 = NSMutableSet.alloc().initWithCapacity(3);
        mySet2.addObject(NSString.stringWithString("one"));
        mySet2.addObject(NSString.stringWithString("two"));
        mySet2.addObject(NSString.stringWithString("three"));

        assertTrue (mySet2.count()== 3) ;
    }

    @Test
    public void testCount1() {
        NSMutableSet  mySet3 = NSMutableSet.alloc().initWithCapacity(3);
        mySet3.addObject(NSString.stringWithString("one"));
        mySet3.addObject(NSString.stringWithString("two"));
        mySet3.addObject(NSString.stringWithString("three"));
        assertTrue(3 == mySet3.count());
    }

    @Test
    public void testRemoveObject1() {
        NSMutableSet  mySet4 = NSMutableSet.alloc().initWithCapacity(3);
        mySet4.addObject(NSString.stringWithString("one"));
        mySet4.addObject(NSString.stringWithString("two"));
        mySet4.addObject(NSString.stringWithString("three"));
        mySet4.removeObject(NSString.stringWithString("three"));
        assertTrue (mySet4.count()== 2) ;
    }

    @Test
    public void testRemoveAllObjects1() {
        NSMutableSet  mySet5 = NSMutableSet.alloc().initWithCapacity(3);
        mySet5.addObject(NSString.stringWithString("one"));
        mySet5.addObject(NSString.stringWithString("two"));
        mySet5.addObject(NSString.stringWithString("three"));
        mySet5.removeAllObjects();
        assertTrue (mySet5.count()== 0) ;
    }

    @Test
    public void testAddObjectsFromArray1() {
        NSMutableSet  mySet6 = NSMutableSet.alloc().initWithCapacity(4);
        ConstPtr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
        	NSString.stringWithString("one"),
            NSString.stringWithString("two"),
            NSString.stringWithString("three"),
            NSString.stringWithString("three")
        });
        NSArray anArray = NSArray.arrayWithObjectsCount(arr, 4);
        mySet6.addObjectsFromArray(anArray);
        assertTrue (mySet6.count()== 3) ;
    }

    @Test
    public void testSetWithCapacity1() {
        NSMutableSet set1 = NSMutableSet.setWithCapacity(3);
        set1.addObject(NSString.stringWithString("one"));
        set1.addObject(NSString.stringWithString("two"));
        set1.addObject(NSString.stringWithString("three"));
        assertTrue (set1.count() == 3) ;
    }

    @Test
    public void testInitWithObjects1() {
    	ConstPtr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
        	NSString.stringWithString("one"),
            NSString.stringWithString("two"),
        });
        NSMutableSet set1 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount((ConstPtr)arr, 2);
        assertTrue(!set1.isEqualToSet(null) && 2 == set1.count());
    }

    @Test
    public void testInitWithObjects2() {
        NSString string0 = NSString.stringWithString("string0");
        NSString string1 = NSString.stringWithString("string1");
        NSString string2 = NSString.stringWithString("string2");
        
        ConstPtr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
        	string0,
        	string1,
        	string2,
        	string1
        });
        
        NSMutableSet set2 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount( (ConstPtr)arr, 4);
        assertTrue(!set2.isEqualToSet(null) && 3 == set2.count());
    }

    @Test
    public void testAllObjects1() {
    	
        ConstPtr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
        	NSString.stringWithString("one"),
            NSString.stringWithString("two"),
            NSString.stringWithString("three")
        });
    	
        NSMutableSet set3 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount( (ConstPtr)arr, 3);
        NSArray array = set3.allObjects();
        assertTrue (!set3.isEqualToSet(null) && arr != null && array.count() == 3) ;
    }

    @Test
    public void testAnyObject1() {
    	
        ConstPtr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
        	NSString.stringWithString("one"),
            NSString.stringWithString("two"),
        });
    	
        NSMutableSet set4 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount((ConstPtr)arr, 2);
        NSMutableSet set5 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {}), 0);
        String obj0 = (String) set4.anyObject();
        String obj1 = (String) set5.anyObject();
        assertTrue((obj0.equals("one"))
                || obj0.equals("two") && obj1 == null);
    }

    @Test
    public void testIsEqualToSet1() {
        NSMutableSet set10 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                }) , 2);
        NSMutableSet set11 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                }), 2);
        NSMutableSet set12 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("two"),
                    NSString.stringWithString("three"),
                }), 2);
        NSMutableSet set13 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                }), 1);
        NSMutableSet set14 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {}), 0);
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
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                }), 2);
        NSMutableSet set21 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                }), 2);
        NSMutableSet set22 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("two"),
                    NSString.stringWithString("three"),
                }), 2);
        NSMutableSet set23 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                }), 1);
        NSMutableSet set24 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {}), 0);
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
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three"),
                    NSString.stringWithString("three"),
                }), 4
        );
        NSMutableSet set26 = (NSMutableSet)NSMutableSet.alloc().initWithArray(objects);
        assertTrue (!set26.isEqualToSet(null) && set26.count() == 3) ;
    }

    @Test
    public void testMember1() {
        NSMutableSet setObjects1 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three")
                }), 3);
        String obj = (String)setObjects1.member(NSString.stringWithString("one"));
        NSObject objNil = (NSObject) setObjects1.member(NSString.stringWithString("four"));
        assertTrue (!setObjects1.isEqualToSet(null) && obj.equals("one")
                && objNil == null) ;
    }

    @Test
    public void testSetWithArray1() {
        NSArray objects1 = NSArray.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three"),
                    NSString.stringWithString("four"),
                    NSString.stringWithString("four"),
                }), 5
        );
        NSMutableSet set27 = (NSMutableSet)NSMutableSet.setWithArray(objects1);
        assertTrue (!set27.isEqualToSet(null) && set27.count() == 4) ;
    }

    @Test
    public void testInitWithSet1() {
        NSMutableSet setObjects = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three"),
                }), 3);
        NSMutableSet set28 = (NSMutableSet)NSMutableSet.alloc().initWithSet(setObjects);
        assertTrue (!set28.isEqualToSet(null) && !setObjects.isEqualToSet(null) &&set28.count() == 3 ) ;
    }

    @Test
    public void testSetWithObject1() {
        NSString obj2 = NSString.stringWithString("one");
        NSMutableSet set29 = (NSMutableSet)NSMutableSet.setWithObject(obj2);
        assertTrue (!set29.isEqualToSet(null) && set29.count() == 1) ;
    }

    @Test
    public void testSetWithSet1() {
        NSMutableSet setObjects2 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three"),
                }), 3);
        NSMutableSet set30 = (NSMutableSet)NSMutableSet.setWithSet(setObjects2);
        assertTrue (!setObjects2.isEqualToSet(null) && !set30.isEqualToSet(null) && set30.count() == 3 ) ;
    }

    @Test
    public void testDescription1() {
        NSMutableSet set31 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                }), 2);
        assertTrue(!set31.isEqualToSet(null) && (set31.description().equals("{(\n    one,\n    two\n)}")
                        || set31.description().equals("{(\n    two,\n    one\n)}"))
        );
    }

    @Test
    public void testSet1() {
        NSMutableSet set32 = (NSMutableSet)NSMutableSet.set();
        assertTrue (set32 != null && set32.count() == 0) ;
    }

    @Test
    public void testSetByAddingObject1() {
        NSMutableSet setObjects3 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
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
        NSMutableSet setObjects4 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three")
                }), 3);
        NSMutableSet setObjects5 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("four"),
                    NSString.stringWithString("five"),
                    NSString.stringWithString("three")
                }), 3);

        NSSet set34 = setObjects4.setByAddingObjectsFromSet(setObjects5);
        assertTrue (!set34.isEqualToSet(null) && set34.count() == 5) ;
    }

    @Test
    public void testSetByAddingObjectsFromArray1() {
        NSMutableSet setObjects6 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three")
                }), 3);
        NSArray objects2 = NSArray.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
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
        NSMutableSet set36 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three")
                }), 3);
        NSEnumerator enumerator0 = set36.objectEnumerator();
        String anObject;
        int i = 0;
        anObject = (String) enumerator0.nextObject();
        while (anObject != null) {
            i++;
            anObject = (String) enumerator0.nextObject();
        }
        assertTrue (i == 3);
    }

    @Test
    public void testContainsObject1() {
        NSMutableSet set37 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three")
                }), 3);
        NSString obj3 = NSString.stringWithString("two");
        boolean contains = set37.containsObject(obj3);
        assertTrue (!set37.isEqualToSet(null) && contains && set37.containsObject(obj3)) ;
    }

    @Test
    public void testIsSubsetOfSet1() {
        NSMutableSet set38 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three"),
                    NSString.stringWithString("four")
                }), 4);
        NSMutableSet set39 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("three")
                }), 2);

        assertTrue (!set38.isEqualToSet(null) && !set39.isEqualToSet(null) && set39.isSubsetOfSet(set38)) ;
    }

    @Test
    public void testIntersectsSet1() {
        NSMutableSet set40 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("one"),
                    NSString.stringWithString("two"),
                    NSString.stringWithString("three"),
                    NSString.stringWithString("four")
                }), 4);
        NSMutableSet set41 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                    NSString.stringWithString("three"),
        			NSString.stringWithString("one")
                }), 2);
        NSMutableSet set42 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                    NSString.stringWithString("five"),
        			NSString.stringWithString("six")
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
        testObject0.field = NSString.stringWithString("testObject0");
        testObject1.field = NSString.stringWithString("testObject1");
        testObject2.field = NSString.stringWithString("testObject2");
        testObject3.field = NSString.stringWithString("testObject3");
        NSMutableSet set43 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSObject.class, new NSObject[] {
        			testObject0,
        			testObject1,
        			testObject2,
        			testObject3
                }), 4);
        SEL selector = new SEL(TestObject.class.getMethod("changeField"));
        set43.makeObjectsPerformSelector(selector);
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
        NSMutableSet set44 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSObject.class, new NSObject[] {
        			testObject4,
        			testObject5,
        			testObject6,
        			testObject7
                }), 4);
        SEL selector = new SEL(TestObject.class.getMethod("changeFieldWithString", NSString.class));
        set44.makeObjectsPerformSelectorWithObject(selector, aString0);
        assertTrue (!set44.isEqualToSet(null) && testObject4.field.isEqual(NSString.stringWithString("changed1"))
                && testObject5.field.isEqual(aString0)
                && testObject6.field.isEqual(NSString.stringWithString("changed1"))
                && testObject7.field.isEqual(NSString.stringWithString("changed1"))
        );
    }

    @Test
    public void testInitWithObjects_count1() {
		ConstPtr strings0 = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("strings0obj0"),
                NSString.stringWithString("strings0obj1"),
                NSString.stringWithString("strings0obj2")
        });

        NSMutableSet mySet = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount((ConstPtr)strings0, 2);
        assertTrue (!mySet.isEqualToSet(null) && mySet.count() == 2) ;
    }

    @Test
    public void testSetWithObjects_count1() {
    	ConstPtr<NSString> strings0 = PtrFactory.newObjectArray(NSString.class, new NSString[] {
            NSString.stringWithString("strings0obj0"),
            NSString.stringWithString("strings0obj1"),
            NSString.stringWithString("strings0obj2")
    	});
        NSMutableSet mySet = (NSMutableSet)NSMutableSet.setWithObjectsCount(strings0, 2);
        assertTrue (!mySet.isEqualToSet(null) && mySet.count() == 2) ;
    }

    @Test
    public void testSetWithObjects1() {
        NSString number = NSString.stringWithString("a string");
        NSString aValue = NSString.stringWithString("a string 2");
        NSString aString = NSString.stringWithString("a string 3");
        NSMutableSet mySet = (NSMutableSet)NSMutableSet.setWithObjectsCount(
        		PtrFactory.newObjectArray(NSString.class, new NSString[] {
                    number,
                    aValue,
                    aString
                }), 3);
        assertTrue (!mySet.isEqualToSet(null) && mySet.count() == 3);
    }

    @Test
    public void testDescriptionWithLocale1() {
        NSMutableSet set46 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                	NSString.stringWithString("six"),
                    NSString.stringWithString("four")
                }), 2);
        NSMutableSet set45 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("three"),
                        NSString.stringWithString("two")
                }), 2);
        assertTrue (!set46.isEqualToSet(null) && !set45.isEqualToSet(null)
                && (set45.descriptionWithLocale(set46).equals("{(\n    three,\n    two\n)}")
                    || set45.descriptionWithLocale(set46).equals("{(\n    two,\n    three\n)}"))
        );
    }

    @Test
    public void testInitWithSet_copyItems1() {
        NSMutableSet setObjects7 = (NSMutableSet)NSMutableSet.alloc().initWithObjectsCount(
                (ConstPtr)PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("one"),
                        NSString.stringWithString("two"),
                        NSString.stringWithString("three"),
                        NSString.stringWithString("four")
                }), 4);
        NSMutableSet set48 = (NSMutableSet)NSMutableSet.alloc().initWithSetCopyItems(setObjects7, true);
        assertTrue (!set48.isEqualToSet(null) && !setObjects7.isEqualToSet(null) && set48.count() == 4);
    }

}
