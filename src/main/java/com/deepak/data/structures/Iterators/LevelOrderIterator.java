/**
 * Data-Structures-In-Java
 * LevelOrderIterator.java
 */
package com.deepak.data.structures.Iterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * <br> Problem Statement :
 * 
 * Implement an iterator that iterates through a binary tree in level order.
 * 
 * </br>
 * 
 * @author Deepak
 */
public class LevelOrderIterator<T> implements Iterator<T> {

	/* Variable for next item to return */
	private T nextItem;
	/* Queue to hold items level by level */
	private final Queue<TreeNode<T>> queue;

	/**
	 * Constructor
	 * 
	 * @param root
	 */
	public LevelOrderIterator(TreeNode<T> root) {
		queue = new LinkedList<>();
		queue.add(root);
	}

	/**
	 * Method to check if next element exists
	 */
	@Override
	public boolean hasNext() {
		/* If next item exists, return true */
		if (nextItem != null) {
			return true;
		}
		/* If queue is empty, return false */
		if (queue.isEmpty()) {
			return false;
		}
		/* Remove the node from the queue */
		TreeNode<T> node = queue.remove();
		/* If left or right child exists, add to the queue */
		if (node.hasLeft()) {
			queue.add(node.left);
		}
		if (node.hasRight()) {
			queue.add(node.right);
		}
		/* Update next item and return true */
		nextItem = node.item;
		return true;
	}

	/**
	 * Method to find next element 
	 */
	@Override
	public T next() {
		/* If there is no next element, throw exception */
		if (!hasNext()) {
			throw new NoSuchElementException("No Element left in collection!!");
		}
		/* Update item to return and next value */
		T itemToReturn = nextItem;
		nextItem = null;
		return itemToReturn;
	}

	/**
	 * Method to remove the item
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove not supported!");
	}

	/**
	 * TreeNode class
	 * 
	 * @author Deepak
	 *
	 * @param <E>
	 */
	public static class TreeNode<E> {

		/* Data in the node, left child and right child */
		public E item;
		public TreeNode<E> left;
		public TreeNode<E> right;

		/**
		 * Constructor
		 * 
		 * @param item
		 */
		public TreeNode(E item) {
			this.item = item;
		}

		public boolean hasLeft() {
			return left != null;
		}

		public boolean hasRight() {
			return right != null;
		}

	}

}
