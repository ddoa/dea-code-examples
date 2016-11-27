package oose.dea.dataaccess;

import oose.dea.IntegrationTest;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@PrepareForTest(ItemJdbcDAO.class)
@Category(IntegrationTest.class)
public class ItemJdbcDAOIT {
    public static final String ERROR = "Error";
    private static JdbcConnectionFactory jdbcConnectionFactory = new JdbcConnectionFactory();
    private Item item = new Item("sku", "cat", "title");

    @BeforeClass
    public static void prepare() throws SQLException {
        Connection connection = jdbcConnectionFactory.create();
        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS items (" +
                "  id int(11) auto_increment primary key," +
                "  category varchar(255) DEFAULT NULL," +
                "  sku varchar(255) DEFAULT NULL," +
                "  title varchar(255) DEFAULT NULL" +
                ")";

        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }

    @Test
    public void whenTableIsEmptyListIsAlsoEmtpy()
    {
        ItemJdbcDAO itemJdbcDAO = new ItemJdbcDAO(jdbcConnectionFactory);
        assertEquals(0,itemJdbcDAO.list().size());
    }

    @Test
    public void afterAddingOneItemTheListHasSizeOne()
    {
        ItemJdbcDAO itemJdbcDAO = new ItemJdbcDAO(jdbcConnectionFactory);
        itemJdbcDAO.add(item);
        assertEquals(1,itemJdbcDAO.list().size());
    }

    @Test
    public void whenSqlExceptionIsThrownDuringAddTheMessageGetsLogged() throws SQLException {
        Logger mockLogger = mock(Logger.class);
        Whitebox.setInternalState(ItemJdbcDAO.class, "logger", mockLogger);
        ItemJdbcDAO itemJdbcDAO = createItemJdbcDAOWithMockedDependencies();
        itemJdbcDAO.add(item);

        verify(mockLogger).severe(ERROR);
    }

    @Test
    public void whenSqlExceptionIsThrownDuringListTheMessageGetsLogged() throws SQLException {
        Logger mockLogger = mock(Logger.class);
        Whitebox.setInternalState(ItemJdbcDAO.class, "logger", mockLogger);
        ItemJdbcDAO itemJdbcDAO = createItemJdbcDAOWithMockedDependencies();
        itemJdbcDAO.list();

        verify(mockLogger).severe(ERROR);
    }

    private ItemJdbcDAO createItemJdbcDAOWithMockedDependencies() throws SQLException {
        JdbcConnectionFactory mockConnectionFactory = mock(JdbcConnectionFactory.class);
        Connection mockConnection = mock(Connection.class);
        when(mockConnection.prepareStatement(anyString())).thenThrow(new SQLException(ERROR));
        when(mockConnectionFactory.create()).thenReturn(mockConnection);
        return new ItemJdbcDAO(mockConnectionFactory);
    }

    @Test(expected = RuntimeException.class)
    public void findNotYetImplemented()
    {
        ItemJdbcDAO itemJdbcDAO = new ItemJdbcDAO(jdbcConnectionFactory);
        itemJdbcDAO.find(0);
    }

    @Test(expected = RuntimeException.class)
    public void updateNotYetImplemented()
    {
        ItemJdbcDAO itemJdbcDAO = new ItemJdbcDAO(jdbcConnectionFactory);
        itemJdbcDAO.update(null);
    }

    @Test(expected = RuntimeException.class)
    public void removeNotYetImplemented()
    {
        ItemJdbcDAO itemJdbcDAO = new ItemJdbcDAO(jdbcConnectionFactory);
        itemJdbcDAO.remove(null);
    }

    @AfterClass
    public static void shutdown() throws IOException {
        FileUtils.deleteDirectory(new File("/tmp/itemjdbcdaoit"));
    }
}