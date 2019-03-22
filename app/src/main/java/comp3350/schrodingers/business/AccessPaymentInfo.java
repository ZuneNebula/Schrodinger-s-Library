package comp3350.schrodingers.business;

import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.persistence.PaymentPersistence;

// Class - facilitates accessing payment info from DB
public class AccessPaymentInfo {

    // Store payment access to DB and relevant/current credit card number
    private PaymentPersistence payPersistence;
    private Billing card;

    // Constructor - initialize DB access
    public AccessPaymentInfo() {
        payPersistence = Services.getPaymentPersistence();
    }

    // Constructor - inject DB access
    public AccessPaymentInfo(final PaymentPersistence payPers) {
        this.payPersistence = payPers;
    }

    // Method - return relevant/current credit card from DB
    public Billing getCard() {
        card = payPersistence.getCard();
        return card;
    }

    // Method - insert credit card into DB
    public Billing insertCard(Billing card) throws CardException {
        PaymentProcessor p = new PaymentProcessor();
        p.validateCard(card);
        if (getCard().isEmpty())
            return payPersistence.addCreditCard(card);
        else return updateCard(card);
    }

    // Method - update credit card stored in DB
    public Billing updateCard(Billing card) {
        return payPersistence.updateCreditCard(card);
    }


}
