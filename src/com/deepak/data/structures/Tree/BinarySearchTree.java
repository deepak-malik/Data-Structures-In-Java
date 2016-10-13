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
	 * Add Node to the tree
	 */
	public void addNode(E value) {
		if (root == null) {
			root = new Node<E>(value);
		} else {
			addNode(root, value);
		}
	}

	private Node<E> addNode(Node<E> root, E value) {
		if (root == null) {
			return null;
		} 
		if ((root.value).compareTo(value) <= 0) { /* We will insert left */
			if (root.left != null) {
				addNode(root.left, value);
			} else {
				root.left = new Node<E>(value);
			}
		} else { /* We will insert right */
			if (root.right != null) {
				addNode(root.right, value);
			} else {
				root.right = new Node<E>(value);
			}
		}
		return root;
	}

	public int size() {
		return size(root);
	}

	private int size(Node<E> root) {
		if (root == null) {
			return 0;
		}
		return (size(root.left)) + 1 + (size(root.right));
	}

	public boolean isEmpty() {
		return size() == 0;
	}

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
		Queue<Node<E>> firstQ = new LinkedList<>();
		firstQ.add(root);
		
		Queue<Queue<Node<E>>> mainQ = new LinkedList<>();
		mainQ.add(firstQ);
		
		while (!mainQ.isEmpty()) {
	        Queue<Node<E>> levelQ = mainQ.remove();
	        Queue<Node<E>> nextLevelQ = new LinkedList<>();
	        for (Node<E> x : levelQ) {
	            System.out.print(x.value + " ");
	            if (x.left != null)    nextLevelQ.add(x.left);
	            if (x.right != null)   nextLevelQ.add(x.right);
	        }
	        if (!nextLevelQ.isEmpty()) mainQ.add(nextLevelQ);
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
