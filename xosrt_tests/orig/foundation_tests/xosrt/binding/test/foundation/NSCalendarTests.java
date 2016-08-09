package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.Foundation;
import xosrt.binding.foundation.NSCalendar;
import xosrt.binding.foundation.NSCalendarUnit;
import xosrt.binding.foundation.NSDate;
import xosrt.binding.foundation.NSDateComponents;
import xosrt.binding.foundation.NSDateFormatter;
import xosrt.binding.foundation.NSString;
import org.junit.Test;
 
public class NSCalendarTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInitWithCalendarIdentifier() {
        NSCalendar calendar = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.GregorianCalendar());
        assertTrue(calendar != null
                && calendar.getCalendarIdentifier().isEqual(Foundation.GregorianCalendar()));
    }

    @Test
    public void testCalendarIdentifier() {
        NSCalendar calendar1 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.GregorianCalendar());
        NSCalendar calendar2 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.BuddhistCalendar());
        NSCalendar calendar3 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.ChineseCalendar());
        NSCalendar calendar4 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.HebrewCalendar());
        NSCalendar calendar5 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.IslamicCalendar());
        NSCalendar calendar6 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.IslamicCivilCalendar());
        NSCalendar calendar7 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.JapaneseCalendar());
        NSCalendar calendar8 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.RepublicOfChinaCalendar());
        NSCalendar calendar9 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.PersianCalendar());
        NSCalendar calendar10 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.IndianCalendar());
        NSCalendar calendar11 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.ISO8601Calendar());

        assertTrue(
                calendar1.getCalendarIdentifier().isEqual(Foundation.GregorianCalendar())
                && calendar2.getCalendarIdentifier().isEqual(Foundation.BuddhistCalendar())
                && calendar3.getCalendarIdentifier().isEqual(Foundation.ChineseCalendar())
                && calendar4.getCalendarIdentifier().isEqual(Foundation.HebrewCalendar())
                && calendar5.getCalendarIdentifier().isEqual(Foundation.IslamicCalendar())
                && calendar6.getCalendarIdentifier().isEqual(Foundation.IslamicCivilCalendar())
                && calendar7.getCalendarIdentifier().isEqual(Foundation.JapaneseCalendar())
                && calendar8.getCalendarIdentifier().isEqual(Foundation.RepublicOfChinaCalendar())
                && calendar9.getCalendarIdentifier().isEqual(Foundation.PersianCalendar())
                && calendar10.getCalendarIdentifier().isEqual(Foundation.IndianCalendar())
        );
    }

    @Test
    public void testComponents_fromDate() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate date = df.dateFromString(NSString.fromJavaString("2013-01-17 15:10:01 -0300"));
        NSCalendar gregorian = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.GregorianCalendar());
        long flags = NSCalendarUnit.Era | NSCalendarUnit.Year | NSCalendarUnit.Month
                | NSCalendarUnit.Day | NSCalendarUnit.Hour | NSCalendarUnit.Minute
                | NSCalendarUnit.Second //Deprecated: | NSCalendarUnit.Week.value()
                | NSCalendarUnit.Weekday | NSCalendarUnit.WeekdayOrdinal;
        NSDateComponents components = gregorian.componentsFromDate(flags , date);
        assertTrue(
                components != null && components.getEra() == 1 && components.getYear() == 2013
                && components.getMonth() == 1 && components.getDay() == 17 && components.getHour() == 15
                && components.getMinute() == 10 && components.getSecond() == 1
                && components.getWeekday() == 5 && components.getWeekdayOrdinal() == 3
        );
    }
}
