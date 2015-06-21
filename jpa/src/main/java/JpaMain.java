import oose.dea.dataaccess.Item;
import oose.dea.dataaccess.ItemJpaDAO;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        ItemJpaDAO itemJpaDAO = new ItemJpaDAO();

        listAll(itemJpaDAO);
        addNew(itemJpaDAO);
        listAll(itemJpaDAO);
        updateLastAdded(itemJpaDAO);
        listAll(itemJpaDAO);
        removeLatest(itemJpaDAO, getLastAdded(itemJpaDAO));
        listAll(itemJpaDAO);
    }

    private static void updateLastAdded(ItemJpaDAO itemJpaDAO) {
        Item it = getLastAdded(itemJpaDAO);
        it.setSku("Bamihapje");
        itemJpaDAO.update(it);
    }

    private static Item getLastAdded(ItemJpaDAO itemJpaDAO) {
        List<Item> list = itemJpaDAO.list();
        return list.stream().max((it1, it2) -> Integer.compare(it1.getId(), it2.getId())).get();
    }

    private static void removeLatest(ItemJpaDAO itemJpaDAO, Item item) {
        itemJpaDAO.remove(item);
    }

    private static void addNew(ItemJpaDAO itemJpaDAO) {
        itemJpaDAO.add(createItem());
    }

    private static Item createItem() {
        Item item = new Item();
        item.setSku("Bamibal");
        item.setCategory("Snacks");
        item.setTitle("Ook vegetarisch verkrijgbaar");
        return item;
    }

    private static void listAll(ItemJpaDAO itemJpaDAO) {
        List<Item> list = itemJpaDAO.list();
        for(Item item: list)
        {
            System.out.println(item);
        }
    }
}
