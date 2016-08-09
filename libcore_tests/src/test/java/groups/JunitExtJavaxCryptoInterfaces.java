import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.crypto.tests.javax.crypto.interfaces.DHPrivateKeyTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.interfaces.DHPublicKeyTest.class,
    org.apache.harmony.crypto.tests.javax.crypto.interfaces.PBEKeyTest.class,

})
public class JunitExtJavaxCryptoInterfaces {
} 