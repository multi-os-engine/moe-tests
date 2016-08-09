package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;

import ios.foundation.*;
import org.moe.xosrt.binding.test.foundation.Utils.ErrorTestObject;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Before;
import org.junit.Test;

public class NSErrorTests extends XOSTest {

    NSError anError;
    NSDictionary aDictionary;

    @Before
    public void initTests() {
        ErrorTestObject arg1 = ErrorTestObject.alloc().init();
        arg1.setMyNumber(1);
        arg1.setMyString(NSString.stringWithString("one"));
        ErrorTestObject arg2 = ErrorTestObject.alloc().init();
        arg2.setMyNumber(2);
        arg2.setMyString(NSString.stringWithString("two"));
        ErrorTestObject arg3 = ErrorTestObject.alloc().init();
        arg3.setMyNumber(3);
        arg3.setMyString(NSString.stringWithString("three"));

        aDictionary = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount((Ptr)PtrFactory.newObjectArray(ErrorTestObject.class, new ErrorTestObject[]{
                        arg1,
                        arg2,
                        arg3
                }), 3),
                NSArray.arrayWithObjectsCount((Ptr)PtrFactory.newObjectArray(NSString.class, new NSString[]{
                        arg1.myString(),
                        arg2.myString(),
                        arg3.myString()
                }), 3)
        );

        anError = NSError.errorWithDomainCodeUserInfo("some error", 3, aDictionary);
    }

    @Test
    public void testErrorWithDomain_code_userInfo1() {
        assertTrue(anError != null);
    }

    @Test
    public void testCode1() {
        assertTrue (anError.code() == 3);
    }

    @Test
    public void testUserInfo1() {
        NSDictionary  aDictionary1 = anError.userInfo();
        assertTrue (aDictionary1.count() == aDictionary.count());
    }

    @Test
    public void testDomain1() {
        ErrorTestObject arg1 = ErrorTestObject.alloc().init();
        arg1.setMyNumber(1);
        arg1.setMyString(NSString.stringWithString("some error"));
        assertTrue (NSString.stringWithString(anError.domain()).isEqualToString(arg1.myString().toString()));
    }

    @Test
    public void testLocalizedDescription1() {
        NSString someString = NSString.stringWithString(anError.localizedDescription());
        assertTrue (someString.isEqual("The operation couldn’t be completed. (some error error 3.)"));
    }

}
