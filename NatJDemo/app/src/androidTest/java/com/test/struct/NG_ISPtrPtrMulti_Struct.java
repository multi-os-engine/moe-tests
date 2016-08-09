package com.test.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.ReferenceInfo;
import org.moe.natj.general.ptr.Ptr;

@Generated
@Structure()
public final class NG_ISPtrPtrMulti_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_ISPtrPtrMulti_Struct() {
		super(NG_ISPtrPtrMulti_Struct.class);
	}

	@Generated
	protected NG_ISPtrPtrMulti_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true, count = 10)
	@ReferenceInfo(type = NG_I_Struct.class, depth = 2)
	public native Ptr<Ptr<NG_I_Struct>> p(int field_idx);

	@Generated
	@StructureField(order = 0, isGetter = false, count = 10)
	public native void setP(Ptr<Ptr<NG_I_Struct>> value, int field_idx);
}