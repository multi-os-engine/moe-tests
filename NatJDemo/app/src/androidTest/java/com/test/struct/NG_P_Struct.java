package com.test.struct;


import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;

@Generated
@Structure()
public final class NG_P_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_P_Struct() {
		super(NG_P_Struct.class);
	}

	@Generated
	protected NG_P_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	public native boolean _bool();

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void set_bool(boolean value);

	@Generated
	@StructureField(order = 1, isGetter = true)
	public native byte _byte();

	@Generated
	@StructureField(order = 1, isGetter = false)
	public native void set_byte(byte value);

	@Generated
	@StructureField(order = 2, isGetter = true)
	public native short _short();

	@Generated
	@StructureField(order = 2, isGetter = false)
	public native void set_short(short value);

	@Generated
	@StructureField(order = 3, isGetter = true)
	public native char _char();

	@Generated
	@StructureField(order = 3, isGetter = false)
	public native void set_char(char value);

	@Generated
	@StructureField(order = 4, isGetter = true)
	public native int _int();

	@Generated
	@StructureField(order = 4, isGetter = false)
	public native void set_int(int value);

	@Generated
	@StructureField(order = 5, isGetter = true)
	public native long _long();

	@Generated
	@StructureField(order = 5, isGetter = false)
	public native void set_long(long value);

	@Generated
	@StructureField(order = 6, isGetter = true)
	public native float _float();

	@Generated
	@StructureField(order = 6, isGetter = false)
	public native void set_float(float value);

	@Generated
	@StructureField(order = 7, isGetter = true)
	public native double _double();

	@Generated
	@StructureField(order = 7, isGetter = false)
	public native void set_double(double value);
}