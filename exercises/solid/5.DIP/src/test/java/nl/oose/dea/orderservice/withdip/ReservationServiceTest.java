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
    private ReservationService reservationService;

    @Before
    public void setUp()
    {
        reservationService = new CafetariaReservationService();
    }

    @Test
    public void buyAllFrikandellen() throws Exception {
        reservationService.reserveInventory(createCartWithSufficientInventory());
        assertTrue(reservationService.isOnStock("Frikandel", 0));
    }

    private Cart createCartWithSufficientInventory() {
        return new Cart("OOSE","oose@gmail.com", new Item[] { new Item("Frikandel", 20) }, 50);
    }

    private Cart createCartWithInsufficientInventory() {
        return new Cart("OOSE","oose@gmail.com", new Item[] { new Item("Frikandel", 21) }, 50);
    }

    @Test(expected = OrderException.class)
    public void youCannotBuyMoreThanAvailableInTheInventory() throws Exception {
        reservationService.reserveInventory(createCartWithInsufficientInventory());
    }
}