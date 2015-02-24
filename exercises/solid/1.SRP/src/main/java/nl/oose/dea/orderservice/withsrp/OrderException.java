package nl.oose.dea.orderservice.withsrp;

public class OrderException extends RuntimeException {
    public OrderException(String message, Exception originalException) {
        super(message, originalException);
    }
}
