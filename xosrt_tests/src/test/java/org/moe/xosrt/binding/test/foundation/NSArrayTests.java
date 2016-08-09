package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.ConstPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ObjCObject;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;

import static org.junit.Assert.*;
import ios.NSObject;
import ios.foundation.*;
import ios.foundation.c.Foundation;
import ios.foundation.enums.*;
import ios.foundation.struct.NSRange;

import org.moe.xosrt.binding.test.foundation.Utils.TestObject;
import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.Exception;import java.lang.Object;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;

public class NSArrayTests extends XOSTest{

	@Test
	public void simpleStaticCreationTest() {
		NSArray testNSArray = NSArray.array();
		assertNotNull(testNSArray);
	 }

	@Test
	public void objectAtIndexTest() {
		NSObject obj = NSObject.alloc().init();
		NSArray testNSArray = NSArray.arrayWithObject(obj);
		assertEquals(obj, testNSArray.objectAtIndex(0));
	 }

	@Test
	public void arrayByAddingObjectTest() {
		NSObject[] obj = new NSObject[100];
		for(int i = 0; i < 100; i++) obj[i] = NSObject.alloc().init();
		NSArray testNSArray = NSArray.array();
		for(int i = 0; i < 100; i++) testNSArray = testNSArray.arrayByAddingObject(obj[i]);

		assertEquals(obj[42], testNSArray.objectAtIndex(42));
	 }

    @Test
    public void testArray1() {
        NSArray array = NSArray.array();
        assertTrue(array != null && array.count() == 0);
    }

    //TODO: varargs
    @Ignore
    @Test
    public void testArrayWithObjects() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("string0"),
                NSString.stringWithString("string1"),
                NSString.stringWithString("string2")
        });
        //NSArray array = NSArray.arrayWithObjects(arr);
        NSArray array2 = NSArray.array();
        //assertTrue(array.count() == 3 && array2.count() == 0);
    }

    @Test
    @Ignore
    //TODO: varargs
    public void testInitWithObjects() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("string0"),
                NSString.stringWithString("string1"),
                NSString.stringWithString("string2")
        });
        //NSArray array = NSArray.alloc().initWithObjects(arr);
        //assertTrue(array.count() == 3);
    }

    @Test
    public void testArrayWithArray() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("A"),
                NSString.stringWithString("B")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 2);
        NSArray array2 = NSArray.arrayWithArray(array);
        assertTrue(array2.count() == 2
                && array2.objectAtIndex(0).equals(array.objectAtIndex(0))
                && array2.objectAtIndex(1).equals(array.objectAtIndex(1))
        );
    }

    @Test @Ignore
    // TODO This test is broken cause of NSString->String conversion
    public void testInitWithArray() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("A"),
                NSString.stringWithString("B")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 2);
        NSArray array2 = NSArray.alloc();
        array2.initWithArray(array);
        assertTrue(array2.count() == 2
                && array2.objectAtIndex(0).equals(array.objectAtIndex(0))
                && array2.objectAtIndex(1).equals(array.objectAtIndex(1))
        );
    }

    @Test
    public void testArrayWithObject() {
        NSArray array = NSArray.arrayWithObject(NSString.stringWithString("string0"));
        assertTrue(array.count() == 1);
    }

    @Test
    public void testObjectEnumerator() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("string0"),
                NSString.stringWithString("string1"),
                NSString.stringWithString("string2")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);
        NSEnumerator enumerator = array.objectEnumerator();
        Object object;
        int count = 0;
        object = enumerator.nextObject();
        while (object != null) {
            object = enumerator.nextObject();
            count++;
        }
        assertTrue(count == 3);
    }

    @Test
    public void testContainsObject() {
        NSString string0 = NSString.stringWithString("string0");
        NSString string1 = NSString.stringWithString("string1");
        NSString string2 = NSString.stringWithString("string2");

        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                string0, string1, string2
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);

        boolean flag = array.containsObject(string0);
        assertTrue(flag && array.containsObject(string2));
    }

    @Test
    public void testLastObject() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("string0"),
                NSString.stringWithString("string1"),
                NSString.stringWithString("string2")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);
        assertTrue((array.lastObject()).equals("string2"));
    }

    @Test
    public void testDescription() {
        NSString objectToInitArray = NSString.stringWithString("asdf");
        NSArray array = NSArray.arrayWithObject(objectToInitArray);
        NSString description = NSString.stringWithString(array.description());
        NSString description2 = NSString.stringWithString("(\n    asdf\n)");
        assertTrue(description.equals(description2));
    }

    @Test
    public void testObjectAtIndex() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("string0"),
                NSString.stringWithString("string1"),
                NSString.stringWithString("string2")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);
        assertTrue(array.objectAtIndex(2).equals("string2"));
    }

    @Test
    public void testCount() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("string0"),
                NSString.stringWithString("string1"),
                NSString.stringWithString("string2")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);
        assertTrue(array.count() == 3);
    }

    @Test
    public void testInit() {
        NSArray array = NSArray.alloc();
        array.init();
        assertTrue(array != null && array.count() == 0);
    }

    @Test
    public void testIsEqualToArray() {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("hello"),
                NSString.stringWithString("food"),
                NSString.stringWithString("sleep")
        });
        Ptr arr2 = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("hello"),
                NSString.stringWithString("sleep"),
                NSString.stringWithString("food")
        });

        NSArray array1 = NSArray.alloc().initWithObjectsCount((ConstPtr)arr, 3);
        NSArray array2 = NSArray.alloc().initWithObjectsCount((ConstPtr)arr, 3);
        NSArray array3 = NSArray.alloc().initWithObjectsCount((ConstPtr)arr2, 3);
        NSArray array4 = NSArray.alloc(); array4.init();
        NSArray array5 = null;

        assertTrue(array1.isEqualToArray(array2) && array2.isEqualToArray(array1)
            && array1.isEqualToArray(array1) && array2.isEqualToArray(array2)
            && !array1.isEqualToArray(array3) && !array2.isEqualToArray(array4)
            && !array3.isEqualToArray(array5) && !array3.isEqualToArray(null)
        );
    }

    @Test
    public void testIsEqual() {
        Ptr arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("hello"),
                NSString.stringWithString("food"),
                NSString.stringWithString("sleep")
        });
        Ptr arr2 = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("hello")
        });

        NSArray array1 = NSArray.alloc().initWithObjectsCount((ConstPtr)arr, 3);
        NSArray array2 = NSArray.alloc().initWithObjectsCount((ConstPtr)arr, 3);
        NSArray array3 = NSArray.alloc().initWithObjectsCount((ConstPtr)arr2, 1);
        NSArray array4 = NSArray.alloc(); array4.init();
        NSArray array5 = null;

        assertTrue(array1.isEqual(array2) && array2.isEqual(array1)
                && array1.isEqual(array1) && array2.isEqual(array2)
                && !array1.isEqual(array3) && !array2.isEqual(array4)
                && !array3.isEqual(array5) && !array3.isEqual(null)
        );
    }

    @Test
    public void testArrayWithObjects_Count() {
        NSString[] strings = new NSString[3];
        strings[0] = NSString.stringWithString("stringsobj0");
        strings[1] = NSString.stringWithString("stringsobj1");
        strings[2] = NSString.stringWithString("stringsobj2");
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, strings);
        NSArray array = NSArray.arrayWithObjectsCount(arr, 2);
        assertTrue(array.count() == 2
                && (strings[0]).isEqualToString((String)array.objectAtIndex(0))
                && (strings[1]).isEqualToString((String)array.objectAtIndex(1))
        );
    }

    @Test
    public void testInitWithObjects_Count() {
        NSString[] strings = new NSString[3];
        strings[0] = NSString.stringWithString("stringsobj0");
        strings[1] = NSString.stringWithString("stringsobj1");
        strings[2] = NSString.stringWithString("stringsobj2");
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, strings);
        NSArray array = NSArray.alloc().initWithObjectsCount((ConstPtr)arr, 2);
        assertTrue(array.count() == 2
                && (strings[0]).isEqualToString(array.objectAtIndex(0).toString())
                && (strings[1]).isEqualToString(array.objectAtIndex(1).toString())
        );
    }

    @Test
    public void testIndexOfObject() {
        NSString string0 = NSString.stringWithString("string0");
        NSString string1 = NSString.stringWithString("string1");
        NSString string2 = NSString.stringWithString("string2");
        NSString string3 = NSString.stringWithString("string3");

        NSArray array = NSArray.arrayWithObject(string0);
        array = array.arrayByAddingObject(string1);
        array = array.arrayByAddingObject(string2);

        assertTrue(array.indexOfObject(string0) == 0 && array.indexOfObject(string1) == 1
            && array.indexOfObject(string3) == Foundation.NSNotFound
        );
    }

    @Test
    public void testArrayByAddingObject() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("0"),
                NSString.stringWithString("1")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 2);
        NSArray array2 = array.arrayByAddingObject(NSString.stringWithString("2"));
        assertTrue(array2.count() == 3 && array2.objectAtIndex(2).equals("2"));
    }

    @Test
    public void testArrayByAddingObjectsFromArray() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("0"),
                NSString.stringWithString("1")
        });
        Ptr<NSString> arr2 = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("A"),
                NSString.stringWithString("B")
        });
        NSArray array1 = NSArray.arrayWithObjectsCount(arr, 2);
        NSArray array2 = NSArray.arrayWithObjectsCount(arr2, 2);
        NSArray array3 = array1.arrayByAddingObjectsFromArray(array2);
        assertTrue(array3.count() == 4
                && array3.objectAtIndex(0).equals("0")
                && array3.objectAtIndex(1).equals("1")
                && array3.objectAtIndex(2).equals("A")
                && array3.objectAtIndex(3).equals("B")
        );
    }

    @Test
    public void testSubarrayWithRange() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("0"),
                NSString.stringWithString("1"),
                NSString.stringWithString("2"),
                NSString.stringWithString("3")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        NSRange range = Foundation.NSMakeRange(1, 2);
        NSArray array2 = array.subarrayWithRange(range);
        assertTrue(array2.count() == 2
                && array2.objectAtIndex(0).equals("1")
                && array2.objectAtIndex(1).equals("2")
        );
    }

    @Test
    public void testMakeObjectsPerformSelector() throws Exception {
        TestObject testObject0 = TestObject.alloc().init();
        TestObject testObject1 = TestObject.alloc().init();
        TestObject testObject2 = TestObject.alloc().init();
        TestObject testObject3 = TestObject.alloc().init();

        testObject0.field = NSString.stringWithString("testObject0");
        testObject1.field = NSString.stringWithString("testObject1");
        testObject2.field = NSString.stringWithString("testObject2");
        testObject3.field = NSString.stringWithString("testObject3");

        Ptr<TestObject> arr = PtrFactory.newObjectArray(TestObject.class, new TestObject[] {
                testObject0, testObject1, testObject2, testObject3
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        array.makeObjectsPerformSelector(new SEL("changeField"));
        assertTrue(testObject0.field.equals(NSString.stringWithString("changed"))
                && testObject1.field.equals(NSString.stringWithString("changed"))
                && testObject2.field.equals(NSString.stringWithString("changed"))
                && testObject3.field.equals(NSString.stringWithString("changed"))
        );
    }

    @Test
    public void testMakeObjectsPerformSelector_withObject() throws Exception {
        TestObject testObject0 = TestObject.alloc().init();
        TestObject testObject1 = TestObject.alloc().init();
        TestObject testObject2 = TestObject.alloc().init();
        TestObject testObject3 = TestObject.alloc().init();
        NSString aString = NSString.stringWithString("changed1");
        testObject0.field = NSString.stringWithString("testObject0");
        testObject1.field = NSString.stringWithString("testObject1");
        testObject2.field = NSString.stringWithString("testObject2");
        testObject3.field = NSString.stringWithString("testObject3");

        Ptr<TestObject> arr = PtrFactory.newObjectArray(TestObject.class, new TestObject[] {
                testObject0, testObject1, testObject2, testObject3
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        array.makeObjectsPerformSelectorWithObject(new SEL("changeFieldWithString:"), aString);
        assertTrue(testObject0.field.equals(NSString.stringWithString("changed1"))
                        && testObject1.field.equals(aString)
                        && testObject2.field.equals(NSString.stringWithString("changed1"))
                        && testObject3.field.equals(NSString.stringWithString("changed1"))
        );
    }

    @Test
    public void testComponentsJoinedByString() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("A"),
                NSString.stringWithString("B"),
                NSString.stringWithString("C"),
                NSString.stringWithString("D")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        NSString aString = NSString.stringWithString(array.componentsJoinedByString(" "));
        assertTrue(aString.equals(NSString.stringWithString("A B C D")));
    }

    @Test
    public void testSortedArrayUsingFunction_context() {
        Ptr<NSNumber> arr = PtrFactory.newObjectArray(NSNumber.class, new NSNumber[]{
                NSNumber.numberWithInt(1),
                NSNumber.numberWithInt(8),
                NSNumber.numberWithInt(9),
                NSNumber.numberWithInt(7),
                NSNumber.numberWithInt(5),
                NSNumber.numberWithInt(2),
                NSNumber.numberWithInt(6),
                NSNumber.numberWithInt(4),
                NSNumber.numberWithInt(3),
                NSNumber.numberWithInt(0)
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 10);
        NSArray array2 = array.sortedArrayUsingFunctionContext(new NSArray.Function_sortedArrayUsingFunctionContext() {
            @Selector("call_sortedArrayUsingFunctionContext:")
            public long call_sortedArrayUsingFunctionContext(Object a, Object b, VoidPtr ctx) {
                int v1 = ((NSNumber)a).intValue();
                int v2 = ((NSNumber)b).intValue();
                if (v1 < v2) {
                    return NSComparisonResult.Ascending;
                } else if (v1 > v2) {
                    return NSComparisonResult.Descending;
                } else {
                    return NSComparisonResult.Same;
                }
            }
        }, null);
        boolean flag = true;
        for (int index = 0; index < array2.count(); index++) {
            if (((NSNumber)array2.objectAtIndex(index)).intValue() != index) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testObjectUsingSelector() throws Exception {
        TestObject testObjectA = TestObject.alloc().init();
        TestObject testObjectB = TestObject.alloc().init();
        TestObject testObjectC = TestObject.alloc().init();
        TestObject testObjectD = TestObject.alloc().init();

        testObjectA.field = NSString.stringWithString("A");
        testObjectB.field = NSString.stringWithString("B");
        testObjectC.field = NSString.stringWithString("C");
        testObjectD.field = NSString.stringWithString("D");

        Ptr<TestObject> arr = PtrFactory.newObjectArray(TestObject.class, new TestObject[] {
                testObjectA, testObjectB, testObjectC, testObjectD
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        NSArray array2 = array.sortedArrayUsingSelector(new SEL("compareFields:"));
        assertTrue(array2.count() == 4 && array2.objectAtIndex(0).equals(testObjectA)
                && array2.objectAtIndex(1).equals(testObjectB)
                && array2.objectAtIndex(2).equals(testObjectC)
                && array2.objectAtIndex(3).equals(testObjectD)
        );
    }

    @Test
    @Ignore
    //TODO: Native object' array initialisation; buffer.get() returns null
    public void testGetObjects_range() {
        NSMutableString stringA = (NSMutableString)NSMutableString.stringWithString("A");
        NSMutableString stringB = (NSMutableString)NSMutableString.stringWithString("B");
        NSMutableString stringC = (NSMutableString)NSMutableString.stringWithString("C");
        NSMutableString stringD = (NSMutableString)NSMutableString.stringWithString("D");
        NSMutableString stringE = (NSMutableString)NSMutableString.stringWithString("E");
        NSMutableString stringF = (NSMutableString)NSMutableString.stringWithString("F");
        Ptr<NSMutableString> arr = PtrFactory.newObjectArray(NSMutableString.class, new NSMutableString[] {
                stringA, stringB, stringC, stringD, stringE, stringF
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 6);

        NSRange range = Foundation.NSMakeRange(2, 2);
        int len = (int) range.length();
        Ptr<? extends NSString> buffer = PtrFactory.newObjectArray(NSMutableString.class, len);

        array.getObjectsRange(buffer, range);

        NSString zerost = (NSString)buffer.get(0);
        NSString first = (NSString)buffer.get(1);

        String second = (String)array.objectAtIndex(2);
        String third = (String)array.objectAtIndex(3);

        boolean pass = second.equals(zerost.toString()) &&
                       third.equals(first.toString());

        assertTrue(pass);
    }

    @Test @Ignore
    // TODO This test is broken cause of NSString->String conversion
    public void testInitWithArray_copyItems() {
        NSMutableString string = (NSMutableString)NSMutableString.stringWithString("G");
        NSArray array1 = NSArray.arrayWithObject(string);
        NSArray array2 = (NSArray)NSArray.alloc().initWithArrayCopyItems(array1, true);
        NSArray array3 = (NSArray)NSArray.alloc().initWithArrayCopyItems(array1, false);
        assertTrue(array2.count() == 1 && array3.count() == 1 &&
            array2.objectAtIndex(0) != string && array3.objectAtIndex(0) == string);
    }

    @Test @Ignore
    // TODO This test is broken cause of NSString->String conversion
    public void testObjectsAtIndexes() {
        NSRange range = Foundation.NSMakeRange(2, 2);
        NSIndexSet indexSet = NSIndexSet.alloc().initWithIndexesInRange(range);
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("A"),
                NSString.stringWithString("B"),
                NSString.stringWithString("C"),
                NSString.stringWithString("D"),
                NSString.stringWithString("E")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 5);
        NSArray array2 = array.objectsAtIndexes(indexSet);
        assertTrue(array.objectAtIndex(2).toString(), array2.count() == indexSet.count()
                && array2.objectAtIndex(0).toString() == array.objectAtIndex(2)
                && array2.objectAtIndex(1).toString() == array.objectAtIndex(3)
        );

    }
}
