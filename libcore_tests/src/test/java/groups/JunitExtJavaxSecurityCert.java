import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    
    org.apache.harmony.tests.javax.security.cert.CertificateEncodingExceptionTest.class,
    org.apache.harmony.tests.javax.security.cert.CertificateExceptionTest.class,
    org.apache.harmony.tests.javax.security.cert.CertificateExpiredExceptionTest.class,
    org.apache.harmony.tests.javax.security.cert.CertificateNotYetValidExceptionTest.class,
    org.apache.harmony.tests.javax.security.cert.CertificateParsingExceptionTest.class,
    org.apache.harmony.tests.javax.security.cert.CertificateTest.class,
    org.apache.harmony.tests.javax.security.cert.X509CertificateTest.class,
    
})
public class JunitExtJavaxSecurityCert {
} 