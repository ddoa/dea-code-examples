package oose.dea.services.rest;

import oose.dea.IntegrationTest;
import oose.dea.dataaccess.Item;
import oose.dea.dataaccess.ItemDAO;
import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.jaxrs.SupportJaxRs;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@Category(IntegrationTest.class)
@RunWith(CdiRunner.class)
@SupportJaxRs
/**
 * This is no full integration test as we test agains the Java API but it shows how to use CDI in a test environment
 */
public class ItemRestServiceCDIIT {

    @Produces
    @Mock
    ItemDAO itemDAO;

    @Inject
    ItemRestService itemRestService;

    @Before
    public void setup()
    {
        ArrayList<Item> items = new ArrayList<Item>() {{
            add(new Item("frik", "Vette hap", "Frikandel"));
        }};
        when(itemDAO.list()).thenReturn(items);
    }

    @Test
    public void findAll() throws Exception {
        List<Item> items = itemRestService.findAll();
        assertEquals(1, items.size());
    }
}