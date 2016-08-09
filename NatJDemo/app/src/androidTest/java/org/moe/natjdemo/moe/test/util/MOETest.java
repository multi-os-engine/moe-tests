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

package org.moe.natjdemo.moe.test.util;

import android.test.InstrumentationTestCase;

import ios.coregraphics.struct.CGRect;

import org.junit.Assert;

public abstract class MOETest extends InstrumentationTestCase {

	protected static final void assertArrayEquals(boolean[] expecteds, boolean[] actuals) {
		Assert.assertEquals("arrays don't have the same length", expecteds.length, actuals.length);
		for (int idx = 0; idx < expecteds.length; ++idx) {
			Assert.assertEquals("values compare failed", expecteds[idx], actuals[idx]);
		}
	}

	protected static final void assertArrayEquals(CGRect[] expecteds, CGRect[] actuals) {
		Assert.assertEquals("arrays don't have the same length", expecteds.length, actuals.length);
		for (int idx = 0; idx < expecteds.length; ++idx) {
			assertEquals("values compare failed", expecteds[idx], actuals[idx]);
		}
	}

	protected static final void assertArrayEquals(Object[] expecteds, Object[] actuals) {
		Assert.assertArrayEquals(expecteds, actuals);
	}

	protected static void assertEquals(CGRect expected, CGRect actual) {
		assertEquals(null, expected, actual);
	}

	protected static void assertEquals(String message, CGRect expected, CGRect actual) {
		Assert.assertEquals("CGRect.o.x compare failed", expected.origin().x(), actual.origin().x(), 0.0f);
		Assert.assertEquals("CGRect.o.y compare failed", expected.origin().y(), actual.origin().y(), 0.0f);
		Assert.assertEquals("CGRect.s.w compare failed", expected.size().width(), actual.size().width(), 0.0f);
		Assert.assertEquals("CGRect.s.h compare failed", expected.size().height(), actual.size().height(), 0.0f);
	}

}
