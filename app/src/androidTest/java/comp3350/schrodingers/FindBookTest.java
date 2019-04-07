package comp3350.schrodingers;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import comp3350.schrodingers.presentation.HomeActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FindBookTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void findByAuthor(){
        onView(withId(R.id.action_search)).perform(click());
        onView(ViewMatchers.isAssignableFrom(EditText.class)).perform(typeText("jenny"), pressImeActionButton());
        //TODO still need to check if found something
    }

    @Test
    public void findByTitle(){
        onView(withId(R.id.action_search)).perform(click());
        onView(ViewMatchers.isAssignableFrom(EditText.class)).perform(typeText("escape"), pressImeActionButton());
        //TODO still need to check if found something
    }


}
