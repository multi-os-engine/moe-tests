package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import ios.foundation.*;
import ios.foundation.c.Foundation;
import ios.foundation.enums.Enums;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

public class NSDateComponentsTests extends XOSTest{

    @Test
    public void testEra1() {
        NSDateComponents dateComponents0 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents0 = NSDateComponents.alloc().init();
        dateComponents0.setEra(1);
        assertTrue (dateComponents0.era() == 1 && emptyDateComponents0.era() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testYear1() {
        NSDateComponents dateComponents1 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents1 = NSDateComponents.alloc().init();
        dateComponents1.setYear(1999);
        assertTrue (dateComponents1.year() == 1999 && emptyDateComponents1.year() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testMonth1() {
        NSDateComponents dateComponents2 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents2 = NSDateComponents.alloc().init();
        dateComponents2.setMonth(12);
        assertTrue (dateComponents2.month() == 12 && emptyDateComponents2.month() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testDay1() {
        NSDateComponents dateComponents3 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents3 = NSDateComponents.alloc().init();
        dateComponents3.setDay(31);
        assertTrue (dateComponents3.day() == 31 && emptyDateComponents3.day() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testHour1() {
        NSDateComponents dateComponents4 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents4 = NSDateComponents.alloc().init();
        dateComponents4.setHour(0);
        assertTrue (dateComponents4.hour() == 0 && emptyDateComponents4.hour() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testMinute1() {
        NSDateComponents dateComponents5 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents5 = NSDateComponents.alloc().init();
        dateComponents5.setMinute(59);
        assertTrue (dateComponents5.minute() == 59 && emptyDateComponents5.minute() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testSecond1() {
        NSDateComponents dateComponents6 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents6 = NSDateComponents.alloc().init();
        dateComponents6.setSecond(59);
        assertTrue (dateComponents6.second() == 59 && emptyDateComponents6.second() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testWeekday1() {
        NSDateComponents dateComponents7 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents7 = NSDateComponents.alloc().init();
        dateComponents7.setWeekday(7);
        assertTrue (dateComponents7.weekday() == 7 && emptyDateComponents7.weekday() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testCalendar1() {
        NSDateComponents dateComponents8 = NSDateComponents.alloc().init();
        NSCalendar gregorianCalendar0 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSGregorianCalendar());
        dateComponents8.setCalendar(gregorianCalendar0);
        assertTrue(gregorianCalendar0.calendarIdentifier().equals(
                dateComponents8.calendar().calendarIdentifier()));
    }

    @Test
    public void testWeek1() {
        NSDateComponents dateComponents9 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents9 = NSDateComponents.alloc().init();
        dateComponents9.setWeek(12);
        assertTrue(dateComponents9.week() == 12 && emptyDateComponents9.week() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testWeekdayOrdinal1() {
        NSDateComponents dateComponents10 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents10 = NSDateComponents.alloc().init();
        dateComponents10.setWeekdayOrdinal(3);
        assertTrue(dateComponents10.weekdayOrdinal() == 3
                && emptyDateComponents10.weekdayOrdinal() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testQuarter1() {
        NSDateComponents dateComponents11 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents11 = NSDateComponents.alloc().init();
        dateComponents11.setQuarter(2);
        assertTrue(dateComponents11.quarter() == 2 && emptyDateComponents11.quarter() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testWeekOfMonth1() {
        NSDateComponents dateComponents12 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents12 = NSDateComponents.alloc().init();
        dateComponents12.setWeekOfMonth(2);
        assertTrue(dateComponents12.weekOfMonth() == 2
                && emptyDateComponents12.weekOfMonth() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testWeekOfYear1() {
        NSDateComponents dateComponents13 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents13 = NSDateComponents.alloc().init();
        dateComponents13.setWeekOfYear(5);
        assertTrue(dateComponents13.weekOfYear() == 5
                && emptyDateComponents13.weekOfYear() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testSetEra1() {
        NSDateComponents dateComponents0 = NSDateComponents.alloc().init();
        dateComponents0.setEra(1);
        assertTrue (dateComponents0.era() == 1);
    }

    @Test
    public void testSetYear1() {
        NSDateComponents dateComponents1 = NSDateComponents.alloc().init();
        dateComponents1.setYear(2000);
        assertTrue (dateComponents1.year() == 2000);
    }

    @Test
    public void testSetMonth1() {
        NSDateComponents dateComponents2 = NSDateComponents.alloc().init();
        dateComponents2.setMonth(0);
        assertTrue (dateComponents2.month() == 0);
    }

    @Test
    public void testSetDay1() {
        NSDateComponents dateComponents3 = NSDateComponents.alloc().init();
        dateComponents3.setDay(11);
        assertTrue (dateComponents3.day() == 11);
    }

    @Test
    public void testSetHour1() {
        NSDateComponents dateComponents4 = NSDateComponents.alloc().init();
        dateComponents4.setHour(23);
        assertTrue (dateComponents4.hour() == 23);
    }

    @Test
    public void testSetMinute1() {
        NSDateComponents dateComponents5 = NSDateComponents.alloc().init();
        dateComponents5.setMinute(0);
        assertTrue (dateComponents5.minute() == 0);
    }

    @Test
    public void testSetSecond1() {
        NSDateComponents dateComponents6 = NSDateComponents.alloc().init();
        dateComponents6.setSecond(0);
        assertTrue (dateComponents6.second() == 0);
    }

    @Test
    public void testSetWeekday1() {
        NSDateComponents dateComponents7 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents7 = NSDateComponents.alloc().init();
        dateComponents7.setWeekday(1);
        assertTrue (dateComponents7.weekday() == 1 && emptyDateComponents7.weekday() == Enums.NSUndefinedDateComponent);
    }

    @Test
    public void testSetCalendar1() {
        NSDateComponents dateComponents8 = NSDateComponents.alloc().init();
        NSCalendar gregorianCalendar0 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.NSGregorianCalendar());
        dateComponents8.setCalendar(gregorianCalendar0);
        assertTrue(gregorianCalendar0.calendarIdentifier().equals(
                dateComponents8.calendar().calendarIdentifier()));
    }

    @Test
    public void testSetWeek1() {
        NSDateComponents dateComponents9 = NSDateComponents.alloc().init();
        dateComponents9.setWeek(12);
        assertTrue(dateComponents9.week() == 12);
    }

    @Test
    public void testSetWeekdayOrdinal1() {
        NSDateComponents dateComponents10 = NSDateComponents.alloc().init();
        dateComponents10.setWeekdayOrdinal(3);
        assertTrue(dateComponents10.weekdayOrdinal() == 3) ;
    }

    @Test
    public void testSetQuarter1() {
        NSDateComponents dateComponents11 = NSDateComponents.alloc().init();
        dateComponents11.setQuarter(2);
        assertTrue(dateComponents11.quarter() == 2) ;
    }

    @Test
    public void testSetWeekOfMonth1() {
        NSDateComponents dateComponents12 = NSDateComponents.alloc().init();
        dateComponents12.setWeekOfMonth(2);
        assertTrue(dateComponents12.weekOfMonth() == 2) ;
    }

    @Test
    public void testSetWeekOfYear1() {
        NSDateComponents dateComponents13 = NSDateComponents.alloc().init();
        dateComponents13.setWeekOfYear(5);
        assertTrue(dateComponents13.weekOfYear() == 5) ;
    }

}
