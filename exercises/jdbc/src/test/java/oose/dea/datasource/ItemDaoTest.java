package oose.dea.datasource;

import oose.dea.datasource.util.DatabaseProperties;
import oose.dea.datasource.util.ScriptRunner;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ItemDaoTest {
    private ItemDao itemDao;

    @Before
    public void setup() throws SQLException, IOException {
        DatabaseProperties databaseProperties = new DatabaseProperties();
        Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
        ScriptRunner scriptRunner = new ScriptRunner(connection, true, true);
        scriptRunner.runScript(new InputStreamReader(ClassLoader.getSystemResourceAsStream("import.sql")));
        connection.close();

        itemDao = new ItemDao(databaseProperties);
    }

    @Test
    public void findAllShouldReturnOneItem()
    {
        assertEquals(1, itemDao.findAll().size());
    }
}
