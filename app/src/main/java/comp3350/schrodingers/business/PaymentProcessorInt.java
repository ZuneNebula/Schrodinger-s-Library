package comp3350.schrodingers.business;

import comp3350.schrodingers.objects.User.Billing;

public interface PaymentProcessorInt {
    boolean validateCard(Billing card) throws CardException;
}
