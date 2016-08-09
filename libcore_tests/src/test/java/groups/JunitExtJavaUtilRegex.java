import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.util.regex.Matcher2Test.class,
    org.apache.harmony.tests.java.util.regex.MatcherTest.class,
    org.apache.harmony.tests.java.util.regex.ModeTest.class,
    org.apache.harmony.tests.java.util.regex.Pattern2Test.class,
    org.apache.harmony.tests.java.util.regex.PatternErrorTest.class,
    org.apache.harmony.tests.java.util.regex.ReplaceTest.class,
    org.apache.harmony.tests.java.util.regex.SplitTest.class,
    org.apache.harmony.regex.tests.java.util.regex.Matcher2Test.class,
    org.apache.harmony.regex.tests.java.util.regex.ModeTest.class,
    org.apache.harmony.regex.tests.java.util.regex.Pattern2Test.class,
    org.apache.harmony.regex.tests.java.util.regex.PatternSyntaxExceptionTest.class,
    org.apache.harmony.regex.tests.java.util.regex.PatternTest.class,
    org.apache.harmony.regex.tests.java.util.regex.ReplaceTest.class,
    org.apache.harmony.regex.tests.java.util.regex.SplitTest.class,
    libcore.java.util.regex.OldAndroidRegexTest.class,
    libcore.java.util.regex.OldMatcherTest.class,

})
public class JunitExtJavaUtilRegex {
} 