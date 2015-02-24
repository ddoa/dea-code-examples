package nl.oose.dea.orderservice.withocp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerGramPriceRuleTest {
    private PriceRule eachPriceRule;

    @Before
    public void setUp()
    {
        eachPriceRule = new PerGramPriceRule();
    }

    @Test
    public void ruleOnlyAppliesToSKUStartingWithTheWordEach()
    {
        assertTrue(eachPriceRule.isMatch(createPerGramItem()));
        assertFalse(eachPriceRule.isMatch(createItem("EACH")));
    }

    @Test
    public void ruleCalculatesPriceAmountTimesFive()
    {
        assertEquals(2.0, eachPriceRule.calculatePrice(createPerGramItem()),0);
    }

    private Item createPerGramItem()
    {
        return createItem("WEIGHT");
    }

    private Item createItem(String prefix) {
        return new Item(prefix + "_Frietjes", 500);
    }
}
