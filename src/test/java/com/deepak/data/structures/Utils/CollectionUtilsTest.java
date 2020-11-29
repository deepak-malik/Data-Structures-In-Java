/**
 * Data-Structures-In-Java
 * CollectionUtilsTest.java
 */
package com.deepak.data.structures.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for collection utility methods
 * 
 * @author Deepak
 */
public class CollectionUtilsTest {

	/**
	 * Test case to check if a collection is empty
	 */
	@Test
	public void testIsEmpty() {
		List<String> list = new ArrayList<>();
		Assert.assertTrue(CollectionUtils.isEmpty(list));
		list.add("A");
		Assert.assertFalse(CollectionUtils.isEmpty(list));
	}

	/**
	 * Test cases for sort
	 */
	@Test
	public void testSort() {
		List<String> list = Arrays.asList("C", "A", "F", "B");
		list = CollectionUtils.sort(list);
		Assert.assertTrue(list.get(0) == "A");
		Assert.assertTrue(list.get(1) == "B");
		Assert.assertTrue(list.get(2) == "C");
		Assert.assertTrue(list.get(3) == "F");
	}

	/**
	 * Test case to reverse the collection
	 */
	@Test
	public void testReverse() {
		List<String> list = Arrays.asList("C", "A", "F", "B");
		list = CollectionUtils.reverse(list);
		Assert.assertTrue(list.get(0) == "B");
		Assert.assertTrue(list.get(1) == "F");
		Assert.assertTrue(list.get(2) == "A");
		Assert.assertTrue(list.get(3) == "C");
	}

	/**
	 * Test case to shuffle the collection
	 */
	@Test
	public void testShuffle() {
		List<String> list = Arrays.asList("C", "A", "F", "B");
		List<String> updatedList = CollectionUtils.reverse(list);
		Assert.assertTrue(list.size() == updatedList.size());
	}

	/**
	 * Method to test swapping of elements when index is given
	 */
	@Test
	public void testSwap() {
		List<String> list = Arrays.asList("C", "A", "F", "B");
		Assert.assertTrue(list.get(0) == "C");
		Assert.assertTrue(list.get(1) == "A");
		Assert.assertTrue(list.get(2) == "F");
		Assert.assertTrue(list.get(3) == "B");
		List<String> updatedList = CollectionUtils.swap(list, 1, 2);
		Assert.assertTrue(updatedList.get(0) == "C");
		Assert.assertTrue(updatedList.get(1) == "F");
		Assert.assertTrue(updatedList.get(2) == "A");
		Assert.assertTrue(updatedList.get(3) == "B");
	}

	/**
	 * Test case to check fill functionality
	 */
	@Test
	public void testFill() {
		List<String> list = Arrays.asList("C", "A", "F", "B");
		list = CollectionUtils.fill(list, "M");
		Assert.assertTrue(list.get(0) == "M");
		Assert.assertTrue(list.get(1) == "M");
		Assert.assertTrue(list.get(2) == "M");
		Assert.assertTrue(list.get(3) == "M");
	}

}
