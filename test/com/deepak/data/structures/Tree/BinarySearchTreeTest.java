package com.deepak.data.structures.Tree;

import org.junit.Assert;
import org.junit.Test;

import com.deepak.data.structures.Tree.BinarySearchTree;

/**
 * TODO : Test cases implementation
 * 
 * @author Deepak
 */
public class BinarySearchTreeTest {

	/**
	 * Test case of adding N nodes
	 */
	@Test
	public void testNodeAddition() {
		/* Integer type */
		BinarySearchTree<Integer> binarySearchTreeInt = new BinarySearchTree<>();
		binarySearchTreeInt.addNode(10);
		binarySearchTreeInt.addNode(8);
		binarySearchTreeInt.addNode(12);
		binarySearchTreeInt.addNode(13);
		Assert.assertTrue(binarySearchTreeInt.size() == 4);

		/* String type */
		BinarySearchTree<String> binarySearchTreeString = new BinarySearchTree<>();
		binarySearchTreeString.addNode("Alex");
		binarySearchTreeString.addNode("Tom");
		binarySearchTreeString.addNode("Steve");
		binarySearchTreeString.addNode("Bob");
		Assert.assertTrue(binarySearchTreeString.size() == 4);
	}

	@Test
	public void testSizeAndEmptyTree() {
		BinarySearchTree<Integer> binarySearchTreeInt = new BinarySearchTree<>();
		Assert.assertTrue(binarySearchTreeInt.isEmpty());
		Assert.assertTrue(binarySearchTreeInt.size() == 0);
		binarySearchTreeInt.addNode(7);
		Assert.assertFalse(binarySearchTreeInt.isEmpty());
		Assert.assertFalse(binarySearchTreeInt.size() == 0);
		binarySearchTreeInt.addNode(9);
		binarySearchTreeInt.addNode(5);
		Assert.assertTrue(binarySearchTreeInt.size() == 3);
	}

}
