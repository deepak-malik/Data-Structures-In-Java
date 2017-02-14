/**
 * Data-Structures-In-Java
 * ArrayUtilsTest.java
 */
package com.deepak.data.structures.Utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for array utilities
 * 
 * @author Deepak
 */
public class ArrayUtilsTest {

	/**
	 * Test case to check if array is empty
	 */
	@Test
	public void testIsEmpty() {
		String[] strArray = {};
		Assert.assertTrue(ArrayUtils.isEmpty(strArray));
		Integer[] intArray = {1, 2};
		Assert.assertFalse(ArrayUtils.isEmpty(intArray));
	}

	/**
	 * Test case to check toString for array
	 */
	@Test
	public void testToString() {
		String[] strArray = {"Apple", "Ball", "Cat", "Dog"};
		Assert.assertEquals(ArrayUtils.toString(strArray), "Apple,Ball,Cat,Dog");
	}

	/**
	 * Method to test cloning of array
	 */
	@Test
	public void testClone() {
		String[] strArray = {"Apple", "Ball", "Cat", "Dog"};
		String[] newArray = ArrayUtils.clone(strArray);
		Assert.assertTrue(strArray.length == newArray.length);
	}

	/**
	 * Method to test if two arrays are of same length
	 */
	@Test
	public void testIsSameLength() {
		String[] array1 = {"A", "B", "C"};
		String[] array2 = {"X", "Y", "Z"};
		Assert.assertTrue(ArrayUtils.isSameLength(array1, array2));
		String[] array3 = {"A", "B", "C"};
		String[] array4 = {"X", "Y"};
		Assert.assertFalse(ArrayUtils.isSameLength(array3, array4));
	}

	/**
	 * Method to test if two arrays are of same type
	 */
	public void testIsSameType() {
		String[] array1 = {"A", "B", "C"};
		String[] array2 = {"X", "Y", "Z"};
		Assert.assertTrue(ArrayUtils.isSameType(array1, array2));
		Integer[] array3 = {1, 2, 3};
		Assert.assertFalse(ArrayUtils.isSameType(array1, array3));
	}

}
