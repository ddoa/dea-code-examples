package nl.oose.dea.orderservice.withoutsrp;

import javax.mail.MessagingException;
import java.util.logging.Logger;

public class Order {
    private Logger logger = Logger.getLogger(getClass().getName());

    public void checkout(Cart cart, PaymentDetails paymentDetails, boolean notifyCustomer)
    {
        if (paymentDetails.paymentMethod == PaymentMethod.CreditCard) chargeCard(paymentDetails, cart);
        reserveInventory(cart);
        if (notifyCustomer) notifyCustomer(cart);
    }

    private void notifyCustomer(Cart cart) {
        MailClient mailClient = new MailClient();
        try {
            mailClient.send("Your order is processed.", cart.getCustomerEmail());
        } catch (MessagingException e) {
            logger.severe(e.getMessage());
            throw new OrderException("Cannot send mail to " + cart.getCustomerEmail(), e);
        }

    }

    private void reserveInventory(Cart cart) {
        for(Item item : cart.getItems())
        {
            try {
                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.reserve(item.sku, item.quantity);
            } catch(InsufficientInventoryException insufficientInventoryException)
            {
                throw new OrderException("Insufficient inventory for item " + item.sku, insufficientInventoryException);
            }
        }
    }

    private void chargeCard(PaymentDetails paymentDetails, Cart cart) {
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.charge(cart.getBillingTotal(), cart.getCustomerName(), paymentDetails.cardNumber);
    }
}
