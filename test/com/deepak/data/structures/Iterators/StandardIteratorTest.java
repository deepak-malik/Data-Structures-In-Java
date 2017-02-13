/**
 * Data-Structures-In-Java
 * StandardIterator_Test.java
 */
package com.deepak.data.structures.Iterators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Standard Iterator
 * 
 * @author Deepak
 */
public class StandardIteratorTest {

	/**
	 * Test case to check iterator for Integers
	 */
	@Test(expected=UnsupportedOperationException.class)
	public void testStandardIteratorForIntegers() {
		List<Integer> integerList = Arrays.asList(1, 3, 5, 7, 9);
		StandardIterator<Integer> iterator = new StandardIterator<>(integerList);
		Assert.assertTrue(iterator.hasNext());
		Assert.assertTrue(iterator.next() == 1);
		Assert.assertTrue(iterator.next() == 3);
		Assert.assertTrue(iterator.next() == 5);
		Assert.assertTrue(iterator.next() == 7);
		Assert.assertTrue(iterator.next() == 9);
		Assert.assertFalse(iterator.hasNext());
		iterator.remove();
	}

	/**
	 * Test case to check iterator for strings 
	 */
	@Test(expected=UnsupportedOperationException.class)
	public void testStandardIteratorForStrings() {
		List<String> stringList = Arrays.asList("Alex", "Bob", "Tom", "Steve", "Richard");
		StandardIterator<String> iterator = new StandardIterator<>(stringList);
		Assert.assertTrue(iterator.hasNext());
		Assert.assertTrue(iterator.next().equals("Alex"));
		Assert.assertTrue(iterator.next().equals("Bob"));
		Assert.assertTrue(iterator.next().equals("Tom"));
		Assert.assertTrue(iterator.next().equals("Steve"));
		Assert.assertTrue(iterator.next().equals("Richard"));
		Assert.assertFalse(iterator.hasNext());
		iterator.remove();
	}

	/**
	 * Test case to check iterator for strings using custom iterator
	 */
	@Test(expected=UnsupportedOperationException.class)
	public void testStandardIteratorForStringsWithComparator() {
		List<String> stringList = Arrays.asList("Alex", "Bob", "Tom", "Steve", "Richard");
		MyComparator<String> comparator = new MyComparator<>();
		StandardIterator<String> iterator = new StandardIterator<>(stringList, comparator);
		Assert.assertTrue(iterator.hasNext());
		Assert.assertTrue(iterator.next().equals("Alex"));
		Assert.assertTrue(iterator.next().equals("Bob"));
		Assert.assertTrue(iterator.next().equals("Richard"));
		Assert.assertTrue(iterator.next().equals("Steve"));
		Assert.assertTrue(iterator.next().equals("Tom"));
		Assert.assertFalse(iterator.hasNext());
		iterator.remove();
	}

	/**
	 * Comparator class which just handles string as of now.
	 * This will sort strings in alphabetical order
	 * 
	 * @author Deepak
	 *
	 * @param <T>
	 */
	public class MyComparator<T> implements Comparator<T> {

		@Override
		public int compare(final T o1, final T o2) {
			if (o1 instanceof String && o2 instanceof String) {
				return o1.toString().compareTo(o2.toString());
			}
			return 0;
		}

	}

}
