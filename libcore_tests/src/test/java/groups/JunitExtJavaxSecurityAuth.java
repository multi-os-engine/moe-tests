import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    
    org.apache.harmony.tests.javax.security.auth.DestroyFailedExceptionTest.class,
    org.apache.harmony.tests.javax.security.auth.DestroyableTest.class,
    org.apache.harmony.tests.javax.security.auth.LoginExceptionTest.class,
    org.apache.harmony.tests.javax.security.auth.SubjectTest.class,

})
public class JunitExtJavaxSecurityAuth {
} 