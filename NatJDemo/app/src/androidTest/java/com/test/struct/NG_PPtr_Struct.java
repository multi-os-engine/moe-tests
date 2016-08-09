package com.test.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ptr.BoolPtr;
import org.moe.natj.general.ptr.BytePtr;
import org.moe.natj.general.ptr.CharPtr;
import org.moe.natj.general.ptr.DoublePtr;
import org.moe.natj.general.ptr.FloatPtr;
import org.moe.natj.general.ptr.IntPtr;
import org.moe.natj.general.ptr.LongPtr;
import org.moe.natj.general.ptr.ShortPtr;

@Generated
@Structure()
public final class NG_PPtr_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_PPtr_Struct() {
		super(NG_PPtr_Struct.class);
	}

	@Generated
	protected NG_PPtr_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	public native BoolPtr _bool();

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void set_bool(BoolPtr value);

	@Generated
	@StructureField(order = 1, isGetter = true)
	public native BytePtr _byte();

	@Generated
	@StructureField(order = 1, isGetter = false)
	public native void set_byte(BytePtr value);

	@Generated
	@StructureField(order = 2, isGetter = true)
	public native ShortPtr _short();

	@Generated
	@StructureField(order = 2, isGetter = false)
	public native void set_short(ShortPtr value);

	@Generated
	@StructureField(order = 3, isGetter = true)
	public native CharPtr _char();

	@Generated
	@StructureField(order = 3, isGetter = false)
	public native void set_char(CharPtr value);

	@Generated
	@StructureField(order = 4, isGetter = true)
	public native IntPtr _int();

	@Generated
	@StructureField(order = 4, isGetter = false)
	public native void set_int(IntPtr value);

	@Generated
	@StructureField(order = 5, isGetter = true)
	public native LongPtr _long();

	@Generated
	@StructureField(order = 5, isGetter = false)
	public native void set_long(LongPtr value);

	@Generated
	@StructureField(order = 6, isGetter = true)
	public native FloatPtr _float();

	@Generated
	@StructureField(order = 6, isGetter = false)
	public native void set_float(FloatPtr value);

	@Generated
	@StructureField(order = 7, isGetter = true)
	public native DoublePtr _double();

	@Generated
	@StructureField(order = 7, isGetter = false)
	public native void set_double(DoublePtr value);
}