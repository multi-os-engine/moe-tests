import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.javax.xml.parsers.DocumentBuilderTest.class,
    org.apache.harmony.tests.javax.xml.parsers.DocumentBuilderFactoryTest.class,
    org.apache.harmony.tests.javax.xml.parsers.DocumentBuilderTest.class,
    org.apache.harmony.tests.javax.xml.parsers.FactoryConfigurationErrorTest.class,
    org.apache.harmony.tests.javax.xml.parsers.ParserConfigurationExceptionTest.class,
    org.apache.harmony.tests.javax.xml.parsers.SAXParserFactoryTest.class,
    org.apache.harmony.tests.javax.xml.parsers.SAXParserTest.class,

})
public class JunitExtJavaxXmlParsers {
} 