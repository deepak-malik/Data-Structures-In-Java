/**
 * Data-Structures-And-Algorithms-in-Java
 * ArrayBasedSetTest.java
 */
package com.deepak.data.structures.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Set
 *  
 * @author Deepak
 */
public class ArrayBasedSetTest {

	/**
	 * Test case to check the insertion
	 */
	@Test
	public void testInsertionInSet() {
		ArrayBasedSet<String> set = new ArrayBasedSet<>(5);
		Assert.assertTrue(set.size() == 0);
		set.addElement("One");
		set.addElement("Two");
		set.addElement("Three");
		Assert.assertTrue(set.size() == 3);
		set.addElement("Four");
		Assert.assertTrue(set.size() == 4);
		/* Trying to insert Three again. Size should not change and operation should fail */
		set.addElement("Three"); 
		Assert.assertTrue(set.size() == 4);
	}

	/**
	 * Test case to check other operations on Set
	 */
	@Test
	public void testOtherOperationsOnSet() {
		ArrayBasedSet<String> set = new ArrayBasedSet<>(5);
		Assert.assertTrue(set.isEmpty());
		Assert.assertTrue(set.size() == 0);
		set.addElement("One");
		set.addElement("Two");
		set.addElement("Three");
		Assert.assertTrue(set.contains("Two"));
		Assert.assertTrue(set.size() == 3);
		set.clear();
		Assert.assertTrue(set.isEmpty());
		Assert.assertTrue(set.size() == 0);
	}

}
