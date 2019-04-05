package comp3350.schrodingers;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.schrodingers.presentation.HomeActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.AllOf.allOf;

import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.contrib.NavigationViewActions.navigateTo;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class AccountTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void createAccount(){
        //logout from default user
        onView(withId(R.id.my_account)).perform(click());
        onView(withId(R.id.logout)).perform(click());

        //create account
        onView(withId(R.id.my_account)).perform(click());
        onView(withId(R.id.account_button)).perform(click());
        onView(withId(R.id.edtName)).perform(typeText("Chris"));
        onView(withId(R.id.edtEmail)).perform(typeText("chris@gmail.com"));
        onView(withId(R.id.edtPassword)).perform(typeText("comp3350"));
        onView(withId(R.id.btnAccount)).perform(click());
        //TODO: there seems to be a bug in create account logic

        //verify account
    }

    @Test
    public void addPaymentInformation(){
        String cardNum = "1234123412341234";
        String expiry = "05/25";
        String cvv = "123";
        String name = "Gordon Freeman";

        // open options from main menu
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open());
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.my_account));


        onView(withId(R.id.paymentInfo)).perform(click());
        //add payment info
        onView(withId(R.id.billing)).perform(clearText());
        onView(withId(R.id.billing)).perform(typeText(cardNum));
        onView(withId(R.id.expDate)).perform(clearText());
        onView(withId(R.id.expDate)).perform(typeText(expiry));
        onView(withId(R.id.cvv)).perform(clearText());
        onView(withId(R.id.cvv)).perform(typeText(cvv));
        onView(withId(R.id.cardName)).perform(clearText());
        onView(withId(R.id.cardName)).perform(typeText(name));
        onView(withId(R.id.resetPayment)).perform(click());

        //verify that all information was added
        onView(withId(R.id.paymentInfo)).perform(click());
        onView(withId(R.id.billing)).check(matches(withText(cardNum)));
        onView(withId(R.id.expDate)).check(matches(withText(expiry)));
        onView(withId(R.id.cvv)).check(matches(withText(cvv)));
        onView(withId(R.id.cardName)).check(matches(withText(name)));

    }
}