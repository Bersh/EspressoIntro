package com.example.espressotestapp;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.rule.ActivityTestRule;

import com.example.espressotestapp.activity.MainActivity;
import com.example.espressotestapp.util.ListActivityIdlingResource;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ListActivityTest2 {

	@Rule
	public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

	/**
	 * Click on the view with id R.id.btn_start_list2, wait for an activity of class ListActivity.class
	 * to become resumed using IdlingResource and check that view with id R.id.recycler_view
	 * became visible
	 */
	@Test
	public void checkListScreenLaunched() throws Exception {
		onView(withId(R.id.btn_start_list2)).perform(click());
		ListActivityIdlingResource resource = new ListActivityIdlingResource();
		IdlingRegistry.getInstance().register(resource);
		onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
		IdlingRegistry.getInstance().unregister(resource);
	}
}
