import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.javax.crypto.CipherInputStreamTest.class,
    libcore.javax.crypto.CipherTest.class,  //crash
    libcore.javax.crypto.ECDHKeyAgreementTest.class,
    libcore.javax.crypto.KeyGeneratorTest.class,
    libcore.javax.crypto.SecretKeyFactoryTest.class,
    libcore.javax.crypto.KeyAgreementTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.BadPaddingExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.CipherInputStream1Test.class,
    org.apache.harmony.crypto.tests.javax.crypto.CipherInputStreamTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.CipherOutputStream1Test.class,
    org.apache.harmony.crypto.tests.javax.crypto.CipherOutputStreamTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.CipherSpiTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.CipherTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.EncryptedPrivateKeyInfoTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.ExemptionMechanismExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.ExemptionMechanismSpiTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.IllegalBlockSizeExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.KeyAgreementSpiTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.KeyAgreementTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.KeyGeneratorSpiTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.KeyGeneratorTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.MacSpiTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.MacTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.NoSuchPaddingExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.NullCipherTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.SealedObjectTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.SecretKeyFactorySpiTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.SecretKeyFactoryTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.SecretKeyTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.ShortBufferExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.ExemptionMechanismTest.class, 
    org.apache.harmony.crypto.tests.javax.crypto.func.CipherAesTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.CipherAesWrapTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.CipherDESedeTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.CipherDESedeWrapTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.CipherDesTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.CipherPBETest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.CipherRSATest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.KeyAgreementFunctionalTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.KeyGeneratorFunctionalTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.MacFunctionalTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.func.SecretKeyFactoryFunctionalTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.serialization.BadPaddingExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.serialization.ExemptionMechanismExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.serialization.IllegalBlockSizeExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.serialization.NoSuchPaddingExceptionTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.serialization.ShortBufferExceptionTest.class,

})
public class JunitExtJavaxCrypto{
}