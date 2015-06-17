package oose.dea.datasource;

import oose.dea.datasource.util.DatabaseProperties;
import oose.dea.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDao {
    private Logger logger = Logger.getLogger(getClass().getName());

    private DatabaseProperties databaseProperties;

    public ItemDao(DatabaseProperties databaseProperties)
    {
        this.databaseProperties = databaseProperties;
        tryLoadJdbcDriver(databaseProperties);
    }

    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        tryFindAll(items);
        return items;
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    private void tryFindAll(List<Item> items) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            Statement statement = connection.createStatement();
            addNewItemsFromDatabase(items, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    private void addNewItemsFromDatabase(List<Item> items, Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * from items");
        while (resultSet.next())
        {
            addNewItemFromResultSet(items, resultSet);
        }
    }

    private void addNewItemFromResultSet(List<Item> items, ResultSet resultSet) throws SQLException {
        Item item = new Item(
                resultSet.getString("sku"), resultSet.getString("category"), resultSet.getString("title")
        );
        items.add(item);
    }
}
