import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    
    libcore.xml.DeclarationTest.class,
    libcore.xml.DomSerializationTest.class,
    libcore.xml.DomTest.class,
    libcore.xml.ExpatSaxParserTest.class,
    libcore.xml.KxmlPullParserDtdTest.class,
    libcore.xml.KxmlPullParserTest.class,
    libcore.xml.KxmlSerializerTest.class,
    libcore.xml.NamespacedAttributesLookupTest.class,
    libcore.xml.NodeTest.class,
    libcore.xml.NormalizeTest.class,
    libcore.xml.SaxTest.class,
    libcore.xml.SimpleBuilderTest.class,
    libcore.xml.SimpleParserTest.class,
    libcore.xml.XmlPullParserFactoryTest.class,

})
public class JunitIntLibcoreXml {
} 