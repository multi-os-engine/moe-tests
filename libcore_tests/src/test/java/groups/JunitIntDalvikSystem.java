import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    dalvik.system.profiler.SamplingProfilerTest.class,
    dalvik.system.DexClassLoaderTest.class,
    dalvik.system.JniTest.class,
    dalvik.system.VMRuntimeTest.class,
    libcore.dalvik.system.PathClassLoaderTest.class,

})
public class JunitIntDalvikSystem {
} 