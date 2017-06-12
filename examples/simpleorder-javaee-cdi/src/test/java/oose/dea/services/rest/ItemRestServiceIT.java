package oose.dea.services.rest;

import oose.dea.IntegrationTest;
import oose.dea.dataaccess.Item;
import oose.dea.dataaccess.ItemDAO;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@Category(IntegrationTest.class)
@RunWith(MockitoJUnitRunner.class)
public class ItemRestServiceIT extends RestEasyIT {
    @InjectMocks
    ItemRestService restService;

    @Mock
    ItemDAO itemDAO;

    public ItemRestServiceIT() {
        super(ItemRestService.class);
    }

    @Override
    protected Object getServiceInstance() {
        return restService;
    }

    @Override
    public void setupDependencies()  {
        ArrayList<Item> items = new ArrayList<Item>() {{
            add(new Item("frik", "Vette hap", "Frikandel"));
        }};
        when(itemDAO.list()).thenReturn(items);
    }

    @Test
    public void findAll() throws Exception {
        ResteasyClient client = new ResteasyClientBuilder().build();
        Response response = client.target("http://localhost:8000/items").request().get();
        String message = response.readEntity(String.class);
        assertEquals("[{\"sku\":\"frik\",\"category\":\"Vette hap\",\"title\":\"Frikandel\"}]", message);
    }

}
