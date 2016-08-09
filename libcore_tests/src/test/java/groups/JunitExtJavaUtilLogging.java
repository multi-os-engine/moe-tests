import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.java.util.logging.OldErrorManagerTest.class,
    libcore.java.util.logging.OldFileHandlerTest.class,
    libcore.java.util.logging.OldFormatterTest.class,
    libcore.java.util.logging.OldLevelTest.class,
    libcore.java.util.logging.OldLogManagerTest.class,
    libcore.java.util.logging.OldLogRecordTest.class,
    libcore.java.util.logging.OldLoggerTest.class,
    libcore.java.util.logging.OldMemoryHandlerTest.class,
    libcore.java.util.logging.OldSimpleFormatterTest.class,
    libcore.java.util.logging.OldXMLFormatterTest.class,

})
public class JunitExtJavaUtilLogging {
} 