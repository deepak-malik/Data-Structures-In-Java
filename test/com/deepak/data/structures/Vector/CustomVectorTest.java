/**
 * Data-Structures-In-Java
 * CustomVectorTest.java
 */
package com.deepak.data.structures.Vector;

import java.util.Enumeration;

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
	public void testVectorCreationWhenNoCapacityIsDefined() {
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

	/**
	 * Test case to check vectors capacity and size
	 */
	@Test
	public void testVectorCapacityAndSize() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		Assert.assertEquals(vector.capacity(), 3);
		Assert.assertEquals(vector.size(), 0);
		Assert.assertTrue(vector.isEmpty());
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		vector.addElement("D");
		Assert.assertEquals(vector.size(), 4);
		Assert.assertFalse(vector.isEmpty());
	}

	/**
	 * Test case to check enumeration of a vector
	 */
	@Test
	public void testEnumeration() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		Assert.assertEquals(vector.capacity(), 3);
		Assert.assertEquals(vector.size(), 0);
		Assert.assertTrue(vector.isEmpty());
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		vector.addElement("D");
		Enumeration<String> enumeration = vector.elements();
		if (enumeration.hasMoreElements()) {
			String output = (String) enumeration.nextElement();
			Assert.assertEquals(output, "A");
		}
	}

	/**
	 * Test case to check if vector contains element
	 */
	@Test
	public void testContains() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		Assert.assertEquals(vector.capacity(), 3);
		Assert.assertEquals(vector.size(), 0);
		Assert.assertTrue(vector.isEmpty());
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		Assert.assertTrue(vector.contains("A"));
		Assert.assertTrue(vector.contains("B"));
		Assert.assertTrue(vector.contains("C"));
		Assert.assertFalse(vector.contains("D"));
	}

	/**
	 * Test case to check if element is available at index
	 */
	@Test
	public void testElementAt() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		Assert.assertEquals(vector.capacity(), 3);
		Assert.assertEquals(vector.size(), 0);
		Assert.assertTrue(vector.isEmpty());
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		Assert.assertEquals(vector.elementAt(1), "B");
		Assert.assertEquals(vector.elementAt(2), "C");
	}

	/**
	 * Test case to check first and last element
	 */
	@Test
	public void testFirstAndLastElement() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		Assert.assertEquals(vector.firstElement(), "A");
		Assert.assertEquals(vector.lastElement(), "C");
	}

	/**
	 * Test case to check set element
	 */
	@Test
	public void testSetElement() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		vector.setElementAt("M", 1);
		Assert.assertEquals(vector.get(1), "M");
	}

	/**
	 * Test case to check remove element
	 */
	@Test
	public void testRemoveElement() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		Assert.assertEquals(vector.size(), 3);
		vector.removeElementAt(1);
		Assert.assertEquals(vector.size(), 2);
		vector.removeElementAt(1);
		Assert.assertEquals(vector.size(), 1);
	}

	/**
	 * Test case to check insertion of element at particular index
	 */
	@Test
	public void testInsertElementAt() {
		CustomVector<String> vector = new CustomVector<>(3, 10);
		vector.addElement("A");
		vector.addElement("B");
		vector.addElement("C");
		Assert.assertEquals(vector.size(), 3);
		vector.insertElementAt("D", 1);
		Assert.assertEquals(vector.elementAt(0), "A");
		Assert.assertEquals(vector.elementAt(1), "D");
		Assert.assertEquals(vector.elementAt(2), "B");
		Assert.assertEquals(vector.elementAt(3), "C");
	}

}
