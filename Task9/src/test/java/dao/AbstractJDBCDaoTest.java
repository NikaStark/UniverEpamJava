package dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class AbstractJDBCDaoTest {

    protected static Logger logger = LogManager.getLogger(AbstractJDBCDaoTest.class);
    protected static Connection connection;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(new File("src/test/resources/db.properties")));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            logger.info("Connection established successfully!");
        } catch (IOException e) {
            logger.warn("Not found file - db.properties!");
        } catch (SQLException e) {
            logger.warn("Connection established failed!");
        }
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        try {
            connection.close();
            logger.info("Connection closed successfully!");
        } catch (SQLException e) {
            logger.warn("Connection closed failed!");
        }
    }

    //TODO replace first call of executeSqlScript in setUpBeforeClass
    @Before
    public void setUp() throws Exception {
        executeSqlScript(connection, new File("src/main/resources/scripts/create_data_model.sql"));
        executeSqlScript(connection, new File("src/test/resources/scripts/fill_database.sql"));
        logger.info("Database prepared successfully!");
    }

    //TODO replace first call of executeSqlScript in tearDownAfterClass
    @After
    public void tearDown() throws Exception {
        executeSqlScript(connection, new File("src/test/resources/scripts/delete_records.sql"));
        executeSqlScript(connection, new File("src/main/resources/scripts/drop_tables.sql"));
        logger.info("Database delete successfully!");
    }

    protected PreparedStatement preparedStatementForSelect(AbstractJDBCDao dao) throws Exception {
        return connection.prepareStatement(dao.SQL_FIND_BY_PK);
    }

    private void executeSqlScript(Connection connection, File inputFile) {
        String delimiter = ";";
        try (Scanner scanner = new Scanner(inputFile).useDelimiter(delimiter);
             Statement statement = connection.createStatement()) {
            while (scanner.hasNext()) {
                statement.execute(scanner.next() + delimiter);
            }
        } catch (FileNotFoundException e) {
            logger.warn("Not found file [" + inputFile.getName() + "]");
        } catch (SQLException e) {
            logger.warn("SQLException at run script [" + inputFile.getName() + "]");
        }
    }

}