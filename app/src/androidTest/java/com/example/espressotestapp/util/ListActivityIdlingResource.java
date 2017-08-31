package com.example.espressotestapp.util;

import android.app.Activity;
import android.support.test.espresso.IdlingResource;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;

import com.example.espressotestapp.activity.ListActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivityIdlingResource implements IdlingResource {
	private ResourceCallback resourceCallback;

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public boolean isIdleNow() {
		List<Activity> resumedActivities = new ArrayList<>();
		resumedActivities.addAll(ActivityLifecycleMonitorRegistry.getInstance()
				.getActivitiesInStage(Stage.RESUMED));

		for (Activity currentActivity : resumedActivities) {
			if (currentActivity != null && currentActivity.getClass().equals(ListActivity.class)) {
				resourceCallback.onTransitionToIdle();
				return true;
			}
		}
		return false;
	}

	@Override
	public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
		this.resourceCallback = resourceCallback;
	}
}
