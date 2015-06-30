package oose.dea.guice;

import com.google.inject.servlet.ServletModule;
import oose.dea.controller.ItemsView;
import oose.dea.dao.FakeItemDAO;
import oose.dea.dao.ItemDAO;
import oose.dea.services.ItemService;
import oose.dea.services.local.LocalItemService;

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/viewItems").with(ItemsView.class);
        bind(ItemService.class).to(LocalItemService.class);
        bind(ItemDAO.class).to(FakeItemDAO.class);
    }
}