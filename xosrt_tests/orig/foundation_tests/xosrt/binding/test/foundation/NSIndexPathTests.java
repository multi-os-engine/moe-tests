package xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import xosrt.binding.arrays.IntArr;
import xosrt.binding.foundation.*;
import xosrt.binding.objc.NSUInteger;
import xosrt.binding.objc.NSUIntegerPtr;
import org.junit.Test;

public class NSIndexPathTests {

    static {
        System.loadLibrary("Mac");
    }

    @Test
    public void simpleStaticCreationTest() {
        NSIndexPath testIndexPath = NSIndexPath.indexPathWithIndex(100500L);
        assertNotNull(testIndexPath);
    }

    @Test
    public void indexAtPositionTest() {
        NSIndexPath testIndexPath = NSIndexPath.indexPathWithIndex(100500L);
        assertEquals(100500L, testIndexPath.indexAtPosition(0));
    }

    @Test
    public void indexByAddingIndexTest() {
        NSIndexPath testIndexPath = NSIndexPath.indexPathWithIndex(100500L);
        for (int i = 0; i < 42; i++) testIndexPath = testIndexPath.indexPathByAddingIndex(100500L + 42*(i+1));
        assertEquals(100500L + 42*24, testIndexPath.indexAtPosition(24));
    }

    @Test
    public void getLengthTest() {
        NSIndexPath testIndexPath = NSIndexPath.indexPathWithIndex(0);
        for (int i = 0; i < 100; i++) testIndexPath = testIndexPath.indexPathByAddingIndex(i+1);
        assertEquals(101L, testIndexPath.getLength());
    }

    @Test
    public void indexByRemovingLastIndexTest() {
        NSIndexPath testIndexPath = NSIndexPath.indexPathWithIndex(1);
        for (int i = 0; i < 99; i++) {
            testIndexPath = testIndexPath.indexPathByAddingIndex(i+2);
        }

        assertEquals(99, testIndexPath.indexPathByRemovingLastIndex().getLength());
    }

    @Test
    public void testInitWithIndex1() {
        NSIndexPath  indexPath0 = (NSIndexPath)NSIndexPath.alloc().initWithIndex(4);
        assertTrue (indexPath0 != null);
    }

    //TODO: NSUInteger array
    /*
    @Test
    public void testInitWithIndexes_length1() {
        NSUIntegerPtr x = new NSUIntegerPtr(new long[] {8, 5});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(x,  2);
        assertTrue (path != null && path.getLength() == 2) ;
    }

    @Test
    public void testIndexAtPosition1() {
        NSUIntegerPtr x = new NSUIntegerPtr(new long[] {8, 5});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(x,  2);
        assertTrue (path.indexAtPosition(0) == 8 && path.indexAtPosition(1) == 5);
    }

    @Test
    public void testIndexPathByAddingIndex1() {
        NSUIntegerPtr x = new NSUIntegerPtr(new long[] {8, 5});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(x,  2);
        NSIndexPath path1 = path.indexPathByAddingIndex(4);
        assertTrue (path1.indexAtPosition(0) == 8 && path1.indexAtPosition(1) == 5
                && path1.indexAtPosition(2) == 4) ;
    }

    @Test
    public void testIndexPathByRemovingLastIndex1() {
        NSUIntegerPtr x = new NSUIntegerPtr(new long[] {8, 5, 4});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(x,  3);
        NSIndexPath path2 = path.indexPathByRemovingLastIndex();
        assertTrue (path2.getLength() == 2 && path2.indexAtPosition(0) == 8
                && path2.indexAtPosition(1) == 5) ;
    }

    @Test
    public void testGetIndexes1() {
        NSUIntegerPtr ind = new NSUIntegerPtr(new long[] {3, 2, 5});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(ind,  3);

        NSUIntegerPtr newIndexes2 = new NSUIntegerPtr(new long[(int)path.getLength()]);
        path.getIndexes(newIndexes2);

        long len2 = path.getLength();
        NSIndexPath baseIndexPath2 = NSIndexPath.indexPathWithIndexesLength(newIndexes2, len2);
        assertTrue (baseIndexPath2.getLength() == 3 && baseIndexPath2.indexAtPosition(0) == 3
                && baseIndexPath2.indexAtPosition(1) == 2 && baseIndexPath2.indexAtPosition(2) == 5) ;
    }
    */
    @Test
    public void testIndexPathWithIndex1() {
        NSIndexPath path = NSIndexPath.indexPathWithIndex(3);
        assertTrue (path != null && path.getLength() == 1);
    }

    //TODO: NSInteger array
    /*
    @Test
    public void testIndexPathWithIndexes_length1() {
        NSUIntegerPtr x = new NSUIntegerPtr(new long[] {8, 5, 4});
        NSIndexPath path = NSIndexPath.indexPathWithIndexesLength(x, 2);
        assertTrue (path != null && path.getLength() == 2) ;
    }
    */

    @Test
    public void testLength1() {
        NSIndexPath indexPath1 = (NSIndexPath)NSIndexPath.alloc().initWithIndex(4);
        assertTrue (indexPath1.getLength() == 1);
    }

    @Test
    public void testCompare1() {
        NSIndexPath indexPath2 = (NSIndexPath)NSIndexPath.alloc().initWithIndex(4);
        NSIndexPath  indexPath3 = (NSIndexPath)NSIndexPath.alloc().initWithIndex(5);
        assertTrue (indexPath2.compare(indexPath3) == NSComparisonResult.Ascending);
    }

    //TODO: categories
    /*
    @Test
    public void testIndexPathForRow_inSection1() {
        NSIndexPath indexPath4 = NSIndexPath.indexPathForRowInSection(2, 1);
        assertTrue (indexPath4 != null && indexPath4.getRow() == 2 && indexPath4.getSection() == 1);
    }
    */

    @Test
    public void testRow1() {
        NSIndexPath indexPath5 = NSIndexPath.indexPathForRowInSection(2, 1);
        assertTrue (indexPath5.getRow() == 2);
    }

    //TODO: categories
    /*
    @Test
    public void testSeccion1() {
        NSIndexPath indexPath6 = NSIndexPath.indexPathForRowInSection(2, 8);
        assertTrue (indexPath6.getSection() == 8);
    }
    */

}
