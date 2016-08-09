package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import xosrt.binding.test.foundation.Utils.ErrorTestObject;
import xosrt.binding.test.foundation.Utils.TimerTestTarget;
import org.junit.After;
import org.junit.Test;

public class NSTimerTests {

    static {
        System.loadLibrary("Mac");
    }

    private static final int SLEEP_TIME = 10;
    private static final int MAX_SLEEP_TIME = 3000;

    @Test
    public void testUserInfo1() throws NoSuchMethodException {
        ErrorTestObject arg1;
        boolean flag = false;

        arg1 = ErrorTestObject.alloc().init();
        arg1.setMyNumber( 1);
        arg1.setMyString(NSString.fromJavaString("one"));

        NSMutableDictionary aDictionary = NSMutableDictionary.alloc().init();
        aDictionary.setObjectForKey(arg1, arg1.myString());

        //fires "targetMethod" immediately, is repeated every 2 seconds until finish
        TimerTestTarget target = TimerTestTarget.alloc().init();
        NSTimer timer = NSTimer.scheduledTimerWithTimeIntervalTargetSelectorUserInfoRepeats(
                2.0, target, TimerTestTarget.class.getMethod("targetMethod"), aDictionary, false);

        int i = 0;
        while (!target.passed && i < MAX_SLEEP_TIME) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i += SLEEP_TIME;
        }
        NSMutableDictionary something = (NSMutableDictionary)timer.getUserInfo();
        assertTrue(target.passed);
        assertTrue (something != null);
    }
}
