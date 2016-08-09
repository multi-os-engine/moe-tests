import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.icu.DateIntervalFormatTest.class,
    libcore.icu.ICUTest.class,
    libcore.icu.LocaleDataTest.class,
    libcore.icu.TimeZoneNamesTest.class,
    libcore.icu.TransliteratorTest.class,
    libcore.icu.RelativeDateTimeFormatterTest.class,

})
public class JunitIntLibcoreIcu {
} 