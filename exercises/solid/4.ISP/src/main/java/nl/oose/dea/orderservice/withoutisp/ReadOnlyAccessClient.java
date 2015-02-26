package nl.oose.dea.orderservice.withoutisp;

import java.util.List;

public class ReadOnlyAccessClient {

    private CartRepository cartRepository;

    public ReadOnlyAccessClient(CartRepository cartRepository)
    {
        this.cartRepository = cartRepository;
    }

    public int getNumberOfCarts()
    {
        return cartRepository.list().size();
    }

    public void deleteAll()
    {
        List<Cart> carts = cartRepository.list();
        for (int i = carts.size() - 1; i >= 0; i--) {
            cartRepository.remove(carts.get(i));
        }
    }
}
