package oose.dea.services.local;

import oose.dea.dataaccess.Item;
import oose.dea.dataaccess.ItemDAO;
import oose.dea.services.ItemService;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.List;

@Default
public class LocalItemService implements ItemService {
    @Inject
    private ItemDAO itemDAO;

    @Override
    public List<Item> findAll() {
        return itemDAO.list();
    }
}
