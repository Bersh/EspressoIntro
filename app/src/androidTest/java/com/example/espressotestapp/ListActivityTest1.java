package com.example.espressotestapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.espressotestapp.activity.ListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class ListActivityTest1 {
	@Rule
	public ActivityTestRule<ListActivity> activityTestRule = new ActivityTestRule<>(ListActivity.class);

	/**
		Click 45th item in the list and check that alert dialog is shown with the correct text
	 */
	@Test
	public void checkAlertDialog() throws Exception {
		String targetText = "Item 45";
		onView(withId(R.id.recycler_view)).perform(
				RecyclerViewActions.actionOnItem(hasDescendant(withText(targetText)), click()));
		onView(withId(android.R.id.message)).check(matches(allOf(isDisplayed(), withText(targetText))));
	}
}
