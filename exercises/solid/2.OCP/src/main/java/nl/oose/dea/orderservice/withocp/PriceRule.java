package nl.oose.dea.orderservice.withocp;

public interface PriceRule {
    boolean isMatch(Item eachItem);

    double calculatePrice(Item eachItem);
}
