package comp3350.schrodingers.persistence;

import comp3350.schrodingers.Objects.User.Billing;

public interface PaymentPersistence {
    void addCreditCard(Billing creditCard);
    void updateCreditCard(Billing creditCard);
    void deleteCreditCard(Billing creditCard);
}
