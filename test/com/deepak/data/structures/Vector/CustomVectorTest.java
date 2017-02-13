/**
 * Data-Structures-In-Java
 * CustomVectorTest.java
 */
package com.deepak.data.structures.Vector;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for custom vector
 * 
 * @author Deepak
 */
public class CustomVectorTest {

	/**
	 * Test case for vector creation when no capacity is defined
	 */
	@Test
	public void testVecorCreationWhenNoCapacityIsDefined() {
		CustomVector<String> vector = new CustomVector<>();
		Assert.assertEquals(vector.capacity(), 10);
	}

	/**
	 * Test case for vector creation when capacity is defined
	 */
	@Test
	public void testVectorCreationWhenCapacityIsDefined() {
		CustomVector<String> vector = new CustomVector<>(3);
		Assert.assertEquals(vector.capacity(), 3);
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		vector.addElement("D");
		/* When 4th element is added, capacity should double
		 * since we have not specified increment capacity */
		Assert.assertEquals(vector.capacity(), 6);
	}

	/**
	 * Test case for vector creation when capacity increases
	 * and increment capacity is defined
	 */
	@Test
	public void testVectorCreationWhenCapacityIncreases() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		Assert.assertEquals(vector.capacity(), 3);
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		vector.addElement("D");
		/* When 4th element is added, capacity should increase
		 * taking into consideration, the increment capacity */
		Assert.assertEquals(vector.capacity(), 13);
	}
}
