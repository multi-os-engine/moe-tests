package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.core.NativeException;
import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSExceptionTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInitWithName_reason_userInfo1() {
        NSException exception0 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                NSString.fromJavaString("name0"), NSString.fromJavaString("reason0"), null);
        assertTrue (exception0 != null);
    }

    @Test
    public void testName1() {
        NSException exception1 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                NSString.fromJavaString("name1"), null, null);
        assertTrue (exception1.getName().isEqualToString(NSString.fromJavaString("name1")));
    }

    @Test
    public void testReason1() {
        NSException exception2 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                null, NSString.fromJavaString("reason2"), null);
        assertTrue (exception2.getReason().isEqualToString(NSString.fromJavaString("reason2")));
    }

    @Test
    public void testUserInfo1() {
        NSDictionary userInfo0 = NSDictionary.dictionary();
        NSException exception3 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                null, null, userInfo0);
        assertTrue (exception3.getUserInfo() == userInfo0);
    }

    @Test
    public void testExceptionWithName_reason_userInfo1() {
        NSDictionary userInfo1 = NSDictionary.dictionary();
        NSException exception4 = NSException.exceptionWithNameReasonUserInfo(
                NSString.fromJavaString("name4"), NSString.fromJavaString("reason4"), userInfo1);
        assertTrue (exception4.getName().isEqualToString(NSString.fromJavaString("name4"))
                && exception4.getReason().isEqualToString(NSString.fromJavaString("reason4"))
                && exception4.getUserInfo() == userInfo1);
    }

    @Test
    public void testRaise1() {
        boolean raiseFlag0 = false;
        NSException exception5 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                NSString.fromJavaString("name5"), NSString.fromJavaString("reason5"), null);
        try {
            exception5.raise();
        } catch (Exception exception) {
            raiseFlag0 = true;
        }
        assertTrue(raiseFlag0);
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testRaise_format1() {
        boolean raiseFlag1 = false;
        try {
            NSException.raiseFormat(NSString.fromJavaString("name6"), NSString.fromJavaString("reason6"));
        } catch (NativeException exception) {
            raiseFlag1 = exception.getMessage().contains("name6")
                    && exception.getMessage().contains("reason6");
        }
        assertTrue (raiseFlag1);
    }
    */

}
