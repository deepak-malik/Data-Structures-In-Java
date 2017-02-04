/**
 * Data-Structures-in-Java
 * BinaryTree.java
 */
package com.deepak.data.structures.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * It is same as binary tree i.e contains at max 2 nodes
 * Left node contains value <= root and right node contains
 * value > root
 * 
 * @author Deepak
 */
public class BinarySearchTree<E extends Comparable<E>> {

	/* We will maintain root and size of the tree.
	 * Size here means number of nodes in the tree */
	private Node<E> root;

	/**
	 * Method to add Node to the tree
	 */
	public void addNode(E value) {
		/* If root is null, make a new node 
		 * and insert at root, else insert in tree */
		if (root == null) {
			root = new Node<E>(value);
		} else {
			addNode(root, value);
		}
	}

	/**
	 * Method to add Node to the tree
	 * 
	 * @param root
	 * @param value
	 * @return {@link Node}
	 */
	private Node<E> addNode(Node<E> root, E value) {
		/* If root is null, return null */
		if (root == null) {
			return null;
		} 
		/* Compare the values and check if we need to
		 * insert in left subtree or right subtree */
		if ((root.value).compareTo(value) <= 0) {
			if (root.left != null) {
				addNode(root.left, value);
			} else {
				root.left = new Node<E>(value);
			}
		} else {
			if (root.right != null) {
				addNode(root.right, value);
			} else {
				root.right = new Node<E>(value);
			}
		}
		return root;
	}

	/**
	 * Method to get size from the root
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return size(root);
	}

	/**
	 * Method to get size from a given node
	 * 
	 * @param node
	 * @return {@link int}
	 */
	private int size(Node<E> node) {
		/* If node is null, size is zero */
		if (node == null) {
			return 0;
		}
		/* Return size of left subtree + size of right subtree + 1 for root */
		return (size(node.left)) + 1 + (size(node.right));
	}

	/**
	 * Method to check if tree is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Method to get the root
	 * 
	 * @return {@link Node}
	 */
	public Node<E> getRoot() {
		if (isEmpty()) {
			return null;
		}
		return root;
	}

	public boolean isRoot(Node<E> node) {
		return node == root;
	}

	public Node<E> findParent(Node<E> node) {
		return findParent(node.value, root, null);
	}

	private Node<E> findParent(E value, Node<E> root, Node<E> parent) {
		if (root == null) {
			return null;
		}
		if (value != root.value) {
			parent = findParent(value, root.left, root);
			if (parent == null) {
				parent = findParent(value, root.right, root);
			}
		}
		return parent;
	}

	public boolean hasParent(Node<E> node) {
		return findParent(node) != null;
	}

	public boolean hasLeftNode(Node<E> node) {
		return node.left != null;
	}

	public boolean hasRightNode(Node<E> node) {
		return node.right != null;
	}

	public Node<E> findLeft(Node<E> node) {
		if (hasLeftNode(node)) {
			return node.left;
		}
		return null;
	}

	public Node<E> findRight(Node<E> node) {
		if (hasRightNode(node)) {
			return node.right;
		}
		return null;
	}

	public boolean isLeafNode(Node<E> node) {
		return !hasLeftNode(node) && !hasRightNode(node);
	}

	public int getDepth(Node<E> node) {
		if (node == null) {
			return 0;
		}
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		return left > right ? left + 1 : right + 1;
	}

	public boolean contains(E value) {
		return search(value) != null;
	}

	public Node<E> search(E value) {
		Node<E> node = root;
		while (node != null && node.value != value) {
			if (value.compareTo(node.value) <= 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}

	public Node<E> delete(E value) {
		return delete(root, value);
	}

	/* There are 3 cases here, 
	 * 1. Node to be removed has no child
	 * 2. Node to be removed has one child
	 * 3. Node to be removed has two child */
	private Node<E> delete(Node<E> root, E value) {
		/* Base case, when tree is empty */
		if (root == null) {
			return root;
		}
		/* Now, go down the tree */
		if (value.compareTo(root.value) < 0) {
			root.left = delete(root.left, value);
		} else if (value.compareTo(root.value) > 0) {
			root.right = delete(root.right, value);
		} else { /* If key is same as the root key, this is the node to be deleted */
			/* Node with only one child or no child */
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			E minv = root.value;
			while (root.left != null)
			{
				minv = root.left.value;
				root = root.left;
			}
			root.value = minv;
			root.right = delete(root.right, root.value);
		}
		return root;
	}

	public E getMinimum() {
		Node<E> node = root;
		while (node.left != null) {
			node = node.left;
		}
		return node.value;
	}

	public E getMaximum() {
		Node<E> node = root;
		while (node.right != null) {
			node = node.right;
		}
		return node.value;
	}

	/* All of these are DFS */
	/* Left -> Root -> Right */
	public void traverseInOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		traverseInOrder(node.left);
		System.out.println(node.value + " ");
		traverseInOrder(node.right);
	}

	/* Root -> Left -> Right */
	public void traversePreOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value + " ");
		traversePreOrder(node.left);
		traversePreOrder(node.right);
	}

	/* Left -> Root -> Right */
	public void traversePostOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		traversePostOrder(node.left);
		System.out.println(node.value + " ");
		traversePostOrder(node.right);
	}

	/* This is BFS */
	/* Level by Level */
	public void traverseLevelOrder(Node<E> root) {
		/* If root is null, return */
		if (root == null) {
			return;
		}
		/* Define two queues and add root to queue 1 */
		Queue<Node<E>> queue1 = new LinkedList<>();
		Queue<Node<E>> queue2 = new LinkedList<>();
		queue1.add(root);
		/* Keep going until both are empty */
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			/* While queue 1 is not empty, keep polling and printing */
			while (!queue1.isEmpty()) {
				root = queue1.poll();
				System.out.println(root.value + " ");
				/* Add children to the other queue */
				if (root.left != null) {
					queue2.add(root.left);
				}
				if (root.right != null) {
					queue2.add(root.right);
				}
			}
			/* We are done with one level. Line space */
			System.out.println();
			while (!queue2.isEmpty()) {
				/* Same logic as queue 1 goes with queue 2 */
				root = queue2.poll();
				System.out.println(root.value + " ");
				if (root.left != null) {
					queue1.add(root.left);
				}
				if (root.right != null) {
					queue1.add(root.right);
				}
			}
			/* Line space when entire tree is printed */
			System.out.println();
		}
	}

	/**
	 * Node class for BST
	 * 
	 * @author Deepak
	 */
	public class Node<T> {

		private Node<T> left;
		private Node<T> right;
		private T value;

		public Node(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "[Node + [Value = " + value + "]";
		}

	}

}
