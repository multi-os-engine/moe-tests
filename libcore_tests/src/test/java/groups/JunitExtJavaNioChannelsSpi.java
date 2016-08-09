import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.nio.channels.spi.AbstractInterruptibleChannelTest.class,
    org.apache.harmony.tests.java.nio.channels.spi.AbstractSelectableChannelTest.class,
    org.apache.harmony.tests.java.nio.channels.spi.AbstractSelectionKeyTest.class,
    org.apache.harmony.tests.java.nio.channels.spi.AbstractSelectorTest.class,
    org.apache.harmony.nio.tests.java.nio.channels.spi.SelectorProviderTest.class,

})
public class JunitExtJavaNioChannelsSpi {
} 