import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    tests.security.acl.AclNotFoundException2Test.class,
    tests.security.acl.AclNotFoundExceptionTest.class,
    tests.security.acl.LastOwnerException2Test.class,
    tests.security.acl.LastOwnerExceptionTest.class,
    tests.security.acl.NotOwnerException2Test.class,
    tests.security.acl.NotOwnerExceptionTest.class,
   
})
public class JunitExtJavaSecurityAcl {
}