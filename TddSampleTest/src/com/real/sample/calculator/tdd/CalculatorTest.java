package com.real.sample.calculator.tdd;

import junit.framework.Assert;
import android.test.AndroidTestCase;

import com.real.sample.calculator.model.Calculator;

/**
 * The test case that tests the calculator model. This test does not rely on any of the Activities infrastructure and
 * is therefore much more isolated.
 * @author Rainer
 */
public class CalculatorTest extends AndroidTestCase {

	private Calculator mObjectUnderTest;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		mObjectUnderTest = new Calculator();
	}

	/**
	 * Unit tests the multiply method with a set of parameters.
	 */
	public final void testMultiply() {
		Assert.assertEquals(16.0f, mObjectUnderTest.multiply(4.0f, 4.0f), 0f);
		Assert.assertEquals( 0.0f, mObjectUnderTest.multiply(0.0f, 0.0f), 0f);
		Assert.assertEquals( 0.0f, mObjectUnderTest.multiply(2.0f, 0.0f), 0f);
		Assert.assertEquals( 2.0f, mObjectUnderTest.multiply(2.0f, 1.0f), 0f);
		Assert.assertEquals( -2.0f, mObjectUnderTest.multiply(2.0f, -1.0f), 0f);
	}

}
