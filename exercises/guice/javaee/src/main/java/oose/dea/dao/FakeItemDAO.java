package oose.dea.dao;

import oose.dea.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class FakeItemDAO implements ItemDAO {
    @Override
    public List<Item> list() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Frikandel", "Snacks", "Lekker wel!"));
        items.add(new Item("Kroket", "Snacks", "Ook lekker in bed!"));
        return items;
    }
}
