/**
 * Data-Structures-In-Java
 * SimpleStackTest.java
 */
package com.deepak.data.structures.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for simple stack
 * 
 * @author Deepak
 */
public class SimpleStackTest {

	/**
	 * Test case for push feature
	 */
	@Test
	public void testPush() {
		SimpleStackFromList stack = new SimpleStackFromList();
		Assert.assertTrue(stack.isEmpty());
		Assert.assertTrue(stack.size() == 0);
		stack.push(3);
		Assert.assertFalse(stack.isEmpty());
		Assert.assertTrue(stack.size() == 1);
		stack.push(7);
		stack.push(31);
		Assert.assertTrue(stack.size() == 3);
	}

	/**
	 * Test case for pop feature
	 */
	@Test
	public void testPop() {
		SimpleStackFromList stack = new SimpleStackFromList();
		Assert.assertTrue(stack.isEmpty());
		Assert.assertTrue(stack.size() == 0);
		stack.push(3);
		stack.push(17);
		stack.push(35);
		stack.push(13);
		Assert.assertTrue(stack.size() == 4);
		Assert.assertEquals(stack.pop(), 13);
		Assert.assertEquals(stack.pop(), 35);
		Assert.assertEquals(stack.pop(), 17);
		Assert.assertTrue(stack.size() == 1);
	}

	/**
	 * Test case for peek feature
	 */
	@Test
	public void testPeek() {
		SimpleStackFromList stack = new SimpleStackFromList();
		Assert.assertTrue(stack.isEmpty());
		Assert.assertTrue(stack.size() == 0);
		stack.push(3);
		stack.push(17);
		stack.push(35);
		stack.push(13);
		Assert.assertTrue(stack.size() == 4);
		Assert.assertEquals(stack.peek(), 13);
		Assert.assertTrue(stack.size() == 4);
		stack.pop();
		Assert.assertTrue(stack.size() == 3);
		Assert.assertEquals(stack.peek(), 35);
	}

}
