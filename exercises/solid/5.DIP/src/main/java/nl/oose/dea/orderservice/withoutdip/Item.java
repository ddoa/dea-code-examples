package nl.oose.dea.orderservice.withoutdip;

public class Item {
    public String sku;
    public int quantity;

    public Item(String sku, int quantity)
    {
        this.sku = sku;
        this.quantity = quantity;
    }
}
