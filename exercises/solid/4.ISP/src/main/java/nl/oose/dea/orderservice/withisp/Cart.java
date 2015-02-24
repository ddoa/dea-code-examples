package nl.oose.dea.orderservice.withisp;

public class Cart {
    private int id;
    private Item[] items;
    private String customerName;
    private int billingTotal;
    private String customerEmail;

    public Cart(String customerName, String customerEmail, Item[] items, int billingTotal){
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.items = items;
        this.billingTotal = billingTotal;
    }

    public Item[] getItems() {
        return items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
