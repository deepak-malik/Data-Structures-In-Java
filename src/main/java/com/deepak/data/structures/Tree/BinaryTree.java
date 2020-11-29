/**
 * Data-Structures-in-Java
 * BinaryTree.java
 */
package com.deepak.data.structures.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree implementation
 * 
 * @author Deepak
 *
 * @param <E>
 */
public class BinaryTree<E extends Comparable<E>> {

	/* Root of tree and counter to keep track of size */
	private Node<E> root;
	private int size = 0;

	/**
	 * Method to add a node to tree
	 * 
	 * @param value
	 */
	public void addNode(E value) {
		/* If size is zero, make it a root node */
		if (size == 0) {
			root = new Node<E>(value);
			size++;
		} else {
			/* Add the node */
			addNode(root, value);
		}
	}

	/**
	 * Method to add the node in a tree 
	 * 
	 * @param rootNode
	 * @param value
	 * @return {@link Node}
	 */
	private Node<E> addNode(Node<E> rootNode, E value) {
		/* If root is null, return null */
		if (rootNode == null) {
			return null;
		}
		/* Create a new node */
		Node<E> newNode = new Node<E>(value);
		/* Compare with the root, if small, insert left else insert right */
		if ((newNode.data).compareTo(rootNode.data) <= 0) {
			if (rootNode.left != null) {
				rootNode.left = addNode(rootNode.left, value);
			} else {
				rootNode.left = newNode;
			}
		} else {
			if (rootNode.right != null) {
				rootNode.right = addNode(rootNode.right, value);
			} else {
				rootNode.right = newNode;
			}
		}
		/* Increase the size and return rootNode */
		size++;
		return rootNode;	
	}

	/**
	 * Method to find the root of the tree
	 * 
	 * @return {@link Node}
	 */
	public Node<E> root() {
		/* If tree is empty, return null 
		 * else return return root node */
		if (isEmpty()) {
			return null;
		} else {
			return root;
		}
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
	 * Method to check size of tree
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return size(root);
	}

	/**
	 * Find the size of the tree from a given node
	 *  
	 * @param root
	 * @return {@link int}
	 */
	private int size(Node<E> root) {
		/* If root is null, return 0 else
		 * size of left subtree + size of right subtree
		 * + 1 for root */
		if (root == null) {
			return 0;
		} else {
			return (size(root.left)) + 1 + (size(root.right));
		}
	}

	/**
	 * Method to check if given node is root
	 * 
	 * @param node
	 * @return {@link boolean}
	 */
	public boolean isRoot(Node<E> node) {
		/* If given node is root, return true */
		if (root == node) {
			return true;
		}
		return false;
	}

	/**
	 * Method to find the parent of a given node
	 * 
	 * @param node
	 * @return {@link Node}
	 */
	public Node<E> findParent(Node<E> node) {
		return findParent(node.data, root, null);
	}

	/**
	 * Method to find the parent of a given node
	 * 
	 * @param data
	 * @param root
	 * @param parent
	 * @return {@link Node} 
	 */
	private Node<E> findParent(E data, Node<E> root, Node<E> parent) {
		/* If root is null, there is no parent */
		if (root == null) {
			return null;
		}
		/* Compare the root with the data. If they are not equal,
		 * first find parent in left subtree, if still parent is not found
		 * check right subtree */
		if ((root.data).compareTo(data) != 0) {
			parent = findParent(data, root.left, root);
			if (parent == null) {
				parent = findParent(data, root.right, root); 
			}
		}
		return parent;
	}

	/**
	 * Method to check if a given node has parent
	 * 
	 * @param node
	 * @return {@link boolean}
	 */
	public boolean hasParent(Node<E> node) {
		/* If parent is not null, exits */
		return findParent(node) != null;
	}

	/**
	 * Method to check if a given node has left node
	 * 
	 * @param node
	 * @return {@link boolean}
	 */
	public boolean hasLeft(Node<E> node) {
		if (node.left != null) {
			return true;
		}
		return false;
	}

	/**
	 * Method to find the left node of a given node
	 * 
	 * @param node
	 * @return {@link Node}
	 */
	public Node<E> left(Node<E> node) {
		/* If left exists, then return that */
		if (hasLeft(node)) {
			return node.left;
		}
		return null;
	}

	/**
	 * Method to check if right node exits for a given node
	 * 
	 * @param node
	 * @return {@link boolean}
	 */
	public boolean hasRight(Node<E> node) {
		if (node.right != null) {
			return true;
		}
		return false;
	}

	/**
	 * Method to find the right node for a given node
	 * 
	 * @param node
	 * @return {@link Node}
	 */
	public Node<E> right(Node<E> node) {
		if (hasRight(node)) {
			return node.right;
		}
		return null;
	}

	/**
	 * Method to check if a given node is a leaf
	 * 
	 * @param node
	 * @return {@link boolean}
	 */
	public boolean isLeaf(Node<E> node) {
		/* If no left or right child, its a leaf node */
		return !hasLeft(node) && !hasRight(node);
	}

	/**
	 * Method to get depth of the tree
	 * This is considered as Level as well
	 *  
	 * @param node
	 * @return {@link int}
	 */
	public int getDepth(Node<E> node) {
		/* If given node is null, size is zero */
		if (node == null) {
			return 0;
		}
		/* Get the depth of left and right. 
		 * Whichever is greater, return that and add 
		 * one for root */
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		return left > right ? left + 1 : right + 1; 
	}

	/**
	 * Method to print the tree InOrder
	 * InOrder : Left -> Root -> Right
	 * 
	 * @param node
	 */
	public void printInOrder(Node<E> node) {
		/* If root is null, return else print 
		 * in order specified above */
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}

	/**
	 * Method to print the tree PreOrder
	 * PreOrder : Root -> Left -> Right
	 * 
	 * @param node
	 */
	public void printPreorder(Node<E> node) {
		/* If root is null, return else print 
		 * in order specified above */
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	/**
	 * Method to print the tree PostOrder
	 * PostOrder : Left -> Right -> Root
	 * 
	 * @param node
	 */
	public void printPostorder(Node<E> node) {
		/* If root is null, return else print 
		 * in order specified above */
		if (node == null) {
			return;
		}
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}

	/**
	 * Method to print the tree level by level 
	 * 
	 * Approach => Use 2 queues, Keep polling from queue 1 and 
	 * keep adding to queue 2. Now, for next level, keep polling
	 * from queue 2 and keep adding from queue 1. Stop when both
	 * queues are empty. 
	 * Basically elements at any level will be in one queue
	 * 
	 * @param root
	 */
	public void printByLevelUsingTwoQueues(Node<E> root) {
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
				System.out.println(root.data + " ");
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
				System.out.println(root.data + " ");
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
	 * Method to print the tree level by level 
	 * 
	 * Approach => Use one queue and a delimiter i.e null.
	 * Add delimiter after every level. As soon as you 
	 * encounter a null, print a new line and add null
	 * to the end of the queue
	 * 
	 * @param root
	 */
	public void printByLevelUsingOneQueueAndDelimiter(Node<E> root) {
		/* If root is null, return */
		if (root == null) {
			return;
		}
		/* Define a queue, add root to it. 
		 * Since root itself is a level, add null */
		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		/* Keep going until queue is empty */
		while (!queue.isEmpty()) {
			/* Poll the node and print its content. 
			 * Keep adding elements from the next level */
			root = queue.poll();
			if (root != null) {
				System.out.println(root.data + " ");
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			} else {
				/* If we encounter null, print a new line and add null at the end */
				if (!queue.isEmpty()) {
					System.out.println();
					queue.add(null);
				}
			}
		}
	}

	/**
	 * Method to print the tree level by level 
	 * 
	 * Approach => Use one queue with count. Keep count of nodes at every level. 
	 * As soon as this count is 0 print a new line.
	 * 
	 * @param root
	 */
	public void printByLevelUsingOneQueueAndCounter(Node<E> root) {
		/* If root is null, return */
		if (root == null) {
			return;
		}
		/* Define a queue and add root to it */
		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(root);
		/* Keep track of level and elements in level */
		int levelCount = 1;
		int currentCount = 0;
		/* Keep going until queue is empty */
		while (!queue.isEmpty()) {
			while (levelCount > 0) {
				/* Get the data, print the content and add children.
				 * Increase the element counter and decrease the level counter */
				root = queue.poll();
				System.out.println(root.data + " ");
				if (root.left != null) {
					currentCount++;
					queue.add(root.left);
				}
				if (root.right != null) {
					currentCount++;
					queue.add(root.right);
				}
				levelCount--;
			}
			/* Print new line, make level counter to current counter
			 * and set current counter to 0 */
			System.out.println();
			levelCount = currentCount;
			currentCount = 0;
		}
	}

	/**
	 * Tree node class 
	 * 
	 * @author Deepak
	 *
	 * @param <T>
	 */
	public class Node<T> {

		/* Left child, right child and data */
		private Node<T> left;
		private Node<T> right;
		private T data;

		/**
		 * Constructor to create a tree node
		 * 
		 * @param data
		 */
		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

}
