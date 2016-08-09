package org.moe.xosrt.binding.test.foundation;

import java.lang.reflect.Method;

import org.moe.natj.objc.SEL;

import static org.junit.Assert.*;
import ios.foundation.*;

import org.moe.xosrt.binding.test.foundation.Utils.ErrorTestObject;
import org.moe.xosrt.binding.test.foundation.Utils.TimerTestTarget;
import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
//TODO: string ~#40: can't generate selector from pure java method
//Test should be rewritten
public class NSTimerTests extends XOSTest{

    private static final int SLEEP_TIME = 10;
    private static final int MAX_SLEEP_TIME = 3000;

    @Test
    public void testUserInfo1() throws NoSuchMethodException {
        ErrorTestObject arg1;

        arg1 = ErrorTestObject.alloc().init();
        arg1.setMyNumber( 1);
        arg1.setMyString(NSString.stringWithString("one"));

        NSMutableDictionary aDictionary = NSMutableDictionary.alloc().init();
        aDictionary.setObjectForKey(arg1, arg1.myString());

        //fires "targetMethod" immediately, is repeated every 2 seconds until finish
        TimerTestTarget target = TimerTestTarget.alloc().init();
        Method tm = TimerTestTarget.class.getDeclaredMethod("targetMethod");
        NSTimer timer = NSTimer.scheduledTimerWithTimeIntervalTargetSelectorUserInfoRepeats(
                2, target, new SEL(tm), aDictionary, true);

        int i = 0;
        while (!target.passed && i < MAX_SLEEP_TIME) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i += SLEEP_TIME;
        }
        NSMutableDictionary something = (NSMutableDictionary)timer.userInfo();
        assertTrue(target.passed);
        assertTrue (something != null);
    }
}
