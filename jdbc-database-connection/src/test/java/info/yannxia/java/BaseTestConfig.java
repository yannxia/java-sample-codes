package info.yannxia.java;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yann.Xia on 2015/7/26.
 */
public class BaseTestConfig {

    protected Logger logger;

    public BaseTestConfig() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Before
    public void initDB() {
        HSQLDBJdbcConnection HSQLDBJdbcConnection = new HSQLDBJdbcConnection();
        HSQLDBJdbcConnection.executeUpdate("CREATE TABLE T_SAMPLE (id INTEGER IDENTITY NOT NULL PRIMARY KEY,name VARCHAR(255));");
        HSQLDBJdbcConnection.executeUpdate("INSERT INTO T_SAMPLE VALUES('1', 'hello')");

        logger.info("HSQL init OK");
    }

    @After
    public void clearDB() {
        HSQLDBJdbcConnection HSQLDBJdbcConnection = new HSQLDBJdbcConnection();
        HSQLDBJdbcConnection.executeUpdate("DROP TABLE T_SAMPLE");

        logger.info("clear db ok");
    }
}
