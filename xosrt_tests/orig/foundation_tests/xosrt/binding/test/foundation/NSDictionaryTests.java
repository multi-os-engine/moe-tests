package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSDictionaryTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void simpleStaticCreationTest() {
        NSDictionary testDict = NSDictionary.dictionary();
        assertNotNull(testDict);
    }


    @Test
    public void dictionaryWithObjectForKeyTest() {
        NSURL key = NSURL.URLWithString(NSString.fromJavaString("/some/URL/String.key")); //something implements NSCopying
        NSURL value = NSURL.URLWithString(NSString.fromJavaString("/some/URL/String.value"));
        NSDictionary testDict = NSDictionary.dictionaryWithObjectForKey(value, key);
        assertNotNull(testDict);
    }

    @Test
    public void objectForKeyTest() {
        NSURL key = NSURL.URLWithString(NSString.fromJavaString("/some/URL/String.key")); //something implements NSCopying
        NSURL value = NSURL.URLWithString(NSString.fromJavaString("/some/URL/String.value"));
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
                object0, NSString.fromJavaString("key0"),
                object1,NSString.fromJavaString("key1")
        );
        assertTrue (dictionary0.objectForKey(NSString.fromJavaString("key0")) == object0
                && dictionary0.objectForKey(NSString.fromJavaString("key1")) == object1);
    }
    */

    @Test
    public void testCount1() {
        NSDictionary  dictionary1 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1")

                }), 2),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1")
                }), 2)
        );
        assertTrue (dictionary1.getCount() == 2); //&& dictionary1.count == 2
    }

    @Test
    public void testObjectForKey1() {
        NSDictionary  dictionary2 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        assertTrue (((NSString)dictionary2.objectForKey(NSString.fromJavaString("key1")))
                .isEqualToString(NSString.fromJavaString("value1")));
    }

    @Test
    public void testDictionary1() {
        NSDictionary  dictionary3 = NSDictionary.dictionary();
        assertTrue (dictionary3.getCount() == 0);
    }

    @Test
    public void testObjectEnumerator1() {
        NSDictionary  dictionary4 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSEnumerator  aEnumerator = dictionary4.objectEnumerator();
        int i = 0;
        NSObject value;
        while ((value = aEnumerator.nextObject()) != null) {
            i++;
        };
        assertTrue (i == dictionary4.getCount());
    }

    @Test
    public void testDictionaryWithObject_forKey1() {
        NSDictionary dictionary5 = NSDictionary.dictionaryWithObjectForKey(
                NSString.fromJavaString("value0"), NSString.fromJavaString("key0"));
        assertTrue (((NSString)dictionary5.objectForKey(NSString.fromJavaString("key0")))
                .isEqualToString(NSString.fromJavaString("value0")));
    }

    @Test
    public void testAllKeys1() {
        NSDictionary  dictionary6 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSArray  array0 = dictionary6.getAllKeys();
        NSString init0 = (NSString)array0.objectAtIndex(0);
        assertTrue (array0.getCount() == dictionary6.getCount() && init0.isEqual(NSString.fromJavaString("key2")));
    }

    @Test
    public void testAllValues1() {
        NSDictionary  dictionary7 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSArray  array1 = dictionary7.getAllValues();
        NSString init0 = (NSString)array1.objectAtIndex(0);
        assertTrue(array1.getCount() == dictionary7.getCount() && init0.isEqual(NSString.fromJavaString("value2")));
    }

    @Test
    public void testValueForKey1() {
        NSDictionary  dictionary9 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        assertTrue (((NSString)dictionary9.valueForKey(NSString.fromJavaString("key0")))
                .isEqualToString(NSString.fromJavaString("value0")));
    }

    @Test
    public void testIsEqualToDictionary1() {
        NSDictionary dictionary10 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSDictionary dictionary11 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSDictionary dictionary12 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSDictionary dictionary13 = NSDictionary.dictionary();
        NSDictionary dictionary14 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value4"),
                        NSString.fromJavaString("value5"),
                        NSString.fromJavaString("value6")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key4"),
                        NSString.fromJavaString("key5"),
                        NSString.fromJavaString("key6")
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
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSDictionary dictionary21 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSDictionary dictionary22 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSDictionary dictionary23 = NSDictionary.dictionary();
        NSDictionary dictionary24 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value4"),
                        NSString.fromJavaString("value5"),
                        NSString.fromJavaString("value6")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key4"),
                        NSString.fromJavaString("key5"),
                        NSString.fromJavaString("key6")
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
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSDictionary dictionary26 = NSDictionary.dictionaryWithDictionary(dictionary20);

        assertTrue (dictionary26 != null && dictionary26.getCount() == 3);
    }

    @Test
    public void testKeyEnumerator1() {
        NSDictionary dictionary20 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                }), 3)
        );
        NSDictionary dictionary26 = NSDictionary.dictionaryWithDictionary(dictionary20);
        NSEnumerator enumerator = dictionary26.keyEnumerator();

        assertTrue (enumerator.getAllObjects().getCount() == dictionary26.getCount());
    }

    @Test
    public void testInitWithDictionary1() {
        NSDictionary dictionary24 = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value4"),
                        NSString.fromJavaString("value5"),
                        NSString.fromJavaString("value6")
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key4"),
                        NSString.fromJavaString("key5"),
                        NSString.fromJavaString("key6")
                }), 3)
        );
        NSDictionary dictionary27 = NSDictionary.alloc().initWithDictionary(dictionary24);

        assertTrue (dictionary27 != null && dictionary27.getCount() == 3);
    }

    @Test
    public void testDictionaryWithObjects_forKeys1() {
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("key1"),
                NSString.fromJavaString("key2"),
                NSString.fromJavaString("key3"),
                NSString.fromJavaString("key4")
        });
        IdArr<NSObject> arr2 = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("value1"),
                NSString.fromJavaString("value2"),
                NSString.fromJavaString("value3"),
                NSString.fromJavaString("value4")
        });
        NSArray keys = NSArray.arrayWithObjectsCount(arr, 4);
        NSArray values = NSArray.arrayWithObjectsCount(arr2, 4);

        NSDictionary dictionary28 = NSDictionary.dictionaryWithObjectsForKeys(values, keys);

        assertTrue (dictionary28 != null && dictionary28.getCount() == 4);
    }

    @Test
    public void testDictionaryWithObjects_forKeys_count1() {
        IdArr<NSObject> keysArray = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("key1"),
                NSString.fromJavaString("key2")
        });
        IdArr<NSObject> valuesArray = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("value1"),
                NSString.fromJavaString("value2")
        });
        NSDictionary dictionary29 = NSDictionary.dictionaryWithObjectsForKeysCount(valuesArray, keysArray, 2);
        assertTrue (dictionary29 != null && dictionary29.getCount() == 2);
    }

    //TODO: varargs
    /*
    @Test
    public void testInitWithObjectsAndKeys1() {
        NSDictionary dict = NSDictionary.alloc().initWithObjectsAndKeys(
                NSString.fromJavaString("value1"), NSString.fromJavaString("key1"),
                NSString.fromJavaString("value2"), NSString.fromJavaString("key2"));
        assertTrue (dict != null && dict.getCount() == 2);
    }
    */

    @Test
    public void testAllKeysForObject1() {
        NSDictionary question = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("QuestionType"),
                        NSString.fromJavaString("Answer")
                }), 2),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("0"),
                        NSString.fromJavaString("1")
                }), 2)
        );
        NSArray keyArray = question.allKeysForObject(NSString.fromJavaString("QuestionType"));
        assertTrue (keyArray != null && keyArray.getCount() == 1);
    }

}
