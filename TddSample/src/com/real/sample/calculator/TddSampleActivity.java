package com.real.sample.calculator;

import com.real.sample.tdd.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TddSampleActivity extends Activity {
	EditText mFirstValue;
	EditText mSecondValue;
	TextView mResult;
	Button mCalculate;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mFirstValue = (EditText) findViewById(R.id.EditText01);
		mSecondValue = (EditText) findViewById(R.id.EditText02);
		mResult = (TextView) findViewById(R.id.TextView01);
		mResult.setText("0.00");

		mCalculate = (Button) findViewById(R.id.Button01);

		// Adding listener to button
		mCalculate.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Getting first & second values and passing to show result
				showResult(mFirstValue.getText(), mSecondValue.getText());
			}
		});
	}

	// Showing multiply results
	void showResult(Editable first, Editable second) {
		float num1 = Float.parseFloat(first.toString());
		float num2 = Float.parseFloat(second.toString());
		float result = multiply(num1, num2);
		mResult.setText(String.valueOf(result));
	}

	/**
	 * This is now a method that can be tested in an easier fashion. It will calculate the product of 2 operands.
	 * @param num1 		the first operand
	 * @param num2		the second operand
	 * @return	the result of their multiplication.
	 */
	float multiply(float num1, float num2) {
		return num1 * num2;
	}

}
