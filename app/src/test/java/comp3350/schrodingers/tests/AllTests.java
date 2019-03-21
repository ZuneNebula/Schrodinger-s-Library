package comp3350.schrodingers.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.schrodingers.tests.business.AccessPaymentInfoTest;
import comp3350.schrodingers.tests.business.AccessPurchaseHistoryTest;
import comp3350.schrodingers.tests.business.AccessUserInfoTest;
import comp3350.schrodingers.tests.business.CreateAccountTest;
import comp3350.schrodingers.tests.business.PaymentProcessorTest;
import comp3350.schrodingers.tests.business.UserLoginTest;
import comp3350.schrodingers.tests.business.UserValidatorTest;
import comp3350.schrodingers.tests.objects.BillingTest;
import comp3350.schrodingers.tests.objects.BookTest;
import comp3350.schrodingers.tests.objects.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BillingTest.class,
        BookTest.class,
        UserTest.class,
        PaymentProcessorTest.class,
        UserValidatorTest.class,
        AccessUserInfoTest.class,
        AccessPaymentInfoTest.class,
        UserLoginTest.class,
        CreateAccountTest.class,
        AccessPurchaseHistoryTest.class

})
public class AllTests
{

}
