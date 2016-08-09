import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.annotation.tests.java.lang.annotation.AnnotationFormatErrorTest.class,
    org.apache.harmony.annotation.tests.java.lang.annotation.AnnotationTypeMismatchExceptionTest.class,
    org.apache.harmony.annotation.tests.java.lang.annotation.ElementTypeTest.class,
    org.apache.harmony.annotation.tests.java.lang.annotation.IncompleteAnnotationExceptionTest.class,
    org.apache.harmony.annotation.tests.java.lang.annotation.RetentionPolicyTest.class,
    libcore.java.lang.annotation.AnnotationTypeMismatchExceptionTest.class,
    org.apache.harmony.annotation.tests.java.lang.annotation.AnnotationTest.class,

})
public class JunitExtJavaLangAnnotation {
} 