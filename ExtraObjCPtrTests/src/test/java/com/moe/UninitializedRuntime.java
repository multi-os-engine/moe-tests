/*
 * Copyright (C) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.moe;

import ios.c.Globals;

import org.junit.Assert;
import org.junit.Test;

import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.general.ptr.impl.PtrFactory;

public class UninitializedRuntime {

	@Test
	public void test_clusteredInit() {
		Ptr<VoidPtr> ptr = (Ptr<VoidPtr>)PtrFactory.newPointerPtr(Void.class, 2, 1, true, false);
		int err = Globals.posix_memalign(ptr, 8, 8);
		
		Assert.assertEquals(err, 0);
		Assert.assertNotEquals(ptr.get().getPeer().getPeer(), 0L);
	} 
	
}
