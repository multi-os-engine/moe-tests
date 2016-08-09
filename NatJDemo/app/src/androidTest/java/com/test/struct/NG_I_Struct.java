package com.test.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;

@Generated
@Structure()
public final class NG_I_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_I_Struct() {
		super(NG_I_Struct.class);
	}

	@Generated
	protected NG_I_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	public NG_I_Struct(int x, int y) {
		super(NG_I_Struct.class);
		setX(x);
		setY(y);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	public native int x();

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void setX(int value);

	@Generated
	@StructureField(order = 1, isGetter = true)
	public native int y();

	@Generated
	@StructureField(order = 1, isGetter = false)
	public native void setY(int value);
}