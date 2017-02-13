/**
 * Data-Structures-In-Java
 * LevelOrderIterator_Test.java
 */
package com.deepak.data.structures.Iterators;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deepak.data.structures.Iterators.LevelOrderIterator.TreeNode;

/**
 * Test cases for level order iterator
 * 
 * @author Deepak
 */
public class LevelOrderIteratorTest {

	/* Root of the tree */
	private TreeNode<Integer> root;

	/**
	 * Setup to create a base tree
	 * 
	 * 			13
	 * 	  	  /    \
	 * 		 7		19
	 *	    / \    /  \
	 * 	   3   9  17  23
	 */
	@Before
	public void setup() {
		root = new TreeNode<Integer>(13);
		TreeNode<Integer> node2 = new TreeNode<Integer>(7);
		TreeNode<Integer> node3 = new TreeNode<Integer>(19);
		TreeNode<Integer> node4 = new TreeNode<Integer>(3);
		TreeNode<Integer> node5 = new TreeNode<Integer>(9);
		TreeNode<Integer> node6 = new TreeNode<Integer>(17);
		TreeNode<Integer> node7 = new TreeNode<Integer>(23);

		/* Setup Tree */
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
	}

	/**
	 * Test case to check level order iterator
	 */
	@Test(expected=NoSuchElementException.class)
	public void testLevelOrderIterator() {
		LevelOrderIterator<Integer> iterator = new LevelOrderIterator<>(root);
		Assert.assertTrue(iterator.hasNext());
		Assert.assertTrue(iterator.next() == 13);
		Assert.assertTrue(iterator.next() == 7);
		Assert.assertTrue(iterator.hasNext());
		Assert.assertTrue(iterator.next() == 19);
		Assert.assertTrue(iterator.next() == 3);
		Assert.assertTrue(iterator.hasNext());
		Assert.assertTrue(iterator.next() == 9);
		Assert.assertTrue(iterator.next() == 17);
		Assert.assertTrue(iterator.hasNext());
		Assert.assertTrue(iterator.next() == 23);
		Assert.assertFalse(iterator.hasNext());
		Assert.assertTrue(iterator.next() == 23);
	}

}
