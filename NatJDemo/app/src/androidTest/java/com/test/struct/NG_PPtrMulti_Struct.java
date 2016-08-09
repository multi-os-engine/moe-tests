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
public final class NG_PPtrMulti_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_PPtrMulti_Struct() {
		super(NG_PPtrMulti_Struct.class);
	}

	@Generated
	protected NG_PPtrMulti_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	public native BoolPtr _bool();

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void set_bool(BoolPtr value);

	@Generated
	@StructureField(order = 1, isGetter = true, count = 2)
	public native BytePtr _byte(int field_idx);

	@Generated
	@StructureField(order = 1, isGetter = false, count = 2)
	public native void set_byte(BytePtr value, int field_idx);

	@Generated
	@StructureField(order = 2, isGetter = true, count = 3)
	public native ShortPtr _short(int field_idx);

	@Generated
	@StructureField(order = 2, isGetter = false, count = 3)
	public native void set_short(ShortPtr value, int field_idx);

	@Generated
	@StructureField(order = 3, isGetter = true, count = 4)
	public native CharPtr _char(int field_idx);

	@Generated
	@StructureField(order = 3, isGetter = false, count = 4)
	public native void set_char(CharPtr value, int field_idx);

	@Generated
	@StructureField(order = 4, isGetter = true, count = 5)
	public native IntPtr _int(int field_idx);

	@Generated
	@StructureField(order = 4, isGetter = false, count = 5)
	public native void set_int(IntPtr value, int field_idx);

	@Generated
	@StructureField(order = 5, isGetter = true, count = 6)
	public native LongPtr _long(int field_idx);

	@Generated
	@StructureField(order = 5, isGetter = false, count = 6)
	public native void set_long(LongPtr value, int field_idx);

	@Generated
	@StructureField(order = 6, isGetter = true, count = 7)
	public native FloatPtr _float(int field_idx);

	@Generated
	@StructureField(order = 6, isGetter = false, count = 7)
	public native void set_float(FloatPtr value, int field_idx);

	@Generated
	@StructureField(order = 7, isGetter = true, count = 8)
	public native DoublePtr _double(int field_idx);

	@Generated
	@StructureField(order = 7, isGetter = false, count = 8)
	public native void set_double(DoublePtr value, int field_idx);
}