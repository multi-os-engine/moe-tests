package org.moe.xosrt.binding.test.loadingTest.testClasses;

import org.moe.natj.general.Pointer;
import ios.NSObject;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.objc.ann.Selector;

//AUDIT
public class HeavyObject extends NSObject {

	@Generated("NatJ")
	@Owned
	@Selector("alloc")
	public static native HeavyObject alloc();

	@Generated("NatJ")
	protected HeavyObject(Pointer peer) {
		super(peer);
	}

    @Selector("init")
    public native HeavyObject init();

}
