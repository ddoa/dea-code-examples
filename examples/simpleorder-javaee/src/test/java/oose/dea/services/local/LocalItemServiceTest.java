package oose.dea.services.local;

import oose.dea.dataaccess.Item;
import oose.dea.dataaccess.ItemDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocalItemServiceTest {
    @Mock
    ItemDAO itemDAO;

    @InjectMocks
    LocalItemService localItemService;

    private ArrayList<Item> items;

    @Before
    public void setUp() throws Exception {
        items = new ArrayList<Item>() {{
            add(new Item("frik", "Vette hap", "Frikandel"));
        }};
        when(itemDAO.list()).thenReturn(items);
    }

    @Test
    public void findAll() throws Exception {
        assertEquals(localItemService.findAll(), items);
    }

}