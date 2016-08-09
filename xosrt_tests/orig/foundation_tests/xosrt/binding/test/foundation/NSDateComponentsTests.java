package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.foundation.*;
import org.junit.Test;

public class NSDateComponentsTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testEra1() {
        NSDateComponents dateComponents0 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents0 = NSDateComponents.alloc().init();
        dateComponents0.setEra(1);
        assertTrue (dateComponents0.getEra() == 1 && emptyDateComponents0.getEra() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testYear1() {
        NSDateComponents dateComponents1 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents1 = NSDateComponents.alloc().init();
        dateComponents1.setYear(1999);
        assertTrue (dateComponents1.getYear() == 1999 && emptyDateComponents1.getYear() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testMonth1() {
        NSDateComponents dateComponents2 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents2 = NSDateComponents.alloc().init();
        dateComponents2.setMonth(12);
        assertTrue (dateComponents2.getMonth() == 12 && emptyDateComponents2.getMonth() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testDay1() {
        NSDateComponents dateComponents3 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents3 = NSDateComponents.alloc().init();
        dateComponents3.setDay(31);
        assertTrue (dateComponents3.getDay() == 31 && emptyDateComponents3.getDay() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testHour1() {
        NSDateComponents dateComponents4 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents4 = NSDateComponents.alloc().init();
        dateComponents4.setHour(0);
        assertTrue (dateComponents4.getHour() == 0 && emptyDateComponents4.getHour() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testMinute1() {
        NSDateComponents dateComponents5 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents5 = NSDateComponents.alloc().init();
        dateComponents5.setMinute(59);
        assertTrue (dateComponents5.getMinute() == 59 && emptyDateComponents5.getMinute() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testSecond1() {
        NSDateComponents dateComponents6 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents6 = NSDateComponents.alloc().init();
        dateComponents6.setSecond(59);
        assertTrue (dateComponents6.getSecond() == 59 && emptyDateComponents6.getSecond() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testWeekday1() {
        NSDateComponents dateComponents7 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents7 = NSDateComponents.alloc().init();
        dateComponents7.setWeekday(7);
        assertTrue (dateComponents7.getWeekday() == 7 && emptyDateComponents7.getWeekday() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testCalendar1() {
        NSDateComponents dateComponents8 = NSDateComponents.alloc().init();
        NSCalendar gregorianCalendar0 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.GregorianCalendar());
        dateComponents8.setCalendar(gregorianCalendar0);
        assertTrue(gregorianCalendar0.getCalendarIdentifier().isEqual(
                dateComponents8.getCalendar().getCalendarIdentifier()));
    }

    @Test
    public void testWeek1() {
        NSDateComponents dateComponents9 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents9 = NSDateComponents.alloc().init();
        dateComponents9.setWeek(12);
        assertTrue(dateComponents9.week() == 12 && emptyDateComponents9.week() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testWeekdayOrdinal1() {
        NSDateComponents dateComponents10 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents10 = NSDateComponents.alloc().init();
        dateComponents10.setWeekdayOrdinal(3);
        assertTrue(dateComponents10.getWeekdayOrdinal() == 3
                && emptyDateComponents10.getWeekdayOrdinal() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testQuarter1() {
        NSDateComponents dateComponents11 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents11 = NSDateComponents.alloc().init();
        dateComponents11.setQuarter(2);
        assertTrue(dateComponents11.getQuarter() == 2 && emptyDateComponents11.getQuarter() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testWeekOfMonth1() {
        NSDateComponents dateComponents12 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents12 = NSDateComponents.alloc().init();
        dateComponents12.setWeekOfMonth(2);
        assertTrue(dateComponents12.getWeekOfMonth() == 2
                && emptyDateComponents12.getWeekOfMonth() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testWeekOfYear1() {
        NSDateComponents dateComponents13 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents13 = NSDateComponents.alloc().init();
        dateComponents13.setWeekOfYear(5);
        assertTrue(dateComponents13.getWeekOfYear() == 5
                && emptyDateComponents13.getWeekOfYear() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testSetEra1() {
        NSDateComponents dateComponents0 = NSDateComponents.alloc().init();
        dateComponents0.setEra(1);
        assertTrue (dateComponents0.getEra() == 1);
    }

    @Test
    public void testSetYear1() {
        NSDateComponents dateComponents1 = NSDateComponents.alloc().init();
        dateComponents1.setYear(2000);
        assertTrue (dateComponents1.getYear() == 2000);
    }

    @Test
    public void testSetMonth1() {
        NSDateComponents dateComponents2 = NSDateComponents.alloc().init();
        dateComponents2.setMonth(0);
        assertTrue (dateComponents2.getMonth() == 0);
    }

    @Test
    public void testSetDay1() {
        NSDateComponents dateComponents3 = NSDateComponents.alloc().init();
        dateComponents3.setDay(11);
        assertTrue (dateComponents3.getDay() == 11);
    }

    @Test
    public void testSetHour1() {
        NSDateComponents dateComponents4 = NSDateComponents.alloc().init();
        dateComponents4.setHour(23);
        assertTrue (dateComponents4.getHour() == 23);
    }

    @Test
    public void testSetMinute1() {
        NSDateComponents dateComponents5 = NSDateComponents.alloc().init();
        dateComponents5.setMinute(0);
        assertTrue (dateComponents5.getMinute() == 0);
    }

    @Test
    public void testSetSecond1() {
        NSDateComponents dateComponents6 = NSDateComponents.alloc().init();
        dateComponents6.setSecond(0);
        assertTrue (dateComponents6.getSecond() == 0);
    }

    @Test
    public void testSetWeekday1() {
        NSDateComponents dateComponents7 = NSDateComponents.alloc().init();
        NSDateComponents emptyDateComponents7 = NSDateComponents.alloc().init();
        dateComponents7.setWeekday(1);
        assertTrue (dateComponents7.getWeekday() == 1 && emptyDateComponents7.getWeekday() == Foundation.UndefinedDateComponent);
    }

    @Test
    public void testSetCalendar1() {
        NSDateComponents dateComponents8 = NSDateComponents.alloc().init();
        NSCalendar gregorianCalendar0 = (NSCalendar)NSCalendar.alloc().initWithCalendarIdentifier(
                Foundation.GregorianCalendar());
        dateComponents8.setCalendar(gregorianCalendar0);
        assertTrue(gregorianCalendar0.getCalendarIdentifier().isEqual(
                dateComponents8.getCalendar().getCalendarIdentifier()));
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
        assertTrue(dateComponents10.getWeekdayOrdinal() == 3) ;
    }

    @Test
    public void testSetQuarter1() {
        NSDateComponents dateComponents11 = NSDateComponents.alloc().init();
        dateComponents11.setQuarter(2);
        assertTrue(dateComponents11.getQuarter() == 2) ;
    }

    @Test
    public void testSetWeekOfMonth1() {
        NSDateComponents dateComponents12 = NSDateComponents.alloc().init();
        dateComponents12.setWeekOfMonth(2);
        assertTrue(dateComponents12.getWeekOfMonth() == 2) ;
    }

    @Test
    public void testSetWeekOfYear1() {
        NSDateComponents dateComponents13 = NSDateComponents.alloc().init();
        dateComponents13.setWeekOfYear(5);
        assertTrue(dateComponents13.getWeekOfYear() == 5) ;
    }

}
