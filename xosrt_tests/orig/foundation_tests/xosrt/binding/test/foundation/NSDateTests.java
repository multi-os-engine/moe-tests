package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IdArr;
import xosrt.binding.foundation.*;
import org.junit.Ignore;
import org.junit.Test;

public class NSDateTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void testInit1() {
        NSDate  aDate = NSDate.alloc().init();
        assertTrue (aDate != null);
    }

    @Test
    public void testDescription1() {
        NSDate  aDate0 = NSDate.alloc().init();
        NSString  description = aDate0.description();
        assertTrue (description.getLength() > 20);
    }

    @Test
    public void testDateWithTimeIntervalSinceNow1() {
        NSDate aDate1 = NSDate.dateWithTimeIntervalSinceNow(1);
        NSDate aDate2 = NSDate.dateWithTimeIntervalSinceNow(60);

        NSRange range = new NSRange();
        range.setLocation(14);
        range.setLength(2);
        NSString minutes1 = aDate1.description().substringWithRange(range);
        NSString minutes2 = aDate2.description().substringWithRange(range);

        assertTrue(minutes2.getIntValue() - minutes1.getIntValue() > 0
                && minutes2.getIntValue() - minutes1.getIntValue() < 2);
    }

    @Test
    public void testTimeIntervalSinceNow1() {
        NSDate aDate32 = NSDate.dateWithTimeIntervalSinceNow(60);
        double interval = aDate32.getTimeIntervalSinceNow();

        assertTrue( interval <= 60 && interval >= 59);
    }

    //TODO: unimplemented methods
    /*
    @Test
    public void testInitWithTimeIntervalSinceNow1() {
        NSDate aDate12 = NSDate.alloc().initWithTimeIntervalSinceNow(1);
        NSDate aDate13 = NSDate.alloc().initWithTimeIntervalSinceNow(60);

        NSRange range1 = new NSRange();
        range1.setLocation(14);
        range1.setLength(2);

        NSString minutes1 = aDate12.description().substringWithRange(range1);
        NSString minutes2 = aDate13.description().substringWithRange(range1);

        assertTrue( minutes2.getIntValue() - minutes1.getIntValue() > 0
                && minutes2.getIntValue() - minutes1.getIntValue() < 2);
    }
    */

    @Test
    public void testTimeIntervalSinceDate1() {
        NSDate aDate33 = NSDate.dateWithTimeIntervalSinceNow(1);
        NSDate aDate34 = NSDate.dateWithTimeIntervalSinceNow(60);
        double interval2 = aDate34.timeIntervalSinceDate(aDate33);

        assertTrue(interval2 <= 61 && interval2 >= 59);
    }

    @Test
    public void testDate1() {
        NSDate aDate3 = NSDate.date();
        NSDate aDate4 = NSDate.dateWithTimeIntervalSinceNow(0);
        double interval3 = aDate4.timeIntervalSinceDate(aDate3);

        assertTrue(interval3 < 1 && interval3 > -1);
    }

    @Test
    public void testCompare1() {
        NSDate aDate5 = NSDate.dateWithTimeIntervalSinceNow(10);
        NSDate aDate6 = NSDate.dateWithTimeIntervalSinceNow(0);

        assertTrue(aDate5.compare(aDate6) == NSComparisonResult.Descending);
    }

    //TODO: unimplemented methods
    /*
    @Test
    public void testInitWithTimeInterval_sinceDate1() {
        NSDate aDate1 = NSDate.dateWithTimeIntervalSinceNow(1);
        NSDate aDate35 = NSDate.dateWithTimeIntervalSinceNow(1);
        NSDate aDate8 = NSDate.alloc().initWithTimeIntervalSinceDate(60, aDate35);

        NSRange range2 = new NSRange();
        range2.setLocation(14);
        range2.setLength(2);

        NSString minutes3 = aDate1.description().substringWithRange(range2);
        NSString minutes4 = aDate8.description().substringWithRange(range2);

        assertTrue(minutes4.getIntValue() - minutes3.getIntValue() > 0
                && minutes4.getIntValue() - minutes3.getIntValue() < 2);
    }
    */

    @Test
    @Ignore
    //dateWithString is absent for iOS
    public void testDateWithString1() {
        //NSDate aDate9 = NSDate.dateWithString(NSString.fromJavaString("2010-12-25 00:00:00 -0600"));
        //NSString description9 = aDate9.description();

        //assertTrue (description9.getLength() > 20);
    }

    @Test
    public void testDateWithTimeIntervalSince19701() {
        NSDate aDate10 = NSDate.dateWithTimeIntervalSince1970(60);
        NSDate aDate11 = NSDate.dateWithTimeIntervalSince1970(0);

        NSRange range3 = new NSRange();
        range3.setLocation(14);
        range3.setLength(2);

        NSString minutes10 = aDate10.description().substringWithRange(range3);
        NSString minutes11 = aDate11.description().substringWithRange(range3);

        assertTrue(minutes10.getIntValue() - minutes11.getIntValue() == 1);
    }

    @Test
    public void testIsEqualToDate1() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate date0 = df.dateFromString(NSString.fromJavaString("2010-12-25 00:00:00 -0600"));
        NSDate date1 = df.dateFromString(NSString.fromJavaString("2010-12-25 00:00:00 -0600"));
        NSDate date2 = df.dateFromString(NSString.fromJavaString("2012-12-25 00:00:00 -0600"));
        NSDate date3 = null;

        assertTrue (date0.isEqualToDate(date1) && date1.isEqualToDate(date0)
                && !date2.isEqualToDate(date0) && !date1.isEqualToDate(date3)
                && !date2.isEqualToDate(null) && date2.isEqualToDate(date2));
    }

    @Test
    public void testIsEqual1() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate date4 = df.dateFromString(NSString.fromJavaString("2010-12-25 00:00:00 -0600"));
        NSDate date5 = df.dateFromString(NSString.fromJavaString("2010-12-25 00:00:00 -0600"));
        NSDate date6 = df.dateFromString(NSString.fromJavaString("2012-12-25 00:00:00 -0600"));
        NSDate date7 = null;

        assertTrue (date4.isEqual(date5) && date5.isEqual(date4)
                && !date6.isEqual(date4) && !date5.isEqual(date7)
                && !date6.isEqual(null) && date6.isEqual(date6));
    }

    //TODO: unimplemented methods
    /*
    @Test
    public void testCopy1() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate aDate36 = df.dateFromString(NSString.fromJavaString("2012-12-25 00:00:00 -0600"));
        NSDate date7 = aDate36.copy();
        assertTrue (aDate36.isEqual(date7)) ;
    }
    */
    @Test
    public void testEarlierDate1() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate date14 = df.dateFromString(NSString.fromJavaString("2013-03-10 00:00:00 +0000"));
        NSDate date15 = df.dateFromString(NSString.fromJavaString("2015-05-10 00:00:00 +0000"));

        NSDate earlier = date14.earlierDate( date15);

        assertTrue(earlier.isEqualToDate(date14));
    }

    @Test
    public void testLaterDate1() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate date14 = df.dateFromString(NSString.fromJavaString("2013-03-10 00:00:00 +0000"));
        NSDate date15 = df.dateFromString(NSString.fromJavaString("2015-05-10 00:00:00 +0000"));
        NSDate later = date14.laterDate(date15);

        assertTrue(later.isEqualToDate(date15));
    }

    @Test
    public void testInitWithTimeIntervalSince19701() {
        NSDate aDate16 = NSDate.alloc().initWithTimeIntervalSince1970(60);
        NSDate aDate17 = NSDate.alloc().initWithTimeIntervalSince1970(0);

        NSRange range4 = new NSRange();
        range4.setLocation(14);
        range4.setLength(2);

        NSString minutes16 = aDate16.description().substringWithRange(range4);
        NSString minutes17 = aDate17.description().substringWithRange(range4);
        assertTrue(minutes16.getIntValue() - minutes17.getIntValue() == 1);
    }

    @Test
    public void testDateWithTimeInterval_sinceDate1() {
        NSDate aDate37 = NSDate.dateWithTimeIntervalSinceNow(1);
        NSDate aDate18 = NSDate.dateWithTimeIntervalSinceDate(60, aDate37);

        NSRange range5 = new NSRange();
        range5.setLocation(14);
        range5.setLength(2);

        NSString minutes6 = aDate37.description().substringWithRange(range5);
        NSString minutes7 = aDate18.description().substringWithRange(range5);

        assertTrue(minutes7.getIntValue() - minutes6.getIntValue() > 0
                && minutes7.getIntValue() - minutes6.getIntValue() < 2);
    }

    @Test
    public void testDateWithTimeIntervalSinceReferenceDate1() {
        NSDate aDate19 = NSDate.dateWithTimeIntervalSinceReferenceDate(1);
        NSDate aDate20 = NSDate.dateWithTimeIntervalSinceReferenceDate(60);

        NSRange range6 = new NSRange();
        range6.setLocation(14);
        range6.setLength(2);

        NSString minutes8 = aDate19.description().substringWithRange(range6);
        NSString minutes9 = aDate20.description().substringWithRange(range6);

        assertTrue(minutes9.getIntValue() - minutes8.getIntValue() > 0
                && minutes9.getIntValue() - minutes8.getIntValue() < 2);
    }

    @Test
    public void testDistantFuture1() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate aDate21 = df.dateFromString(NSString.fromJavaString("2050-01-01 00:00:00 +0000"));
        NSDate aDate22 = (NSDate)NSDate.distantFuture();
        assertTrue(aDate21.earlierDate(aDate22) != null);
    }

    @Test
    public void testDistantPast1() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate aDate23 = df.dateFromString(NSString.fromJavaString("1900-01-01 00:00:00 +0000"));
        NSDate aDate24 = (NSDate)NSDate.distantPast();
        assertTrue(null != aDate24.earlierDate(aDate23));
    }

    //TODO: unimplemented methods
    /*
    @Test
    public void testTimeIntervalSinceReferenceDate1() {
        double interval6 = NSDate.timeIntervalSinceReferenceDate();
        double interval7 = NSDate.timeIntervalSinceReferenceDate();
        assertTrue(interval6 - interval7 < 10);
    }*/

    @Test
    public void testTimeIntervalSince19701() {
        NSDate aDate26 = NSDate.dateWithTimeIntervalSince1970(6);
        double interval5 = aDate26.getTimeIntervalSince1970();
        assertTrue( interval5 == 6);
    }

    //deprecated method addTimeInterval
    @Test
    @Ignore
    public void testAddTimeInterval1() {
        NSDate aDate28 = NSDate.dateWithTimeIntervalSinceNow(1);
        //NSDate aDate29 = aDate28.addTimeInterval(20);

        NSRange range7 = new NSRange();
        range7.setLocation(14);
        range7.setLength(2);

        NSString minutes18 = aDate28.description().substringWithRange(range7);
       // NSString minutes19 = aDate29.description().substringWithRange(range7);

        //assertTrue(minutes19.getIntValue() - minutes18.getIntValue() >= 0
        //        && minutes19.getIntValue() - minutes18.getIntValue() < 2);
    }

    @Test
    public void testDateByAddingTimeInterval1() {
        NSDate aDate30 = NSDate.dateWithTimeIntervalSinceNow(1);
        NSDate aDate31 = aDate30.dateByAddingTimeInterval( 20);

        NSRange range8 = new NSRange();
        range8.setLocation(14);
        range8.setLength(2);

        NSString minutes20 = aDate30.description().substringWithRange(range8);
        NSString minutes21 = aDate31.description().substringWithRange(range8);

        assertTrue(minutes21.getIntValue() - minutes20.getIntValue() >= 0
                && minutes21.getIntValue() - minutes20.getIntValue() < 2);
    }

    @Test
    public void testDescriptionWithLocale1() {
        NSDateFormatter df = NSDateFormatter.alloc().init();
        df.setDateFormat(NSString.fromJavaString("yyyy-MM-dd HH:mm:ss Z"));
        NSDate aDate21 = df.dateFromString(NSString.fromJavaString("2050-01-01 00:00:00 +0000"));
        IdArr<NSObject> arr = new IdArr<NSObject>(new NSString[] {
                NSString.fromJavaString("six"),
                NSString.fromJavaString("four")
        });
        NSSet set1 = NSSet.alloc().initWithObjectsCount(arr, 2);
        NSString  description1 = aDate21.descriptionWithLocale(set1);
        assertTrue (description1.getLength() > 20);
    }

}
