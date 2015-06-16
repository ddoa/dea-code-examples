
package oose.dea.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/items")
public class ItemRestService  {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> findAll() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Frikandel", "Snacks", "Restafval, maar wel lekker"));
        items.add(new Item("Bradwurst", "Snacks", "Restafval, maar dan op zijn Duits"));
        return items;
    }
}
