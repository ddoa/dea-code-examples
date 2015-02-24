package nl.oose.dea.orderservice.withsrp;

public class Item {
    // SKU' A store's or catalog's product and service identification code, often portrayed as a
    // machine-readable bar code that helps the item to be tracked for inventory.
    public String sku;
    public int quantity;

    public Item(String sku, int quantity)
    {
        this.sku = sku;
        this.quantity = quantity;
    }
}
