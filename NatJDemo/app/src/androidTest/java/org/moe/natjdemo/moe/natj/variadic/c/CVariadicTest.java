/*
 * Copyright 2014-2016 Intel Corporation
 *
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.eclipse.org/org/documents/epl-v10.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.moe.natjdemo.moe.natj.variadic.c;

import android.test.InstrumentationTestCase;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;

import org.junit.Assert;
import org.junit.Test;

import org.moe.natj.c.map.CStringMapper;
import org.moe.natj.general.VariadicArg;
import org.moe.natj.general.ptr.BytePtr;
import org.moe.natj.general.ptr.impl.PtrFactory;

public class CVariadicTest extends InstrumentationTestCase {
	@Test
	public void testPointerVariadicFunction() {
		BytePtr buff = PtrFactory.newByteArray(40);
		CGSize obj = new CGSize(0, 0);
		ios.c.Globals.sprintf(buff, "%s", "teststr");
		String res = buff.toASCIIString();
		String exp = "teststr";
		Assert.assertEquals(res, exp);
	}	
	
	@Test
	public void testBooleanVariadicFunction() {
		Assert.assertTrue(VariadicFunctions.testBooleansWithPairNumber(3, true, true, false, false, true, true));
		Assert.assertFalse(VariadicFunctions.testBooleansWithPairNumber(3, true, true, false, false, true, false));
	}
	
	@Test
	public void testByteVariadicFunction() {
		Assert.assertTrue(VariadicFunctions.testBytesWithPairNumber(3, (byte) 5, (byte) 5, (byte) 6, (byte) 6, (byte) 7, (byte) 7));
		Assert.assertFalse(VariadicFunctions.testBytesWithPairNumber(3, (byte) 5, (byte) 5, (byte) 6, (byte) 6, (byte) 7, (byte) 8));
	}
	
	@Test
	public void testCharVariadicFunction() {
		Assert.assertTrue(VariadicFunctions.testCharsWithPairNumber(3, (char) 5, (char) 5, (char) 6, (char) 6, (char) 7, (char) 7));
		Assert.assertFalse(VariadicFunctions.testCharsWithPairNumber(3, (char) 5, (char) 5, (char) 6, (char) 6, (char) 7, (char) 8));
	}
	
	@Test
	public void testShortVariadicFunction() {
		Assert.assertTrue(VariadicFunctions.testShortsWithPairNumber(3, (short) 5, (short) 5, (short) 6, (short) 6, (short) 7, (short) 7));
		Assert.assertFalse(VariadicFunctions.testShortsWithPairNumber(3, (short) 5, (short) 5, (short) 6, (short) 6, (short) 7, (short) 8));
	}
	
	@Test
	public void testIntVariadicFunction() {
		Assert.assertTrue(VariadicFunctions.testIntsWithPairNumber(3, 5, 5, 6, 6, 7, 7));
		Assert.assertFalse(VariadicFunctions.testIntsWithPairNumber(3, 5, 5, 6, 6, 7, 8));
	}
	
	@Test
	public void testLongVariadicFunction() {
		Assert.assertTrue(VariadicFunctions.testLongsWithPairNumber(3, 5L, 5L, 6L, 6L, 7L, 7L));
		Assert.assertFalse(VariadicFunctions.testLongsWithPairNumber(3, 5L, 5L, 6L, 6L, 7L, 8L));
	}
	
	@Test
	public void testFloatVariadicFunction() {
		Assert.assertTrue(VariadicFunctions.testFloatsWithPairNumber(3, 5f, 5f, 6f, 6f, 7f, 7f));
		Assert.assertFalse(VariadicFunctions.testFloatsWithPairNumber(3, 5f, 5f, 6f, 6f, 7f, 8f));
		
		Assert.assertTrue(VariadicFunctions.testUnboxingFloatsWithPairNumber(3, 5f, 5f, 6f, 6f, 7f, 7f));
		Assert.assertFalse(VariadicFunctions.testUnboxingFloatsWithPairNumber(3, 5f, 5f, 6f, 6f, 7f, 8f));
		
		VariadicArg.UnboxVariadicArg a = VariadicArg.createUnbox(10f);
		VariadicArg.UnboxVariadicArg b = VariadicArg.createUnbox(9f);
		
		Assert.assertTrue(VariadicFunctions.testExplicitUnboxingFloatsWithPairNumber(3, a, a, b, b, a, a));
		Assert.assertFalse(VariadicFunctions.testExplicitUnboxingFloatsWithPairNumber(3, a, a, b, b, a, b));
	}
	
	@Test
	public void testDoubleVariadicFunction() {
		Assert.assertTrue(VariadicFunctions.testDoublesWithPairNumber(3, 5.0, 5.0, 6.0, 6.0, 7.0, 7.0));
		Assert.assertFalse(VariadicFunctions.testDoublesWithPairNumber(3, 5.0, 5.0, 6.0, 6.0, 7.0, 8.0));
	}
	
	@Test
	public void testCGRectVariadicFunction() {
		VariadicArg.ByValueVariadicArg a = VariadicArg.createByValue(new CGRect(new CGPoint(0, 0), new CGSize(10, 10)));
		VariadicArg.ByValueVariadicArg b = VariadicArg.createByValue(new CGRect(new CGPoint(0, 0), new CGSize(9, 9)));
		
		Assert.assertTrue(VariadicFunctions.testCGRectsWithPairNumber(3, a, a, b, b, a, a));
		Assert.assertFalse(VariadicFunctions.testCGRectsWithPairNumber(3, a, a, b, b, a, b));
	}
	
	@Test
	public void testCStringVariadicFunction() {
		VariadicArg.MapVariadicArg a = VariadicArg.createMap("a", CStringMapper.class);
		VariadicArg.MapVariadicArg b = VariadicArg.createMap("b", CStringMapper.class);
		
		Assert.assertTrue(VariadicFunctions.testCStringsWithPairNumber(3, a, a, b, b, a, a));
		Assert.assertFalse(VariadicFunctions.testCStringsWithPairNumber(3, a, a, b, b, a, b));
	}
	
	@Test
	public void testNFloatVariadicFunction() {		
		Assert.assertTrue(VariadicFunctions.testNFloatsWithPairNumber(3, 5f, 5f, 6f, 6f, 7f, 7f));
		Assert.assertFalse(VariadicFunctions.testNFloatsWithPairNumber(3, 5f, 5f, 6f, 6f, 7f, 8f));
		
		VariadicArg.NFloatVariadicArg a = VariadicArg.createNFloat(10.0);
		VariadicArg.NFloatVariadicArg b = VariadicArg.createNFloat(9.0);
		
		Assert.assertTrue(VariadicFunctions.testExplicitNFloatsWithPairNumber(3, a, a, b, b, a, a));
		Assert.assertFalse(VariadicFunctions.testExplicitNFloatsWithPairNumber(3, a, a, b, b, a, b));
	}
	
	@Test
	public void testNUIntVariadicFunction() {		
		Assert.assertTrue(VariadicFunctions.testNUIntsWithPairNumber(3, 5L, 5L, 6L, 6L, 7L, 7L));
		Assert.assertFalse(VariadicFunctions.testNUIntsWithPairNumber(3, 5L, 5L, 6L, 6L, 7L, 8L));
		
		VariadicArg.NUIntVariadicArg a = VariadicArg.createNUInt(10L);
		VariadicArg.NUIntVariadicArg b = VariadicArg.createNUInt(9L);
		
		Assert.assertTrue(VariadicFunctions.testExplicitNUIntsWithPairNumber(3, a, a, b, b, a, a));
		Assert.assertFalse(VariadicFunctions.testExplicitNUIntsWithPairNumber(3, a, a, b, b, a, b));
	}
	
	@Test
	public void testNIntVariadicFunction() {		
		Assert.assertTrue(VariadicFunctions.testNUIntsWithPairNumber(3, -5L, -5L, -6L, -6L, -7L, -7L));
		Assert.assertFalse(VariadicFunctions.testNUIntsWithPairNumber(3, -5L, -5L, -6L, -6L, -7L, -8L));
		
		VariadicArg.NIntVariadicArg a = VariadicArg.createNInt(10L);
		VariadicArg.NIntVariadicArg b = VariadicArg.createNInt(9L);
		
		Assert.assertTrue(VariadicFunctions.testExplicitNIntsWithPairNumber(3, a, a, b, b, a, a));
		Assert.assertFalse(VariadicFunctions.testExplicitNIntsWithPairNumber(3, a, a, b, b, a, b));
	}
}
