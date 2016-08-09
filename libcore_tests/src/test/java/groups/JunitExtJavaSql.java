import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    libcore.java.sql.ConnectionTest.class,
    libcore.java.sql.OldConnectionTest.class,
    libcore.java.sql.OldDriverPropertyInfoTest.class,
    libcore.java.sql.OldPreparedStatementTest.class,
    libcore.java.sql.OldResultSetGetterTests.class,
    libcore.java.sql.OldResultSetMetaDataTest.class,
    libcore.java.sql.OldResultSetTest.class,
    libcore.java.sql.OldStatementTest.class,
    libcore.java.sql.TimestampTest.class,
    libcore.java.sql.DriverTest.class,
    tests.java.sql.DatabaseMetaDataNotSupportedTest.class,
    tests.java.sql.DatabaseMetaDataTest.class,
    tests.java.sql.DeleteFunctionalityTest.class,
    tests.java.sql.InsertFunctionalityTest.class,
    tests.java.sql.MultiThreadAccessTest.class,
    tests.java.sql.SelectFunctionalityTest.class,
    tests.java.sql.SqlDateTest.class,
    tests.java.sql.StressTest.class,
    tests.java.sql.UpdateFunctionalityTest.class,
    tests.java.sql.UpdateFunctionalityTest2.class,

})
public class JunitExtJavaSql {
} 