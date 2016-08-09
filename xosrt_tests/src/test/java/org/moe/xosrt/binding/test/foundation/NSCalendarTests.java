package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import ios.foundation.*;
import ios.foundation.c.Foundation;
import ios.foundation.enums.NSCalendarUnit;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSCalendarTests extends XOSTest {

    @Test
    public void testInitWithCalendarIdentifier() {
        NSCalendar calendar = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierGregorian());
        assertTrue(calendar != null
                && calendar.calendarIdentifier().equals(Foundation.NSCalendarIdentifierGregorian()));
    }

    @Test
    public void testCalendarIdentifier() {
        NSCalendar calendar1 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierGregorian());
        NSCalendar calendar2 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierBuddhist());
        NSCalendar calendar3 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierChinese());
        NSCalendar calendar4 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierHebrew());
        NSCalendar calendar5 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierIslamic());
        NSCalendar calendar6 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierIslamicCivil());
        NSCalendar calendar7 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierJapanese());
        NSCalendar calendar8 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierRepublicOfChina());
        NSCalendar calendar9 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierPersian());
        NSCalendar calendar10 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierIndian());
        NSCalendar calendar11 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierISO8601());

        assertTrue(
                calendar1.calendarIdentifier().equals(Foundation.NSCalendarIdentifierGregorian())
                && calendar2.calendarIdentifier().equals(Foundation.NSCalendarIdentifierBuddhist())
                && calendar3.calendarIdentifier().equals(Foundation.NSCalendarIdentifierChinese())
                && calendar4.calendarIdentifier().equals(Foundation.NSCalendarIdentifierHebrew())
                && calendar5.calendarIdentifier().equals(Foundation.NSCalendarIdentifierIslamic())
                && calendar6.calendarIdentifier().equals(Foundation.NSCalendarIdentifierIslamicCivil())
                && calendar7.calendarIdentifier().equals(Foundation.NSCalendarIdentifierJapanese())
                && calendar8.calendarIdentifier().equals(Foundation.NSCalendarIdentifierRepublicOfChina())
                && calendar9.calendarIdentifier().equals(Foundation.NSCalendarIdentifierPersian())
                && calendar10.calendarIdentifier().equals(Foundation.NSCalendarIdentifierIndian())
        );
    }

    @Test
    public void testComponents_fromDate() {
    	// This test works only in Greenwich
        NSTimeZone.setDefaultTimeZone(NSTimeZone.timeZoneForSecondsFromGMT(0));
    	
    	NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat("yyyy-MM-dd HH:mm:ss Z");
        NSDate date = df.dateFromString("2013-01-17 15:10:01 -0000");
        NSCalendar gregorian = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSCalendarIdentifierGregorian());
        long flags = NSCalendarUnit.CalendarUnitEra | NSCalendarUnit.CalendarUnitYear | NSCalendarUnit.CalendarUnitMonth
                | NSCalendarUnit.CalendarUnitDay | NSCalendarUnit.CalendarUnitHour | NSCalendarUnit.CalendarUnitMinute
                | NSCalendarUnit.CalendarUnitSecond //Deprecated: | NSCalendarUnit.Week.value()
                | NSCalendarUnit.CalendarUnitWeekday | NSCalendarUnit.CalendarUnitWeekdayOrdinal;
        NSDateComponents components = gregorian.componentsFromDate(flags , date);
        assertTrue(
                components != null && components.era() == 1 && components.year() == 2013
                && components.month() == 1 && components.day() == 17 && components.hour() == 15
                && components.minute() == 10 && components.second() == 1
                && components.weekday() == 5 && components.weekdayOrdinal() == 3
        );
    }
}
