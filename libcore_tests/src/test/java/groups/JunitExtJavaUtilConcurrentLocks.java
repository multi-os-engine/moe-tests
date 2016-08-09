import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    jsr166.AbstractQueuedLongSynchronizerTest.class,
    jsr166.AbstractQueuedSynchronizerTest.class,
    jsr166.LockSupportTest.class,
    jsr166.ReentrantLockTest.class,
    jsr166.ReentrantReadWriteLockTest.class,

})
public class JunitExtJavaUtilConcurrentLocks {
} 