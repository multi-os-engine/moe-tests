package org.moe.xosrt.binding.test.loadingTest;

import ios.foundation.NSString;
import org.moe.xosrt.binding.test.loadingTest.testClasses.HeavyObject;
import org.junit.Test;

//AUDIT
public class LoadingTest {

    @Test
    public void singleObject()
    {
    	{
      		HeavyObject newObj = HeavyObject.alloc().init();
        }
        System.gc();
    }

    
    @Test
    public void collectableObjects()
    {
        for (int i = 0; i < 10; i++) {
        	System.out.println("i = " + i + ", creating objects...");
        	for (int j = 0; j < 10000; j++) {
        		NSString nss = NSString.stringWithString("SomeString");
        		HeavyObject newObj = HeavyObject.alloc().init();
        	}
        	System.gc();
        }
    }


}
