/**
 * Data-Structures-In-Java
 * TrieTest.java
 */
package com.deepak.data.structures.Trie;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases to test Trie Data Structure
 * 
 * @author Deepak
 */
public class TrieTest {

	/**
	 * Test case to test all the Trie functionalities
	 */
	@Test
	public void testTrieFunctionality() {
		TrieImplementation trie = new TrieImplementation();
		trie.insert("Zebra");
		trie.insert("Cat");
		trie.insert("Dog");
		Assert.assertTrue(trie.startsWith("D"));
		Assert.assertNotNull(trie.searchNode("Cat"));
		Assert.assertNotNull(trie.searchNode("Dog"));
		Assert.assertTrue(trie.startsWith("Zebra"));
		Assert.assertFalse(trie.startsWith("M"));
	}

}
