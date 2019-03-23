package comp3350.schrodingers.tests.persistence;

import comp3350.schrodingers.application.Services;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.persistence.PaymentPersistence;
import comp3350.schrodingers.persistence.UsersPersistence;


public class PaymentPersistenceStub implements PaymentPersistence {

    private User user;
    private Billing card;
    private UsersPersistence userPersistence;

    public PaymentPersistenceStub() {
        userPersistence = new UsersPersistenceStub();
        user = userPersistence.getUser();
        card = user.getBilling();
    }

    @Override
    public Billing addCreditCard(Billing creditCard) {
        card = creditCard;
        newUser(card);
        return card;
    }

    public Billing getCard() {
        return card;
    }

    @Override
    public Billing updateCreditCard(Billing creditCard) {
        card = creditCard;
        newUser(card);
        return card;
    }

    @Override
    public Billing findCard(long number) {
        return card;
    }

    private User newUser(Billing c) {
        return userPersistence.editUser(new User(user.getUserId(), user.getEmail(), user.getUserName(), user.getPassword(), user.getAddress(), c));
    }
}
