package nl.oose.dea.orderservice.withoutocp;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * We need to modify this code when adding new rules. This method does not
     * comply to the OCP!
     * @return
     */
    public double totalAmount()
    {
        double total = 0;
        for(Item item: items)
        {
            if (item.sku.startsWith("EACH"))
            {
                total += item.quantity * 5.0;
            }
            else if(item.sku.startsWith("WEIGHT"))
            {
                total += (item.quantity * 4.0) / 1000;
            }
            else if(item.sku.startsWith("SPECIAL"))
            {
                total += item.quantity * 0.4;
                int setsOfThree = item.quantity / 3;
                total -= setsOfThree * 0.2;
            }
        }
        return total;
    }
}
