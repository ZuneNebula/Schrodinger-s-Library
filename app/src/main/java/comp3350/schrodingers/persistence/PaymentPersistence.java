package comp3350.schrodingers.persistence;

import java.util.List;

import comp3350.schrodingers.Objects.User.Billing;

public interface PaymentPersistence {
    Billing addCreditCard(Billing creditCard);
    Billing updateCreditCard(Billing creditCard);
    void deleteCreditCard(Billing creditCard);
    List<Billing> getCards();
}
