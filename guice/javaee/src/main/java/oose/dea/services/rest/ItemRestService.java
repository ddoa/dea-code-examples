
package oose.dea.services.rest;

import oose.dea.dao.FakeItemDAO;
import oose.dea.dao.ItemDAO;
import oose.dea.domain.Item;
import oose.dea.services.ItemService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
public class ItemRestService implements ItemService {

    private ItemDAO itemDAO = new FakeItemDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> findAll() {
        return itemDAO.list();
    }
}
