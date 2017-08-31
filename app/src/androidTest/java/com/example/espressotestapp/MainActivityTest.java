package com.example.espressotestapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.espressotestapp.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
	@Rule
	public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

	/**
	 Check that text in the view with id R.id.text is equals to R.string.welcome_text
	 */
	@Test
	public void checkWelcomeLabel() throws Exception {
		onView(withId(R.id.text)).check(matches(withText(R.string.welcome_text)));
	}

	/**
	 Check that text in the view with id R.id.btn_start_list1 is equals to R.string.txt_start_list1
	 */
	@Test
	public void checkButtonText() throws Exception {
		onView(withId(R.id.btn_start_list1)).check(matches(withText(R.string.txt_start_list1)));
	}

	/**
	 * Click on the view with id R.id.btn_start_list1 and check that view with id R.id.recycler_view
	 * (which is on the ListActivity) became visible
	 */
	@Test
	public void checkCorrectActivityLaunched() throws Exception {
		onView(withId(R.id.btn_start_list1)).perform(click());
		onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
	}
}
