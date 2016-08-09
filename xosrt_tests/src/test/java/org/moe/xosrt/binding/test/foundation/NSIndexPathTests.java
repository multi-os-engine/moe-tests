package org.moe.xosrt.binding.test.foundation;

import org.moe.natj.general.ptr.NUIntPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;

import static org.junit.Assert.*;

import ios.foundation.*;
import ios.foundation.enums.NSComparisonResult;

import org.junit.Test;

public class NSIndexPathTests {

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
        assertEquals(101L, testIndexPath.length());
    }

    @Test
    public void indexByRemovingLastIndexTest() {
        NSIndexPath testIndexPath = NSIndexPath.indexPathWithIndex(1);
        for (int i = 0; i < 99; i++) {
            testIndexPath = testIndexPath.indexPathByAddingIndex(i+2);
        }

        assertEquals(99, testIndexPath.indexPathByRemovingLastIndex().length());
    }

    @Test
    public void testInitWithIndex1() {
        NSIndexPath  indexPath0 = (NSIndexPath)NSIndexPath.alloc().initWithIndex(4);
        assertTrue (indexPath0 != null);
    }

    @Test
    public void testInitWithIndexes_length1() {
        NUIntPtr x = PtrFactory.newNUIntArray(new long[] {8, 5});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(x,  2);
        assertTrue (path != null && path.length() == 2) ;
    }

    @Test
    public void testIndexAtPosition1() {
        NUIntPtr x = PtrFactory.newNUIntArray(new long[] {8, 5});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(x,  2);
        assertTrue (path.indexAtPosition(0) == 8 && path.indexAtPosition(1) == 5);
    }

    @Test
    public void testIndexPathByAddingIndex1() {
        NUIntPtr x = PtrFactory.newNUIntArray(new long[] {8, 5});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(x,  2);
        NSIndexPath path1 = path.indexPathByAddingIndex(4);
        assertTrue (path1.indexAtPosition(0) == 8 && path1.indexAtPosition(1) == 5
                && path1.indexAtPosition(2) == 4) ;
    }

    @Test
    public void testIndexPathByRemovingLastIndex1() {
        NUIntPtr x = PtrFactory.newNUIntArray(new long[] {8, 5, 4});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(x,  3);
        NSIndexPath path2 = path.indexPathByRemovingLastIndex();
        assertTrue (path2.length() == 2 && path2.indexAtPosition(0) == 8
                && path2.indexAtPosition(1) == 5) ;
    }

    @Test
    public void testGetIndexes1() {
        NUIntPtr ind = PtrFactory.newNUIntArray(new long[] {3, 2, 5});
        NSIndexPath path = NSIndexPath.alloc().initWithIndexesLength(ind,  3);

        NUIntPtr newIndexes2 = PtrFactory.newNUIntArray(new long[(int)path.length()]);
        path.getIndexes(newIndexes2);

        long len2 = path.length();
        NSIndexPath baseIndexPath2 = NSIndexPath.indexPathWithIndexesLength(newIndexes2, len2);
        assertTrue (baseIndexPath2.length() == 3 && baseIndexPath2.indexAtPosition(0) == 3
                && baseIndexPath2.indexAtPosition(1) == 2 && baseIndexPath2.indexAtPosition(2) == 5) ;
    }
    
    @Test
    public void testIndexPathWithIndex1() {
        NSIndexPath path = NSIndexPath.indexPathWithIndex(3);
        assertTrue (path != null && path.length() == 1);
    }

    @Test
    public void testIndexPathWithIndexes_length1() {
        NUIntPtr x = PtrFactory.newNUIntArray(new long[] {8, 5, 4});
        NSIndexPath path = NSIndexPath.indexPathWithIndexesLength(x, 2);
        assertTrue (path != null && path.length() == 2) ;
    }
    

    @Test
    public void testLength1() {
        NSIndexPath indexPath1 = (NSIndexPath)NSIndexPath.alloc().initWithIndex(4);
        assertTrue (indexPath1.length() == 1);
    }

    @Test
    public void testCompare1() {
        NSIndexPath indexPath2 = (NSIndexPath)NSIndexPath.alloc().initWithIndex(4);
        NSIndexPath  indexPath3 = (NSIndexPath)NSIndexPath.alloc().initWithIndex(5);
        assertTrue (indexPath2.compare(indexPath3) == NSComparisonResult.Ascending);
    }


    @Test
    public void testIndexPathForRow_inSection1() {
    	if (!System.getProperty("java.vendor").startsWith("Oracle")) {					// Checking if we are on iOS
	        NSIndexPath indexPath4 = NSIndexPath.indexPathForRowInSection(2, 1);
	        assertTrue (indexPath4 != null && indexPath4.row() == 2 && indexPath4.section() == 1);
    	}
    }


    @Test
    public void testRow1() {
    	if (!System.getProperty("java.vendor").startsWith("Oracle")) {					// Checking if we are on iOS
            NSIndexPath indexPath5 = NSIndexPath.indexPathForRowInSection(2, 1);
            assertTrue (indexPath5.row() == 2);
    	}
    }


    @Test
    public void testSection1() {
    	if (!System.getProperty("java.vendor").startsWith("Oracle")) {					// Checking if we are on iOS
    		NSIndexPath indexPath6 = NSIndexPath.indexPathForRowInSection(2, 8);
    		assertTrue (indexPath6.section() == 8);
    	}
    }


}
