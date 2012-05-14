/*
 * Copyright (c) 2012 RealNetworks.
 * All rights reserved.
 *
 * RealNetworks Confidential and Proprietary information.
 * Do not redistribute.
 *
 */
package com.real.sample.tdd;

import junit.framework.Assert;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author rainer
 *
 */
public class TddSampleActivityTest extends ActivityUnitTestCase<TddSampleActivity> {

	TddSampleActivity mClassUnderTest;
	private Intent mStartIntent;
	
	/**
	 * @param activityClass
	 */
	public TddSampleActivityTest() {
		super(TddSampleActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mStartIntent = new Intent(Intent.ACTION_MAIN);
		mClassUnderTest = startActivity(mStartIntent, null, null);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Unit tests the multiply method with a set of parameters.
	 */
	public final void testCalculate() {
		Assert.assertEquals(16.0f, mClassUnderTest.multiply(4.0f, 4.0f), 0.001f);
		Assert.assertEquals( 0.0f, mClassUnderTest.multiply(0.0f, 0.0f), 0.001f);
		Assert.assertEquals( 0.0f, mClassUnderTest.multiply(2.0f, 0.0f), 0.001f);
		Assert.assertEquals( 2.0f, mClassUnderTest.multiply(2.0f, 1.0f), 0.001f);
		Assert.assertEquals( -2.0f, mClassUnderTest.multiply(2.0f, -1.0f), 0.001f);
	}
	
	/**
	 * This test instruments the showResults method and checks its side effects.
	 */
	public final void testShowResult() {
		SpannableStringBuilder operator1 = new SpannableStringBuilder("4");
		
		mClassUnderTest.showResult(operator1, operator1);
		
		TextView result = (TextView) mClassUnderTest.findViewById(R.id.TextView01); 
		Assert.assertEquals("16.0", result.getText().toString());
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
