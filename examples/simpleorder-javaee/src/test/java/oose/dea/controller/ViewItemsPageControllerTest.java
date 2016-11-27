package oose.dea.controller;

import oose.dea.dataaccess.Item;
import oose.dea.services.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewItemsPageControllerTest {
    @Mock
    ItemService itemService;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    RequestDispatcher requestDispatcher;

    @InjectMocks
    private ViewItemsPageController viewPageController;

    private ArrayList<Item> items;

    @Before
    public void setup()
    {
        items = new ArrayList<Item>() {{
            add(new Item("frik", "Vette hap", "Frikandel"));
        }};
        when(itemService.findAll()).thenReturn(items);
        when(httpServletRequest.getRequestDispatcher("viewItems.jsp")).thenReturn(requestDispatcher);
    }

    @Test
    public void doGet() throws Exception {
        viewPageController.doGet(httpServletRequest, httpServletResponse);
        verify(httpServletRequest).setAttribute("all", items);
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);
    }

}