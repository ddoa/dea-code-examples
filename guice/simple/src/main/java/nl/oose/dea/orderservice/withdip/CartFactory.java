package nl.oose.dea.orderservice.withdip;

public class CartFactory {
    public Cart create() {
        return new Cart("OOSE", "oose@gmail.com", new Item[] { new Item("Frikandel", 10)}, 100);
    }
}
