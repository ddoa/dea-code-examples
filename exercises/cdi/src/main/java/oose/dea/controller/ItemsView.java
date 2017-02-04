package oose.dea.controller;

import oose.dea.domain.Item;
import oose.dea.services.ItemService;
import oose.dea.services.local.LocalItemService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Singleton
@WebServlet(urlPatterns = "/viewItems")
public class ItemsView extends HttpServlet {
    @Inject
    @Named("localItemService") // this can be removed when using @Default with @Alternative
    private ItemService itemService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = itemService.findAll();
        for(Item item:items)
        {
            response.getWriter().print(item.toString());
        }
    }
}
