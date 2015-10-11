package nl.oose.dea.orderservice.withdip;

public class OrderService {
    public static void main(String[] args) {
        POSCreditOrder posCreditOrder =
                new POSCreditOrder(
                        new CartFactory().get(),
                        new PaymentDetails(),
                        new LoggingPaymentProcessor());
        posCreditOrder.checkout();
    }
}
