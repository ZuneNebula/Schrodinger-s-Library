package comp3350.schrodingers.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.schrodingers.tests.business.AccessPaymentInfoIT;
import comp3350.schrodingers.tests.business.AccessPurchaseHistoryIT;
import comp3350.schrodingers.tests.business.AccessUserInfoIT;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessPaymentInfoIT.class,
        AccessUserInfoIT.class,
        AccessPurchaseHistoryIT.class
})
public class IntegrationTests {
}
