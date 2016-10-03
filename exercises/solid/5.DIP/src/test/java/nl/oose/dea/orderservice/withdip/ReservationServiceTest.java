package nl.oose.dea.orderservice.withdip;

import nl.oose.dea.orderservice.withoutdip.CafetariaReservationService;
import nl.oose.dea.orderservice.withoutdip.Cart;
import nl.oose.dea.orderservice.withoutdip.Item;
import nl.oose.dea.orderservice.withoutdip.OrderException;
import nl.oose.dea.orderservice.withoutdip.ReservationService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReservationServiceTest {
    private static final String PRODUCT = "Frikandel";
    private static final String EMAIL_ADDRESS = "oose@gmail.com";
    private static final int NOTHING_LEFT_IN_INVENTORY = 0;

    private ReservationService reservationService;

    @Before
    public void setUp()
    {
        reservationService = new CafetariaReservationService();
    }

    @Test
    public void buyAllFrikandellen() throws Exception {
        reservationService.reserveInventory(createCartWithSufficientInventory());
        assertTrue(reservationService.isOnStock(PRODUCT, NOTHING_LEFT_IN_INVENTORY));
    }

    private Cart createCartWithSufficientInventory() {
        return createCart(20);
    }

    private Cart createCartWithInsufficientInventory() {
        return createCart(21);
    }

    private Cart createCart(int quantity) {
        return new Cart("OOSE",EMAIL_ADDRESS, new Item[] { new Item(PRODUCT, quantity) }, 50);
    }

    @Test(expected = OrderException.class)
    public void youCannotBuyMoreThanAvailableInTheInventory() throws Exception {
        reservationService.reserveInventory(createCartWithInsufficientInventory());
    }
}