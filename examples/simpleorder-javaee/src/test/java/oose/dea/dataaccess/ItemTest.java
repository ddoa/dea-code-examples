package oose.dea.dataaccess;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class ItemTest {
    @Test
    public void testGetterSetterCorrectness() {
        new BeanTester().testBean(Item.class);
    }
}