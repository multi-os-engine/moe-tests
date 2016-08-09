package org.moe.xosrt.binding.test.uikit;

import static org.junit.Assert.*;

import ios.coregraphics.c.CoreGraphics;
import ios.coregraphics.enums.CGRectEdge;
import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;

import org.junit.Test;

public class CGRectTests {

    public static int WAIT_TIMEOUT = 0;

    public static void starter() {}

    @Test
    public void testCGPoint__point1() {
        CGPoint point1 = new CGPoint();
        point1.setX(3.0);
        double xx = point1.x();
        assertTrue (xx - 3.0 < 0.1);
    }

    @Test
    public void testCGPoint__point2() {
        CGPoint point1 = new CGPoint();
        point1.setY(5);
        assertTrue (point1.y() - 5 < 0.1);
    }

    @Test
    public void testCGSize__width1() {
        CGSize size1 = new CGSize();
        size1.setWidth(2);
        assertTrue (size1.width() - 2 < 0.1);
    }

    @Test
    public void testCGSize__height2() {
        CGSize size1 = new CGSize();
        size1.setHeight(4);
        assertTrue (size1.height() - 4 < 0.1);
    }

    @Test
    public void testCGRect__origin1() {
        CGPoint point1 = new CGPoint();
        point1.setX(3.0);
        point1.setY(5);
        CGRect cgrect = new CGRect();
        cgrect.setOrigin(point1);
        CGPoint point2 = cgrect.origin();
        assertTrue (point1.x() == point2.x() && point1.y() == point2.y());
    }

    @Test
    public void testCGRect__size1() {
        CGSize size1 = new CGSize();
        size1.setWidth(2);
        size1.setHeight(4);
        CGRect cgrect = new CGRect();
        cgrect.setSize(size1);
        CGSize size2 = cgrect.size();
        assertTrue( size1.width() == size2.width() && size1.height() == size2.height());
    }

    @Test
    public void testCGRectMake1() {
        CGRect rect2 = CoreGraphics.CGRectMake(2, 3, 4, 5);
        assertTrue (rect2.origin().x() == 2 && rect2.origin().y() == 3 && rect2.size().width() == 4 && rect2.size().height() == 5 );
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testCGSizeMake1() {
        CGSize size3 = CGSizeMake(10, 234);
        assertTrue (size3.width() == 10 && size3.height() == 234);
    }

    @Test
    public void testCGPointMake1() {
        CGPoint point5  = CGPointMake(34, 55);
        assertTrue (point5.x() == 34 && point5.y() == 55);
    }
    */

    @Test
    public void testCGRectEqualToRect1() {
        CGRect rect0 = CoreGraphics.CGRectMake(10, 20, 250, 100);
        assertTrue(CoreGraphics.CGRectEqualToRect(rect0, CoreGraphics.CGRectMake(10, 20, 250, 100)));
    }

    @Test
    public void testCGRectEqualToRect2() {
        CGRect rect1 = CoreGraphics.CGRectMake(10, 20, 250, 100);
        assertTrue(!CoreGraphics.CGRectEqualToRect(rect1, CoreGraphics.CGRectMake(20, 20, 250, 100)));
    }

    //TODO: unimplemented method
    /*
    @Test
    public void testCGPointEqualToPoint1() {
        assertTrue(CGPointEqualToPoint(CGPointMake(10, 50), CGPointMake(10, 50)));
    }

    @Test
    public void testCGPointEqualToPoint2() {
        assertTrue(!CGPointEqualToPoint(CGPointMake(10, 50), CGPointMake(10, 70)));
    }

    @Test
    public void testCGSizeEqualToSize1() {
        assertTrue(CGSizeEqualToSize(CGSizeMake(10, 50), CGSizeMake(10, 50)));
    }

    @Test
    public void testCGSizeEqualToSize2() {
        assertTrue(!CGSizeEqualToSize(CGSizeMake(10, 50), CGSizeMake(10, 70)));
    }
    */
    @Test
    public void testCGRectIntersectsRect1() {
        CGRect rect2 = CoreGraphics.CGRectMake(1, 1, 3, 2);
        CGRect rect3 = CoreGraphics.CGRectMake(3, 2, 2, 2);
        CGRect rect4 = CoreGraphics.CGRectMake(0, 0, 1, 1);
        CGRect rect5 = CoreGraphics.CGRectMake(1, 1, 1, 1);

        assertTrue (CoreGraphics.CGRectIntersectsRect(rect2, rect3)
                && !CoreGraphics.CGRectIntersectsRect(rect4, rect5));
    }

    @Test
    public void testCGRectContainsPoint1() {
        assertTrue(CoreGraphics.CGRectContainsPoint(CoreGraphics.CGRectMake(20, 20, 250, 100),
                CoreGraphics.CGPointMake(40, 50)));
    }

    @Test
    public void testCGRectContainsPoint2() {
        assertTrue(!CoreGraphics.CGRectContainsPoint(CoreGraphics.CGRectMake(20, 20, 250, 100),
                CoreGraphics.CGPointMake(10, 20)));
    }

    @Test
    public void testCGRectContainsRect1() {
        assertTrue(CoreGraphics.CGRectContainsRect(CoreGraphics.CGRectMake(20, 20, 250, 100),
                CoreGraphics.CGRectMake(20, 25, 50, 50)));
    }

    @Test
    public void testCGRectContainsRect2() {
        assertTrue(!CoreGraphics.CGRectContainsRect(CoreGraphics.CGRectMake(20, 20, 250, 100),
                CoreGraphics.CGRectMake(20, 20, 270, 50)));
    }

    @Test
    public void testCGRectGetMidX1() {
        CGRect rect0 = CoreGraphics.CGRectMake(10, 20, 250, 100);
        CGRect rect1 = CoreGraphics.CGRectMake(100, 200, -100, -100);
        double x = CoreGraphics.CGRectGetMidX(rect0);
        assertTrue (x == 135 && CoreGraphics.CGRectGetMidX(rect1) == 50);
    }

    @Test
    public void testCGRectGetMidY1() {
        CGRect rect2 = CoreGraphics.CGRectMake(10, 0, 50, 50);
        CGRect rect3 = CoreGraphics.CGRectMake(200, 100, -50, -50);
        double y = CoreGraphics.CGRectGetMidY(rect2);
        assertTrue (y == 25 && CoreGraphics.CGRectGetMidY(rect3) == 75);
    }

    @Test
    public void testCGRectGetMinY1() {
        CGRect rect4 = CoreGraphics.CGRectMake(0, 100, 100, 300);
        CGRect rect5 = CoreGraphics.CGRectMake(200, 100, -40, -40);
        double miny = CoreGraphics.CGRectGetMinY(rect4);
        assertTrue (miny == 100 && CoreGraphics.CGRectGetMinY(rect5) == 60);
    }

    @Test
    public void testCGRectGetMinX1() {
        CGRect rect6 = CoreGraphics.CGRectMake(0, 0, 200, 100);
        CGRect rect7 = CoreGraphics.CGRectMake(200, 100, -100, -100);
        double minx = CoreGraphics.CGRectGetMinX(rect6);
        assertTrue (minx == 0 && CoreGraphics.CGRectGetMinX(rect7) == 100);
    }

    @Test
    public void testCGRectGetMaxX1() {
        CGRect rect8 = CoreGraphics.CGRectMake(0, 0, 100, 200);
        CGRect rect9 = CoreGraphics.CGRectMake(200, 100, -100, -100);
        double maxx = CoreGraphics.CGRectGetMaxX(rect8);
        assertTrue (maxx == 100 && CoreGraphics.CGRectGetMaxX(rect9) == 200);
    }

    @Test
    public void testCGRectGetMaxY1() {
        CGRect rect10 = CoreGraphics.CGRectMake(20, 0, 100, 100);
        CGRect rect11 = CoreGraphics.CGRectMake(200, 100, -100, -100);
        double maxy = CoreGraphics.CGRectGetMaxY(rect10);
        assertTrue (maxy == 100 && CoreGraphics.CGRectGetMaxY(rect11) == 100);
    }

    @Test
    public void testCGRectGetHeight1() {
        CGRect rect0 = CoreGraphics.CGRectMake(0, 0, 10, 100);
        double h = CoreGraphics.CGRectGetHeight(rect0);
        assertTrue (h == 100);
    }

    @Test
    public void testCGRectGetWidth1() {
        CGRect rect1 = CoreGraphics.CGRectMake(0, 0, 250, 100);
        double w = CoreGraphics.CGRectGetWidth(rect1);
        assertTrue (w == 250);
    }

    @Test
    public void testCGPointZero1() {
        CGPoint point3 = CoreGraphics.CGPointZero();
        assertTrue (point3.x() == 0 && point3.y() == 0);
    }

    @Test
    public void testCGSizeZero1() {
        CGSize sizeZero = CoreGraphics.CGSizeZero();
        assertTrue (sizeZero.width() == 0 && sizeZero.height() == 0);
    }

    @Test
    public void testCGRectZero1() {
        CGRect rectZero = CoreGraphics.CGRectZero();
        assertTrue (rectZero.origin().x() == 0 && rectZero.origin().y() == 0
                && rectZero.size().width() == 0 && rectZero.size().height() == 0);
    }

    @Test
    public void testCGRectDivide1() {
        CGRect rectMinX = CoreGraphics.CGRectMake(0.0, 0.0, 100.0, 100.0);
        CGRect sliceMinX = CoreGraphics.CGRectZero();
        CGRect remainderMinX = CoreGraphics.CGRectZero();
        CoreGraphics.CGRectDivide(rectMinX, sliceMinX, remainderMinX, 40.0, CGRectEdge.MinXEdge);
        assertTrue (CoreGraphics.CGRectEqualToRect(sliceMinX, CoreGraphics.CGRectMake(0, 0, 40, 100))
                && CoreGraphics.CGRectEqualToRect(remainderMinX, CoreGraphics.CGRectMake(40, 0, 60, 100))) ;
    }

    @Test
    public void testCGRectDivide2() {
        CGRect rectMinY = CoreGraphics.CGRectMake(0.0, 0.0, 100.0, 100.0);
        CGRect sliceMinY = CoreGraphics.CGRectZero();
        CGRect remainderMinY = CoreGraphics.CGRectZero();
        CoreGraphics.CGRectDivide(rectMinY, sliceMinY, remainderMinY, 40.0, CGRectEdge.MinYEdge);

        assertTrue(CoreGraphics.CGRectEqualToRect(sliceMinY, CoreGraphics.CGRectMake(0, 0, 100, 40))
                && CoreGraphics.CGRectEqualToRect(remainderMinY, CoreGraphics.CGRectMake(0, 40, 100, 60)));
    }

    @Test
    public void testCGRectDivide3() {
        CGRect rectMaxX = CoreGraphics.CGRectMake(0, 0, 700, 1000);
        CGRect sliceMaxX = CoreGraphics.CGRectZero();
        CGRect remainderMaxX = CoreGraphics.CGRectZero();
        CoreGraphics.CGRectDivide(rectMaxX, sliceMaxX, remainderMaxX, 400, CGRectEdge.MaxXEdge);
        assertTrue(CoreGraphics.CGRectEqualToRect(sliceMaxX, CoreGraphics.CGRectMake(300, 0, 400, 1000))
                && CoreGraphics.CGRectEqualToRect(remainderMaxX, CoreGraphics.CGRectMake(0, 0, 300, 1000))) ;
    }

    @Test
    public void testCGRectDivide4() {
        CGRect rectMaxY = CoreGraphics.CGRectMake(0, 0, 900, 1000);
        CGRect sliceMaxY = CoreGraphics.CGRectZero();
        CGRect remainderMaxY = CoreGraphics.CGRectZero();
        CoreGraphics.CGRectDivide(rectMaxY, sliceMaxY, remainderMaxY, 500.0, CGRectEdge.MaxYEdge);
        assertTrue(CoreGraphics.CGRectEqualToRect(sliceMaxY, CoreGraphics.CGRectMake(0, 500, 900, 500))
                && CoreGraphics.CGRectEqualToRect(remainderMaxY, CoreGraphics.CGRectMake(0, 0, 900, 500))) ;
    }

    @Test
    public void testCGRectIntersection1() {
        CGRect rect2 = CoreGraphics.CGRectMake(1, 1, 3, 2);
        CGRect rect3 = CoreGraphics.CGRectMake(3, 2, 2, 2);
        CGRect rect4 = CoreGraphics.CGRectIntersection(rect2, rect3);
        assertTrue(CoreGraphics.CGRectEqualToRect(rect4, CoreGraphics.CGRectMake(3, 2, 1, 1))) ;
    }

    @Test
    public void testCGRectUnion1() {
        CGRect rect_0 = CoreGraphics.CGRectMake(5, 0, 200, 100);
        CGRect rect_1 = CoreGraphics.CGRectMake(10, 20, 260, 100);

        CGRect rect_2 = CoreGraphics.CGRectUnion(rect_0, rect_1);
        assertTrue (rect_2.origin().x() == 5 && rect_2.origin().y() == 0
                && rect_2.size().width() == 265 && rect_2.size().height() == 120) ;
    }

    @Test
    public void testCGRectOffset1() {
        CGRect rect_0 = CoreGraphics.CGRectMake(5, 25, 200, 100);
        CGRect rect_2 = CoreGraphics.CGRectOffset(rect_0, 30, 20);

        assertTrue (rect_2.origin().x() == 35 && rect_2.origin().y() == 45
                && rect_2.size().width() == 200 && rect_2.size().height() == 100) ;
    }

    @Test
    public void testCGRectStandardize1() {
        CGRect rect5 = CoreGraphics.CGRectMake(5, 4, -2, -1);
        CGRect rect6 = CoreGraphics.CGRectMake(6, 7, -3, 8);
        CGRect rect7 = CoreGraphics.CGRectMake(10, 10, 3, -8);
        CGRect rect8 = CoreGraphics.CGRectMake(5, 5, 5, 5);
        CGRect rect9 = CoreGraphics.CGRectMake(-10,-10 , 20, 20);
        CGRect rect10 = CoreGraphics.CGRectMake(-10,-10 , -1, -1);
        assertTrue (CoreGraphics.CGRectEqualToRect(CoreGraphics.CGRectStandardize(rect5), CoreGraphics.CGRectMake(3, 3, 2, 1))
                && CoreGraphics.CGRectEqualToRect(CoreGraphics.CGRectStandardize(rect6), CoreGraphics.CGRectMake(3, 7, 3, 8))
                && CoreGraphics.CGRectEqualToRect(CoreGraphics.CGRectStandardize(rect7), CoreGraphics.CGRectMake(10, 2, 3, 8))
                && CoreGraphics.CGRectEqualToRect(CoreGraphics.CGRectStandardize(rect8), CoreGraphics.CGRectMake(5, 5, 5, 5))
                && CoreGraphics.CGRectEqualToRect(CoreGraphics.CGRectStandardize(rect9), CoreGraphics.CGRectMake(-10, -10, 20, 20))
                && CoreGraphics.CGRectEqualToRect(CoreGraphics.CGRectStandardize(rect10), CoreGraphics.CGRectMake(-11, -11, 1, 1))) ;
    }

    @Test
    public void testCGRectIntegral1() {
        CGRect rect11 =  CoreGraphics.CGRectMake(10.5, 10.11, 9.56, 9.12);
        CGRect rect12 = CoreGraphics.CGRectMake(15.8, 16.9, -1.8989, -7.0001);
        CGRect rect13 = CoreGraphics.CGRectMake(-5.8, -6.9, 14.07, 13.001);
        CGRect rect14 = CoreGraphics.CGRectMake(-4.8, -7.9, -6.9, -3.7);
        CGRect rect15 = CoreGraphics.CGRectMake(8, 9, 10, 11);
        CGRect integralRect0 = CoreGraphics.CGRectIntegral(rect11);
        CGRect integralRect1 = CoreGraphics.CGRectIntegral(rect12);
        CGRect integralRect2 = CoreGraphics.CGRectIntegral(rect13);
        CGRect integralRect3 = CoreGraphics.CGRectIntegral(rect14);
        CGRect integralRect4 = CoreGraphics.CGRectIntegral(rect15);
        assertTrue (CoreGraphics.CGRectEqualToRect(integralRect0, CoreGraphics.CGRectMake(10, 10, 11, 10))
                && CoreGraphics.CGRectEqualToRect(integralRect1, CoreGraphics.CGRectMake(13, 9, 3, 8))
                && CoreGraphics.CGRectEqualToRect(integralRect2, CoreGraphics.CGRectMake(-6, -7, 15, 14))
                && CoreGraphics.CGRectEqualToRect(integralRect3, CoreGraphics.CGRectMake(-12, -12, 8, 5))
                && CoreGraphics.CGRectEqualToRect(integralRect4, CoreGraphics.CGRectMake(8, 9, 10, 11))) ;
    }

    @Test
    public void testCGRectInset1() {
        CGRect rect_5 = CoreGraphics.CGRectMake(13, 112, 132, 225);
        CGRect rect_6 = CoreGraphics.CGRectInset(rect_5, 5, 7);
        assertTrue((rect_6.origin().x() - 18.0 < 0.1) && (rect_6.origin().y() - 119 < 0.1)
                && (rect_6.size().width() - 122.0 < 0.1) && (rect_6.size().height() - 211.0 < 0.1));
    }

    @Test
    public void testCGRectInset2() {
        CGRect rect_7 = CoreGraphics.CGRectMake(25, 42, 105, 325);
        CGRect rect_8 = CoreGraphics.CGRectInset(rect_7, 8, 3);
        assertTrue((rect_8.origin().x() - 33.0 < 0.1) && (rect_8.origin().y() - 45.0 < 0.1)
                && (rect_8.size().width() - 89.0 < 0.1) && (rect_8.size().height() - 319.0 < 0.1));
    }

    @Test
    public void testCGRectIsEmpty1() {
        CGRect rect0 = CoreGraphics.CGRectMake(0, 0, 0, 0);
        CGRect rect1 = CoreGraphics.CGRectMake(1, 1, 1, 0);
        CGRect rect2 = CoreGraphics.CGRectMake(1, 1, 0, 1);
        assertTrue (CoreGraphics.CGRectIsEmpty(rect0) && CoreGraphics.CGRectIsEmpty(rect1)
                && CoreGraphics.CGRectIsEmpty(rect2) && CoreGraphics.CGRectIsEmpty(CoreGraphics.CGRectNull()));
    }

    @Test
    public void testCGRectIsNull1() {
        CGRect rect3 = CoreGraphics.CGRectMake(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 0);
        CGRect rect4 = CoreGraphics.CGRectNull();
        assertTrue (CoreGraphics.CGRectIsNull(rect3) && CoreGraphics.CGRectIsNull(rect4)
                && CoreGraphics.CGRectIsNull(CoreGraphics.CGRectNull()));
    }

    @Test
    public void testCGRectIsInfinite1() {
        CGRect rect5 = CoreGraphics.CGRectInfinite();
        assertTrue (CoreGraphics.CGRectIsInfinite(rect5) && CoreGraphics.CGRectIsInfinite(CoreGraphics.CGRectInfinite()));
    }
}
