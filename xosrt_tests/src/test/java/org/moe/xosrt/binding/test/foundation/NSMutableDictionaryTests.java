package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.ConstPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;
import ios.foundation.*;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSMutableDictionaryTests extends XOSTest {

    @Test
    public void testSetObject_forKey1() {
        NSMutableDictionary dictionary0 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary0.setObjectForKey(NSString.stringWithString("string0"), NSString.stringWithString("key0"));
        dictionary0.setObjectForKey(NSString.stringWithString("string1"), NSString.stringWithString("key1"));
        dictionary0.setObjectForKey(NSString.stringWithString("string2"), NSString.stringWithString("key2"));
        assertTrue (NSString.stringWithString("string0").isEqual(dictionary0.objectForKey(NSString.stringWithString("key0")))
                && NSString.stringWithString("string1").isEqual(dictionary0.objectForKey(NSString.stringWithString("key1")))
                && NSString.stringWithString("string2").isEqual(dictionary0.objectForKey(NSString.stringWithString("key2")))
        );
    }

    @Test
    public void testRemoveObjectForKey1() {
        NSMutableDictionary dictionary1 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary1.setObjectForKey(NSString.stringWithString("string0"), NSString.stringWithString("key0"));
        dictionary1.setObjectForKey(NSString.stringWithString("string1"), NSString.stringWithString("key1"));
        dictionary1.setObjectForKey(NSString.stringWithString("string2"), NSString.stringWithString("key2"));
        dictionary1.removeObjectForKey(NSString.stringWithString("key1"));
        assertTrue(dictionary1.count()== 2) ;
    }

    @Test
    public void testRemoveAllObjects1() {
        NSMutableDictionary dictionary2 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary2.setObjectForKey(NSString.stringWithString("string0"), NSString.stringWithString("key0"));
        dictionary2.setObjectForKey(NSString.stringWithString("string1"), NSString.stringWithString("key1"));
        dictionary2.setObjectForKey(NSString.stringWithString("string2"), NSString.stringWithString("key2"));
        dictionary2.removeAllObjects();
        assertTrue(dictionary2.count()== 0) ;
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
        dictionary5.setValueForKey("string0", "key0");
        dictionary5.setValueForKey("string1", "key1");
        dictionary5.setValueForKey("string2", "key2");
        dictionary5.setValueForKey(null, "key2");
        assertTrue(dictionary5.count()== 2 &&
                dictionary5.objectForKey(NSString.stringWithString("key0")).equals("string0")
                && dictionary5.objectForKey(NSString.stringWithString("key1")).equals("string1")
        );
    }

    @Test
    public void testAddEntriesFromDictionary1() {
        NSMutableDictionary dictionary6b = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary6b.setValueForKey("string0", "key0");
        dictionary6b.setValueForKey("string1", "key1");


        NSMutableDictionary dictionary6 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary6.setObjectForKey(NSString.stringWithString("string3"), NSString.stringWithString("key3"));
        dictionary6.setObjectForKey(NSString.stringWithString("string4"), NSString.stringWithString("key4"));
        dictionary6.setObjectForKey(NSString.stringWithString("string0"), NSString.stringWithString("key0"));

        dictionary6.addEntriesFromDictionary(dictionary6b);

        assertTrue(dictionary6.count()== 4) ;
    }

    @Test
    public void testRemoveObjectsForKeys1() {

        NSArray keys = NSArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        NSString.stringWithString("key3"),
                        NSString.stringWithString("key4")
                }), 2);

        NSMutableDictionary dictionary8 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary8.setObjectForKey(NSString.stringWithString("string3"), NSString.stringWithString("key3"));
        dictionary8.setObjectForKey(NSString.stringWithString("string4"), NSString.stringWithString("key4"));
        dictionary8.setObjectForKey(NSString.stringWithString("string0"), NSString.stringWithString("key0"));
        dictionary8.setObjectForKey(NSString.stringWithString("string1"), NSString.stringWithString("key2"));


        dictionary8.removeObjectsForKeys(keys);

        assertTrue(dictionary8.count()== 2) ;
    }

    @Test
    public void testSetDictionary1() {
        NSMutableDictionary dictionary7b = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary7b.setValueForKey("string0", "key0");
        dictionary7b.setValueForKey("string1", "key1");


        NSMutableDictionary dictionary7 = (NSMutableDictionary)NSMutableDictionary.alloc().init();
        dictionary7.setObjectForKey(NSString.stringWithString("string5"), NSString.stringWithString("key5"));
        dictionary7.setObjectForKey(NSString.stringWithString("string6"), NSString.stringWithString("key6"));
        dictionary7.setObjectForKey(NSString.stringWithString("string7"), NSString.stringWithString("key7"));

        dictionary7.setDictionary(dictionary7b);

        assertTrue(dictionary7.count()== 2) ;
    }

    //TODO: varargs
    /*
    @Test
    public void testDictionaryWithObjectsAndKeys1() {
        NSObject object0 = NSObject.alloc().init();
        NSObject object1 = NSObject.alloc().init();
        NSMutableDictionary  dictionary0 = NSMutableDictionary.dictionaryWithObjectsAndKeys(
                object0,NSString.stringWithString("key0"), object1,NSString.stringWithString("key1"));
        assertTrue(dictionary0.objectForKey(NSString.stringWithString("key0")) == object0
                && dictionary0.objectForKey(NSString.stringWithString("key1")) == object1);
    }
    */

    @Test
    public void testCount1() {
        NSMutableDictionary  dictionary1 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value0"),
                        NSString.stringWithString("value1")
                }), 2),
                NSArray.arrayWithObjectsCount(PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key0"),
                        NSString.stringWithString("key1")
                }), 2)
        );
        assertTrue (dictionary1.count()== 2 && dictionary1.count()== 2) ;
    }

    @Test
    public void testObjectForKey1() {
        NSMutableDictionary  dictionary2 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        assertTrue (((String)dictionary2.objectForKey(NSString.stringWithString("key1"))).equals("value1"));
    }

    @Test
    public void testDictionary1() {
        NSMutableDictionary  dictionary3 = (NSMutableDictionary)NSMutableDictionary.dictionary();
        assertTrue (dictionary3.count()== 0);
    }

    @Test
    public void testObjectEnumerator1() {
        NSMutableDictionary  dictionary4 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        while (null != (value = aEnumerator.nextObject())) {
            i++;
        }
        assertTrue (i == dictionary4.count());
    }

    @Test
    public void testDictionaryWithObject_forKey1() {
        NSMutableDictionary dictionary5 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectForKey(
                NSString.stringWithString("value0"), NSString.stringWithString("key0"));
        assertTrue (((String)dictionary5.objectForKey(NSString.stringWithString("key0"))).equals("value0"));
    }

    @Test
    public void testAllKeys1() {
        NSMutableDictionary  dictionary6 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        String key0 = (String)array0.objectAtIndex(0);
        String key1 = (String)array0.objectAtIndex(1);
        String key2 = (String)array0.objectAtIndex(2);
        assertTrue (array0.containsObject(key0) && array0.containsObject(key1)
                && array0.containsObject(key2) && array0.count()== 3 );
    }

    @Test
    public void testAllValues1() {
        NSMutableDictionary  dictionary7 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        assertTrue (array1.count()== dictionary7.count());
    }

    @Test
    public void testValueForKey1() {
        NSMutableDictionary  dictionary9 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        assertTrue (((String)dictionary9.valueForKey("key0")).equals("value0"));
    }

    @Test
    public void testIsEqualToDictionary1() {
        NSMutableDictionary dictionary10 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary11 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary12 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary13 = (NSMutableDictionary)NSMutableDictionary.dictionary();
        NSMutableDictionary dictionary14 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary21 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary22 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary23 = (NSMutableDictionary)NSMutableDictionary.dictionary();
        NSMutableDictionary dictionary24 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary26 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithDictionary(dictionary20);

        assertTrue (dictionary26 != null && dictionary26.count()== 3);
    }

    @Test
    public void testKeyEnumerator1() {
        NSMutableDictionary dictionary20 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSEnumerator enumerator = dictionary20.keyEnumerator();

        assertTrue (enumerator.allObjects().count() == dictionary20.count());
    }

    @Test
    public void testInitWithDictionary1() {
        NSMutableDictionary dictionary24 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
        NSMutableDictionary dictionary27 = (NSMutableDictionary)NSMutableDictionary.alloc().initWithDictionary(
                dictionary24);

        assertTrue (dictionary27 != null && dictionary27.count()== 3) ;
    }

    @Test
    public void testDictionaryWithObjects_forKeys1() {

        NSArray keys = NSArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2"),
                        NSString.stringWithString("key3"),
                        NSString.stringWithString("key4")
                }), 4);
        NSArray values = NSArray.arrayWithObjectsCount(
                PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2"),
                        NSString.stringWithString("value3"),
                        NSString.stringWithString("value4")
                }), 4);

        NSMutableDictionary dictionary28 = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
                values, keys);

        assertTrue (dictionary28 != null && dictionary28.count()== 4) ;
    }

    @Test
    public void testDictionaryWithObjects_forKeys_count1() {
        Ptr keys = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("key1"),
                        NSString.stringWithString("key2")
                });
        Ptr<NSString> values = PtrFactory.newObjectArray(NSString.class, new NSString[] {
                        NSString.stringWithString("value1"),
                        NSString.stringWithString("value2")
                });
        NSMutableDictionary dictionary29 = (NSMutableDictionary)NSMutableDictionary
                .dictionaryWithObjectsForKeysCount(values, (ConstPtr)keys, 2);
        assertTrue (dictionary29 != null && dictionary29.count()== 2);
    }

    //TODO: varargs
    /*
    @Test
    public void testInitWithObjectsAndKeys1() {
        NSMutableDictionary dict = NSMutableDictionary.alloc().initWithObjectsAndKeys(
                NSString.stringWithString("value1"), NSString.stringWithString("key1"),
                NSString.stringWithString("value2"), NSString.stringWithString("key2"));
        assertTrue (dict != null && dict.count()== 2);
    }
    */

    @Test
    public void testAllKeysForObject1() {
        NSMutableDictionary question = (NSMutableDictionary)NSMutableDictionary.dictionaryWithObjectsForKeys(
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
