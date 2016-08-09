package com.test.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;

@Generated
@Structure()
public final class NG_I2_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_I2_Struct() {
		super(NG_I2_Struct.class);
	}

	@Generated
	protected NG_I2_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true, count = 2)
	public native int x(int field_idx);

	@Generated
	@StructureField(order = 0, isGetter = false, count = 2)
	public native void setX(int value, int field_idx);

	@Generated
	@StructureField(order = 1, isGetter = true, count = 2)
	public native int y(int field_idx);

	@Generated
	@StructureField(order = 1, isGetter = false, count = 2)
	public native void setY(int value, int field_idx);
}