package nl.oose.dea.orderservice.withdip;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class InventorySystem {
    private Logger logger = Logger.getLogger(getClass().getName());

    private Map<String, Integer> inventory = new HashMap<String, Integer>() {{
        put("Frikandel", 20);
        put("Bamihap", 25);
        put("Mexicano", 50);
    }};

    public void reserve(String sku, int quantity) throws InsufficientInventoryException {
        if (isOnStock(sku, quantity))
            inventory.put(sku, inventory.get(sku) - quantity);
        else throw new InsufficientInventoryException();
        logger.info("There is still " + inventory.get(sku) + " of " + sku + " left in inventory");
    }

    public boolean isOnStock(String sku, int quantity) {
        return inventory.get(sku) >= quantity;
    }
}
