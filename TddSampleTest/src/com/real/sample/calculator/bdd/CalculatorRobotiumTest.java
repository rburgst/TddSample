package com.real.sample.calculator.bdd;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;
import com.real.sample.calculator.TddSampleActivity;
import com.real.sample.tdd.R;

public class CalculatorRobotiumTest extends
		ActivityInstrumentationTestCase2<TddSampleActivity> {
	private Solo solo;

	public CalculatorRobotiumTest() {
		super(TddSampleActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	/**
	 * Implements a black box text that will simply instrument the UI without
	 * knowing the details about its implementation.
	 */
	public void testCalculateBlackBox() {

		// Enter 10 in first editfield
		solo.enterText(0, "10");

		// Enter 20 in second editfield
		solo.enterText(1, "20");

		// Click on Multiply button
		solo.clickOnButton("Multiply");

		// Verify that result of 10 x 20 is correct
		assertTrue(solo.searchText("200"));
	}

	/**
	 * Implements a white box test using specific knowledge about the UI hierarchy of the target application.
	 * This test is more precise as it can make sure that the searched texts appear in the correct views rather than
	 * anywhere in the UI.
	 * <p>
	 * However, it is also more fragile against application changes (such as id changes of certain UI elements).
	 */
	public void testCalculateWhiteBox() {

		// Defining our own values to multiply
		float firstNumber = 10;
		float secondNumber = 20;
		float result = firstNumber * secondNumber;

		// Access First value (editfiled) and putting firstNumber value in it
		EditText firstEditText = (EditText) solo.getView(R.id.EditText01);
		solo.enterText(firstEditText, String.valueOf(firstNumber));

		// Access Second value (editfiled) and putting SecondNumber value in it
		EditText secondEditText = (EditText) solo.getView(R.id.EditText02);
		solo.enterText(secondEditText, String.valueOf(secondNumber));

		// Click on Multiply button
		solo.clickOnButton("Multiply");

		assertTrue(solo.searchText(String.valueOf(result)));

		TextView outputField = (TextView) solo.getView(R.id.TextView01);

		ArrayList currentTextViews = solo.getCurrentTextViews(outputField);
		assertFalse(currentTextViews.isEmpty());

		TextView output = (TextView) currentTextViews.get(0);

		// Assert to verify result with visible value
		assertEquals(String.valueOf(result), output.getText().toString());
	}

	@Override
	protected void tearDown() throws Exception {

		solo.finishOpenedActivities();
	}
}