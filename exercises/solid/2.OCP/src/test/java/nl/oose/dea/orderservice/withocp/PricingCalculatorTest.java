package nl.oose.dea.orderservice.withocp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PricingCalculatorTest {
    private IPricingCalculator pricingCalculator;

    @Before
    public void setUp() throws Exception {
        pricingCalculator = new PricingCalculator();
    }

    @Test
    public void totalIsZeroWhenCartIsEmpty() {
        assertEquals(0, pricingCalculator.calculatePrice(new Item("EACH_Frikandel", 0)), 0);
    }

    @Test
    public void totalIsFiveWhenCartHasOneEachItem() {
        assertEquals(5.0, pricingCalculator.calculatePrice(new Item("EACH_Frikandel", 1)), 0);
    }

    @Test
    public void totalIsTwoWhenCartHasOnePoundOfFrenchFries() {
        assertEquals(2.0, pricingCalculator.calculatePrice(new Item("WEIGHT_Frietjes", 500)), 0);
    }

    @Test
    public void totalIsEightyCentsWhenCartHasTwoSpecialItems() {
        assertEquals(0.8, pricingCalculator.calculatePrice(new Item("SPECIAL_Fritessaus", 2)), 0.01);
    }

    @Test
    public void totalIsTwoWhenCartHasSixSpecialItems() {
        assertEquals(2, pricingCalculator.calculatePrice(new Item("SPECIAL_Fritessaus", 6)), 0.01);
    }

    @Test
    public void totalIsZeroWhenNoRuleApplies()
    {
        assertEquals(0, pricingCalculator.calculatePrice(new Item("SOME_Frikandel", 100)), 0);
    }
}