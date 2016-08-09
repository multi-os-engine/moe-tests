package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.*;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSExceptionTests extends XOSTest{

    @Test
    public void testInitWithName_reason_userInfo1() {
        NSException exception0 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                "name0", "reason0", null);
        assertTrue (exception0 != null);
    }

    @Test
    public void testName1() {
        NSException exception1 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                "name1", null, null);
        assertTrue (NSString.stringWithString(exception1.name()).isEqualToString("name1"));
    }

    @Test
    public void testReason1() {
        NSException exception2 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                null, "reason2", null);
        assertTrue (NSString.stringWithString(exception2.reason()).isEqualToString("reason2"));
    }

    @Test
    public void testUserInfo1() {
        NSDictionary userInfo0 = NSDictionary.dictionary();
        NSException exception3 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                null, null, userInfo0);
        assertTrue (exception3.userInfo() == userInfo0);
    }

    @Test
    public void testExceptionWithName_reason_userInfo1() {
        NSDictionary userInfo1 = NSDictionary.dictionary();
        NSException exception4 = NSException.exceptionWithNameReasonUserInfo(
                "name4", "reason4", userInfo1);
        assertTrue (NSString.stringWithString(exception4.name()).isEqualToString("name4")
                && NSString.stringWithString(exception4.reason()).isEqualToString("reason4")
                && exception4.userInfo() == userInfo1);
    }

    @Test
    public void testRaise1() {
        boolean raiseFlag0 = false;
        NSException exception5 = (NSException)NSException.alloc().initWithNameReasonUserInfo(
                "name5", "reason5", null);
        try {
            exception5.raise();
        } catch (Throwable exception) {
            raiseFlag0 = true;
        }
        assertTrue(raiseFlag0);
    }

    @Test
    public void testRaise_format1() {
        boolean raiseFlag1 = false;
        try {
            NSException.raiseFormatArguments("name6", "reason6", null);
        } catch (Throwable exception) {
            raiseFlag1 = exception.getMessage().contains("reason6");
        }
        assertTrue (raiseFlag1);
    }


}
