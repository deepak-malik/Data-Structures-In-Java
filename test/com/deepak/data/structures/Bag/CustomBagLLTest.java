/**
 * Data-Structures-In-Java
 * CustomBagLLTest.java
 */
package com.deepak.data.structures.Bag;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Custom Bag
 * 
 * @author Deepak
 */
public class CustomBagLLTest {

	/**
	 * Test cases for Bag creation
	 */
	@Test
	public void testBagCreation() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("B");
		Assert.assertTrue(bag.size() == 2);
	}

	/**
	 * Test cases for removal of a item from Bag
	 */
	@Test
	public void testBagRemoval() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("B");
		Assert.assertTrue(bag.size() == 2);
		bag.add("A");
		bag.add("C");
		Assert.assertTrue(bag.size() == 4);
		bag.remove("A");
		Assert.assertTrue(bag.size() == 3);
		bag.remove("B");
		Assert.assertTrue(bag.size() == 2);
	}

	/**
	 * Test case for bag contains
	 */
	@Test
	public void testBagContains() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("B");
		Assert.assertTrue(bag.contains("A"));
		Assert.assertFalse(bag.contains("C"));
	}

	/**
	 * Test cases for bag clear
	 */
	@Test
	public void testBagClear() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("B");
		Assert.assertTrue(bag.size() == 2);
		bag.clear();
		Assert.assertTrue(bag.size() == 0);
		Assert.assertTrue(bag.isEmpty());
	}

	/**
	 * Test case to check bag size
	 */
	@Test
	public void testBagSize() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("B");
		Assert.assertTrue(bag.size() == 2);
		bag.add("C");
		Assert.assertTrue(bag.size() == 3);
		bag.add("D");
		Assert.assertTrue(bag.size() == 4);
	}

	/**
	 * Test case to check distinct size
	 */
	@Test
	public void testBagDistinctSize() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("A");
		bag.add("A");
		bag.add("B");
		Assert.assertTrue(bag.size() == 4);
		Assert.assertTrue(bag.distinctSize() == 2);
	}

	/**
	 * Test case to check grab
	 */
	@Test
	public void testBagGrab() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("A");
		bag.add("A");
		Assert.assertEquals(bag.grab(), "A");
		bag.add("D");
		bag.add("X");
		Assert.assertNotNull(bag.grab());
	}

	/**
	 * Test case to check toString method
	 */
	@Test
	public void testBagToString() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("B");
		bag.add("B");
		bag.add("C");
		Assert.assertEquals(bag.toString(), "Bag = {A}{B}{B}{C}");
		bag.add("A");
		Assert.assertEquals(bag.toString(), "Bag = {A}{A}{B}{B}{C}");
	}

	/**
	 * Test case to check iterator
	 */
	@Test
	public void testBagIterator() {
		CustomBagLL<String> bag = new CustomBagLL<>();
		Assert.assertTrue(bag.isEmpty());
		bag.add("A");
		bag.add("B");
		bag.add("B");
		bag.add("C");
		Iterator<String> itr = bag.iterator();
		Assert.assertTrue(itr.hasNext());
		Assert.assertEquals(itr.next(), "A");
		Assert.assertTrue(itr.hasNext());
		Assert.assertEquals(itr.next(), "B");
		Assert.assertTrue(itr.hasNext());
		Assert.assertEquals(itr.next(), "B");
		Assert.assertTrue(itr.hasNext());
	}

}
