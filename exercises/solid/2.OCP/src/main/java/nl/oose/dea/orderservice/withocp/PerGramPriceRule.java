package nl.oose.dea.orderservice.withocp;

public class PerGramPriceRule implements PriceRule {
    @Override
    public boolean isMatch(Item item) {
        return item.sku.startsWith("WEIGHT");
    }

    @Override
    public double calculatePrice(Item item) {
        return (item.quantity * 4.0) / 1000;
    }
}
