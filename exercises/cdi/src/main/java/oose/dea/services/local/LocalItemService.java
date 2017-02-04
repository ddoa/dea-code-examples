package oose.dea.services.local;

import oose.dea.dao.ItemDAO;
import oose.dea.domain.Item;
import oose.dea.services.ItemService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("localItemService")
// @Default
public class LocalItemService implements ItemService {
    @Inject
    private ItemDAO itemDAO;

    @Override
    public List<Item> findAll() {
        return itemDAO.list();
    }
}
