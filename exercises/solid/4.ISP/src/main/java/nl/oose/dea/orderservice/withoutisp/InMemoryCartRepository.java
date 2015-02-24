package nl.oose.dea.orderservice.withoutisp;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCartRepository implements CartRepository, ReadOnlyCartRepository {
    private List<Cart> carts = new ArrayList<nl.oose.dea.orderservice.withoutisp.Cart>();
    private int lastId = 0;

    @Override
    public void add(Cart cart) {
        cart.setId(lastId);
        carts.add(cart);
        lastId++;
    }

    @Override
    public void update(Cart updatedCart) {
        carts.set(carts.indexOf(find(updatedCart.getId())), updatedCart);
    }

    @Override
    public void remove(nl.oose.dea.orderservice.withoutisp.Cart cart) {
        carts.remove(cart);
    }

    @Override
    public List<Cart> list() {
        return carts;
    }

    @Override
    public nl.oose.dea.orderservice.withoutisp.Cart find(int cartId) {
        for(Cart cart:carts)
        {
            if (cart.getId() == cartId) return cart;
        }
        return null;
    }
}
