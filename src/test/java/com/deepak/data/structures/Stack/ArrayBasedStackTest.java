/**
 * Data-Structures-In-Java
 * ArrayBasedStackTest.java
 */
package com.deepak.data.structures.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Array based stack
 * 
 * @author Deepak
 */
public class ArrayBasedStackTest {

	/**
	 * Test case for push feature
	 */
	@Test
	public void testPush() {
		ArrayBasedStack stack = new ArrayBasedStack(10);
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
		ArrayBasedStack stack = new ArrayBasedStack(10);
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
		ArrayBasedStack stack = new ArrayBasedStack(10);
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
