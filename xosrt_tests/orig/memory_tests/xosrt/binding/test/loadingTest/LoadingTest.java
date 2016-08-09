package xosrt.binding.test.loadingTest;

import xosrt.binding.test.common.XrtTest;
import xosrt.binding.test.common.xNSString;
import xosrt.binding.test.loadingTest.testClasses.HeavyObject;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class LoadingTest extends XrtTest {

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
        for (int i = 0; i < 1000; i++) {
        	System.out.println("i = " + i + ", creating objects...");
        	for (int j = 0; j < 100000; j++) {
        		xNSString nss = xNSString.fromJavaString("SomeString");
        		HeavyObject newObj = HeavyObject.alloc().init();
        	}
        	System.gc();
        }
    }


}
