/**
 * Data-Structures-In-Java
 * TupleTest.java
 */
package com.deepak.data.structures.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Tuple
 * 
 * @author Deepak
 */
public class TupleTest {

	/**
	 * Method to test Tuple
	 */
	@Test
	public void testTuple() {
		/* Create Tuple with two possible ways */
		Tuple<String, String, String> tuple1 = new Tuple<>("A", "B", "C");
		Tuple<String, String, String> tuple2 = Tuple.of("A", "B", "C");
		Assert.assertEquals(tuple1.getLeft(), tuple2.getLeft());
		Assert.assertEquals(tuple1.getMiddle(), tuple2.getMiddle());
		Assert.assertEquals(tuple1.getRight(), tuple2.getRight());

		/* Create a Tuple with null values */
		Tuple<String, String, String> tuple3 = new Tuple<>(null, null, null);
		Assert.assertEquals(tuple3.getLeft(), null);
		Assert.assertEquals(tuple3.getMiddle(), null);
		Assert.assertEquals(tuple3.getRight(), null);
	}

}
