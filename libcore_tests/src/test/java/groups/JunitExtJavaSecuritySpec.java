import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    tests.security.spec.DSAParameterSpecTest.class,
    tests.security.spec.DSAPrivateKeySpecTest.class,
    tests.security.spec.DSAPublicKeySpecTest.class,
    tests.security.spec.ECFieldF2mTest.class,
    tests.security.spec.ECFieldFpTest.class,
    tests.security.spec.ECGenParameterSpecTest.class,
    tests.security.spec.ECParameterSpecTest.class,
    tests.security.spec.ECPointTest.class,
    tests.security.spec.ECPrivateKeySpecTest.class,
    tests.security.spec.ECPublicKeySpecTest.class,
    tests.security.spec.EllipticCurveTest.class,
    tests.security.spec.EncodedKeySpec2Test.class,
    tests.security.spec.EncodedKeySpecTest.class,
    tests.security.spec.InvalidKeySpecExceptionTest.class,
    tests.security.spec.InvalidParameterSpecExceptionTest.class,
    tests.security.spec.MGF1ParameterSpecTest.class,
    tests.security.spec.PKCS8EncodedKeySpecTest.class,
    tests.security.spec.PSSParameterSpecTest.class,
    tests.security.spec.RSAKeyGenParameterSpecTest.class,
    tests.security.spec.RSAMultiPrimePrivateCrtKeySpecTest.class,
    tests.security.spec.RSAOtherPrimeInfoTest.class,
    tests.security.spec.RSAPrivateCrtKeySpecTest.class,
    tests.security.spec.RSAPrivateKeySpecTest.class,
    tests.security.spec.RSAPublicKeySpecTest.class,
    tests.security.spec.X509EncodedKeySpecTest.class,

})
public class JunitExtJavaSecuritySpec {
} 