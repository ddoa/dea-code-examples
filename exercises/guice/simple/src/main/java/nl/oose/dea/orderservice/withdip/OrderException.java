package nl.oose.dea.orderservice.withdip;

public class OrderException extends RuntimeException {
    public OrderException(String message, Exception originalException) {
        super(message, originalException);
    }
}
