package nl.oose.dea.orderservice.withsrp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReservationServiceTest {
    private ReservationService reservationService;

    @Before
    public void setUp()
    {
        /**
         * TIP:
         * - create a new class CafetariaReservationService that implements a new interface ReservationService
         * - implement a reserveInventory method using the code from the 'old' Order class.
         */
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