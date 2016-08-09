import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.io.Base64Test.class,
    libcore.io.MemoryTest.class,
    libcore.io.StrictLineReaderTest.class,
    libcore.io.OsTest.class, 
    
})
public class JunitIntLibcoreIo {
} 