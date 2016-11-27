package oose.dea.services.local;

import oose.dea.dataaccess.Item;
import oose.dea.dataaccess.ItemDAO;
import oose.dea.services.ItemService;

import javax.inject.Inject;
import java.util.List;

public class LocalItemService implements ItemService {
    @Inject
    private ItemDAO itemDAO;

    @Override
    public List<Item> findAll() {
        return itemDAO.list();
    }
}
