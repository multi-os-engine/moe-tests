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

package ios.coregraphics.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.NFloat;

@Generated
@Structure()
public final class CGPoint extends StructObject {
	static {
		NatJ.register();
	}
	private static long __natjCache;

	@Generated
	public CGPoint() {
		super(CGPoint.class);
	}

	@Generated
	protected CGPoint(Pointer peer) {
		super(peer);
	}

	@Generated
	public CGPoint(@NFloat double x, @NFloat double y) {
		super(CGPoint.class);
		setX(x);
		setY(y);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	@NFloat
	public native double x();

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void setX(@NFloat double value);

	@Generated
	@StructureField(order = 1, isGetter = true)
	@NFloat
	public native double y();

	@Generated
	@StructureField(order = 1, isGetter = false)
	public native void setY(@NFloat double value);
}
