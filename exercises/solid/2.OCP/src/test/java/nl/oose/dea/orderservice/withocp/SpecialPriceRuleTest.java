package nl.oose.dea.orderservice.withocp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialPriceRuleTest {
    private PriceRule eachPriceRule;

    @Before
    public void setUp()
    {
        eachPriceRule = new SpecialPriceRule();
    }

    @Test
    public void ruleOnlyAppliesToSKUStartingWithTheWordEach()
    {
        assertTrue(eachPriceRule.isMatch(createSpecialItem()));
        assertFalse(eachPriceRule.isMatch(createItem("EACH")));
    }

    @Test
    public void ruleCalculatesPriceAmountTimesFive()
    {
        assertEquals(2.0, eachPriceRule.calculatePrice(createSpecialItem()),0.1);
    }

    private Item createSpecialItem()
    {
        return createItem("SPECIAL");
    }

    private Item createItem(String prefix) {
        return new Item(prefix + "_Fritessaus", 6);
    }
}
