package nl.oose.dea.orderservice.withisp;

public class FullAccessClient {
    private CartRepository cartRepository;

    public FullAccessClient(CartRepository cartRepository)
    {

        this.cartRepository = cartRepository;
    }

    public int saveCurrentCart(Cart c)
    {
        cartRepository.add(c);
        return c.getId();
    }
}
