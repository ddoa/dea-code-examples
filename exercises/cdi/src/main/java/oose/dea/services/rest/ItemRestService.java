
package oose.dea.services.rest;

import oose.dea.dao.ItemDAO;
import oose.dea.domain.Item;
import oose.dea.services.ItemService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
@Named("restItemService")
// @Alternative
public class ItemRestService implements ItemService {
    @Inject
    private ItemDAO itemDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> findAll() {
        return itemDAO.list();
    }
}
