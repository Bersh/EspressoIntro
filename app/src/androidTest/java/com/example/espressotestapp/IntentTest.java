package com.example.espressotestapp;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.espressotestapp.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class IntentTest {
	@Rule
	public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

	/**
	 * Click on view with id R.id.btn_start_list1 and check that intent with component
	 * "com.example.espressotestapp.activity.ListActivity" was fired
	 */
	@Test
	public void testIntent() throws Exception {
		onView(withId(R.id.btn_start_list1)).perform(click());
		intended(hasComponent("com.example.espressotestapp.activity.ListActivity"));
	}
}
