package comp3350.schrodingers.persistence;

import java.util.List;

import comp3350.schrodingers.objects.User.Billing;

public interface PaymentPersistence {
    Billing addCreditCard(Billing creditCard);
    Billing updateCreditCard(Billing creditCard);
    List<Billing> getCards();
}
