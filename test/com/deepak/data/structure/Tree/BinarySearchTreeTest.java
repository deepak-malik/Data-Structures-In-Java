package com.deepak.data.structure.Tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * TODO : Test cases implementation
 * 
 * @author Deepak
 */
public class BinarySearchTreeTest {
	
	@Test
	public void testNodeAddition() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.addNode(10);
		binarySearchTree.addNode(8);
		binarySearchTree.addNode(12);
		binarySearchTree.addNode(13);
		Assert.assertTrue(binarySearchTree.size() == 4);
	}

}
