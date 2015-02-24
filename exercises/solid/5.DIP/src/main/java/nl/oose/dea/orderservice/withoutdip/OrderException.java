package nl.oose.dea.orderservice.withoutdip;

public class OrderException extends RuntimeException {
    public OrderException(String message, Exception originalException) {
        super(message, originalException);
    }
}
