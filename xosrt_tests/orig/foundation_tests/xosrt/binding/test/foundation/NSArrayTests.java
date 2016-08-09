package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.core.VoidPtr;
import xosrt.binding.foundation.Foundation;
import xosrt.binding.foundation.NSArray;
import xosrt.binding.foundation.NSComparisonResult;
import xosrt.binding.foundation.NSEnumerator;
import xosrt.binding.foundation.NSIndexSet;
import xosrt.binding.foundation.NSMutableString;
import xosrt.binding.foundation.NSNumber;
import xosrt.binding.foundation.NSObject;
import xosrt.binding.foundation.NSRange;
import xosrt.binding.foundation.NSString;
import xosrt.binding.objc.NSInteger;
import xosrt.binding.pointers.FuncPtr;
import xosrt.binding.pointers.IdPtr;
import xosrt.binding.test.foundation.Utils.TestObject;
import org.junit.Ignore;
import org.junit.Test;

public class NSArrayTests {

	static {
		System.loadLibrary("Mac");
	}
	
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

    private long integerSortFunc(IdPtr a, IdPtr b, VoidPtr context) {
        int v1 = ((NSNumber)a.getPointee()).getIntValue();
        int v2 = ((NSNumber)b.getPointee()).getIntValue();
        if (v1 < v2) {
            return NSComparisonResult.Ascending;
        } else if (v1 > v2) {
            return NSComparisonResult.Descending;
        } else {
            return NSComparisonResult.Same;
        }
    }

    @Test
    public void testArray1() {
        NSArray array = NSArray.array();
        assertTrue(array != null && array.getCount() == 0);
    }

    //TODO: varargs
    @Ignore
    @Test
    public void testArrayWithObjects() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("string0"),
                NSString.fromJavaString("string1"),
                NSString.fromJavaString("string2")
        });
        //NSArray array = NSArray.arrayWithObjects(arr);
        NSArray array2 = NSArray.array();
        //assertTrue(array.getCount() == 3 && array2.getCount() == 0);
    }

    //TODO: varargs
    @Ignore
    @Test
    public void testInitWithObjects() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[]{
                NSString.fromJavaString("string0"),
                NSString.fromJavaString("string1"),
                NSString.fromJavaString("string2")
        });
        //NSArray array = NSArray.alloc().initWithObjects(arr);
        //assertTrue(array.getCount() == 3);
    }

    @Test
    public void testArrayWithArray() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("A"),
                NSString.fromJavaString("B")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 2);
        NSArray array2 = NSArray.arrayWithArray(array);
        assertTrue(array2.getCount() == 2
                && array2.objectAtIndex(0).isEqual(array.objectAtIndex(0))
                && array2.objectAtIndex(1).isEqual(array.objectAtIndex(1))
        );
    }

    @Test
    public void testInitWithArray() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("A"),
                NSString.fromJavaString("B")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 2);
        NSArray array2 = NSArray.alloc();
        array2.initWithArray(array);
        assertTrue(array2.getCount() == 2
                && array2.objectAtIndex(0).isEqual(array.objectAtIndex(0))
                && array2.objectAtIndex(1).isEqual(array.objectAtIndex(1))
        );
    }

    @Test
    public void testArrayWithObject() {
        NSArray array = NSArray.arrayWithObject(NSString.fromJavaString("string0"));
        assertTrue(array.getCount() == 1);
    }

    @Test
    public void testObjectEnumerator() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("string0"),
                NSString.fromJavaString("string1"),
                NSString.fromJavaString("string2")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);
        NSEnumerator enumerator = array.objectEnumerator();
        NSObject object;
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
        NSString string0 = NSString.fromJavaString("string0");
        NSString string1 = NSString.fromJavaString("string1");
        NSString string2 = NSString.fromJavaString("string2");

        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                string0, string1, string2
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);

        boolean flag = array.containsObject(string0);
        assertTrue(flag && array.containsObject(string2));
    }

    @Test
    public void testLastObject() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("string0"),
                NSString.fromJavaString("string1"),
                NSString.fromJavaString("string2")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);
        assertTrue((array.getLastObject()).isEqual(NSString.fromJavaString("string2")));
    }

    @Test
    public void testDescription() {
        NSString objectToInitArray = NSString.fromJavaString("asdf");
        NSArray array = NSArray.arrayWithObject(objectToInitArray);
        NSString description = array.description();
        NSString description2 = NSString.fromJavaString("(\n    asdf\n)");
        assertTrue(description.isEqual(description2));
    }

    @Test
    public void testObjectAtIndex() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("string0"),
                NSString.fromJavaString("string1"),
                NSString.fromJavaString("string2")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);
        NSString string2 = NSString.fromJavaString("string2");
        assertTrue(array.objectAtIndex(2).isEqual(string2));
    }

    @Test
    public void testCount() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("string0"),
                NSString.fromJavaString("string1"),
                NSString.fromJavaString("string2")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 3);
        assertTrue(array.getCount() == 3);
    }

    @Test
    public void testInit() {
        NSArray array = NSArray.alloc();
        array.init().autorelease();
        assertTrue(array != null && array.getCount() == 0);
    }

    @Test
    public void testIsEqualToArray() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("hello"),
                NSString.fromJavaString("food"),
                NSString.fromJavaString("sleep")
        });
        IdArr<NSObject> arr2 = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("hello"),
                NSString.fromJavaString("sleep"),
                NSString.fromJavaString("food")
        });

        NSArray array1 = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSArray array2 = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSArray array3 = NSArray.alloc().initWithObjectsCount(arr2, 3);
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
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("hello"),
                NSString.fromJavaString("food"),
                NSString.fromJavaString("sleep")
        });
        IdArr<NSObject> arr2 = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("hello")
        });

        NSArray array1 = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSArray array2 = NSArray.alloc().initWithObjectsCount(arr, 3);
        NSArray array3 = NSArray.alloc().initWithObjectsCount(arr2, 1);
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
        strings[0] = NSString.fromJavaString("stringsobj0");
        strings[1] = NSString.fromJavaString("stringsobj1");
        strings[2] = NSString.fromJavaString("stringsobj2");
        IdArr<NSObject> arr = new IdArr<NSObject>(strings);
        NSArray array = NSArray.arrayWithObjectsCount(arr, 2);
        assertTrue(array.getCount() == 2
                && ((NSString) array.objectAtIndex(0)).isEqualToString(strings[0])
                && ((NSString) array.objectAtIndex(1)).isEqualToString(strings[1])
        );
    }

    @Test
    public void testInitWithObjects_Count() {
        NSString[] strings = new NSString[3];
        strings[0] = NSString.fromJavaString("stringsobj0");
        strings[1] = NSString.fromJavaString("stringsobj1");
        strings[2] = NSString.fromJavaString("stringsobj2");
        IdArr<NSObject> arr = new IdArr<NSObject>(strings);
        NSArray array = NSArray.alloc().initWithObjectsCount(arr, 2);
        assertTrue(array.getCount() == 2
                && ((NSString) array.objectAtIndex(0)).isEqualToString(strings[0])
                && ((NSString) array.objectAtIndex(1)).isEqualToString(strings[1])
        );
    }

    @Test
    public void testIndexOfObject() {
        NSString string0 = NSString.fromJavaString("string0");
        NSString string1 = NSString.fromJavaString("string1");
        NSString string2 = NSString.fromJavaString("string2");
        NSString string3 = NSString.fromJavaString("string3");

        NSArray array = NSArray.arrayWithObject(string0);
        array = array.arrayByAddingObject(string1);
        array = array.arrayByAddingObject(string2);

        assertTrue(array.indexOfObject(string0) == 0 && array.indexOfObject(string1) == 1
            && array.indexOfObject(string3) == Foundation.NotFound
        );
    }

    @Test
    public void testArrayByAddingObject() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("0"),
                NSString.fromJavaString("1")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 2);
        NSArray array2 = array.arrayByAddingObject(NSString.fromJavaString("2"));
        assertTrue(array2.getCount() == 3 && array2.objectAtIndex(2).isEqual(NSString.fromJavaString("2")));
    }

    @Test
    public void testArrayByAddingObjectsFromArray() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("0"),
                NSString.fromJavaString("1")
        });
        IdArr<NSObject> arr2 = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("A"),
                NSString.fromJavaString("B")
        });
        NSArray array1 = NSArray.arrayWithObjectsCount(arr, 2);
        NSArray array2 = NSArray.arrayWithObjectsCount(arr2, 2);
        NSArray array3 = array1.arrayByAddingObjectsFromArray(array2);
        assertTrue(array3.getCount() == 4
                && array3.objectAtIndex(0).isEqual(NSString.fromJavaString("0"))
                && array3.objectAtIndex(1).isEqual(NSString.fromJavaString("1"))
                && array3.objectAtIndex(2).isEqual(NSString.fromJavaString("A"))
                && array3.objectAtIndex(3).isEqual(NSString.fromJavaString("B"))
        );
    }

    @Test
    public void testSubarrayWithRange() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("0"),
                NSString.fromJavaString("1"),
                NSString.fromJavaString("2"),
                NSString.fromJavaString("3")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        NSRange range = Foundation.NSMakeRange(1, 2);
        NSArray array2 = array.subarrayWithRange(range);
        assertTrue(array2.getCount() == 2
                && array2.objectAtIndex(0).isEqual(NSString.fromJavaString("1"))
                && array2.objectAtIndex(1).isEqual(NSString.fromJavaString("2"))
        );
    }

    @Test
    public void testMakeObjectsPerformSelector() throws Exception {
        TestObject testObject0 = TestObject.alloc().init();
        TestObject testObject1 = TestObject.alloc().init();
        TestObject testObject2 = TestObject.alloc().init();
        TestObject testObject3 = TestObject.alloc().init();

        testObject0.field = NSString.fromJavaString("testObject0");
        testObject1.field = NSString.fromJavaString("testObject1");
        testObject2.field = NSString.fromJavaString("testObject2");
        testObject3.field = NSString.fromJavaString("testObject3");

        IdArr<NSObject> arr = new IdArr<NSObject>(new TestObject[] {
                testObject0, testObject1, testObject2, testObject3
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        array.makeObjectsPerformSelector(TestObject.class.getMethod("changeField"));
        assertTrue(testObject0.field.isEqual(NSString.fromJavaString("changed"))
                && testObject1.field.isEqual(NSString.fromJavaString("changed"))
                && testObject2.field.isEqual(NSString.fromJavaString("changed"))
                && testObject3.field.isEqual(NSString.fromJavaString("changed"))
        );
    }

    @Test
    public void testMakeObjectsPerformSelector_withObject() throws Exception {
        TestObject testObject0 = TestObject.alloc().init();
        TestObject testObject1 = TestObject.alloc().init();
        TestObject testObject2 = TestObject.alloc().init();
        TestObject testObject3 = TestObject.alloc().init();
        NSString aString = NSString.fromJavaString("changed1");
        testObject0.field = NSString.fromJavaString("testObject0");
        testObject1.field = NSString.fromJavaString("testObject1");
        testObject2.field = NSString.fromJavaString("testObject2");
        testObject3.field = NSString.fromJavaString("testObject3");

        IdArr<NSObject> arr = new IdArr<NSObject>(new TestObject[] {
                testObject0, testObject1, testObject2, testObject3
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        array.makeObjectsPerformSelectorWithObject(TestObject.class.getMethod("changeField"), aString);
        assertTrue(testObject0.field.isEqual(NSString.fromJavaString("changed1"))
                        && testObject1.field.isEqual(aString)
                        && testObject2.field.isEqual(NSString.fromJavaString("changed1"))
                        && testObject3.field.isEqual(NSString.fromJavaString("changed1"))
        );
    }

    @Test
    public void testComponentsJoinedByString() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("A"),
                NSString.fromJavaString("B"),
                NSString.fromJavaString("C"),
                NSString.fromJavaString("D")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        NSString aString = array.componentsJoinedByString(NSString.fromJavaString(" "));
        assertTrue(aString.isEqual(NSString.fromJavaString("A B C D")));
    }

    @Test
    public void testSortedArrayUsingFunction_context() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSNumber[]{
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
        NSArray array2 = array.sortedArrayUsingFunctionContext(new FuncPtr("integerSortFunc"), null);
        boolean flag = true;
        for (int index = 0; index < array2.getCount(); index++) {
            if (((NSNumber)array2.objectAtIndex(index)).getIntValue() != index) {
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

        testObjectA.field = NSString.fromJavaString("A");
        testObjectB.field = NSString.fromJavaString("B");
        testObjectC.field = NSString.fromJavaString("C");
        testObjectD.field = NSString.fromJavaString("D");

        IdArr<NSObject> arr = new IdArr<NSObject>(new TestObject[] {
                testObjectA, testObjectB, testObjectC, testObjectD
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 4);
        NSArray array2 = array.sortedArrayUsingSelector(TestObject.class.getMethod("compareFields",
                new Class[] {TestObject.class}));
        assertTrue(array2.getCount() == 4 && array2.objectAtIndex(0).isEqual(testObjectA)
                && array2.objectAtIndex(1).isEqual(testObjectB)
                && array2.objectAtIndex(2).isEqual(testObjectC)
                && array2.objectAtIndex(3).isEqual(testObjectD)
        );
    }

    @Test
    public void testGetObjects_range() {
        NSMutableString stringA = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("A"));
        NSMutableString stringB = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("B"));
        NSMutableString stringC = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("C"));
        NSMutableString stringD = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("D"));
        NSMutableString stringE = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("E"));
        NSMutableString stringF = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("F"));
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSMutableString[] {
                stringA, stringB, stringC, stringD, stringE, stringF
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 6);

        NSRange range = Foundation.NSMakeRange(2, 2);
        IdArr<NSObject> buffer = new IdArr<NSObject>(range.getLength());
        //aBuffer = malloc(sizeof(id) * aRange.length);
        array.getObjectsRange(buffer, range);
        boolean pass = array.objectAtIndex(2).isEqual(buffer.get(0)) &&
                array.objectAtIndex(3).isEqual(buffer.get(1)) &&
                array.objectAtIndex(2) == buffer.get(0) &&
                array.objectAtIndex(3) == buffer.get(1);
        //free(aBuffer);
        assertTrue(pass);
    }

    @Test
    public void testInitWithArray_copyItems() {
        NSMutableString string = (NSMutableString)NSMutableString.stringWithString(NSString.fromJavaString("G"));
        NSArray array1 = NSArray.arrayWithObject(string);
        NSArray array2 = (NSArray)NSArray.alloc().initWithArrayCopyItems(array1, true);
        NSArray array3 = (NSArray)NSArray.alloc().initWithArrayCopyItems(array1, false);
        assertTrue(array2.getCount() == 1 && array3.getCount() == 1 &&
            array2.objectAtIndex(0) != string && array3.objectAtIndex(0) == string);
    }

    @Test
    public void testObjectsAtIndexes() {
        NSRange range = Foundation.NSMakeRange(2, 2);
        NSIndexSet indexSet = NSIndexSet.alloc().initWithIndexesInRange(range);
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("A"),
                NSString.fromJavaString("B"),
                NSString.fromJavaString("C"),
                NSString.fromJavaString("D"),
                NSString.fromJavaString("E")
        });
        NSArray array = NSArray.arrayWithObjectsCount(arr, 5);
        NSArray array2 = array.objectsAtIndexes(indexSet);
        assertTrue(array2.getCount() == indexSet.getCount()
                && array2.objectAtIndex(0) == array.objectAtIndex(2)
                && array2.objectAtIndex(1) == array.objectAtIndex(3)
        );

    }
}
