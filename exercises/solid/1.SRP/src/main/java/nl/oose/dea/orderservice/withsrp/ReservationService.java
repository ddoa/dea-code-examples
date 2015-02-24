package nl.oose.dea.orderservice.withsrp;

public interface ReservationService {
    void reserveInventory(Cart cart);

    boolean isOnStock(String product, int amount);
}
