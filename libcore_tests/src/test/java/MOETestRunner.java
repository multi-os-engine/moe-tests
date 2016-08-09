/*
 * Copyright (C) 2013 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import org.junit.runner.Request;
 import org.junit.runner.manipulation.Filter;

import ios.NSObject;
import ios.coregraphics.struct.CGRect;
import ios.foundation.NSArray;
import ios.foundation.NSBundle;
import ios.foundation.NSCharacterSet;
import ios.foundation.NSCoder;
import ios.foundation.NSData;
import ios.foundation.NSDictionary;
import ios.foundation.NSError;
import ios.foundation.NSString;
import ios.foundation.NSURL;
import ios.foundation.NSUserActivity;
import ios.foundation.enums.Enums;
import ios.uikit.UIAlertView;
import ios.uikit.UIApplication;
import ios.uikit.UILocalNotification;
import ios.uikit.UIScreen;
import ios.uikit.UIUserNotificationSettings;
import ios.uikit.UIViewController;
import ios.uikit.UIWindow;
import ios.uikit.c.UIKit;
import ios.uikit.protocol.UIApplicationDelegate;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.ByValue;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.NotImplemented;
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.general.ann.NUInt;

import java.io.*;

public class MOETestRunner extends NSObject implements UIApplicationDelegate {
    static int skipped_num = 0;
    static String fileCSV;
    static Writer writer;
    static BufferedReader reader;
    
    public static void setWriter(String fileName){
        fileCSV = fileName;
        
        try{
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileCSV)));
        } catch (Exception ex){
            System.logE("exception on creating writer",ex);
        }
    }

    public static void setReader(){
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileCSV))); //+"_"
        } catch (Exception ex){
            System.logE("exception on creating writer",ex);
        }
    }
    
    public static void changeFile(Description description, String status){
        String curFileName = fileCSV;
        File orig = new File(curFileName);
        File temp = new File(curFileName + "_");
        //orig.renameTo(temp);
        setReader();
        setWriter(curFileName+"_");
        
        String renewLine = description.getClassName() + "-"+ description.getMethodName()+",";
        try{
            String line = reader.readLine();
            while(line != null){
                if(line.equals(renewLine+"NOTRUN")){
                    line = renewLine + status;
                }
                writer.write(line+"\n");
                line = reader.readLine();
            }
        } catch (Exception ex){
            System.out.println("Exception during file change: "+ex.toString());
        }
        try {
            reader.close();
            writer.close();
            setWriter(curFileName);
            writer.close();
        } catch (Exception ex) {
            /*ignore*/
        }
        temp.renameTo(orig);
        temp.delete();
    }

    private static class ExcludeAlreadyRun extends Filter {
        private final String className;
        private final String methodName;
        private boolean alreadyRun = true;
        
        public ExcludeAlreadyRun(String testName) {
            if(testName.indexOf("#") == -1){
                this.className = testName;
                this.methodName = "";
            } else {
                this.methodName = testName.substring(testName.indexOf("#")+1);
                this.className = testName.substring(0,testName.indexOf("#"));
                System.out.println("%TESTE   :" + this.className + "-" + this.methodName);
                try{
                    writer.write(this.className + "-"+ this.methodName+","+"CRASH\n");
                    writer.flush();
                } catch (Exception ex){
                    System.logE("exception on writing csv file",ex);
                }
            }
        }
        
        @Override
        public boolean shouldRun(Description description){
            if(!alreadyRun){
                return true;
            }
            
            if(methodName == ""){
                if(description.getClassName().equals(className)){
                    alreadyRun = false;
                }
            } else {
                if(description.getMethodName()!= null){
                    if(description.getMethodName().equals(methodName)
                        && description.getClassName().equals(className)){
                        alreadyRun = false;
                    }
                } else {
                    return true;
                }
            }
        
            return false;
        }
        
        @Override
        public String describe() {
            return "%ALRUN   :" + className + "-" + methodName;
        }
    };
    
    private static class Exclude extends Filter {
        private final String className;
        private final String methodName;
        private final boolean addDescr;
       
        public Exclude(String testName, boolean addDescr) {
            this.addDescr=addDescr;
            if(testName.indexOf("#") == -1){
                this.className = testName;
                this.methodName = "";
            } else {
                this.methodName = testName.substring(testName.indexOf("#")+1);
                this.className = testName.substring(0,testName.indexOf("#"));
            }
        }
   
        @Override
        public boolean shouldRun(Description description){
            if(description.getMethodName()!= null)
                if(methodName == ""){
                    if(description.getClassName().equals(className)){
                        if(addDescr){
                            System.out.println("%SKIP   :" + className + "-" + description.getMethodName());
                            try{
                                writer.write(className + "-"+ description.getMethodName()+","+"SKIPPED\n");
                                writer.flush();
                            } catch (Exception ex){
                                System.logE("exception on writing csv file",ex);
                            }
                        }

                        skipped_num++;
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    if(description.getMethodName().equals(methodName)
                       && description.getClassName().equals(className)){
                       if(addDescr){
                           System.out.println(describe());
                           try{
                               writer.write(className + "-"+ description.getMethodName()+","+"SKIPPED\n");
                               writer.flush();
                           } catch (Exception ex){
                               System.logE("exception on writing csv file",ex);
                           }
                       }
                       skipped_num++;
                       return false;
                    } else {
                       return true;
                    }
                }
            else
                return true;
        }
   
        @Override
        public String describe() {
            return "%SKIP   :" + className + "-" + methodName;
        }
    };
    
    static class TestListener extends RunListener {
        int count_all = 0;
        int count_failed = 0;
        int failure_flag = 0;
        Writer summaryWriter;
        
        public void setSummaryWriter(String fileName){
            try{
                summaryWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("java.io.tmpdir")+"/"+fileName, true)));
            } catch (Exception ex){
                System.logE("exception on creating summaryWriter",ex);
            }
        }
        
        public void closeSummaryWriter(){
            try{
              summaryWriter.close();
            } catch(Exception ex){
                /*ignore*/
            }
        }
        
        public void setWriter(String className){
            try{
              summaryWriter.write(className+",");
            }catch(Exception ex){
                System.logE("exception on writing summary",ex);
            }
        }
        
        public void reset(){
            try {writer.close();} catch (Exception ex) {/*ignore*/}
            count_all=0;
            skipped_num=0;
            count_failed=0;
        }
        /**
         * Called before any tests have been run.
         */
        public void testRunStarted(Description description) throws java.lang.Exception {
            for (Description child : description.getChildren()) {
                defineTest(child);
            }
            try {
                writer.close();
            } catch (Exception ex) {
                /*ignore*/
            }
            sendMessage(MessageIds.TEST_RUN_START + ":" + description.testCount());
        }
        
        /**
         * Called internally for defining tests.
         */
        private void defineTest(Description description) {
            if (description.isTest() && !description.getMethodName().equals("initializationError")) {
                sendMessage(MessageIds.TEST_DEFINE + ":" + description.getClassName() + "-"
                            + description.getMethodName());
                try{
                    writer.write(description.getClassName() + "-"+ description.getMethodName()+","+"NOTRUN\n");
                    writer.flush();
                } catch (Exception ex){
                    System.logE("exception on writing csv file",ex);
                }
                return;
            }
            if (description.getChildren() == null || description.getChildren().size() == 0) {
                return;
            }
            for (Description child : description.getChildren()) {
                defineTest(child);
            }
        }
        
        /**
         *  Called when all tests have finished.
         */
        public void testRunFinished(Result result) throws java.lang.Exception {
            sendMessage(MessageIds.TEST_RUN_END + ":" + result.getRunTime());
            sendMessage(MessageIds.TEST_RUN_END + ":" + "all:" + count_all + " failed:"+count_failed
                        +" skipped:"+skipped_num);
            summaryWriter.write(count_all+","+count_failed+","+skipped_num+"\n");
            reset();
            
        }
        
        /**
         *  Called when an atomic test is about to be started.
         */
        public void testStarted(Description description) throws java.lang.Exception {
            count_all++;
            
            sendMessage(MessageIds.TEST_START + ":" + description.getClassName() + "-"
                        + description.getMethodName());
        }
        
        /**
         *  Called when an atomic test has finished, whether the test succeeds or fails.
         */
        public void testFinished(Description description) throws java.lang.Exception {
            sendMessage(MessageIds.TEST_END + ":" + description.getClassName() + "-"
                        + description.getMethodName());
            if(failure_flag == 1){
                failure_flag = 0;
                changeFile(description, "FAILED");
            } else {
                changeFile(description, "OK");
            }
        }
        
        /**
         *  Called when an atomic test fails.
         */
        public void testFailure(Failure failure) throws java.lang.Exception {
            sendMessage(MessageIds.TEST_FAILED + ":" + failure.getTestHeader() + ":"
                        + failure.getTrace());
            count_failed++;
            failure_flag = 1;
        }
    };

    private static String ConvertFilenameToClass(String fn){
        String res = "";
        //trim JunitExt or JunitInt prefix
        fn = fn.substring(8);
        //replace upper case symbol X by '.'+ x
        char []buf=fn.toCharArray();
        int last = buf.length;
        for(int i=buf.length-1; i>=0 ; i--){
            if(Character.isUpperCase(buf[i])){
                if(i == 0){
                    res = fn.substring(i, last).toLowerCase() + res;
                } else {
                    res = "." + fn.substring(i,last).toLowerCase() + res;
                    last = i;
                }
            }

        }

        return res;
    }
    
    private static class SkippedTests {
        private final NSArray components;
        
        public SkippedTests(){
            String str = NSBundle.mainBundle().pathForResourceOfType("skipped", "txt");
            NSString contents = NSString.stringWithContentsOfFileEncodingError(str,
                                                                               Enums.NSUTF8StringEncoding, null);
            components = contents.componentsSeparatedByCharactersInSet(
                                                                               NSCharacterSet.newlineCharacterSet());
        }
    
        public ArrayList<String> getSkippedTests(){
            ArrayList<String> tests = new ArrayList<String>();
            for (String sub : (List<String>)components) {
                if (sub.length() == 0) {
                    continue;
                }
                if(sub.indexOf(" ") != -1)
                    tests.add(sub.substring(0, sub.indexOf(" ")));
                else
                    tests.add(sub);
            }
            return tests;
        }
    };


    private static void runTests(Class<?>[] testsClasses, String startRunHere) {

        JUnitCore junit = new JUnitCore();
        TestListener l=new TestListener();
        junit.addListener(l);
        
        SkippedTests st = new SkippedTests();
        ArrayList<String> skippedTests = st.getSkippedTests();

        for(Class cl : testsClasses){
            String clName = ConvertFilenameToClass(cl.getName());
            if(cl.getName().startsWith("JunitExt")){
                l.setSummaryWriter("summaryExt.csv");
            } else {
                l.setSummaryWriter("summaryInt.csv");
            }
            System.out.println(clName+" starts:");
            setWriter(System.getProperty("java.io.tmpdir")+"/"+cl.getName().replace("JunitExt","").replace("JunitInt","")+".csv" );
            l.setWriter(clName);

            Request r = Request.aClass(cl);
            boolean addDescr=true;
            if(startRunHere != null && !startRunHere.equals("")){
                r = r.filterWith(new ExcludeAlreadyRun(startRunHere));
                addDescr = false;
            }
            for(String s : skippedTests){
                r = r.filterWith(new Exclude(s, addDescr));
            }
            
            
            junit.run(r);
            System.out.println(clName+" finishes!");
            System.out.println("################################################################################");
            l.closeSummaryWriter();
        }       
    }

    public class MessageIds {

        public static final String TEST_RUN_START = "%TESTC  ";

        public static final String TEST_DEFINE = "%TESTD  ";

        public static final String TEST_START = "%TESTS  ";

        public static final String TEST_END = "%TESTE  ";

        public static final String TEST_ERROR = "%ERROR  ";

        public static final String TEST_FAILED = "%FAILED ";

        public static final String TEST_RUN_END = "%RUNTIME";
    }

    private static void sendMessage(String message) {
        System.out.println(message);
        System.out.flush();
    }
    
    private static String[] args;

    public static void main(String[] args) {
        MOETestRunner.args = args;
        UIKit.UIApplicationMain(0, null, null, MOETestRunner.class.getName());
    }

    static {
        NatJ.register();
    }

    @Generated("NatJ")
    @Owned
    @Selector("alloc")
    public static native MOETestRunner alloc();

    @Generated("NatJ")
    protected MOETestRunner(Pointer peer) {
        super(peer);
    }

    private UIWindow window;
    
    private final Runnable testRunner = new Runnable() {
        
        @Override
        public void run() {
            ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
            String startArg = null;
    
            for (String arg : args) {
                if(arg.equals("-start")){
                    startArg = "";
                } else {
                    if(startArg != null && startArg.equals("")){
                        startArg = arg;
                    } else {
                        String[] subs = arg.split("[,]");
                        for (String sub : subs) {
                            if (sub.length() == 0) {
                                continue;
                            }
                            Class<?> cls = null;
                            try {
                                cls = Class.forName(sub);
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            if (cls != null) {
                                classList.add(cls);
                            }
                        }
                    }
                }
            }

            if (classList.size() == 0) {
                String str = NSBundle.mainBundle().pathForResourceOfType("classlist", "txt");
                NSString contents = NSString.stringWithContentsOfFileEncodingError(str,
                    Enums.NSUTF8StringEncoding, null);
                NSArray components = contents.componentsSeparatedByCharactersInSet(
                    NSCharacterSet.newlineCharacterSet());
                for (String sub : (List<String>)components) {
                    if (sub.length() == 0) {
                        continue;
                    }
                    Class<?> cls = null;
                    try {
                        cls = Class.forName(sub);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (cls != null) {
                        classList.add(cls);
                    }
                }
            }
            if (classList.size() > 0) {
                Class<?>[] classArray = new Class<?>[classList.size()];
                runTests(classList.toArray(classArray), startArg);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    };

    @Override
    @Selector("application:didFinishLaunchingWithOptions:")
    public boolean applicationDidFinishLaunchingWithOptions(
            UIApplication application, NSDictionary launchOptions) {
        window = UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());

        UIViewController controller = UIViewController.alloc().init();
        window.setRootViewController(controller);

        window.makeKeyAndVisible();

        UIAlertView alert = UIAlertView.alloc().init();
        alert.setMessage("Running JUnit tests!");
        alert.show();

        new Thread(testRunner).start();

        return true;
    }

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

    @NotImplemented
    @Override
    @Selector("application:didChangeStatusBarFrame:")
    @IsOptional
    public native void applicationDidChangeStatusBarFrame(
            UIApplication application, @ByValue CGRect oldStatusBarFrame);

    @NotImplemented
    @Override
    @Selector("application:didChangeStatusBarOrientation:")
    @IsOptional
    public native void applicationDidChangeStatusBarOrientation(
            UIApplication application, @NInt long oldStatusBarOrientation);

    @NotImplemented
    @Override
    @Selector("application:didDecodeRestorableStateWithCoder:")
    @IsOptional
    public native void applicationDidDecodeRestorableStateWithCoder(
            UIApplication application, NSCoder coder);

    @NotImplemented
    @Override
    @Selector("application:didFailToRegisterForRemoteNotificationsWithError:")
    @IsOptional
    public native void applicationDidFailToRegisterForRemoteNotificationsWithError(
            UIApplication application, NSError error);

    @NotImplemented
    @Override
    @Selector("application:didReceiveLocalNotification:")
    @IsOptional
    public native void applicationDidReceiveLocalNotification(
            UIApplication application, UILocalNotification notification);

    @NotImplemented
    @Override
    @Selector("application:didReceiveRemoteNotification:")
    @IsOptional
    public native void applicationDidReceiveRemoteNotification(
            UIApplication application, NSDictionary userInfo);

    @NotImplemented
    @Override
    @Selector("application:didReceiveRemoteNotification:fetchCompletionHandler:")
    @IsOptional
    public native void applicationDidReceiveRemoteNotificationFetchCompletionHandler(
            UIApplication application,
            NSDictionary userInfo,
            @ObjCBlock(name = "call_applicationDidReceiveRemoteNotificationFetchCompletionHandler")
            UIApplicationDelegate
            .Block_applicationDidReceiveRemoteNotificationFetchCompletionHandler completionHandler);

    @NotImplemented
    @Override
    @Selector("application:didRegisterForRemoteNotificationsWithDeviceToken:")
    @IsOptional
    public native void applicationDidRegisterForRemoteNotificationsWithDeviceToken(
            UIApplication application, NSData deviceToken);

    @NotImplemented
    @Override
    @Selector("application:handleEventsForBackgroundURLSession:completionHandler:")
    @IsOptional
    public native void applicationHandleEventsForBackgroundURLSessionCompletionHandler(
            UIApplication application,
            String identifier,
            @ObjCBlock(name
                = "call_applicationHandleEventsForBackgroundURLSessionCompletionHandler")
            UIApplicationDelegate
            .Block_applicationHandleEventsForBackgroundURLSessionCompletionHandler
            completionHandler);

    @NotImplemented
    @Override
    @Selector("application:handleOpenURL:")
    @IsOptional
    public native boolean applicationHandleOpenURL(UIApplication application,
            NSURL url);

    @NotImplemented
    @Override
    @Selector("application:openURL:sourceApplication:annotation:")
    @IsOptional
    public native boolean applicationOpenURLSourceApplicationAnnotation(
            UIApplication application,
            NSURL url,
            String sourceApplication,
            @Mapped(org.moe.natj.objc.map.ObjCObjectMapper.class) Object annotation);

    @NotImplemented
    @Override
    @Selector("application:performFetchWithCompletionHandler:")
    @IsOptional
    public native void applicationPerformFetchWithCompletionHandler(
            UIApplication application,
            @ObjCBlock(name = "call_applicationPerformFetchWithCompletionHandler")
            UIApplicationDelegate
            .Block_applicationPerformFetchWithCompletionHandler completionHandler);

    @NotImplemented
    @Override
    @Selector("application:shouldRestoreApplicationState:")
    @IsOptional
    public native boolean applicationShouldRestoreApplicationState(
            UIApplication application, NSCoder coder);

    @NotImplemented
    @Override
    @Selector("application:shouldSaveApplicationState:")
    @IsOptional
    public native boolean applicationShouldSaveApplicationState(
            UIApplication application, NSCoder coder);

    @NotImplemented
    @Override
    @NUInt
    @Selector("application:supportedInterfaceOrientationsForWindow:")
    @IsOptional
    public native long applicationSupportedInterfaceOrientationsForWindow(
            UIApplication application, UIWindow window);

    @NotImplemented
    @Override
    @Selector("application:viewControllerWithRestorationIdentifierPath:coder:")
    @IsOptional
    public native UIViewController applicationViewControllerWithRestorationIdentifierPathCoder(
            UIApplication application, NSArray identifierComponents,
            NSCoder coder);

    @NotImplemented
    @Override
    @Selector("application:willChangeStatusBarFrame:")
    @IsOptional
    public native void applicationWillChangeStatusBarFrame(
            UIApplication application, @ByValue CGRect newStatusBarFrame);

    @NotImplemented
    @Override
    @Selector("application:willChangeStatusBarOrientation:duration:")
    @IsOptional
    public native void applicationWillChangeStatusBarOrientationDuration(
            UIApplication application, @NInt long newStatusBarOrientation,
            double duration);

    @NotImplemented
    @Override
    @Selector("application:willEncodeRestorableStateWithCoder:")
    @IsOptional
    public native void applicationWillEncodeRestorableStateWithCoder(
            UIApplication application, NSCoder coder);

    @NotImplemented
    @Override
    @Selector("application:willFinishLaunchingWithOptions:")
    @IsOptional
    public native boolean applicationWillFinishLaunchingWithOptions(
            UIApplication application, NSDictionary launchOptions);

    @NotImplemented
    @Override
    @Selector("applicationDidBecomeActive:")
    @IsOptional
    public native void applicationDidBecomeActive(UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationDidEnterBackground:")
    @IsOptional
    public native void applicationDidEnterBackground(UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationDidFinishLaunching:")
    @IsOptional
    public native void applicationDidFinishLaunching(UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationDidReceiveMemoryWarning:")
    @IsOptional
    public native void applicationDidReceiveMemoryWarning(
            UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationProtectedDataDidBecomeAvailable:")
    @IsOptional
    public native void applicationProtectedDataDidBecomeAvailable(
            UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationProtectedDataWillBecomeUnavailable:")
    @IsOptional
    public native void applicationProtectedDataWillBecomeUnavailable(
            UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationSignificantTimeChange:")
    @IsOptional
    public native void applicationSignificantTimeChange(
            UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationWillEnterForeground:")
    @IsOptional
    public native void applicationWillEnterForeground(UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationWillResignActive:")
    @IsOptional
    public native void applicationWillResignActive(UIApplication application);

    @NotImplemented
    @Override
    @Selector("applicationWillTerminate:")
    @IsOptional
    public native void applicationWillTerminate(UIApplication application);

    @NotImplemented
    @Override
    @Selector("application:continueUserActivity:restorationHandler:")
    @IsOptional
    public native boolean applicationContinueUserActivityRestorationHandler(
            UIApplication application,
            NSUserActivity userActivity,
            @ObjCBlock(name = "call_applicationContinueUserActivityRestorationHandler")
            UIApplicationDelegate
            .Block_applicationContinueUserActivityRestorationHandler restorationHandler);

    @NotImplemented
    @Override
    @Selector("application:didFailToContinueUserActivityWithType:error:")
    @IsOptional
    public native void applicationDidFailToContinueUserActivityWithTypeError(
            UIApplication application, String userActivityType, NSError error);

    @NotImplemented
    @Override
    @Selector("application:didRegisterUserNotificationSettings:")
    @IsOptional
    public native void applicationDidRegisterUserNotificationSettings(
            UIApplication application,
            UIUserNotificationSettings notificationSettings);

    @NotImplemented
    @Override
    @Selector("application:didUpdateUserActivity:")
    @IsOptional
    public native void applicationDidUpdateUserActivity(
            UIApplication application, NSUserActivity userActivity);

    @NotImplemented
    @Override
    @Selector("application:handleActionWithIdentifier:forLocalNotification:completionHandler:")
    @IsOptional
    public native void applicationHandleActionWithIdentifierForLocalNotificationCompletionHandler(
            UIApplication application,
            String identifier,
            UILocalNotification notification,
            @ObjCBlock(name
                = "call_applicationHandleActionWithIdentifierForLocalNotificationCompletionHandler")
            UIApplicationDelegate
            .Block_applicationHandleActionWithIdentifierForLocalNotificationCompletionHandler
            completionHandler);

    @NotImplemented
    @Override
    @Selector("application:handleActionWithIdentifier:forRemoteNotification:completionHandler:")
    @IsOptional
    public native void applicationHandleActionWithIdentifierForRemoteNotificationCompletionHandler(
            UIApplication application,
            String identifier,
            NSDictionary userInfo,
            @ObjCBlock(name
                = "call_applicationHandleActionWithIdentifierForRemoteNotificationCompletionHandler"
                )
            UIApplicationDelegate
            .Block_applicationHandleActionWithIdentifierForRemoteNotificationCompletionHandler
            completionHandler);

    @NotImplemented
    @Override
    @Selector("application:shouldAllowExtensionPointIdentifier:")
    @IsOptional
    public native boolean applicationShouldAllowExtensionPointIdentifier(
            UIApplication application, String extensionPointIdentifier);

    @NotImplemented
    @Override
    @Selector("application:willContinueUserActivityWithType:")
    @IsOptional
    public native boolean applicationWillContinueUserActivityWithType(
            UIApplication application, String userActivityType);

    @NotImplemented
	@Override
	@Selector("application:handleWatchKitExtensionRequest:reply:")
    @IsOptional
	public native void applicationHandleWatchKitExtensionRequestReply(
			UIApplication application, NSDictionary userInfo,
			Block_applicationHandleWatchKitExtensionRequestReply reply);
}
