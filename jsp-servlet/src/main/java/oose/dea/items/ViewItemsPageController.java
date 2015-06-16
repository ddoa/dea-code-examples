package oose.dea.items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/viewItems")
public class ViewItemsPageController extends HttpServlet {
    private ItemService itemService = new ItemService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = itemService.findAll();
        request.setAttribute("all", items);
        request.getRequestDispatcher("viewItems.jsp").forward(request, response);
    }
}
