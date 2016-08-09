package org.moe.xosrt.binding.test.uikit.viewTest;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.ByValue;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

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
import ios.uikit.UIResponder;
import ios.uikit.UIScreen;
import ios.uikit.UIUserNotificationSettings;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.protocol.UIApplicationDelegate;

public class AppDelegate extends UIResponder implements UIApplicationDelegate {

    public ViewController0 controller = null;
    UIWindow window = null;

    static {
        NatJ.register();
    }

    protected AppDelegate(Pointer peer) {
        super(peer);
    }

    @Selector("alloc")
    public static native AppDelegate alloc();

    @Selector("init")
    public native AppDelegate init();

    @Override
    @Selector("setWindow:")
    public void setWindow(UIWindow value) {
        window = value;
    }

    @Override
    @Selector("window")
    public UIWindow window() {
        return window;
    }

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

    @Override
    public boolean applicationDidFinishLaunchingWithOptions(UIApplication uiApplication, NSDictionary nsDictionary) {
        setWindow((UIWindow)UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds()));
        window().setTag(99);
        controller = ViewController0.alloc().init();
        window().addSubview(controller.view());
        window().makeKeyAndVisible();
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

    @Override
    public void applicationDidBecomeActive(UIApplication uiApplication) {

    }

    @Override
    public void applicationDidEnterBackground(UIApplication uiApplication) {

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

    @Override
    public void applicationWillEnterForeground(UIApplication uiApplication) {

    }

    @Override
    public void applicationWillResignActive(UIApplication uiApplication) {

    }

    @Override
    public void applicationWillTerminate(UIApplication uiApplication) {

    }
}
