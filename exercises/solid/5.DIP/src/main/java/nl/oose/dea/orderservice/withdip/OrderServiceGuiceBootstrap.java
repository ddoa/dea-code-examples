package nl.oose.dea.orderservice.withdip;

import com.google.inject.Guice;

public class OrderServiceGuiceBootstrap {
    /**
     *
     * You can use Guice as a framework to build all the dependencies. Before you run the main-method, make sure every
     * class you want to inject dependencies to has a constructor annotated with @Inject.
     *
     * @param args
     */
    public static void main(String[] args) {
        POSCreditOrder posCreditOrder = Guice.createInjector(new OrderModule()).getInstance(POSCreditOrder.class);
        posCreditOrder.checkout();
    }
}
