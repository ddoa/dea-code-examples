package oose.dea.config;

import com.google.inject.servlet.ServletModule;
import oose.dea.controller.ViewItemsPageController;
import oose.dea.dataaccess.ItemDAO;
import oose.dea.dataaccess.ItemJdbcDAO;
import oose.dea.services.ItemService;
import oose.dea.services.local.LocalItemService;

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/viewItems").with(ViewItemsPageController.class);
        bind(ItemService.class).to(LocalItemService.class);
        bind(ItemDAO.class).to(ItemJdbcDAO.class);
    }
}