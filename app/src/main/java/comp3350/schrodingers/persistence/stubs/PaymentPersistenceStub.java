package comp3350.schrodingers.persistence.stubs;

import comp3350.schrodingers.Objects.User.Billing;
import comp3350.schrodingers.persistence.PaymentPersistence;

import java.util.ArrayList;
import java.util.List;


public class PaymentPersistenceStub implements PaymentPersistence {
    private List<Billing> bills;
    public PaymentPersistenceStub(){
        bills = new ArrayList<>();
    }
    @Override
    public void addCreditCard(Billing creditCard){
        bills.add(creditCard);
    }
    @Override
    public void updateCreditCard(Billing creditCard){
        int index = bills.indexOf(creditCard);
        if(index >= 0)
            bills.set(index,creditCard);
    }
    @Override
    public void deleteCreditCard(Billing creditCard){
        int index = bills.indexOf(creditCard);
        if(index >= 0)
            bills.remove(index);
    }

}
