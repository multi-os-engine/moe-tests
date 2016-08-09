package com.test.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.UncertainArgument;
import org.moe.natj.general.ann.UncertainReturn;

@Generated
@Structure()
public final class NG_ISPtrMulti_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_ISPtrMulti_Struct() {
		super(NG_ISPtrMulti_Struct.class);
	}

	@Generated
	protected NG_ISPtrMulti_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true, count = 10)
	@UncertainReturn("Options: reference, array Fallback: reference")
	public native NG_I_Struct p(int field_idx);

	@Generated
	@StructureField(order = 0, isGetter = false, count = 10)
	public native void setP(@UncertainArgument("Options: reference, array Fallback: reference") NG_I_Struct value,
			int field_idx);
}