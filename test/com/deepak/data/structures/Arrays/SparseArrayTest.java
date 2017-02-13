/**
 * Data-Structures-In-Java
 * SparseArrayTest.java
 */
package com.deepak.data.structures.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Sparse Array
 * 
 * @author Deepak
 */
public class SparseArrayTest {

	/**
	 * Test case for sparse array creation
	 */
	@Test
	public void testSparseArrayCreation() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		Assert.assertTrue(sparseArray.isEmpty());
		Assert.assertEquals(sparseArray.size(), 0);
	}

	/**
	 * Test case for sparse get
	 */
	@Test
	public void testGet() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		sparseArray.put(3, "C");
		Assert.assertEquals(sparseArray.size(), 3);
		Assert.assertEquals(sparseArray.get(1), "A");
		Assert.assertEquals(sparseArray.get(2), "B");
		Assert.assertEquals(sparseArray.get(3), "C");
	}

	/**
	 * Test case for sparse get for default value
	 */
	@Test
	public void testWithDefaultValue() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		Assert.assertEquals(sparseArray.size(), 2);
		Assert.assertEquals(sparseArray.get(1), "A");
		Assert.assertEquals(sparseArray.get(3, "DEFAULT"), "DEFAULT");
		Assert.assertEquals(sparseArray.size(), 2);
	}

	/**
	 * Test case for sparse array put functionality
	 */
	@Test
	public void testPut() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		Assert.assertEquals(sparseArray.size(), 2);
		Assert.assertEquals(sparseArray.get(1), "A");
		Assert.assertEquals(sparseArray.get(2), "B");
		sparseArray.put(2, "C");
		Assert.assertEquals(sparseArray.size(), 2);
		Assert.assertEquals(sparseArray.get(2), "C");
	}

	/**
	 * Test case for sparse delete functionality
	 */
	@Test
	public void testDelete() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		Assert.assertEquals(sparseArray.size(), 2);
		sparseArray.delete(1);
		Assert.assertEquals(sparseArray.size(), 1);
		Assert.assertEquals(sparseArray.get(1), null);
		Assert.assertEquals(sparseArray.get(2), "B");
	}

	/**
	 * Test case for sparse remove functionality
	 */
	@Test
	public void testRemove() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		Assert.assertEquals(sparseArray.size(), 2);
		sparseArray.remove(1);
		Assert.assertEquals(sparseArray.size(), 1);
		Assert.assertEquals(sparseArray.get(1), null);
		Assert.assertEquals(sparseArray.get(2), "B");
	}

	/**
	 * Test case for sparse to remove element
	 * at a particular index
	 */
	@Test
	public void testRemoveAt() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		sparseArray.put(3, "C");
		sparseArray.put(4, "D");
		sparseArray.put(5, "E");
		sparseArray.put(6, "F");
		Assert.assertEquals(sparseArray.size(), 6);
		Assert.assertEquals(sparseArray.get(4), "D");
		sparseArray.removeAt(4);
		Assert.assertEquals(sparseArray.get(5), null);
	}

	/**
	 * Test case to get key at given index
	 */
	@Test
	public void testKeyAt() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		sparseArray.put(10, "C");
		Assert.assertEquals(sparseArray.keyAt(1), 2);
		Assert.assertEquals(sparseArray.keyAt(2), 10);
	}

	/**
	 * Test case to get value at a given index
	 */
	@Test
	public void testValueAt() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		sparseArray.put(10, "C");
		Assert.assertEquals(sparseArray.valueAt(0), "A");
		Assert.assertEquals(sparseArray.valueAt(1), "B");
		Assert.assertEquals(sparseArray.valueAt(2), "C");
	}

	/**
	 * Test case to set the value at a given index
	 */
	@Test
	public void testSetValue() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		sparseArray.put(10, "C");
		Assert.assertEquals(sparseArray.valueAt(0), "A");
		sparseArray.setValueAt(0, "New Value");
		Assert.assertEquals(sparseArray.valueAt(0), "New Value");
	}

	/**
	 * Test case to check clear functionality
	 */
	@Test
	public void testClear() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		sparseArray.put(10, "C");
		Assert.assertEquals(sparseArray.size(), 3);
		Assert.assertEquals(sparseArray.valueAt(0), "A");
		sparseArray.clear();
		Assert.assertEquals(sparseArray.size(), 0);
		Assert.assertEquals(sparseArray.valueAt(0), null);
	}

	/**
	 * Test case to check size of sparse array
	 */
	@Test
	public void testSize() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		Assert.assertEquals(sparseArray.size(), 0);
		sparseArray.put(1, "A");
		sparseArray.put(2, "B");
		sparseArray.put(10, "C");
		Assert.assertEquals(sparseArray.size(), 3);
		sparseArray.remove(1);
		Assert.assertEquals(sparseArray.size(), 2);
	}

	/**
	 * Test case to check if sparse array is empty
	 */
	@Test
	public void testIsEmpty() {
		SparseArray<String> sparseArray = new SparseArray<>(3);
		Assert.assertTrue(sparseArray.isEmpty());
		sparseArray.put(1, "Hello");
		Assert.assertFalse(sparseArray.isEmpty());
	}

}
