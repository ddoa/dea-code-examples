package nl.oose.dea.orderservice.withdip;

public class PaymentDetailsFactory {
    public PaymentDetails create() {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.paymentMethod = PaymentMethod.CreditCard;
        paymentDetails.cardNumber = 1234;
        return paymentDetails;
    }
}
