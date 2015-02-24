package nl.oose.dea.orderservice.withocp;

public class EachPriceRule implements PriceRule {
    @Override
    public boolean isMatch(Item eachItem) {
        return eachItem.sku.startsWith("EACH");
    }

    @Override
    public double calculatePrice(Item eachItem) {
        return 5.0 * eachItem.quantity;
    }
}
