package oose.dea.services.rest;

import com.sun.net.httpserver.HttpServer;
import oose.dea.IntegrationTest;
import org.jboss.resteasy.plugins.server.sun.http.HttpContextBuilder;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.ResourceFactory;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.net.InetSocketAddress;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@Category(IntegrationTest.class)
@RunWith(MockitoJUnitRunner.class)
public abstract class RestEasyIT {
    private Class type;
    private HttpContextBuilder contextBuilder;
    private HttpServer httpServer;

    @Mock
    ResourceFactory resourceFactory;

    public RestEasyIT(Class type) { this.type = type; }

    @Before
    public void setup() throws IOException {
        setupDependencies();
        when(resourceFactory.getScannableClass()).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return type;
            }
        });
        when(resourceFactory.createResource(any(HttpRequest.class), any(HttpResponse.class), any(ResteasyProviderFactory.class))).thenReturn(getServiceInstance());
        httpServer = HttpServer.create(new InetSocketAddress(8000), 10);
        contextBuilder = new HttpContextBuilder();
        contextBuilder.getDeployment().getResourceFactories().add(resourceFactory);
        contextBuilder.bind(httpServer);
        httpServer.start();
    }

    protected abstract Object getServiceInstance();

    protected abstract void setupDependencies();


    @After
    public void tearDown() {
        contextBuilder.cleanup();
        httpServer.stop(0);
    }
}
