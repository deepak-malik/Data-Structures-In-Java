/**
 * Data-Structures-In-Java
 * AssociativeArrayTest.java
 */
package com.deepak.data.structures.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for associative array
 * 
 * @author Deepak
 */
public class AssociativeArrayTest {

	/* Associative array defined */
	AssociativeArray<String, String> associativeArray;

	/**
	 * Method to setup associative array
	 */
	@Before
	public void setup() {
		associativeArray = new AssociativeArray<>(3);
		associativeArray.put("A", "Apple");
		associativeArray.put("B", "Ball");
		associativeArray.put("C", "Cat");
		associativeArray.put("D", "Dog");
		associativeArray.put("E", "Elephant");
		associativeArray.put("F", "Fan");
		associativeArray.put("G", "Goat");
	}

	/**
	 * Method to test associative Array
	 */
	@Test
	public void testAssociativeArray() {
		Assert.assertEquals(associativeArray.size(), 7);
		Assert.assertFalse(associativeArray.isEmpty());
		Assert.assertEquals(associativeArray.get("D"), "Dog");
		associativeArray.put("D", "Dice");
		Assert.assertEquals(associativeArray.get("D"), "Dice");
	}

}
