import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    android.database.SQLiteConnectionPoolTest.class,
    android.database.SQLiteConnectionTest.class,
    android.database.SQLiteSessionTest.class,
    android.database.SQLiteDatabaseTest.class,
    android.database.PackageInfoTest.class,
    android.database.ResourcesTest.class,
    android.database.AsyncTaskTest.class,
    android.database.CursorTest.class,
    android.database.AssetManagerTest.class,
    android.database.ContextWrapperTest.class,
})
public class JunitExtAndroidDatabase {
} 