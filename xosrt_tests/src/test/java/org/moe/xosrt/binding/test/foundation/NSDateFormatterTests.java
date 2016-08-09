package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;
import ios.foundation.*;
import ios.foundation.enums.NSDateFormatterStyle;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Before;
import org.junit.Test;

public class NSDateFormatterTests extends XOSTest {

	@Before
	public void initTimezone() {
        NSTimeZone.setDefaultTimeZone(NSTimeZone.timeZoneForSecondsFromGMT(0));
	}
	
    @Test
    public void testSetDateFormat1() {
        NSDateFormatter  aFormatter = NSDateFormatter.alloc().init();
        aFormatter.setDateFormat("yyyy-MM-dd HH:mm");
        NSDateFormatter  aFormatter2 = NSDateFormatter.alloc().init();
        aFormatter2.setDateFormat("dd-MM-yyyy mm:HH:ss");
        NSDateFormatter  aFormatter3 = NSDateFormatter.alloc().init();
        aFormatter3.setDateFormat("yyyyMMddHH:mm");

        assertTrue (NSString.stringWithString(aFormatter.dateFormat()).isEqualToString("yyyy-MM-dd HH:mm")
                && NSString.stringWithString(aFormatter2.dateFormat()).isEqualToString("dd-MM-yyyy mm:HH:ss")
                && NSString.stringWithString(aFormatter3.dateFormat()).isEqualToString("yyyyMMddHH:mm"));
    }

    @Test
    public void testStringFromDate1() {
        NSDateFormatter  aFormatter = NSDateFormatter.alloc().init();
        aFormatter.setDateFormat("yyyy-MM-dd HH:mm");
        NSDateFormatter  aFormatter2 = NSDateFormatter.alloc().init();
        aFormatter2.setDateFormat("dd-MM-yyyy mm:HH:ss");
        NSDateFormatter  aFormatter3 = NSDateFormatter.alloc().init();
        aFormatter3.setDateFormat("yyyyMMddHH:mm");

        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat("yyyy'-'MM'-'dd' 'HH':'mm':'ss' 'Z");
        NSDate aDate2 = df.dateFromString(
                "2000-01-15 10:45:32 -0000");
        NSString  aString1 = NSString.stringWithString(aFormatter.stringFromDate(aDate2));
        NSString  aString2 = NSString.stringWithString(aFormatter2.stringFromDate(aDate2));
        NSString  aString3 = NSString.stringWithString(aFormatter3.stringFromDate(aDate2));

        assertTrue (aString1.hasPrefix("2000-01-15")
                && aString2.hasPrefix("15-01-2000")
                && aString3.hasPrefix("2000011510:45"));
    }

    @Test
    public void testSetDateStyle1() {
        NSDateFormatter  aFormatter = NSDateFormatter.alloc().init();
        aFormatter.setDateFormat("yyyy-MM-dd HH:mm");
        NSDateFormatter  aFormatter2 = NSDateFormatter.alloc().init();
        aFormatter2.setDateFormat("dd-MM-yyyy mm:HH:ss");
        NSDateFormatter  aFormatter3 = NSDateFormatter.alloc().init();
        aFormatter3.setDateFormat("yyyyMMddHH:mm");

        aFormatter.setDateStyle(NSDateFormatterStyle.ShortStyle);
        aFormatter2.setDateStyle(NSDateFormatterStyle.MediumStyle);
        aFormatter3.setDateStyle(NSDateFormatterStyle.LongStyle);

        assertTrue (aFormatter.dateStyle() == NSDateFormatterStyle.ShortStyle &&
                aFormatter2.dateStyle() == NSDateFormatterStyle.MediumStyle &&
                aFormatter3.dateStyle() == NSDateFormatterStyle.LongStyle);
    }

    @Test
    public void testSetTimeStyle1() {
        NSDateFormatter  aFormatter = NSDateFormatter.alloc().init();
        aFormatter.setDateFormat("yyyy-MM-dd HH:mm");
        NSDateFormatter  aFormatter2 = NSDateFormatter.alloc().init();
        aFormatter2.setDateFormat("dd-MM-yyyy mm:HH:ss");
        NSDateFormatter  aFormatter3 = NSDateFormatter.alloc().init();
        aFormatter3.setDateFormat("yyyyMMddHH:mm");

        aFormatter.setTimeStyle(NSDateFormatterStyle.ShortStyle);
        aFormatter2.setTimeStyle(NSDateFormatterStyle.MediumStyle);
        aFormatter3.setTimeStyle(NSDateFormatterStyle.LongStyle);

        assertTrue (aFormatter.timeStyle() == NSDateFormatterStyle.ShortStyle &&
                aFormatter2.timeStyle() == NSDateFormatterStyle.MediumStyle &&
                aFormatter3.timeStyle() == NSDateFormatterStyle.LongStyle);
    }

}
