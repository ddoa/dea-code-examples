package nl.oose.dea.orderservice.withocp;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private IPricingCalculator pricingCalculator;
    private List<Item> items;

    public Cart(IPricingCalculator pricingCalculator) {
        this.pricingCalculator = pricingCalculator;
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public double totalAmount() {
        double total = 0;
        for(Item item: items) {
            total += pricingCalculator.calculatePrice(item);
        }
        return total;
    }
}
