package oose.dea;

import oose.dea.datasource.ItemDao;
import oose.dea.datasource.util.DatabaseProperties;
import oose.dea.domain.Item;

import java.io.IOException;
import java.util.List;

public class JdbcApp {
    public static void main(String[] args) throws IOException {
        ItemDao itemDao = new ItemDao(new DatabaseProperties());
        List<Item> items = itemDao.findAll();
        for(Item item:items)
            System.out.println(item);
    }
}
