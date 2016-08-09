package com.test.struct;


import org.moe.natj.c.CRuntime;
import org.moe.natj.c.StructObject;
import org.moe.natj.c.ann.FunctionPtr;
import org.moe.natj.c.ann.Structure;
import org.moe.natj.c.ann.StructureField;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Runtime;

@Generated
@Structure()
public final class NG_FnPtr_Struct extends StructObject {
	static {
		NatJ.register();
	}

	private static long __natjCache;

	@Generated
	public NG_FnPtr_Struct() {
		super(NG_FnPtr_Struct.class);
	}

	@Generated
	protected NG_FnPtr_Struct(Pointer peer) {
		super(peer);
	}

	@Generated
	@StructureField(order = 0, isGetter = true)
	@FunctionPtr(name = "call_cb1")
	public native Function_cb1 cb1();

	@Runtime(CRuntime.class)
	@Generated
	static public interface Function_cb1 {
		@Generated
		public void call_cb1(int arg0);
	}

	@Generated
	@StructureField(order = 0, isGetter = false)
	public native void setCb1(@FunctionPtr(name = "call_cb1") Function_cb1 value);

	@Generated
	@StructureField(order = 1, isGetter = true)
	@FunctionPtr(name = "call_cb2")
	public native Function_cb2 cb2();

	@Runtime(CRuntime.class)
	@Generated
	static public interface Function_cb2 {
		@Generated
		public void call_cb2(float arg0);
	}

	@Generated
	@StructureField(order = 1, isGetter = false)
	public native void setCb2(@FunctionPtr(name = "call_cb2") Function_cb2 value);
}