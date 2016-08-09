import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.javax.net.ServerSocketFactoryTest.class,
    org.apache.harmony.tests.javax.net.SocketFactoryTest.class,
    libcore.javax.net.ServerSocketFactoryTest.class,
    
})
public class JunitExtJavaxNet {

} 