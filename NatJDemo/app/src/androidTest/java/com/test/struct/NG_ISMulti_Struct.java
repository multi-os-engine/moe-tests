package com.test.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.ByValue;
import org.moe.natj.general.ann.Generated;

@Generated
@Structure()
public final class NG_ISMulti_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_ISMulti_Struct() {
		super(NG_ISMulti_Struct.class);
	}

	@Generated
	protected NG_ISMulti_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true, count = 5)
	@ByValue
	public native NG_I_Struct p(int field_idx);

	@Generated
	@StructureField(order = 0, isGetter = false, count = 5)
	public native void setP(@ByValue NG_I_Struct value, int field_idx);
}