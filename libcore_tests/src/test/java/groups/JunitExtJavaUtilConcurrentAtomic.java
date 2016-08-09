import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    jsr166.AtomicBooleanTest.class,
    jsr166.AtomicIntegerArrayTest.class,
    jsr166.AtomicIntegerFieldUpdaterTest.class,
    jsr166.AtomicIntegerTest.class,
    jsr166.AtomicLongArrayTest.class,
    jsr166.AtomicLongFieldUpdaterTest.class,
    jsr166.AtomicLongTest.class,
    jsr166.AtomicMarkableReferenceTest.class,
    jsr166.AtomicReferenceArrayTest.class,
    jsr166.AtomicReferenceFieldUpdaterTest.class,
    jsr166.AtomicReferenceTest.class,
    jsr166.AtomicStampedReferenceTest.class,
})
public class JunitExtJavaUtilConcurrentAtomic {
} 