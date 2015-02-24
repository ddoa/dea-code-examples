package nl.oose.dea.orderservice.withoutdip;

public class Cart {
    private Item[] items;
    private String customerName;
    private int amount;
    private String customerEmail;

    public Cart(String customerName, String customerEmail, Item[] items, int amount){
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.items = items;
        this.amount = amount;
    }

    public Item[] getItems() {
        return items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getBillingTotal() {
        return amount;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}
