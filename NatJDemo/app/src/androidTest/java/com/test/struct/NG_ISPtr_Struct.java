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
public final class NG_ISPtr_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_ISPtr_Struct() {
		super(NG_ISPtr_Struct.class);
	}

	@Generated
	protected NG_ISPtr_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	public NG_ISPtr_Struct(@UncertainArgument("Options: reference, array Fallback: reference") NG_I_Struct p) {
		super(NG_ISPtr_Struct.class);
		setP(p);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	@UncertainReturn("Options: reference, array Fallback: reference")
	public native NG_I_Struct p();

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void setP(@UncertainArgument("Options: reference, array Fallback: reference") NG_I_Struct value);
}