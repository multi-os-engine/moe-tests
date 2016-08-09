import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    
    org.apache.harmony.tests.javax.security.auth.callback.CallbackHandlerTest.class,
    org.apache.harmony.tests.javax.security.auth.callback.PasswordCallbackTest.class,
    org.apache.harmony.tests.javax.security.auth.callback.UnsupportedCallbackExceptionTest.class,

})
public class JunitExtJavaxSecurityAuthCallback {
} 