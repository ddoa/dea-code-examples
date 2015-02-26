package nl.oose.dea.orderservice.withoutisp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientsTest {
    private ReadOnlyAccessClient readOnlyAccessClient;
    private FullAccessClient fullAccessClient;

    @Before
    public void setUp() throws Exception {
        CartRepository cartRepository = new InMemoryCartRepository();
        readOnlyAccessClient = new ReadOnlyAccessClient(cartRepository);
        fullAccessClient = new FullAccessClient(cartRepository);
    }

    @Test
    public void whenBothClientsShareTheSameDataSourceBothHaveTheSameAccess()
    {
        Cart c1 = new Cart("OOSE1", "oose1@gmail.com", new Item[]{ new Item("Frikandel", 10)}, 100);
        Cart c2 = new Cart("OOSE2", "oose2@gmail.com", new Item[]{ new Item("Bamihap", 10)}, 150);

        assertEquals(0, fullAccessClient.saveCurrentCart(c1));
        assertEquals(1, fullAccessClient.saveCurrentCart(c2));

        assertEquals(2, readOnlyAccessClient.getNumberOfCarts());

        readOnlyAccessClient.deleteAll();
        assertEquals(0, readOnlyAccessClient.getNumberOfCarts());
    }
}