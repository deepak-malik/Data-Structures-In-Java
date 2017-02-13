/**
 * Data-Structures-In-Java
 * PairTest.java
 */
package com.deepak.data.structures.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases to check functionality of Pair
 * 
 * @author Deepak
 */
public class PairTest {

	/**
	 * Test cases for Pair
	 */
	@Test
	public void testPair() {
		/* Create pairs with two possible ways */
		Pair<String, String> pair1 = new Pair<>("A", "B");
		Pair<String, String> pair2 = Pair.of("A", "B");
		Assert.assertEquals(pair1.getLeft(), pair2.getLeft());
		Assert.assertEquals(pair1.getRight(), pair2.getRight());

		/* Create a pair with null values */
		Pair<String, String> pair3 = Pair.of(null, null);
		Assert.assertEquals(pair3.getLeft(), pair3.getRight());
	}

}
