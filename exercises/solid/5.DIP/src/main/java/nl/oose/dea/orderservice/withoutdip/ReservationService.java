package nl.oose.dea.orderservice.withoutdip;

public interface ReservationService {
    void reserveInventory(Cart cart);

    boolean isOnStock(String product, int amount);
}
