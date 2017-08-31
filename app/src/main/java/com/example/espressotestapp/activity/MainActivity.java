package com.example.espressotestapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.espressotestapp.R;

public class MainActivity extends AppCompatActivity {
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progressBar = findViewById(R.id.progress);

		findViewById(R.id.btn_start_list1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, ListActivity.class));
			}
		});

		findViewById(R.id.btn_start_list2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				progressBar.setVisibility(View.VISIBLE);
				//Note: If we do this with AsyncTask Espresso will be able to detect it and wait until it finishes
				//So I will use Thread here to demonstrate the problem
				(new Thread(new SleepAndStartListScreen())).start();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		progressBar.setVisibility(View.GONE);
	}

	private class SleepAndStartListScreen implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			startActivity(new Intent(MainActivity.this, ListActivity.class));
		}
	}
}
