import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.nio.channels.AlreadyConnectedExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.AsynchronousCloseExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.CancelledKeyExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.ChannelsTest.class,
    org.apache.harmony.tests.java.nio.channels.ClosedByInterruptExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.ClosedChannelExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.ClosedSelectorExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.ConnectionPendingExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.FileChannelLockingTest.class,
    org.apache.harmony.tests.java.nio.channels.FileChannelTest.class, //crash
    org.apache.harmony.tests.java.nio.channels.FileLockInterruptionExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.FileLockTest.class,
    org.apache.harmony.tests.java.nio.channels.IllegalBlockingModeExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.IllegalSelectorExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.MapModeTest.class,
    org.apache.harmony.tests.java.nio.channels.NoConnectionPendingExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.NonReadableChannelExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.NonWritableChannelExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.NotYetBoundExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.NotYetConnectedExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.OverlappingFileLockExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.PipeTest.class,
    org.apache.harmony.tests.java.nio.channels.SelectableChannelTest.class,
    org.apache.harmony.tests.java.nio.channels.SelectionKeyTest.class,
    org.apache.harmony.tests.java.nio.channels.SelectorTest.class,
    org.apache.harmony.tests.java.nio.channels.SinkChannelTest.class,  //crash
    org.apache.harmony.tests.java.nio.channels.SocketChannelTest.class, //crash
    org.apache.harmony.tests.java.nio.channels.SourceChannelTest.class, //crash
    org.apache.harmony.tests.java.nio.channels.UnixSelectorTest.class,
    org.apache.harmony.tests.java.nio.channels.UnresolvedAddressExceptionTest.class,
    org.apache.harmony.tests.java.nio.channels.UnsupportedAddressTypeExceptionTest.class, //crash
    org.apache.harmony.tests.java.nio.channels.DatagramChannelTest.class,
    org.apache.harmony.tests.java.nio.channels.ServerSocketChannelTest.class, //crash 
    libcore.java.nio.channels.ChannelsTest.class,
    libcore.java.nio.channels.DatagramChannelTest.class, //crash
    libcore.java.nio.channels.FileChannelTest.class,  //crash
    libcore.java.nio.channels.PipeTest.class,
    libcore.java.nio.channels.FileIOInterruptTest.class, //crash
    libcore.java.nio.channels.OldServerSocketChannelTest.class,
    libcore.java.nio.channels.OldFileChannelTest.class,
    libcore.java.nio.channels.OldSocketChannelTest.class,
    libcore.java.nio.channels.SelectorTest.class,
    libcore.java.nio.channels.ServerSocketChannelTest.class,
    libcore.java.nio.channels.SocketChannelTest.class,

})
public class JunitExtJavaNioChannels {
}