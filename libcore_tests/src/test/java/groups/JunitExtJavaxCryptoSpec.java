import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.javax.crypto.spec.AlgorithmParameterGeneratorTestDH.class,
    libcore.javax.crypto.spec.AlgorithmParameterGeneratorTestDSA.class,
    libcore.javax.crypto.spec.AlgorithmParametersTestAES.class,
    libcore.javax.crypto.spec.AlgorithmParametersTestDES.class,
    libcore.javax.crypto.spec.AlgorithmParametersTestDESede.class,
    libcore.javax.crypto.spec.AlgorithmParametersTestDH.class,
    libcore.javax.crypto.spec.AlgorithmParametersTestDSA.class,
    libcore.javax.crypto.spec.AlgorithmParametersTestOAEP.class,
    libcore.javax.crypto.spec.KeyFactoryTestDH.class,
    libcore.javax.crypto.spec.KeyFactoryTestDSA.class,
    libcore.javax.crypto.spec.KeyFactoryTestRSA.class,
    libcore.javax.crypto.spec.KeyPairGeneratorTestDH.class,
    libcore.javax.crypto.spec.KeyPairGeneratorTestDSA.class,
    libcore.javax.crypto.spec.KeyPairGeneratorTestRSA.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.DESKeySpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.DESedeKeySpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.DHGenParameterSpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.DHParameterSpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.DHPrivateKeySpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.DHPublicKeySpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.GCMParameterSpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.IvParameterSpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.OAEPParameterSpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.PBEKeySpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.PBEParameterSpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.PSourceTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.RC2ParameterSpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.RC5ParameterSpecTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.spec.SecretKeySpecTest.class,

})
public class JunitExtJavaxCryptoSpec {
} 