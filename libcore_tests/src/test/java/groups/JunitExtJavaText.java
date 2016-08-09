import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.text.AnnotationTest.class,
    org.apache.harmony.tests.java.text.AttributedCharacterIteratorAttributeTest.class,
    org.apache.harmony.tests.java.text.AttributedCharacterIteratorTest.class,
    org.apache.harmony.tests.java.text.AttributedStringTest.class,
    org.apache.harmony.tests.java.text.BidiTest.class,
    org.apache.harmony.tests.java.text.BreakIteratorTest.class, 
    org.apache.harmony.tests.java.text.ChoiceFormatTest.class,
    org.apache.harmony.tests.java.text.CollationElementIteratorTest.class,
    org.apache.harmony.tests.java.text.CollationKeyTest.class,
    org.apache.harmony.tests.java.text.CollatorTest.class,
    org.apache.harmony.tests.java.text.DataFormatFieldTest.class,
    org.apache.harmony.tests.java.text.DateFormatSymbolsTest.class, 
    org.apache.harmony.tests.java.text.DateFormatTest.class,
    org.apache.harmony.tests.java.text.DecimalFormatSymbolsTest.class,
    org.apache.harmony.tests.java.text.DecimalFormatTest.class, //crash
    org.apache.harmony.tests.java.text.FieldPositionTest.class,
    org.apache.harmony.tests.java.text.MessageFormatFieldTest.class,
    org.apache.harmony.tests.java.text.MessageFormatTest.class,
    org.apache.harmony.tests.java.text.NormalizerTest.class,
    org.apache.harmony.tests.java.text.NumberFormatFieldTest.class,
    org.apache.harmony.tests.java.text.NumberFormatTest.class,
    org.apache.harmony.tests.java.text.ParseExceptionTest.class,
    org.apache.harmony.tests.java.text.ParsePositionTest.class,
    org.apache.harmony.tests.java.text.RuleBasedCollatorTest.class,
    org.apache.harmony.tests.java.text.SimpleDateFormatTest.class,
    org.apache.harmony.tests.java.text.StringCharacterIteratorTest.class,
    libcore.java.text.AttributedCharacterIteratorAttributeTest.class,
    libcore.java.text.BreakIteratorTest.class,
    libcore.java.text.CollatorTest.class,
    libcore.java.text.DateFormatSymbolsTest.class,
    libcore.java.text.DecimalFormatSymbolsTest.class,
    libcore.java.text.DecimalFormatTest.class,
    libcore.java.text.NormalizerTest.class,
    libcore.java.text.NumberFormatTest.class,
    libcore.java.text.OldAttributedCharacterIteratorAttributeTest.class,
    libcore.java.text.OldAttributedCharacterIteratorTest.class,
    libcore.java.text.OldAttributedStringTest.class,
    libcore.java.text.OldBidiTest.class,
    libcore.java.text.OldCollationKeyTest.class,
    libcore.java.text.OldDateFormatTest.class,
    libcore.java.text.OldDecimalFormatSymbolsTest.class,
    libcore.java.text.OldDecimalFormatTestICU.class,
    libcore.java.text.OldFormatFieldTest.class,
    libcore.java.text.OldFormatTest.class,
    libcore.java.text.OldMessageFormatFieldTest.class,
    libcore.java.text.OldNumberFormatFieldTest.class,
    libcore.java.text.OldNumberFormatTest.class,
    libcore.java.text.OldParsePositionTest.class,
    libcore.java.text.SimpleDateFormatTest.class,

})
public class JunitExtJavaText {
} 