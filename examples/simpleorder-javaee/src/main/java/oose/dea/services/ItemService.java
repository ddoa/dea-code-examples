package oose.dea.services;

import oose.dea.dataaccess.Item;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface ItemService {
    List<Item> findAll();
}
