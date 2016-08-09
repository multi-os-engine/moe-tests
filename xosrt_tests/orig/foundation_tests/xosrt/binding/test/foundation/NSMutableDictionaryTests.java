package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSMutableDictionaryTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testSetObject_forKey1() {
        NSMutableDictionary dictionary0 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary0.setObjectForKey(NSString.fromJavaString("string0"), NSString.fromJavaString("key0"));
        dictionary0.setObjectForKey(NSString.fromJavaString("string1"), NSString.fromJavaString("key1"));
        dictionary0.setObjectForKey(NSString.fromJavaString("string2"), NSString.fromJavaString("key2"));
        assertTrue (dictionary0.objectForKey(NSString.fromJavaString("key0")).isEqual(NSString.fromJavaString("string0"))
                && dictionary0.objectForKey(NSString.fromJavaString("key1")).isEqual(NSString.fromJavaString("string1"))
                && dictionary0.objectForKey(NSString.fromJavaString("key2")).isEqual(NSString.fromJavaString("string2"))
        );
    }

    @Test
    public void testRemoveObjectForKey1() {
        NSMutableDictionary dictionary1 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary1.setObjectForKey(NSString.fromJavaString("string0"), NSString.fromJavaString("key0"));
        dictionary1.setObjectForKey(NSString.fromJavaString("string1"), NSString.fromJavaString("key1"));
        dictionary1.setObjectForKey(NSString.fromJavaString("string2"), NSString.fromJavaString("key2"));
        dictionary1.removeObject(NSString.fromJavaString("key1"));
        assertTrue(dictionary1.getCount()== 2) ;
    }

    @Test
    public void testRemoveAllObjects1() {
        NSMutableDictionary dictionary2 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary2.setObjectForKey(NSString.fromJavaString("string0"), NSString.fromJavaString("key0"));
        dictionary2.setObjectForKey(NSString.fromJavaString("string1"), NSString.fromJavaString("key1"));
        dictionary2.setObjectForKey(NSString.fromJavaString("string2"), NSString.fromJavaString("key2"));
        dictionary2.removeAllObjects();
        assertTrue(dictionary2.getCount()== 0) ;
    }

    @Test
    public void testDictionaryWithCapacity1() {
        NSMutableDictionary dictionary3 = NSMutableDictionary.dictionaryWithCapacity(5);
        assertTrue (dictionary3 != null);
    }

    @Test
    public void testInitWithCapacity1() {
        NSMutableDictionary dictionary4 = NSMutableDictionary.alloc().initWithCapacity(5);
        assertTrue (dictionary4 != null);
    }

    @Test
    public void testSetValue_forKey1() {
        NSMutableDictionary dictionary5 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary5.setValueForKey(NSString.fromJavaString("string0"), NSString.fromJavaString("key0"));
        dictionary5.setValueForKey(NSString.fromJavaString("string1"), NSString.fromJavaString("key1"));
        dictionary5.setValueForKey(NSString.fromJavaString("string2"), NSString.fromJavaString("key2"));
        dictionary5.setValueForKey(null, NSString.fromJavaString("key2"));
        assertTrue(dictionary5.getCount()== 2 &&
                dictionary5.objectForKey(NSString.fromJavaString("key0")).isEqual(NSString.fromJavaString("string0"))
                && dictionary5.objectForKey(NSString.fromJavaString("key1")).isEqual(NSString.fromJavaString("string1"))
        );
    }

    @Test
    public void testAddEntriesFromDictionary1() {
        NSMutableDictionary dictionary6b = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary6b.setValueForKey(NSString.fromJavaString("string0"), NSString.fromJavaString("key0"));
        dictionary6b.setValueForKey(NSString.fromJavaString("string1"), NSString.fromJavaString("key1"));


        NSMutableDictionary dictionary6 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary6.setObjectForKey(NSString.fromJavaString("string3"), NSString.fromJavaString("key3"));
        dictionary6.setObjectForKey(NSString.fromJavaString("string4"), NSString.fromJavaString("key4"));
        dictionary6.setObjectForKey(NSString.fromJavaString("string0"), NSString.fromJavaString("key0"));

        dictionary6.addEntriesFromDictionary(dictionary6b);

        assertTrue(dictionary6.getCount()== 4) ;
    }

    @Test
    public void testRemoveObjectsForKeys1() {

        NSArray keys = NSArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("key3"),
                        NSString.fromJavaString("key4")
                }), 2);

        NSMutableDictionary dictionary8 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary8.setObjectForKey(NSString.fromJavaString("string3"), NSString.fromJavaString("key3"));
        dictionary8.setObjectForKey(NSString.fromJavaString("string4"), NSString.fromJavaString("key4"));
        dictionary8.setObjectForKey(NSString.fromJavaString("string0"), NSString.fromJavaString("key0"));
        dictionary8.setObjectForKey(NSString.fromJavaString("string1"), NSString.fromJavaString("key2"));


        dictionary8.removeObjectsForKeys(keys);

        assertTrue(dictionary8.getCount()== 2) ;
    }

    @Test
    public void testSetDictionary1() {
        NSMutableDictionary dictionary7b = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary7b.setValueForKey(NSString.fromJavaString("string0"), NSString.fromJavaString("key0"));
        dictionary7b.setValueForKey(NSString.fromJavaString("string1"), NSString.fromJavaString("key1"));


        NSMutableDictionary dictionary7 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary7.setObjectForKey(NSString.fromJavaString("string5"), NSString.fromJavaString("key5"));
        dictionary7.setObjectForKey(NSString.fromJavaString("string6"), NSString.fromJavaString("key6"));
        dictionary7.setObjectForKey(NSString.fromJavaString("string7"), NSString.fromJavaString("key7"));

        dictionary7.setDictionary(dictionary7b);

        assertTrue(dictionary7.getCount()== 2) ;
    }

    //TODO: varargs
    /*
    @Test
    public void testDictionaryWithObjectsAndKeys1() {
        NSObject object0 = NSObject.alloc().init();
        NSObject object1 = NSObject.alloc().init();
        NSMutableDictionary  dictionary0 = NSMutableDictionary.dictionaryWithObjectsAndKeys(
                object0,NSString.fromJavaString("key0"), object1,NSString.fromJavaString("key1"));
        assertTrue(dictionary0.objectForKey(NSString.fromJavaString("key0")) == object0
                && dictionary0.objectForKey(NSString.fromJavaString("key1")) == object1);
    }
    */

    @Test
    public void testCount1() {
        NSMutableDictionary  dictionary1 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("value0"),
                        NSString.fromJavaString("value1")
                }), 2),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[] {
                        NSString.fromJavaString("key0"),
                        NSString.fromJavaString("key1")
                }), 2)
        );
        assertTrue (dictionary1.getCount()== 2 && dictionary1.getCount()== 2) ;
    }

    @Test
    public void testObjectForKey1() {
        NSMutableDictionary  dictionary2 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        assertTrue (((NSString)dictionary2.objectForKey(NSString.fromJavaString("key1"))).isEqualToString(
                NSString.fromJavaString("value1"))
        );
    }

    @Test
    public void testDictionary1() {
        NSMutableDictionary  dictionary3 = (NSMutableDictionary)NSMutableDictionary.dictionary();
        assertTrue (dictionary3.getCount()== 0);
    }

    @Test
    public void testObjectEnumerator1() {
        NSMutableDictionary  dictionary4 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        while (null != (value = aEnumerator.nextObject())) {
            i++;
        }
        assertTrue (i == dictionary4.getCount());
    }

    @Test
    public void testDictionaryWithObject_forKey1() {
        NSMutableDictionary dictionary5 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectForKey(
                NSString.fromJavaString("value0"), NSString.fromJavaString("key0"));
        assertTrue (((NSString)dictionary5.objectForKey(NSString.fromJavaString("key0"))).isEqualToString(
                NSString.fromJavaString("value0"))
        );
    }

    @Test
    public void testAllKeys1() {
        NSMutableDictionary  dictionary6 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSString key0 = (NSString)array0.objectAtIndex(0);
        NSString key1 = (NSString)array0.objectAtIndex(1);
        NSString key2 = (NSString)array0.objectAtIndex(2);
        assertTrue (array0.containsObject(key0) && array0.containsObject(key1)
                && array0.containsObject(key2) && array0.getCount()== 3 );
    }

    @Test
    public void testAllValues1() {
        NSMutableDictionary  dictionary7 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        assertTrue (array1.getCount()== dictionary7.getCount());
    }

    @Test
    public void testValueForKey1() {
        NSMutableDictionary  dictionary9 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        assertTrue (((NSString)dictionary9.valueForKey(NSString.fromJavaString("key0"))).isEqualToString(
                NSString.fromJavaString("value0"))
        );
    }

    @Test
    public void testIsEqualToDictionary1() {
        NSMutableDictionary dictionary10 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary11 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary12 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary13 = (NSMutableDictionary)NSMutableDictionary.dictionary();
        NSMutableDictionary dictionary14 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary15 = null;
        assertTrue (dictionary10.isEqualToDictionary(dictionary11) && dictionary11.isEqualToDictionary(dictionary10)
                && dictionary10.isEqualToDictionary(dictionary12) && dictionary12.isEqualToDictionary(dictionary11)
                && !dictionary10.isEqualToDictionary(dictionary13) && !dictionary12.isEqualToDictionary(dictionary14)
                && !dictionary10.isEqualToDictionary(dictionary15) && !dictionary11.isEqualToDictionary(null)
                && dictionary10.isEqualToDictionary(dictionary10)
        );
    }

    @Test
    public void testIsEqual1() {
        NSMutableDictionary dictionary20 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary21 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary22 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary23 = (NSMutableDictionary)NSMutableDictionary.dictionary();
        NSMutableDictionary dictionary24 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary25 = null;
        assertTrue (dictionary20.isEqual(dictionary21) && dictionary21.isEqual(dictionary20)
                && dictionary20.isEqual(dictionary22) && dictionary22.isEqual(dictionary21)
                && !dictionary20.isEqual(dictionary23) && !dictionary22.isEqual(dictionary24)
                && !dictionary20.isEqual(dictionary25) && !dictionary21.isEqual(null)
                && dictionary20.isEqual(dictionary20)
        );
    }

    @Test
    public void testDictionaryWithDictionary1() {
        NSMutableDictionary dictionary20 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary26 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithDictionary(dictionary20);

        assertTrue (dictionary26 != null && dictionary26.getCount()== 3);
    }

    @Test
    public void testKeyEnumerator1() {
        NSMutableDictionary dictionary20 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSEnumerator enumerator = dictionary20.keyEnumerator();

        assertTrue (enumerator.getAllObjects().getCount() == dictionary20.getCount());
    }

    @Test
    public void testInitWithDictionary1() {
        NSMutableDictionary dictionary24 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary27 = (NSMutableDictionary)NSMutableDictionary.alloc().initWithDictionary(
                dictionary24);

        assertTrue (dictionary27 != null && dictionary27.getCount()== 3) ;
    }

    @Test
    public void testDictionaryWithObjects_forKeys1() {

        NSArray keys = NSArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2"),
                        NSString.fromJavaString("key3"),
                        NSString.fromJavaString("key4")
                }), 4);
        NSArray values = NSArray.arrayWithObjectsCount(
                new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2"),
                        NSString.fromJavaString("value3"),
                        NSString.fromJavaString("value4")
                }), 4);

        NSMutableDictionary dictionary28 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
                values, keys);

        assertTrue (dictionary28 != null && dictionary28.getCount()== 4) ;
    }

    @Test
    public void testDictionaryWithObjects_forKeys_count1() {
        IdArr<NSObject> keys = new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("key1"),
                        NSString.fromJavaString("key2")
                });
        IdArr<NSObject> values = new IdArr<NSObject>(new NSString[]{
                        NSString.fromJavaString("value1"),
                        NSString.fromJavaString("value2")
                });
        NSMutableDictionary dictionary29 = (NSMutableDictionary)NSMutableDictionary
                .dictionaryWithObjectsForKeysCount(values, keys, 2);
        assertTrue (dictionary29 != null && dictionary29.getCount()== 2);
    }

    //TODO: varargs
    /*
    @Test
    public void testInitWithObjectsAndKeys1() {
        NSMutableDictionary dict = NSMutableDictionary.alloc().initWithObjectsAndKeys(
                NSString.fromJavaString("value1"), NSString.fromJavaString("key1"),
                NSString.fromJavaString("value2"), NSString.fromJavaString("key2"));
        assertTrue (dict != null && dict.getCount()== 2);
    }
    */

    @Test
    public void testAllKeysForObject1() {
        NSMutableDictionary question = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
