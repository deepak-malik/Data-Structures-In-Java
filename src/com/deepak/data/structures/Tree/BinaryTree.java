package com.deepak.data.structures.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<E>> {

	private Node<E> root;
	private int size = 0;

	public void addNode(E value) {
		if (size == 0) {
			root = new Node<E>(value);
			size++;
		} else {
			addNode(root, value);
		}
	}

	private Node<E> addNode(Node<E> rootNode, E value) {
		if (rootNode == null) {
			return null;
		}
		Node<E> newNode = new Node<E>(value);
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
		size++;
		return rootNode;	
	}

	public Node<E> root() {
		if (isEmpty()) {
			return null;
		} else {
			return root;
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size(root);
	}

	private int size(Node<E> root) {
		if (root == null) {
			return 0;
		} else {
			return (size(root.left)) + 1 + (size(root.right));
		}
	}

	public boolean isRoot(Node<E> node) {
		if (root == node) {
			return true;
		}
		return false;
	}

	public Node<E> findParent(Node<E> node) {
		return findParent(node.data, root, null);
	}

	private Node<E> findParent(E data, Node<E> root, Node<E> parent) {
		if (root == null) {
			return null;
		}
		if ((root.data).compareTo(data) != 0) {
			parent = findParent(data, root.left, root);
			if (parent == null) {
				parent = findParent(data, root.right, root); 
			}
		}
		return parent;
	}

	public boolean hasParent(Node<E> node) {
		return findParent(node) != null;
	}

	public boolean hasLeft(Node<E> node) {
		return node.left != null;
	}

	public Node<E> left(Node<E> node) {
		if (hasLeft(node)) {
			return node.left;
		}
		return null;
	}

	public boolean hasRight(Node<E> node) {
		return node.right != null;
	}

	public Node<E> right(Node<E> node) {
		if (hasRight(node)) {
			return node.right;
		}
		return null;
	}

	public boolean isLeaf(Node<E> node) {
		return !hasLeft(node) && !hasRight(node);
	}

	public int getDepth(Node<E> node) {
		if (node == null) {
			return 0;
		}
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		return left > right ? left + 1 : right + 1; 
	}

	public void printInOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}

	public void printPreorder(Node<E> node) {
		if (node == null) return;
		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	public void printPostorder(Node<E> node) {
		if (node == null) return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}

	public void printByLevel(Node<E> root) {
		Queue<Node<E>> firstQ = new LinkedList<>();
		firstQ.add(root);

		Queue<Queue<Node<E>>> mainQ = new LinkedList<>();
		mainQ.add(firstQ);

		while (!mainQ.isEmpty()) {
			Queue<Node<E>> levelQ = mainQ.remove();
			Queue<Node<E>> nextLevelQ = new LinkedList<>();
			for (Node<E> x : levelQ) {
				System.out.print(x.data + " ");
				if (x.left != null)    nextLevelQ.add(x.left);
				if (x.right != null)   nextLevelQ.add(x.right);
			}
			if (!nextLevelQ.isEmpty()) mainQ.add(nextLevelQ);
			System.out.println();
		}
	}

	public class Node<T> {

		private Node<T> left;
		private Node<T> right;
		private T data;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

}
