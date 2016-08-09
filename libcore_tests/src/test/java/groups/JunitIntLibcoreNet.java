import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.net.MimeUtilsTest.class,
    libcore.net.event.NetworkEventDispatcherTest.class,
    libcore.net.url.UrlUtilsTest.class,
    libcore.net.http.ResponseUtilsTest.class,
    org.apache.harmony.tests.internal.net.www.protocol.file.FileURLConnectionTest.class,

})
public class JunitIntLibcoreNet{
} 