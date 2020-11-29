/**
 * Data-Structures-In-Java
 * MaxIterator_Test.java
 */
package com.deepak.data.structures.Iterators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for max iterator
 * 
 * @author Deepak
 */
public class MaxIteratorTest {

	/**
	 * Test case to validate max iterator
	 */
	@Test(expected=NoSuchElementException.class)
	public void testMaxIterator() {
		List<Integer> integerList = Arrays.asList(2, 1, 4, 9, 5);
		MaxIterator<Integer> maxIterator = new MaxIterator<>(integerList.iterator(), 
				new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
		Assert.assertTrue(maxIterator.hasNext());
		Assert.assertTrue(maxIterator.next() == 2);
		Assert.assertTrue(maxIterator.next() == 4);
		Assert.assertTrue(maxIterator.next() == 9);
		Assert.assertFalse(maxIterator.hasNext());
		Assert.assertTrue(maxIterator.next() == 9);
	}

}
