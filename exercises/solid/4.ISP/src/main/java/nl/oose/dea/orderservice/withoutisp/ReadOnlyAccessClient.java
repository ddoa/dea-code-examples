package nl.oose.dea.orderservice.withoutisp;

public class ReadOnlyAccessClient {

    private ReadOnlyCartRepository cartRepository;

    public ReadOnlyAccessClient(ReadOnlyCartRepository cartRepository)
    {
        this.cartRepository = cartRepository;
    }

    public int getNumberOfCarts()
    {
        return cartRepository.list().size();
    }

}
