package com.test.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.ReferenceInfo;
import org.moe.natj.general.ptr.BoolPtr;
import org.moe.natj.general.ptr.BytePtr;
import org.moe.natj.general.ptr.CharPtr;
import org.moe.natj.general.ptr.DoublePtr;
import org.moe.natj.general.ptr.FloatPtr;
import org.moe.natj.general.ptr.IntPtr;
import org.moe.natj.general.ptr.LongPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.ShortPtr;
import java.lang.Boolean;
import java.lang.Byte;
import java.lang.Character;
import java.lang.Double;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Short;

@Generated
@Structure()
public final class NG_PPtrPtr_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_PPtrPtr_Struct() {
		super(NG_PPtrPtr_Struct.class);
	}

	@Generated
	protected NG_PPtrPtr_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	@ReferenceInfo(type = Boolean.class, depth = 2)
	public native Ptr<BoolPtr> _bool();

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void set_bool(Ptr<BoolPtr> value);

	@Generated
	@StructureField(order = 1, isGetter = true)
	@ReferenceInfo(type = Byte.class, depth = 2)
	public native Ptr<BytePtr> _byte();

	@Generated
	@StructureField(order = 1, isGetter = false)
	public native void set_byte(Ptr<BytePtr> value);

	@Generated
	@StructureField(order = 2, isGetter = true)
	@ReferenceInfo(type = Short.class, depth = 2)
	public native Ptr<ShortPtr> _short();

	@Generated
	@StructureField(order = 2, isGetter = false)
	public native void set_short(Ptr<ShortPtr> value);

	@Generated
	@StructureField(order = 3, isGetter = true)
	@ReferenceInfo(type = Character.class, depth = 2)
	public native Ptr<CharPtr> _char();

	@Generated
	@StructureField(order = 3, isGetter = false)
	public native void set_char(Ptr<CharPtr> value);

	@Generated
	@StructureField(order = 4, isGetter = true)
	@ReferenceInfo(type = Integer.class, depth = 2)
	public native Ptr<IntPtr> _int();

	@Generated
	@StructureField(order = 4, isGetter = false)
	public native void set_int(Ptr<IntPtr> value);

	@Generated
	@StructureField(order = 5, isGetter = true)
	@ReferenceInfo(type = Long.class, depth = 2)
	public native Ptr<LongPtr> _long();

	@Generated
	@StructureField(order = 5, isGetter = false)
	public native void set_long(Ptr<LongPtr> value);

	@Generated
	@StructureField(order = 6, isGetter = true)
	@ReferenceInfo(type = Float.class, depth = 2)
	public native Ptr<FloatPtr> _float();

	@Generated
	@StructureField(order = 6, isGetter = false)
	public native void set_float(Ptr<FloatPtr> value);

	@Generated
	@StructureField(order = 7, isGetter = true)
	@ReferenceInfo(type = Double.class, depth = 2)
	public native Ptr<DoublePtr> _double();

	@Generated
	@StructureField(order = 7, isGetter = false)
	public native void set_double(Ptr<DoublePtr> value);
}