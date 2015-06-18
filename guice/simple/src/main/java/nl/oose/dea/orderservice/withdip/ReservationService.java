package nl.oose.dea.orderservice.withdip;

public interface ReservationService {
    void reserveInventory(Cart cart);

    boolean isOnStock(String product, int amount);
}
