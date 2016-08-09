package org.moe.xosrt.binding.test.uikit.testhelpers;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.ByValue;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

import ios.NSObject;
import ios.coregraphics.struct.CGRect;
import ios.foundation.NSArray;
import ios.foundation.NSCoder;
import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSError;
import ios.foundation.NSURL;
import ios.foundation.NSUserActivity;
import ios.uikit.UIApplication;
import ios.uikit.UILocalNotification;
import ios.uikit.UIScreen;
import ios.uikit.UIUserNotificationSettings;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;

public class TestAppDelegate extends NSObject implements UIApplicationDelegate {

    UIWindow window;
    private static UIViewController controller = null;
    private static Object sem = new Object();

    public static boolean testWillResignActive = false;
    public static boolean testDidEnterBackground = false;
    public static boolean testWillEnterForeground = false;
    public static boolean testDidBecomeActive = false;
    public static boolean testWillTerminate = false;

    public static void setController(UIViewController cont) {
        try {
            synchronized (sem) {
                while (controller != null) sem.wait();
                controller = cont;
                //sem.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    static {
        NatJ.register();
    }

    protected TestAppDelegate(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native TestAppDelegate alloc();

    @Selector("init")
    public native TestAppDelegate init();

    @Override
    public boolean applicationContinueUserActivityRestorationHandler(UIApplication uiApplication, NSUserActivity nsUserActivity, @ObjCBlock(name = "call_applicationContinueUserActivityRestorationHandler") Block_applicationContinueUserActivityRestorationHandler block_applicationContinueUserActivityRestorationHandler) {
        return false;
    }

    @Override
    public void applicationDidChangeStatusBarFrame(UIApplication uiApplication, @ByValue CGRect cgRect) {

    }

    @Override
    public void applicationDidChangeStatusBarOrientation(UIApplication uiApplication, @NInt long l) {

    }

    @Override
    public void applicationDidDecodeRestorableStateWithCoder(UIApplication uiApplication, NSCoder nsCoder) {

    }

    @Override
    public void applicationDidFailToContinueUserActivityWithTypeError(UIApplication uiApplication, String s, NSError nsError) {

    }

    @Override
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(UIApplication uiApplication, NSError nsError) {

    }

    @Selector("application:didFinishLaunchingWithOptions:")
    @Override
    public boolean applicationDidFinishLaunchingWithOptions(UIApplication uiApplication, NSDictionary nsDictionary) {

        window = (UIWindow) UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
        try {
            synchronized (sem) {
                //while (controller == null) sem.wait();
                if (controller == null) {
                    throw new Exception("No controller specified");
                }
                controller = null;
                sem.notifyAll();
                window.addSubview(controller.view());
            }
        } catch (Exception e) {
            e.printStackTrace();
            //Thread.currentThread().interrupt();
        }

        window.makeKeyAndVisible();
        return true;
    }

    @Override
    public void applicationDidReceiveLocalNotification(UIApplication uiApplication, UILocalNotification uiLocalNotification) {

    }

    @Override
    public void applicationDidReceiveRemoteNotification(UIApplication uiApplication, NSDictionary nsDictionary) {

    }

    @Override
    public void applicationDidReceiveRemoteNotificationFetchCompletionHandler(UIApplication uiApplication, NSDictionary nsDictionary, @ObjCBlock(name = "call_applicationDidReceiveRemoteNotificationFetchCompletionHandler") Block_applicationDidReceiveRemoteNotificationFetchCompletionHandler block_applicationDidReceiveRemoteNotificationFetchCompletionHandler) {

    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(UIApplication uiApplication, NSData nsData) {

    }

    @Override
    public void applicationDidRegisterUserNotificationSettings(UIApplication uiApplication, UIUserNotificationSettings uiUserNotificationSettings) {

    }

    @Override
    public void applicationDidUpdateUserActivity(UIApplication uiApplication, NSUserActivity nsUserActivity) {

    }

    @Override
    public void applicationHandleActionWithIdentifierForLocalNotificationCompletionHandler(UIApplication uiApplication, String s, UILocalNotification uiLocalNotification, @ObjCBlock(name = "call_applicationHandleActionWithIdentifierForLocalNotificationCompletionHandler") Block_applicationHandleActionWithIdentifierForLocalNotificationCompletionHandler block_applicationHandleActionWithIdentifierForLocalNotificationCompletionHandler) {

    }

    @Override
    public void applicationHandleActionWithIdentifierForRemoteNotificationCompletionHandler(UIApplication uiApplication, String s, NSDictionary nsDictionary, @ObjCBlock(name = "call_applicationHandleActionWithIdentifierForRemoteNotificationCompletionHandler") Block_applicationHandleActionWithIdentifierForRemoteNotificationCompletionHandler block_applicationHandleActionWithIdentifierForRemoteNotificationCompletionHandler) {

    }

    @Override
    public void applicationHandleEventsForBackgroundURLSessionCompletionHandler(UIApplication uiApplication, String s, @ObjCBlock(name = "call_applicationHandleEventsForBackgroundURLSessionCompletionHandler") Block_applicationHandleEventsForBackgroundURLSessionCompletionHandler block_applicationHandleEventsForBackgroundURLSessionCompletionHandler) {

    }

    @Override
    public boolean applicationHandleOpenURL(UIApplication uiApplication, NSURL nsurl) {
        return false;
    }

    @Override
    public boolean applicationOpenURLSourceApplicationAnnotation(UIApplication uiApplication, NSURL nsurl, String s, @Mapped(ObjCObjectMapper.class) Object o) {
        return false;
    }

    @Override
    public void applicationPerformFetchWithCompletionHandler(UIApplication uiApplication, @ObjCBlock(name = "call_applicationPerformFetchWithCompletionHandler") Block_applicationPerformFetchWithCompletionHandler block_applicationPerformFetchWithCompletionHandler) {

    }

    @Override
    public boolean applicationShouldAllowExtensionPointIdentifier(UIApplication uiApplication, String s) {
        return false;
    }

    @Override
    public boolean applicationShouldRestoreApplicationState(UIApplication uiApplication, NSCoder nsCoder) {
        return false;
    }

    @Override
    public boolean applicationShouldSaveApplicationState(UIApplication uiApplication, NSCoder nsCoder) {
        return false;
    }

    @Override
    public long applicationSupportedInterfaceOrientationsForWindow(UIApplication uiApplication, UIWindow uiWindow) {
        return 0;
    }

    @Override
    public UIViewController applicationViewControllerWithRestorationIdentifierPathCoder(UIApplication uiApplication, NSArray nsArray, NSCoder nsCoder) {
        return null;
    }

    @Override
    public void applicationWillChangeStatusBarFrame(UIApplication uiApplication, @ByValue CGRect cgRect) {

    }

    @Override
    public void applicationWillChangeStatusBarOrientationDuration(UIApplication uiApplication, @NInt long l, double v) {

    }

    @Override
    public boolean applicationWillContinueUserActivityWithType(UIApplication uiApplication, String s) {
        return false;
    }

    @Override
    public void applicationWillEncodeRestorableStateWithCoder(UIApplication uiApplication, NSCoder nsCoder) {

    }

    @Override
    public boolean applicationWillFinishLaunchingWithOptions(UIApplication uiApplication, NSDictionary nsDictionary) {
        return false;
    }

    @Selector("applicationDidBecomeActive:")
    @Override
    public void applicationDidBecomeActive(UIApplication uiApplication) {
        testDidBecomeActive = true;
    }

    @Selector("applicationDidEnterBackground:")
    @Override
    public void applicationDidEnterBackground(UIApplication uiApplication) {
        testDidEnterBackground = true;
    }

    @Override
    public void applicationDidFinishLaunching(UIApplication uiApplication) {

    }

    @Override
    public void applicationDidReceiveMemoryWarning(UIApplication uiApplication) {

    }

    @Override
    public void applicationProtectedDataDidBecomeAvailable(UIApplication uiApplication) {

    }

    @Override
    public void applicationProtectedDataWillBecomeUnavailable(UIApplication uiApplication) {

    }

    @Override
    public void applicationSignificantTimeChange(UIApplication uiApplication) {

    }

    @Selector("applicationWillEnterForeground:")
    @Override
    public void applicationWillEnterForeground(UIApplication uiApplication) {
        testWillEnterForeground = true;
    }

    @Selector("applicationWillResignActive:")
    @Override
    public void applicationWillResignActive(UIApplication uiApplication) {
        testWillResignActive = true;
    }

    @Selector("applicationWillTerminate:")
    @Override
    public void applicationWillTerminate(UIApplication uiApplication) {
        testWillTerminate = true;
    }

    @Override
    public void setWindow(UIWindow uiWindow) {
        window = uiWindow;
    }

    @Override
    public UIWindow window() {
        return window;
    }

}
