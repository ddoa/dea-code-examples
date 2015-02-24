package nl.oose.dea.orderservice.withocp;

import java.util.ArrayList;
import java.util.List;

public class PricingCalculator implements IPricingCalculator {
    private List<PriceRule> rules;

    public PricingCalculator() {
        rules = new ArrayList() {{
            add(new EachPriceRule());
            add(new PerGramPriceRule());
            add(new SpecialPriceRule());
        }};
    }

    public double calculatePrice(Item item) {
        for(PriceRule rule : rules)
        {
            if (rule.isMatch(item))
                return rule.calculatePrice(item);
        }
        return 0;
    }
}
