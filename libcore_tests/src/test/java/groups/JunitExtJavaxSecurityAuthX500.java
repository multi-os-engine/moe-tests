import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.javax.security.auth.x500.GeneralNameTest.class,
    libcore.javax.security.auth.x500.X500PrincipalTest.class,
    org.apache.harmony.tests.javax.security.auth.x500.X500PrincipalTest.class,

})

public class JunitExtJavaxSecurityAuthX500 {
} 