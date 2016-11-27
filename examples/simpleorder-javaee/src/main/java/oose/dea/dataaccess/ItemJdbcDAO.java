package oose.dea.dataaccess;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class ItemJdbcDAO implements ItemDAO {
    private static Logger logger = Logger.getLogger(ItemJdbcDAO.class.getName());

    private JdbcConnectionFactory jdbcConnectionFactory;

    @Inject
    public ItemJdbcDAO(JdbcConnectionFactory jdbcConnectionFactory) {
        this.jdbcConnectionFactory = jdbcConnectionFactory;
    }

    @Override
    public void add(Item entity) {
        Connection connection = jdbcConnectionFactory.create();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO items VALUES (NULL, ? , ? , ?)");
            preparedStatement.setString(1, entity.getSku());
            preparedStatement.setString(2, entity.getCategory());
            preparedStatement.setString(3, entity.getTitle());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    public void update(Item updatedEntity) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public void remove(Item entity) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public List<Item> list() {
        Connection connection = jdbcConnectionFactory.create();
        List<Item> items = new ArrayList<Item>();
        try {
            ResultSet rs = connection.prepareStatement("SELECT * FROM items").executeQuery();
            while (rs.next()) {
                items.add(new Item(rs.getString("sku"),rs.getString("category"),rs.getString("title")));
            }
            connection.close();
        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
        return items;
    }

    @Override
    public Item find(int id) {
        throw new RuntimeException("Not implemented yet");
    }
}
