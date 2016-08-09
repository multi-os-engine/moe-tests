package xosrt.binding.test.foundation;

import static org.junit.Assert.assertEquals;

import xosrt.binding.foundation.NSAffineTransform;
import xosrt.binding.foundation.NSAffineTransformStruct;
import xosrt.binding.foundation.NSPoint;
import xosrt.binding.foundation.NSSize;
import org.junit.Test;

public class NSAffineTransformTests {

	static {
		System.loadLibrary("Mac");
	}
	
	@Test
	public void testTransform() {
		NSAffineTransform nat = NSAffineTransform.transform();
		NSAffineTransformStruct nts = nat.getTransformStruct();
		double m11 = nts.getM11();
		double m12 = nts.getM12();
		double m21 = nts.getM21();
		double m22 = nts.getM22();
		double tx = nts.getTX();
		double ty = nts.getTY();
		assertEquals(1.0, m11, 0.01);
		assertEquals(0.0, m12, 0.01);
		assertEquals(0.0, m21, 0.01);
		assertEquals(1.0, m22, 0.01);
		assertEquals(0.0, tx, 0.01);
		assertEquals(0.0, ty, 0.01);
	}
	
	@Test
	public void testInitWithTransform() {
		NSAffineTransform nat = NSAffineTransform.transform();
		NSAffineTransform nat2 = NSAffineTransform.alloc().initWithTransform(nat);

		NSAffineTransformStruct nts = nat2.getTransformStruct();
		double m11 = nts.getM11();
		double m12 = nts.getM12();
		double m21 = nts.getM21();
		double m22 = nts.getM22();
		double tx = nts.getTX();
		double ty = nts.getTY();
		assertEquals(1.0, m11, 0.01);
		assertEquals(0.0, m12, 0.01);
		assertEquals(0.0, m21, 0.01);
		assertEquals(1.0, m22, 0.01);
		assertEquals(0.0, tx, 0.01);
		assertEquals(0.0, ty, 0.01);
	}
	
	@Test
	public void testTranslateRotateScale() {
		NSAffineTransform nat = NSAffineTransform.transform();
		nat.translateXByYBy(10, 20);
		nat.rotateByRadians(Math.PI / 4);
		nat.scaleXByYBy(123, 456);
		NSAffineTransformStruct nts = nat.getTransformStruct();
		double m11 = nts.getM11();
		double m12 = nts.getM12();
		double m21 = nts.getM21();
		double m22 = nts.getM22();
		double tx = nts.getTX();
		double ty = nts.getTY();
		
		assertEquals(Math.sqrt(2) / 2 * 123, m11, 0.01);
		assertEquals(Math.sqrt(2) / 2 * 123, m12, 0.01);
		assertEquals(-Math.sqrt(2) / 2 * 456, m21, 0.01);
		assertEquals(Math.sqrt(2) / 2 * 456, m22, 0.01);
		assertEquals(10.0, tx, 0.01);
		assertEquals(20.0, ty, 0.01);
	}

	@Test
	public void testTransformPointSize() {
		NSPoint nsp = new NSPoint(10, 15);
		NSSize nss = new NSSize(25, 35);
		
		NSAffineTransform nat = NSAffineTransform.transform();
		nat.scaleXByYBy(2, 3);
		
		NSPoint nsp2 = nat.transformPoint(nsp);
		NSSize nss2 = nat.transformSize(nss);
		
		assertEquals(20, nsp2.getX(), 0.1);
		assertEquals(45, nsp2.getY(), 0.1);
		assertEquals(50, nss2.getWidth(), 0.1);
		assertEquals(105, nss2.getHeight(), 0.1);
	}
	
	@Test
	public void testAppendPrepend() {
		NSAffineTransform nat = NSAffineTransform.transform();
		NSAffineTransform appendMe = NSAffineTransform.transform();
		NSAffineTransform prependMe = NSAffineTransform.transform();
		
		appendMe.translateXByYBy(10, 20);
		prependMe.scaleBy(10);
		
		nat.appendTransform(appendMe);
		nat.prependTransform(prependMe);
		
		NSAffineTransformStruct nts = nat.getTransformStruct();
		double m11 = nts.getM11();
		double m12 = nts.getM12();
		double m21 = nts.getM21();
		double m22 = nts.getM22();
		double tx = nts.getTX();
		double ty = nts.getTY();
		
		assertEquals(10.0, m11, 0.01);
		assertEquals(0.0, m12, 0.01);
		assertEquals(0.0, m21, 0.01);
		assertEquals(10.0, m22, 0.01);
		assertEquals(10.0, tx, 0.01);
		assertEquals(20.0, ty, 0.01);
	}
}
