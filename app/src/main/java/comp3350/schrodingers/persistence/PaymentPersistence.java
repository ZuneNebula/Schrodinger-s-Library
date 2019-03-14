package comp3350.schrodingers.persistence;

import comp3350.schrodingers.objects.User.Billing;

// Interface - provides skeleton for books persistence
public interface PaymentPersistence {
    Billing addCreditCard(Billing creditCard);
    Billing updateCreditCard(Billing creditCard);
    Billing getCard();
    Billing findCard(long number);
}
