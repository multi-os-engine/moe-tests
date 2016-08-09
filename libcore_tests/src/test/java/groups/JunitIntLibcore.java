import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.internal.StringPoolTest.class,
    org.apache.harmony.tests.org.apache.harmony.kernel.dalvik.ThreadsTest.class,
    sun.misc.UnsafeTest.class,

})
public class JunitIntLibcore {
} 