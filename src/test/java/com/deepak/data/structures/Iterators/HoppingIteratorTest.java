/**
 * Data-Structures-In-Java
 * HoppingIteratorTest.java
 */
package com.deepak.data.structures.Iterators;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Hopping Iterator
 * 
 * @author Deepak
 */
public class HoppingIteratorTest {

	/**
	 * Test case for collection of integers
	 */
	@Test
	public void testHoppingIteratorForIntegers() {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

		/* Iterator with 0 hops, behaves the same way */
		HoppingIterator<Integer> iteratorWith0Hops = new HoppingIterator<>(integerList.iterator(), 0);
		Assert.assertTrue(iteratorWith0Hops.hasNext());
		Assert.assertTrue(iteratorWith0Hops.next() == 1);
		Assert.assertTrue(iteratorWith0Hops.next() == 2);
		Assert.assertTrue(iteratorWith0Hops.next() == 3);
		Assert.assertTrue(iteratorWith0Hops.hasNext());
		Assert.assertTrue(iteratorWith0Hops.next() == 4);
		Assert.assertTrue(iteratorWith0Hops.hasNext());
		Assert.assertTrue(iteratorWith0Hops.next() == 5);
		Assert.assertTrue(iteratorWith0Hops.next() == 6);

		/* Iterator with 1 hop, jumps 1 */
		HoppingIterator<Integer> iteratorWith1Hops = new HoppingIterator<>(integerList.iterator(), 1);
		Assert.assertTrue(iteratorWith1Hops.hasNext());
		Assert.assertTrue(iteratorWith1Hops.next() == 1);
		Assert.assertTrue(iteratorWith1Hops.next() == 3);
		Assert.assertTrue(iteratorWith1Hops.hasNext());
		Assert.assertTrue(iteratorWith1Hops.next() == 5);

		/* Iterator with 2 hops, jumps 2 */
		HoppingIterator<Integer> iteratorWith2Hops = new HoppingIterator<>(integerList.iterator(), 2);
		Assert.assertTrue(iteratorWith2Hops.hasNext());
		Assert.assertTrue(iteratorWith2Hops.next() == 1);
		Assert.assertTrue(iteratorWith2Hops.next() == 4);
		Assert.assertFalse(iteratorWith2Hops.hasNext());

		/* Iterator with 3 hops, jumps 3 */
		HoppingIterator<Integer> iteratorWith3Hops = new HoppingIterator<>(integerList.iterator(), 3);
		Assert.assertTrue(iteratorWith3Hops.hasNext());
		Assert.assertTrue(iteratorWith3Hops.next() == 1);
		Assert.assertTrue(iteratorWith3Hops.next() == 5);
		Assert.assertFalse(iteratorWith3Hops.hasNext());
	}

	/**
	 * Test case for collection of strings
	 */
	@Test
	public void testHoppingIteratorForStrings() {
		List<String> stringList = Arrays.asList("A", "B", "C", "D", "E", "F");

		/* Iterator with 0 hops, behaves the same way */
		HoppingIterator<String> iteratorWith0Hops = new HoppingIterator<>(stringList.iterator(), 0);
		Assert.assertTrue(iteratorWith0Hops.hasNext());
		Assert.assertTrue(iteratorWith0Hops.next() == "A");
		Assert.assertTrue(iteratorWith0Hops.next() == "B");
		Assert.assertTrue(iteratorWith0Hops.next() == "C");
		Assert.assertTrue(iteratorWith0Hops.hasNext());
		Assert.assertTrue(iteratorWith0Hops.next() == "D");
		Assert.assertTrue(iteratorWith0Hops.hasNext());
		Assert.assertTrue(iteratorWith0Hops.next() == "E");
		Assert.assertTrue(iteratorWith0Hops.next() == "F");

		/* Iterator with 1 hop, jumps 1 */
		HoppingIterator<String> iteratorWith1Hops = new HoppingIterator<>(stringList.iterator(), 1);
		Assert.assertTrue(iteratorWith1Hops.hasNext());
		Assert.assertTrue(iteratorWith1Hops.next() == "A");
		Assert.assertTrue(iteratorWith1Hops.next() == "C");
		Assert.assertTrue(iteratorWith1Hops.hasNext());
		Assert.assertTrue(iteratorWith1Hops.next() == "E");

		/* Iterator with 2 hops, jumps 2 */
		HoppingIterator<String> iteratorWith2Hops = new HoppingIterator<>(stringList.iterator(), 2);
		Assert.assertTrue(iteratorWith2Hops.hasNext());
		Assert.assertTrue(iteratorWith2Hops.next() == "A");
		Assert.assertTrue(iteratorWith2Hops.next() == "D");
		Assert.assertFalse(iteratorWith2Hops.hasNext());

		/* Iterator with 3 hops, jumps 3 */
		HoppingIterator<String> iteratorWith3Hops = new HoppingIterator<>(stringList.iterator(), 3);
		Assert.assertTrue(iteratorWith3Hops.hasNext());
		Assert.assertTrue(iteratorWith3Hops.next() == "A");
		Assert.assertTrue(iteratorWith3Hops.next() == "E");
		Assert.assertFalse(iteratorWith3Hops.hasNext());
	}

}
