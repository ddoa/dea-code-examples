package oose.dea.config;

import org.glassfish.hk2.api.ServiceLocator;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
class RestResourceConfig extends GuiceResourceConfig {
    @Inject
    public RestResourceConfig(ServiceLocator serviceLocator) {
        packages(true, "oose.dea.services.oose.dea.services.rest");
        property(JSON_SERIALIZER, JACKSON_JSON_SERIALIZER);
        registerGuiceBinding(serviceLocator, new AppBinding());
    }
}