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
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * This test instruments the showResults method and checks its side effects.
	 */
	public final void testShowResult() {
		mClassUnderTest = startActivity(mStartIntent, null, null);
		SpannableStringBuilder operator1 = new SpannableStringBuilder("4");
		
		mClassUnderTest.showResult(operator1, operator1);
		
		TextView result = (TextView) mClassUnderTest.findViewById(R.id.TextView01); 
		Assert.assertEquals("16.0", result.getText().toString());
	}

	/**
	 * This test checks instrumenting the actual frontend.
	 */
	public final void testClickMultiplyButton() {
		mClassUnderTest = startActivity(mStartIntent, null, null);
		EditText text1 = (EditText) mClassUnderTest.findViewById(R.id.EditText01);
		EditText text2 = (EditText) mClassUnderTest.findViewById(R.id.EditText02);
		text1.setText("4");
		text2.setText("4");
		
		Button btn = (Button) mClassUnderTest.findViewById(R.id.Button01);
		
		btn.callOnClick();
		
		TextView result = (TextView) mClassUnderTest.findViewById(R.id.TextView01); 
		Assert.assertEquals("16.0", result.getText().toString());
	}
}
