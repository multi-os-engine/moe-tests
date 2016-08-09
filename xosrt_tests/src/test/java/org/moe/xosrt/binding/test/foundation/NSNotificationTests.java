package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.NSObject;
import ios.foundation.NSDictionary;
import ios.foundation.NSNotification;
import ios.foundation.NSString;

import org.junit.Test;

public class NSNotificationTests {

    NSObject notiMsg = NSString.stringWithString("My Message Notification");
    String notiName = "TestNotification";
    NSObject userState = NSString.stringWithString("Active");
    NSDictionary userInfo = NSDictionary.dictionaryWithObjectForKey(userState, NSString.stringWithString("state"));

    @Test
    public void testNotificationWithName1() {
        NSNotification  notification = NSNotification.notificationWithNameObjectUserInfo(
                notiName, notiMsg, userInfo);
        assertTrue(notification != null);
    }

    @Test
    public void testName1() {
        NSNotification  notification = NSNotification.notificationWithNameObjectUserInfo(
                notiName, notiMsg, userInfo);
        assertTrue (notification.name().equals("TestNotification"));
    }

    @Test
    public void testObject1() {
        NSNotification  notification = NSNotification.notificationWithNameObjectUserInfo(
                notiName, notiMsg, userInfo);
        assertTrue (notification.object() != null);
    }

    @Test
    public void testUserInfo1() {
        NSNotification  notification = NSNotification.notificationWithNameObjectUserInfo(
                notiName, notiMsg, userInfo);
        NSDictionary  ui = notification.userInfo();

        String obj = (String)ui.objectForKey("state");

        assertTrue (ui.count() > 0 );
        assertEquals(obj, userState.toString());
    }
}
