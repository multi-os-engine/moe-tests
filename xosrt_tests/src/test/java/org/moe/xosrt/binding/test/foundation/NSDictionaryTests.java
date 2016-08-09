package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.ConstPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;
import ios.foundation.*;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSDictionaryTests extends XOSTest{

    @Test
    public void simpleStaticCreationTest() {
        NSDictionary testDict = NSDictionary.dictionary();
        assertNotNull(testDict);
    }


    @Test
    public void dictionaryWithObjectForKeyTest() {
        NSURL key = NSURL.URLWithString("/some/URL/String.key"); //something implements NSCopying
        NSURL value = NSURL.URLWithString("/some/URL/String.value");
        NSDictionary testDict = NSDictionary.dictionaryWithObjectForKey(value, key);
        assertNotNull(testDict);
    }

    @Test
    public void objectForKeyTest() {
        NSURL key = NSURL.URLWithString("/some/URL/String.key"); //something implements NSCopying
        NSURL value = NSURL.URLWithString("/some/URL/String.value");
        NSDictionary testDict = NSDictionary.dictionaryWithObjectForKey(value, key);
        assertEquals(value, testDict.objectForKey(key));
    }

    //TODO: varargs
    /*
    @Test
    public void testDictionaryWithObjectsAndKeys1() {
        NSObject object0 = NSObject.alloc().init();
        NSObject object1 = NSObject.alloc().init();
        NSDictionary  dictionary0 = NSDictionary.dictionaryWithObjectsAndKeys(
                object0, NSString.stringWithString("key0"),
                object1,NSString.stringWithString("key1")
        );
        assertTrue (dictionary0.objectForKey(NSString.stringWithString("key0")) == object0
                && dictionary0.objectForKey(NSString.stringWithString("key1")) == object1);
    }
    */

    @Test
    public void testCount1() {
        NSDictionary  dictionary1 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1")

                }), (long) 2),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1")
                }), (long)2)
        );
        assertTrue (dictionary1.count() == 2); //&& dictionary1.count == 2
    }

    @Test
    public void testObjectForKey1() {
        NSDictionary  dictionary2 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        assertTrue (((String)dictionary2.objectForKey("key1"))
                .equals("value1"));
    }

    @Test
    public void testDictionary1() {
        NSDictionary  dictionary3 = NSDictionary.dictionary();
        assertTrue (dictionary3.count() == 0);
    }

    @Test
    public void testObjectEnumerator1() {
        NSDictionary  dictionary4 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSEnumerator  aEnumerator = dictionary4.objectEnumerator();
        int i = 0;
        @SuppressWarnings("unused")
		Object value;
        while ((value = aEnumerator.nextObject()) != null) {
            i++;
        };
        assertTrue (i == dictionary4.count());
    }

    @Test
    public void testDictionaryWithObject_forKey1() {
        NSDictionary dictionary5 = NSDictionary.dictionaryWithObjectForKey(
                NSString.stringWithString("value0"), NSString.stringWithString("key0"));
        assertTrue (((String)dictionary5.objectForKey("key0"))
                .equals("value0"));
    }

    @Test
    public void testAllKeys1() {
        NSDictionary  dictionary6 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSArray  array0 = dictionary6.allKeys();
        String init0 = (String)array0.objectAtIndex(2);
        assertTrue (array0.count() == dictionary6.count() && init0.equals("key2"));
    }

    @Test
    public void testAllValues1() {
        NSDictionary  dictionary7 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSArray  array1 = dictionary7.allValues();
        String init0 = (String)array1.objectAtIndex(2);
        assertTrue(array1.count() == dictionary7.count() && init0.equals("value2"));
    }

    @Test
    public void testValueForKey1() {
        NSDictionary  dictionary9 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        assertTrue (((String)dictionary9.valueForKey("key0"))
                .equals("value0"));
    }

    @Test
    public void testIsEqualToDictionary1() {
        NSDictionary dictionary10 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSDictionary dictionary11 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSDictionary dictionary12 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSDictionary dictionary13 = NSDictionary.dictionary();
        NSDictionary dictionary14 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value4"),
                        NSString.stringWithString("value5"),
                        NSString.stringWithString("value6")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key4"),
                        NSString.stringWithString("key5"),
                        NSString.stringWithString("key6")
                }), 3)
        );
        NSDictionary dictionary15 = null;
        assertTrue (dictionary10.isEqualToDictionary(dictionary11) && dictionary11.isEqualToDictionary(dictionary10)
                && dictionary10.isEqualToDictionary(dictionary12) && dictionary12.isEqualToDictionary(dictionary11)
                && !dictionary10.isEqualToDictionary(dictionary13) && !dictionary12.isEqualToDictionary(dictionary14)
                && !dictionary10.isEqualToDictionary(dictionary15) && !dictionary11.isEqualToDictionary(null)
                && dictionary10.isEqualToDictionary(dictionary10));
    }

    @Test
    public void testIsEqual1() {
        NSDictionary dictionary20 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSDictionary dictionary21 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSDictionary dictionary22 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSDictionary dictionary23 = NSDictionary.dictionary();
        NSDictionary dictionary24 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value4"),
                        NSString.stringWithString("value5"),
                        NSString.stringWithString("value6")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key4"),
                        NSString.stringWithString("key5"),
                        NSString.stringWithString("key6")
                }), 3)
        );
        NSDictionary dictionary25 = null;
        assertTrue (dictionary20.isEqual(dictionary21) && dictionary21.isEqual(dictionary20)
                && dictionary20.isEqual(dictionary22) && dictionary22.isEqual(dictionary21)
                && !dictionary20.isEqual(dictionary23) && !dictionary22.isEqual(dictionary24)
                && !dictionary20.isEqual(dictionary25) && !dictionary21.isEqual(null)
                && dictionary20.isEqual(dictionary20));
    }

    @Test
    public void testDictionaryWithDictionary1() {
        NSDictionary dictionary20 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSDictionary dictionary26 = NSDictionary.dictionaryWithDictionary(dictionary20);

        assertTrue (dictionary26 != null && dictionary26.count() == 3);
    }

    @Test
    public void testKeyEnumerator1() {
        NSDictionary dictionary20 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                }), 3)
        );
        NSDictionary dictionary26 = NSDictionary.dictionaryWithDictionary(dictionary20);
        NSEnumerator enumerator = dictionary26.keyEnumerator();

        assertTrue (enumerator.allObjects().count() == dictionary26.count());
    }

    @Test
    public void testInitWithDictionary1() {
        NSDictionary dictionary24 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value4"),
                        NSString.stringWithString("value5"),
                        NSString.stringWithString("value6")
                }), 3),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key4"),
                        NSString.stringWithString("key5"),
                        NSString.stringWithString("key6")
                }), 3)
        );
        NSDictionary dictionary27 = NSDictionary.alloc().initWithDictionary(dictionary24);

        assertTrue (dictionary27 != null && dictionary27.count() == 3);
    }

    @Test
    public void testDictionaryWithObjects_forKeys1() {
        Ptr<NSString> arr = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("key1"),
                NSString.stringWithString("key2"),
                NSString.stringWithString("key3"),
                NSString.stringWithString("key4")
        });
        Ptr<NSString> arr2 = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("value1"),
                NSString.stringWithString("value2"),
                NSString.stringWithString("value3"),
                NSString.stringWithString("value4")
        });
        NSArray keys = NSArray.arrayWithObjectsCount(arr, 4);
        NSArray values = NSArray.arrayWithObjectsCount(arr2, 4);

        NSDictionary dictionary28 = NSDictionary.dictionaryWithObjectsForKeys(values, keys);

        assertTrue (dictionary28 != null && dictionary28.count() == 4);
    }

    @Test
    public void testDictionaryWithObjects_forKeys_count1() {
        Ptr keysArray = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("key1"),
                NSString.stringWithString("key2")
        });
        Ptr<NSString> valuesArray = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                NSString.stringWithString("value1"),
                NSString.stringWithString("value2")
        });
        NSDictionary dictionary29 = NSDictionary.dictionaryWithObjectsForKeysCount(valuesArray, (ConstPtr)keysArray, 2);
        assertTrue (dictionary29 != null && dictionary29.count() == 2);
    }

    //TODO: varargs
    /*
    @Test
    public void testInitWithObjectsAndKeys1() {
        NSDictionary dict = NSDictionary.alloc().initWithObjectsAndKeys(
                NSString.stringWithString("value1"), NSString.stringWithString("key1"),
                NSString.stringWithString("value2"), NSString.stringWithString("key2"));
        assertTrue (dict != null && dict.count() == 2);
    }
    */

    @Test
    public void testAllKeysForObject1() {
        NSDictionary question = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("QuestionType"),
                        NSString.stringWithString("Answer")
                }), 2),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("0"),
                        NSString.stringWithString("1")
                }), 2)
        );
        NSArray keyArray = question.allKeysForObject(NSString.stringWithString("QuestionType"));
        assertTrue (keyArray != null && keyArray.count() == 1);
    }

}
