package nl.oose.dea.orderservice.withdip;

import com.google.inject.Provider;
import com.google.inject.Provides;

public class CartProvider implements Provider<Cart> {
    @Provides
    public Cart get() {
        return new Cart("OOSE", "oose@gmail.com", new Item[] { new Item("Frikandel", 10)}, 100);
    }
}
