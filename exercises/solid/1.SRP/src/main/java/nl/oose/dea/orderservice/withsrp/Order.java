package nl.oose.dea.orderservice.withsrp;

public abstract class Order {
    protected Cart cart;

    public Order(Cart cart)
    {
        this.cart = cart;
    }

    public void checkout() {}
}
