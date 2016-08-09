import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.util.BasicLruCacheTest.class,
    libcore.util.CollectionUtilsTest.class,
    libcore.util.ZoneInfoDBTest.class, 
    libcore.util.HexEncodingTest.class,

})
public class JunitIntLibcoreUtil {
} 