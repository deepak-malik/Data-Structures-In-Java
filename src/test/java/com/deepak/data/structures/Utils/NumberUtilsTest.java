/**
 * Data-Structures-In-Java
 * NumberUtilsTest.java
 */
package com.deepak.data.structures.Utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Number Utility Functions
 * 
 * @author Deepak
 */
public class NumberUtilsTest {

	/**
	 * Test case to convert string to Integer
	 */
	@Test
	public void testToInt() {
		Assert.assertEquals(NumberUtils.toInt(null), 0);
		Assert.assertEquals(NumberUtils.toInt(""), 0);
		Assert.assertEquals(NumberUtils.toInt("1"), 1);
		Assert.assertEquals(NumberUtils.toInt(null, 1), 1);
		Assert.assertEquals(NumberUtils.toInt("", 1), 1);
		Assert.assertEquals(NumberUtils.toInt("1", 0), 1);
	}

	/**
	 * Method to test all zeros
	 */
	@Test
	public void testAllZeros() {
		Assert.assertEquals(NumberUtils.isAllZeros(null), true);
		Assert.assertEquals(NumberUtils.isAllZeros("000000"), true);
		Assert.assertEquals(NumberUtils.isAllZeros("000001"), false);
	}

	/**
	 * Method to test find minimum out of a given array
	 */
	@Test
	public void testFindMin() {
		int[] array = {1, 3, 6, 9, 10, 7};
		Assert.assertEquals(NumberUtils.min(array), 1);
		Assert.assertEquals(NumberUtils.min(null), 0);
	}

	/**
	 * Method to test find maximum out of a given array
	 */
	@Test
	public void testFindMax() {
		int[] array = {1, 3, 6, 9, 10, 7};
		Assert.assertEquals(NumberUtils.max(array), 10);
		Assert.assertEquals(NumberUtils.max(null), 0);
	}

}
