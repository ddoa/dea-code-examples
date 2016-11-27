package oose.dea.controller;

import oose.dea.dataaccess.Item;
import oose.dea.services.ItemService;
import oose.dea.services.local.LocalItemService;

import javax.inject.Inject;
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
public class ViewItemsPageController extends HttpServlet {
    @Inject
    private ItemService itemService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = itemService.findAll();
        request.setAttribute("all", items);
        request.getRequestDispatcher("viewItems.jsp").forward(request, response);
    }
}
