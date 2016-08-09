package xosrt.binding.test.loadingTest.testClasses;

import xosrt.binding.annotation.NativeName;
import xosrt.binding.annotation.NativeSelector;
import xosrt.binding.core.NativeObject;
import xosrt.binding.core.Registrator;

@NativeName("HeavyObject")
public class HeavyObject extends NativeObject {
	static {
		Registrator.registerClassObject(HeavyObject.class);
	}
	
	@NativeSelector("alloc")
	public static native HeavyObject alloc(); 
	
	@NativeSelector("init")
	public native HeavyObject init();
}
