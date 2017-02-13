/**
 * Data-Structures-In-Java
 * BooleanUtilsTest.java
 */
package com.deepak.data.structures.Utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Boolean Utility functions
 * 
 * @author Deepak
 */
public class BooleanUtilsTest {

	/**
	 * Test case to check negation
	 */
	@Test
	public void testNegateBoolean() {
		Assert.assertEquals(BooleanUtils.negate(Boolean.TRUE), Boolean.FALSE);
		Assert.assertEquals(BooleanUtils.negate(Boolean.FALSE), Boolean.TRUE);
		Assert.assertEquals(BooleanUtils.negate(null), null);
	}

	/**
	 * Test case to check is True
	 */
	@Test
	public void testIsTrue() {
		Assert.assertEquals(BooleanUtils.isTrue(Boolean.TRUE), true);
		Assert.assertEquals(BooleanUtils.isTrue(Boolean.FALSE), false);
	}

	/**
	 * Test case to check is False
	 */
	@Test
	public void testIsFalse() {
		Assert.assertEquals(BooleanUtils.isFalse(Boolean.TRUE), false);
		Assert.assertEquals(BooleanUtils.isFalse(Boolean.FALSE), true);
	}

	/**
	 * Test case to convert Boolean object to primitive boolean
	 */
	@Test
	public void testToBoolean() {
		Assert.assertEquals(BooleanUtils.toBoolean(Boolean.TRUE), true);
		Assert.assertEquals(BooleanUtils.toBoolean(Boolean.FALSE), false);
	}

	/**
	 * Test case to convert int to Boolean object
	 */
	@Test
	public void testToBooleanObject() {
		Assert.assertEquals(BooleanUtils.toBooleanObject(0), Boolean.FALSE);
		Assert.assertEquals(BooleanUtils.toBooleanObject(1), Boolean.TRUE);
		Assert.assertEquals(BooleanUtils.toBooleanObject(2), Boolean.TRUE);
	}

	/**
	 * Test case to compare two boolean
	 */
	@Test
	public void testCompare() {
		Assert.assertEquals(BooleanUtils.compare(true, true), 0);
		Assert.assertEquals(BooleanUtils.compare(true, false), 1);
		Assert.assertEquals(BooleanUtils.compare(false, true), -1);
	}

}
