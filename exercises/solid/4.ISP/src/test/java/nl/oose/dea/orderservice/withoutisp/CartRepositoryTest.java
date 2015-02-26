package nl.oose.dea.orderservice.withoutisp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartRepositoryTest {
    private CartRepository cartRepository;
    private Cart c1;

    @Before
    public void setUp() throws Exception {
        cartRepository = new InMemoryCartRepository();
        c1 = new Cart("OOSE1", "oose1@gmail.com", new Item[]{ new Item("Frikandel", 10)}, 100);
    }

    @Test
    public void basicFlowOfAllRepositoryActions()
    {
        cartRepository.add(c1);
        assertNotNull(cartRepository.find(0));
        assertEquals(1, cartRepository.list().size());
        c1.getItems()[0].quantity = 2;
        cartRepository.update(c1);
        assertEquals(2, cartRepository.find(0).getItems()[0].quantity);
        cartRepository.remove(c1);
        assertEquals(0, cartRepository.list().size());
    }

    @Test
    public void cannotFindAnythingInAnEmptyRepository()
    {
        assertNull(cartRepository.find(0));
        assertEquals(0, cartRepository.list().size());
    }

    @Test
    public void cannotFindWhenUsingAWrongIdInAFilledRepository()
    {
        cartRepository.add(c1);
        assertNull(cartRepository.find(1));
        assertEquals(1, cartRepository.list().size());
    }

}