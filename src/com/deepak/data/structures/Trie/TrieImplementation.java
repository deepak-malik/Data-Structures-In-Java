/**
 * Data-Structures-In-Java
 * TrieImplementation.java
 */
package com.deepak.data.structures.Trie;

import java.util.HashMap;

/**
 * Class to hold Trie implementation
 * Not making it generic since keys are usually strings
 *
 * @author Deepak
 */
public class TrieImplementation {

	/**
	 * Root Node
	 */
	private TrieNode root;

	/**
	 * Default Constructor
	 */
	public TrieImplementation() {
		root = new TrieNode();
	}

	/**
	 * Method to insert a word in Trie
	 * 
	 * @param word
	 */
	public void insert(String word) {
		/* Find the children of root node */
		HashMap<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			TrieNode node = null;
			if (children.containsKey(character)) {
				node = children.get(character);
			} else {
				node = new TrieNode(character);
				children.put(character, node);
			}
			children = node.children;
			if (i == word.length() - 1) {
				node.isLeaf = true;
			}
		}
	}

	/**
	 * Method to check if a word in Trie starts with the given prefix
	 * 
	 * @param prefix
	 * @return {@link boolean}
	 */
	public boolean startsWith(String prefix) {
		if (searchNode(prefix) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Method to search TrieNode based on the word
	 * 
	 * @param word
	 * @return {@link TrieNode}
	 */
	public TrieNode searchNode(String word) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode node = null;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			if (children.containsKey(character)) {
				node = children.get(character);
				children = node.children;
			} else {
				return null;
			}
		}
		return node;
	}

	/**
	 * Method to search the given word in the Trie
	 * 
	 * @param word
	 * @return {@link boolean}
	 */
	public boolean searchWord(String word) {
		TrieNode node = searchNode(word);
		if (null != node && node.isLeaf) {
			return true;
		}
		return false;
	}

	/**
	 * Static class TrieNode
	 * 
	 * @author Deepak
	 */
	public static class TrieNode {

		/* Attributes of TrieNode*/
		char c;
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean isLeaf;

		/**
		 * Default Constructor
		 */
		public TrieNode() {}

		/**
		 * Parameterized Constructor
		 * @param c
		 */
		public TrieNode(char c) {
			this.c = c;
		}

	}

}
