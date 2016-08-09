package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.*;
import xosrt.binding.test.foundation.Utils.ErrorTestObject;
import xosrt.binding.test.foundation.Utils.TestObject;
import org.junit.Before;
import org.junit.Test;

public class NSErrorTests {

    NSError anError;
    NSDictionary aDictionary;

    static {
        System.loadLibrary("Mac");
    }

    @Before
    public void initTests() {
        ErrorTestObject arg1 = ErrorTestObject.alloc().init();
        arg1.setMyNumber(1);
        arg1.setMyString(NSString.fromJavaString("one"));
        ErrorTestObject arg2 = ErrorTestObject.alloc().init();
        arg2.setMyNumber(2);
        arg2.setMyString(NSString.fromJavaString("two"));
        ErrorTestObject arg3 = ErrorTestObject.alloc().init();
        arg3.setMyNumber(3);
        arg3.setMyString(NSString.fromJavaString("three"));

        aDictionary = NSDictionary.dictionaryWithObjectsForKeys(
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new ErrorTestObject[]{
                        arg1,
                        arg2,
                        arg3
                }), 3),
                NSArray.arrayWithObjectsCount(new IdArr<NSObject>(new NSString[]{
                        arg1.myString(),
                        arg2.myString(),
                        arg3.myString()
                }), 3)
        );

        anError = NSError.errorWithDomainCodeUserInfo(NSString.fromJavaString("some error"), 3, aDictionary);
    }

    @Test
    public void testErrorWithDomain_code_userInfo1() {
        assertTrue(anError != null);
    }

    @Test
    public void testCode1() {
        assertTrue (anError.getCode() == 3);
    }

    @Test
    public void testUserInfo1() {
        NSDictionary  aDictionary1 = anError.getUserInfo();
        assertTrue (aDictionary1.getCount() == aDictionary.getCount());
    }

    @Test
    public void testDomain1() {
        ErrorTestObject arg1 = ErrorTestObject.alloc().init();
        arg1.setMyNumber(1);
        arg1.setMyString(NSString.fromJavaString("some error"));
        assertTrue (anError.getDomain().isEqualToString(arg1.myString())) ;
    }

    @Test
    public void testLocalizedDescription1() {
        NSString someString = anError.getLocalizedDescription();
        assertTrue (someString.isEqualToString(
                NSString.fromJavaString("The operation couldn't be completed. (some error error 3.)")));
    }

}
