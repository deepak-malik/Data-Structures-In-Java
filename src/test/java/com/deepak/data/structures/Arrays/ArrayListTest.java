/**
 * Data-Structures-In-Java
 * ArrayListTest.java
 */
package com.deepak.data.structures.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for ArrayList implementation
 * 
 * @author Deepak
 */
public class ArrayListTest {

	/**
	 * Test case for array list addition
	 */
	@Test
	public void testArrayListAddition() {
		CustomArrayList<String> list = new CustomArrayList<>();
		Assert.assertTrue(list.size() == 0);
		Assert.assertTrue(list.isEmpty());
		list.add("A");
		Assert.assertTrue(list.size() == 1);
		list.add("b");
		list.add("C");
		Assert.assertTrue(list.size() == 3);
		Assert.assertFalse(list.isEmpty());
	}

	/**
	 * Test case for array list removal
	 */
	@Test
	public void testArrayListRemoval() {
		CustomArrayList<String> list = new CustomArrayList<>();
		Assert.assertTrue(list.size() == 0);
		Assert.assertTrue(list.isEmpty());
		list.add("A");
		list.add("b");
		list.add("C");
		Assert.assertTrue(list.size() == 3);
		Assert.assertEquals(list.get(1), "b");
		list.remove(1);
		Assert.assertEquals(list.get(1), "C");
		Assert.assertTrue(list.size() == 2);
	}

	/**
	 * Test case for array list contains
	 */
	@Test
	public void testArrayListContains() {
		CustomArrayList<String> list = new CustomArrayList<>();
		Assert.assertTrue(list.size() == 0);
		Assert.assertTrue(list.isEmpty());
		list.add("A");
		list.add("b");
		list.add("C");
		Assert.assertTrue(list.contains("C"));
		Assert.assertTrue(list.contains("A"));
	}

	/**
	 * Test case for get
	 */
	@Test
	public void testGet() {
		CustomArrayList<String> list = new CustomArrayList<>();
		Assert.assertTrue(list.size() == 0);
		Assert.assertTrue(list.isEmpty());
		list.add("A");
		list.add("b");
		Assert.assertEquals(list.get(0), "A");
		Assert.assertEquals(list.get(1), "b");
	}

	/**
	 * Test case for checking array size 
	 */
	@Test
	public void testArraySize() {
		CustomArrayList<String> list = new CustomArrayList<>();
		Assert.assertTrue(list.size() == 0);
		Assert.assertTrue(list.isEmpty());
		list.add("A");
		list.add("b");
		list.add("C");
		Object[] array = list.toArray();
		Assert.assertTrue(array.length == 3);
	}

	/**
	 * Test case to check clear All
	 */
	@Test
	public void testClearAll() {
		CustomArrayList<String> list = new CustomArrayList<>();
		Assert.assertTrue(list.size() == 0);
		Assert.assertTrue(list.isEmpty());
		list.add("A");
		list.add("b");
		list.add("C");
		Assert.assertTrue(list.size() == 3);
		Assert.assertFalse(list.isEmpty());
		list.clearAll();
		Assert.assertTrue(list.size() == 0);
		Assert.assertTrue(list.isEmpty());
	}

}
