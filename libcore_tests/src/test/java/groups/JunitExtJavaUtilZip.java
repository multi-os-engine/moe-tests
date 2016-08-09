import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.util.zip.Adler32Test.class,
    org.apache.harmony.tests.java.util.zip.CRC32Test.class,
    org.apache.harmony.tests.java.util.zip.CheckedInputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.CheckedOutputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.DeflaterInputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.DeflaterOutputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.DeflaterTest.class,
    org.apache.harmony.tests.java.util.zip.GZIPOutputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.InflaterInputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.InflaterOutputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.InflaterTest.class,
    org.apache.harmony.tests.java.util.zip.ZipEntryTest.class,
    org.apache.harmony.tests.java.util.zip.ZipErrorTest.class,
    org.apache.harmony.tests.java.util.zip.ZipFileTest.class,
    org.apache.harmony.tests.java.util.zip.ZipInputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.ZipOutputStreamTest.class,
    org.apache.harmony.tests.java.util.zip.GZIPInputStreamTest.class,
    libcore.java.util.zip.DeflaterInputStreamTest.class,
    libcore.java.util.zip.DeflaterOutputStreamTest.class,
    libcore.java.util.zip.DeflaterTest.class,
    libcore.java.util.zip.GZIPInputStreamTest.class,
    libcore.java.util.zip.GZIPOutputStreamTest.class,
    libcore.java.util.zip.InflaterTest.class,
    libcore.java.util.zip.OldAndroidChecksumTest.class,
    libcore.java.util.zip.OldAndroidDeflateTest.class,
    libcore.java.util.zip.OldAndroidGZIPStreamTest.class,
    libcore.java.util.zip.OldAndroidZipFileTest.class,
    libcore.java.util.zip.OldAndroidZipStreamTest.class,
    libcore.java.util.zip.OldAndroidZipStressTest.class,
    libcore.java.util.zip.OldDataFormatExceptionTest.class,
    libcore.java.util.zip.OldZipExceptionTest.class,
    libcore.java.util.zip.OldZipFileTest.class,
    libcore.java.util.zip.OldZipInputStreamTest.class,
    libcore.java.util.zip.ZipEntryTest.class,
    libcore.java.util.zip.ZipFileTest.class, //hang
    libcore.java.util.zip.ZipInputStreamTest.class,
    libcore.java.util.zip.ZipOutputStreamTest.class,

})
public class JunitExtJavaUtilZip {
} 