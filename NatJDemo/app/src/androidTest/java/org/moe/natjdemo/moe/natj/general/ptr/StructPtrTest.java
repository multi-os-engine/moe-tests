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

package org.moe.natjdemo.moe.natj.general.ptr;

import org.moe.natj.general.ptr.Ptr;

import ios.coregraphics.struct.CGRect;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.moe.natjdemo.moe.test.util.DataSource;
import org.moe.natjdemo.moe.test.util.MOETest;

public class StructPtrTest extends MOETest {

	private static final CGRect OBJECT_VALUES[] = DataSource.getStructs();

	private static final int NUM_VALUES = OBJECT_VALUES.length;
	private static final int SUB_FROM = 1;
	private static final int SUB_TO = NUM_VALUES - 1;
	private static final int SUB_LENGTH = SUB_TO - SUB_FROM;

	private Ptr<CGRect> getTestPtr() {
		return DataSource.getStructTestPtr();
	}

	private Ptr<CGRect> getZeroPtr() {
		return DataSource.getStructZeroPtr();
	}

	private void failIfConst(Ptr<CGRect> ptr) {
		if (ptr.isConstPtr()) {
			Assert.fail("failed to throw exception (const ptr)");
		}
	}

	@Before
	public void prepare() {
		Assert.assertNotNull("test values did not initialize", OBJECT_VALUES);
	}

	@Test
	public void test_get__ConstPtr() {
		CGRect exp = OBJECT_VALUES[0];
		CGRect act = getTestPtr().get();
		assertEquals(exp, act);
	}

	@Test
	public void test_get_idx__ConstPtr() {
		Ptr<CGRect> ptr = getTestPtr();
		for (int idx = 0; idx < NUM_VALUES; ++idx) {
			CGRect exp = OBJECT_VALUES[idx];
			CGRect act = ptr.get(idx);
			assertEquals(exp, act);
		}
	}

	@Test
	public void test_toArray_len__ConstPtr() {
		CGRect[] exp = OBJECT_VALUES;
		CGRect[] act = getTestPtr().toArray(NUM_VALUES);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_toArray_from_to__ConstPtr() {
		CGRect[] exp = Arrays.copyOfRange(OBJECT_VALUES, SUB_FROM, SUB_TO);
		CGRect[] act = getTestPtr().toArray(SUB_FROM, SUB_TO);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_copyTo_dest__ConstPtr() {
		CGRect[] exp = OBJECT_VALUES;
		CGRect[] act = new CGRect[NUM_VALUES];
		getTestPtr().copyTo(act);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_copyTo_dest_len__ConstPtr() {
		CGRect[] exp = Arrays.copyOfRange(OBJECT_VALUES, 0, SUB_LENGTH);
		CGRect[] act = new CGRect[NUM_VALUES];
		getTestPtr().copyTo(act, SUB_LENGTH);
		act = Arrays.copyOfRange(act, 0, SUB_LENGTH);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_copyTo_srcoff_dest_destoff_len__ConstPtr() {
		CGRect[] exp = Arrays.copyOfRange(OBJECT_VALUES, SUB_FROM, SUB_TO);
		CGRect[] act = new CGRect[NUM_VALUES];
		getTestPtr().copyTo(SUB_FROM, act, SUB_FROM, SUB_LENGTH);
		act = Arrays.copyOfRange(act, SUB_FROM, SUB_TO);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_set_value__Ptr() {
		CGRect exp = OBJECT_VALUES[0];
		Ptr<CGRect> ptr = getZeroPtr();
		try {
			ptr.set(exp);
			failIfConst(ptr);
		} catch (UnsupportedOperationException ex) {
			if (ptr.isConstPtr()) {
				return;
			}
			Assert.fail("unexpected exception");
		}
		CGRect act = ptr.get();
		assertEquals(exp, act);
	}

	@Test
	public void test_set_idx_value__Ptr() {
		Ptr<CGRect> ptr = getZeroPtr();
		for (int idx = 0; idx < NUM_VALUES; ++idx) {
			CGRect exp = OBJECT_VALUES[idx];
			try {
				ptr.set(idx, exp);
				failIfConst(ptr);
			} catch (UnsupportedOperationException ex) {
				if (ptr.isConstPtr()) {
					return;
				}
				Assert.fail("unexpected exception");
			}
			CGRect act = ptr.get(idx);
			assertEquals(exp, act);
		}
	}

	@Test
	public void test_copyFrom_src__Ptr() {
		CGRect[] exp = OBJECT_VALUES;
		Ptr<CGRect> ptr = getZeroPtr();
		try {
			ptr.copyFrom(exp);
			failIfConst(ptr);
		} catch (UnsupportedOperationException ex) {
			if (ptr.isConstPtr()) {
				return;
			}
			Assert.fail("unexpected exception");
		}
		CGRect[] act = ptr.toArray(NUM_VALUES);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_copyFrom_src_destoff__Ptr() {
		CGRect[] exp = Arrays.copyOfRange(OBJECT_VALUES, SUB_FROM, SUB_TO);
		Ptr<CGRect> ptr = getZeroPtr();
		try {
			ptr.copyFrom(exp, SUB_FROM);
			failIfConst(ptr);
		} catch (UnsupportedOperationException ex) {
			if (ptr.isConstPtr()) {
				return;
			}
			Assert.fail("unexpected exception");
		}
		CGRect[] act = ptr.toArray(SUB_FROM, SUB_TO);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_copyFrom_src_destoff_len__Ptr() {
		CGRect[] exp = Arrays.copyOfRange(OBJECT_VALUES, SUB_FROM, SUB_TO);
		Ptr<CGRect> ptr = getZeroPtr();
		try {
			ptr.copyFrom(exp, SUB_FROM, SUB_LENGTH);
			failIfConst(ptr);
		} catch (UnsupportedOperationException ex) {
			if (ptr.isConstPtr()) {
				return;
			}
			Assert.fail("unexpected exception");
		}
		CGRect[] act = ptr.toArray(SUB_FROM, SUB_TO);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_copyFrom_src_srcoff_destoff_len__Ptr() {
		CGRect[] exp = Arrays.copyOfRange(OBJECT_VALUES, SUB_FROM, SUB_TO);
		Ptr<CGRect> ptr = getZeroPtr();
		try {
			ptr.copyFrom(OBJECT_VALUES, SUB_FROM, SUB_FROM, SUB_LENGTH);
			failIfConst(ptr);
		} catch (UnsupportedOperationException ex) {
			if (ptr.isConstPtr()) {
				return;
			}
			Assert.fail("unexpected exception");
		}
		CGRect[] act = ptr.toArray(SUB_FROM, SUB_TO);
		assertArrayEquals(exp, act);
	}

	@Test
	public void test_ofs_idx() {
		CGRect[] exp = Arrays.copyOfRange(OBJECT_VALUES, SUB_FROM, SUB_TO);
		Ptr<CGRect> ofs = (Ptr<CGRect>) getTestPtr().ofs(SUB_FROM);
		CGRect[] act = ofs.toArray(SUB_LENGTH);
		assertArrayEquals(exp, act);
		Assert.assertEquals(getTestPtr().getClass(), ofs.getClass());
	}

	@Test
	public void test_getGuarded_len() {
		Ptr<CGRect> ptr = (Ptr<CGRect>) getTestPtr().getGuarded(NUM_VALUES);
		Assert.assertNotNull(ptr);
		Assert.assertTrue(ptr.isGuarded());
		Assert.assertTrue(ptr.isConstPtr() == getTestPtr().isConstPtr());
		Assert.assertEquals(0, ptr.getGuardLow());
		Assert.assertEquals(NUM_VALUES, ptr.getGuardHigh());
	}

	@Test
	public void test_getGuarded_from_to() {
		Ptr<CGRect> ptr = (Ptr<CGRect>) getTestPtr().getGuarded(SUB_FROM, SUB_TO);
		Assert.assertNotNull(ptr);
		Assert.assertTrue(ptr.isGuarded());
		Assert.assertTrue(ptr.isConstPtr() == getTestPtr().isConstPtr());
		Assert.assertEquals(SUB_FROM, ptr.getGuardLow());
		Assert.assertEquals(SUB_TO, ptr.getGuardHigh());
	}

}
