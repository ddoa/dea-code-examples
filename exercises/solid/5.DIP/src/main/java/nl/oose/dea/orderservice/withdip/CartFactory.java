package nl.oose.dea.orderservice.withdip;

import com.google.inject.Provider;

public class CartFactory implements Provider<Cart>{
    public Cart get() {
        return new Cart("OOSE", "oose@gmail.com", new Item[] { new Item("Frikandel", 10)}, 100);
    }
}
