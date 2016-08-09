import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.lang.ref.SoftReferenceTest.class,
    org.apache.harmony.tests.java.lang.ref.PhantomReferenceTest.class,
    org.apache.harmony.tests.java.lang.ref.ReferenceQueueTest.class,
    org.apache.harmony.tests.java.lang.ref.ReferenceTest.class,
    org.apache.harmony.tests.java.lang.ref.WeakReferenceTest.class,
    libcore.java.lang.ref.FinalizeTest.class,
    libcore.java.lang.ref.ReferenceQueueTest.class,

})
public class JunitExtJavaLangRef {
} 