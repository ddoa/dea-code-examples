package nl.oose.dea.orderservice.withoutdip;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentGateway {
    private Logger logger = Logger.getLogger(getClass().getName());

    public boolean charge(int amount, String customerName, int cardNumber) {
        logger.log(Level.INFO, "Charged " + customerName + " EUR " + amount + " on card: " + cardNumber);
        return true;
    }
}
