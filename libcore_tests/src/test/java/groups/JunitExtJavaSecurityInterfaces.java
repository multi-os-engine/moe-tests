import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    tests.security.interfaces.DSAKeyPairGeneratorTest.class,
    tests.security.interfaces.DSAKeyTest.class,
    tests.security.interfaces.DSAParamsTest.class,
    tests.security.interfaces.RSAKeyTest.class,  //crash
    tests.security.interfaces.RSAMultiPrimePrivateCrtKeyTest.class,
    tests.security.interfaces.RSAPrivateCrtKeyTest.class,   //crash
    tests.security.interfaces.RSAPrivateKeyTest.class,  //crash
    tests.security.interfaces.RSAPublicKeyTest.class,   //crash
    tests.security.interfaces.DSAPrivateKeyTest.class,
    tests.security.interfaces.DSAPublicKeyTest.class,
    
})
public class JunitExtJavaSecurityInterfaces {
} 