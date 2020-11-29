/**
 * Data-Structures-In-Java
 * DoublyLinkedListTest.java
 */
package com.deepak.data.structures.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Doubly linked list
 * 
 * @author Deepak
 */
public class DoublyLinkedListTest {

	/**
	 * Test case to check insertion at head of linked list
	 */
	@Test
	public void testInsertionAtHead() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		Assert.assertTrue(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		Assert.assertFalse(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 1);
		Assert.assertEquals(doublyList.searchByIndex(0).item, "Tom");
		doublyList.insertAtHead("Alex");
		Assert.assertTrue(doublyList.size() == 2);
		Assert.assertEquals(doublyList.searchByIndex(0).item, "Alex");
	}

	/**
	 * Test case to check insertion at tail of linked list
	 */
	@Test
	public void testInsertionAtTail() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		Assert.assertTrue(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		Assert.assertFalse(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 1);
		Assert.assertEquals(doublyList.searchByIndex(0).item, "Tom");
		doublyList.insertAtTail("Alex");
		Assert.assertTrue(doublyList.size() == 2);
		Assert.assertEquals(doublyList.searchByIndex(0).item, "Tom");
		Assert.assertEquals(doublyList.searchByIndex(1).item, "Alex"); 
	}

	/**
	 * Test case to check insertion at a given position of linked list
	 */
	@Test
	public void testInsertionAtPosition() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		Assert.assertTrue(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		Assert.assertFalse(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 3);
		Assert.assertEquals(doublyList.searchByIndex(0).item, "Maria");
		Assert.assertEquals(doublyList.searchByValue("Maria").item, "Maria");
		doublyList.insertAtPosition("Steve", 2);
		Assert.assertTrue(doublyList.size() == 4);
		Assert.assertEquals(doublyList.searchByIndex(1).item, "Alex");
		Assert.assertEquals(doublyList.searchByIndex(2).item, "Tom");
		Assert.assertEquals(doublyList.searchByIndex(3).item, "Steve");
	}

	/**
	 * Test case to check deletion from head
	 */
	@Test
	public void testDeleteFromHead() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		Assert.assertTrue(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		Assert.assertFalse(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 3);
		Assert.assertEquals(doublyList.searchByIndex(0).item, "Maria");
		doublyList.deleteFromHead();
		Assert.assertTrue(doublyList.size() == 2);
		Assert.assertEquals(doublyList.searchByIndex(0).item, "Alex");
	}

	/**
	 * Test case to check deletion from tail
	 */
	@Test
	public void testDeleteFromTail() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		Assert.assertTrue(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		Assert.assertFalse(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 3);
		Assert.assertEquals(doublyList.searchByIndex(2).item, "Tom");
		doublyList.deleteFromTail();
		Assert.assertTrue(doublyList.size() == 2);
		Assert.assertEquals(doublyList.searchByIndex(0).item, "Maria");
		Assert.assertEquals(doublyList.searchByIndex(1).item, "Alex");
	}

	/**
	 * Test case to check deletion from position
	 */
	@Test
	public void testDeleteFromPosition() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		Assert.assertTrue(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		Assert.assertFalse(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 3);
		Assert.assertEquals(doublyList.searchByIndex(2).item, "Tom");
		doublyList.deleteFromPosition(1);
		Assert.assertTrue(doublyList.size() == 2);
		Assert.assertEquals(doublyList.searchByIndex(1).item, "Tom");
	}

	/**
	 * Test case to convert a linked list to Array
	 */
	@Test
	public void testConvertToArray() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		Assert.assertTrue(doublyList.isEmpty());
		Assert.assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		Assert.assertTrue(doublyList.size() == 3);
		Object[] array = doublyList.toArray();
		Assert.assertTrue(array.length == 3);
		Assert.assertEquals(array[0], "Maria");
		Assert.assertEquals(array[1], "Alex");
		Assert.assertEquals(array[2], "Tom");
	}

}
