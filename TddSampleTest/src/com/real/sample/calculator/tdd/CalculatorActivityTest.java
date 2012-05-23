package com.real.sample.calculator.tdd;

import junit.framework.Assert;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.real.sample.calculator.CalculatorActivity;
import com.real.sample.calculator.R;

/**
 * Tests the calculator activity.
 * @author Rainer
 */
public class CalculatorActivityTest extends ActivityUnitTestCase<CalculatorActivity> {

	private CalculatorActivity mClassUnderTest;
	private Intent mStartIntent;
	
	/**
	 * @param activityClass
	 */
	public CalculatorActivityTest() {
		super(CalculatorActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mStartIntent = new Intent(Intent.ACTION_MAIN);
		mClassUnderTest = startActivity(mStartIntent, null, null);
	}

	/**
	 * This test instruments the showResults method and checks its side effects.
	 */
	public final void testShowResult() {
		SpannableStringBuilder operator1 = new SpannableStringBuilder("4");
		SpannableStringBuilder operator2 = new SpannableStringBuilder("8");
		
		mClassUnderTest.showResult(operator1, operator2);
		
		TextView result = (TextView) mClassUnderTest.findViewById(R.id.TextView01); 
		Assert.assertEquals("32.0", result.getText().toString());
	}

	/**
	 * This test checks instrumenting the actual frontend.
	 */
	public final void testClickMultiplyButton() {
		EditText text1 = (EditText) mClassUnderTest.findViewById(R.id.EditText01);
		EditText text2 = (EditText) mClassUnderTest.findViewById(R.id.EditText02);
		text1.setText("4");
		text2.setText("4");
		
		Button btn = (Button) mClassUnderTest.findViewById(R.id.Button01);
		
		btn.performClick();
		
		TextView result = (TextView) mClassUnderTest.findViewById(R.id.TextView01); 
		Assert.assertEquals("16.0", result.getText().toString());
	}
}
