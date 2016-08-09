package org.moe.xosrt.binding.test.foundation;

import static org.junit.Assert.*;

import org.moe.xosrt.binding.test.foundation.Utils.XOSTest;
import org.junit.Test;

import java.util.Random;

public class MathLibraryTests extends XOSTest{

    private final static float PI = 3.14159265358979323846f;

    @Test
    public void testSqrt1() {
        double d1 = 81.00;
        double d2 = Math.sqrt(d1);
        assertTrue ( d2 == 9.00 );
    }

    @Test
    public void testPow1() {
        double d3 = 3.00;
        double d4 = Math.pow(d3, 3);
        assertTrue ( d4 == 27 );
    }

    @Test
    public void testCos1() {
        double d5 = Math.cos(PI / 4);
        assertTrue ( d5 >= 0.707 && d5 <= 0.708 );
    }

    @Test
    public void testSin1() {
        double d6 = Math.sin(PI / 4);
        assertTrue ( d6 >= 0.707 && d6 <= 0.708 );
    }

    @Test
    public void testTan1() {
        double d7 = PI/4;
        double d8 = Math.tan(d7);
        assertTrue ( d8 >= 0.999 && d8 <= 1.001 );
    }

    @Test
    public void testAcos1() {
        double d9 = 0.707;
        double d10 = Math.acos(d9);
        assertTrue ( d10 >= (PI/4-0.01) && d10 <= (PI/4+0.01) );
    }

    @Test
    public void testAsin1() {
        double d11 = 0.707;
        double d12 = Math.asin(d11);
        assertTrue ( d12 >= (PI/4-0.01) && d12 <= (PI/4+0.01) );
    }

    @Test
    public void testAtan1() {
        double d13 = 1;
        double d14 = Math.atan(d13);
        assertTrue ( d14 >= (PI/4-0.01) && d14 <= (PI/4+0.01) );
    }

    @Test
    public void testAtan21() {
        double d15 = 1;
        double d16 = Math.atan2(d15, 1);
        assertTrue ( d16 >= (PI/4-0.01) && d16 <= (PI/4+0.01) );
    }

    @Test
    public void testAbs1() {
        int i1 = -1;
        int i2 = Math.abs(i1);
        assertTrue( i2 == 1);
    }

    @Test
    public void testFmin1() {
        double d29 = 1.50;
        double d30 = 1.49;
        double d31 = Math.min(d29, d30);
        assertTrue ( d31 == d30 );
    }

    @Test
    public void testFmax1() {
        double d32 = 1.50;
        double d33 = 1.49;
        double d34 = Math.max(d32, d33);
        assertTrue (d34 == d32 );
    }

    @Test
    public void testCeil1() {
        double d19 = 6.05;
        double d20 = Math.ceil(d19);
        assertTrue ( d20 == 7.00 );
    }

    @Test
    public void testFloor1() {
        double d21 = 6.05;
        double d22 = Math.floor(d21);
        assertTrue ( d22 == 6.00 );
    }

    @Test
    public void testLog1() {
        double d23 = 10;
        double d24 = Math.log(d23);
        assertTrue( d24 >= 2.300 && d24 <= 2.310 );
    }

    @Test
    public void testExp1() {
        double d25 = 2;
        double d26 = Math.exp(d25);
        assertTrue( d26 >= 7.388 && d26 <= 7.390 );
    }

    @Test
    public void testRound1() {
        double d27 = 1.8;
        double d28 = Math.round(d27);
        assertTrue (d28 == 2.00);
    }

    @Test
    public void testRound2() {
        double d35 = 1.612;
        double d36 = Math.round(d35);
        assertTrue (d36 == 2.00);
    }

    @Test
    public void testRand1() {
        Random rand = new Random();
        int randomNum = rand.nextInt(11);
        assertTrue(randomNum >=0 && randomNum <=10);
    }

    @Test
    public void testRand2() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3);
        assertTrue(randomNum >=0 && randomNum <=2);
    }

    @Test
    public void testRand3() {
        Random rand = new Random();
        int randomNum = rand.nextInt(2);
        assertTrue(randomNum >=0 && randomNum <=1);
    }

    @Test
    public void testSrandom1() {
        Random rand = new Random();
        long rand1 = rand.nextLong();
        rand.setSeed(4);
        long rand2 = rand.nextLong();
        assertTrue(rand1 != rand2 );
    }

    @Test
    public void testSran1() {
        Random rand = new Random();
        rand.setSeed(1);
        long rand1 = rand.nextLong();
        rand.setSeed(3);
        long rand2 = rand.nextLong();
        assertTrue(rand1 != rand2 );
    }

    @Test
    public void testAtoi1() {
        String string = "1234";
        int intNumber = Integer.parseInt( string );
        assertTrue(intNumber == 1234);
    }

    @Test
    public void testAtof1() {
        String stringDouble = "1.334455";
        double doubleNumber = Double.parseDouble( stringDouble );
        assertTrue(doubleNumber == 1.334455);
    }

    @Test
    public void testAtol1() {
        String stringLong = "2147111222";
        long longNumber = Long.parseLong( stringLong);
        assertTrue(longNumber == 2147111222);
    }

}
