package oose.dea.items;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    public List<Item> findAll() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Frikandel", "Snacks", "Restafval, maar wel lekker"));
        items.add(new Item("Bradwurst", "Snacks", "Restafval, maar dan op zijn Duits"));
        return items;
    }
}
