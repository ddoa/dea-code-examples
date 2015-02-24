package nl.oose.dea.orderservice.withdip;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderServiceSpringBootstrap {
    /**
     * First define all "beans" in the applicationContext.xml and its dependencies. After that
     * call getBean on the factory and call the checkout method
     *
     * @param args
     */
    public static void main(String[] args) {
        // We use the XML based version of Spring so our code will not be polluted with framework-dependent annotations
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        OnlineOrder onlineOrder = (OnlineOrder) factory.getBean("onlineOrder");
        onlineOrder.checkout();
    }
}
