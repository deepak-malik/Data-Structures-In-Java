package com.deepak.data.structures.Tree;

/**
 * An AVL tree is another self-balanced binary search tree. 
 * The heights of the two child subtrees of any node differ by at most one; 
 * otherwise, re balancing is done to restore this property. 
 * The AVL tree maintains an extra attribute in each node to balance the height.
 * The heights of two child subtree (left subtree and 
 * right subtree) of any node differ by at most one
 * 
 * @author Deepak
 */
public class AVLTree {

	private AVLTreeNode root;

	public boolean isEmpty() {
		return root == null;
	}

	public void makeEmpty() {
		root = null;
	}

	public void insert(int data) {
		root = insert(data, root);
	}

	private AVLTreeNode insert(int data, AVLTreeNode node) {
		if (node == null) {
			root = new AVLTreeNode(data);
		} else if (data < node.data) {
			node.left = insert(data, node.left);
			if (height(node.left) - height(node.right) == 2) {
				if (data < node.left.data) {
					node = rotateLeft(node);
				} else {
					node = doubleRotateLeft(node);
				}
			}
		} else if (data > node.data) {
			node.right = insert(data, node.right);
			if (height(node.right) - height(node.left) == 2) {
				if (data > node.right.data) {
					node = rotateRight(node);
				} else {
					node = doubleRotateRight(node);
				}
			}
		}
		node.height = max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	private AVLTreeNode rotateLeft(AVLTreeNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	private AVLTreeNode doubleRotateLeft(AVLTreeNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	private AVLTreeNode rotateRight(AVLTreeNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	private AVLTreeNode doubleRotateRight(AVLTreeNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	public int height(AVLTreeNode node) {
		return node == null ? -1 : node.height;
	}

	/**
	 * AVL Tree Node
	 * 
	 * @author Deepak
	 */
	public class AVLTreeNode {

		private AVLTreeNode left;
		private AVLTreeNode right;
		private int data;
		private int height;

		public AVLTreeNode() {
			this.left = null;
			this.right = null;
			this.data = 0;
			this.height = 0;
		}

		public AVLTreeNode(int data) {
			this.left = null;
			this.right = null;
			this.data = data;
			this.height = 0;
		}

	}

}
