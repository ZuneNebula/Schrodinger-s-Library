package comp3350.schrodingers.persistence.stubs;

import java.util.Collections;
import java.util.List;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;


public class PaymentPersistenceStub implements PaymentPersistence {

   private User user;
    private List<Billing> cards;
    private UsersPersistence userPersistence;

    public PaymentPersistenceStub(){
        userPersistence = Services.getUsersPersistence();
        user = userPersistence.getUser();
        cards = user.getBilling();
    }

    @Override
    public Billing addCreditCard(Billing creditCard){
        cards.add(creditCard);
        newUser();
        return creditCard;
    }

    public List<Billing> getCards(){
        return Collections.unmodifiableList(cards);
    }

    @Override
    public Billing updateCreditCard(Billing creditCard){
        int index = cards.indexOf(creditCard);
        if(index >= 0) {
            cards.set(index, creditCard);
            newUser();
            return creditCard;
        }
        return null;
    }
    private User newUser(){
        return userPersistence.editUser(new User(user.getEmail(),user.getUserName(),user.getPassword(), user.getAddress(), cards));
    }
}
