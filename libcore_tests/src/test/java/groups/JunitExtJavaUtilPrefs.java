import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.util.prefs.AbstractPreferencesTest.class,
    org.apache.harmony.tests.java.util.prefs.BackingStoreExceptionTest.class,
    org.apache.harmony.tests.java.util.prefs.FilePreferencesImplTest.class,
    org.apache.harmony.tests.java.util.prefs.InvalidPreferencesFormatExceptionTest.class,
    org.apache.harmony.tests.java.util.prefs.NodeChangeEventTest.class,
    org.apache.harmony.tests.java.util.prefs.NodeChangeListenerTest.class,
    org.apache.harmony.tests.java.util.prefs.PreferenceChangeEventTest.class,
    org.apache.harmony.tests.java.util.prefs.PreferenceChangeListenerTest.class,
    org.apache.harmony.tests.java.util.prefs.PreferencesFactoryTest.class,
    org.apache.harmony.tests.java.util.prefs.PreferencesTest.class,
    libcore.java.util.prefs.OldAbstractPreferencesTest.class,
    libcore.java.util.prefs.OldFilePreferencesImplTest.class,
    libcore.java.util.prefs.OldNodeChangeEventTest.class,
    libcore.java.util.prefs.OldPreferenceChangeEventTest.class,
    libcore.java.util.prefs.OldPreferencesTest.class,
    libcore.java.util.prefs.PreferencesTest.class,

})
public class JunitExtJavaUtilPrefs {
} 