package comp3350.schrodingers.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.schrodingers.tests.business.PaymentProcessorTest;
import comp3350.schrodingers.tests.objects.BillingTest;
import comp3350.schrodingers.tests.objects.Booktest;
import comp3350.schrodingers.tests.objects.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BillingTest.class,
        Booktest.class,
        UserTest.class,
        BillingTest.class,
        PaymentProcessorTest.class
})
public class AllTests
{

}
