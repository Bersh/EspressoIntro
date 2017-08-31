package com.example.espressotestapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.espressotestapp.R;

public class EditActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);

		final EditText edit = findViewById(R.id.edit);
		Button btnOk = findViewById(R.id.btn_ok);
		final TextView txtResult = findViewById(R.id.txt_result);
		txtResult.setText("");

		btnOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				txtResult.setText(edit.getText().toString());
			}
		});
	}
}
