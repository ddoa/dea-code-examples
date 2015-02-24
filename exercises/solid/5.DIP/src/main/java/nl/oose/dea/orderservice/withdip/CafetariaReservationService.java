package nl.oose.dea.orderservice.withdip;

public class CafetariaReservationService implements ReservationService {
    private InventorySystem inventorySystem = new InventorySystem();

    @Override
    public void reserveInventory(Cart cart) {
        for(Item item : cart.getItems())
        {
            try {
                inventorySystem.reserve(item.sku, item.quantity);
            } catch(InsufficientInventoryException insufficientInventoryException)
            {
                throw new OrderException("Insufficient inventory for item " + item.sku, insufficientInventoryException);
            }
        }
    }

    @Override
    public boolean isOnStock(String product, int amount) {
        return inventorySystem.isOnStock(product, amount);
    }
}
