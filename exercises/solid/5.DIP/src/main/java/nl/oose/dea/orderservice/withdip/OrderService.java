package nl.oose.dea.orderservice.withdip;

public class OrderService {
    public static void main(String[] args) {
        POSCashOrder posCashOrder = new POSCashOrder(new CartFactory().create());
        posCashOrder.checkout();
    }
}
