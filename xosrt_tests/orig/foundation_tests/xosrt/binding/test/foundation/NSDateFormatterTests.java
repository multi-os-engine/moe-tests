package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSDateFormatterTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testSetDateFormat1() {
        NSDateFormatter  aFormatter = NSDateFormatter.alloc().init();
        aFormatter.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm"));
        NSDateFormatter  aFormatter2 = NSDateFormatter.alloc().init();
        aFormatter2.setDateFormat(NSString.fromJavaString("dd-MM-yyyy mm:HH:ss"));
        NSDateFormatter  aFormatter3 = NSDateFormatter.alloc().init();
        aFormatter3.setDateFormat(NSString.fromJavaString("yyyyMMddHH:mm"));

        assertTrue (aFormatter.getDateFormat().isEqualToString(NSString.fromJavaString("yyyy-MM-dd HH:mm"))
                && aFormatter2.getDateFormat().isEqualToString(NSString.fromJavaString("dd-MM-yyyy mm:HH:ss"))
                && aFormatter3.getDateFormat().isEqualToString(NSString.fromJavaString("yyyyMMddHH:mm")));
    }

    @Test
    public void testStringFromDate1() {
        NSDateFormatter  aFormatter = NSDateFormatter.alloc().init();
        aFormatter.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm"));
        NSDateFormatter  aFormatter2 = NSDateFormatter.alloc().init();
        aFormatter2.setDateFormat(NSString.fromJavaString("dd-MM-yyyy mm:HH:ss"));
        NSDateFormatter  aFormatter3 = NSDateFormatter.alloc().init();
        aFormatter3.setDateFormat(NSString.fromJavaString("yyyyMMddHH:mm"));

        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate aDate2 = NSDateFormatter.alloc().init().dateFromString(
                NSString.fromJavaString("2000-01-15 10:45:32 -0300"));
        NSString  aString1 = aFormatter.stringFromDate(aDate2);
        NSString  aString2 = aFormatter2.stringFromDate(aDate2);
        NSString  aString3 = aFormatter3.stringFromDate(aDate2);

        assertTrue (aString1.hasPrefix(NSString.fromJavaString("2000-01-15"))
                && aString2.hasPrefix(NSString.fromJavaString("15-01-2000"))
                && aString3.hasPrefix(NSString.fromJavaString("2000011510:45")));
    }

    @Test
    public void testSetDateStyle1() {
        NSDateFormatter  aFormatter = NSDateFormatter.alloc().init();
        aFormatter.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm"));
        NSDateFormatter  aFormatter2 = NSDateFormatter.alloc().init();
        aFormatter2.setDateFormat(NSString.fromJavaString("dd-MM-yyyy mm:HH:ss"));
        NSDateFormatter  aFormatter3 = NSDateFormatter.alloc().init();
        aFormatter3.setDateFormat(NSString.fromJavaString("yyyyMMddHH:mm"));

        aFormatter.setDateStyle(NSDateFormatterStyle.ShortStyle);
        aFormatter2.setDateStyle(NSDateFormatterStyle.MediumStyle);
        aFormatter3.setDateStyle(NSDateFormatterStyle.LongStyle);

        assertTrue (aFormatter.getDateStyle() == NSDateFormatterStyle.ShortStyle &&
                aFormatter2.getDateStyle() == NSDateFormatterStyle.MediumStyle &&
                aFormatter3.getDateStyle() == NSDateFormatterStyle.LongStyle);
    }

    @Test
    public void testSetTimeStyle1() {
        NSDateFormatter  aFormatter = NSDateFormatter.alloc().init();
        aFormatter.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm"));
        NSDateFormatter  aFormatter2 = NSDateFormatter.alloc().init();
        aFormatter2.setDateFormat(NSString.fromJavaString("dd-MM-yyyy mm:HH:ss"));
        NSDateFormatter  aFormatter3 = NSDateFormatter.alloc().init();
        aFormatter3.setDateFormat(NSString.fromJavaString("yyyyMMddHH:mm"));

        aFormatter.setTimeStyle(NSDateFormatterStyle.ShortStyle);
        aFormatter2.setTimeStyle(NSDateFormatterStyle.MediumStyle);
        aFormatter3.setTimeStyle(NSDateFormatterStyle.LongStyle);

        assertTrue (aFormatter.getTimeStyle() == NSDateFormatterStyle.ShortStyle &&
                aFormatter2.getTimeStyle() == NSDateFormatterStyle.MediumStyle &&
                aFormatter3.getTimeStyle() == NSDateFormatterStyle.LongStyle);
    }

}
