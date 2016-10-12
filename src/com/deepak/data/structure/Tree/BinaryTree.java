package com.deepak.data.structure.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.println("Initial Size of Tree => " + tree.size());
		tree.addNode(10);
		System.out.println("Inserted 10");
		System.out.println("Size of tree after insertion => " + tree.size());
		System.out.println("Printing the Tree");
		printByLevel(root);
		System.out.println();
		tree.addNode(7);
		tree.addNode(12);
		tree.addNode(13);
		tree.addNode(8);
		tree.addNode(15);
		tree.addNode(9);
		System.out.println("Size of tree after insertion => " + tree.size());
		System.out.println("Printing the Tree");
		System.out.println();
		printByLevel(root);
		System.out.println();
		System.out.println(getDepth(root));
	}

	static Node root;
	static int size = 0;

	public void addNode(int value) {
		if (size == 0) {
			root = new Node(value);
			size++;
		} else {
			addNode(root, value);
		}
	}
	
	private Node addNode(Node rootNode, int value) {
		if (rootNode == null) {
			return null;
		}
		Node newNode = new Node(value);
		if (newNode.data <= rootNode.data) {
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

	public Node root() {
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

	private int size(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (size(root.left)) + 1 + (size(root.right));
		}
	}

	public boolean isRoot(Node node) {
		if (root == node) {
			return true;
		}
		return false;
	}
	
	public Node findParent(Node node) {
		return findParent(node.data, root, null);
	}

	private Node findParent(int data, Node root, Node parent) {
		if (root == null) {
			return null;
		}
		if (root.data != data) {
			parent = findParent(data, root.left, root);
			if (parent == null) {
				parent = findParent(data, root.right, root); 
			}
		}
		return parent;
	}

	public boolean hasParent(Node node) {
		return findParent(node) != null;
	}

	public boolean hasLeft(Node node) {
		return node.left != null;
	}

	public Node left(Node node) {
		if (hasLeft(node)) {
			return node.left;
		}
		return null;
	}

	public boolean hasRight(Node node) {
		return node.right != null;
	}

	public Node right(Node node) {
		if (hasRight(node)) {
			return node.right;
		}
		return null;
	}
	
	public boolean isLeaf(Node node) {
		return !hasLeft(node) && !hasRight(node);
	}
	
	public static int getDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		return left > right ? left + 1 : right + 1; 
	}
	
	public static void printInOrder(Node node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}
	
	public static void printPreorder(Node node) {
	    if (node == null) return;
	    System.out.print(node.data + " ");
	    printPreorder(node.left);
	    printPreorder(node.right);
	}

	public static void printPostorder(Node node) {
	    if (node == null) return;
	    printPostorder(node.left);
	    printPostorder(node.right);
	    System.out.print(node.data + " ");
	}
	
	public static void printByLevel(Node root) {
	    Queue<Node> firstQ = new LinkedList<>();
	    firstQ.add(root);

	    Queue<Queue<Node>> mainQ = new LinkedList<>();
	    mainQ.add(firstQ);

	    while (!mainQ.isEmpty()) {
	        Queue<Node> levelQ = mainQ.remove();
	        Queue<Node> nextLevelQ = new LinkedList<>();
	        for (Node x : levelQ) {
	            System.out.print(x.data + " ");
	            if (x.left != null)    nextLevelQ.add(x.left);
	            if (x.right != null)   nextLevelQ.add(x.right);
	        }
	        if (!nextLevelQ.isEmpty()) mainQ.add(nextLevelQ);
	        System.out.println();
	    }
	}

	public class Node {

		private Node left;
		private Node right;
		private int data;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
	}

}
