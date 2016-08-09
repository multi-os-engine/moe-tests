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

package org.moe.natjdemo.moe.natjgen.c;

import android.test.InstrumentationTestCase;

import static com.test.c.Globals.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.moe.natj.general.ptr.ConstBoolPtr;
import org.moe.natj.general.ptr.ConstBytePtr;
import org.moe.natj.general.ptr.ConstCharPtr;
import org.moe.natj.general.ptr.ConstDoublePtr;
import org.moe.natj.general.ptr.ConstFloatPtr;
import org.moe.natj.general.ptr.ConstIntPtr;
import org.moe.natj.general.ptr.ConstLongPtr;
import org.moe.natj.general.ptr.ConstShortPtr;

public class VariablesWithPrimitivesTest extends InstrumentationTestCase {

	@Override
	@BeforeClass
	protected void setUp() {
		NGPrepareVariablesWithPrimitivesTest();
	}

	@Test
	public void testBool() {
		// Test default and unit values
		Assert.assertTrue(kNGBoolDefault() == false);
		Assert.assertTrue(kNGBoolUnit() == true);

		// Test array values
		ConstBoolPtr ref = kNGBoolValues();
		Assert.assertTrue(ref.getValue(0) == kNGBoolDefault());
		Assert.assertTrue(ref.getValue(1) == kNGBoolUnit());
		Assert.assertTrue(ref.getValue(2) == kNGBoolValueA());
		Assert.assertTrue(ref.getValue(3) == kNGBoolValueB());
		Assert.assertTrue(ref.getValue(4) == kNGBoolValueC());
	}

	@Test
	public void testByte() {
		// Test default and unit values
		Assert.assertTrue(kNGByteDefault() == 0);
		Assert.assertTrue(kNGByteUnit() == 1);

		// Test array values
		ConstBytePtr ref = kNGByteValues();
		Assert.assertTrue(ref.getValue(0) == kNGByteDefault());
		Assert.assertTrue(ref.getValue(1) == kNGByteUnit());
		Assert.assertTrue(ref.getValue(2) == kNGByteValueA());
		Assert.assertTrue(ref.getValue(3) == kNGByteValueB());
		Assert.assertTrue(ref.getValue(4) == kNGByteValueC());

	}

	@Test
	public void testShort() {
		// Test default and unit values
		Assert.assertTrue(kNGShortDefault() == 0);
		Assert.assertTrue(kNGShortUnit() == 1);

		// Test array values
		ConstShortPtr ref = kNGShortValues();
		Assert.assertTrue(ref.getValue(0) == kNGShortDefault());
		Assert.assertTrue(ref.getValue(1) == kNGShortUnit());
		Assert.assertTrue(ref.getValue(2) == kNGShortValueA());
		Assert.assertTrue(ref.getValue(3) == kNGShortValueB());
		Assert.assertTrue(ref.getValue(4) == kNGShortValueC());
	}

	@Test
	public void testChar() {
		// Test default and unit values
		Assert.assertTrue(kNGCharDefault() == 0);
		Assert.assertTrue(kNGCharUnit() == 1);

		// Test array values
		ConstCharPtr ref = kNGCharValues();
		Assert.assertTrue(ref.getValue(0) == kNGCharDefault());
		Assert.assertTrue(ref.getValue(1) == kNGCharUnit());
		Assert.assertTrue(ref.getValue(2) == kNGCharValueA());
		Assert.assertTrue(ref.getValue(3) == kNGCharValueB());
		Assert.assertTrue(ref.getValue(4) == kNGCharValueC());
	}

	@Test
	public void testInt() {
		// Test default and unit values
		Assert.assertTrue(kNGIntDefault() == 0);
		Assert.assertTrue(kNGIntUnit() == 1);

		// Test array values
		ConstIntPtr ref = kNGIntValues();
		Assert.assertTrue(ref.getValue(0) == kNGIntDefault());
		Assert.assertTrue(ref.getValue(1) == kNGIntUnit());
		Assert.assertTrue(ref.getValue(2) == kNGIntValueA());
		Assert.assertTrue(ref.getValue(3) == kNGIntValueB());
		Assert.assertTrue(ref.getValue(4) == kNGIntValueC());
	}

	@Test
	public void testLong() {
		// Test default and unit values
		Assert.assertTrue(kNGLongDefault() == 0);
		Assert.assertTrue(kNGLongUnit() == 1);

		// Test array values
		ConstLongPtr ref = kNGLongValues();
		Assert.assertTrue(ref.getValue(0) == kNGLongDefault());
		Assert.assertTrue(ref.getValue(1) == kNGLongUnit());
		Assert.assertTrue(ref.getValue(2) == kNGLongValueA());
		Assert.assertTrue(ref.getValue(3) == kNGLongValueB());
		Assert.assertTrue(ref.getValue(4) == kNGLongValueC());
	}

	@Test
	public void testFloat() {
		// Test default and unit values
		Assert.assertTrue(kNGFloatDefault() == 0);
		Assert.assertTrue(kNGFloatUnit() == 1);

		// Test array values
		ConstFloatPtr ref = kNGFloatValues();
		Assert.assertTrue(ref.getValue(0) == kNGFloatDefault());
		Assert.assertTrue(ref.getValue(1) == kNGFloatUnit());
		Assert.assertTrue(ref.getValue(2) == kNGFloatValueA());
		Assert.assertTrue(ref.getValue(3) == kNGFloatValueB());
		Assert.assertTrue(ref.getValue(4) == kNGFloatValueC());
	}

	@Test
	public void testDouble() {
		// Test default and unit values
		Assert.assertTrue(kNGDoubleDefault() == 0);
		Assert.assertTrue(kNGDoubleUnit() == 1);

		// Test array values
		ConstDoublePtr ref = kNGDoubleValues();
		Assert.assertTrue(ref.getValue(0) == kNGDoubleDefault());
		Assert.assertTrue(ref.getValue(1) == kNGDoubleUnit());
		Assert.assertTrue(ref.getValue(2) == kNGDoubleValueA());
		Assert.assertTrue(ref.getValue(3) == kNGDoubleValueB());
		Assert.assertTrue(ref.getValue(4) == kNGDoubleValueC());
	}

}
