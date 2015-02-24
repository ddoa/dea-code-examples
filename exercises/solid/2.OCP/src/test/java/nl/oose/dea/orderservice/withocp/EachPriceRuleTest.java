package nl.oose.dea.orderservice.withocp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EachPriceRuleTest {
    private PriceRule eachPriceRule;

    @Before
    public void setUp()
    {
        eachPriceRule = new EachPriceRule();
    }

    @Test
    public void ruleOnlyAppliesToSKUStartingWithTheWordEach()
    {
        assertTrue(eachPriceRule.isMatch(createEachItem()));
        assertFalse(eachPriceRule.isMatch(createItem("WEIGHT")));
    }

    @Test
    public void ruleCalculatesPriceAmountTimesFive()
    {
        assertEquals(5.0, eachPriceRule.calculatePrice(createEachItem()),0);
    }

    private Item createEachItem()
    {
        return createItem("EACH");
    }

    private Item createItem(String prefix) {
        return new Item(prefix + "_Frikandel", 1);
    }
}
