package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSNotificationTests {

    static {
        System.loadLibrary("Mac");
    }

    NSObject notiMsg = NSString.fromJavaString("My Message Notification");
    NSString notiName = NSString.fromJavaString("TestNotification");
    NSObject userState = NSString.fromJavaString("Active");
    NSDictionary userInfo = NSDictionary.dictionaryWithObjectForKey(userState, NSString.fromJavaString("state"));

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
        assertTrue (notification.getName().isEqualToString(NSString.fromJavaString("TestNotification")));
    }

    @Test
    public void testObject1() {
        NSNotification  notification = NSNotification.notificationWithNameObjectUserInfo(
                notiName, notiMsg, userInfo);
        assertTrue (notification.getObject() != null);
    }

    @Test
    public void testUserInfo1() {
        NSNotification  notification = NSNotification.notificationWithNameObjectUserInfo(
                notiName, notiMsg, userInfo);
        NSDictionary  ui = notification.getUserInfo();

        ui.objectForKey(NSString.fromJavaString("state"));

        assertTrue (ui.getCount() > 0 && ui.objectForKey(NSString.fromJavaString("state")).isEqual(userState));
    }
}
