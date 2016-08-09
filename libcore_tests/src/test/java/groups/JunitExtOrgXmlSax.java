import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.org.xml.sax.HandlerBaseTest.class,
    org.apache.harmony.tests.org.xml.sax.InputSourceTest.class,
    org.apache.harmony.tests.org.xml.sax.SAXExceptionTest.class,
    org.apache.harmony.tests.org.xml.sax.SAXNotRecognizedExceptionTest.class,
    org.apache.harmony.tests.org.xml.sax.SAXNotSupportedExceptionTest.class,
    org.apache.harmony.tests.org.xml.sax.SAXParseExceptionTest.class,

})
public class JunitExtOrgXmlSax {
} 