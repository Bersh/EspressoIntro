package com.example.espressotestapp.exercise;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.example.espressotestapp.R;
import com.example.espressotestapp.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class BrokenTest {
	@Rule
	public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

	//FIXME Should check if text in the welcome label matches R.string.welcome_text
	@Test
	public void checkWelcomeLabel() throws Exception {
		onView(withId(R.id.all)).check(matches(withText(R.string.welcome_text)));
	}

	//FIXME Should click on view with id R.id.btn_start_list2, check if ListActivity is started,
	//click on item #5 and check that alert dialog has text equals to item text
	@Test
	public void checkListScreen() throws Exception {
		onView(withId(R.id.btn_start_list2)).perform(click());
		onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));

		String targetText = "Item 5";
		onView(withId(R.id.recycler_view)).perform(
				RecyclerViewActions.actionOnItem(hasDescendant(withText(targetText)), click()));
		onView(withId(android.R.id.message)).check(matches(allOf(isDisplayed(), withText(targetText))));
	}
}
