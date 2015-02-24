package nl.oose.dea.orderservice.withoutocp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    private Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @Test
    public void totalIsZeroWhenCartIsEmpty() {
        assertEquals(0, cart.totalAmount(), 0);
    }

    @Test
    public void totalIsFiveWhenCartHasOneEachItem() {
        cart.addItem(new Item("EACH_Frikandel", 1));
        assertEquals(5.0, cart.totalAmount(), 0);
    }

    @Test
    public void totalIsTwoWhenCartHasOnePoundOfFrenchFries() {
        cart.addItem(new Item("WEIGHT_Frietjes", 200)); // small size bag
        cart.addItem(new Item("WEIGHT_Frietjes", 300)); // medium size bag

        assertEquals(2.0, cart.totalAmount(), 0);
    }

    @Test
    public void totalIsEightyCentsWhenCartHasTwoSpecialItems() {
        cart.addItem(new Item("SPECIAL_Fritessaus", 2));
        assertEquals(0.8, cart.totalAmount(), 0.01);
    }

    @Test
    public void totalIsTwoWhenCartHasSixSpecialItems() {
        cart.addItem(new Item("SPECIAL_Fritessaus", 3));
        cart.addItem(new Item("SPECIAL_Fritessaus", 3));
        assertEquals(2, cart.totalAmount(), 0.01);
    }
}