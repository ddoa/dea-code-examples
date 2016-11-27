package oose.dea.services.rest;

import oose.dea.IntegrationTest;
import oose.dea.dataaccess.Item;
import oose.dea.dataaccess.ItemDAO;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import javax.ws.rs.core.Application;

import java.util.ArrayList;

import static oose.dea.config.GuiceResourceConfig.JACKSON_JSON_SERIALIZER;
import static oose.dea.config.GuiceResourceConfig.JSON_SERIALIZER;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Category(IntegrationTest.class)
public class ItemRestServiceIT extends JerseyTest {

    @Test
    public void findAll() throws Exception {
        final String items = target("/items").request().get(String.class);
        assertEquals("[{\"sku\":\"frik\",\"category\":\"Vette hap\",\"title\":\"Frikandel\"}]", items);
    }

    @Override
    protected Application configure() {
        return new ResourceConfig() {
            {
                property(JSON_SERIALIZER, JACKSON_JSON_SERIALIZER);
                register(new TestBinder());
                register(ItemRestService.class);
            }
        };
    }

    private static class TestBinder extends AbstractBinder {
        @Override
        protected void configure() {
            bindFactory(ServiceProvider.class).to(ItemDAO.class);
        }
    }

    private static class ServiceProvider implements Factory<ItemDAO>{
        @Override
        public ItemDAO provide() {
            ItemDAO itemDAO = mock(ItemDAO.class);
            ArrayList<Item> items = new ArrayList<Item>() {{
                add(new Item("frik", "Vette hap", "Frikandel"));
            }};
            when(itemDAO.list()).thenReturn(items);
            return itemDAO;
        }

        @Override
        public void dispose(ItemDAO itemDAO) { }
    }
}