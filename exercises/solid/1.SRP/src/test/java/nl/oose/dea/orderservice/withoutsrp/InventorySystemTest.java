package nl.oose.dea.orderservice.withoutsrp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InventorySystemTest {
    private InventorySystem inventorySystem;

    @Before
    public void setUp()
    {
        inventorySystem = new InventorySystem();
    }

    @Test
    public void buyAllFrikandellen() throws Exception {
        inventorySystem.reserve("Frikandel", 20);
        assertTrue(inventorySystem.isOnStock("Frikandel", 0));
    }

    @Test(expected = InsufficientInventoryException.class)
    public void youCannotBuyMoreThanAvailableInTheInventory() throws Exception {
        inventorySystem.reserve("Frikandel", 21);
    }
}