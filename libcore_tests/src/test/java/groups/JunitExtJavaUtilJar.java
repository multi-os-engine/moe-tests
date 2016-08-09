import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.util.jar.AttributesNameTest.class,
    org.apache.harmony.tests.java.util.jar.AttributesTest.class,
    org.apache.harmony.tests.java.util.jar.JarEntryTest.class,
    org.apache.harmony.tests.java.util.jar.JarExceptionTest.class,
    org.apache.harmony.tests.java.util.jar.JarFileTest.class,
    org.apache.harmony.tests.java.util.jar.JarInputStreamTest.class,
    org.apache.harmony.tests.java.util.jar.JarOutputStreamTest.class,
    org.apache.harmony.tests.java.util.jar.ManifestTest.class,
    libcore.java.util.jar.OldAttributesNameTest.class,
    libcore.java.util.jar.OldAttributesTest.class,
    libcore.java.util.jar.OldJarEntryTest.class,
    libcore.java.util.jar.OldJarExceptionTest.class,
    libcore.java.util.jar.OldJarFileTest.class,
    libcore.java.util.jar.OldJarInputStreamTest.class,
    libcore.java.util.jar.OldJarOutputStreamTest.class,
    libcore.java.util.jar.OldManifestTest.class,
    libcore.java.util.jar.StrictJarFileTest.class,

})

public class JunitExtJavaUtilJar {
} 