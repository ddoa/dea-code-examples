package nl.oose.dea.orderservice.withocp;

public class SpecialPriceRule implements PriceRule {
    @Override
    public boolean isMatch(Item item) {
        return item.sku.startsWith("SPECIAL");
    }

    @Override
    public double calculatePrice(Item item) {
        double price = item.quantity * 0.4;
        int setsOfThree = item.quantity / 3;
        price -= setsOfThree * 0.2;
        return price;
    }
}
